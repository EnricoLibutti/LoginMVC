package me.enricolibutti.controller;

import me.enricolibutti.model.User;
import me.enricolibutti.service.UserService;
import me.enricolibutti.session.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    
    private final UserService userService;
    private final UserSession userSession;
    
    @Autowired
    public LoginController(UserService userService, UserSession userSession) {
        this.userService = userService;
        this.userSession = userSession;
    }
    
    @GetMapping("/")
    public String showLoginForm() {
        if (userSession.isAuthenticated()) {
            return "redirect:/home";
        }
        return "login";
    }
    
    @PostMapping("/login")
    public String login(@RequestParam String username, 
                        @RequestParam String password, 
                        Model model) {
        
        if (userService.authenticate(username, password)) {
            User user = userService.getUserByUsername(username);
            userSession.login(user);
            return "redirect:/home";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }
    
    @GetMapping("/home")
    public String home(Model model) {
        if (!userSession.isAuthenticated()) {
            return "redirect:/";
        }
        model.addAttribute("user", userSession.getUser());
        return "home";
    }
    
    @GetMapping("/details")
    public String details(Model model) {
        if (!userSession.isAuthenticated()) {
            return "redirect:/";
        }
        model.addAttribute("user", userSession.getUser());
        return "details";
    }
    
    @GetMapping("/logout")
    public String logout() {
        userSession.logout();
        return "redirect:/";
    }
}