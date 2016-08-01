package com.vote.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vote.dao.VoteDAO;
import com.vote.domain.VoteVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})

public class VoteDAOTest {

	@Inject
	private VoteDAO dao;
	
	@Test
	public void createVote() throws Exception {
		VoteVO vo = new VoteVO();
		vo.setV_WRITER("test00");
		vo.setV_TITLE("test_title");
		
		dao.createVote(vo);
	}
}
