package theater.persist.daos;

import org.springframework.stereotype.Repository;
import theater.persist.model.RolesEntity;

import java.util.List;
@Repository
public class RolesDAO extends BaseDAO<RolesEntity, Integer> implements IRolesDAO{

    @Override
    public RolesEntity getRolesById(int id) {
        RolesEntity roles = super.readById(id);
        if (roles != null) {
            return roles;
        }
        return null;
    }

    @Override
    public List<RolesEntity> getAllRoles() {
        return super.getAll();
    }

    @Override
    public void addRoles(RolesEntity roles) {
        super.create(roles);
    }

    @Override
    public void updateRoles(RolesEntity roles) {
        super.update(roles);
    }

    @Override
    public void deleteRoles(int id) {
        RolesEntity roles = super.readById(id);
        if (roles != null) {
            super.delete(roles);
        }

    }
}
