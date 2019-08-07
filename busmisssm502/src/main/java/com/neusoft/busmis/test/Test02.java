package com.neusoft.busmis.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.neusoft.busmis.security.dao.IUserDao;
import com.neusoft.busmis.security.factory.ServiceFactory;
import com.neusoft.busmis.security.model.FunctionModel;
import com.neusoft.busmis.security.model.ModuleModel;
import com.neusoft.busmis.security.model.RoleModel;
import com.neusoft.busmis.security.model.UserModel;
import com.neusoft.busmis.security.service.IFunctionService;
import com.neusoft.busmis.security.service.IModuleService;
import com.neusoft.busmis.security.service.IRoleService;
import com.neusoft.busmis.security.service.IUserService;

public class Test02 {

	public static void main(String[] args) {
		
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		IFunctionService fs=ServiceFactory.createFunctionService();
		IRoleService rs=ServiceFactory.createRoleService();
		IUserService us=ServiceFactory.createUserService();
		IModuleService ms=ServiceFactory.createModuleService();
		
		FunctionModel fm=new FunctionModel();
		ModuleModel mm=new ModuleModel();
		mm.setNo(1);
		fm.setName("测试的功能");
		fm.setUrl("../test/test.do");
		fm.setModule(mm); //设置关联的对一对象
		
		
		RoleModel rm=new RoleModel();
		rm.setName("员工");
		
		
		
		
		
		
		UserModel um=new UserModel();
		um.setId("DDDD");
		um.setPassword("DDDD");
		um.setName("DDDD");
		
		um.setAge(20);
		um.setJoinDate(new Date());
		try {
			//fs.create(fm);
			//rs.add(rm);
			//us.addRoles("55",new int[] {1,2,3});
			//List<FunctionModel> funs=fs.selectListByAllWithModuleByNestedResultMap();
			/*
			List<ModuleModel> modules=ms.getListByAllWithRolesByNestedResultMap();
			for(ModuleModel mmm:modules) {
				if(mmm.getRoles()!=null) {
					System.out.println(mmm.getName()+" :角色个数:"+mmm.getRoles().size());
				}
				else {
					System.out.println(mmm.getName()+" :角色个数:0");
				}
				
			}
			*/
			//System.out.println(us.validate("55","55"));
			/*
			List<ModuleModel> modules=us.getModuleListByUser("55");
			for(ModuleModel mmm:modules) {
				System.out.println(mmm.getName()+" 功能个数:"+mmm.getFunctions().size());
			}
			System.out.println(modules.size());
			*/
			List<UserModel> userList=us.getListByCondition(1, "",0, 40,null, null);
			System.out.println(userList.size());
			
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	}

}
