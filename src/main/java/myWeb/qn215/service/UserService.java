package myWeb.qn215.service;

import myWeb.qn215.entity.User;

public interface UserService {
	
	public boolean save(User user);
	
	public User selectOneUser(String account,String password);
}
