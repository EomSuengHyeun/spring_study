package com.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.board.dto.BoardVO;
import com.board.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired(required=false)
	private BoardService service;
	
	@RequestMapping("/test")
	public String test(String name,Model model)throws Exception{
		
		model.addAttribute("name", name);
		return "test";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public void registerGET()throws Exception{}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String registerPOST(BoardVO board,RedirectAttributes rtts)
								throws Exception{
		service.create(board);
		rtts.addFlashAttribute("msg","success");
		return "redirect:/board/listAll";
	}
	
	@RequestMapping(value="/listAll",method=RequestMethod.GET)
	public void listAll(Model model)throws Exception{
		List<BoardVO> boardList=service.listAll();
		model.addAttribute("list",boardList);
	}
	
	@RequestMapping("/read")
	public void read(int bno, Model model)throws Exception{
		BoardVO board=service.read(bno);
		model.addAttribute(board);
	}
	
	@RequestMapping(value="/modify",method=RequestMethod.GET)
	public void modifyGET(int bno,Model model)throws Exception{
		BoardVO board=service.read(bno);
		model.addAttribute(board);
	}
	
	@RequestMapping(value="/modify",method=RequestMethod.POST)
	public String modifyPOST(BoardVO board,RedirectAttributes rttr)
					throws Exception{
		
		service.modify(board);
		rttr.addFlashAttribute("msg","SUCCESS");
		
		return "redirect:/board/listAll";
		
	}
	
	@RequestMapping(value="/remove",method=RequestMethod.POST)
	public String delete(int bno,RedirectAttributes rttr)
					throws Exception{
		service.remove(bno);
		rttr.addFlashAttribute("msg","SUCCESS");
		return "redirect:/board/listAll";
	}
}








