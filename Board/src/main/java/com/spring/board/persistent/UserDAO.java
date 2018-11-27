package com.spring.board.persistent;

import com.spring.board.domain.UserVO;



public interface UserDAO {
	void insert(UserVO userVO)throws Exception;
	void delte(int userID)throws Exception;

}
