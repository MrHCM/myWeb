package myWeb.qn215.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysql.jdbc.StringUtils;

import myWeb.qn215.entity.User;
import myWeb.qn215.service.UserService;





@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService useerserice;
	/**
	 * 登录
	 */
	@RequestMapping("/login")
	public String Userlogin() {
 
		return "login";
	}
	
	@RequestMapping("/logindl")
	public String login(@RequestParam String userCode,@RequestParam String userPassword, 
			javax.servlet.ServletRequest req,
            javax.servlet.http.HttpSession session) {
		 	User user=useerserice.selectOneUser(userCode, userPassword);
		 	// 如果账号或密码为空
	        if (StringUtils.isNullOrEmpty(userCode) || StringUtils.isNullOrEmpty(userPassword)) {
	            req.setAttribute("errormessage", "账号密码为空");
	            // 返回原页面
	            return "login";
	        }
	        if (null==user) {
	        	 req.setAttribute("errormessage", "账号或密码不对！");
	             // 返回原页面
	             return "login";
			}else {
				session.setAttribute("userName", userCode);
				return "frame";
			}   	
	}
	
	
	/**
	 * 退出登录
	 */
	@GetMapping("/tuichu")
	public String tuichu(javax.servlet.http.HttpSession session) {
		session.removeAttribute("userName");
		return "login";
	}
}
