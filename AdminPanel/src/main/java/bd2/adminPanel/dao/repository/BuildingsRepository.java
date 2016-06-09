package bd2.adminPanel.dao.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bd2.adminPanel.dao.DBUtils;
import bd2.adminPanel.model.dictionaries.Building;

@Repository
public class BuildingsRepository {

	@Autowired
    private DBUtils dbUtils;

    public List<Building> getBuildings() {
        return dbUtils.getAll(Building.class);
    }
	
}
