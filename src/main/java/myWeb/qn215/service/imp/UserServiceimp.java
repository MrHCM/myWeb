package myWeb.qn215.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myWeb.qn215.dao.UserDao;
import myWeb.qn215.entity.User;
import myWeb.qn215.service.UserService;

@Service
public class UserServiceimp implements UserService{

	@Autowired
	UserDao userDao;
	
	/**
	 * 用户注册
	 *@param user
     *@return
	 */
	@Override
	public boolean save(User user) {
		
		return userDao.save(user)>0;
	}

	@Override
	public User selectOneUser(String account,String password) {
		
		return userDao.selectOneUser(account, password);
	}
	

}
