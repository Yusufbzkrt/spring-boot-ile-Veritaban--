
package com.example.stajLig.Service.impl;

import com.example.stajLig.Entity.Stadium;
import com.example.stajLig.Entity.Team;
import com.example.stajLig.Repository.TeamRepository;
import com.example.stajLig.Service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeamServiceimpl implements TeamService {
    public final TeamRepository teamRepository;

    @Override
    public Team createTeam(Team team) {
        team.setCreateAt(new Date());
        team.setCreateBy("admin");
        return teamRepository.save(team);
    }

    @Override
    public List<Team> getTeam() {
        return teamRepository.findAll();

    }

    @Override
    public Team updateTeam(Long id, Team team) {
        Optional<Team> updateteam=teamRepository.findById(id);
        if (updateteam.isPresent()) {
            updateteam.get().setUpdatedAt(new Date());
            updateteam.get().setUpdateBy("Admin");
            updateteam.get().setTeam(team.getTeam());
            updateteam.get().setStadium_id(team.getStadium_id());
            updateteam.get().setLig(team.getLig());
            updateteam.get().setCode(team.getCode());
            return teamRepository.save(updateteam.get());
        }
        return null;
    }

    @Override
    public Boolean deleteTeam(Long id) {
        Optional<Team> removeTeam=teamRepository.findById(id);
        if (removeTeam.isPresent()){
            teamRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
