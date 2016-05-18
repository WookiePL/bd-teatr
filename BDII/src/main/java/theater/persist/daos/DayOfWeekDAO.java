package theater.persist.daos;


import theater.persist.model.DayOfWeekEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DayOfWeekDAO extends BaseDAO<DayOfWeekEntity, Integer> implements IDayOfWeekDAO{

    @Override
    public DayOfWeekEntity getDayOfWeekById(int id) {
        DayOfWeekEntity dayOfWeek = super.readById(id);
        if (dayOfWeek != null) {
            return dayOfWeek;
        }
        return null;
    }

    @Override
    public List<DayOfWeekEntity> getAllDaysOfWeek() {
        return super.getAll();
    }

    @Override
    public void addDayOfWeek(DayOfWeekEntity dayOfWeek) {
        super.create(dayOfWeek);
    }

    @Override
    public void updateDayOfWeek(DayOfWeekEntity dayOfWeek) {
        super.update(dayOfWeek);
    }

    @Override
    public void deleteDayOfWeek(int id) {
        DayOfWeekEntity dayOfWeek = super.readById(id);
        if (dayOfWeek != null) {
            super.delete(dayOfWeek);
        }
    }
}
