package info.freeit.repository;

import info.freeit.model.Role;
import info.freeit.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("userDaoHiber")
public class UserDaoHiberImpl implements UserDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public UserDaoHiberImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public User add(User user) {
        Session session = getSession();
        Role role = session.get(Role.class, 1L);
        user.setRole(role);
        session.save(user);
        return user;
    }

    public boolean delete(long id) {
        Session session = getSession();
        session.delete(session.get(User.class, id));
        return true;
    }

    public User get(long id) {
        Session session = getSession();
        return session.get(User.class, id);
    }

    public User get(String username) {
        Query query = getSession().createSQLQuery("from users where username = :username");
        query.setString("username", username);
        User u = (User) query.uniqueResult();
        return u;
    }

    private Session getSession() {
        return sessionFactory.openSession();
    }
}
