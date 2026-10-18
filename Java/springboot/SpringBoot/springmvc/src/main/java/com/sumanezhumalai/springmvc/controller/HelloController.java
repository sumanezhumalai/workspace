package com.sumanezhumalai.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sumanezhumalai.springmvc.model.User;

@Controller
public class HelloController {

    @RequestMapping({"/", "/index"})
    public String home() {
        // return "index.jsp";
        return "index";
    }

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
        return "Java";
    }
}
