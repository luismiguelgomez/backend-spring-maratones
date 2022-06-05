package com.co.GyDAsociados.maratones.service;

import com.co.GyDAsociados.maratones.dao.TeamDao;
import com.co.GyDAsociados.maratones.models.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
    @Autowired
    TeamDao teamDao;

    public List<Team> getAllTeams() {
        return teamDao.getAllTeams();
    }

    public Team registerTeam(Team team) {
        return teamDao.registerTeam(team);
    }

    public Team getTeam(long idTeam) {
        return teamDao.getTeam(idTeam);
    }

    public void deleteTeam(long id) {
        teamDao.deleteTeam(id);
    }

}
