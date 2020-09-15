package com.company.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAdvice {
	private static final Logger logger = LoggerFactory.getLogger(LogAdvice.class);
	
	@Around(    "execution(* com.company.com.*Controller.*(..))"+
			" or execution(* com.company.contorller.*Controller.*(..))")
	public Object logShow(ProceedingJoinPoint pj) throws Throwable{
		long start = System.currentTimeMillis();
		long end = 0;
		Object result= null;
		String type="", name="", parameter="", comm="";
		result=pj.proceed();
		type=pj.getSignature().getDeclaringTypeName();
		name=pj.getSignature().getName();
		parameter=Arrays.deepToString(pj.getArgs());
		if(type.contains("Controller")) { comm="Controller : " ;}
		else if(type.contains("Dao")) { comm="Dao : " ;}
		else if(type.contains("Service")) { comm="Service : " ;}
		end = System.currentTimeMillis();
		logger.info("-----------------------------------------------------");
		logger.info(comm + type + name + "()");
		logger.info("parameter : " + parameter);
		logger.info("runningTime : " + (end-start));
		logger.info("-----------------------------------------------------");
		return result;
	}
}
