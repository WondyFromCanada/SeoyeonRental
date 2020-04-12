package com.seoyeon.rental.customer.service.impl;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.seoyeon.rental.HomeController;
import com.seoyeon.rental.common.CommonUtils;
import com.seoyeon.rental.customer.dao.CustomerMaterialDao;
import com.seoyeon.rental.customer.service.CustomerMaterialService;

/**
 * @author dhkim
 *
 */
@Service
public class CustomerMaterialServiceImpl implements CustomerMaterialService{

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private CustomerMaterialDao cmd;
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public int insertCustomerMaterialBoard(
			Map<String, Object> param, 
			MultipartFile file, 
			HttpServletRequest request) throws Exception {
		//파일 업로드의 기본
		//1. 파일이름을 사이트 규약에 맞는 랜덤스트링으로변경(내 맴대로 CommonUtils.getRandomString())
		//2. transferTo 메소드로 지정된 경로에 파일 저장 spring은 WEB-INf 하위 경로에 있는 파일에
		//	직접 접근이 불가하므로 ***-servlet.xml 에 매핑한 
		//	<resources mapping="/resources/**" location="/resources/" />
		//	하위에 저장을 해야 접근이 가능하다 
		//3. 원본파일이름, 변경된이름, 확장자, 파일 저장경로 정보 디비에 저장
		//	그래야 나중에 불러올 수 있다.
		String root = request.getSession().getServletContext().getRealPath("resources");
		
		String filePath = root + "\\uploadFiles\\customer\\material";
		String originFileName = file.getOriginalFilename();
		String ext = originFileName.substring(originFileName.lastIndexOf("."));
		String changeFileName = CommonUtils.getRandomString();
		
		try {
			//지정한 경로에 파일저장
			file.transferTo(new File(filePath + "\\" + changeFileName + ext));
			
			//Attachment 테이블에 저장할 데이터 map
			Map<String, Object> attMap = new HashMap<String, Object> ();
			attMap.put("filePath", filePath);
			attMap.put("originNm", originFileName);
			attMap.put("changeNm", changeFileName);
			attMap.put("ext", ext);
			//자료실 게시판에 insert
			int matResult = cmd.insertCustomerMaterial(sqlSession, param);
			//Attachment 테이블에 insert
			int attResult = cmd.insertAttachment(sqlSession, attMap);
			
			if(matResult + attResult > 1) {
				return matResult + attResult;
			}
			
			
		} catch (Exception e) {
			new File(filePath + "\\" + changeFileName + ext).delete();
			throw new Exception("파일등록 에러");
		}
		
		return 0;
	}

	@Override
	public List<Map<String, Object>> selectCustomerMaterialBoardList() {
		return cmd.selectCustomerMaterialBoardList(sqlSession);
	}

	@Override
	public Map<String, Object> selectCustomerMaterialBoard(String postId) {
		return cmd.selectCustomerMaterialBoard(sqlSession, postId);
	}

	@Override
	public List<Map<String, Object>> getGridColInf(Map<String, Object> param) {
		return cmd.getGridColInf(sqlSession, param);
	}
	
}
