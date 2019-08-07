package com.neusoft.busmis.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neusoft.busmis.config.SpringContextConfig;
import com.neusoft.busmis.security.service.IModuleService;
import com.neusoft.busmis.security.service.IUserService;

/**
 * Servlet implementation class TestSpringServlet
 */
@WebServlet("/TestSpringServlet")
public class TestSpringServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		
		
		
		ApplicationContext acforxml=new ClassPathXmlApplicationContext("springcontext.xml");
		//ApplicationContext acforconfig=new AnnotationConfigApplicationContext(SpringContextConfig.class);
		//DataSource ds=acforxml.getBean("oaDataSource",DataSource.class);
		//DataSource ds01=acforconfig.getBean("getDataSource",DataSource.class);
		try {
			//IUserService us=acforconfig.getBean("userService04",IUserService.class);
			IModuleService ms=acforxml.getBean("ModuleService",IModuleService.class);
			
			
			List list=ms.getListByAll();
			System.out.println(list.size());
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		response.getWriter().append("测试Servlet ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
