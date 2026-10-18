package com.sumanezhumalai.springbootthymleafmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sumanezhumalai.springbootthymleafmvc.model.User;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

@Controller
public class HelloController {

    @RequestMapping("/")
    public String home() {
        // return "index.jsp";
        return "index";
    }

    // @RequestMapping("add")
    // public String add(HttpServletRequest req, HttpSession session) {
    // int num1 = Integer.parseInt(req.getParameter("number1"));
    // int num2 = Integer.parseInt(req.getParameter("number2"));
    // int result = num1 + num2;

    // session.setAttribute("result", result);

    // System.out.println(result);
    // return "result"
    // }

    // @RequestMapping("add")
    // public String add(@RequestParam("number1") int num1, @RequestParam("number2")
    // int num2, Model model) {
    // int result = num1 + num2;

    // model.addAttribute("result", result);

    // return "result";
    // }

    @RequestMapping("add")
    public ModelAndView add(@RequestParam("number1") int num1,
            @RequestParam("number2") int num2, ModelAndView mv) {
        int result = num1 + num2;

        mv.addObject("result", result);
        mv.setViewName("result");
        return mv;
    }

    // @RequestMapping("addUser")
    // public ModelAndView addUser(@RequestParam("uid") int id,
    // @RequestParam("uname") String name, ModelAndView mv) {

    // User user = new User();
    // user.setId(id);
    // user.setName(name);

    // mv.addObject("user", user);
    // mv.setViewName("result");
    // return mv;
    // }

    @RequestMapping("addUser")
    public String addUser(@ModelAttribute User user) {

        // mv.addObject("user", user);
        // mv.setViewName("result");
        return "result";
    }

    @ModelAttribute("course")
    public String course() {
        return "Thymeleaf";
    }
}
