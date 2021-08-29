package ru.ceounit.teatime.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.ceounit.teatime.model.User;
import ru.ceounit.teatime.repo.UserRepo;
import ru.ceounit.teatime.service.UserService;

import java.util.List;

@RestController
public class MainController {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserService userService;

    @GetMapping
    List<User> index(){
        if (this.userRepo.equals(null)) {
            return null; }
        else
        { return userRepo.findAll(); }
    }
    @PostMapping
    public User createUser(@RequestBody User user) {
        userService.addUser(user);
        return user;
    }
}
