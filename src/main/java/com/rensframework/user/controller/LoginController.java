package com.rensframework.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rensframework.entity.User;
import com.rensframework.user.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/login", "/login;JSESSIONID={sessionId}",
			"/signon", "/signon;JSESSIONID={sessionId}" })
	public String redirectLogin(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		if (session.getAttribute("user") != null) {
			return "redirect:/manage";
		} else {
			return "user/login";
		}
	}

	@RequestMapping(value = { "/dologin", "/dologin;JSESSIONID={sessionId}",
			"/dosignon/", "/dosignon/;JSESSIONID={sessionId}" }, method = { RequestMethod.POST })
	public String login(
			@RequestParam(value = "account", required = false) String account,
			@RequestParam(value = "password", required = false) String password,
			Model model, HttpServletRequest req) {

		System.out.println(account);
		System.out.println(password);

		User user = userService.findByAccount(account);
		// new SimpleAuthenticationInfo(new LoginInfo(user.getId(),
		// (String)SecurityUtils.getSubject().getSession().getId(),
		// user.getAccount(), user.getPoolId().longValue()), user.getPassword(),
		// ByteSource.Util.bytes(salt), getName());
		if (user != null && password.equals(user.getPassword())) {
			req.getSession().setAttribute("userCommon", user);
			return "redirect:/manage";
		} else {
			return "user/login";
		}
	}

	@RequestMapping(value = "/logout", method = { RequestMethod.GET })
	public String logout(HttpServletRequest req) {
		req.getSession().invalidate();
		return "user/login";
	}

}
