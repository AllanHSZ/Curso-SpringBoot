package com.allanhsz.cursomc.resources;

import org.springframework.security.core.context.SecurityContextHolder;

import com.allanhsz.cursomc.security.UserSS;

public class UserService {
	
	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception e) {
			return null;
		}
	}
}
