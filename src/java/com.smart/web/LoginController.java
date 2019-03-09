package com.smart.web;

import com.smart.entity.User;
import com.smart.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    private UserService userService;

    public void setUserService(UserService userService){
        this.userService = userService;
    }
    @RequestMapping("/tologin")
    public String tologin(){
        System.out.println("ss");
        return "login";
    }

    @RequestMapping("/login")
    public ModelAndView login(HttpServletRequest request, User user){
        System.out.println(user.getUsername());
        boolean isValidUser=userService.hasMatch(user.getUsername(),user.getPassword());
        if (isValidUser){
            request.getSession().setAttribute("user",user);
            return new ModelAndView("success");
        }else{
            return new ModelAndView("login","error","用户名或账户错误");
        }
    }


}
