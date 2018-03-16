package com.cms.dto;

import java.util.Date;

public class MemberVO {
	
	private String member_id;
	private String member_pwd;
	private String member_name;
	private Date member_regDate;
	
	public MemberVO(){};
	
	public MemberVO(String member_id, String member_pwd, String member_name, Date member_regDate) {
		super();
		this.member_id = member_id;
		this.member_pwd = member_pwd;
		this.member_name = member_name;
		this.member_regDate = member_regDate;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_pwd() {
		return member_pwd;
	}

	public void setMember_pwd(String member_pwd) {
		this.member_pwd = member_pwd;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public Date getMember_regDate() {
		return member_regDate;
	}

	public void setMember_regDate(Date member_regDate) {
		this.member_regDate = member_regDate;
	}

	@Override
	public String toString() {
		return "MemberVO [member_id=" + member_id + ", member_pwd=" + member_pwd + ", member_name=" + member_name
				+ ", member_regDate=" + member_regDate + "]";
	}
	
	
	
	
}
