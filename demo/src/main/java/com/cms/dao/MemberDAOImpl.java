package com.cms.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.cms.dto.MemberVO;
import com.cms.dto.SearchCriteria;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.jdbc.source.DataSourceDBCPIbatis;

public class MemberDAOImpl implements MemberDAO {

	private static MemberDAOImpl instance=
			new MemberDAOImpl();
	private MemberDAOImpl(){}
	public static MemberDAOImpl getInstance(){
		return instance;
	}
	
	DataSourceDBCPIbatis dataSource=
			DataSourceDBCPIbatis.getInstance();
	private SqlMapClient client=dataSource.getSqlMapClient();
	public void setClient(SqlMapClient client){
		this.client=client;
	}
	
	
	
	@Override
	public List<MemberVO> selectMemberList() throws SQLException {
		
		List<MemberVO> memberList=(List<MemberVO>)
				client.queryForList("selectMemberList",null);
		return memberList;
	}

	@Override
	public MemberVO selectMemberByID(String member_id) throws SQLException {
		MemberVO member=(MemberVO)
			client.queryForObject("selectMemberByID",member_id);
		return member;
	}

	@Override
	public void insertMember(MemberVO member) throws SQLException {
		client.update("insertMember",member);		
	}

	@Override
	public void updateMember(MemberVO member) throws SQLException {
		client.update("updateMember",member);		
	}

	@Override
	public void deleteMember(String member_id) throws SQLException {
		client.update("deleteMember",member_id);		
	}
	@Override
	public List<MemberVO> selectSearchMemberList(SearchCriteria scri) throws SQLException {
		int offset=scri.getPageStartRow();
		int limit=scri.getPerPageNum();
		List<MemberVO> memberList=
				client.queryForList("selectSearchMemberList",scri,offset,limit);
		return memberList;
	}
	@Override
	public int selectSearchMemberListCount(SearchCriteria scri) throws SQLException {
		int count=(Integer)client.queryForObject("selectSearchMemberListCount",scri);
		return count;
	}

}










