package bd2.adminPanel.dao.dictionaries;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "eventtype", schema = "theater")
public class EventTypeDAO {

	@Id
	@Column(name = "event_type_id")
	@SequenceGenerator(name = "eventtype_event_type_id_seq", sequenceName = "eventtype_event_type_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "eventtype_event_type_id_seq")
	private int eventTypeID;
	private String name;

	public EventTypeDAO() {
	}

	public EventTypeDAO(String name) {
		this.name = name;
	}

	public int getEventTypeID() {
		return eventTypeID;
	}

	public void setEventTypeID(int eventTypeID) {
		this.eventTypeID = eventTypeID;
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
