package theater.persist.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "place", schema = "theater")
public class PlaceEntity {
    private Integer placeId;
    private Integer number;
    private Integer sectorId;
    private SectorEntity sector;
    private Collection<TicketEntity> tickets;
    private Collection<ReservationEntity> reservations;

    @Id
    @Column(name = "place_id", columnDefinition = "serial")
    @SequenceGenerator(name = "place_place_id_seq",
            sequenceName = "place_place_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY,
            generator = "place_place_id_seq")
    public Integer getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Integer placeId) {
        this.placeId = placeId;
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
    @Column(name = "sector_id")
    public Integer getSectorId() {
        return sectorId;
    }

    public void setSectorId(Integer sectorId) {
        this.sectorId = sectorId;
    }

    @ManyToOne
    @JoinColumn(name = "sector_id", insertable = false, updatable = false)
    public SectorEntity getSector() {
        return sector;
    }

    public void setSector(SectorEntity sector) {
        this.sector = sector;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "ticket_place",schema = "theater")
    public Collection<TicketEntity> getTickets() {
        return tickets;
    }

    public void setTickets(Collection<TicketEntity> tickets) {
        this.tickets = tickets;
    }

    @ManyToMany
    @JoinTable(name = "reservation_place",schema = "theater")
    public Collection<ReservationEntity> getReservations() {
        return reservations;
    }

    public void setReservations(Collection<ReservationEntity> reservations) {
        this.reservations = reservations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlaceEntity that = (PlaceEntity) o;

        if (placeId != null ? !placeId.equals(that.placeId) : that.placeId != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (sectorId != null ? !sectorId.equals(that.sectorId) : that.sectorId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = placeId != null ? placeId.hashCode() : 0;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (sectorId != null ? sectorId.hashCode() : 0);
        return result;
    }
}
