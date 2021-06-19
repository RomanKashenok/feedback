package info.freeit.service;

import info.freeit.model.User;
import info.freeit.repository.UserDaoInternal;

public final class UserService {

    private UserDaoInternal userDaoInternal;

    protected UserService(UserDaoInternal userDaoInternal) {
        this.userDaoInternal = userDaoInternal;
    }

    public boolean add(User user) {
        System.out.printf("UserService: add() with user: %s\n", user);
        return userDaoInternal.add(user);
    }

    public boolean delete(long id) {
        System.out.printf("UserService: delete() with user id: %s\n", id);
        return userDaoInternal.delete(id);
    }

    public User get(long id) {
        System.out.printf("UserService: get() with user id: %s\n", id);
        return userDaoInternal.get(id);
    }

    public User get(String username) {
        System.out.printf("UserService: get() with username: %s", username);
        return userDaoInternal.get(username);
    }

}
