package info.freeit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

    @GetMapping("/")
    public ModelAndView first() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("msg", "From first page");
        mav.setViewName("first");
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
