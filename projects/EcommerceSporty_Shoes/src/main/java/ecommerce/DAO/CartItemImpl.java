package ecommerce.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ecommerce.model.CartItem;
import ecommerce.model.Category;

@Repository("cartDAO")
@Transactional
public class CartItemImpl implements CartDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addCartItem(CartItem cartItem) {
		try {
			sessionFactory.getCurrentSession().save(cartItem);
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

	@Override
	public boolean deleteCartItem(CartItem cartItem) {
		try {
			sessionFactory.getCurrentSession().delete(cartItem);
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

	@Override
	public boolean updateCartItem(CartItem cartItem) {
		try {
			sessionFactory.getCurrentSession().update(cartItem);
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

	@Override
	public List<CartItem> listCartItems(String username) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from CartItem where username=:username and paymentStatus='NP'");
		query.setParameter(username, username);
		List<CartItem> cartItemList = query.getResultList();
		session.close();

		return cartItemList;

	}

	@Override
	public CartItem getCartItem(int cartItemId) {
		Session session = sessionFactory.openSession();
		CartItem cartItem = session.get(CartItem.class, cartItemId);
		session.close();

		return cartItem;

	}

}
