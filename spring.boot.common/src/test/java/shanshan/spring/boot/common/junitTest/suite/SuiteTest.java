package shanshan.spring.boot.common.junitTest.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import shanshan.spring.boot.common.junitTest.parameterizedtest.FibonacciTest1;
import shanshan.spring.boot.common.junitTest.parameterizedtest.FibonacciTest2;
import shanshan.spring.boot.common.junitTest.parameterizedtest.FibonacciTest3;

@RunWith(Suite.class)
//指定运行器
@Suite.SuiteClasses({ FibonacciTest1.class, FibonacciTest2.class, FibonacciTest3.class })
public class SuiteTest {
	
//	在JUnit4中，如果想要同时运行多个测试类，需要使用两个注解：
//
//	@RunWith(Suite.class)指定使用Suite运行器来运行测试；
//
//	@SuiteClasses(ClassName.class)指定运行哪些测试类。
//	测试类可以指定为Suite，这样JUnit会继续再去寻找里面的测试类，一直找到能够执行的Test Case并执行之。
}
