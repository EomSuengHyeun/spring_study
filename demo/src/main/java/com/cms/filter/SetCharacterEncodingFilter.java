package com.cms.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

public class SetCharacterEncodingFilter implements Filter {
	
	public static final String UTF8="utf-8";
	
	private String encoding;
	
	public void destroy() {

	}

	public void doFilter(ServletRequest request, 
			             ServletResponse response, 
			             FilterChain chain) 
			            		 throws IOException, ServletException {
		if(request.getCharacterEncoding()==null){
			request.setCharacterEncoding(encoding);
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
		encoding=fConfig.getInitParameter("encoding").trim();
		if(encoding==null){
			encoding=UTF8;
		}
	}

}








