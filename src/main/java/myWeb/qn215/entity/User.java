package myWeb.qn215.entity;

import java.util.Date;

import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 用户类
 * @author 汪春滋
 *
 */
public class User {

	private int user_id;//用户id
        @Size(min=2,max=20)
	private String user_name;//用户名
        @Size(min=2,max=20)
	private String user_account;//用户账号
        @Size(min=2,max=20)
	private String user_password;//用户密码
	private int age;//用户年龄
	private Date birthday;//用户生日
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_account() {
		return user_account;
	}
	public void setUser_account(String user_account) {
		this.user_account = user_account;
	}
	public int getAge() {
		return age;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	
}
