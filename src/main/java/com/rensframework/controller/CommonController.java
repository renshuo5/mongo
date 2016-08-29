package com.rensframework.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.rensframework.entity.User;
import com.rensframework.user.service.UserService;

@ControllerAdvice("com.rensframework")
public class CommonController {
	
	protected transient final Logger logger = LoggerFactory.getLogger(this
			.getClass());
	@Autowired
	private UserService userService;
	
	public static final String ATTR_LOGIN_USER = "loginUser";

	@ModelAttribute(ATTR_LOGIN_USER)
	public User loginUser(HttpServletRequest req) {
		User user=(User)req.getSession().getAttribute("userCommon");
		return user;
	}

}
