package com.neusoft.busmis.security.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.busmis.security.factory.ServiceFactory;
import com.neusoft.busmis.security.model.UserModel;
import com.neusoft.busmis.security.service.IUserService;

/**
 * 用户登录处理控制器
 */
@WebServlet("/login.do")
public class UserLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id=request.getParameter("id");
		String password=request.getParameter("password");
		if(id==null||id.trim().length()==0||password==null||password.trim().length()==0) {
			response.sendRedirect("login.jsp");
		}
		else {
			try {
				IUserService userService=ServiceFactory.createUserService();
				//验证员工是否合法
				if(userService.validate(id, password)) { 
					UserModel um=userService.getById(id);
					request.getSession().setAttribute("user", um);
					response.sendRedirect("home/tomain.do"); //重定向到主页前分发控制器
					
				}
				else {
					response.sendRedirect("login.jsp"); //验证失败，重定向到登录页面
				}
			}
			catch(Exception e) {
				e.printStackTrace();
				response.sendRedirect("error/error.jsp");
			}
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
