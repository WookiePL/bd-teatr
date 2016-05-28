package theater.persist.daos;

import theater.persist.model.UserEntity;

import java.util.List;


public interface IUserDAO extends IBaseDAO<UserEntity, Integer> {

    UserEntity getUserById(int id);

    UserEntity getUserByEmail(String email);

    List<UserEntity> getAllUsers();

    void addUser(UserEntity user);

    void updateUser(UserEntity user);

    void deleteUser(int id);

}
