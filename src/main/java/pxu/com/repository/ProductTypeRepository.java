package pxu.com.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pxu.com.model.Product;
import pxu.com.model.Producttype;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@Transactional
public class ProductTypeRepository implements BaseRepository<Producttype> {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Producttype> getAll() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Producttype> cq = cb.createQuery(Producttype.class);
		Root<Producttype> root = cq.from(Producttype.class);
		cq.select(root);
		return session.createQuery(cq).getResultList();
	}

	@Override
	@Transactional
	public void save(Producttype producttype) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(producttype); // Use the provided 'product' instead of 'session'
	}

	@Override
	@Transactional
	public Producttype getById(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Producttype.class, id);
	}

	@Override
	@Transactional
	public void update(Producttype producttype) {
		Session session = sessionFactory.getCurrentSession();
		session.update(producttype);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Producttype producttype = session.get(Producttype.class, id);
		if (producttype != null) {
			session.delete(producttype);
		}
	}

}
