package shanshan.spring.boot.common.junitTest.asserts;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.hamcrest.core.CombinableMatcher;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import shanshan.spring.boot.common.junitTest.category.AssertEqual;
import shanshan.spring.boot.common.junitTest.category.AssertOther;


public class AssertTest {
	
	@Category(AssertEqual.class)
	@Test
	public void testAssertArrayEquals() {
	    byte[] expected = "trial".getBytes();
	    byte[] actual = "trial".getBytes();
	    assertArrayEquals("failure - byte arrays not same", expected, actual);
	}
	
	@Category(AssertEqual.class)
	@Test
	public void testAssertEquals() {
	    assertEquals("failure - strings are not equal", "text", "text");
	}
	
	@Category(AssertOther.class)
	@Test
	public void testAssertFalse() {
	    assertFalse("failure - should be false", false);
	}
	
	@Category(AssertOther.class)
	@Test
	public void testAssertNotNull() {
	    assertNotNull("should not be null", new Object());
	}
	
	@Category(AssertEqual.class)
	@Test
	public void testAssertNotSame() {
	    assertNotSame("should not be same Object", new Object(), new Object());
	}
	
	@Category(AssertOther.class)
	@Test
	public void testAssertNull() {
	    assertNull("should be null", null);
	}
	
	@Category(AssertEqual.class)
	@Test
	public void testAssertSame() {
	    Integer aNumber = Integer.valueOf(768);
	    assertSame("should be same", aNumber, aNumber);
	}
	
	// JUnit Matchers assertThat
	@Category(AssertEqual.class)
	@Test
	public void testAssertThatBothContainsString() {
	    assertThat("albumen", both(containsString("a")).and(containsString("b")));
	}
	
	@Category(AssertEqual.class)
	@Test
	public void testAssertThatHasItems() {
	    assertThat(Arrays.asList("one", "two", "three"), hasItems("one", "three"));
	}
	
	@Category(AssertEqual.class)
	@Test
	public void testAssertThatEveryItemContainsString() {
	    assertThat(Arrays.asList(new String[] { "fun", "ban", "net" }), everyItem(containsString("n")));
	}
	
	// Core Hamcrest Matchers with assertThat
	@Category(AssertOther.class)
	@Test
	public void testAssertThatHamcrestCoreMatchers() {
	    assertThat("good", allOf(equalTo("good"), startsWith("good")));
	    assertThat("good", not(allOf(equalTo("bad"), equalTo("good"))));
	    assertThat("good", anyOf(equalTo("bad"), equalTo("good")));
	    assertThat(7, not(CombinableMatcher.<Integer> either(equalTo(3)).or(equalTo(4))));
	    assertThat(new Object(), not(sameInstance(new Object())));
	}
	
	@Category(AssertOther.class)
	@Test
	public void testAssertTrue() {
	    assertTrue("failure - should be true", true);
	}
}
