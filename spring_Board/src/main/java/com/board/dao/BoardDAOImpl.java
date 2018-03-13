package com.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.board.dto.BoardVO;

public class BoardDAOImpl implements BoardDAO {
	
	private SqlSession session;
	public void setSession(SqlSession session){
		this.session=session;
	}

	private static final String NAMESPACE="BoardMapper";
	
	@Override
	public void insertBoard(BoardVO board) throws Exception {
		session.update(NAMESPACE+".insertBoard",board);

	}

	@Override
	public BoardVO selectBoardByBNO(int bno) throws Exception {
		BoardVO board=
		(BoardVO)session.selectOne(NAMESPACE+".selectBoardByBNO",bno);
		return board;
	}

	@Override
	public void updateBorad(BoardVO board) throws Exception {
		session.update(NAMESPACE+".updateBoard",board);
	}

	@Override
	public void deleteBoard(int bno) throws Exception {
		session.update(NAMESPACE+".deleteBoard",bno);

	}

	@Override
	public List<BoardVO> selectBoardAll() throws Exception {
		List<BoardVO> boardList=
				session.selectList(NAMESPACE+".selectBoardAll");
		return boardList;
	}

}






