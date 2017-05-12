package shanshan.spring.boot.web.aop;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 日志处理
 * @author zss
 * @date 2017年4月20日
 */
@Component
@Aspect
public class LogAspect {
	
	private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);
	
	/**
	 * 切面定义
	 */
	@Pointcut("@within(org.springframework.stereotype.Controller)")
	private void pointCutMethod() {
	}
	
	//声明前置通知
	@Before("pointCutMethod()")
	public void doBefore(JoinPoint point) {
		return;
	}

	//声明后置通知
	@AfterReturning(pointcut = "pointCutMethod()", returning = "returnValue")
	public void doAfterReturning(JoinPoint point,Object returnValue) {
	}

	//声明例外通知
	@AfterThrowing(pointcut = "pointCutMethod()", throwing = "e")
	public void doAfterThrowing(Exception e) {
	}

	//声明最终通知
	@After("pointCutMethod()")
	public void doAfter() {
	}

	//声明环绕通知
	@Around("pointCutMethod()")
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		long start = System.currentTimeMillis();
		//正在执行的类名
		String className = pjp.getTarget().getClass().getName();
		//正在执行的方法名
		String methodString = pjp.getSignature().getName();
		List<?> args = Arrays.asList(pjp.getArgs());
		
		logger.info("{}.{}({}) on {}", 
				className,
				methodString,
				args,
				start);
		
		Object result = pjp.proceed();
		
		logger.info("{}.{}({}): {} in {}ms",
					className,
					methodString,
					args,
					result,
				    System.currentTimeMillis() - start);
		return result;
	}
}
