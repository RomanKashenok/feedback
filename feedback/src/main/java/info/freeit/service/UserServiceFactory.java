package info.freeit.service;

import info.freeit.repository.UserDaoInternal;

public class UserServiceFactory {

    public UserService instance(UserDaoInternal dao) {
        UserService userService = new UserService(dao);
        return userService;
    }

}
