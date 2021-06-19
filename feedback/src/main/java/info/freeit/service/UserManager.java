package info.freeit.service;

import info.freeit.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserManager {

    private UserService us;

    public List<User> fetchBatch(long ... ids) {
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < ids.length; i++) {
            System.out.printf("UserManager: fetchBatch() with ID: %d\n", ids[i]);
            userList.add(us.get(ids[i]));
        }
        return userList;
    }

    public void setUs(UserService us) {
        this.us = us;
    }
}
