package com.vote.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.vote.domain.PageMaker;
import com.vote.domain.VoteVO;

@Repository
public class VoteDAOImpl implements VoteDAO {

	private static final Logger logger = LoggerFactory.getLogger(VoteDAOImpl.class);

	@Inject
	private SqlSession session;

	private static String namespace = "com.vote.mapper.VoteMapper";

	@Override
	public int createVote(VoteVO vo) throws Exception {
		session.insert(namespace + ".createVote", vo);
		return vo.getVidx();
	}

	@Override
	public VoteVO readVote(Integer v_idx) throws Exception {
		return session.selectOne(namespace + ".readVote", v_idx);
	}

	@Override
	public List<VoteVO> listVote() throws Exception {
		return session.selectList(namespace + ".listVote");
	}

	@Override
	public int updateVote(VoteVO vo) throws Exception {
		session.update(namespace + ".updateVote", vo);
		return vo.getVidx();
	}

	@Override
	public void deleteVote(Integer v_idx) throws Exception {
		session.update(namespace + ".deleteVote", v_idx);
	}
	
	@Override
	public List<VoteVO> readVoteListWithPaging(PageMaker pageMaker){
		return session.selectList(namespace+".readVoteListWithPaging",pageMaker);
	}
   
	@Override
	public int getTotalVote(String writer){
	   return session.selectOne(namespace+".getTotalVote",writer);
	}
}
