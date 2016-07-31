package theater.persist.daos;

import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import theater.persist.model.SectorEntity;

import java.util.List;

@Repository
public class SectorDAO extends BaseDAO<SectorEntity, Integer> implements ISectorDAO{
    @Override
    public SectorEntity getSectorById(int id) {
        SectorEntity sector = super.readById(id);
        if (sector != null) {
            return sector;
        }
        return null;
    }

    @Override
    public SectorEntity findByNumber(Integer number) {
        return (SectorEntity) currentSession().createCriteria(SectorEntity.class)
                                                .add(Restrictions.eq("number", number))
                                                    .uniqueResult();
    }

    @Override
    public List<SectorEntity> getAllSectors() {
        return super.getAll();
    }

    @Override
    public void addSector(SectorEntity sector) {
        super.create(sector);
    }

    @Override
    public void updateSector(SectorEntity sector) {
        super.update(sector);
    }

    @Override
    public void deleteSector(int id) {
        SectorEntity sector = super.readById(id);
        if (sector != null) {
            super.delete(sector);
        }
    }
}
