package info.freeit.service;

import info.freeit.model.Abuser;
import info.freeit.model.User;
import info.freeit.repository.AbuserDaoHiberImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class AbuserService {

    private final AbuserDaoHiberImpl userDao;

    @Autowired
    public AbuserService(AbuserDaoHiberImpl userDao) {
        this.userDao = userDao;
    }

    public Abuser add(Abuser user) {
        System.out.printf("UserService: add() with user: %s\n", user);
        try {
            userDao.add(user);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return user;
    }
}
