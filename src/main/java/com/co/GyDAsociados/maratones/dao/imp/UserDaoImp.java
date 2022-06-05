package com.co.GyDAsociados.maratones.dao.imp;

import com.co.GyDAsociados.maratones.dao.UserDao;
import com.co.GyDAsociados.maratones.models.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<User> getAllUsers() {
        String hqlObtenerTodosUsuarios = "FROM User as u";
        return (List<User>) entityManager.createQuery(hqlObtenerTodosUsuarios).getResultList();
    }

    @Override
    @Transactional
    public User register(@RequestBody User user) {
        entityManager.merge(user);
        return user;
    }

    @Override
    @Transactional
    public User get(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public void delete(long id) {
        User usuarioEliminar = get(id);
        entityManager.remove(usuarioEliminar);
    }


}
