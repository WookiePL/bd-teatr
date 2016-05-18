package theater.persist.dtos;

import java.math.BigInteger;

/**
 * Created by Wookie on 2016-05-16.
 */
public class PriceDTO {
    private BigInteger price;
    private Integer priceId;
    private Integer groupOfClientsId;
    private Integer priceListId;
    private Integer periodId;

    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }

    public Integer getPriceId() {
        return priceId;
    }

    public void setPriceId(Integer priceId) {
        this.priceId = priceId;
    }

    public Integer getGroupOfClientsId() {
        return groupOfClientsId;
    }

    public void setGroupOfClientsId(Integer groupOfClientsId) {
        this.groupOfClientsId = groupOfClientsId;
    }

    public Integer getPriceListId() {
        return priceListId;
    }

    public void setPriceListId(Integer priceListId) {
        this.priceListId = priceListId;
    }

    public Integer getPeriodId() {
        return periodId;
    }

    public void setPeriodId(Integer periodId) {
        this.periodId = periodId;
    }
}
