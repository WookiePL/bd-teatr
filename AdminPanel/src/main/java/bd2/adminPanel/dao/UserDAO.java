package bd2.adminPanel.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "user", schema = "theater")
public class UserDAO {
	@Id
	@Column(name = "user_id", columnDefinition = "serial")
	@SequenceGenerator(name = "user_user_id_seq",
                sequenceName = "user_user_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
                generator = "user_user_id_seq")
	private int userId;
	private String name;
	private String surname;
	private String email;
	private String password;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "users_roles",
                joinColumns = {
                    @JoinColumn(name = "user_id")
                },
                inverseJoinColumns = {
                    @JoinColumn(name = "role_id")
                }
        )
	private List<RoleDAO> roles;

	public UserDAO() {

	}

	public UserDAO(String name, String surname,
                String email, String password) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		roles = new ArrayList<>();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<RoleDAO> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleDAO> roles) {
		this.roles = roles;
	}

        @Override
	public String toString() {
		return "ID: " + userId + ", " + name + " " + surname;
	}
}