package theater.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import theater.persist.daos.RoleDAO;
import theater.persist.daos.UserDAO;
import theater.persist.dtos.UserDTO;
import theater.persist.model.RoleEntity;
import theater.persist.model.UserEntity;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService implements IUserService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RoleDAO roleDAO;



    @Override
    public UserDTO getUserById(int id) {
        return convertToDto(userDAO.getUserById(id));
    }

    @Override
    public UserDTO getUserByEmail(String email) throws SQLException {
        UserDTO userDTO = convertToDto(userDAO.getUserByEmail(email));
        return userDTO;
    }

    @Override
    public void addUser(UserDTO userDTO) {
        // RoleEntity adminRole = roleDAO.findByName("ROLE_ADMIN");
        RoleEntity userRole = roleDAO.findByName("ROLE_USER");
        userDTO.setRoleEntities(Arrays.asList(userRole/*, adminRole*/));
        userDAO.addUser(convertToUserEntity(userDTO));
    }

    @Override
    public void updateUser(UserDTO userDTO) {
        RoleEntity userRole = roleDAO.findByName("ROLE_USER");
        userDTO.setRoleEntities(Arrays.asList(userRole));
        userDAO.updateUser(convertToUserEntity(userDTO));
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserDTO> userDTOs = userDAO.getAllUsers().stream().map(this::convertToDto).collect(Collectors.toList());
        return userDTOs;
    }


    private UserDTO convertToDto(UserEntity user) {
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        return userDTO;
    }

    private UserEntity convertToUserEntity(UserDTO userDto) throws ParseException {
        UserEntity user = modelMapper.map(userDto, UserEntity.class);
        return user;
    }
}
