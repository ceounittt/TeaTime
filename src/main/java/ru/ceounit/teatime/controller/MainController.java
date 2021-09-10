package ru.ceounit.teatime.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.ceounit.teatime.model.User;
import ru.ceounit.teatime.model.dto.UserDto;
import ru.ceounit.teatime.service.MappingUtils;
import ru.ceounit.teatime.service.UserService;

@RestController("tea")
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private MappingUtils utils;

    @PostMapping("add")
    public User createUser(@RequestBody UserDto userDto) {
        return userService.addUser(utils.mapToUser(userDto));
    }
}
