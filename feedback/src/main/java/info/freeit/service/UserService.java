package info.freeit.service;

import info.freeit.model.User;
import info.freeit.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public final class UserService {

    private final UserDao userDao;

    @Autowired
    public UserService(@Qualifier("userDaoHiber") UserDao userDao) {
        this.userDao = userDao;
    }

    public User add(User user) {
        System.out.printf("UserService: add() with user: %s\n", user);
        try {
            userDao.add(user);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return user;
    }

    public boolean delete(long id) {
        System.out.printf("UserService: delete() with user id: %s\n", id);
        return userDao.delete(id);
    }

    public User get(long id) {
        System.out.printf("UserService: get() with user id: %s\n", id);
        return userDao.get(id);
    }

    public User get(String username) {
        System.out.printf("UserService: get() with username: %s", username);
        return userDao.get(username);
    }

}
