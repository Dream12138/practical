package com.neusoft.busmis.factory;
//通过JNDI API查找命名服务中注册的连接池对象

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionFactoryWithJNDI {
	private static DataSource ds=null;
	static {
		try {
			Context ctx=new InitialContext();
			ds=(DataSource)ctx.lookup("java:comp/env/c3p0");
			ctx.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//从连接池取得连接
	public static Connection getConnection() throws Exception{
		return ds.getConnection();
	}
	

}
