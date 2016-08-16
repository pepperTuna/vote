package com.result.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.result.service.ResultService;

@Controller
@RequestMapping("/result/*")
public class ResultController {
	@Autowired
	ResultService resultService;
	
	@RequestMapping(value="/getResult", method=RequestMethod.GET)
	public void getResult(){
		
	}
}
