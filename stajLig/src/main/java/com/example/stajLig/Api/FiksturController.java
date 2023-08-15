
package com.example.stajLig.Api;

import com.example.stajLig.Entity.Fikstur;
import com.example.stajLig.Repository.FiksturRepository;
import com.example.stajLig.Service.FiksturService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Fikstur")
public class FiksturController {
    public final FiksturService fiksturService;
    public FiksturController(FiksturService fiksturService) {
        this.fiksturService = fiksturService;
    }
    @PostMapping("/save")
    public ResponseEntity<Fikstur> createFikstur(@RequestBody Fikstur fikstur){
        Fikstur resultFikstur=fiksturService.createFikstur(fikstur);
        return ResponseEntity.ok(resultFikstur);
    }
    @GetMapping("/getALL")
    public ResponseEntity<List<Fikstur>> getFiksturs(){
        List<Fikstur> fiksturs =fiksturService.getFiksturs();
        return ResponseEntity.ok(fiksturs);
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<Fikstur> updateFikstur(@PathVariable("id") Long id,@RequestBody Fikstur fikstur){
        Fikstur resultFikstur = fiksturService.updateFikstur(id,fikstur);
        return ResponseEntity.ok(resultFikstur);
    }
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Boolean> deleteFikstur(@PathVariable("id") Long id){
        Boolean status =fiksturService.deleteFikstur(id);
        return ResponseEntity.ok(status);
    }
}

