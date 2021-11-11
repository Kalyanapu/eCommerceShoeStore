package ecommerce.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ecommerce.DAO.ProductDAO;
import ecommerce.model.Product;

public class ProductJunitTest {
	static ProductDAO productDAO;

	@BeforeClass
	public static void executeFirst() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("ecommerce");
		context.refresh();

		productDAO = (ProductDAO) context.getBean("productDAO");

	}

	@Test
	public void addProductTest() {

		Product product = new Product();
		product.setProductName("Shoes");
		product.setProductDesc("All imported brands");
		product.setPrice(1200);
		product.setStock(50);
		product.setCategoryId(18);
		product.setSupplierId(20);

		assertTrue("Problem in adding product", productDAO.addProduct(product));

	}
}
