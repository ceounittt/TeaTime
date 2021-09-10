package ru.ceounit.teatime.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.ceounit.teatime.model.User;
import ru.ceounit.teatime.repo.UserRepo;

import java.util.List;

import static org.apache.commons.lang3.StringUtils.isNotEmpty;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private MailSender mailSender;

    private void sendMessage(User user) {
        if (isNotEmpty(user.getEmail())) {
            String message = "Время пить чай!";
            mailSender.send(user.getEmail(), "Tea Time, Sir!", message);
        }
    }

    @Scheduled(cron = "0 17 * * * MON-FRI")
    public void teaMessage() {
        List<User> users = userRepo.findAll();
        users.forEach(user -> sendMessage(user));
    }

    public User addUser(User user) {
        userRepo.save(user);
        return user;
    }
}
