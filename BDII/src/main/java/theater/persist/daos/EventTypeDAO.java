package theater.persist.daos;

import org.springframework.stereotype.Repository;
import theater.persist.model.EventTypeEntity;

import java.util.List;

@Repository
public class EventTypeDAO extends BaseDAO<EventTypeEntity, Integer> implements IEventTypeDAO {

    @Override
    public EventTypeEntity getEventTypeById(int id) {
        EventTypeEntity eventType = super.readById(id);
        if (eventType != null) {
            return eventType;
        }
        return null;
    }

    @Override
    public List<EventTypeEntity> getAllEventTypes() {
        return super.getAll();
    }

    @Override
    public void addEventType(EventTypeEntity eventType) {
        super.create(eventType);
    }

    @Override
    public void updateEventType(EventTypeEntity eventType) {
        super.update(eventType);
    }

    @Override
    public void deleteEventType(int id) {
        EventTypeEntity eventType = super.readById(id);
        if (eventType != null) {
            super.delete(eventType);
        }
    }
}
