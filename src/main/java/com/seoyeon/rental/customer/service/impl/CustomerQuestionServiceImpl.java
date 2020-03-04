package com.seoyeon.rental.customer.service.impl;

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
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.JsonObject;
import com.seoyeon.rental.HomeController;
import com.seoyeon.rental.common.CommonUtils;
import com.seoyeon.rental.common.PageInfo;
import com.seoyeon.rental.customer.dao.CustomerQuestionDao;
import com.seoyeon.rental.customer.service.CustomerQuestionService;

/**
 * @author dhkim
 *
 */
@Service
public class CustomerQuestionServiceImpl implements CustomerQuestionService{

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private CustomerQuestionDao cqd;
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public void imageUpload(HttpServletRequest request, HttpServletResponse response, MultipartFile upload) throws IOException {
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
						String uploadPath = request.getSession().getServletContext().getRealPath("/resources/uploadFiles/customer/question");
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
                        String fileUrl = request.getContextPath() + "/resources/uploadFiles/customer/question/" + fileName;
                        
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
	public int insertCustomerQuestionBoard(Map<String, Object> param) {
		return cqd.insertCustomerQuestionBoard(sqlSession, param);
	}

	@Override
	public List<Map<String, Object>> selectCustomerQuestionBoardList() {
		return cqd.selectCustomerQuestionBoardList(sqlSession);
	}

	@Override
	public Map<String, Object> selectCustomerQuestionBoard(String postId) {
		return cqd.selectCustomerQuestionBoard(sqlSession, postId);
	}


}
