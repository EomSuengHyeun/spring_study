package com.board.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.board.dto.ReplyVO;
import com.board.service.ReplyService;

// url : /replies
// /replies/all/{bno}		GET방식 : bno번 게시글의 댓글 목록
// /replies/{rno}			PUT,PATCH방식 : rno 댓글의 수정 
// /replies/{rno}			DELETE 방식 : rno 댓글의 삭제
// /replies 				POST 방식 : 댓글 입력
// /replies/{bno}/{page} 	GET방식 : bno번 게시글의 페이징 처리된 댓글 목록

@RestController
@RequestMapping("/replies")
public class ReplyController {
	
	@Autowired
	private ReplyService service;
	
	@RequestMapping(value="/all/{bno}",method=RequestMethod.GET)
	public ResponseEntity<List<ReplyVO>> 
			list(@PathVariable("bno") int bno)throws Exception{
		
		System.out.println("bno : "+bno);
		
		return null;
	}
	
	@RequestMapping(value="/{rno}",method={RequestMethod.PUT,						
											RequestMethod.PATCH})
	public ResponseEntity<String> update(@PathVariable("rno")int rno,
										ReplyVO reply)
											throws Exception{		
		System.out.println("rno : "+rno);		
		return null;
	}
	
	@RequestMapping(value="/{rno}",method=RequestMethod.DELETE)
	public ResponseEntity<String> remove(@PathVariable("rno") int rno)
									throws Exception{
		
		System.out.println("delete rno : "+rno);
		return null;
	}
	
	@RequestMapping(value="",method=RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody Map<String,Object> data){
		
		System.out.println("insert:"+data);
		
		return null;
	}
	
	@RequestMapping(value="/{bno}/{page}",method=RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> listPage(
				@PathVariable("bno")int bno, 
				@PathVariable("page")int page)throws Exception{
		
		System.out.println("bno : "+bno+",page : "+page);
		
		return null;
	}
}












