package ecommerce.DAO;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ecommerce.model.OrderDetail;

@Repository("orderDAO")
@Transactional
public class OrderDAOImpl implements OrderDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean saveOrder(OrderDetail orderDetail) {
		try {
			sessionFactory.getCurrentSession().save(orderDetail);
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

	@Override
	public boolean updateCart(String username) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("update cartItem set paymentStatus='P where username=:uname");
		query.setParameter("uname", username);
		int row_eff = query.executeUpdate();
		return true;
		// session.close();

	}
}