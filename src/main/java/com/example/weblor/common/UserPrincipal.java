package com.example.weblor.common;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
public class UserPrincipal {
	 private UserPrincipal(){

	    }

	    public static String getUsernameCurrent(){
	        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

			if (auth == null) {
				throw new UnauthorizedException();
			}
	        
			if (auth.getPrincipal() instanceof String) {
				return (String) auth.getPrincipal();
			}

			UserDetails currentAuditor = (UserDetails) auth.getPrincipal();
			return currentAuditor.getUsername();
	    }

}
