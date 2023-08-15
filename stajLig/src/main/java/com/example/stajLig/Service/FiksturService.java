
package com.example.stajLig.Service;

import com.example.stajLig.Api.FiksturController;
import com.example.stajLig.Entity.Fikstur;

import java.util.List;

public interface FiksturService {
    Fikstur createFikstur(Fikstur fikstur);
    List<Fikstur> getFiksturs();
    Fikstur updateFikstur(Long id, Fikstur fikstur);
    Boolean deleteFikstur(Long id);
}

