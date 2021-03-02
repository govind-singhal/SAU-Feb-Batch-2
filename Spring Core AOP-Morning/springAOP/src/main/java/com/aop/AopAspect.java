package com.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopAspect {

	@Pointcut("execution(* com.aop.Car.getCarName(..))")
	private void getCar() {
	}

	@After("getCar()")
	public void afterAdvice() {
		System.out.println("########################################");
		System.out.println("I am after advice");
		System.out.println("########################################");
	}

	@AfterReturning(pointcut = "execution(* com.aop.Car.*(..))", returning = "retVal")
	public void afterReturningAdvice(JoinPoint jp, Object retVal) {
		System.out.println("########################################");
		System.out.println("Method Signature1: " + jp.getSignature());
		System.out.println("Returning:" + retVal.toString());
		System.out.println("########################################");
	}

	@AfterThrowing(pointcut = "execution(* com.aop.Car..*(..))", throwing = "error")
	public void afterThrowingAdvice(JoinPoint jp, Throwable error) {
		System.out.println("########################################");
		System.out.println("Method Signature2: " + jp.getSignature());
		System.out.println("Exception: " + error);
		System.out.println("########################################");
	}

	@Around("getCar()")
	public void aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("########################################");
		System.out.println("Around advice");
		Object[] args = proceedingJoinPoint.getArgs();
		if (args.length > 0) {
			System.out.print("Arguments passed: ");
			for (int i = 0; i < args.length; i++) {
				System.out.print("arg " + (i + 1) + ": " + args[i]);
			}
		}

		Object result = proceedingJoinPoint.proceed(args);
		System.out.println("Returning " + result);
		System.out.println("########################################");
	}

}
