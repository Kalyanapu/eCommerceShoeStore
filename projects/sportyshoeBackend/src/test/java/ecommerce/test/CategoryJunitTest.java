package ecommerce.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ecommerce.DAO.CategoryDAO;
import ecommerce.model.Category;

public class CategoryJunitTest {

	static CategoryDAO categoryDAO;

	@BeforeClass
	public static void executeFirst() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("ecommerce");
		context.refresh();
       
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	@Test
	public void addCategoryTest() {
		Category category = new Category();
		category.setCategoryName("shoes");
		category.setCategoryDesc("Best Quality shoes");

		assertTrue("Problem in adding Category", categoryDAO.addCategory(category));
	}

}
