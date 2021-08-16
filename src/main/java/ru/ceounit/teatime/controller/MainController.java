package ru.ceounit.teatime.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ceounit.teatime.model.User;

@RestController
public class MainController {
    User userList;
    @GetMapping
    public String index(){
        return null;
    }
}
