package theater.persist.daos;

import theater.persist.model.EventEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class EventDAO extends BaseDAO<EventEntity, Integer> implements IEventDAO {


    @Override
    public EventEntity getEventById(int id) {
        EventEntity event = super.readById(id);
        if (event != null) {
            return event;
        }
        return null;
    }

    @Override
    public List<EventEntity> getAllEvents() {
        return super.getAll();
    }

    @Override
    public void addEvent(EventEntity event) {
        super.create(event);
    }

    @Override
    public void updateEvent(EventEntity event) {
        super.update(event);
    }

    @Override
    public void deleteEvent(int id) {
        EventEntity event = super.readById(id);
        if (event != null) {
            super.delete(event);
        }
    }
}
