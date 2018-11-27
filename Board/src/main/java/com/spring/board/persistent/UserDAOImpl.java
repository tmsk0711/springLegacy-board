package com.spring.board.persistent;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.board.domain.UserVO;


//Controller, Repository, Service, Component
@Repository
public class UserDAOImpl implements UserDAO{
	
	@Inject
	private SqlSession session;
	private static final String namespace = "com.spring.user";
	
	@Override
	public void insert(UserVO userVO) throws Exception {
		session.insert(namespace+".insert", userVO);
		
	}
	@Override
	public void delte(int userID) throws Exception {
		session.delete(namespace+".delete", userID);
		
	}
	
	
}
