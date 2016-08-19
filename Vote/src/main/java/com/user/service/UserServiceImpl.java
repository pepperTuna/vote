package com.user.service;

import java.util.UUID;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.user.dao.UserDAO;
import com.user.domain.UserVO;

@Service
public class UserServiceImpl implements UserService{

	@Inject
	private UserDAO dao;

	@Override
	public int joinSnsUser(UserVO uservo) {
		
		UUID uid = UUID.randomUUID();
		
		uservo.setUserid(uid.toString());
		
		return dao.joinSnsUser(uservo);
	}

	@Override
	public UserVO login(UserVO uservo) {
		return dao.login(uservo);
	}

	@Override
	public int checkRegisteredUser(UserVO uservo) {
		return dao.checkRegisteredUser(uservo);
	}

	@Override
	public int duplCheck(UserVO uservo) {
		return dao.duplCheck(uservo);
	}

	@Override
	public int joinUser(UserVO uservo) {
		return dao.joinUser(uservo);
	}
}
