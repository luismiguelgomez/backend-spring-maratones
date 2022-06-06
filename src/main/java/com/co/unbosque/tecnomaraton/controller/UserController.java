package com.co.unbosque.tecnomaraton.controller;

import com.co.unbosque.tecnomaraton.models.User;
import com.co.unbosque.tecnomaraton.service.CsvExportService;
import com.co.unbosque.tecnomaraton.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("usuario")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    CsvExportService csvExportService;

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

    @RequestMapping(value = "/generador-csv", method = RequestMethod.GET)
    public void getAllUsuariosInCsv(HttpServletResponse servletResponse) throws IOException {
        servletResponse.setContentType("text/csv");
        servletResponse.addHeader("Content-Disposition","attachment; filename=\"usuarios.csv\"");
        csvExportService.writeEmployeesToCsv(servletResponse.getWriter());
    }

}
