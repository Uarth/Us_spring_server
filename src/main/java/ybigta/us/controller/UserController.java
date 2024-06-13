package ybigta.us.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ybigta.us.domain.User;
import ybigta.us.service.UserService;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ResponseBody
    @PostMapping("/users/new")
    public User create(@RequestParam("name") String name, @RequestParam("email") String email) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        return userService.join(user);
    }

    @ResponseBody
    @GetMapping("/users")
    public String list() {
        List<User> users = userService.findUsers();
        System.out.println(users);
        return users.toString();
    }

    @ResponseBody
    @GetMapping("/users/{id}")
    public String findUser(@PathVariable("id") Integer id) {
        User user = userService.findUser(id);
        return user.toString();
    }

    @ResponseBody
    @GetMapping("/users/name/{name}")
    public String findUserByName(@PathVariable("name") String name) {
        User user = userService.findUserByName(name);
        return user.toString();
    }

    @ResponseBody
    @GetMapping("/users/email/{email}")
    public String findUserByEmail(@PathVariable("email") String email) {
        User user = userService.findUserByEmail(email);
        return user.toString();
    }
}
