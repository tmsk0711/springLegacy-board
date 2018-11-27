package com.spring.board.controller;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.spring.board.domain.ReplyVO;
import com.spring.board.persistent.ReplyDAO;


@Controller
public class RController {
	
	@Autowired
	private ReplyDAO replyDao;
	
	
	@RequestMapping(value="/reply/write", 
			method=RequestMethod.POST)
	public @ResponseBody String replyWrite(@RequestBody ReplyVO replyVO) throws Exception{
		
		replyDao.insert(replyVO);
		int rNum = replyDao.selectMaxRnum();
		
		return rNum+"";
	

	}
	

}
