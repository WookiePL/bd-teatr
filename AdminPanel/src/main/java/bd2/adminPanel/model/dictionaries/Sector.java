package bd2.adminPanel.model.dictionaries;

import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name = "sector", schema = "theater")
public class Sector implements Comparable<Sector> {

	private Integer sectorId;
    private Integer number;
    private Integer roomId;
    private Integer size_X;
    private Integer size_Y;
    private Room room;
    private List<Place> places;
	
    @Id
    @Column(name = "sector_id", columnDefinition = "serial")
    @SequenceGenerator(name = "sector_sector_id_seq", sequenceName = "sector_sector_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "sector_sector_id_seq")
    public Integer getSectorId() {
        return sectorId;
    }

    public void setSectorId(Integer sectorId) {
        this.sectorId = sectorId;
    }

    @Column(name = "number")
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Column(name = "room_id")
    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getSize_X() {
        return size_X;
    }

    public void setSize_X(Integer size_X) {
        this.size_X = size_X;
    }

    public Integer getSize_Y() {
        return size_Y;
    }

    public void setSize_Y(Integer size_Y) {
        this.size_Y = size_Y;
    }
    
    @ManyToOne
    @JoinColumn(name = "room_id", insertable = false, updatable = false)
    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
    
    @OneToMany(mappedBy = "sector", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }
    
    @Override
	public String toString() {
		return number.toString();
	}
    
    @Override
    public int compareTo(Sector s) {
        return number.compareTo(s.getNumber());
    }
}
