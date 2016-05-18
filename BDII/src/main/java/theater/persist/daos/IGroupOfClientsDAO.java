package theater.persist.daos;

import theater.persist.model.GroupOfClientsEntity;

import java.util.List;

/**
 * Created by Wookie on 2016-05-16.
 */
public interface IGroupOfClientsDAO extends IBaseDAO<GroupOfClientsEntity, Integer> {

    GroupOfClientsEntity getGroupOfClientsById(int id);

    List<GroupOfClientsEntity> getAllGroupsOfClients();

    void addGroupOfClients(GroupOfClientsEntity groupOfClients);

    void updateGroupOfClients(GroupOfClientsEntity groupOfClients);

    void deleteGroupOfClients(int id);
}
