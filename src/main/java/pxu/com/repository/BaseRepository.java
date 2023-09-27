package pxu.com.repository;

import java.util.List;

public interface BaseRepository<T> {

	public List<T> getAll();

	public void save(T object);

	public T getById(int id);

	public void update(T object);

	public void deleteById(int id);
}
