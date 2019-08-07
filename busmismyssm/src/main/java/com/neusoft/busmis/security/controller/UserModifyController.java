package com.neusoft.busmis.security.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.busmis.security.factory.ServiceFactory;
import com.neusoft.busmis.security.model.UserModel;
import com.neusoft.busmis.security.service.IUserService;

/**
 * 用户修改后处理控制器
 */
@WebServlet("/user/modify.do")
public class UserModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String sjoinDate=request.getParameter("joinDate");
		String role = request.getParameter("role");
		String age = request.getParameter("age");
		String password = request.getParameter("password");
		//取得其他属性参数
		
		//数据验证 推荐使用Java正则表达式进行

		//取得业务接口对象
		IUserService us=ServiceFactory.createUserService();
		try {
			//类型转换
			DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
			UserModel um=new UserModel();
			um.setId(id);
			um.setName(name);
			um.setPassword(password);
			um.setJoinDate(df.parse(sjoinDate));
			um.setAge(Integer.parseInt(age));
			um.setRole(role);
			
			us.modify(um);
			response.sendRedirect("tolist.do"); //重定向到列表前分发控制器
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			response.sendRedirect("../error/error.jsp");
			
		}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
