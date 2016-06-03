package theater.persist.daos;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import theater.persist.model.BuildingEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BuildingDAO extends BaseDAO<BuildingEntity, Integer> implements IBuildingDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public BuildingEntity getBuildingById(int id) {
        BuildingEntity buildingEntity = super.readById(id);
        if (buildingEntity != null) {
            return buildingEntity;
        }
        return null;
    }

    @Override
    public List<BuildingEntity> getAllBuildings() {
        return super.getAll();
    }

    @Override
    public void addBuilding(BuildingEntity building) {
        super.create(building);
    }

    @Override
    public void updateBuilding(BuildingEntity building) {
        super.update(building);
    }

    @Override
    public void deleteBuilding(int id) {
        BuildingEntity buildingEntity = super.readById(id);
        if (buildingEntity != null) {
            super.delete(buildingEntity);
        }
    }
}
