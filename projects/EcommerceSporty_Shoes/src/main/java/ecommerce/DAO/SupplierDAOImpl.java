package ecommerce.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ecommerce.model.Supplier;

@Repository("supplierDAO")
@Transactional
public class SupplierDAOImpl implements SupplierDAO {

	@Autowired
	SessionFactory sessionFactory;

	public boolean addSupplier(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().save(supplier);
			return true;
		} catch (HibernateException e) {
			return false;
		}

	}

	public boolean deleteSupplier(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().delete(supplier);
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

	public boolean updateSupplier(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().update(supplier);
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

	public List<Supplier> listSuppliers() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Supplier");
		List<Supplier> listSupplier = query.list();
		session.close();

		return listSupplier;

	}

	public Supplier getSupplier(int supplierId) {
		Session session = sessionFactory.openSession();
		 Supplier supplier = session.get(Supplier.class, supplierId);
		session.close();
		return supplier;
	}
}
