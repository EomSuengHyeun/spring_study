package com.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.board.dto.BoardVO;
import com.board.dto.PageMaker;
import com.board.dto.SearchCriteria;
import com.board.service.BoardService;

@Controller
@RequestMapping("/sboard")
public class SearchBoardController {
	
	@Autowired
	private BoardService service;
	
	@RequestMapping(value="/listPage",method=RequestMethod.GET)
	public void listPage(@ModelAttribute("cri")SearchCriteria cri,
						 Model model) throws Exception{
		List<BoardVO> boardList=service.listSearch(cri);
		model.addAttribute("list",boardList);
		
		PageMaker pageMaker=new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.readSearchBoardCount(cri));
		model.addAttribute(pageMaker);
	}
	
	@RequestMapping(value="/readPage",method=RequestMethod.GET)
	public void readPage(@ModelAttribute("cri")SearchCriteria cri,
						 int bno, Model model)throws Exception{
		BoardVO board=service.read(bno);
		model.addAttribute(board);
	}
}








