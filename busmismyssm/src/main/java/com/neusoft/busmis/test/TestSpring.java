package com.neusoft.busmis.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neusoft.busmis.config.SpringContextConfig;
import com.neusoft.busmis.security.model.UserModel;
import com.neusoft.busmis.security.service.IUserService;

public class TestSpring {
	
	public static void main(String[] args) {
		//创建Spring IoC容器，读取XML配置文件方式
		ApplicationContext aContext = new ClassPathXmlApplicationContext("springcontext.xml");
		ApplicationContext acforconfig = new AnnotationConfigApplicationContext(SpringContextConfig.class); 
		//取得IoC管理对象
		IUserService us = aContext.getBean("userServices", IUserService.class);
		IUserService us01 = aContext.getBean("userServices", IUserService.class);
		IUserService us02 = acforconfig.getBean("getServices", IUserService.class);
		
		System.out.println(us==us01);
		System.out.println(us==us02);
		
		try {
			UserModel um = us.getById("admin");
			System.out.println("11111111");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}