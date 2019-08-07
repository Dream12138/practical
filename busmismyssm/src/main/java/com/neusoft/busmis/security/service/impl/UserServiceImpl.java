package com.neusoft.busmis.security.service.impl;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.neusoft.busmis.security.dao.IUserDao;
import com.neusoft.busmis.security.factory.DaoFactory;
import com.neusoft.busmis.security.model.UserModel;
import com.neusoft.busmis.security.service.IUserService;
//用户的业务实现类
public class UserServiceImpl implements IUserService {
	//取得User的DAO接口对象
	//private IUserDao userDao=DaoFactory.createUserDao();
	
	@Override
	public void register(UserModel userModel) throws Exception {
		String resource = "mybatis_config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		IUserDao userDao=session.getMapper(IUserDao.class);
		userDao.create(userModel);
		session.commit();
		session.close();
	}
	@Override
	public void modify(UserModel userModel) throws Exception {
		String resource = "mybatis_config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		IUserDao userDao=session.getMapper(IUserDao.class);
		userDao.update(userModel);
		session.commit();
		session.close();
		
		System.out.println("执行修改");
	}
	@Override
	public void delete(UserModel userModel) throws Exception {
		String resource = "mybatis_config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		IUserDao userDao=session.getMapper(IUserDao.class);
		userDao.delete(userModel);
		session.commit();
		session.close();
		
		System.out.println("执行删除");
	}
	@Override
	public List<UserModel> getListByAll() throws Exception {
		return DaoFactory.createUserDao().selectListByAll();
	}
	@Override
	public UserModel getById(String id) throws Exception {
		
		return DaoFactory.createUserDao().selectById(id);
	}
	@Override
	public void changePasswowrd(String id, String password) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void changrRole(String id, String role) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean validate(String id, String password) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void active(String id) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void disable(String id) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
