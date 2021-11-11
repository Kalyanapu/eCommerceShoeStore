package ecommerce.controller;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ecommerce.DAO.ProductDAO;
import ecommerce.model.Product;

@Controller
public class UserController<Authentication, SecurityContext, GrantedAuthority> {

	@Autowired
	ProductDAO productDAO;

	@RequestMapping(value = "/userhome")

	public String showUserHome(Model m, HttpSession session) {

		m.addAttribute("pageinfo", "Product catalog");
		List<Product> listProducts = productDAO.listProducts();
		m.addAttribute("productList", listProducts);

		return "UserHome";

	}
	

}
