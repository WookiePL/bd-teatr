package bd2.adminPanel.tmp;

import java.util.List;

public class User {
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private List<Right> rights;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Right> getRights() {
		return rights;
	}

	public void setRights(List<Right> rights) {
		this.rights = rights;
	}

	public User(String id, String firstName, String lastName, String email, String phone, List<Right> rights) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.rights = rights;
	}

	@Override
	public String toString() {
		return "Id: " + id + ", "+ firstName + " " + lastName;
	}
}
