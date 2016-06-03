package theater.persist.dtos;


import theater.persist.model.BuildingEntity;
import theater.persist.model.EventRealizationEntity;
import theater.persist.model.SectorEntity;

import java.util.List;

public class RoomDTO {

    private Integer roomId;
    private Integer number;
    private Integer buildingId;
    private BuildingEntity building;
    private List<EventRealizationEntity> eventRealizations;
    private List<SectorEntity> sectors;

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public BuildingEntity getBuilding() {
        return building;
    }
    public void setBuilding(BuildingEntity building) {
        this.building = building;
    }

    public List<EventRealizationEntity> getEventRealizations() {
        return eventRealizations;
    }

    public void setEventRealizations(List<EventRealizationEntity> eventRealizations) {
        this.eventRealizations = eventRealizations;
    }

    public List<SectorEntity> getSectors() {
        return sectors;
    }

    public void setSectors(List<SectorEntity> sectors) {
        this.sectors = sectors;
    }
}
