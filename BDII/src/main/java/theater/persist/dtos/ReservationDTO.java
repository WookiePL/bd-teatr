package theater.persist.dtos;

import theater.persist.model.EventRealizationEntity;
import theater.persist.model.PlaceEntity;
import theater.persist.model.UserEntity;

import java.sql.Date;
import java.util.Collection;
import java.util.List;


public class ReservationDTO {
    private Integer reservationId;
    private String name;
    private String surname;
    private Integer phone;
    private String email;
    private Date date;
    private Date revokeDate;
    private Integer eventRealizationId;
    private Integer userId;
    private EventRealizationEntity eventRealization;
    private UserEntity user;
    private Collection<PlaceEntity> places;

    public Integer getReservationId() {
        return reservationId;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getRevokeDate() {
        return revokeDate;
    }

    public void setRevokeDate(Date revokeDate) {
        this.revokeDate = revokeDate;
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
