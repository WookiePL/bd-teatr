package theater.persist.dtos;


import theater.persist.model.CycleEntity;

import java.util.List;

public class PeriodDTO {

    private Integer periodId;
    private String name;
    private List<CycleEntity> cycles;

    public Integer getPeriodId() {
        return periodId;
    }

    public void setPeriodId(Integer periodId) {
        this.periodId = periodId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CycleEntity> getCycles() {
        return cycles;
    }

    public void setCycles(List<CycleEntity> cycles) {
        this.cycles = cycles;
    }
}
