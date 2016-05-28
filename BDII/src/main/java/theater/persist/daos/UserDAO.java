package theater.persist.daos;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import theater.persist.model.UserEntity;

import java.util.List;

@Repository
public class UserDAO extends BaseDAO<UserEntity, Integer> implements IUserDAO{
    @Override
    public UserEntity getUserById(int id) {
        UserEntity user = super.readById(id);
        if (user != null) {
            return user;
        }
        return null;
    }

    @Override
    public UserEntity getUserByEmail(String email) {
        Query q = super.getNamedQuery("getUserByEmail").setParameter("email", email);
        UserEntity userEntity = (UserEntity) q.uniqueResult();
        if (userEntity != null) {
            return userEntity;
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
