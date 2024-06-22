package com.example.demoshoppingsite.Controller;


import com.example.demoshoppingsite.model.User;
import com.example.demoshoppingsite.service.UserService;
import com.example.demoshoppingsite.exceptions.AuthenticationException;
import com.example.demoshoppingsite.exceptions.DuplicateException;
import com.example.demoshoppingsite.exceptions.PendingOrderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createUserAccount(@RequestBody User user) throws DuplicateException {

        userService.createUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping({"/login", "/getUser"})
    public ResponseEntity<User> authenticate(@RequestParam String username, @RequestParam String password) throws AuthenticationException {

        User user = userService.authenticate(username, password);
        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }

    @PutMapping("/password")
    public ResponseEntity<String> changePassword(@RequestParam String username, @RequestParam String oldPassword, @RequestParam String newPassword) throws AuthenticationException {

        userService.changePassword(username, oldPassword, newPassword);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUserAccount(@RequestParam String username, @RequestParam String password) throws PendingOrderException, AuthenticationException {

        userService.deleteAccount(username, password);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
