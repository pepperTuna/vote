/*package com.vote.controller;

import java.io.File;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class UploadController {

	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);

	@Resource(name = "uploadPath")
	private String uploadPath;

	@RequestMapping(value = "/uploadForm", method = RequestMethod.GET)
	public void uploadForm() {
	}

	@RequestMapping(value = "/uploadForm", method = RequestMethod.POST)
	public String uploadForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

		int questionLen = multipartRequest.getParameter("vote_length")!=null ? Integer.parseInt(multipartRequest.getParameter("vote_length")) : 0;
		String choiceLen = multipartRequest.getParameter("choice_length").toString();
		String[] choice = choiceLen.split("\\|");

		for (int i = 0; i < questionLen; i++) {

			for (int j = 0; j < Integer.parseInt(choice[i]); j++) {

				String choiceFile = "choice-file-" + (i+1) + "-" + (j+1);
				MultipartFile file = multipartRequest.getFile(choiceFile);

				if (file != null) {
					
					if (!file.isEmpty()) {

						logger.info("originalName: " + file.getOriginalFilename());
						logger.info("size: " + file.getSize());
						logger.info("contentType: " + file.getContentType());
						
						//uploadFile(file.getOriginalFilename(), file.getBytes());
						uploadFile(choiceFile + "_" + file.getOriginalFilename() ,file.getBytes());
						
						//db
					}
				}
			}
		}
		return "uploadForm"; // uploadForm.jsp
	}

	private void uploadFile(String originalName, byte[] fileData) throws Exception {

		UUID uid = UUID.randomUUID();

		String savedName = uid.toString() + "_" + originalName;

		File target = new File(uploadPath, savedName);

		FileCopyUtils.copy(fileData, target);

	}
}

/*
  //uploadForm.jsp
  
	@RequestMapping(value = "/uploadForm", method = RequestMethod.POST)
	//public String uploadForm(MultipartFile file, Model model) throws Exception {
	public String uploadForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
  
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request;
		
		for(int i = 0; i < 3; i++) {

			String choiceFile = "file" + (i + 1);
			MultipartFile file = multipartRequest.getFile(choiceFile);
			
			logger.info("originalName: " + file.getOriginalFilename());
			logger.info("size: " + file.getSize());
			logger.info("contentType: " + file.getContentType());

			uploadFile(file.getOriginalFilename(), file.getBytes());
		}

		return "uploadResult";
	}
  
 */