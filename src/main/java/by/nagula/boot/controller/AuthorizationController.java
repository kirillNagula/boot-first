package by.nagula.boot.controller;

import by.nagula.boot.entity.User;
import by.nagula.boot.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/auth")
public class AuthorizationController {
    private final UserService userService;

    public AuthorizationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> authorization(@RequestBody User user, @RequestHeader("apiKey") String apiKey){
        //todo
        return new ResponseEntity<User>(HttpStatus.CREATED);
    }
}
