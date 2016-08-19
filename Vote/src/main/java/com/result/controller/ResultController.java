package com.result.controller;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.result.domain.ResultVO;
import com.result.service.ResultService;

@Controller
public class ResultController {
	
	@Inject
	ResultService resultService;
	
	@RequestMapping(value="/readResult", method=RequestMethod.GET)
	public void readResult(@RequestParam("vidx") int vidx, Model model){
		List<ResultVO> resultList = resultService.readResult(vidx);
		
		model.addAttribute("resultList", resultList);
	}
	
	@RequestMapping(value="/createResult", method=RequestMethod.POST)
	public String createResult(@RequestParam("result") String result, @RequestParam("vidx") String vidx){
		resultService.createResult(result, Integer.parseInt(vidx));
		return vidx+"";
	}
	
}
