package org.example.vylko.pp_3_1_1_springboot.controller;

import org.example.vylko.pp_3_1_1_springboot.entity.User;
import org.example.vylko.pp_3_1_1_springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String index(Model model) {
        List<User> userList = userService.findAll();
        model.addAttribute("userList", userList);
        return "index";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "newUser";
    }

    @PostMapping("/create")
    public String createNewUser(@RequestParam("name") String name,
                                @RequestParam("email") String email) {
        User user = new User(name, email);
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/pageForEdit")
    public String getPageForEditUser(Model model, @RequestParam("id") Long id) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "editUser";
    }

    @PatchMapping("/edit")
    public String editUser(@RequestParam("name") String name,
                           @RequestParam("email") String email,
                           @RequestParam("id") Long id) {
        User user = new User(name, email);
        user.setId(id);
        userService.update(user);
        return "redirect:/users";
    }

    @DeleteMapping("/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.delete(id);
        return "redirect:/users";
    }
}
