package com.result.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.result.domain.ResultVO;
import com.result.service.ResultService;
import com.vote.domain.VoteQuestionVO;
import com.vote.service.VoteQuestionService;

@Controller
public class ResultController {
	
	@Inject
	ResultService resultService;
	VoteQuestionService voteQuestionService;
	
	@RequestMapping(value="/readResult", method=RequestMethod.GET)
	public void readResult(@RequestParam("vidx") int vidx, Model model) throws Exception{
		List<ResultVO> resultList = resultService.readResult(vidx);
		
		List<VoteQuestionVO> questionList = voteQuestionService.readQuestionResult(vidx, resultList);
		
		model.addAttribute("resultList", resultList);
		model.addAttribute("questionList", questionList);
	}
	
	@RequestMapping(value="/createResult", method=RequestMethod.POST)
	public String createResult(@RequestParam("result") String result, @RequestParam("vidx") String vidx){
		resultService.createResult(result, Integer.parseInt(vidx));
		return vidx+"";
	}
	
}
