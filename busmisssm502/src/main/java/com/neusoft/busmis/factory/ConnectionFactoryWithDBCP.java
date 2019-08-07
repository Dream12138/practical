package com.neusoft.busmis.factory;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

//使用DBCP连接池框架的连接工厂
public class ConnectionFactoryWithDBCP {
	private static DataSource ds=null;
	static {
		BasicDataSource bds = new BasicDataSource();  
		bds.setDriverClassName("com.mysql.jdbc.Driver");  
		bds.setUrl("jdbc:mysql://localhost:3317/busmis?serverTimezone=GMT%2B8");  
        bds.setUsername("root");  
        bds.setPassword("root");  
        
        bds.setInitialSize(1);  //设置初始的连接个数
        bds.setMaxTotal(2); //设置最大的连接个数   
        bds.setMaxIdle(2);  
        bds.setMaxWaitMillis(2000);//设置等待的最长时间，超时自动关闭连接
        ds=bds;
	}
	//从连接池取得连接
	public static Connection getConnection() throws Exception{
		return ds.getConnection();
	}

}
