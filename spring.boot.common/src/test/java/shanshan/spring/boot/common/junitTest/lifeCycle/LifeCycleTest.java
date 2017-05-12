package shanshan.spring.boot.common.junitTest.lifeCycle;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LifeCycleTest {
	
	public LifeCycleTest()
	{
		super();
		System.out.println("<<Class Constructor>>");
	}

	@BeforeClass
	public static void beforeClassM()
	{
		System.out.println("<<Before Class>>");
	}
	

	@Before
	public void beforeM()
	{
		System.out.println("<<Before>>");
	}
	

	@AfterClass
	public static void afterClassM()
	{
		System.out.println("<<After Class>>");
	}
	

	@After
	public void after()
	{
		System.out.println("<<After>>");
	}
	
	@Test
	public void testMethod1()
	{
		System.out.println("Test Method 1.");
	}
	
	@Test
	public void testMethod2()
	{
		System.out.println("Test Method 2.");
	}
	
	//运行结果
//	<<Before Class>>  修饰static的方法，在整个类执行之前执行该方法一次

//	<<Class Constructor>>  每个测试用例都会重新创建当前的Class实例
//	<<Before>>
//	Test Method 1.
//	<<After>>

//	<<Class Constructor>>
//	<<Before>>
//	Test Method 2.
//	<<After>>

//	<<After Class>>
}
