package com.vote.controller;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.vote.service.QuestionService;

@Controller
@RequestMapping("/*")
public class VoteController {
   
   private static final Logger logger = LoggerFactory.getLogger(VoteController.class);
   
   @Resource(name = "uploadPath")
   private String uploadPath;
   
   @Inject
   private QuestionService service;

   @RequestMapping(value = "/uploadForm", method = RequestMethod.GET)
   public void uploadForm() {
   }

   @RequestMapping(value = "/uploadForm", method = RequestMethod.POST)
   public String uploadForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
      
      MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

      service.uploadForm(multipartRequest, uploadPath);
      
      return "uploadForm"; // uploadForm.jsp
   }
}