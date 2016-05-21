package theater.persist.dtos;


import theater.persist.model.RoomEntity;

import java.util.List;

public class BuildingDTO {
    private Integer buildingId;
    private String address;
    private List<RoomEntity> rooms;


    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public String getAdress() {
        return address;
    }

    public void setAdress(String address) {
        this.address = address;
    }

    public List<RoomEntity> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomEntity> rooms) {
        this.rooms = rooms;
    }

}
