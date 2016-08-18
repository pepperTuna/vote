package com.user.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.user.domain.UserVO;
import com.user.service.UserService;

@Controller
public class UserContoller {
	
	@Inject
	UserService userService;
	
//	@RequestMapping("/login")
//	public int joinUser(UserVO uservo) {
//	
//		return userService.userJoin(uservo);
//	}
	
	@RequestMapping(value = "/snsLogin", method = RequestMethod.GET)
	public String snsLogin() {
		return "snsLogin";
	}
	
	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	public void userLogin(HttpServletRequest request, UserVO uservo, Model model) throws Exception {
//		System.out.println(userService.checkRegisterdUser(uservo));
//		if(userService.checkRegisteredUser(uservo)==0){
//			userService.joinSnsUser(uservo);
//		}
		request.setCharacterEncoding("UTF-8");
		String test = request.getParameter("username");
		test = new String(test.getBytes("8859_1"),"UTF-8"); // getBytes("8859_1") 
		System.out.println("ID : "+request.getParameter("snsid")+"\n 이름: "+request.getParameter("username"));
		System.out.println(test);
		System.out.println("ID : "+uservo.getSnsid()+"\n 이름: "+uservo.getUsername());
		
		
		String word = request.getParameter("username");
		System.out.println("utf-8(1) : " + new String(word.getBytes("utf-8"), "euc-kr"));
		System.out.println("utf-8(2) : " + new String(word.getBytes("utf-8"), "ksc5601"));
		System.out.println("utf-8(3) : " + new String(word.getBytes("utf-8"), "x-windows-949"));
		System.out.println("utf-8(4) : " + new String(word.getBytes("utf-8"), "iso-8859-1"));
		
		System.out.println("iso-8859-1(1) : " + new String(word.getBytes("iso-8859-1"), "euc-kr"));
		System.out.println("iso-8859-1(2) : " + new String(word.getBytes("iso-8859-1"), "ksc5601"));
		System.out.println("iso-8859-1(3) : " + new String(word.getBytes("iso-8859-1"), "x-windows-949"));
		System.out.println("iso-8859-1(4) : " + new String(word.getBytes("iso-8859-1"), "utf-8"));
		
		System.out.println("euc-kr(1) : " + new String(word.getBytes("euc-kr"), "ksc5601"));
		System.out.println("euc-kr(2) : " + new String(word.getBytes("euc-kr"), "utf-8"));
		System.out.println("euc-kr(3) : " + new String(word.getBytes("euc-kr"), "x-windows-949"));
		System.out.println("euc-kr(4) : " + new String(word.getBytes("euc-kr"), "iso-8859-1"));
		
		System.out.println("ksc5601(1) : " + new String(word.getBytes("ksc5601"), "euc-kr"));
		System.out.println("ksc5601(2) : " + new String(word.getBytes("ksc5601"), "utf-8"));
		System.out.println("ksc5601(3) : " + new String(word.getBytes("ksc5601"), "x-windows-949"));
		System.out.println("ksc5601(4) : " + new String(word.getBytes("ksc5601"), "iso-8859-1"));
		
		System.out.println("x-windows-949(1) : " + new String(word.getBytes("x-windows-949"), "euc-kr"));
		System.out.println("x-windows-949(2) : " + new String(word.getBytes("x-windows-949"), "utf-8"));
		System.out.println("x-windows-949(3) : " + new String(word.getBytes("x-windows-949"), "ksc5601"));
		System.out.println("x-windows-949(4) : " + new String(word.getBytes("x-windows-949"), "iso-8859-1"));
	}
}