package com.revature.project3.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserAspect {
	static Logger log;

	@Before("within(com.revature.project3.service.UserService)")
	public void adviseForAllServiceMethods(JoinPoint jp) {
		log = Logger.getLogger(jp.getClass().getName());
		log.info("Before the service method: " + jp.getSignature().getName());
	}

	@AfterReturning("within(com.revature.project3.service.UserService)")
	public void adviseForAllServiceMethodsReturn(JoinPoint jp) {
		log = Logger.getLogger(jp.getClass().getName());
		log.info("The serivce method: " + jp.getSignature().getName() + " returned successfully");
	}

	@AfterThrowing("within(com.revature.project3.service.UserService)")
	public void adviseForAllServiceMethodsException(JoinPoint jp) {
		log = Logger.getLogger(jp.getClass().getName());
		log.info("The serivce method: " + jp.getSignature().getName() + " threw an exception");
	}

}
