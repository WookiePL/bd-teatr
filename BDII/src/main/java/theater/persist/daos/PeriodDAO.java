package theater.persist.daos;


import theater.persist.model.PeriodEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PeriodDAO extends BaseDAO<PeriodEntity, Integer> implements IPeriodDAO{

    @Override
    public PeriodEntity getPeriodById(int id) {
        PeriodEntity periodEntity = super.readById(id);
        if (periodEntity != null) {
            return periodEntity;
        }
        return null;
    }

    @Override
    public List<PeriodEntity> getAllPeriods() {
        return super.getAll();
    }

    @Override
    public void addPeriod(PeriodEntity period) {
        super.create(period);
    }

    @Override
    public void updatePeriod(PeriodEntity period) {
        super.update(period);
    }

    @Override
    public void deletePeriod(int id) {
        PeriodEntity period = super.readById(id);
        if (period != null) {
            super.delete(period);
        }
    }
}
