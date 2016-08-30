package com.rensframework.message.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rensframework.controller.CommonController;
import com.rensframework.entity.Message;
import com.rensframework.entity.User;
import com.rensframework.message.service.MessageService;
import com.rensframework.model.AjaxResult;
import com.rensframework.user.service.UserService;

@Controller
@RequestMapping("/manage/message")
public class MessageController {

	
	@Autowired
	private MessageService messageService;
	@Autowired
	private UserService userService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String index(Model model){
		
		User loginInfo =(User)model.asMap().get(CommonController.ATTR_LOGIN_USER);
		String id=loginInfo.getId();
		//发出的消息
		List<Message> fromList = messageService.findByFromId(id);
		//收到的消息
		List<Message> toList = messageService.findByToId(id);
		
		model.addAttribute("fromList", fromList);
		
		model.addAttribute("toList", toList);
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
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public Object create(Message mess,Model model){
		AjaxResult ajax=new AjaxResult();
		User user = userService.findOne(mess.getFromId());
		User toUser = userService.findOne(mess.getToId());
		mess.setFromName(user.getName());
		mess.setToName(toUser.getName());
		Message newMess = messageService.create(mess);
		if(newMess==null){
			ajax.setStatus(300);
			ajax.setMessage("保存失败");
		}
		return ajax;
	}
	
}
