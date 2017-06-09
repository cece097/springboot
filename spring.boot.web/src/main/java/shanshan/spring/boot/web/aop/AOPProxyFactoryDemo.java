package shanshan.spring.boot.web.aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import shanshan.spring.boot.common.model.UserModel;
import shanshan.spring.boot.jpa.repository.UserRepository;
import shanshan.spring.boot.jpa.service.UserService;
import shanshan.spring.boot.jpa.service.impl.UserServiceImpl;

public class AOPProxyFactoryDemo {
	
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
	
	static MethodBeforeAdvice mbAdvice =new MethodBeforeAdvice(){  
		@Override
		public void before(Method arg0, Object[] arg1, Object arg2)
				throws Throwable {
			System.out.println("before^.............");
		}  
	};
	
}
