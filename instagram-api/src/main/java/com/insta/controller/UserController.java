package com.insta.controller;

import com.insta.exception.UserException;
import com.insta.model.User;
import com.insta.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<User> saveUser(@RequestBody User user) throws UserException {
        user = userService.registerUser(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Integer id) throws UserException {
        User user = userService.findUserById(id);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @GetMapping("/m/{userIds}")
    public ResponseEntity<List<User>> findUsersByUserIds(@PathVariable List<Integer> userIds) throws UserException {
       List<User> users = userService.findUserByIds(userIds);
       return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<User>> searchUser(@PathVariable("q") String query) throws UserException {
        List<User> users = userService.searchUser(query);
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }
}
