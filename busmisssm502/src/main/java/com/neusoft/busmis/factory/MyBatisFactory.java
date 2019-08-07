package com.neusoft.busmis.factory;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisFactory {
	private static SqlSessionFactory ssf=null;
	static {
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			//使用SqlSessionFactoryBuilder读取配置文件，创建新的SqlSessionFactory对象。
			ssf=new SqlSessionFactoryBuilder().build(inputStream);
			System.out.println("SSF OK");
			System.out.println(ssf==null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		return ssf;
	}
	
	public static SqlSession getSession() {
		return ssf.openSession();
	}
	

}
