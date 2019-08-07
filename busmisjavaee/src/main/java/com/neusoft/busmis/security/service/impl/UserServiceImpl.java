package com.neusoft.busmis.security.service.impl;

import java.util.List;

import com.neusoft.busmis.security.dao.IUserDao;
import com.neusoft.busmis.security.factory.DaoFactory;
import com.neusoft.busmis.security.model.UserModel;
import com.neusoft.busmis.security.service.IUserService;
//用户的业务实现类
public class UserServiceImpl implements IUserService {
	//取得User的DAO接口对象
	private IUserDao userDao=DaoFactory.createUserDao();
	
	@Override
	public void register(UserModel userModel) throws Exception {
		userDao.create(userModel);
	}
	@Override
	public void modify(UserModel userModel) throws Exception {
		userDao.update(userModel);
	}
	@Override
	public void changePasswowrd(String id, String password) throws Exception {
		UserModel um=userDao.selectById(id);
		um.setPassword(password);
		userDao.update(um);
	}
	@Override
	public void changrRole(String id, String role) throws Exception {
		UserModel um=userDao.selectById(id);
		um.setRole(role);
		userDao.update(um);
	}
	@Override
	public boolean validate(String id, String password) throws Exception {
		boolean result=false;
		UserModel um=userDao.selectById(id);
		if(um!=null&&um.getPassword()!=null&&um.getPassword().equals(password)) {
			result=true;
		}
		return result;
	}
	@Override
	public void active(String id) throws Exception {
		UserModel um=userDao.selectById(id);
		um.setStatus("Y");
		userDao.update(um);
	}
	@Override
	public void disable(String id) throws Exception {
		UserModel um=userDao.selectById(id);
		um.setStatus("N");
		userDao.update(um);
	}
	@Override
	public void delete(UserModel userModel) throws Exception {
		userDao.delete(userModel);
	}
	@Override
	public List<UserModel> getListByAll() throws Exception {
		return userDao.selectListByAll();
	}
	@Override
	public UserModel getById(String id) throws Exception {
		
		return userDao.selectById(id);
	}

}
