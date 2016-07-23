package theater.persist.dtos;

import theater.persist.model.PriceEntity;

import java.sql.Date;
import java.util.List;

/**
 * Created by Wookie on 2016-05-16.
 */
public class PriceListDTO {
    private Integer priceListId;
    private Date from;
    private Date to;
    private Integer eventId;
    private String name;
    private List<PriceEntity> prices;

    public Integer getPriceListId() {
        return priceListId;
    }

    public void setPriceListId(Integer priceListId) {
        this.priceListId = priceListId;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PriceEntity> getPrices() { return prices; }

    public void setPrices(List<PriceEntity> prices) { this.prices = prices; }
}
