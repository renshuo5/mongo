package com.rensframework.message.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rensframework.controller.CommonController;
import com.rensframework.entity.User;
import com.rensframework.message.service.MessageService;

@Controller
@RequestMapping("/manage/message")
public class MessageController {

	
	@Autowired
	private MessageService messageService;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String index(Model model){
		
		User loginInfo =(User)model.asMap().get(CommonController.ATTR_LOGIN_USER);
		String id=loginInfo.getId();
		messageService.findByFromId(id);
		messageService.findByToId(id);
		
		
		return "message/list";
		
	}
	
	@RequestMapping(value="/form",method=RequestMethod.GET)
	public String form(@RequestParam(value="id",required=false)String id,Model model){
		
		User loginInfo =(User)model.asMap().get(CommonController.ATTR_LOGIN_USER);
		String loginIid=loginInfo.getId();
		model.addAttribute("fromId", loginIid);
		model.addAttribute("toId", id);
		
		return "message/form";
		
	}
	
}
