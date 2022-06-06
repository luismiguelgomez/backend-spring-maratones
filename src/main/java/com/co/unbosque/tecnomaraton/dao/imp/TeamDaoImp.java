package com.co.unbosque.tecnomaraton.dao.imp;

import com.co.unbosque.tecnomaraton.dao.TeamDao;
import com.co.unbosque.tecnomaraton.models.Team;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class TeamDaoImp implements TeamDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<Team> getAllTeams() {
        String hqlObtenerTodosTeams = "FROM Team as t";
        return (List<Team>) entityManager.createQuery(hqlObtenerTodosTeams).getResultList();
    }

    @Override
    @Transactional
    public Team registerTeam(Team team) {
        entityManager.merge(team);
        return team;
    }

    @Override
    @Transactional
    public Team getTeam(long idTeam) {
        return entityManager.find(Team.class, idTeam);
    }

    @Override
    @Transactional
    public void deleteTeam(long id) {
        Team teamEliminar = getTeam(id);
        entityManager.remove(teamEliminar);
    }
}
