package theater.persist.daos;


import theater.persist.model.CycleEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CycleDAO extends BaseDAO<CycleEntity, Integer> implements ICycleDAO{

    @Override
    public CycleEntity getCycleById(int id) {
        CycleEntity cycle = super.readById(id);
        if (cycle != null) {
            return cycle;
        }
        return null;
    }

    @Override
    public List<CycleEntity> getAllCycles() {
        return super.getAll();
    }

    @Override
    public void addCycle(CycleEntity cycle) {
        super.create(cycle);
    }

    @Override
    public void updateCycle(CycleEntity cycle) {
        super.update(cycle);
    }

    @Override
    public void deleteCycle(int id) {
        CycleEntity cycle = super.readById(id);
        if (cycle != null) {
            super.delete(cycle);
        }
    }
}
