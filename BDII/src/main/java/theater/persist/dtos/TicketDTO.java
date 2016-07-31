package theater.persist.dtos;

import theater.persist.model.EventRealizationEntity;
import theater.persist.model.PlaceEntity;
import theater.persist.model.UserEntity;

import java.util.Collection;

public class TicketDTO {
    private Integer ticketId;
    private Integer number;
    private Integer eventRealizationId;
    private Integer userId;
    private EventRealizationEntity eventRealization;
    private UserEntity user;
    private Collection<PlaceEntity> places;

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getEventRealizationId() {
        return eventRealizationId;
    }

    public void setEventRealizationId(Integer eventRealizationId) {
        this.eventRealizationId = eventRealizationId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public EventRealizationEntity getEventRealization() {
        return eventRealization;
    }

    public void setEventRealization(EventRealizationEntity eventRealization) {
        this.eventRealization = eventRealization;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Collection<PlaceEntity> getPlaces() {
        return places;
    }

    public void setPlaces(Collection<PlaceEntity> places) {
        this.places = places;
    }
}
