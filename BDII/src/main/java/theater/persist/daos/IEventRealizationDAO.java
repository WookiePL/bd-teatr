package theater.persist.daos;

import theater.persist.model.EventRealizationEntity;

import java.util.List;

/**
 * Created by Wookie on 2016-05-16.
 */
public interface IEventRealizationDAO extends IBaseDAO<EventRealizationEntity, Integer> {

    EventRealizationEntity getEventRealizationById(int id);

    List<EventRealizationEntity> getAllEventRealizations();

    void addEventRealization(EventRealizationEntity eventRealization);

    void updateEventRealization(EventRealizationEntity eventRealization);

    void deleteEventRealization(int id);


}
