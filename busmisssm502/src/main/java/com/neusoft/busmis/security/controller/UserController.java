package com.neusoft.busmis.security.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.neusoft.busmis.security.model.UserModel;
import com.neusoft.busmis.security.service.IUserService;

//用户的控制类
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService us=null;
	
	
	
	@RequestMapping("/tolist")
	public String tolist(Model model) throws Exception{
		System.out.println("to list");
		List<UserModel> userList=us.getListByAll();
		model.addAttribute("userList",  userList);
		return "user/list";
		
	}
	
	@RequestMapping("/toregister")
	public String toregister() throws Exception{
		System.out.println("toregister");
		return "user/register";
		
	}
	//有头像上传的用户注册
	@RequestMapping("/register")
	public String register(UserModel um, @RequestParam(required=false) MultipartFile  userphoto) throws Exception{
		
		if(userphoto==null||userphoto.isEmpty()) {
			System.out.println("无文件");
		}
		else {
			//取得文件的名
			String fileName=userphoto.getOriginalFilename();
			//取得文件的类型
			String contentType=userphoto.getContentType();
			um.setPhoto(userphoto.getBytes()); //设置到Model对象的属性。
			um.setPhotoFileName(fileName);
			um.setPhotoContentType(contentType);
			//把文件保存到指定的目录e:\\upload
			userphoto.transferTo(new File("e:/upload/"+fileName));
			
			
			
		}
		us.register(um);
		System.out.println("注册处理");
		return "user/list";
		
	}
	
	//用户头像的下载
	@RequestMapping("/downphoto")
	public void downphoto01(String contentType,String fileName,HttpServletResponse response) throws Exception{
		 response.setContentType(contentType);
		 OutputStream out=response.getOutputStream();
		 
		 InputStream  in=new FileInputStream("e:/upload/"+fileName);
		 int data=0;
		 while((data=in.read())!=-1) {
			 out.write(data);
		 }
		 in.close();
		 out.flush();
		 out.close();
		
	}
	
	
	
	

}
