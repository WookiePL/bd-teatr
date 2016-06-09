package bd2.adminPanel.model.dictionaries;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "groupofclients", schema = "theater")
public class GroupOfClient implements Comparable<GroupOfClient>{

    @Id
    @Column(name = "group_of_clients_id", columnDefinition = "serial")
    @SequenceGenerator(name = "groupofclients_group_of_clients_id_seq", sequenceName = "groupofclients_group_of_clients_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "groupofclients_group_of_clients_id_seq")
    private int groupOfClientID;
    private String name;

    public GroupOfClient() {

    }

    public GroupOfClient(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(GroupOfClient t) {
        return name.compareTo(t.getName());
    }
}
