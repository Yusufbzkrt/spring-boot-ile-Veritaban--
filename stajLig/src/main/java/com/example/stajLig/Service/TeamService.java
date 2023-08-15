
package com.example.stajLig.Service;

import com.example.stajLig.Entity.Team;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TeamService {
    Team createTeam(Team team);
    List<Team> getTeam();
    Team updateTeam(Long id , Team team);
    Boolean deleteTeam(Long id);
}

