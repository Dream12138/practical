package com.neusoft.busmis.test;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neusoft.busmis.config.SpringContextConfig;
import com.neusoft.busmis.security.factory.ServiceFactory;
import com.neusoft.busmis.security.model.ModuleModel;
import com.neusoft.busmis.security.model.UserModel;
import com.neusoft.busmis.security.service.IModuleService;
import com.neusoft.busmis.security.service.IUserService;

public class TestSpring {

	public static void main(String[] args) {

		//创建Spring IoC容器,读取XML配置文件方式
		//ApplicationContext ac=new ClassPathXmlApplicationContext("springcontext.xml");
		ApplicationContext ac=new AnnotationConfigApplicationContext(SpringContextConfig.class);
		
		//取得IoC管理的对象
		IModuleService ms=ac.getBean("ModuleService",IModuleService.class);
		
		

		
		
		try {
			
			ModuleModel mm=new ModuleModel();
			mm.setName("模块300");
			
			ms.add(mm);
			
			List<ModuleModel> list=ms.getListByAll();
			System.out.println(list.size());
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
