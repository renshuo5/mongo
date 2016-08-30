package com.rensframework.user.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rensframework.controller.CommonController;
import com.rensframework.entity.User;
import com.rensframework.model.AjaxResult;
import com.rensframework.user.service.UserService;

@Controller
@RequestMapping("/manage/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String index(@RequestParam(value="name",required=false)String name, Model model){
		
		if(name==null){
			List<User>  list =userService.findAll();
			model.addAttribute("list", list);
		}else{
			List<User>  list =userService.findByName(name);
			model.addAttribute("list", list);
		}
		
		return "user/list";
	}
	
	@RequestMapping(value="/form",method=RequestMethod.GET)
	public String form(@RequestParam(value="id",required=false)User user,Model model){
		if(user==null){
			user=new User();
		}
		model.addAttribute("entity", user);
		return "user/form";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public Object create(User user,Model model){
		AjaxResult ajax=new AjaxResult();
		User newUser = userService.creative(user);
		if(newUser==null){
			ajax.setStatus(300);
			ajax.setMessage("保存失败");
		}
		return ajax;
//		return "redirect:/user/index";
	}
	
	@RequestMapping(value="/addfriend",method=RequestMethod.GET)
	@ResponseBody
	public Object addFriends(@RequestParam(value="id",required=false)User user,Model model){
		AjaxResult ajax=new AjaxResult();
		User loginInfo =(User)model.asMap().get(CommonController.ATTR_LOGIN_USER);
		if(loginInfo==null){
			ajax.setStatus(300);
			ajax.setMessage("用户为空");
			return ajax;
		}
		Set<User> set = loginInfo.getFriends();
		if(set==null){
			set = new HashSet<User>();
		}
		set.add(user);
		loginInfo.setFriends(set);
		User newUser = userService.update(loginInfo);
		if(newUser==null){
			ajax.setStatus(300);
			ajax.setMessage("保存失败");
		}
		
		return ajax;
	}

	@RequestMapping(value="/getfriend",method=RequestMethod.GET)
	public String getFriends(Model model){
		User loginInfo =(User)model.asMap().get(CommonController.ATTR_LOGIN_USER);
		Set<User> set = loginInfo.getFriends();
		if(set==null){
			set=new HashSet<User>();
		}
		List<User> list = new ArrayList<User>(set);
		model.addAttribute("list", list);
		return "user/friendsList";
	}
}
