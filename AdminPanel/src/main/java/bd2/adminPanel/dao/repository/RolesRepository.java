package bd2.adminPanel.dao.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bd2.adminPanel.dao.DBUtils;
import bd2.adminPanel.dao.RoleDAO;

@Repository
public class RolesRepository {

    @Autowired
    private DBUtils dbUtils;

    public List<RoleDAO> getRoles() {
        return dbUtils.getAll(RoleDAO.class);
    }
}
