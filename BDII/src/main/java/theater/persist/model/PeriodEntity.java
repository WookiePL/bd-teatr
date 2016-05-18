package theater.persist.model;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "period", schema = "theater")
public class PeriodEntity {
    private Integer periodId;
    private String name;
    private List<CycleEntity> cycles;

    @Id
    @Column(name = "period_id", columnDefinition = "serial")
    @SequenceGenerator(name = "period_period_id_seq",
            sequenceName = "period_period_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "period_period_id_seq")
    public Integer getPeriodId() {
        return periodId;
    }

    public void setPeriodId(Integer periodId) {
        this.periodId = periodId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

        PeriodEntity that = (PeriodEntity) o;

        if (periodId != null ? !periodId.equals(that.periodId) : that.periodId != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = periodId != null ? periodId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
