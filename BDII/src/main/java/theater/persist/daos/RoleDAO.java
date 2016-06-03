package theater.persist.daos;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import theater.persist.model.RoleEntity;

import java.util.List;
@Repository
public class RoleDAO extends BaseDAO<RoleEntity, Integer> implements IRolesDAO{

    @Override
    public RoleEntity getRolesById(int id) {
        RoleEntity roles = super.readById(id);
        if (roles != null) {
            return roles;
        }
        return null;
    }

    @Override
    public RoleEntity findByName(String name) {
        Query q = super.getNamedQuery("findByName").setParameter("name", name);
        RoleEntity roleEntity = (RoleEntity) q.uniqueResult();
        if (roleEntity != null) {
            return roleEntity;
        }
        return null;
    }

    @Override
    public List<RoleEntity> getAllRoles() {
        return super.getAll();
    }

    @Override
    public void addRoles(RoleEntity roles) {
        super.create(roles);
    }

    @Override
    public void updateRoles(RoleEntity roles) {
        super.update(roles);
    }

    @Override
    public void deleteRoles(int id) {
        RoleEntity roles = super.readById(id);
        if (roles != null) {
            super.delete(roles);
        }

    }
}
