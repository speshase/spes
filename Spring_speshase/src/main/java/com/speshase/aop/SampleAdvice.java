package com.speshase.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.speshase.controller.BoardController;

@Component
@Aspect
public class SampleAdvice {
	
	private static final Logger logger =
			LoggerFactory.getLogger(BoardController.class);
	
	@Before("execution(* com.speshase.service.MessageService*.*(..))")
	public void startLog(JoinPoint jp) {
		logger.info("----------Before----------");
		logger.info("��="+Arrays.toString(jp.getArgs()));
		
	}
	
	@Around("execution(* com.speshase.service.MessageService*.*(..))")
	public Object timeLog(ProceedingJoinPoint pjp) throws Throwable {
		
		long startTime = System.currentTimeMillis();
		logger.info("������="+Arrays.toString(pjp.getArgs()));

		Object result = pjp.proceed(); //�� ���� Advice�� ����.

		long endTime = System.currentTimeMillis();
		logger.info("ü��="+pjp.getSignature().getName()+ " : " + (endTime - startTime));
		logger.info("============Hi============");
		
		return pjp;
		
	}
}
