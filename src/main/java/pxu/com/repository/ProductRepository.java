package pxu.com.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pxu.com.model.Product;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@Transactional
public class ProductRepository implements BaseRepository<Product> {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Product> getAll() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Product> cq = cb.createQuery(Product.class);
		Root<Product> root = cq.from(Product.class);
		cq.select(root);
		return session.createQuery(cq).getResultList();
	}

	@Override
	@Transactional
	public void save(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(product); // Use the provided 'product' instead of 'session'
	}

	@Override
	@Transactional
	public Product getById(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Product.class, id);
	}

	@Override
	@Transactional
	public void update(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.update(product);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Product product = session.get(Product.class, id);
		if (product != null) {
			session.delete(product);
		}
	}

}
