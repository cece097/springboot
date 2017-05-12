package shanshan.spring.boot.common.junitTest.mock;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class MockSimpleTest {
	
	@Test
	public void mockTest(){
		List mock = Mockito.mock(List.class);  
		Mockito.when(mock.get(0)).thenReturn(1);  
		assertEquals("预期返回1", 1, mock.get(0));
		Mockito.when(mock.get(1)).thenThrow(new RuntimeException("test excpetion")); 
	}
	
	@Test  
	public void argumentMatcherTest(){  
	    List<String> list = Mockito.mock(List.class);  
	    Mockito.when(list.get(Mockito.anyInt())).thenReturn("hello","world");  
	    String result = list.get(0)+list.get(1);  
	    Mockito.verify(list,Mockito.times(2)).get(Mockito.anyInt());  
	    Assert.assertEquals("helloworld", result);  
	} 
	
	//如果使用参数匹配器，那么所有的参数都要使用参数匹配器
	@Test  
	public void argumentMatcherTest2(){  
	    Map<Integer,String> map = Mockito.mock(Map.class);  
	    Mockito.when(map.put(Mockito.anyInt(),Mockito.anyString())).thenReturn("hello");//anyString()替换成"hello"就会报错  
//	    Mockito.when(map.put(Mockito.anyInt(),"hello")).thenReturn("hello");//anyString()替换成"hello"就会报错  
	    map.put(1, "world");  
	    Mockito.verify(map).put(Mockito.eq(1), Mockito.eq("world")); //eq("world")替换成"world"也会报错  
	} 
	
	@Test  
	public void verifyInvocate(){  
	      
	    List<String> mockedList = Mockito.mock(List.class);  
	    
	    //using mock   
	    mockedList.add("once");  
	    mockedList.add("twice");  
	    mockedList.add("twice");  
	       
	    mockedList.add("three times");  
	    mockedList.add("three times");  
	    mockedList.add("three times");  
	       
	     /** 
	      * 基本的验证方法 
	      * verify方法验证mock对象是否有没有调用mockedList.add("once")方法 
	      * 不关心其是否有返回值，如果没有调用测试失败。 
	      */  
	    Mockito.verify(mockedList).add("once");   
	    Mockito.verify(mockedList, Mockito.times(1)).add("once");//默认调用一次,times(1)可以省略  
	       
	       
	    Mockito.verify(mockedList, Mockito.times(2)).add("twice");  
	    Mockito.verify(mockedList, Mockito.times(3)).add("three times");  
	       
	    //never()等同于time(0),一次也没有调用  
	    Mockito.verify(mockedList, Mockito.times(0)).add("never happened");  
	       
	    //atLeastOnece/atLeast()/atMost()  
	    Mockito.verify(mockedList, Mockito.atLeastOnce()).add("three times");  
	    Mockito.verify(mockedList, Mockito.atLeast(2)).add("twice");  
	    Mockito.verify(mockedList, Mockito.atMost(5)).add("three times");  
	  
	} 
}
