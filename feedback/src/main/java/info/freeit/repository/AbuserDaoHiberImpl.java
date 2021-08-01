package info.freeit.repository;

import info.freeit.model.Abuser;
import info.freeit.model.Role;
import info.freeit.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("abuserDaoHiber")
public class AbuserDaoHiberImpl {

    private final SessionFactory sessionFactory;

    @Autowired
    public AbuserDaoHiberImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Abuser add(Abuser user) {
        Session session = getSession();
        session.save(user);
        return user;
    }

    private Session getSession() {
        return sessionFactory.openSession();
    }
}
