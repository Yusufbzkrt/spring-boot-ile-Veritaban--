package com.example.stajLig.Api;

import com.example.stajLig.Entity.Country;


import com.example.stajLig.Filter;
import com.example.stajLig.Repository.CountryRepository;
import com.example.stajLig.Repository.PlayerRepository;
import com.example.stajLig.Service.CountryService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Data
@RequestMapping("/Country")
public class CountryController {




    @Autowired
    private final CountryService countryService;

    @Autowired
    private CountryRepository countryRepository;


@Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }
    //veri kaydı
    @PostMapping("/save")
    public ResponseEntity<Country> createCountry(@RequestBody Country country){
        Country resultCountry = countryService.createCountry(country);
        return ResponseEntity.ok(resultCountry);
    }
    @GetMapping("/getALL")
    public ResponseEntity<List<Country>> getCountry(){
        List<Country> countries =countryService.getCountry();
        return ResponseEntity.ok(countries);
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<Country> updateCountry(@PathVariable ("id") Long id,@RequestBody Country country ){
        Country updateCountry = countryService.updateCountry(id,country);
        return ResponseEntity.ok(updateCountry);
    }
   @DeleteMapping("/remove/{id}")
    public ResponseEntity<Boolean> deleteCountry(@PathVariable("id") Long id){
        Boolean Delete = countryService.deleteCountry(id);
        return ResponseEntity.ok(Delete);
   }
/*   @GetMapping(value = "/Search", produces = MediaType.ALL_VALUE)
    List<Map<String,String>> getListTo(@RequestParam Map<String, String> params) {
        Filter filter = new Filter(params);
        String countryName = filter.getString("countryName") == null ? "-1" : filter.getString("countryName");
        String teamName = filter.getString("teamName") == null ? "-1" : filter.getString("teamName");
        List<Map<String,String>> contractList = countryRepository.getListPlayerAndTeam(countryName,teamName);
        return contractList;
    }*/


}
