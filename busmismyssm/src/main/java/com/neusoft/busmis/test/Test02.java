package com.neusoft.busmis.test;

import java.util.Date;

import com.neusoft.busmis.security.dao.IUserDao;
import com.neusoft.busmis.security.dao.impl.UserDaoImpl;
import com.neusoft.busmis.security.model.UserModel;

public class Test02 {

	public static void main(String[] args) {
		IUserDao ud=new UserDaoImpl();
		
		UserModel um=new UserModel();
		um.setId("DDDD");
		um.setPassword("DDDD");
		um.setName("DDDD");
		um.setRole("管理员");
		um.setAge(20);
		um.setJoinDate(new Date());
		try {
			ud.create(um);
			System.out.println("OK000");
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	}

}
