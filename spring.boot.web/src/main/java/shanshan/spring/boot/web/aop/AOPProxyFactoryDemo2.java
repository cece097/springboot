package shanshan.spring.boot.web.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.aop.MethodBeforeAdvice;


public class AOPProxyFactoryDemo2 {
	public static Object createProxy(Object target,MethodBeforeAdvice mbAdvice){  
		  
		return Proxy.newProxyInstance(
			target.getClass().getClassLoader(), 
			target.getClass().getInterfaces(), 
			new InvocationHandler(){//拦截器  
				  @Override 
				  public Object invoke(Object proxy,Method m,Object[] args) throws Throwable{  
				      mbAdvice.before(m,args,target);//方法执行前增强  
				      return m.invoke(target,args);//方法调用  
				  }
		});
	}
}
