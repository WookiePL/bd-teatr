package theater.persist.dtos;

/**
 * Created by Wookie on 2016-05-16.
 */
public class SectorDTO {
    private Integer sectorId;
    private Integer number;
    private Integer roomId;

    public Integer getSectorId() {
        return sectorId;
    }

    public void setSectorId(Integer sectorId) {
        this.sectorId = sectorId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }
}
