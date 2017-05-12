package shanshan.spring.boot.common.junitTest.mock;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MockAnnotationTest {
	
	@Mock 
	private List list;
	
	@Test 
	public void shouldDoSomething() {  
		list.add(100); 
		Mockito.verify(list).add(100);
		Mockito.verify(list).add(101);  //报错，没有调用过add(101)
	} 
	
}
