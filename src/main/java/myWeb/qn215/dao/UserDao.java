package myWeb.qn215.dao;

import org.apache.ibatis.annotations.Param;

import myWeb.qn215.entity.User;

public interface UserDao {
	
	public int save(User user);
	
	//@Param传入UserMapper参数
	public User selectOneUser(@Param("account") String account,@Param("password")  String password);
}
