package by.nagula.boot.controller;

import by.nagula.boot.entity.ApplicationKey;
import by.nagula.boot.entity.User;
import by.nagula.boot.repository.ApplicationKeyRepository;
import by.nagula.boot.service.ApplicationKeyService;
import by.nagula.boot.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/auth")
public class AuthorizationController {
    private final UserService userService;
    private final ApplicationKeyService applicationKeyService;

    public AuthorizationController(UserService userService, ApplicationKeyService applicationKeyService) {
        this.userService = userService;
        this.applicationKeyService = applicationKeyService;
    }

    @PostMapping
    public ResponseEntity<ApplicationKey> authorization(@RequestBody User user){
        Optional<User> user1 = userService.showByLogin(user.getLogin());
        if (user1.isEmpty()){
            return new ResponseEntity<ApplicationKey>(HttpStatus.EXPECTATION_FAILED);
        } else {
            applicationKeyService.addApiKey(user.getLogin());
            Optional<ApplicationKey> applicationKey = applicationKeyService.showApiKEy(user.getLogin());
            return ResponseEntity.of(applicationKey);
        }

    }
}
