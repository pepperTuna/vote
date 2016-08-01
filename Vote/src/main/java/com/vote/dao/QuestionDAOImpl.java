package com.vote.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import com.vote.domain.QuestionVO;

public class QuestionDAOImpl implements QuestionDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "com.vote.mapper.VoteMapper";

	@Override
	public void createQuestion(QuestionVO vo) throws Exception {
		session.insert(namespace + ".createQuestion", vo);
	}

	@Override
	public List<QuestionVO> readQuestion(Integer v_idx) throws Exception {
	    return session.selectList(namespace + ".readQuestion", v_idx);
	}

	@Override
	public void updateQuestion(QuestionVO vo) throws Exception {
		session.update(namespace + ".updateQuestion", vo);
	}

	@Override
	public void deleteQuestion(QuestionVO vo) throws Exception {
		session.delete(namespace + ".deleteQuestion", vo);
	}

	@Override
	public void deleteChoice(QuestionVO vo) throws Exception {
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
