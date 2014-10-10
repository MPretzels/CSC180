
public interface Service<T> {
	T create(T obj);
	T retreive(Integer id);
	T update(Integer id, T obj);
	void delete(Integer id);
}
