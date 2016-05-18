package theater.persist.daos;

import theater.persist.model.TicketEntity;

import java.util.List;

/**
 * Created by Wookie on 2016-05-18.
 */
public class TicketDAO extends BaseDAO<TicketEntity, Integer> implements ITicketDAO {
    @Override
    public TicketEntity getTicketById(int id) {
        TicketEntity ticket = super.readById(id);
        if (ticket != null) {
            return ticket;
        }
        return null;
    }

    @Override
    public List<TicketEntity> getAllTickets() {
        return super.getAll();
    }

    @Override
    public void addTicket(TicketEntity ticket) {
        super.create(ticket);
    }

    @Override
    public void updateTicket(TicketEntity ticket) {
        super.update(ticket);
    }

    @Override
    public void deleteTicket(int id) {
        TicketEntity ticket = super.readById(id);
        if (ticket != null) {
            super.delete(ticket);
        }
    }
}
