
package com.example.stajLig.Api;

import com.example.stajLig.Entity.Stadium;
import com.example.stajLig.Service.StadiumService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Stadium")

public class StadiumController {

    public final StadiumService stadiumService;
    public StadiumController(StadiumService stadiumService) {

        this.stadiumService = stadiumService;
    }
@PostMapping("/save")
    public ResponseEntity<Stadium> createStadium(@RequestBody Stadium stadium){
        Stadium resultStadium = stadiumService.createStadium(stadium);
        return ResponseEntity.ok(resultStadium);
}
@GetMapping("/getALL")
    public ResponseEntity<List<Stadium>> getList(){
        List<Stadium> result=stadiumService.getList();
        return ResponseEntity.ok(result);
}
@PutMapping("/edit/{id}")
    public ResponseEntity<Stadium> updateStadium(@PathVariable("id") Long id,@RequestBody Stadium stadium) {
    Stadium resultStadium = stadiumService.updateStadium(id, stadium);
    return ResponseEntity.ok(resultStadium);
}
 @DeleteMapping("remove/{id}")
    public ResponseEntity<Boolean> deleteStadium(@PathVariable("id") Long id){
     Boolean removeStadium =stadiumService.deleteStadium(id);
     return ResponseEntity.ok(removeStadium);
    }

}

