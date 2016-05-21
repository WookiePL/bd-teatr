package theater.persist.dtos;

import java.sql.Date;

/**
 * Created by Wookie on 2016-05-16.
 */
public class ReservationDTO {
    private Integer reservationId;
    private String name;
    private Integer phone;
    private String email;
    private Date date;
    private Date revokeDate;
    private Integer eventRealizationId;
    private Integer userId;

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
}
