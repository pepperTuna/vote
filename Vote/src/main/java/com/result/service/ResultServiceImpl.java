package com.result.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.result.dao.ResultDAO;
import com.result.domain.ResultVO;

@Service
public class ResultServiceImpl implements ResultService{
	
	@Autowired
	ResultDAO dao;
	
	public List<ResultVO> readResult(int vidx){
		return dao.readResult(vidx);
	}
	
	public void createResult(String result, int vidx){
		String[] resultList = result.split("\\|");
		int length = Integer.parseInt(resultList[0]);
		

		for (int i = 1; i <= length; i++) {
			ResultVO vo = new ResultVO();
			vo.setVno(vidx);
			vo.setRuser("noname");
			vo.setQno(i);
			vo.setCno(Integer.parseInt(resultList[i]));
			dao.createResult(vo);
		}
		
		
	}
}
