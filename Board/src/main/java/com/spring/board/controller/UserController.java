package com.spring.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.board.domain.UserVO;
import com.spring.board.persistent.BoardDAO;
import com.spring.board.persistent.ReplyDAO;
import com.spring.board.persistent.UserDAO;

@Controller
public class UserController {
	
	@Autowired
	private UserDAO userDAO;
	
	
	@RequestMapping("/user/joinForm")
	public String userJoinForm(){
		
		return "/user/joinForm";
	}
	
	@RequestMapping("/user/join")
	public String userJoin(UserVO userVO)throws Exception{
		userDAO.insert(userVO);
		
		return "redirect:/";
	}
	
	


}
