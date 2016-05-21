package theater.persist.daos;

import theater.persist.model.UserEntity;

import java.util.List;

/**
 * Created by Wookie on 2016-05-16.
 */
public interface IUserDAO extends IBaseDAO<UserEntity, Integer> {

    UserEntity getUserByid(int id);

    List<UserEntity> getAllUsers();

    void addUser(UserEntity user);

    void updateUser(UserEntity user);

    void deleteUser(int id);

}
