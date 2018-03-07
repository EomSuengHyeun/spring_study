package com.cms.dto;

import javax.servlet.http.HttpServletRequest;

public class SearchCriteriaHelper {
	
	public static SearchCriteria 
					toSearchCriteria(HttpServletRequest request){
		
		String page=request.getParameter("page");		
		String perPageNum=request.getParameter("perPageNum");
		String searchType=request.getParameter("searchType");		
		String keyword=request.getParameter("keyword");
		SearchCriteria scri=new SearchCriteria();
		if(page!=null) scri.setPage(Integer.parseInt(page));
		if(perPageNum!=null)scri.setPerPageNum(Integer.parseInt(perPageNum));
		scri.setKeyword(keyword);
		scri.setSearchType(searchType);
		
		
		return scri;
	}
	
	public static void inRequestCriteria(HttpServletRequest request){
		String searchType=request.getParameter("searchType");
		String keyword=request.getParameter("keyword");
		String page=request.getParameter("page");		
		String perPageNum=request.getParameter("perPageNum");
		
		SearchCriteria scri=new SearchCriteria();
		scri.setKeyword(keyword);
		scri.setSearchType(searchType);
		if(page!=null) scri.setPage(Integer.parseInt(page));
		if(perPageNum!=null)scri.setPerPageNum(Integer.parseInt(perPageNum));
		
		request.setAttribute("cri", scri);
	}
}




