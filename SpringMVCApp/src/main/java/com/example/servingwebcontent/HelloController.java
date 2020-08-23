package com.example.servingwebcontent;

import com.example.servingwebcontent.domain.User;
import com.example.servingwebcontent.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/main")
    public String main(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "main";
    }

    @GetMapping("/login")
    public String login(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "login";
    }

    @PostMapping(path="/add")
    public @ResponseBody
    String addNewUser(@RequestParam String name
            , @RequestParam String email, Model model) {

        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);

        return "add";
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping("/all")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "all";
    }

    @RequestMapping(value="/registration", method=RequestMethod.GET)
    public String greetingForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute User user, Model model) {
        userRepository.save(user);
        model.addAttribute("user", user);
        return "result";
    }

}