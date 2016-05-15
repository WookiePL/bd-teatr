package example.persist.dtos;


import example.persist.model.CycleEntity;

import java.util.List;

public class DayOfWeekDTO {

    private String name;
    private Integer dayOfWeekId;
    private List<CycleEntity> cycles;

    public Integer getDayOfWeekId() {
        return dayOfWeekId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setDayOfWeekId(Integer dayOfWeekId) {
        this.dayOfWeekId = dayOfWeekId;
    }

    public List<CycleEntity> getCycles() {
        return cycles;
    }

    public void setCycles(List<CycleEntity> cycles) {
        this.cycles = cycles;
    }
}
