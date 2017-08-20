package com.Li.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.Li.pojos.roles.User;

public class Interceptor extends HandlerInterceptorAdapter{

	String destination;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException{
		HttpSession sessionH = request.getSession();
		User user = (User)sessionH.getAttribute("signedUser");
		if(user.getUserRole().equals("Admin") ){
			return true;
			
		}
		else{
			response.sendRedirect(request.getContextPath()+"/index");
			return false;
			
		}
		
		
	}
}
