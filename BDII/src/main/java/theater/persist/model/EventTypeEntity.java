package theater.persist.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "eventtype", schema = "theater")
public class EventTypeEntity {
    private Integer eventTypeId;
    private String name;
    private List<EventEntity> events;

    @Id
    @Column(name = "event_type_id", columnDefinition = "serial")
    @SequenceGenerator(name = "eventtype_event_type_id_seq",
            sequenceName = "eventtype_event_type_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY,
            generator = "eventtype_event_type_id_seq")
    public Integer getEventTypeId() {
        return eventTypeId;
    }

    public void setEventTypeId(Integer eventTypeId) {
        this.eventTypeId = eventTypeId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "eventType", fetch = FetchType.LAZY)
    public List<EventEntity> getEvents() {
        return events;
    }

    public void setEvents(List<EventEntity> events) {
        this.events = events;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EventTypeEntity that = (EventTypeEntity) o;

        if (eventTypeId != null ? !eventTypeId.equals(that.eventTypeId) : that.eventTypeId != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = eventTypeId != null ? eventTypeId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
