package bd2.adminPanel.tmp;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
	private List<User> users = new ArrayList<>();

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public UserRepository() {
		List<Right> rightUser1 = new ArrayList<>();
		rightUser1.add(new Right(Right.RIGHT_1_ID, Right.RIGHT_1_NAME, Right.RIGHT_1_CODE));
		
		List<Right> rightUser2 = new ArrayList<>();
		rightUser2.add(new Right(Right.RIGHT_2_ID, Right.RIGHT_2_NAME, Right.RIGHT_2_CODE));
		rightUser2.add(new Right(Right.RIGHT_3_ID, Right.RIGHT_3_NAME, Right.RIGHT_3_CODE));
		
		List<Right> rightUser3 = new ArrayList<>();
		rightUser3.add(new Right(Right.RIGHT_3_ID, Right.RIGHT_3_NAME, Right.RIGHT_3_CODE));
		rightUser3.add(new Right(Right.RIGHT_5_ID, Right.RIGHT_5_NAME, Right.RIGHT_5_CODE));
		
		users.add(new User("1", "Jan", "Kowalski", "jan.kowalski@mail.com", "111-111-111", rightUser1));
		users.add(new User("2", "Krzysztof", "Nowak", "krzysztof.nowak@mail.com", "222-222-222", rightUser2));
		users.add(new User("3", "Tomasz", "Jaworek", "tomasz.jaworek@mail.com", "333-333-333",rightUser3));
	}

}
