
package com.example.stajLig.Service.impl;

import com.example.stajLig.Entity.Stadium;
import com.example.stajLig.Repository.StadiumRepository;
import com.example.stajLig.Service.StadiumService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.mbeans.SparseUserDatabaseMBean;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StadiumServiceimpl implements StadiumService {
    public final StadiumRepository stadiumRepository;

    @Override
    public Stadium createStadium(Stadium stadium) {
        stadium.setCreateAt(new Date());
        stadium.setCreateBy("admin");
        return stadiumRepository.save(stadium);
    }

    @Override
    public List<Stadium> getList() {

        return stadiumRepository.findAll();
    }

    @Override
    public Stadium updateStadium(Long id, Stadium stadium) {
        Optional<Stadium> resultStadium = stadiumRepository.findById(id);
        if (resultStadium.isPresent()) {
            resultStadium.get().setUpdatedAt(new Date());
            resultStadium.get().setUpdateBy("admin");
            resultStadium.get().setStadium(stadium.getStadium());
            resultStadium.get().setHeight(stadium.getHeight());
            return stadiumRepository.save(resultStadium.get());
        }
        return null;
    }

    @Override
    public Boolean deleteStadium(Long id) {
        Optional<Stadium> stadium =stadiumRepository.findById(id);
        if (stadium.isPresent()){
            stadiumRepository.deleteById(id);
            return true;
        }
        return false;
    }


}

