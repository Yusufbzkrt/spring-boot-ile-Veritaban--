
package com.example.stajLig.Api;
import com.example.stajLig.Filter;

import com.example.stajLig.Entity.Country;
import com.example.stajLig.Entity.Player;
import com.example.stajLig.Repository.PlayerRepository;
import com.example.stajLig.Service.PlayerService;
import liquibase.pro.packaged.S;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Player")
@CrossOrigin(origins = "http://localhost8081")
public class PlayerController {

    @Autowired
    PlayerRepository playerRepository;


    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {

        this.playerService = playerService;
    }

    //veri kaydı
    @PostMapping("/save")
    public ResponseEntity<Player> createPlayer(@RequestBody Player player) {
        Player resultPlayer = playerService.createPlayer(player);
        return ResponseEntity.ok(resultPlayer);
    }

    //veri listeleme
    @GetMapping("/getALL")
    public ResponseEntity<List<Player>> getPlayers() {
        List<Player> players = playerService.getPlayers();
        return ResponseEntity.ok(players);
    }

    //veri güncelleme
    @PutMapping("/edit/{id}")
    public ResponseEntity<Player> updateUser(@PathVariable("id") Long id, @RequestBody Player player) {
        Player resultPlayer = playerService.updateUser(id, player);
        return ResponseEntity.ok(resultPlayer);
    }

    //veri silme
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Boolean> deletePlayer(@PathVariable("id") Long id) {
        Boolean status = playerService.deletePlayer(id);
        return ResponseEntity.ok(status);
    }

    @GetMapping(value = "/deneme1")
    public ResponseEntity<List<Map<String, String>>> getListLigAndCountry(@RequestParam Map<String, String> params) {
        List<Map<String, String>> contractList = playerService.getListLigAndCountry(params);
        return ResponseEntity.ok(contractList);
    }

    @GetMapping(value = "/deneme2")
    public ResponseEntity<List<Map<String, String>>> getAgeAndPlayers(@RequestParam Map<String, String> params) {
        List<Map<String, String>> contractlist = playerService.getAgeAndPlayers(params);
        return ResponseEntity.ok(contractlist);
    }

    @GetMapping(value = "/deneme3")
    public ResponseEntity<List<Map<String, String>>> getCountryAndmevki(@RequestParam Map<String, String> params) {
        List<Map<String, String>> liste = playerService.getCountryAndmevki(params);
        return ResponseEntity.ok(liste);
    }

    @GetMapping("/deneme4")
    //TAKIMINDA AVRUPALI ORTA SAHA BULUNAN TAKIMLARIN FUTBOLCU YAS ORTALAMASI
    public ResponseEntity<List<Map<String, String>>> getMevkiAndAge(@RequestParam Map<String, String> params) {
        List<Map<String, String>> listem = playerService.getMevkiAndAge(params);
        return ResponseEntity.ok(listem);
    }

    //EN ÇOK KALECİ YETİTİREN ULKE
    @GetMapping("/deneme5")
    public ResponseEntity<List<Map<String, String>>> getmevkiAndCountry(@RequestParam Map<String, String> params) {
        List<Map<String, String>> listemi = playerService.getmevkiAndCountry(params);
        return ResponseEntity.ok(listemi);
    }

    @GetMapping("/deneme6")
    public ResponseEntity<List<Map<String, String>>> getCountryAndMevki(@RequestParam Map<String, String> params) {
        List<Map<String, String>> listemi = playerService.getCountryAndMevki(params);
        return ResponseEntity.ok(listemi);
    }

    @GetMapping("/deneme7")
    public ResponseEntity<List<Map<String, String>>> getAgeAndMevkiAndCountry(@RequestParam Map<String, String> params) {
        List<Map<String, String>> listemi = playerService.getAgeAndMevkiAndCountry(params);
        return ResponseEntity.ok(listemi);
    }

    @GetMapping("/deneme8")
    public ResponseEntity<List<Map<String, String>>> getAgeAndAgeAndMevki(@RequestParam Map<String, String> params) {
        List<Map<String, String>> listemi = playerService.getAgeAndAgeAndMevki(params);
        return ResponseEntity.ok(listemi);
    }

    @GetMapping("/deneme9")
    public ResponseEntity<List<Map<String, String>>> getAgeAndAgeAndMevkiAndGuc(@RequestParam Map<String, String> params) {
        List<Map<String, String>> listemi = playerService.getAgeAndAgeAndMevkiAndGuc(params);
        return ResponseEntity.ok(listemi);
    }

    @GetMapping("/deneme10")
    public ResponseEntity<List<Map<String, String>>> getAyakaAndPrice(@RequestParam Map<String, String> params) {
        List<Map<String, String>> listemi = playerService.getAyakaAndPrice(params);
        return ResponseEntity.ok(listemi);
    }

}