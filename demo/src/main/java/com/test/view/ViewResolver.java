package com.test.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewResolver {
	
	public static void view(String url, 
							HttpServletRequest request,
							HttpServletResponse response)
							throws IOException,ServletException{
		
		if(url.indexOf("redirect:")==0){
			// redirect:/member/list
			url=request.getContextPath()+url.replace("redirect:", "");
			response.sendRedirect(url);
		}else{
			url="/WEB-INF/views"+url+".jsp";
			request.getRequestDispatcher(url).forward(request, response);
		}
		
		
	}
	
}










