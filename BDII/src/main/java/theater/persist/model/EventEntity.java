package theater.persist.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "event", schema = "theater")
public class EventEntity {
    private Integer eventId;
    private String name;
    private String description;
    private Integer eventTypeId;
    private EventTypeEntity eventType;
    private List<EventRealizationEntity> eventRealizations;
    private List<PriceListEntity> priceListEntities;


    @Id
    @Column(name = "event_id", columnDefinition = "serial")
    @SequenceGenerator(name = "event_event_id_seq",
            sequenceName = "event_event_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "event_event_id_seq")
    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "event_type_id")
    public Integer getEventTypeId() {
        return eventTypeId;
    }

    public void setEventTypeId(Integer eventTypeId) {
        this.eventTypeId = eventTypeId;
    }

    @ManyToOne
    @JoinColumn(name = "event_type_id", insertable = false, updatable = false)
    public EventTypeEntity getEventType() {
        return eventType;
    }

    public void setEventType(EventTypeEntity eventType) {
        this.eventType = eventType;
    }

    @OneToMany(mappedBy = "event", fetch = FetchType.LAZY)
    public List<EventRealizationEntity> getEventRealizations() {
        return eventRealizations;
    }

    public void setEventRealizations(List<EventRealizationEntity> eventRealizations) {
        this.eventRealizations = eventRealizations;
    }

    @OneToMany(mappedBy = "event", fetch = FetchType.LAZY)
    public List<PriceListEntity> getPriceListEntities() {
        return priceListEntities;
    }

    public void setPriceListEntities(List<PriceListEntity> priceListEntities) {
        this.priceListEntities = priceListEntities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EventEntity that = (EventEntity) o;

        if (eventId != null ? !eventId.equals(that.eventId) : that.eventId != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (eventTypeId != null ? !eventTypeId.equals(that.eventTypeId) : that.eventTypeId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = eventId != null ? eventId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (eventTypeId != null ? eventTypeId.hashCode() : 0);
        return result;
    }
}
