package com.co.GyDAsociados.maratones.controller;

import com.co.GyDAsociados.maratones.models.User;
import com.co.GyDAsociados.maratones.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("usuario")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity
                .status(HttpStatus.OK)
                        .body(userService.getAllUsers());
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public User registerUser(@RequestBody User user) {
      return userService.register(user);
    }




}
