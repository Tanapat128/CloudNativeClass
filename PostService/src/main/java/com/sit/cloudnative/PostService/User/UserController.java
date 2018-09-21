package com.sit.cloudnative.PostService.User;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    // create a user
    @PostMapping(value = "/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User user_object = userService.create(user);
        return new ResponseEntity<User>(user_object, HttpStatus.OK);
    }
    // find all users
    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> getUserList() {
        List<User> userList = userService.getAllUser();
        return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
    }
    // find a user by user_id
    @GetMapping(value = "/users/{user_id}")
    public ResponseEntity<User> getUser(@PathVariable("user_id") Long user_id) {
        User user = userService.getUserById(user_id).get();
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

}