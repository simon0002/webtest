package com.example.webtest.controller;

import com.example.webtest.entity.User;
import com.example.webtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUser/{id}")
    public String GetUser(@PathVariable int id, Model model) {
        User user = userService.getUser(id);

        model.addAttribute("user", user);
        //System.out.println(str);
        return "first";
    }

    @RequestMapping("/addUser")
    public String AddUser() {
        return "adduser";
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String SaveUser(HttpServletResponse responnse,
                           @RequestParam(value = "username", required = true) String userName,
                           @RequestParam(value = "password", required = true) String passWord,
                           @RequestParam(value = "realname") String realName) {
        userService.addUser(userName, passWord, realName);
        return "ok";
    }



    @RequestMapping("/login")
    public String login(HttpServletRequest request) {
        HttpSession session = request.getSession();
        System.out.print(session.getAttribute("user"));
        //Object user = session.getAttribute("user");

        return "login";
    }

    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    public String doLogin(HttpServletResponse response, HttpServletRequest request,
                          @RequestParam(value = "username", required = true) String userName,
                          @RequestParam(value = "password", required = true) String passWord) throws Exception {

        User user = userService.getUserByName(userName);
        if(user != null){
            System.out.print(user);
            String upw = user.getPassWord();
            if(!upw.equals(passWord)){
                System.out.print(upw);
                System.out.print(passWord);
                return "error";
            }
            //session
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            //String sessionId = session.getId();

            //System.out.print(sessionId);
        }else {
            return "error";
        }

        return "ok";
    }
}