package example.persist.daos;


import example.persist.model.PeriodEntity;

import java.util.List;

public interface IPeriodDAO extends IBaseDAO<PeriodEntity, Integer>{

    PeriodEntity getPeriodById(int id);

    List<PeriodEntity> getAllPeriods();

    void addPeriod(PeriodEntity building);

    void updatePeriod(PeriodEntity building);

    void deletePeriod(int id);
}
