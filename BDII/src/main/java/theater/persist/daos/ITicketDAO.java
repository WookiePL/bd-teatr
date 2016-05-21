package theater.persist.daos;

import theater.persist.model.TicketEntity;

import java.util.List;

/**
 * Created by Wookie on 2016-05-16.
 */
public interface ITicketDAO extends IBaseDAO<TicketEntity, Integer> {

    TicketEntity getTicketById(int id);

    List<TicketEntity> getAllTickets();

    void addTicket(TicketEntity ticket);

    void updateTicket(TicketEntity ticket);

    void deleteTicket(int id);

}


