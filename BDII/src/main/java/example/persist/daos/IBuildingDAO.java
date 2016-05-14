package example.persist.daos;

import example.persist.model.BuildingEntity;

import java.util.List;

public interface IBuildingDAO extends IBaseDAO<BuildingEntity, Integer> {

    BuildingEntity getBuildingById(int id);

    List<BuildingEntity> getAllBuildings();

    void addBuilding(BuildingEntity building);

    void updateBuilding(BuildingEntity building);

    void deleteBuilding(int id);
}
