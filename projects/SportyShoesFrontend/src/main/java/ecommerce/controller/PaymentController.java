package ecommerce.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ecommerce.DAO.CartDAO;
import ecommerce.DAO.OrderDAO;
import ecommerce.DAO.ProductDAO;
import ecommerce.DAO.UserDAO;
import ecommerce.model.CartItem;
import ecommerce.model.UserDetail;

@Controller
public class PaymentController {

	@Autowired
	CartDAO cartDAO;

	@Autowired
	ProductDAO productDAO;

	@Autowired
	UserDAO userDAO;

	@Autowired
	OrderDAO orderDAO;

	@RequestMapping("/checkout")
	public String checkOut(Model m, HttpSession session) {
		String username = (String) session.getAttribute("username");
		List<CartItem> cartItemList = cartDAO.listCartItems(username);

		m.addAttribute("cartItemList", cartItemList);
		m.addAttribute("grandTotal", this.getGrandTotal(cartItemList));

		UserDetail userDetail = userDAO.getUser(username);

		String address = userDetail.getCustomerAddr();
		m.addAttribute("addr", address);

		return "OrderConfirm";
	}

	@RequestMapping(value = "/UpdateAddr", method = RequestMethod.POST)
	public String UpdateAddr(@RequestParam("addr") String addr, Model m, HttpSession session) {
		String username = (String) session.getAttribute("username");
		List<CartItem> cartItemList = cartDAO.listCartItems(username);

		m.addAttribute("cartItemList", cartItemList);
		m.addAttribute("grandTotal", this.getGrandTotal(cartItemList));

		UserDetail userDetail = userDAO.getUser(username);
		userDetail.setCustomerAddr(addr);
		userDAO.updateUser(userDetail);

		String address = userDetail.getCustomerAddr();
		m.addAttribute("addr", address);
		return "OrderConfirm";
	}

	@RequestMapping(value = "/payment")
	public String paymentPage(Model m, HttpSession session) {
		return "Payment";
	}

	public int getGrandTotal(List<CartItem> cartList) {
		int grandTotal = 0, count = 0;
		while (count < cartList.size()) {
			grandTotal = grandTotal + (cartList.get(count).getQuantity() * cartList.get(count).getCartItemId());
			count++;
		}
		return grandTotal;
	}
}
