package theater.persist.daos;

import theater.persist.model.EventTypeEntity;

import java.util.List;

/**
 * Created by Wookie on 2016-05-16.
 */
public interface IEventTypeDAO extends IBaseDAO<EventTypeEntity, Integer> {

    EventTypeEntity getEventTypeById(int id);

    List<EventTypeEntity> getAllEventTypes();

    void addEventType(EventTypeEntity eventType);

    void updateEventType(EventTypeEntity eventType);

    void deleteEventType(int id);
}
