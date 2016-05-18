package theater.persist.daos;

import theater.persist.model.GroupOfClientsEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Wookie on 2016-05-16.
 */
@Repository
public class GroupOfClientsDAO extends BaseDAO<GroupOfClientsEntity, Integer> implements IGroupOfClientsDAO {

    @Override
    public GroupOfClientsEntity getGroupOfClientsById(int id) {
        GroupOfClientsEntity groupOfClients = super.readById(id);
        if (groupOfClients != null) {
            return groupOfClients;
        }
        return null;
    }

    @Override
    public List<GroupOfClientsEntity> getAllGroupsOfClients() {
        return super.getAll();
    }

    @Override
    public void addGroupOfClients(GroupOfClientsEntity groupOfClients) {

    }

    @Override
    public void updateGroupOfClients(GroupOfClientsEntity groupOfClients) {

    }

    @Override
    public void deleteGroupOfClients(int id) {

    }
}
