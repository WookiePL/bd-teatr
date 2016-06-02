package theater.persist.model;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "groupofclients", schema = "theater")
public class GroupOfClientsEntity {
    private Integer groupOfClientsId;
    private String name;
    private List<PriceEntity> prices;

    @Id
    @Column(name = "group_of_clients_id", columnDefinition = "serial")
    @SequenceGenerator(name = "groupofclients_group_of_clients_id_seq",
            sequenceName = "groupofclients_group_of_clients_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY,
            generator = "groupofclients_group_of_clients_id_seq")
    public Integer getGroupOfClientsId() {
        return groupOfClientsId;
    }

    public void setGroupOfClientsId(Integer groupOfClientsId) {
        this.groupOfClientsId = groupOfClientsId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "groupOfClients", targetEntity = PriceEntity.class, fetch = FetchType.LAZY)
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

        GroupOfClientsEntity that = (GroupOfClientsEntity) o;

        if (groupOfClientsId != null ? !groupOfClientsId.equals(that.groupOfClientsId) : that.groupOfClientsId != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = groupOfClientsId != null ? groupOfClientsId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
