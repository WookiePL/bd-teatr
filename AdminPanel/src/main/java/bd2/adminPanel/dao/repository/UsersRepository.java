package bd2.adminPanel.dao.repository;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bd2.adminPanel.dao.DBUtils;
import bd2.adminPanel.dao.users.UserDAO;

@Repository
public class UsersRepository {

    @Autowired
    private DBUtils dbUtils;

    public List<UserDAO> getUsers() {
        return dbUtils.getAll(UserDAO.class);
    }
    
    public UserDAO findUserByEmail(String email) {
    	String sql = "SELECT u FROM UserDAO u WHERE u.email = ?1";
    	TypedQuery<UserDAO> query = dbUtils.geEntityManager().createQuery(sql, UserDAO.class);
    	query.setParameter(1, email);
    	
    	UserDAO user = null;
    	
    	for(UserDAO u : query.getResultList()) {
    		user = u;
    	}
    	
    	return user;
    }
}
