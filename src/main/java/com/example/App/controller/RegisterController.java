package com.example.App.controller;

import com.example.App.entity.User;
import com.example.App.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, Model model) {
        userService.register(user);
        return "redirect:/success";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String email,
                            @RequestParam String password,
                            HttpSession session,
                            Model model) {

        return userService.login(email, password)
                .map(user -> {
                    session.setAttribute("loggedInUser", user); // store in session
                    return "redirect:/welcome";
                })
                .orElseGet(() -> {
                    model.addAttribute("error", "Invalid email or password");
                    model.addAttribute("user", new User());
                    return "register";
                });
    }

    @GetMapping("/welcome")
    public String welcomePage(HttpSession session, Model model) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null) {
            return "redirect:/register"; // Not logged in
        }
        model.addAttribute("name", user.getName());
        return "welcome";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/register";
    }

    @GetMapping("/success")
    public String successPage() {
        return "success";
    }
}
