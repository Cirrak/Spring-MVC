package cs544.bank.advice;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import cs544.bank.logging.ILogger;

@Aspect
public class JMSLogAdvice {

ILogger logger;
	
	public void setLogger(ILogger logger) {
		this.logger = logger;
	}

	@Pointcut("execution(* cs544.bank.jms.*(..))")
	public void allJMS() {}
	
	@Pointcut("args(text")
	public void textArgs(String text) {}
	
	@Before("allJMS() && textArgs(text)")
	public void logMessage4ForD(String text) {
		logger.log(text);
	}
}
