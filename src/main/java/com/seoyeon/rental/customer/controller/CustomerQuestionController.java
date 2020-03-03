package com.seoyeon.rental.customer.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import net.sf.json.JSONObject;

@RestController
public class CustomerQuestionController {

	@PostMapping(value = "/customer/question/image")
	public String insertCustomerQuestionBoard(HttpServletRequest req, HttpServletResponse resp, 
            MultipartHttpServletRequest multiFile) throws Exception {
	JSONObject json = new JSONObject();
	PrintWriter printWriter = null;
	OutputStream out = null;
	MultipartFile file = multiFile.getFile("upload");
	if(file != null){
		if(file.getSize() > 0 && StringUtils.isNotBlank(file.getName())){
			if(file.getContentType().toLowerCase().startsWith("image/")){
				try{
					String fileName = file.getName();
					byte[] bytes = file.getBytes();
					String uploadPath = req.getSession().getServletContext().getRealPath("/img");


					File uploadFile = new File(uploadPath);
					if(!uploadFile.exists()){
						uploadFile.mkdirs();
					}
					fileName = UUID.randomUUID().toString();
					uploadPath = uploadPath + "/" + fileName;
					out = new FileOutputStream(new File(uploadPath));
                   out.write(bytes);
                   
                   printWriter = resp.getWriter();
                   resp.setContentType("text/html");
                   String fileUrl = req.getContextPath() + "/img/" + fileName;
                   
                   // json 데이터로 등록
                   // {"uploaded" : 1, "fileName" : "test.jpg", "url" : "/img/test.jpg"}
                   // 이런 형태로 리턴이 나가야함.
                   json.put("uploaded", 1);
                   json.put("fileName", fileName);
                   json.put("url", fileUrl);
                   
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
	return null;
}


}
