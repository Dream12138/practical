package com.neusoft.busmis.aop;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.neusoft.busmis.security.model.UserModel;

//业务层 AOP Advice类
@Aspect
@Component
public class ServiceLayerAdvice {
		
	@Before("com.neusoft.busmis.aop.PointcutDefinition.serviceMethodForAll()")
	public void methodBeforeRun(JoinPoint jp) throws Exception{
		System.out.println("切入的类："+jp.getTarget().getClass().getName()+" 方法："+jp.getSignature().getName());
		System.out.println("这是方法前Advice执行了。。。。");
	}
	@After("com.neusoft.busmis.aop.PointcutDefinition.serviceMethodForAll()")
	public void methodAfterRun(JoinPoint jp) throws Exception{
		System.out.println("切入的类："+jp.getTarget().getClass().getName()+" 方法："+jp.getSignature().getName());
		System.out.println("这是方法后Advice执行了。。。。");
	}
	
	@AfterReturning(value="com.neusoft.busmis.aop.PointcutDefinition.serviceMethodForAll()",returning="result")
	public void methodAfterReturnRun(JoinPoint jp,Object result) throws Exception{
		System.out.println("切入的类："+jp.getTarget().getClass().getName()+" 方法："+jp.getSignature().getName());
		if(result!=null && result instanceof UserModel ) {
			System.out.println("返回用户的姓名："+ ((UserModel)result).getName());
		}
		
		System.out.println("这是方法返回后Advice执行了。。。。");
	}
	@AfterThrowing(value="com.neusoft.busmis.aop.PointcutDefinition.serviceMethodForAll()",throwing="ex")
	public void methonAfterThrowExceptionAdvice(JoinPoint jp,Exception ex) throws Exception{
		
		System.out.println("抛出的类："+jp.getTarget().getClass().getName()+" 方法："+jp.getSignature().getName()+" 异常信息："+ex.getMessage());
		System.out.println("这是方法异常抛出后Advice执行了。。。。");
	}
	
	@Around(value="com.neusoft.busmis.aop.PointcutDefinition.serviceMethodForAll()")
	public Object methodAroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
		//方法前切面代码
		System.out.println("这是环绕Adivce方法前执行了。。。。");
		Date start=new Date();
		
		Object result=pjp.proceed();
		Date end=new Date();
		System.out.println("环绕切入类："+pjp.getTarget().getClass().getName()+" 方法："+pjp.getSignature().getName()+" 方法执行时间："+(end.getTime()-start.getTime())+"毫秒");
		//方法后切面diam
		System.out.println("这是环绕Adivce方法后前执行了。。。。");
		return result;
		  
	}
	

	
}
