package theater.persist.daos;

import theater.persist.model.RoleEntity;

import java.util.List;


public interface IRolesDAO extends IBaseDAO<RoleEntity, Integer> {

    RoleEntity getRolesById(int id);

    RoleEntity findByName(String name);

    List<RoleEntity> getAllRoles();

    void addRoles(RoleEntity roles);

    void updateRoles(RoleEntity roles);

    void deleteRoles(int id);
    
}
