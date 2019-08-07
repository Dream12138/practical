package com.neusoft.busmis.security.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.busmis.security.factory.ServiceFactory;
import com.neusoft.busmis.security.service.IUserService;

/**
 * 用户修改页面前分发控制器
 */
@WebServlet("/user/tomodify.do")
public class UserToModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id=request.getParameter("id");
		if(id!=null&&id.trim().length()>0) {
			IUserService us=ServiceFactory.createUserService();
			
			try {
				request.setAttribute("usermodel",us.getById(id));
				request.getRequestDispatcher("modify.jsp").forward(request, response);
				
			} catch (Exception e) {
				
				e.printStackTrace();
				response.sendRedirect("../error/error.jsp");
				
			}
		}
		else {
			response.sendRedirect("tolist.do");
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
