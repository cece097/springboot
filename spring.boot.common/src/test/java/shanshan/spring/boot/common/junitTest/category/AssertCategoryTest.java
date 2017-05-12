package shanshan.spring.boot.common.junitTest.category;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.ExcludeCategory;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import shanshan.spring.boot.common.junitTest.asserts.AssertTest;


@RunWith(Categories.class)
@SuiteClasses(AssertTest.class)
@IncludeCategory(AssertEqual.class)
@ExcludeCategory(AssertOther.class)
public class AssertCategoryTest {
	
}
