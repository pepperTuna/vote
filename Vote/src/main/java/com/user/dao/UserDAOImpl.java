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
	public int createUser(UserVO uservo) {
		return session.insert(namespace+".createUser",uservo);
	}

	@Override
	public int checkRegisteredUser(UserVO uservo) {
		return session.selectOne(namespace+".checkRegisteredUser",uservo);
	}
	
}
