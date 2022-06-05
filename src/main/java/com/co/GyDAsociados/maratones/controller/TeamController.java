package com.co.GyDAsociados.maratones.controller;

import com.co.GyDAsociados.maratones.models.Team;
import com.co.GyDAsociados.maratones.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("team")
public class TeamController {
    @Autowired
    TeamService teamService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Team>> getAllUsers() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(teamService.getAllTeams());
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Team registerUser(@RequestBody Team team) {
        return teamService.registerTeam(team);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Team get(@PathVariable long id) {
        return teamService.getTeam(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void delete(@PathVariable long id) {
        teamService.deleteTeam(id);
    }

}
