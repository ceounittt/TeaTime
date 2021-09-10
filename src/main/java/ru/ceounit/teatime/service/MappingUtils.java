package ru.ceounit.teatime.service;

import lombok.Data;
import org.springframework.stereotype.Service;
import ru.ceounit.teatime.model.User;
import ru.ceounit.teatime.model.dto.UserDto;

@Service
@Data
public class MappingUtils {
    public UserDto mapToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());

        return userDto;
    }

    public User mapToUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());

        return user;
    }
}
