package com.neusoft.busmis.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

//切入点定义类
@Aspect
public class PointcutDefinition {
	//模块baseinfo所有的业务层
	@Pointcut("execution(* com.neusoft.busmis.baseinfo.service.impl.*.*(..))")
	public void serviceMethodForBaseInfoModule() {
		
	}
	
	//模块baseinfo所有的业务层
	@Pointcut("execution(* com.neusoft.busmis.*.service.impl.*.*(..))")
	public void serviceMethodForAll() {
		
	}
	
	//模块baseinfo所有的业务层
	@Pointcut("execution(* com.neusoft.busmis.*.service.impl.ModuleServiceImpl.*(..))")
	public void serviceMethodForModule() {
			
	}

}
