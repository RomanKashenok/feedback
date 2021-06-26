package info.freeit;

import info.freeit.config.AppConfig;
import info.freeit.config.DatabaseConfig;
import info.freeit.model.User;
import info.freeit.service.UserManager;
import info.freeit.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context2 = new AnnotationConfigApplicationContext(AppConfig.class, DatabaseConfig.class);
        context2.getEnvironment().setActiveProfiles("dev");

        UserService us = context2.getBean(UserService.class);
        us.add(new User(1L, "Jane", "qwerty", "qwerty"));

        UserManager um = context2.getBean(UserManager.class);
        System.out.println(um.fetchBatch(1L, 2L, 3L));


    }
}
