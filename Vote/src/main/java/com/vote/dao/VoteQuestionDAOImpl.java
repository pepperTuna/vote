package com.vote.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.vote.domain.VoteQuestionVO;

@Repository
public class VoteQuestionDAOImpl implements VoteQuestionDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "com.vote.mapper.VoteMapper";

	@Override
	public void createQuestion(VoteQuestionVO vo) throws Exception {
		session.insert(namespace + ".createQuestion", vo);
	}

	@Override
	public List<VoteQuestionVO> readQuestion(Integer v_idx) throws Exception {
	    return session.selectList(namespace + ".readQuestion", v_idx);
	}

	@Override
	public void updateQuestion(VoteQuestionVO vo) throws Exception {
		session.update(namespace + ".updateQuestion", vo);
	}

	@Override
	public void deleteQuestion(VoteQuestionVO vo) throws Exception {
		session.delete(namespace + ".deleteQuestion", vo);
	}

	@Override
	public void deleteChoice(VoteQuestionVO vo) throws Exception {
		session.delete(namespace + ".deleteQuestion", vo);
	}
/*	
	@Override
	public void deleteQuestion(Integer v_idx, Integer q_no) throws Exception {
		session.delete(namespace + ".deleteQuestion", v_idx + "-" + q_no);
	}

	@Override
	public void deleteChoice(Integer v_idx, Integer q_no, Integer c_no) throws Exception {
		session.delete(namespace + ".deleteQuestion", v_idx + "-" + q_no + "-" + c_no);
	}
*/
}
