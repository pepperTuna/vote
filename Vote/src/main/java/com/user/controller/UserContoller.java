package com.user.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.user.domain.UserVO;
import com.user.service.UserService;

@Controller
public class UserContoller {
   
   @Inject
   UserService userService;
//   @RequestMapping("/login")
//   public int joinUser(UserVO uservo) {
//   
//      return userService.userJoin(uservo);
//   }
   
   @RequestMapping(value = "/snsLogin", method = RequestMethod.GET)
   public String snsLogin(HttpServletRequest request) {
      
      return "snsLogin";
   }
   
   @RequestMapping(value = "/snsLogin", method = RequestMethod.POST)
   public void userLogin(HttpServletRequest request, UserVO uservo, RedirectAttributes rttr, Model model) throws Exception {

      System.out.println(uservo);
      
      UserVO uvo = null;
      //그냥 로그인
      if(uservo.getSnstype().equals("0"))
      {
         uvo = userService.login(uservo);
         
         if (uvo == null)
         {
            System.out.println("실패");
            rttr.addFlashAttribute("MSG", "fail");
            return;
            
         }

         model.addAttribute("userVO", uvo);
         
      }
      //SNS로 로그인
      else
      {
         if(userService.checkRegisteredUser(uservo) == 0) {
            userService.joinSnsUser(uservo);
         }
         
         model.addAttribute("userVO", uvo);
      } 
      
   }
   
   @RequestMapping("/join")
   public String userJoin(){
      return "/userJoin";
   }
   
   @RequestMapping(value="/duplCheck", method= RequestMethod.POST)
   @ResponseBody
   public int duplCheck(UserVO uservo){
      return userService.duplCheck(uservo);
   }
   
   @RequestMapping(value="addUser", method = RequestMethod.POST)
   @ResponseBody
   public int userJoin(UserVO uservo) throws Exception{
//      uservo.setUsername(URLDecoder.decode(uservo.getUsername(),"UTF-8"));
      System.out.println("이름 : "+uservo.getUsername());
      return userService.joinUser(uservo);
   }
}