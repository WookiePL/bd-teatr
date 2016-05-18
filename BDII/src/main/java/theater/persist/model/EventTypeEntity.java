package theater.persist.model;

import javax.persistence.*;

@Entity
@Table(name = "eventtype", schema = "theater")
public class EventTypeEntity {
    private Integer eventTypeId;
    private String name;

    @Id
    @Column(name = "event_type_id", columnDefinition = "serial")
    @SequenceGenerator(name = "eventtype_event_type_id_seq",
            sequenceName = "eventtype_event_type_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
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
