package bd2.adminPanel.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import bd2.adminPanel.dao.repository.UsersRepository;
import bd2.adminPanel.dao.users.RoleDAO;
import bd2.adminPanel.dao.users.UserDAO;

@Component
public class Security {

	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(11);
	
	@Autowired
	private UsersRepository usersRepository;


	public boolean authentication(String email, String password) {
		UserDAO user = usersRepository.findUserByEmail(email);
		
		if(user == null) {
			return false;
		}
		
		boolean isAdmin = false;
		
		for(RoleDAO r : user.getRoles()) {
			if(r.getRole().equals("ROLE_ADMIN")) {
				isAdmin = true;
				break;
			}
		}
		
		if(!isAdmin) {
			return false;
		}
		
		if(!encoder.matches(password, user.getPassword())) {
			return false;
		}
		
		return true;
	}
	
	public String encode(String password) {
		return encoder.encode(password);
	}
	
}
