package com.vote.dao;

import java.util.List;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.vote.domain.VoteVO;

@Repository
public class VoteDAOImpl implements VoteDAO {

	@Inject
	private SqlSession session;
	
	private static String namespace = "com.vote.mapper.VoteMapper";
	
	@Override
	public void createVote(VoteVO vo) throws Exception {
		session.insert(namespace + ".createVote", vo);
	}


	@Override
	public VoteVO readVote(Integer v_idx) throws Exception {
	    return session.selectOne(namespace + ".readVote", v_idx);
	}

	@Override
	public List<VoteVO> readVoteList(String v_writer) throws Exception {
		return session.selectList(namespace + ".readVoteList");
	}
	
	@Override
	public void updateVote(VoteVO vo) throws Exception {
	    session.update(namespace+".updateVote", vo);
	}

	@Override
	public void deleteVote(Integer v_idx) throws Exception {
	    session.update(namespace+".deleteVote", v_idx);
	}

}
