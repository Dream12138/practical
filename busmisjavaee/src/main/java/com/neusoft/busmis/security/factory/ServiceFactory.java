package com.neusoft.busmis.security.factory;

import com.neusoft.busmis.security.service.IUserService;
import com.neusoft.busmis.security.service.impl.UserServiceImpl;

//安全模块的Service工厂类
public class ServiceFactory {
	//创建用户的业务接口对象
	public static IUserService createUserService() {
		return new UserServiceImpl();
	}
	//其他业务接口对象的创建

}
