package com.result.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.result.domain.ResultVO;
import com.result.service.ResultService;

@Controller
@RequestMapping("/result/*")
public class ResultController {
	@Autowired
	ResultService resultService;
	
	@RequestMapping(value="/readResult", method=RequestMethod.GET)
	public void readResult(@RequestParam("vIdx") int vidx, Model model){
		List<ResultVO> resultList = resultService.readResult(vidx);
		
		model.addAttribute("resultList", resultList);
	}
}
