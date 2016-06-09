package bd2.adminPanel.dao.repository;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bd2.adminPanel.dao.DBUtils;
import bd2.adminPanel.model.dictionaries.Sector;

@Repository
public class SectorsRepository {

	@Autowired
    private DBUtils dbUtils;

    public List<Sector> getSectors() {
        return dbUtils.getAll(Sector.class);
    }
	
    public List<Sector> findSectorByRoomId(Integer roomId) {
    	String sql = "SELECT s FROM Sector s WHERE s.roomId = ?1";
    	TypedQuery<Sector> query = dbUtils.geEntityManager().createQuery(sql, Sector.class);
    	query.setParameter(1, roomId);
    	
    	return query.getResultList();
    }
}
