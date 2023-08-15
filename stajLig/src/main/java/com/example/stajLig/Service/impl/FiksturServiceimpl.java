
package com.example.stajLig.Service.impl;

import com.example.stajLig.Entity.Fikstur;
import com.example.stajLig.Repository.FiksturRepository;
import com.example.stajLig.Service.FiksturService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FiksturServiceimpl implements FiksturService {
    public final FiksturRepository fiksturRepository;

    @Override
    public Fikstur createFikstur(Fikstur fikstur) {
        fikstur.setCreateAt(new Date());
        fikstur.setCreateBy("Admin");
        return fiksturRepository.save(fikstur);
    }

    @Override
    public List<Fikstur> getFiksturs() {
        return fiksturRepository.findAll();
    }

    @Override
    public Fikstur updateFikstur(Long id, Fikstur fikstur) {
        Optional<Fikstur> resultFikstur = fiksturRepository.findById(id);
        if (resultFikstur.isPresent()){
            resultFikstur.get().setUpdatedAt(new Date());
            resultFikstur.get().setUpdateBy("admin");
            resultFikstur.get().setDış(fikstur.getDış());
            resultFikstur.get().setDeplasman(fikstur.getDeplasman());
            resultFikstur.get().setHafta(fikstur.getHafta());
            resultFikstur.get().setIc_saha(fikstur.getIc_saha());
            resultFikstur.get().setIç(fikstur.getIç());
            return fiksturRepository.save(resultFikstur.get());
        }
        return null;
    }

    @Override
    public Boolean deleteFikstur(Long id) {
        Optional<Fikstur> fikstur= fiksturRepository.findById(id);
        if (fikstur.isPresent()){
            fiksturRepository.deleteById(id);
            return true;
        }
        return false;
    }

}

