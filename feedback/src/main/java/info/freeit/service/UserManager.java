package info.freeit.service;

import info.freeit.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserManager {

    private final UserService us;

    @Autowired
    public UserManager(UserService us) {
        this.us = us;
    }

    public List<User> fetchBatch(long ... ids) {
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < ids.length; i++) {
            System.out.printf("UserManager: fetchBatch() with ID: %d\n", ids[i]);
            userList.add(us.get(ids[i]));
        }
        return userList;
    }
}
