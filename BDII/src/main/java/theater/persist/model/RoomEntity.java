package theater.persist.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "room", schema = "theater")
public class RoomEntity {
    private Integer roomId;
    private Integer number;
    private Integer buildingId;
    private BuildingEntity building;
    private List<EventRealizationEntity> eventRealizations;
    private List<SectorEntity> sectors;

    @Id
    @Column(name = "room_id", columnDefinition = "serial")
    @SequenceGenerator(name = "room_room_id_seq",
            sequenceName = "room_room_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY,
            generator = "room_room_id_seq")
    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    @Basic
    @Column(name = "number")
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Basic
    @Column(name = "building_id")
    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    @ManyToOne
    @JoinColumn(name = "building_id", insertable = false, updatable = false)
    public BuildingEntity getBuilding() {
        return building;
    }

    public void setBuilding(BuildingEntity building) {
        this.building = building;
    }

    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY)
    public List<EventRealizationEntity> getEventRealizations() {
        return eventRealizations;
    }

    public void setEventRealizations(List<EventRealizationEntity> eventRealizations) {
        this.eventRealizations = eventRealizations;
    }

    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY)
    public List<SectorEntity> getSectors() {
        return sectors;
    }

    public void setSectors(List<SectorEntity> sectors) {
        this.sectors = sectors;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomEntity that = (RoomEntity) o;

        if (roomId != null ? !roomId.equals(that.roomId) : that.roomId != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (buildingId != null ? !buildingId.equals(that.buildingId) : that.buildingId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roomId != null ? roomId.hashCode() : 0;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (buildingId != null ? buildingId.hashCode() : 0);
        return result;
    }
}
