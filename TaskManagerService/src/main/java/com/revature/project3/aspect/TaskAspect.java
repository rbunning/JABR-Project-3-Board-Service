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
public class TaskAspect {
static Logger log;
	
	@Before("within(com.revature.project3.dao.TaskRepository)")
	public void adviseForAllDaoMethods(JoinPoint jp) {
		log = Logger.getLogger(jp.getClass().getName());
		log.info("Before the dao method: " + jp.getSignature().getName());
	}

	@AfterReturning("within(com.revature.project3.dao.TaskRepository)")
	public void adviseForAllDaoMethodsReturn(JoinPoint jp) {
		log = Logger.getLogger(jp.getClass().getName());
		log.info("The dao method: " + jp.getSignature().getName() + " returned successfully");
	}

	@AfterThrowing("within(com.revature.project3.dao.TaskRepository)")
	public void adviseForAllDaoMethodsException(JoinPoint jp) {
		log = Logger.getLogger(jp.getClass().getName());
		log.info("The Ctrl method: " + jp.getSignature().getName() + " threw an exception");
	}
	
	@Before("within(com.revature.project3.controller.*)")
	public void adviseForAllCtrlMethods(JoinPoint jp) {
		log = Logger.getLogger(jp.getClass().getName());
		log.info("Before the Ctrl method: " + jp.getSignature().getName());
	}

	@AfterReturning("within(com.revature.project3.controller.*)")
	public void adviseForAllCtrlMethodsReturn(JoinPoint jp) {
		log = Logger.getLogger(jp.getClass().getName());
		log.info("The Ctrl method: " + jp.getSignature().getName() + " returned successfully");
	}

	@AfterThrowing("within(com.revature.project3.controller.*)")
	public void adviseForAllCtrlMethodsException(JoinPoint jp) {
		log = Logger.getLogger(jp.getClass().getName());
		log.info("The Ctrl method: " + jp.getSignature().getName() + " threw an exception");
	}
}
