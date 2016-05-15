package example.persist.daos;


import example.persist.model.DayOfWeekEntity;

import java.util.List;

public interface IDayOfWeekDAO extends IBaseDAO<DayOfWeekEntity, Integer> {

    DayOfWeekEntity getDayOfWeekById(int id);

    List<DayOfWeekEntity> getAllDaysOfWeek();

    void addDayOfWeek(DayOfWeekEntity building);

    void updateDayOfWeek(DayOfWeekEntity building);

    void deleteDayOfWeek(int id);
}
