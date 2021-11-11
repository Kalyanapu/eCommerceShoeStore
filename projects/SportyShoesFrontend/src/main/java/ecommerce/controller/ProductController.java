package ecommerce.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ecommerce.DAO.CategoryDAO;
import ecommerce.DAO.ProductDAO;
import ecommerce.model.Product;

@Controller
public class ProductController {

	@Autowired
	CategoryDAO categoryDAO;

	@Autowired
	ProductDAO productDAO;

	@RequestMapping("/product")

	public String showProduct(Model m) {
		Product product = new Product();
		m.addAttribute(product);

		List<Product> listProducts = productDAO.listProducts();
		m.addAttribute("productList", listProducts);
		m.addAttribute("categoryList", this.getCategories());
		m.addAttribute("pageinfo", "Manger Product");

		return "Product";
	}

	@RequestMapping(value = "/InsertProduct", method = RequestMethod.POST)

	public String insertProduct(@ModelAttribute("product") Product product,
			@RequestParam("pimage") MultipartFile filedet, Model m) {

		productDAO.addProduct(product);

		Product product1 = new Product();
		m.addAttribute(product1);
		m.addAttribute("pageinfo", "Manage Product");
		m.addAttribute("categoryList", this.getCategories());

		String imagepath = "D:\\java-01\\projects\\SportyShoesFrontend\\src\\main\\resources\\images";
		imagepath = imagepath + String.valueOf(product.getProductId() + ".jpg");

		File image = new File(imagepath);
		if (!filedet.isEmpty()) {
			try {
				byte buff[] = filedet.getBytes();
				FileOutputStream fos = new FileOutputStream(image);
				BufferedOutputStream bs = new BufferedOutputStream(fos);
				bs.write(buff);
				bs.close();
			} catch (FileNotFoundException e) {
				m.addAttribute("errorInfo", "Exception Occured during image loading" + e.getMessage());
				e.printStackTrace();
			}
		} else {
			m.addAttribute("errorInfo", "problem Occured during Image Uploading");
		}

		List<Product> listproducts = productDAO.listProducts();
		m.addAttribute("productList", listproducts);
		return "Product";
	}

	@RequestMapping(value = "Updateproduct", method = RequestMethod.POST)
	public String updateProduct(@ModelAttribute("product") Product product, Model m) {

		productDAO.updateProduct(product);
		Product product1 = new Product();
		m.addAttribute(product1);
		m.addAttribute("pageinfo", "Manage Product");
		m.addAttribute("categoryList", this.getCategories());

		List<Product> listproducts = productDAO.listProducts();
		m.addAttribute("productList", listproducts);
		return "Product";

	}

	@RequestMapping(value = "/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable("productId") int productId, Model m) {

		Product product = productDAO.getProduct(productId);
		productDAO.deleteProduct(product);
		Product product1 = new Product();
		m.addAttribute(product1);
		m.addAttribute("pageinfo", "Manage Product");
		m.addAttribute("categoryList", this.getCategories());

		List<Product> listproducts = productDAO.listProducts();
		m.addAttribute("productList", listproducts);
		return "Product";

	}

	@RequestMapping(value = "/editProduct/{productId}")
	public String editProduct(@PathVariable("productId") int productId, Model m) {

		Product product = productDAO.getProduct(productId);
		m.addAttribute(product);

		m.addAttribute("pageinfo", "Manage Product");
		m.addAttribute("categoryList", this.getCategories());

		return "UpdateProduct";
	}

	@RequestMapping(value = "/productDisplay")

	public String displayAllProduct(Model m) {
		m.addAttribute("pageinfo", "Product Catalog");

		List<Product> listproducts = productDAO.listProducts();
		m.addAttribute("productList", listproducts);

		return "ProductDisplay";

	}

	@RequestMapping(value = "/totalProductDisplay/{productId}")

	public String totalProductDisplay(@PathVariable("productId") int productId, Model m) {
		m.addAttribute("pageinfo", "Product Info");
		Product product = productDAO.getProduct(productId);
		m.addAttribute("product", "Product");

		return "TotalProductDisplay";

	}
}
