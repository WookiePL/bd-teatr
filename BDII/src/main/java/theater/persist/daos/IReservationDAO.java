package theater.persist.daos;

import theater.persist.model.ReservationEntity;

import java.util.List;

public interface IReservationDAO extends IBaseDAO<ReservationEntity, Integer> {

    ReservationEntity getReservationById(int id);

    List<ReservationEntity> getAllReservations();

    List<ReservationEntity> getAllReservationsByRealization(int id);

    List<ReservationEntity> getAllReservations(int id);

    void addReservation(ReservationEntity reservation);

    void updateReservation(ReservationEntity reservation);

    void deleteReservation(int id);
}
