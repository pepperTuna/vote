package com.vote.controller;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.vote.service.VoteService;
import com.vote.service.VoteQuestionService;

@Controller
@RequestMapping("/*")
public class VoteController {
   
   private static final Logger logger = LoggerFactory.getLogger(VoteController.class);
   
   @Resource(name = "uploadPath")
   private String uploadPath;
   
   @Inject
   private VoteService voteService;
   
   @Inject
   private VoteQuestionService voteQuestionService;

   @RequestMapping(value = "/readVote", method = RequestMethod.GET)
   public String readVote(@RequestParam("vIdx") int vIdx, Model model) throws Exception {
	   model.addAttribute(voteService.readVote(vIdx));
	   model.addAttribute("list", voteQuestionService.readQuestion(vIdx));
	   
	   return "voteView";
   }
   
   @RequestMapping(value = "/listVote", method = RequestMethod.GET)
   public void listVote(Model model) throws Exception {
      model.addAttribute("list", voteService.listVote());
   }
   
   @RequestMapping(value = "/createVote", method = RequestMethod.POST)
   public String createVote(HttpServletRequest request, HttpServletResponse response) throws Exception {
      
      voteService.createVote(request, uploadPath);
      
      return "listVote";
   }
}