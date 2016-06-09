package bd2.adminPanel.model.dictionaries;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.core.style.ToStringCreator;

@Entity
@Table(name = "building", schema = "theater")
public class Building implements Comparable<Building> {

	private Integer buildingId;
	private String address;
	private List<Room> rooms;

	@Id
	@Column(name = "building_id", updatable = false)
	@SequenceGenerator(name = "building_building_id_seq", sequenceName = "building_building_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "building_building_id_seq")
	public Integer getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
	}

	// @Basic
	@Column(name = "address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@OneToMany(mappedBy = "building", fetch = FetchType.LAZY)
	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	@Override
	public String toString() {
		return address;
	}
	
	@Override
    public int compareTo(Building b) {
        return address.compareTo(b.getAddress());
    }
	
}
