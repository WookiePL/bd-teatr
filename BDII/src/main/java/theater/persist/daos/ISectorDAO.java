package theater.persist.daos;

import theater.persist.model.SectorEntity;

import java.util.List;

/**
 * Created by Wookie on 2016-05-16.
 */
public interface ISectorDAO extends IBaseDAO<SectorEntity, Integer> {

    SectorEntity getSectorById(int id);

    List<SectorEntity> getAllSectors();

    void addSector(SectorEntity sector);

    void updateSector(SectorEntity sector);

    void deleteSector(int id);

}
