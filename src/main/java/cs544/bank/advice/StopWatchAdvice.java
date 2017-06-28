package cs544.bank.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;

@Aspect
public class StopWatchAdvice {

	@Around("within(cs544.bank.service.*)")
	public Object methodTimer(ProceedingJoinPoint joinpoint)
	throws Throwable {
		StopWatch sw = new StopWatch();
		sw.start(joinpoint.getSignature().getName());
		Object object = joinpoint.proceed();
		sw.stop();
		
		long totalTime = sw.getLastTaskTimeMillis();
		System.out.println("Time to execute " + joinpoint.getSignature().getName() + " = " + totalTime + "ms");
		return object;
	}
}
