package theater.persist.dtos;

/**
 * Created by Wookie on 2016-05-16.
 */
public class EventTypeDTO {
    private Integer eventTypeId;
    private String name;

    public Integer getEventTypeId() {
        return eventTypeId;
    }

    public void setEventTypeId(Integer eventTypeId) {
        this.eventTypeId = eventTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
