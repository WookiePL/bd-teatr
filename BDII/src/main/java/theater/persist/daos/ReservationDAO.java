package theater.persist.daos;

import theater.persist.model.ReservationEntity;

import java.util.List;

/**
 * Created by Wookie on 2016-05-16.
 */
public class ReservationDAO extends BaseDAO<ReservationEntity, Integer> implements IReservationDAO {
    @Override
    public ReservationEntity getReservationById(int id) {
        ReservationEntity reservation = super.readById(id);
        if (reservation != null) {
            return reservation;
        }
        return null;
    }

    @Override
    public List<ReservationEntity> getAllReservations() {
        return super.getAll();
    }

    @Override
    public void addReservation(ReservationEntity reservation) {
        super.create(reservation);
    }

    @Override
    public void updateReservation(ReservationEntity reservation) {
        super.update(reservation);
    }

    @Override
    public void deleteReservation(int id) {
        ReservationEntity reservation = super.readById(id);
        if (reservation != null) {
            super.delete(reservation);
        }
    }
}
