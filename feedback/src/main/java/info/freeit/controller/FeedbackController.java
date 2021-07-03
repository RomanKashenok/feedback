package info.freeit.controller;

import info.freeit.model.User;
import info.freeit.service.UserManager;
import info.freeit.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;

@Controller
public class FeedbackController {

    private final UserService userService;
    private final UserManager userManager;

    public FeedbackController(UserService userService, UserManager userManager) {
        this.userService = userService;
        this.userManager = userManager;
    }

    @RequestMapping(value = "/usr", method = RequestMethod.POST)
    public String addSomeUsers(Model model,
                               @RequestParam (required = false) Long id,
                               @RequestParam (required = false) String name) {
        System.out.println("addSomeUsers()");
        User user = new User(id != null ? id : 1L, name != null ? name : "Roma", "username", "password");
        System.out.println(user);
        userService.add(user);
        List<User> usersList = Collections.singletonList(user);
        model.addAttribute("users", usersList);
        System.out.println(usersList);
        return "users";
    }

    @RequestMapping(value = "/usr", method = RequestMethod.GET)
    public String getSomeUsers(Model model) {
        System.out.println("addSomeUsers()");
        List<User> users = userManager.fetchBatch(1L, 2L, 3L);
        System.out.println(users);
        model.addAttribute("users", users);
        return "users";
    }


    @RequestMapping(value = "/{id}/usr", method = RequestMethod.GET)
    public String getxactUsers(Model model, @PathVariable Long id) {
        System.out.println("addSomeUsers()");
        List<User> users = userManager.fetchBatch(id);
        System.out.println(users);
        model.addAttribute("users", users);
        return "users";
    }

    @RequestMapping(value = "/msg", method = RequestMethod.GET)
    public String getWelcomeMessage(Model model) {
        System.out.println("getWelcomeMessage()");
        model.addAttribute("message", "From my first WEB MVC Controller!");
        return "index";
    }

    @RequestMapping(value = "/msg2", method = RequestMethod.GET)
    public ModelAndView getWelcomeMessage2(ModelAndView model) {
        System.out.println("getWelcomeMessage2()");
        model.setViewName("index");
        model.addObject("message", "From my second WEB MVC Controller with ModelAndView!");
        return model;
    }

}
