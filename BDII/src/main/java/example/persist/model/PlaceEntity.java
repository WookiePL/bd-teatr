package example.persist.model;

import javax.persistence.*;

@Entity
@Table(name = "place", schema = "theater")
public class PlaceEntity {
    private Integer placeId;
    private Integer number;
    private Integer sectorId;
    private Integer ticketId;
    private Integer reservationId;

    @Id
    @Column(name = "place_id", columnDefinition = "serial")
    @SequenceGenerator(name = "place_place_id_seq",
            sequenceName = "place_place_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
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

    @Basic
    @Column(name = "ticket_id")
    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    @Basic
    @Column(name = "reservation_id")
    public Integer getReservationId() {
        return reservationId;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlaceEntity that = (PlaceEntity) o;

        if (placeId != null ? !placeId.equals(that.placeId) : that.placeId != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (sectorId != null ? !sectorId.equals(that.sectorId) : that.sectorId != null) return false;
        if (ticketId != null ? !ticketId.equals(that.ticketId) : that.ticketId != null) return false;
        if (reservationId != null ? !reservationId.equals(that.reservationId) : that.reservationId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = placeId != null ? placeId.hashCode() : 0;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (sectorId != null ? sectorId.hashCode() : 0);
        result = 31 * result + (ticketId != null ? ticketId.hashCode() : 0);
        result = 31 * result + (reservationId != null ? reservationId.hashCode() : 0);
        return result;
    }
}
