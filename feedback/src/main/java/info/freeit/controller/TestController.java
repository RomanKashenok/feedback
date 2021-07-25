package info.freeit.controller;

import info.freeit.model.User;
import info.freeit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ModelAndView first() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("first");
        User user = new User("Test", "test", "test");
        User addedUser = userService.add(user);
        mav.addObject("msg", addedUser.toString());
        System.out.println(user);
        return mav;
    }

    @GetMapping("/user")
    public ModelAndView user() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("msg", "From USERS page");
        mav.setViewName("user");
        return mav;
    }

    @GetMapping("/admin")
    public ModelAndView admin() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("msg", "From ADMINS page");
        mav.setViewName("admin");
        return mav;
    }

}
