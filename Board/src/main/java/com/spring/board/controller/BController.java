package com.spring.board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.board.domain.BoardVO;
import com.spring.board.domain.ReplyVO;
import com.spring.board.persistent.BoardDAO;
import com.spring.board.persistent.ReplyDAO;
import com.spring.board.persistent.ReplyDAOImpl;
import com.spring.board.persistent.UserDAO;
import com.spring.board.persistent.UserDAOImpl;
import com.spring.board.util.MyUtils;

// Controller, Repository, Service, Component

@Controller
public class BController {

	@Autowired
	private BoardDAO boardDao;
	@Autowired
	private ReplyDAO replyDao;

	/*
	 * @Inject private SqlSession session;
	 */
	// dispatcher �뿭�븷
	// http://localhost:8000/board/
	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/board/list")
	public String list(Model model,@RequestParam int page) throws Exception {
	
		List<BoardVO> list = boardDao.list();
		model.addAttribute("page", page);

		model.addAttribute("list", list);

		return "board/list";
	}

	@RequestMapping("/board/write")
	public String write() {
		return "board/write";
	}
	@RequestMapping(value = "/writeAction", method = RequestMethod.POST)
	public String writeAction(BoardVO boardVO) throws Exception {

		boardDao.insert(boardVO);

		return "redirect:board/list";

	}

	@RequestMapping(value = "/board/content", method = RequestMethod.GET)
	public String content(@RequestParam int bNum) throws Exception {

		boardDao.select(bNum);

		return "board/content";
	}

	@RequestMapping("/adminboard/delete")
	public String adminboardDelete(@RequestParam int bNum) throws Exception {
		boardDao.delete(bNum);
		return "redirect:/board/list";
	}

	@RequestMapping("/board/delete")
	public String boardDelete(@RequestParam int bNum) throws Exception {
		boardDao.delete(bNum);
		return "redirect:/board/list";
	}

	@RequestMapping("/board/detail")
	@Transactional
	public String boardDetail(@RequestParam int bNum, Model model)
			throws Exception {
		boardDao.updateReadCount(bNum);
		BoardVO boardVO = boardDao.select(bNum);
		String result = MyUtils.getYoutubeMovie(boardVO.getbContent());
		boardVO.setbContent(result);
		model.addAttribute("boardVO", boardVO);
		List<ReplyVO> list = replyDao.list(bNum);
		model.addAttribute("list", list);
		return "/board/detail";
	}

	@RequestMapping("/board/updateForm")
	public String boardUpdateForm(@RequestParam int bNum, Model model)
			throws Exception {
		BoardVO boardVO = boardDao.select(bNum);
		model.addAttribute("boardVO", boardVO);
		return "board/updateForm";
	}
	
	@RequestMapping(value = "/board/update", method = RequestMethod.POST)
	public String boardUpdate(BoardVO boardVO) throws Exception {

		boardDao.update(boardVO);

		return "redirect:/board/list";

	}

}
