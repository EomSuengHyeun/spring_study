package com.cms.dto;

public class SearchCriteria {

	private int page; // 현재 page번호
	private int perPageNum; // page 당 보여주는 list개수
	private String searchType; // 검색어 종류
	private String keyword; // 검색어

	public SearchCriteria() {
		this.page = 1;
		this.perPageNum = 5;
		this.searchType="";
		this.keyword="";
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if (page <= 0) {
			this.page=1;
		} else {
			this.page = page;
		}
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		if(perPageNum<=0 || perPageNum>100){
			this.perPageNum=5;
		}else{
			this.perPageNum=perPageNum;
		}		
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		if(searchType==null){
			searchType="";
		}else{
			this.searchType = searchType;
		}
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		if(keyword==null){
			keyword="";
		}else{
			this.keyword = keyword;
		}
	}
	
	@Override
	public String toString() {
		return "SearchCriteria [page=" + page + ", perPageNum=" + perPageNum + ", searchType=" + searchType
				+ ", keyword=" + keyword + "]";
	}

	public int getPageStartRow(){
		return (this.page-1)*this.perPageNum;
	}
	
	public String getURL(){
		return "page="+page
				+"&perPageNum="+perPageNum
				+"&searchType="+searchType
				+"&keyword="+keyword;
	}
}













