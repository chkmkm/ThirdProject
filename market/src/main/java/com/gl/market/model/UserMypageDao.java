package com.gl.market.model;

import java.util.List;

public interface UserMypageDao {

	UserJoinVo userOne(String id);
	UserJoinVo mileCk(String id);
	int copCk(String id);
	List<UserCopVo> copList(String id);
	
}
