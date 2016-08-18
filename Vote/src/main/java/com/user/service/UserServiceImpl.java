package com.user.service;

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
		return dao.joinSnsUser(uservo);
	}

	@Override
	public int checkRegisteredUser(UserVO uservo) {
		return dao.checkRegisteredUser(uservo);
	}

	@Override
	public int duplCheck(UserVO uservo) {
		return dao.duplCheck(uservo);
	}
}
