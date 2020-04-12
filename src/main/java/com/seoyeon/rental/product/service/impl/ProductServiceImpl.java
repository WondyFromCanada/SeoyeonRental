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
	private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
	
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

	@Override
	public Map<String, Object> selectProductMfpDetail(String prodId) {
		return pd.selectProductMfpDetail(sqlSession, prodId);
	}

	@Override
	public Map<String, Object> selectProductExpdDetail(String prodId) {
		return pd.selectProductExpdDetail(sqlSession, prodId);
	}

	@Override
	public int deleteProductMfp(HttpServletRequest request, String prodId) {
		
		Map<String, Object> mfpMap = pd.selectProductMfpDetail(sqlSession, prodId);
		
		try {
			String delFilePath = request.getSession().getServletContext().getRealPath("resources\\uploadFiles\\product\\mfp\\" + mfpMap.get("CHANGE_NM") + mfpMap.get("EXT"));
			File delFile = new File(delFilePath);
			logger.info("파일 경로 : " + delFile);

			if(delFile.exists()) delFile.delete();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		//PROD_MFP 테이블에서 delete
		int mfpResult = pd.deleteProductMfp(sqlSession, prodId);
		//Attachment 테이블에서 delete
		int attResult = pd.deleteProductMfpAttachment(sqlSession, prodId);
		
		if(mfpResult + attResult > 1) {
			return mfpResult + attResult;
		}
		
		return 0;
	}

	@Override
	public int deleteProductExpd(HttpServletRequest request, String prodId) {
		Map<String, Object> expdMap = pd.selectProductExpdDetail(sqlSession, prodId);
		
		try {
			String delFilePath = request.getSession().getServletContext().getRealPath("resources\\uploadFiles\\product\\expd\\" + expdMap.get("CHANGE_NM") + expdMap.get("EXT"));
			File delFile = new File(delFilePath);
			logger.info("파일 경로 : " + delFile);

			if(delFile.exists()) delFile.delete();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		//PROD_EXPD 테이블에서 delete
		int expdResult = pd.deleteProductExpd(sqlSession, prodId);
		//Attachment 테이블에서 delete
		int attResult = pd.deleteProductExpdAttachment(sqlSession, prodId);

		if(expdResult + attResult > 1) {
			return expdResult + attResult;
		}

		return 0;
	}

	@Transactional
	@Override
	public int updateProductMfp(Map<String, Object> param, MultipartFile prodMfpImgDetail, HttpServletRequest request) throws Exception {
		int attResult = 0;
		
		if(!prodMfpImgDetail.isEmpty()) {
			String prodId = (String) param.get("mfpProdId");
			Map<String, Object> mfpMap = pd.selectProductMfpDetail(sqlSession, prodId);
			
			String delFilePath = request.getSession().getServletContext().getRealPath("resources\\uploadFiles\\product\\mfp\\" + mfpMap.get("CHANGE_NM") + mfpMap.get("EXT"));
			File delFile = new File(delFilePath);
			logger.info("파일 경로 : " + delFile);
			if(delFile.exists()) delFile.delete();
			
			String root = request.getSession().getServletContext().getRealPath("resources");
			
			String filePath = root + "\\uploadFiles\\product\\mfp";
			String originFileName = prodMfpImgDetail.getOriginalFilename();
			String ext = originFileName.substring(originFileName.lastIndexOf("."));
			String changeFileName = CommonUtils.getRandomString();
			
			try {
				//지정한 경로에 파일저장
				prodMfpImgDetail.transferTo(new File(filePath + "\\" + changeFileName + ext));
				
				//Attachment 테이블에 저장할 데이터 map
				Map<String, Object> attMap = new HashMap<String, Object> ();
				attMap.put("filePath", filePath);
				attMap.put("originNm", originFileName);
				attMap.put("changeNm", changeFileName);
				attMap.put("ext", ext);
				attMap.put("mfpProdId", prodId);
				
				//Attachment 테이블에 update
				attResult = pd.updateProductMfpAttachment(sqlSession, attMap);
				
			} catch (Exception e) {
				new File(filePath + "\\" + changeFileName + ext).delete();
				throw new Exception("파일등록 에러");
			}
		}
		
		//PROD_MFP 테이블에 update
		int mfpResult = pd.updateProductMfp(sqlSession, param);
		
		return mfpResult + attResult;
	}

	@Transactional
	@Override
	public int updateProductExpd(Map<String, Object> param, MultipartFile prodExpdImgDetail, HttpServletRequest request) throws Exception {
		int attResult = 0;
		
		if(!prodExpdImgDetail.isEmpty()) {
			String prodId = (String) param.get("expdProdId");
			Map<String, Object> expdMap = pd.selectProductExpdDetail(sqlSession, prodId);
			
			String delFilePath = request.getSession().getServletContext().getRealPath("resources\\uploadFiles\\product\\expd\\" + expdMap.get("CHANGE_NM") + expdMap.get("EXT"));
			File delFile = new File(delFilePath);
			logger.info("파일 경로 : " + delFile);
			if(delFile.exists()) delFile.delete();
			
			String root = request.getSession().getServletContext().getRealPath("resources");
			
			String filePath = root + "\\uploadFiles\\product\\expd";
			String originFileName = prodExpdImgDetail.getOriginalFilename();
			String ext = originFileName.substring(originFileName.lastIndexOf("."));
			String changeFileName = CommonUtils.getRandomString();
			
			try {
				//지정한 경로에 파일저장
				prodExpdImgDetail.transferTo(new File(filePath + "\\" + changeFileName + ext));
				
				//Attachment 테이블에 저장할 데이터 map
				Map<String, Object> attMap = new HashMap<String, Object> ();
				attMap.put("filePath", filePath);
				attMap.put("originNm", originFileName);
				attMap.put("changeNm", changeFileName);
				attMap.put("ext", ext);
				attMap.put("expdProdId", prodId);
				
				//Attachment 테이블에 update
				attResult = pd.updateProductExpdAttachment(sqlSession, attMap);
				
			} catch (Exception e) {
				new File(filePath + "\\" + changeFileName + ext).delete();
				throw new Exception("파일등록 에러");
			}
		}
		
		//PROD_EXPD 테이블에 update
		int expdResult = pd.updateProductExpd(sqlSession, param);

		return expdResult + attResult;
	}
}