package example.persist.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dayofweek", schema = "theater")
public class DayOfWeekEntity {
    private String name;
    private Integer dayOfWeekId;
    private List<CycleEntity> cycles;

    @Id
    @Column(name = "day_of_week_id")
    public Integer getDayOfWeekId() {
        return dayOfWeekId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setDayOfWeekId(Integer dayOfWeekId) {
        this.dayOfWeekId = dayOfWeekId;
    }

    @OneToMany(mappedBy = "cycleEntity", fetch = FetchType.LAZY)
    public List<CycleEntity> getCycles() {
        return cycles;
    }

    public void setCycles(List<CycleEntity> cycles) {
        this.cycles = cycles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DayOfWeekEntity that = (DayOfWeekEntity) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (dayOfWeekId != null ? !dayOfWeekId.equals(that.dayOfWeekId) : that.dayOfWeekId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (dayOfWeekId != null ? dayOfWeekId.hashCode() : 0);
        return result;
    }
}
