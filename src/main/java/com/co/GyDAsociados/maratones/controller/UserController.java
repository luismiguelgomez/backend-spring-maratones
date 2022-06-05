package com.co.GyDAsociados.maratones.controller;

import com.co.GyDAsociados.maratones.models.User;
import com.co.GyDAsociados.maratones.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    User get(@PathVariable long id) {
        return userService.get(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void delete(@PathVariable long id) {
        // TODO: eliminar en la base de datos al usuario
        userService.delete(id);
    }




}
