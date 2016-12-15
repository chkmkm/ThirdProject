package com.gl.market.model;

import java.util.List;

public interface UserLoginDao {
	
	int logCheck(UserJoinVo bean);
	List<UserJoinVo> selId(UserJoinVo bean);
	List<UserJoinVo> selPw(UserJoinVo bean);
	List<UserJoinVo> logIn(UserJoinVo bean);
	void PwUp(UserJoinVo bean);
	
}
