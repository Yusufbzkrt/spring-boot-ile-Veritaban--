
package com.example.stajLig.Api;

import com.example.stajLig.Entity.Stadium;
import com.example.stajLig.Entity.Team;
import com.example.stajLig.Service.TeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Team")
public class TeamController {

    public final TeamService teamService;
    public TeamController(TeamService teamService) {

        this.teamService = teamService;
    }
    @PostMapping("/save")
    public ResponseEntity<Team> createTeam(@RequestBody Team team){
        Team resultTeam=teamService.createTeam(team);
        return ResponseEntity.ok(resultTeam);
    }
    @GetMapping("/getALL")
    public ResponseEntity<List<Team>> getTeam(){
        List<Team> ListTeam=teamService.getTeam();
        return ResponseEntity.ok(ListTeam);
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<Team> updateTeam(@PathVariable("id") Long id , @RequestBody Team team){
        Team editTeam=teamService.updateTeam(id,team);
        return ResponseEntity.ok(editTeam);
    }
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Boolean> deleteTeam(@PathVariable("id") Long id){
        Boolean removeTeam=teamService.deleteTeam(id);
        return ResponseEntity.ok(removeTeam);
    }
}

