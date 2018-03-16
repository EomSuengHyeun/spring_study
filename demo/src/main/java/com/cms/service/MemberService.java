package com.cms.service;

import java.sql.SQLException;
import java.util.List;

import com.cms.controller.JoinRequest;
import com.cms.controller.LoginRequest;
import com.cms.controller.ModifyRequest;
import com.cms.dto.MemberVO;
import com.cms.dto.SearchCriteria;
import com.jdbc.exception.FailToVerifiedIDException;
import com.jdbc.exception.InvalidPasswordException;
import com.jdbc.exception.NotFoundIDException;
import com.jdbc.exception.NullLoginUserException;

public interface MemberService {
	
	//ȸ�� ����Ʈ ����
	List<MemberVO> getMemberList() throws SQLException;
	//ȸ�� ���� ����
	MemberVO getMemberByID(String member_id)throws SQLException;
	//ȸ�� �����ϱ�
	void joinMember(JoinRequest req)throws SQLException
										   ,FailToVerifiedIDException;
	//ȸ�� �����ϱ�
	void modifyMember(ModifyRequest req)throws SQLException;
	//ȸ�� Ż���ϱ�
	void removeMember(String member_id)throws SQLException;
	
	//�α��� �ϱ�
	MemberVO login(LoginRequest req)
			throws SQLException,NotFoundIDException,InvalidPasswordException; 
	//�α׾ƿ� �ϱ�
	void logout()throws SQLException,NullLoginUserException;
	
	List<MemberVO> getSearchMemberList(SearchCriteria scri)
	throws SQLException;
	
	int getSearchMemberListCount(SearchCriteria scri)
			throws SQLException;
}







