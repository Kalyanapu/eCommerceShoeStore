package ecommerce.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ecommerce.DAO.UserDAO;
import ecommerce.model.UserDetail;

public class UserJunitTest {
	static UserDAO userDAO;

	@BeforeClass

	public static void executeFirst() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("ecommerce");
		context.refresh();

		userDAO = (UserDAO) context.getBean("userDAO");

	}

	@Test
	public void registerUserTest() {

		UserDetail user = new UserDetail();
		user.setUserName("Model");
		user.setPassword("pass123");
		user.setEnabled(true);
		user.setRole("ROLE_USER");
		user.setCustomerName("Naveen kumar");
		user.setCustomerAddr("Machilipatnam");

		assertTrue("Problem in Registering user", userDAO.registerUser(user));

	}
}
