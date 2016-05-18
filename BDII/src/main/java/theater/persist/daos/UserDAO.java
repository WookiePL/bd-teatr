package theater.persist.daos;

import theater.persist.model.UserEntity;

import java.util.List;

/**
 * Created by Wookie on 2016-05-18.
 */
public class UserDAO extends BaseDAO<UserEntity, Integer> implements IUserDAO{
    @Override
    public UserEntity getUserByid(int id) {
        UserEntity user = super.readById(id);
        if (user != null) {
            return user;
        }
        return null;
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return super.getAll();
    }

    @Override
    public void addUser(UserEntity user) {
        super.create(user);
    }

    @Override
    public void updateUser(UserEntity user) {
        super.update(user);
    }

    @Override
    public void deleteUser(int id) {
        UserEntity user = super.readById(id);
        if (user != null) {
            super.delete(user);
        }
    }
}
