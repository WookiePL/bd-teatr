package theater.persist.daos;

import theater.persist.model.ReservationEntity;

import java.util.List;

/**
 * Created by Wookie on 2016-05-16.
 */
public interface IReservationDAO extends IBaseDAO<ReservationEntity, Integer> {

    ReservationEntity getReservationById(int id);

    List<ReservationEntity> getAllReservations();

    List<ReservationEntity> getAllReservations(int id);

    void addReservation(ReservationEntity reservation);

    void updateReservation(ReservationEntity reservation);

    void deleteReservation(int id);
}
