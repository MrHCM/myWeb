package myWeb.qn215.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import myWeb.qn215.entity.User;
import myWeb.qn215.service.UserService;



@Controller
@RequestMapping
public class HelloController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/hello3")
	public void hello3() {
		System.out.println("======");
	}
	
	@GetMapping("/hello2")
	public void hello2(Date date) {
		System.out.println(null==date?"时间为null":date);
	}
	
	@GetMapping("/ok")
	public void hello() {
		System.out.println("ssssssssssssss");
		User user=new User();
		user.setAge(100);
		user.setUser_account("555");
		user.setBirthday(new Date());
		user.setUser_name("2018-11-15");
		user.setUser_password("1222");
		userService.save(user);
	}
	
	
}
