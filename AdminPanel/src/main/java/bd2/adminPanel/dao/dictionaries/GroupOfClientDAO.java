package bd2.adminPanel.dao.dictionaries;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "groupofclients", schema = "theater")
public class GroupOfClientDAO {

	@Id
	@Column(name = "group_of_clients_id", columnDefinition = "serial")
	@SequenceGenerator(name = "groupofclients_group_of_clients_id_seq", sequenceName = "groupofclients_group_of_clients_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "groupofclients_group_of_clients_id_seq")
	private int groupOfClientID;
	private String name;

	public GroupOfClientDAO() {

	}
	
	public GroupOfClientDAO(String name) {
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

}
