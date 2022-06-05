package com.co.GyDAsociados.maratones.dao;

import com.co.GyDAsociados.maratones.models.Team;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface TeamDao {

    List<Team> getAllTeams();

    Team registerTeam(@RequestBody Team team);

    Team getTeam(@PathVariable long idTeam);

    void deleteTeam(@PathVariable long id);
}
