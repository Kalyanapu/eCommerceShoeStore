package ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

	@RequestMapping("/login")

	public String showLogin(Model m) {

		m.addAttribute("pageinfo", "Login");
		return "Login";
	}

	@RequestMapping("/register")

	public String showRegister(Model m) {

		m.addAttribute("pageinfo", "Login");

		return "Register";
	}

	@RequestMapping("/aboutus")

	public String showAboutUs(Model m) {

		m.addAttribute("pageinfo", "Login");

		return "AboutUs";
	}

	@RequestMapping("/contactus")

	public String showContactUs(Model m) {

		m.addAttribute("pageinfo", "Login");

		return "ContactUs";
	}

}
