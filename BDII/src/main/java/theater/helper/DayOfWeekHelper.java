package theater.helper;

import theater.persist.dtos.DayOfWeekDTO;

import java.util.List;

/**
 * Helper to define which checkboxes are checked on Edit/Add periods Form
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
