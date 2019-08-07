package com.neusoft.busmis.factory;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisFactory {

	private static SqlSessionFactory ssf = null;
	static {
		String resourceString = "mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resourceString);
			
			//使用SqlSessionFactoryBulider读取配置文件，创建新的SqlSessionFactory对象
			ssf = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	private static SqlSession getSession() {
		return ssf.openSession();
	}
}
