package theater.persist.daos;

import theater.persist.model.EventEntity;

import java.util.List;

/**
 * Created by Wookie on 2016-05-16.
 */
public interface IEventDAO extends IBaseDAO<EventEntity, Integer> {
    EventEntity getEventById(int id);

    List<EventEntity> getAllEvents();

    void addEvent(EventEntity event);

    void updateEvent(EventEntity event);

    void deleteEvent(int id);

}
