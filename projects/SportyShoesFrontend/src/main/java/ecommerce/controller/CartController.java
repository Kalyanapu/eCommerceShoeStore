package ecommerce.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ecommerce.DAO.CartDAO;
import ecommerce.DAO.ProductDAO;
import ecommerce.model.CartItem;
import ecommerce.model.Product;

@Controller
public class CartController {

	@Autowired
	CartDAO cartDAO;

	@Autowired
	ProductDAO productDAO;

	@RequestMapping("/cart")

	public String showCart(Model m, HttpSession session) {
		String username = (String) session.getAttribute("username");
		List<CartItem> cartItemList = cartDAO.listCartItems(username);

		m.addAttribute("cartItemList", cartItemList);
		m.addAttribute("grandTotal", this.getGrandTotal(cartItemList));

		return "Cart";

	}

	@RequestMapping("/addToCart/{productId}")
	public String addToCart(@PathVariable("poductId") int productId, @RequestParam("quantity") int quantity,
			HttpSession session, Model m) {
		Product product = productDAO.getProduct(productId);
		String username = (String) session.getAttribute("username");

		CartItem cartItem = new CartItem();
		cartItem.setProductId(product.getProductId());
		cartItem.setProductName(product.getProductName());
		cartItem.setPrice(quantity);
		cartItem.setPaymentStatus("NP");
		cartItem.setUsername(username);

		cartDAO.addCartItem(cartItem);

		List<CartItem> cartItemList = cartDAO.listCartItems(username);
		m.addAttribute("cartItemList", cartItemList);
		m.addAttribute("grandTotal", this.getGrandTotal(cartItemList));

		return "Cart";
	}

	@RequestMapping("/updateCartItem/{cartItemId}")
	public String addToCart(@PathVariable("cartItemId") int cartItemId, @RequestParam("quantity") int quantity, Model m,
			HttpSession session) {

		CartItem cartItem = cartDAO.getCartItem(cartItemId);
		cartItem.setQuantity(quantity);

		cartDAO.updateCartItem(cartItem);

		String username = (String) session.getAttribute("username");
		List<CartItem> cartItemList = cartDAO.listCartItems(username);

		m.addAttribute("cartItemList", cartItemList);
		m.addAttribute("grandTotal", this.getGrandTotal(cartItemList));
		return "Cart";
	}

	@RequestMapping("/deleteCartItem/{cartItemId}")
	public String deleteCartItem(@PathVariable("cartItemId") int cartItemId, Model m, HttpSession session) {

		CartItem cartItem = cartDAO.getCartItem(cartItemId);
		cartDAO.deleteCartItem(cartItem);
		String username = (String) session.getAttribute("Username");
		List<CartItem> cartItemList = cartDAO.listCartItems(username);

		m.addAttribute("cartItemList", cartItemList);
		m.addAttribute("grandTotal", this.getGrandTotal(cartItemList));

		return "Cart";
	}

	public int getGrandTotal(List<CartItem> cartList) {
		int grandTotal = 0, count = 0;
		while (count < cartList.size()) {
			grandTotal = grandTotal + (cartList.get(count).getQuantity() * cartList.get(count).getPrice());
			count++;
		}
		return grandTotal;

	}
}
