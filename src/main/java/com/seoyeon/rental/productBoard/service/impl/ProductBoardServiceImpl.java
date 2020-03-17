/**
 * 
 */
package com.seoyeon.rental.productBoard.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.JsonObject;
import com.seoyeon.rental.common.CommonUtils;
import com.seoyeon.rental.productBoard.controller.ProductBoardController;
import com.seoyeon.rental.productBoard.dao.ProductBoardDao;
import com.seoyeon.rental.productBoard.service.ProductBoardService;

/**
 * @author dhkim
 *
 */

@Service
public class ProductBoardServiceImpl implements ProductBoardService{

	private static final Logger logger = LoggerFactory.getLogger(ProductBoardServiceImpl.class);
	
	@Autowired
	private ProductBoardDao pbd;
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public void imageUpload(HttpServletRequest request, HttpServletResponse response, MultipartFile upload) throws Exception {
		JsonObject json = new JsonObject();
		PrintWriter printWriter = null;
		OutputStream out = null;
		MultipartFile file = upload;
		//null체크
		if(file != null){
			//경로에 공백있는지 체크
			if(file.getSize() > 0 && StringUtils.isNotBlank(file.getName())){
				//이미지파일인 경우만
				if(file.getContentType().toLowerCase().startsWith("image/")){
					try{
						//fileName: upload - ckeditor는 무조건 uplaod라는 이름으로 받아야함(MultipartFile upload)
						String fileName = file.getName();
						//file 데이터를 바이트단위로 배열에 삽입
						byte[] bytes = file.getBytes();
						//파일 업로드 경로 설정 로컬인경우 127.0.0.1:8001/rental  + /resources/uploadFiles/customer/question
						String uploadPath = request.getSession().getServletContext().getRealPath("/resources/uploadFiles/productBoard/rental/mfp");
						//파일 객체 생성
						File uploadFile = new File(uploadPath);
						//경로가 비어있으면 디렉토리 생성
						if(!uploadFile.exists()){
							uploadFile.mkdirs();
						}
						//랜덤스트링으로 파일이름 변경
						fileName = CommonUtils.getRandomString();
						//경로에 파일이름 추가
						uploadPath = uploadPath + "/" + fileName;
						//아웃풋 스트림으로 파일전송
						out = new FileOutputStream(new File(uploadPath));
                        out.write(bytes);
                        
                        //여기서부터는 화면단에 내려줄 내용
                        printWriter = response.getWriter();
                        response.setContentType("text/html");
                        
                        //이 파일을 읽을때 127.0.0.1:8001/rental  + /resources/uploadFiles/customer/question 경로로 접근하라고 알려줌
                        //resources에 저장해야 action-servlet에 있는 
                        //<resources mapping="/resources/**" location="/resources/" /> 를 타고 접근할 수 있음
                        //WEB-INF 하위에 있는 리소스는 직접 접근할 수 없기 때문에 경로를 꼭 resources 하위로 매핑해줘야함
                        String fileUrl = request.getContextPath() + "/resources/uploadFiles/productBoard/rental/mfp/" + fileName;
                        
                        //파일업로드 결과를 GSON 으로 내려줌(이름은 json인데 GSON 라이브러리에 있는 객체임)
                        //pom.xml에 GSON 라이브러리 추가했음
                        //1은 성공, 0은 실패
                        json.addProperty("uploaded", 1);
                        //파일명
                        json.addProperty("fileName", fileName);
                        //웹에서 이 파일을 읽을때 접근할 경로
                        json.addProperty("url", fileUrl);
                        
                        //printWriter로 웹에 json 내려줌
                        printWriter.println(json);
                    }catch(IOException e){
                        e.printStackTrace();
                    }finally{
                        if(out != null){
                            out.close();
                        }
                        if(printWriter != null){
                            printWriter.close();
                        }		
					}
				}
			}
		}
		
	}
	
	@Override
	public int insertProductBoardRentalMfp(Map<String, Object> param) {
		return pbd.insertProductBoardRentalMfp(sqlSession, param);
	}

	@Override
	public List<Map<String, Object>> selectProductBoardRentalMfp() {
		return pbd.selectProductBoardRentalMfp(sqlSession);
	}

	@Override
	public Map<String, Object> selectProductBoardRentalMfpDetail(String postId) {
		return pbd.selectProductBoardRentalMfpDetail(sqlSession, postId);
	}

	@Override
	public int updateProductBoardRentalMfp(Map<String, Object> param) {
		return pbd.updateProductBoardRentalMfp(sqlSession, param);
	}

	@Override
	public int deleteProductBoardRentalMfp(Map<String, Object> param, HttpServletRequest request) {
		String [] srcList = (param.get("srcList") + "").split(", ");
		
		if(srcList.length > 0) {
			for(int i = 0; i < srcList.length; i++) {
				srcList[i] = srcList[i].replace("[", "").replace("]", "");
				String filePath = request.getSession().getServletContext().getRealPath(srcList[i]);
				File delFile = new File(filePath);
				if(delFile.exists()) {
					delFile.delete();
				}
			}
		}
		
		String postId = param.get("postId") + "";
		return pbd.deleteProductBoardRentalMfp(sqlSession, postId);
	}

}

