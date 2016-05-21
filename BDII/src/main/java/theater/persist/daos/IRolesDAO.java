package theater.persist.daos;

import theater.persist.model.RolesEntity;

import java.util.List;

/**
 * Created by Wookie on 2016-05-16.
 */
public interface IRolesDAO extends IBaseDAO<RolesEntity, Integer> {

    RolesEntity getRolesById(int id);

    List<RolesEntity> getAllRoles();

    void addRoles(RolesEntity roles);

    void updateRoles(RolesEntity roles);

    void deleteRoles(int id);
    
}
