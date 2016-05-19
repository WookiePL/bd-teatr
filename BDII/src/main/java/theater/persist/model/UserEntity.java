package theater.persist.model;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "user", schema = "theater")
public class UserEntity {
    private Integer userId;
    private String name;
    private String surname;
    private List<ReservationEntity> reservations;
    private List<TicketEntity> tickets;
    private List<JoinUsersToRolesEntity> joinUsersToRolesEntities;


    @Id
    @Column(name = "user_id", columnDefinition = "serial")
    @SequenceGenerator(name = "user_user_id_seq",
            sequenceName = "user_user_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "user_user_id_seq")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @OneToMany(mappedBy = "userEntity", fetch = FetchType.LAZY)
    public List<ReservationEntity> getReservations() {
        return reservations;
    }

    public void setReservations(List<ReservationEntity> reservations) {
        this.reservations = reservations;
    }

    @OneToMany(mappedBy = "userEntity", fetch = FetchType.LAZY)
    public List<TicketEntity> getTickets() {
        return tickets;
    }

    public void setTickets(List<TicketEntity> tickets) {
        this.tickets = tickets;
    }

    @OneToMany(mappedBy = "userEntity", fetch = FetchType.LAZY)
    public List<JoinUsersToRolesEntity> getJoinUsersToRolesEntities() {
        return joinUsersToRolesEntities;
    }

    public void setJoinUsersToRolesEntities(List<JoinUsersToRolesEntity> joinUsersToRolesEntities) {
        this.joinUsersToRolesEntities = joinUsersToRolesEntities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        return result;
    }
}
