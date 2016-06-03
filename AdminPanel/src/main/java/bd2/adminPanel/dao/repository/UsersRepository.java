package bd2.adminPanel.dao.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bd2.adminPanel.dao.DBUtils;
import bd2.adminPanel.dao.UserDAO;

@Repository
public class UsersRepository {

    @Autowired
    private DBUtils dbUtils;

    public List<UserDAO> getUsers() {
        return dbUtils.getAll(UserDAO.class);
    }
}
