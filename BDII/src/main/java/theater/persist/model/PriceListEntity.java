package theater.persist.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;


@Entity
@Table(name = "pricelist", schema = "theater")
public class PriceListEntity {
    private Integer priceListId;
    private Date from;
    private Date to;
    private Integer eventId;
    private EventEntity event;
    private List<PriceEntity> prices;

    @Id
    @Column(name = "price_list_id", columnDefinition = "serial")
    @SequenceGenerator(name = "pricelist_price_list_id_seq",
            sequenceName = "pricelist_price_list_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "pricelist_price_list_id_seq")
    public Integer getPriceListId() {
        return priceListId;
    }

    public void setPriceListId(Integer priceListId) {
        this.priceListId = priceListId;
    }

    @Basic
    @Column(name = "from")
    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    @Basic
    @Column(name = "to")
    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    @Basic
    @Column(name = "event_id")
    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    @ManyToOne
    @JoinColumn(name = "event_id", insertable = false, updatable = false)
    public EventEntity getEvent() {
        return event;
    }

    public void setEvent(EventEntity event) {
        this.event = event;
    }

    @OneToMany(mappedBy = "priceList", targetEntity = PriceEntity.class, fetch = FetchType.LAZY)
    public List<PriceEntity> getPrices() {
        return prices;
    }

    public void setPrices(List<PriceEntity> prices) {
        this.prices = prices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PriceListEntity that = (PriceListEntity) o;

        if (priceListId != null ? !priceListId.equals(that.priceListId) : that.priceListId != null) return false;
        if (from != null ? !from.equals(that.from) : that.from != null) return false;
        if (to != null ? !to.equals(that.to) : that.to != null) return false;
        if (eventId != null ? !eventId.equals(that.eventId) : that.eventId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = priceListId != null ? priceListId.hashCode() : 0;
        result = 31 * result + (from != null ? from.hashCode() : 0);
        result = 31 * result + (to != null ? to.hashCode() : 0);
        result = 31 * result + (eventId != null ? eventId.hashCode() : 0);
        return result;
    }
}
