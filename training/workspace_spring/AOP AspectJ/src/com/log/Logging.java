package com.log;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect //only class can be Aspect
public class Logging {
		//following is def of POINTCUT to select all methods
		//ie: advice called for all methods
	
		@Pointcut("execution(* com.log.*.*(..))") //and bean (emp)
		private void selectAll_1(){
			
		}
		
		//Method to execute after selected method execution
		@Before("selectAll_1()")
		public void afterAdvice(){
			System.out.println("Student advice has already been set up");
		}
		
		//Method to execute when any method RETURNS
		@AfterReturning(pointcut="selectAll_1()", returning="retVal")
		public void afterReturningAdvice(Object retVal){
			System.out.println("Returning: "+retVal.toString());
		}
		
		//Method to be executed if an exception is thrown by a method
		@AfterThrowing(pointcut="selectAll_1()", throwing="ex")
		public void afterThrowingAdvice(IllegalArgumentException ex){
			System.out.println("There has been an exception: "+ex.toString());
		}
}
