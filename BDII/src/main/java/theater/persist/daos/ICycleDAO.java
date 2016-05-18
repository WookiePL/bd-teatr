package theater.persist.daos;

import theater.persist.model.CycleEntity;

import java.util.List;


public interface ICycleDAO extends IBaseDAO<CycleEntity, Integer>{

    CycleEntity getCycleById(int id);

    List<CycleEntity> getAllCycles();

    void addCycle(CycleEntity building);

    void updateCycle(CycleEntity building);

    void deleteCycle(int id);
}
