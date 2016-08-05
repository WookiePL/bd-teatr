package bd2.adminPanel.dao.repository;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bd2.adminPanel.dao.DBUtils;
import bd2.adminPanel.model.dictionaries.DayOfWeek;

@Repository
public class DaysOfWeekRepository {

    @Autowired
    private DBUtils dbUtils;

    public List<DayOfWeek> getDaysOfWeek() {
        return dbUtils.getAll(DayOfWeek.class);
    }
    
    public List<Integer> getIds() {
    	EntityManager entityManager = dbUtils.geEntityManager();
    	Query query = entityManager.createQuery("select day.id from DayOfWeek day");
    	return query.getResultList();
    	
    }

}
