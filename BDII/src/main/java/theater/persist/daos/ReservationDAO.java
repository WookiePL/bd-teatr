package theater.persist.daos;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import theater.persist.model.ReservationEntity;

import java.util.List;
@Repository
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
    public List<ReservationEntity> getAllReservations(int id) {
        Criteria criteria = super.getCriteria();
        return criteria.add(Restrictions.eq("reservationId", id)).list();
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
