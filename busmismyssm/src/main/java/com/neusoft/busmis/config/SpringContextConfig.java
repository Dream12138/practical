package com.neusoft.busmis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.neusoft.busmis.security.service.IUserService;
import com.neusoft.busmis.security.service.impl.UserServiceImpl;

//使用Java Config类方式管理IoC容器管理的Bean
@Configuration
@ComponentScan(basePackages = "org.example")
public class SpringContextConfig {

	@Bean
	public IUserService getService() {
		return new UserServiceImpl();
	}
	
	@Bean
	public IUserService userService() throws Exception {
		return new UserServiceImpl();
	}
	
}
