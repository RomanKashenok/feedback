package info.freeit.repository;

import info.freeit.model.User;

public interface UserDao {

    User add(User user);

    boolean delete(long id);

    User get(long id);

    User get(String username);
}
