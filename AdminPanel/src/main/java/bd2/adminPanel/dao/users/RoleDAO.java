package bd2.adminPanel.dao.users;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role", schema = "theater")
public class RoleDAO {

	@Id
	@Column(name = "role_id")
	private int roleId;
	private String role;
	@ManyToMany(mappedBy = "roles", targetEntity = UserDAO.class, fetch = FetchType.EAGER)
	private List<UserDAO> users;

	public RoleDAO() {

	}

	public RoleDAO(String role) {
		this.role = role;
	}

	public RoleDAO(int roleId, String role, List<UserDAO> users) {
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

}
