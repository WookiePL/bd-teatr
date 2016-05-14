package example.persist.model;

import javax.persistence.*;

@Entity
@Table(name = "cycle", schema = "theater")
public class CycleEntity {
    private Integer cycleId;
    private Integer periodId;
    private Integer dayOfWeekId;
    private DayofweekEntity dayofweek;
    private PeriodEntity period;

    @Id
    @Column(name = "cycle_id", columnDefinition = "serial")
    @SequenceGenerator(name = "cycle_cycle_id_seq",
            sequenceName = "cycle_cycle_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "cycle_cycle_id_seq")
    public Integer getCycleId() {
        return cycleId;
    }

    public void setCycleId(Integer cycleId) {
        this.cycleId = cycleId;
    }

    @Basic
    @Column(name = "period_id")
    public Integer getPeriodId() {
        return periodId;
    }

    public void setPeriodId(Integer periodId) {
        this.periodId = periodId;
    }

    @Basic
    @Column(name = "day_of_week_id")
    public Integer getDayOfWeekId() {
        return dayOfWeekId;
    }

    public void setDayOfWeekId(Integer dayOfWeekId) {
        this.dayOfWeekId = dayOfWeekId;
    }

    @ManyToOne
    @JoinColumn(name = "day_of_week_id")
    public DayofweekEntity getDayofweek() {
        return dayofweek;
    }

    public void setDayofweek(DayofweekEntity dayofweek) {
        this.dayofweek = dayofweek;
    }

    @ManyToOne
    @JoinColumn(name = "period_id")
    public PeriodEntity getPeriod() {
        return period;
    }

    public void setPeriod(PeriodEntity period) {
        this.period = period;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CycleEntity that = (CycleEntity) o;

        if (cycleId != null ? !cycleId.equals(that.cycleId) : that.cycleId != null) return false;
        if (periodId != null ? !periodId.equals(that.periodId) : that.periodId != null) return false;
        if (dayOfWeekId != null ? !dayOfWeekId.equals(that.dayOfWeekId) : that.dayOfWeekId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cycleId != null ? cycleId.hashCode() : 0;
        result = 31 * result + (periodId != null ? periodId.hashCode() : 0);
        result = 31 * result + (dayOfWeekId != null ? dayOfWeekId.hashCode() : 0);
        return result;
    }
}
