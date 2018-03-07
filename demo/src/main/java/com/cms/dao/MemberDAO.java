package com.cms.dao;

import java.sql.SQLException;
import java.util.List;

import com.cms.dto.MemberVO;
import com.cms.dto.SearchCriteria;

public interface MemberDAO {
	
	// ȸ������ ...............
	
	//ȸ�� ����Ʈ
	List<MemberVO> selectMemberList() throws SQLException;
	
	//ȸ�� ����
	MemberVO selectMemberByID(String member_id) throws SQLException;
	
	//ȸ�� ���
	void insertMember(MemberVO member) throws SQLException;
	
	//ȸ�� ����
	void updateMember(MemberVO member) throws SQLException;
	
	//ȸ�� ����
	void deleteMember(String member_id)throws SQLException;
	
	
	// 리스트 검색 
	List<MemberVO> selectSearchMemberList(SearchCriteria scri)throws SQLException;
	//리스트 총개수
	int selectSearchMemberListCount(SearchCriteria scri)throws SQLException;
}








