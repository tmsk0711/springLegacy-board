package com.spring.board.persistent;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.board.domain.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO{
	
	@Inject
	private SqlSession session;
	private static final String namespace = "com.spring.reply";
	
	@Override
	public void insert(ReplyVO replyVO) throws Exception {
		session.insert(namespace+".insert", replyVO);
	}

	@Override
	public void delete(int rNum) throws Exception {
		session.delete(namespace+".delete", rNum);	
	}

	@Override
	public List<ReplyVO> list(int bNum) throws Exception {
		return session.selectList(namespace+".list", bNum);
	}

	@Override
	public int selectMaxRnum() throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".selectMaxRnum");
	}
	

}
