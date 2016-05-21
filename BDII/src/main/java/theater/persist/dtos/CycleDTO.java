package theater.persist.dtos;


import theater.persist.model.DayOfWeekEntity;
import theater.persist.model.PeriodEntity;

public class CycleDTO {

    private Integer cycleId;
    private Integer periodId;
    private Integer dayOfWeekId;
    private DayOfWeekEntity dayofweek;
    private PeriodEntity period;


    public Integer getCycleId() {
        return cycleId;
    }

    public void setCycleId(Integer cycleId) {
        this.cycleId = cycleId;
    }

    public Integer getPeriodId() {
        return periodId;
    }

    public void setPeriodId(Integer periodId) {
        this.periodId = periodId;
    }


    public Integer getDayOfWeekId() {
        return dayOfWeekId;
    }

    public void setDayOfWeekId(Integer dayOfWeekId) {
        this.dayOfWeekId = dayOfWeekId;
    }


    public DayOfWeekEntity getDayofweek() {
        return dayofweek;
    }

    public void setDayofweek(DayOfWeekEntity dayofweek) {
        this.dayofweek = dayofweek;
    }

    public PeriodEntity getPeriod() {
        return period;
    }

    public void setPeriod(PeriodEntity period) {
        this.period = period;
    }
}
