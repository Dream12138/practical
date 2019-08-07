package com.neusoft.busmis.listener;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

import com.neusoft.busmis.factory.ConnectionFactoryWithC3P0;

/**
 * Application Lifecycle Listener implementation class ServerStartupListener
 *
 */
@WebListener
public class ServerStartupListener implements ServletContextListener {

  
	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
        
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event)  { 
    	
    	try {
			Context ctx=new InitialContext();
			DataSource ds=ConnectionFactoryWithC3P0.getDataSource();
			ctx.bind("c3p0ds", ds);
			
			ctx.close(); //断开与命名服务的连接
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
        
    }
	
}
