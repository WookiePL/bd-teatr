package bd2.adminPanel.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DBUtils {

    EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;

    @Autowired
    public DBUtils(EntityManager entityManager, EntityManagerFactory entityManagerFactory) {
        this.entityManager = entityManager;
        this.entityManagerFactory = entityManagerFactory;
    }

    public void persist(Object entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    public void remove(Object entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }

    public <T> List<T> getAll(Class<T> entityClass) {
        TypedQuery<T> query = entityManager.createQuery("select e from "
                + entityClass.getSimpleName() + " e",
                entityClass);
        return query.getResultList();
    }

    public void close() {
        entityManager.close();
        entityManagerFactory.close();
    }

    public EntityManager geEntityManager() {
        return entityManager;
    }
}
