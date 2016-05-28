package theater.persist.daos;

import theater.persist.model.EventRealizationEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class EventRealizationDAO extends BaseDAO<EventRealizationEntity, Integer> implements IEventRealizationDAO {

    @Override
    public EventRealizationEntity getEventRealizationById(int id) {
        EventRealizationEntity eventRealization = super.readById(id);
        if (eventRealization != null) {
            return eventRealization;
        }
        return null;
    }

    @Override
    public List<EventRealizationEntity> getAllEventRealizations() {
        return super.getAll();
    }

    @Override
    public void addEventRealiztion(EventRealizationEntity eventRealization) {
        super.create(eventRealization);
    }

    @Override
    public void updateEventRealiztion(EventRealizationEntity eventRealization) {
        super.update(eventRealization);
    }

    @Override
    public void deleteEventRealiztion(int id) {
        EventRealizationEntity eventRealization = super.readById(id);
        if (eventRealization != null) {
            super.delete(eventRealization);
        }
    }
}
