package bd2.adminPanel.dao.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bd2.adminPanel.dao.DBUtils;
import bd2.adminPanel.dao.dictionaries.GroupOfClientDAO;

@Repository
public class GroupsOfClientsRepository {

	@Autowired
    private DBUtils dbUtils;

    public List<GroupOfClientDAO> getGroupsOfClients() {
        return dbUtils.getAll(GroupOfClientDAO.class);
    }
	
}
