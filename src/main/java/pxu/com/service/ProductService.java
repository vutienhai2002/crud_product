package pxu.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pxu.com.model.Product;
import pxu.com.repository.BaseRepository;

@Service
public class ProductService implements BaseService<Product> {

	@Autowired
	private BaseRepository<Product> productRepository;

	public ProductService() {
		super();
	}

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return productRepository.getAll();
	}

	@Override
	public void save(Product object) {
		// TODO Auto-generated method stub
		productRepository.save(object);
	}

	@Override
	public Product getById(int id) {
		// TODO Auto-generated method stub
		return productRepository.getById(id);
	}

	@Override
	public void update(Product object) {
		// TODO Auto-generated method stub
		productRepository.update(object);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		productRepository.deleteById(id);
	}

}
