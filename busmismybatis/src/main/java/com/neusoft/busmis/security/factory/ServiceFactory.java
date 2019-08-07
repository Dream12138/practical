package com.neusoft.busmis.security.factory;

import com.neusoft.busmis.security.service.IFunctionService;
import com.neusoft.busmis.security.service.IModuleService;
import com.neusoft.busmis.security.service.IRoleService;
import com.neusoft.busmis.security.service.IUserService;
import com.neusoft.busmis.security.service.impl.FunctionServiceImpl;
import com.neusoft.busmis.security.service.impl.ModuleServiceImpl;
import com.neusoft.busmis.security.service.impl.RoleServiceImpl;
import com.neusoft.busmis.security.service.impl.UserServiceImpl;

//安全模块的Service工厂类
public class ServiceFactory {
	//创建用户的业务接口对象
	public static IUserService createUserService() {
		return new UserServiceImpl();
	}
	
	//创建FunctionService层对象
	public static IFunctionService creatFunctionService() {
		return new FunctionServiceImpl;
	}

	public static IRoleService createRoleService() {
		return new RoleServiceImpl();
	}
	
	public static IModuleService createModuleService() {
		return new ModuleServiceImpl();
	}
}
