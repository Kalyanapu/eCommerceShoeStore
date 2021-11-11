package ecommerce.DAO;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ecommerce.model.UserDetail;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {

	@Autowired
	SessionFactory sessionFactory;

	public boolean registerUser(UserDetail user) {
		try {
			sessionFactory.getCurrentSession().save(user);
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

	public boolean updateUser(UserDetail user) {
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

	public UserDetail getUser(String username) {
		Session session = sessionFactory.openSession();

		UserDetail userDetail = (UserDetail) session.get(UserDetail.class, username);
		session.close();
		return userDetail;
	}

}
