package bd2.adminPanel.dao.repository;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bd2.adminPanel.dao.DBUtils;
import bd2.adminPanel.model.dictionaries.Room;

@Repository
public class RoomsRepository {

	@Autowired
	private DBUtils dbUtils;

	public List<Room> getRooms() {
		return dbUtils.getAll(Room.class);
	}

	public List<Room> findRoomByBuildingId(Integer buildingId) {
		String sql = "SELECT r FROM Room r WHERE r.buildingId = ?1";
		TypedQuery<Room> query = dbUtils.geEntityManager().createQuery(sql, Room.class);
		query.setParameter(1, buildingId);

		return query.getResultList();
	}

}
