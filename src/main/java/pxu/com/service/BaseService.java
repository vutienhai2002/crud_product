package pxu.com.service;

import java.util.List;

public interface BaseService<T> {
	public List<T> getAll();

	public void save(T object);

	public T getById(int id);

	public void update(T object);

	public void delete(int id);

}
