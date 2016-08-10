package com.user.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.user.domain.UserVO;
import com.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserContoller {
	
	@Inject UserService userService;
	
	@RequestMapping("/login")
	public int joinUser(UserVO uservo){
		
		return userService.userJoin(uservo);
	}
}