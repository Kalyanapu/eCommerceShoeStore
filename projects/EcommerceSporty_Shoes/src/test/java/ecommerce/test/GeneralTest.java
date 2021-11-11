package ecommerce.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GeneralTest {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        
		context.scan("ecommerce");
		context.refresh();
	}

}
