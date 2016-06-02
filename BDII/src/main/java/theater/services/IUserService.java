package theater.services;



import theater.persist.dtos.UserDTO;

import java.sql.SQLException;
import java.util.List;


public interface IUserService {

   UserDTO getUserById(int id);

    UserDTO getUserByEmail(String email) throws SQLException;

    void addUser(UserDTO userDTO);

    void updateUser(UserDTO userDTO);

    List<UserDTO> getAllUsers();
}
