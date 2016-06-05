package bd2.adminPanel.dao;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "groupofclients", schema = "theater")
public class GroupOfClientDAO {

	@Id
	@Column(name = "group_of_clients_id")
	private int groupOfClientID;
	private String name;/*  //Klasa do zakodzenia!!! <----- <------ <-----
	@ManyToMany(mappedBy = "roles", targetEntity = UserDAO.class,
                fetch = FetchType.EAGER)
	private List<UserDAO> users;
*/
	public GroupOfClientDAO() {

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
