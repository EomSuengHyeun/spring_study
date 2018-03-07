package com.cms.dto;

public class PageMaker {
	private int totalCount; // 전체 list개수
	private int startPage; // 시작 페이지 번호
	private int endPage; // 끝 페이지 번호
	private boolean prev; // 이전 버튼 여부
	private boolean next; // 다음 버튼 여부.

	private int displayPageNum = 5; // 페이지당 list개수

	private SearchCriteria scri;

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;

		calcData();
	}

	private void calcData() {
		endPage = (int)(Math.ceil(scri.getPage()/(double)displayPageNum)*displayPageNum);
		startPage = endPage - displayPageNum + 1;

		int tmpEndPage = (int) (Math.ceil(totalCount / (double) displayPageNum));
		if (endPage > tmpEndPage) {
			endPage = tmpEndPage;
		}

		prev = startPage == 1 ? false : true;
		next = endPage * displayPageNum >= totalCount ? false : true;
		
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public SearchCriteria getScri() {
		return scri;
	}

	public void setScri(SearchCriteria scri) {
		this.scri = scri;
	}

	public String makeSearch(int page){
		String url="?page="+page
				  +"&perPageNum="+scri.getPerPageNum()
				  +"&searchType="+scri.getSearchType()
				  +"&keyword="+scri.getKeyword();
		return url;
	}	
	
	
	
	@Override
	public String toString() {
		return "PageMaker [totalCount=" + totalCount + ", startPage=" + startPage + ", endPage=" + endPage + ", prev="
				+ prev + ", next=" + next + ", displayPageNum=" + displayPageNum + ", scri=" + scri + "]";
	}

}








