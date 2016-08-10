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
	public int userJoin(UserVO uservo) {
		return dao.createUser(uservo);
	}
	
}
