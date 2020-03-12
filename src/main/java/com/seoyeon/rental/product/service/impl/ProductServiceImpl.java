package com.seoyeon.rental.product.service.impl;

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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.seoyeon.rental.HomeController;
import com.seoyeon.rental.common.CommonUtils;
import com.seoyeon.rental.product.dao.ProductDao;
import com.seoyeon.rental.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private ProductDao pd;
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Transactional
	@Override
	public int insertProductMfp(Map<String, Object> param, MultipartFile prodMfpImg, HttpServletRequest request) throws Exception {
		String root = request.getSession().getServletContext().getRealPath("resources");
		
		String filePath = root + "\\uploadFiles\\product\\mfp";
		String originFileName = prodMfpImg.getOriginalFilename();
		String ext = originFileName.substring(originFileName.lastIndexOf("."));
		String changeFileName = CommonUtils.getRandomString();
		
		try {
			//지정한 경로에 파일저장
			prodMfpImg.transferTo(new File(filePath + "\\" + changeFileName + ext));
			
			//Attachment 테이블에 저장할 데이터 map
			Map<String, Object> attMap = new HashMap<String, Object> ();
			attMap.put("filePath", filePath);
			attMap.put("originNm", originFileName);
			attMap.put("changeNm", changeFileName);
			attMap.put("ext", ext);
			//PROD_MFP 테이블에 insert
			int mfpResult = pd.insertProductMfp(sqlSession, param);
			//Attachment 테이블에 insert
			int attResult = pd.insertProductMfpAttachment(sqlSession, attMap);
			
			if(mfpResult + attResult > 1) {
				return mfpResult + attResult;
			}
			
			
		} catch (Exception e) {
			new File(filePath + "\\" + changeFileName + ext).delete();
			throw new Exception("파일등록 에러");
		}
		
		return 0;
	}
	
	@Transactional
	@Override
	public int insertProductExpd(Map<String, Object> param, MultipartFile prodExpdImg, HttpServletRequest request) throws Exception {
		String root = request.getSession().getServletContext().getRealPath("resources");
		
		String filePath = root + "\\uploadFiles\\product\\expd";
		String originFileName = prodExpdImg.getOriginalFilename();
		String ext = originFileName.substring(originFileName.lastIndexOf("."));
		String changeFileName = CommonUtils.getRandomString();
		
		try {
			//지정한 경로에 파일저장
			prodExpdImg.transferTo(new File(filePath + "\\" + changeFileName + ext));
			
			//Attachment 테이블에 저장할 데이터 map
			Map<String, Object> attMap = new HashMap<String, Object> ();
			attMap.put("filePath", filePath);
			attMap.put("originNm", originFileName);
			attMap.put("changeNm", changeFileName);
			attMap.put("ext", ext);
			//PROD_EXPD 테이블에 insert
			int expdResult = pd.insertProductExpd(sqlSession, param);
			//Attachment 테이블에 insert
			int attResult = pd.insertProductExpdAttachment(sqlSession, attMap);
			
			if(expdResult + attResult > 1) {
				return expdResult + attResult;
			}
			
			
		} catch (Exception e) {
			new File(filePath + "\\" + changeFileName + ext).delete();
			throw new Exception("파일등록 에러");
		}
		
		return 0;
	}

	@Override
	public List<Map<String, Object>> selectProductMfpList() {
		return pd.selectProductMfpList(sqlSession);
	}

	@Override
	public List<Map<String, Object>> selectProductExpdList() {
		return pd.selectProductExpdList(sqlSession);
	}

	@Override
	public int selectProductMfpListCount() {
		return pd.selectProductMfpListCount(sqlSession);
	}

	@Override
	public int selectProductExpdListCount() {
		return pd.selectProductExpdListCount(sqlSession);
	}

}
