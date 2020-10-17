package by.nagula.boot.service;

import by.nagula.boot.entity.User;
import by.nagula.boot.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user){
        if (userRepository.findByLogin(user.getLogin()).isEmpty()){
            userRepository.save(user);
        }
    }

    public Optional<User> showUser(String login){
        if (userRepository.findByLogin(login).equals(login)){
            return userRepository.findByLogin(login);
        }
        return null;
    }
}
