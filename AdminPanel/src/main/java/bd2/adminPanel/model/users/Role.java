package bd2.adminPanel.model.users;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role", schema = "theater")
public class Role {

	@Id
	@Column(name = "role_id")
	private int roleId;
	private String role;
	@ManyToMany(mappedBy = "roles", targetEntity = User.class, fetch = FetchType.EAGER)
	private List<User> users;

	public Role() {

	}

	public Role(String role) {
		this.role = role;
	}

	public Role(int roleId, String role, List<User> users) {
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

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
