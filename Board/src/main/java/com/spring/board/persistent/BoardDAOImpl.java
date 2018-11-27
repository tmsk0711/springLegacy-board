package com.spring.board.persistent;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.board.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO{
	
	@Inject
	private SqlSession session;
	
	private static final String Namespace = "com.spring.board";
	
	@Override
	public void insert(BoardVO board) throws Exception {
		session.insert(Namespace+".insert", board);
	}

	@Override
	public void delete(int bNum) throws Exception {
		// TODO Auto-generated method stub
		session.delete(Namespace+".delete", bNum);
	}

	@Override
	public void update(BoardVO board) throws Exception {
		// TODO Auto-generated method stub
		session.update(Namespace+".update",board);
		
	}

	@Override
	public void updateReadCount(int bNum) throws Exception {
		// TODO Auto-generated method stub
		session.update(Namespace+".updateReadCount",bNum);
	}

	@Override
	public List<BoardVO> list() throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(Namespace+".list");
	}

	@Override
	public BoardVO select(int bNum) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(Namespace+".select",bNum);
	}

	
	
}
