package bd2.adminPanel.dao.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bd2.adminPanel.dao.DBUtils;
import bd2.adminPanel.model.dictionaries.DayOfWeek;

@Repository
public class DaysOfWeekRepository {

    @Autowired
    private DBUtils dbUtils;

    public List<DayOfWeek> getDaysOfWeek() {
        return dbUtils.getAll(DayOfWeek.class);
    }

}
