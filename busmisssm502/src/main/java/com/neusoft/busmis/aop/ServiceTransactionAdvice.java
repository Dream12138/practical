package com.neusoft.busmis.aop;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.neusoft.busmis.factory.MyBatisFactory;
import com.neusoft.busmis.security.dao.IModuleDao;
import com.neusoft.busmis.security.service.impl.ModuleServiceImpl;

//@Aspect
//@Component
public class ServiceTransactionAdvice {
	@Autowired
	private SqlSessionFactory ssf=null;
	
	@Around("com.neusoft.busmis.aop.PointcutDefinition.serviceMethodForModule()")
	public Object serviceTransactionProcess(ProceedingJoinPoint pjp) throws Throwable{
		
		System.out.println("模块业务切面类。。。");
		SqlSession session = ssf.openSession();
		IModuleDao moduleDao=session.getMapper(IModuleDao.class);
		if(pjp.getTarget() instanceof ModuleServiceImpl) {
			//((ModuleServiceImpl)pjp.getTarget()).setModuleDao(moduleDao);
			
		}
		
		Object result=pjp.proceed(); //目标对象方法
		session.commit();
		session.close();
		
		return result;
	}

}
