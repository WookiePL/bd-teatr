package example.persist.daos;

import java.util.List;

public interface IBaseDAO<T, K> {

    void create(T t);

    T readById(K id);

    void update(T t);

    void delete(T t);

    List<T> getAll();
}
