package theater.persist.daos;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;


public abstract class BaseDAO<T, K extends Serializable> implements IBaseDAO<T, K> {

    @Autowired
    private SessionFactory sessionFactory;

    private Class<T> clazz;

    @SuppressWarnings("unchecked")
    public BaseDAO() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.clazz = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
    }

    protected Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void create(T t) {
        currentSession().save(t);
    }

    @Override
    public T readById(K key) {
        return (T) currentSession().get(clazz, key);
    }

    @Override
    public void delete(T t) {
        currentSession().delete(t);
    }

    @Override
    public void update(T t) {
        currentSession().merge(t);
    }

    @Override
    public List<T> getAll() {
        return currentSession().createCriteria(clazz).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

    protected Criteria getCriteria() {
        return currentSession().createCriteria(clazz);
    }

    protected Query getNamedQuery(String s) {
        return currentSession().getNamedQuery(s);
    }


}
