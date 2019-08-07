package com.neusoft.busmis.test;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.busmis.security.dao.IUserDao;

import com.neusoft.busmis.security.factory.ServiceFactory;
import com.neusoft.busmis.security.model.UserModel;
import com.neusoft.busmis.security.service.IUserService;

/**
 * Servlet implementation class Test01
 */
@WebServlet("/Test01")
public class Test01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IUserService us=ServiceFactory.createUserService();
		
		/*
		UserModel um=new UserModel();
		um.setId("EEE");
		um.setPassword("EEE");
		um.setName("EEE");
		um.setRole("管理员");
		um.setAge(20);
		um.setJoinDate(new Date());
		*/
		try {
			//ud.create(um);
			List<UserModel> list=us.getListByAll();
			System.out.println(list.size());
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
