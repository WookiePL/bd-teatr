package bd2.adminPanel.model.dictionaries;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "room", schema = "theater")
public class Room implements Comparable<Room> {

	private Integer roomId;
	private Integer number;
	private Integer buildingId;
	private Building building;
	private List<Sector> sectors;

	@Id
	@Column(name = "room_id", columnDefinition = "serial")
	@SequenceGenerator(name = "room_room_id_seq", sequenceName = "room_room_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "room_room_id_seq")
	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	@Column(name = "number")
	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	@Column(name = "building_id")
	public Integer getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
	}

	@ManyToOne
	@JoinColumn(name = "building_id", insertable = false, updatable = false)
	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	@OneToMany(mappedBy = "room", fetch = FetchType.LAZY)
	public List<Sector> getSectors() {
		return sectors;
	}

	public void setSectors(List<Sector> sectors) {
		this.sectors = sectors;
	}
	
	@Override
	public String toString() {
		return number.toString();
	}
	
	 @Override
	    public int compareTo(Room r) {
	        return number.compareTo(r.getNumber());
	    }
}
