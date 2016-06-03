package theater.persist.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "eventrealization", schema = "theater")
public class EventRealizationEntity {
    private Date date;
    private Integer eventRealizationId;
    private Integer price;
    private Integer hour;
    private Integer eventId;
    private Integer roomId;
    private RoomEntity room;
    private EventEntity event;
    private List<ReservationEntity> reservations;
    private List<TicketEntity> tickets;

    @Id
    @Column(name = "event_realization_id", columnDefinition = "serial")
    @SequenceGenerator(name = "eventrealization_event_realization_id_seq",
            sequenceName = "eventrealization_event_realization_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY,
            generator = "eventrealization_event_realization_id_seq")
    public Integer getEventRealizationId() {
        return eventRealizationId;
    }

    public void setEventRealizationId(Integer eventRealizationId) {
        this.eventRealizationId = eventRealizationId;
    }

    @Basic
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    @Basic
    @Column(name = "price")
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Basic
    @Column(name = "hour")
    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    @Basic
    @Column(name = "event_id")
    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    @Basic
    @Column(name = "room_id")
    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    @ManyToOne
    @JoinColumn(name = "room_id", insertable = false, updatable = false)
    public RoomEntity getRoom() {
        return room;
    }

    public void setRoom(RoomEntity room) {
        this.room = room;
    }

    @ManyToOne
    @JoinColumn(name = "event_id", insertable = false, updatable = false)
    public EventEntity getEvent() {
        return event;
    }

    public void setEvent(EventEntity event) {
        this.event = event;
    }

    @OneToMany(mappedBy = "eventRealization", fetch = FetchType.LAZY)
    public List<ReservationEntity> getReservations() {
        return reservations;
    }

    public void setReservations(List<ReservationEntity> reservations) {
        this.reservations = reservations;
    }

    @OneToMany(mappedBy = "eventRealization", targetEntity = TicketEntity.class, fetch = FetchType.LAZY)
    public List<TicketEntity> getTickets() {
        return tickets;
    }

    public void setTickets(List<TicketEntity> tickets) {
        this.tickets = tickets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EventRealizationEntity that = (EventRealizationEntity) o;

        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (eventRealizationId != null ? !eventRealizationId.equals(that.eventRealizationId) : that.eventRealizationId != null)
            return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (hour != null ? !hour.equals(that.hour) : that.hour != null) return false;
        if (eventId != null ? !eventId.equals(that.eventId) : that.eventId != null) return false;
        if (roomId != null ? !roomId.equals(that.roomId) : that.roomId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = date != null ? date.hashCode() : 0;
        result = 31 * result + (eventRealizationId != null ? eventRealizationId.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (hour != null ? hour.hashCode() : 0);
        result = 31 * result + (eventId != null ? eventId.hashCode() : 0);
        result = 31 * result + (roomId != null ? roomId.hashCode() : 0);
        return result;
    }
}
