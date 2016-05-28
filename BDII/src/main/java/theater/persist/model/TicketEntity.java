package theater.persist.model;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "ticket", schema = "theater")
public class TicketEntity {
    private Integer ticketId;
    private Integer number;
    private Integer eventRealizationId;
    private Integer userId;
    private EventRealizationEntity eventRealization;
    private UserEntity user;
    private List<PlaceEntity> places;


    @Id
    @Column(name = "ticket_id", columnDefinition = "serial")
    @SequenceGenerator(name = "ticket_ticket_id_seq",
            sequenceName = "ticket_ticket_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "ticket_ticket_id_seq")
    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
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
    @Column(name = "event_realization_id")
    public Integer getEventRealizationId() {
        return eventRealizationId;
    }

    public void setEventRealizationId(Integer eventRealizationId) {
        this.eventRealizationId = eventRealizationId;
    }

    @Basic
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @ManyToOne
    @JoinColumn(name = "event_realization_id", insertable = false, updatable = false)
    public EventRealizationEntity getEventRealization() {
        return eventRealization;
    }

    public void setEventRealization(EventRealizationEntity eventRealization) {
        this.eventRealization = eventRealization;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    @OneToMany(mappedBy = "ticket", targetEntity = PlaceEntity.class, fetch = FetchType.LAZY)
    public List<PlaceEntity> getPlaces() {
        return places;
    }

    public void setPlaces(List<PlaceEntity> places) {
        this.places = places;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TicketEntity that = (TicketEntity) o;

        if (ticketId != null ? !ticketId.equals(that.ticketId) : that.ticketId != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (eventRealizationId != null ? !eventRealizationId.equals(that.eventRealizationId) : that.eventRealizationId != null)
            return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ticketId != null ? ticketId.hashCode() : 0;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (eventRealizationId != null ? eventRealizationId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }
}
