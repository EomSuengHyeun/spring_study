package com.cms.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.cms.dto.MemberVO;


public class LoginCheckFilter implements Filter {
	
	private List<String> includeURLs=new ArrayList<String>();
    
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, 
			ServletResponse response, FilterChain chain) throws IOException, ServletException {
				
		
		HttpServletRequest httpReq=(HttpServletRequest)request;
		
		String reqUrl=httpReq.getRequestURI()
				.replace(httpReq.getContextPath(), "");
		
		boolean flag=false;
		for(String includeURL:includeURLs){
			if(reqUrl.indexOf(includeURL)>-1) {
				flag=true;
				break;
			}
		}		
		if(!flag){
			loginCheck(request,response,chain);			
		}else{
			chain.doFilter(request, response);
		}
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		String includeParam=fConfig.getInitParameter("includeURL");
		
		StringTokenizer token=new StringTokenizer(includeParam,",");
		
		while(token.hasMoreTokens()){
			includeURLs.add(token.nextToken().trim());
		}		
	}
	
	private void loginCheck(ServletRequest request, 
							ServletResponse response,
							FilterChain chain)
					        throws IOException,ServletException{
		
		String url=null;
		
		HttpServletRequest httpReq=(HttpServletRequest)request;
		HttpSession session=httpReq.getSession();
		MemberVO loginUser=(MemberVO)session.getAttribute("loginUser");
		
		//if(SessionScope.loginUser==null){
		if(loginUser==null){
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();			
			out.print("<script>alert('로그인이 필요합니다.');</script>");
			url=httpReq.getContextPath()+"/commons/login";
			/*response.sendRedirect(url);*/
			out.print("<script>");
			out.print("location.href='"+url+"'");
			out.print("</script>");
			return;
		}	
		chain.doFilter(request, response);
	}
}








