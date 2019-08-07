package com.neusoft.busmis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//Spring MVC DispatcherServlet级别的IoC容器配置类
//配置Controller，View解析器，JSON解析器等。
@Configuration
@ComponentScan(basePackages = { "com.neusoft.busmis"})
//启用MVC注解类解析
@EnableWebMvc
public class SpringMVCContextConfig implements WebMvcConfigurer {
	
	//配置JSP的内置解析器
	@Bean
	public ViewResolver configureViewResolver() {
	     InternalResourceViewResolver viewResolve = new InternalResourceViewResolver();
	     viewResolve.setPrefix("/");
	     viewResolve.setSuffix(".jsp");
	 
	     return viewResolve;
	}
	//配置文件上传解析器
	@Bean(name = "multipartResolver")
	public StandardServletMultipartResolver resolver() {
			return new StandardServletMultipartResolver();
	}
	
	//配置全局CORS
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
		.allowedOrigins("*")
		.allowedMethods("GET","POST","PUT", "DELETE","HEAD");
		
		
		System.out.println("全局CORS设置。。。");
	}
	

}
