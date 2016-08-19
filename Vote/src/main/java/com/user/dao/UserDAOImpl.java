package com.user.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.user.domain.UserVO;

@Repository
public class UserDAOImpl implements UserDAO{

	@Inject
	private SqlSession session;
	
	private static String namespace = "com.vote.mapper.UserMapper";
	
	@Override
	public int joinSnsUser(UserVO uservo) {
		return session.insert(namespace+".joinSnsUser",uservo);
	}

	@Override
	public UserVO login(UserVO uservo) {
		return session.selectOne(namespace+".loginUser", uservo);
	}

	@Override
	public int checkRegisteredUser(UserVO uservo) {
		return session.selectOne(namespace+".checkRegisteredUser",uservo);
	}

	@Override
	public int duplCheck(UserVO uservo) {
		return session.selectOne(namespace+".duplCheck",uservo);
	}

	@Override
	public int joinUser(UserVO uservo) {
		return session.insert(namespace+".joinUser",uservo);
	}
}
