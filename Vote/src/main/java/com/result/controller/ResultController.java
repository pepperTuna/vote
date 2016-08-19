package com.result.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
	
	@RequestMapping(value="/createResult", method=RequestMethod.GET)
	public String createResultGet(){
		
		return "hello222";
	}
	
	@RequestMapping(value="/createResult", method=RequestMethod.POST)
	public String createResult(/*@RequestBody String jsonStr*/) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		Map<String, String> map = new HashMap<String, String>();
		
		//map = mapper.readValue(jsonStr, new TypeReference<Map<String, String>>(){});
		
		//return map.get("length");
		return "hello";
	}
	
}
