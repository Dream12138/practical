package com.neusoft.busmis.config;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//配置MVC 前端控制器方法02：

public class MVCStarter02 extends AbstractAnnotationConfigDispatcherServletInitializer {

	//取得全局的IoC容器的配置类
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { SpringContextConfig.class };
		
	}
	//取得Spring MVC DispactherServlet级别IoC容器的配置类
	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		return new Class<?>[] { SpringMVCContextConfig.class };
	}
	//设置前端控制器的请求地址
	@Override
	protected String[] getServletMappings() {
		
		System.out.println("映射地址。。。");
		
		return new String[]{"*.do"};
	}
	//启用文件上传解析器
	@Override
	protected void customizeRegistration(ServletRegistration.Dynamic registration)
	{
	      // Optionally also set maxFileSize, maxRequestSize, fileSizeThreshold
	      registration.setMultipartConfig(new MultipartConfigElement("d:/temp",2000000,3000000,0));
	}
	
	//为DispactherServlet配置过滤器
	protected Filter[] getServletFilters() {//注册过滤器
		//请求体文本数据按 UTF-8进行编码转换
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        //启用非GET和POST其他的请求方式，如PUT，DELETE,HEAD等HiddenHttpMethodFilter()
        return new Filter[]{characterEncodingFilter,new HiddenHttpMethodFilter() };
	}    
}
