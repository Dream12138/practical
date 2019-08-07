package com.neusoft.busmis.security.factory;

import com.neusoft.busmis.security.dao.IUserDao;
import com.neusoft.busmis.security.dao.impl.UserDaoImpl;

//安全模块的DAO工厂类
public class DaoFactory {
	
	//创建用户的DAO接口对象
	public static IUserDao  createUserDao() {
		return new UserDaoImpl();
	}
	//其他DAO接口对象创建方法。。。。
	

}
