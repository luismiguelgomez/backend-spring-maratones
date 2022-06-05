package com.co.GyDAsociados.maratones.dao;

import com.co.GyDAsociados.maratones.models.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserDao {
    /**
     * Traer todos los usuarios
     * @return una lista de usuarios
     */
    List<User> getAllUsers();

    /**
     * @param user viene del modelo de usuario
     * @return Un modelo user creado
     */
    User register(@RequestBody User user);

    /**
     *
     * @param id id de un usuario
     * @return un usuario
     */
    User get(@PathVariable long id);

    /**
     *
     * @param id id utilizado para eliminar un usuario
     */
    void delete(@PathVariable long id) ;
}
