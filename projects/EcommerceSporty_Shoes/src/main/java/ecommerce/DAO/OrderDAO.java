package ecommerce.DAO;

import ecommerce.model.CartItem;
import ecommerce.model.OrderDetail;

public interface OrderDAO {

	public boolean saveOrder(OrderDetail orderDetail);

	public boolean updateCart(String username);

}
