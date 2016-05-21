package theater.persist.model;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "price", schema = "theater")
public class PriceEntity {
    private BigInteger price;
    private Integer priceId;
    private Integer groupOfClientsId;
    private Integer priceListId;
    private Integer periodId;
    private PriceListEntity priceList;
    private GroupOfClientsEntity groupOfClients;
    private PeriodEntity period;

    @Id
    @Column(name = "price_id", columnDefinition = "serial")
    @SequenceGenerator(name = "price_price_id_seq",
            sequenceName = "price_price_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "price_price_id_seq")
    public Integer getPriceId() {
        return priceId;
    }

    public void setPriceId(Integer priceId) {
        this.priceId = priceId;
    }

    @Basic
    @Column(name = "price")
    public BigInteger getPrice() {
        return price;
    }


    public void setPrice(BigInteger price) {
        this.price = price;
    }

    @Basic
    @Column(name = "group_of_clients_id")
    public Integer getGroupOfClientsId() {
        return groupOfClientsId;
    }

    public void setGroupOfClientsId(Integer groupOfClientsId) {
        this.groupOfClientsId = groupOfClientsId;
    }

    @Basic
    @Column(name = "price_list_id")
    public Integer getPriceListId() {
        return priceListId;
    }

    public void setPriceListId(Integer priceListId) {
        this.priceListId = priceListId;
    }

    @Basic
    @Column(name = "period_id")
    public Integer getPeriodId() {
        return periodId;
    }

    public void setPeriodId(Integer periodId) {
        this.periodId = periodId;
    }

    @ManyToOne
    @JoinColumn(name = "price_list_id")
    public PriceListEntity getPriceList() {
        return priceList;
    }

    public void setPriceList(PriceListEntity priceList) {
        this.priceList = priceList;
    }

    @ManyToOne
    @JoinColumn(name = "group_of_clients_id")
    public GroupOfClientsEntity getGroupOfClients() {
        return groupOfClients;
    }

    public void setGroupOfClients(GroupOfClientsEntity groupOfClients) {
        this.groupOfClients = groupOfClients;
    }

    @ManyToOne
    @JoinColumn(name = "period_id")
    public PeriodEntity getPeriod() {
        return period;
    }

    public void setPeriod(PeriodEntity period) {
        this.period = period;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PriceEntity that = (PriceEntity) o;

        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (priceId != null ? !priceId.equals(that.priceId) : that.priceId != null) return false;
        if (groupOfClientsId != null ? !groupOfClientsId.equals(that.groupOfClientsId) : that.groupOfClientsId != null)
            return false;
        if (priceListId != null ? !priceListId.equals(that.priceListId) : that.priceListId != null) return false;
        if (periodId != null ? !periodId.equals(that.periodId) : that.periodId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = price != null ? price.hashCode() : 0;
        result = 31 * result + (priceId != null ? priceId.hashCode() : 0);
        result = 31 * result + (groupOfClientsId != null ? groupOfClientsId.hashCode() : 0);
        result = 31 * result + (priceListId != null ? priceListId.hashCode() : 0);
        result = 31 * result + (periodId != null ? periodId.hashCode() : 0);
        return result;
    }
}
