package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.domain.User;
import com.example.servingwebcontent.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/main")
    public String main(@RequestParam(name = "username", required = false, defaultValue = "World") String username, Model model) {
        model.addAttribute("username", username);
        return "main";
    }
/*
    @GetMapping("/login")
    public String login(@RequestParam(name = "username", required = false, defaultValue = "World") String username, Model model) {
        model.addAttribute("username", username);
        return "login";
    }

    @PostMapping(path="/add")
    public @ResponseBody
    String addNewUser(@RequestParam String name
            , @RequestParam String password, Model model) {

        User n = new User();
        n.setName(name);
        n.setPassword(password);
        userRepository.save(n);

        return "add";
    }
*/

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "username", required = false, defaultValue = "World") String username, Model model) {
        model.addAttribute("username", username);
        return "greeting";
    }

    @GetMapping("/all")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "all";
    }

    @RequestMapping(value="/reg", method=RequestMethod.GET)
    public String greetingForm(Model model) {
        model.addAttribute("user", new User());
        return "reg";
    }


    @RequestMapping(value="/reg", method=RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute User user, Model model) {
        userRepository.save(user);
        model.addAttribute("user", user);
        return "result";
    }

}