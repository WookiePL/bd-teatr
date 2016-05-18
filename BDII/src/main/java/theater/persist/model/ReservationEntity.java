package theater.persist.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;


@Entity
@Table(name = "reservation", schema = "theater")
public class ReservationEntity {
    private Integer reservationId;
    private String name;
    private Integer phone;
    private String email;
    private Date date;
    private Date revokeDate;
    private Integer eventRealizationId;
    private Integer userId;
    private EventRealizationEntity eventRealization;
    private List<PlaceEntity> places;

    @Id
    @Column(name = "reservation_id", columnDefinition = "serial")
    @SequenceGenerator(name = "reservation_reservation_id_seq",
            sequenceName = "reservation_reservation_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "reservation_reservation_id_seq")
    public Integer getReservationId() {
        return reservationId;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "phone")
    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    @Column(name = "revoke_date")
    public Date getRevokeDate() {
        return revokeDate;
    }

    public void setRevokeDate(Date revokeDate) {
        this.revokeDate = revokeDate;
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
    @JoinColumn(name = "event_realization_id")
    public EventRealizationEntity getEventRealization() {
        return eventRealization;
    }

    public void setEventRealization(EventRealizationEntity eventRealization) {
        this.eventRealization = eventRealization;
    }

    @OneToMany(mappedBy = "reservationEntity", fetch = FetchType.LAZY)
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

        ReservationEntity that = (ReservationEntity) o;

        if (reservationId != null ? !reservationId.equals(that.reservationId) : that.reservationId != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (revokeDate != null ? !revokeDate.equals(that.revokeDate) : that.revokeDate != null) return false;
        if (eventRealizationId != null ? !eventRealizationId.equals(that.eventRealizationId) : that.eventRealizationId != null)
            return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = reservationId != null ? reservationId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (revokeDate != null ? revokeDate.hashCode() : 0);
        result = 31 * result + (eventRealizationId != null ? eventRealizationId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }
}
