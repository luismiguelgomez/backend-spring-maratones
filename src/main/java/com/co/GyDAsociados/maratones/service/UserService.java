package com.co.GyDAsociados.maratones.service;

import com.co.GyDAsociados.maratones.dao.UserDao;
import com.co.GyDAsociados.maratones.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public List<User> getAllUsers(){
        return userDao.getAllUsers();
    }

    public User register(@RequestBody User user){
        return userDao.register(user);
    }

    public User get(@PathVariable long id) {
        return userDao.get(id);
    }

    public void delete(@PathVariable long id) {
        userDao.delete(id);
    }

}
