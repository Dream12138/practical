package com.neusoft.busmis.config;

import javax.annotation.PostConstruct;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.neusoft.busmis.factory.MyBatisFactory;
import com.neusoft.busmis.security.factory.ServiceFactory;
import com.neusoft.busmis.security.service.IUserService;
import com.neusoft.busmis.security.service.impl.UserServiceImpl;
//使用Java Config类方式管理IoC容器管理的Bean
@Configuration
@ComponentScan(basePackages = { "com.neusoft.busmis"})
@EnableAspectJAutoProxy
@MapperScan("com.neusoft.busmis.security.dao,com.neusoft.busmis.baseinfo.dao")
@EnableTransactionManagement
public class SpringContextConfig {
	//MyBatis集成Spring JavaConfig配置类模式
	//创建DataSource对象
	//使用C3P0框架
	@Autowired
	private ApplicationContext ctx=null;
	
	@Bean
	public DataSource crateDateSourceFromC3P0() throws Exception {
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		cpds.setDriverClass("com.mysql.cj.jdbc.Driver" );  //新的驱动类
		
		cpds.setJdbcUrl( "jdbc:mysql://localhost:3317/busmis?serverTimezone=GMT%2B8" );
		cpds.setUser("root");                                  
		cpds.setPassword("root");
		//设置连接池参数
		cpds.setMinPoolSize(1); //设置最小的连接个数                                     
		cpds.setAcquireIncrement(1); //每次新增的连接个数
		cpds.setMaxPoolSize(10); //设置最大的连接个数
		return cpds;
		
	}
	//使用DBCP2框架
	@Bean
	public DataSource crateDateSourceFromDBCP2() throws Exception {
		BasicDataSource bds = new BasicDataSource();  
		bds.setDriverClassName("com.mysql.jdbc.Driver");  
		bds.setUrl("jdbc:mysql://localhost:3317/busmis?serverTimezone=GMT%2B8");  
        bds.setUsername("root");  
        bds.setPassword("root");  
        
        bds.setInitialSize(1);  //设置初始的连接个数
        bds.setMaxTotal(2); //设置最大的连接个数   
        bds.setMaxIdle(2);  
        bds.setMaxWaitMillis(2000);//设置等待的最长时间，超时自动关闭连接
        return bds;
	}
	
	//使用JNDI查找Tomcat Server配置的数据库连接池
	public DataSource getDataSourceFromJNDI() {
		return null;
	}
	
	//定义MyBatis的SqlSessionFactory对象 Bean
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
	  SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
	  //设置数据源对象
	  factoryBean.setDataSource(crateDateSourceFromC3P0());
	  //设置配置文件
	  Resource configResource = new ClassPathResource("mybatis-config2.xml");
	  factoryBean.setConfigLocation(configResource);
	  //设置Mapper XML文件路径
	  PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
      String packageXMLConfigPath = PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX +"/mappers/**/*.xml";
	  
	  factoryBean.setMapperLocations(resolver.getResources(packageXMLConfigPath));
	  //设置Model类的别名
	  factoryBean.setTypeAliasesPackage("com.neusoft.busmis.security.model");
	  
	  return factoryBean.getObject();
	}
	
	//配置数据源的事务管理器
	@Bean
	public DataSourceTransactionManager transactionManager() throws Exception {
	  return new DataSourceTransactionManager(crateDateSourceFromC3P0());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Spring Bean定义时练习实验的代码
	/* 使用扫描方式，扫描有注解类的Bean，不需要单独定义每个Bean的方法 */
	//直接调用类的构造方法
	/*
	 * @Bean public IUserService getUserService() { return new UserServiceImpl(); }
	 */
	//调用工厂的静态方法
	/*
	 * @Bean public IUserService createUserServiceFromStaticFactory() { return
	 * ServiceFactory.createUserService(); }
	 */
	//调用工厂的动态方法
	/*
	 * @Bean public IUserService getUserServiceFromDynamicFactory() {
	 * 
	 * return new ServiceFactory().getUserService(); }
	 */
	
	//通过JNDI查找取得命名服务系统中注册的对象
	/*
	@Bean
	public DataSource getDataSource() throws Exception{
		Context ctx=new InitialContext();
		return (DataSource)ctx.lookup("java:comp/env/c3p0");
	}
	*/
	/*
	 * @Bean
	 * 
	 * @Primary public SqlSessionFactory getSSF() throws Exception{ return
	 * MyBatisFactory.getSqlSessionFactory(); }
	 */
	
	
	
	
	

}
