package com.gl.market.model;

import java.util.HashMap;
import java.util.List;

public interface UserMypageDao {

	UserJoinVo userOne(String id);
	UserJoinVo mileCk(String id);
	int copCk(String id);
	List<UserCopVo> copList(HashMap<String,Object> map);
	void userUpdata(UserJoinVo data);
	void userDelete(String id);
	
}
