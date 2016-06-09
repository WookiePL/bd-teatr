package bd2.adminPanel.dao.repository;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bd2.adminPanel.dao.DBUtils;
import bd2.adminPanel.model.dictionaries.Place;

@Repository
public class PlacesRepository {

	@Autowired
	private DBUtils dbUtils;

	public List<Place> getPlaces() {
		return dbUtils.getAll(Place.class);
	}

	public List<Place> findPlaceBySectorId(Integer sectorId) {
		String sql = "SELECT p FROM Place p WHERE p.sectorId = ?1";
		TypedQuery<Place> query = dbUtils.geEntityManager().createQuery(sql, Place.class);
		query.setParameter(1, sectorId);

		return query.getResultList();
	}
	
}
