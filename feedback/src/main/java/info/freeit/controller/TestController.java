package info.freeit.controller;

import info.freeit.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class TestController {

    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private JwtTokenProvider provider;

    @GetMapping("/")
    public ModelAndView first() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("msg", "From first page");
        mav.setViewName("first");
        return mav;
    }

    @PostMapping("/signin")
    @ResponseBody
    public String user(@RequestBody Map<String, String> body) {
        Authentication authenticate = manager.authenticate(new UsernamePasswordAuthenticationToken(body.get("username"), body.get("password")));
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        return provider.createToken(body.get("username"));
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
