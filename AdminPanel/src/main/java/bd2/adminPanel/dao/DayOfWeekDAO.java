package bd2.adminPanel.dao;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "dayofweek", schema = "theater")
public class DayOfWeekDAO {

	@Id
	@Column(name = "day_of_week_id")
	private int DayOfWeekID;
	private String name;/*  //Klasa do zakodzenia!!! <----- <------ <-----
	@ManyToMany(mappedBy = "roles", targetEntity = UserDAO.class,
                fetch = FetchType.EAGER)
	private List<UserDAO> users;
*/
	public DayOfWeekDAO() {

	}
	/*
	public EventTypeDAO(String role) {
		this.role = role;
	}

	public EventTypeDAO(int roleId, String role, List<UserDAO> users) {
		super();
		this.roleId = roleId;
		this.role = role;
		this.users = users;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<UserDAO> getUsers() {
		return users;
	}

	public void setUsers(List<UserDAO> users) {
		this.users = users;
	}
*/
}
