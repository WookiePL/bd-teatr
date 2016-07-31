package theater.persist.dtos;

import theater.persist.model.ReservationEntity;
import theater.persist.model.TicketEntity;

import java.util.Collection;

public class PlaceDTO {
    private Integer placeId;
    private Integer number;
    private Integer sectorId;
    private Collection<TicketEntity> tickets;
    private Collection<ReservationEntity> reservations;

    public Integer getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Integer placeId) {
        this.placeId = placeId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getSectorId() {
        return sectorId;
    }

    public void setSectorId(Integer sectorId) {
        this.sectorId = sectorId;
    }

    public Collection<TicketEntity> getTickets() {
        return tickets;
    }

    public void setTickets(Collection<TicketEntity> tickets) {
        this.tickets = tickets;
    }

    public Collection<ReservationEntity> getReservations() {
        return reservations;
    }

    public void setReservations(Collection<ReservationEntity> reservations) {
        this.reservations = reservations;
    }
}
