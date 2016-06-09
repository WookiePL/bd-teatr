package bd2.adminPanel.dao.repository;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bd2.adminPanel.dao.DBUtils;
import bd2.adminPanel.model.users.User;

@Repository
public class UsersRepository {

    @Autowired
    private DBUtils dbUtils;

    public List<User> getUsers() {
        return dbUtils.getAll(User.class);
    }
    
    public User findUserByEmail(String email) {
    	String sql = "SELECT u FROM User u WHERE u.email = ?1";
    	TypedQuery<User> query = dbUtils.geEntityManager().createQuery(sql, User.class);
    	query.setParameter(1, email);
    	
    	User user = null;
    	
    	for(User u : query.getResultList()) {
    		user = u;
    	}
    	
    	return user;
    }
}
