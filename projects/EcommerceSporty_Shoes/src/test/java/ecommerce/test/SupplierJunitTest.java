package ecommerce.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ecommerce.DAO.SupplierDAO;
import ecommerce.model.Category;
import ecommerce.model.Supplier;

public class SupplierJunitTest {
	static SupplierDAO supplierDAO;

	@BeforeClass
	public static void executeFirst() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("ecommerce");
		context.refresh();

		supplierDAO = (SupplierDAO) context.getBean("supplierDAO");

	}

	@Test
	public void addSupplierTest() {
		Supplier supplier = new Supplier();
		supplier.setSupplierId(5);
		supplier.setSupplierAddr("Delhi");
		supplier.setSupplierName("Naveen kumar");

		assertTrue("problem in adding Supplier", supplierDAO.addSupplier(supplier));
	}

}
