package ru.ceounit.teatime.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ru.ceounit.teatime.model.User;
import ru.ceounit.teatime.repo.UserRepo;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private MailSender mailSender;

    public boolean addUser(User user) {
        User userFromDb = userRepo.findUserById(user.getId());

        if (userFromDb != null) {
            return false;
        }

        userRepo.save(user);

        return true;
    }
    private void sendMessage(User user) {
        if (!StringUtils.isEmpty(user.getEmail())) {
            String message = String.format(
                    "Время пить чай!",
                    user.getEmail()
            );

            mailSender.send(user.getEmail(), "Tea Time, Sir!", message);
        }
    }
}
