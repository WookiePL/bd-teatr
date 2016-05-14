package example.persist.model;

import javax.persistence.*;


@Entity
@Table(name = "sector", schema = "theater")
public class SectorEntity {
    private Integer sectorId;
    private Integer number;
    private Integer roomId;

    @Id
    @Column(name = "sector_id", columnDefinition = "serial")
    @SequenceGenerator(name = "sector_sector_id_seq",
            sequenceName = "sector_sector_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "sector_sector_id_seq")
    public Integer getSectorId() {
        return sectorId;
    }

    public void setSectorId(Integer sectorId) {
        this.sectorId = sectorId;
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
    @Column(name = "room_id")
    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SectorEntity that = (SectorEntity) o;

        if (sectorId != null ? !sectorId.equals(that.sectorId) : that.sectorId != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (roomId != null ? !roomId.equals(that.roomId) : that.roomId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sectorId != null ? sectorId.hashCode() : 0;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (roomId != null ? roomId.hashCode() : 0);
        return result;
    }
}
