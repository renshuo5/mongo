package com.rensframework.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/manage")
public class ManageController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String manage(HttpServletRequest request, Model model) {
		return "manage/index";
	}
	
	@RequestMapping(value = "/hello",method=RequestMethod.GET)
	public String hello(HttpServletRequest request, Model model) {
		return "manage/hello";
	}

}
