package cs544.bank.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import cs544.bank.logging.ILogger;

@Aspect
public class DAOLogAdvice {

	ILogger logger;
	
	public void setLogger(ILogger logger) {
		this.logger = logger;
	}

	@Before("execution(* cs544.bank.dao.AccountDAO.*(..))")
	public void logDAOCall(JoinPoint joinPoint)
	throws Throwable {
		logger.log(joinPoint.getSignature().toShortString());
	}


	
	

}
