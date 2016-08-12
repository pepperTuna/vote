package com.vote.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vote.domain.VoteQuestionVO;
import com.vote.domain.VoteVO;
import com.vote.service.VoteQuestionService;
import com.vote.service.VoteService;

@Controller
@RequestMapping("/vote")
public class VoteController {
   
   private static final Logger logger = LoggerFactory.getLogger(VoteController.class);
   
   @Resource(name = "uploadPath")
   private String uploadPath;
   
   @Inject
   private VoteService voteService;
   
   @Inject
   private VoteQuestionService voteQuestionService;

   @RequestMapping(method = RequestMethod.GET)
   public String home(Locale locale, Model model) {
	   
     logger.info("Welcome home! The client locale is {}.", locale);

     Date date = new Date();
     DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

     String formattedDate = dateFormat.format(date);

     model.addAttribute("serverTime", formattedDate);

     return "home";
   }
   
   
   @RequestMapping(value = "/readVote", method = RequestMethod.GET)
   public void readVote(@RequestParam("vIdx") int vIdx, Model model) throws Exception {
	   
	   model.addAttribute(voteService.readVote(vIdx));
	   model.addAttribute("list", voteQuestionService.readQuestion(vIdx));
   }
   
   @RequestMapping(value = "/listVote", method = RequestMethod.GET)
   public void listVote(Model model) throws Exception {
	   model.addAttribute("list", voteService.listVote());
   }
   
   @RequestMapping(value = "/createVote", method = RequestMethod.GET)
   public String createVote() {
	   return "createVote";
   }
   
   @RequestMapping(value = "/createVote", method = RequestMethod.POST)
   public String createVote(HttpServletRequest request, HttpServletResponse response) throws Exception {
	   request.setCharacterEncoding("UTF-8");
	   
	   int idx = voteService.createVote(request);
	   voteQuestionService.createQuestion(request, uploadPath, idx);

	   return "listVote";
   }

   @RequestMapping(value = "/updateVote", method = RequestMethod.GET)
   public void updateVote(@RequestParam("vIdx") int vIdx, Model model) throws Exception {
	   
	   model.addAttribute(voteService.readVote(vIdx));
	   model.addAttribute("list", voteQuestionService.readQuestion(vIdx));
   }

   /*
   @RequestMapping(value = "/updateVote", method = RequestMethod.POST)
   
   public String updateVote(VoteVO vo, RedirectAttributes rttr) throws Exception {
¤±¤¤¤··ý¤·³Ç
	   rttr.addFlashAttribute("msg", "SUCCESS");

	   return "redirect:/listVote";
   }
   */
   @RequestMapping(value = "/deleteVote", method = RequestMethod.POST)
   public String deleteVote(@RequestParam("vIdx") int vIdx, RedirectAttributes rttr) throws Exception {
	   voteService.deleteVote(vIdx);
	   rttr.addFlashAttribute("msg", "SUCCESS");

	   return "redirect:/listVote";
   }
   
   @RequestMapping(value = "/snsLogin", method = RequestMethod.GET)
   public String snsLogin() {   
      return "snsLogin";
   }
   
   @RequestMapping(value = "/user/login", method = RequestMethod.POST)
   public void userLogin(HttpServletRequest request, Model model) throws Exception {
      
      String id = request.getParameter("sns_id");
      String type = request.getParameter("sns_type");
      
      System.out.println(id + " : " + type);
   }
}