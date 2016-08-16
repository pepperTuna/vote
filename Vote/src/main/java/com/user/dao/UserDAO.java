package com.user.dao;

import com.user.domain.UserVO;

public interface UserDAO {
	public int joinSnsUser(UserVO uservo);
	public int checkRegisteredUser(UserVO uservo);
}
