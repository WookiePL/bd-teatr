package theater.helper;

import theater.persist.dtos.DayOfWeekDTO;

import java.util.List;

/**
 * Created by Wookie on 2016-08-10.
 */
public class DayOfWeekHelper {

    private List<DayOfWeekDTO> checkedDaysOfWeek;

    public List<DayOfWeekDTO> getCheckedDaysOfWeek() {
        return checkedDaysOfWeek;
    }

    public void setCheckedDaysOfWeek(List<DayOfWeekDTO> checkedDaysOfWeek) {
        this.checkedDaysOfWeek = checkedDaysOfWeek;
    }
}
