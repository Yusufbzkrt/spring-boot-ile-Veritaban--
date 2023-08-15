
package com.example.stajLig.Service;

import com.example.stajLig.Entity.Stadium;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StadiumService {
    Stadium createStadium(Stadium stadium);
    List<Stadium> getList();
    Stadium updateStadium(Long id,Stadium stadium);
    Boolean deleteStadium(Long id);
}

