package com.konarzewski.configuration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
 
@Component
public class CustomizeAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication arg2) {
		response.setStatus(HttpServletResponse.SC_OK);
		try {
			 response.sendRedirect( request.getContextPath() + "/home" );
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
} 