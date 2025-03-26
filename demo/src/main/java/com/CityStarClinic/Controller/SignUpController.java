package com.CityStarClinic.Controller;

import com.CityStarClinic.Entity.User;
import com.CityStarClinic.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignUpController {

    @Autowired
    private UserService userService;

    @GetMapping("/signup")
    public String showSignUpForm(Model model) {
        return "signup";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username,
                               @RequestParam String password,
                               @RequestParam String email,
                               Model model) {
        try {
            User user = new User();
            user.setName(username);
            user.setPassword(password);
            user.setEmail(email);

            userService.registerUser(user);
            model.addAttribute("success", "Registration successful!");
            return "redirect:/login"; // Redirect to login page after successful registration
        } catch (Exception e) {
            model.addAttribute("error", "Registration failed: " + e.getMessage());
            return "signup"; // Stay on sign-up page if there's an error
        }
    }
}
