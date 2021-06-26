package info.freeit.repository;

import info.freeit.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.time.Clock;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Repository("userDaoInternal")
public class UserDaoInternal implements UserDao {

    private Set<User> users = new HashSet<>();
    @Value("${db.jdbc.password}")
    private String password;
    @Value("${dao.internal.qualifier}")
    private String daoQualifier;

    private final Clock clock;

    @Autowired
    public UserDaoInternal(Clock clock) {
        this.clock = clock;
    }

    public boolean add(User user) {
        System.out.println("password: " + password);
        System.out.printf("add(): %s at %s\n", daoQualifier, clock.instant().getEpochSecond());
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
