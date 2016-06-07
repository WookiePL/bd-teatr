package bd2.adminPanel.dao.dictionaries;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dayofweek", schema = "theater")
public class DayOfWeekDAO {

	@Id
	@Column(name = "day_of_week_id")
	private int DayOfWeekID;
	private String name;
	
	public DayOfWeekDAO() {
		
	}
	
	public DayOfWeekDAO(String name) {
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
