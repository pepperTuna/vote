package com.user.dao;

import com.user.domain.UserVO;

public interface UserDAO {
	public int joinSnsUser(UserVO uservo);
	public int checkRegisteredUser(UserVO uservo);
	public int duplCheck(UserVO uservo);
	public int joinUser(UserVO uservo);
	public UserVO login(UserVO uservo);
}
