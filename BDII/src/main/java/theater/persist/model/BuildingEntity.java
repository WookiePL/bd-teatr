package theater.persist.model;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "building", schema = "theater")
public class BuildingEntity {
    private Integer buildingId;
    private String address;
    private List<RoomEntity> rooms;

    @Id
    @Column(name = "building_id", updatable=false)
    @SequenceGenerator(name = "building_building_id_seq",
            sequenceName = "building_building_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY,
            generator = "building_building_id_seq")
    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    @Basic
    @Column(name = "address")
    public String getAdress() {
        return address;
    }

    public void setAdress(String address) {
        this.address = address;
    }

    @OneToMany(mappedBy = "building", fetch = FetchType.LAZY)
    public List<RoomEntity> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomEntity> rooms) {
        this.rooms = rooms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BuildingEntity that = (BuildingEntity) o;

        if (buildingId != null ? !buildingId.equals(that.buildingId) : that.buildingId != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = buildingId != null ? buildingId.hashCode() : 0;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }
}
