package info.freeit.repository;

import info.freeit.model.User;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class UserDaoInternal {

    private String daoQualifier;

    private Set<User> users = new HashSet<>();

    public UserDaoInternal(String daoQualifier) {
        this.daoQualifier = daoQualifier;
    }

    public boolean add(User user) {
        System.out.printf("add(): %s\n", daoQualifier );
        boolean add = users.add(user);
        return add;
    }

    public boolean delete (long id) {
        System.out.printf("delete(): %s\n", daoQualifier );
        if(!users.isEmpty()) {
            Optional<User> exist = users.stream().filter(it -> it.getId().equals(id)).findFirst();
            return exist.isPresent() && users.remove(exist.get());
        }
        return false;
    }

    public User get(long id) {
        System.out.printf("get(): %s\n", daoQualifier );
        return users.stream().filter(it -> it.getId().equals(id)).findFirst().orElse(null);
    }

    public User get(String username) {
        System.out.printf("get(): %s\n", daoQualifier );
        return users.stream().filter(it -> it.getUsername().equals(username)).findFirst().orElse(null);
    }
}
