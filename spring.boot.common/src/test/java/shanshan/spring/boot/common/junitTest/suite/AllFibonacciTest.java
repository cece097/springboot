package shanshan.spring.boot.common.junitTest.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses(SuiteTest.class)
// 除了指定类，也可以指定套件类
public class AllFibonacciTest {

}
