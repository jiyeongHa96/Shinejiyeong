package com.SkyBlue.common.advice;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CommonAdvice {
	private final Log logger = LogFactory.getLog(getClass());

	@Around("execution(* com.SkyBlue..serviceFacade.*.*(..)) || execution(* com.SkyBlue..applicationService.*.*(..)) || execution(* com.SkyBlue..dao.*.*(..))")
	public Object logging(ProceedingJoinPoint joinPoint) throws Throwable {
		String className = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();

		if (logger.isDebugEnabled()) {
			logger.debug(className + "." + methodName + "() 시작");
		}
		Object[] args = joinPoint.getArgs();
		if ((args != null) && (args.length > 0)) {
			for (int i = 0; i < args.length; i++) {
				logger.debug("Argument[" + i + "] : " + args[i]);
			}
		}

		Object retVal = joinPoint.proceed();
		if (logger.isDebugEnabled()) {
			logger.debug(className + "." + methodName + "() 종료");
		}
		return retVal;
	}

	@AfterThrowing(pointcut = "execution(* com.SkyBlue..serviceFacade.*.*(..))", throwing = "ex")
	public void afterThrowing(DataAccessException ex) throws Throwable {
		if (logger.isDebugEnabled()) {
			logger.debug("Caught : " + ex.getClass().getName());
		}
		if (logger.isErrorEnabled()) {
			logger.fatal(ex.getMessage());
		}
		throw ex;
	}
}
