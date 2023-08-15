
package com.example.stajLig.Service.impl;

import com.example.stajLig.Entity.Player;
import com.example.stajLig.Filter;
import com.example.stajLig.Repository.PlayerRepository;
import com.example.stajLig.Service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

@Service
@RequiredArgsConstructor//constructor otomatik oluşturmayı sağlıyor.
public class PlayerServiceimpl implements PlayerService {

    private final PlayerRepository playerRepository;

    @Override
    public Player createPlayer(Player player) {
        player.setCreateAt(new Date());
        player.setCreateBy("Admin");
        return playerRepository.save(player);
    }
    @Override
    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }
    @Override
    public Player updateUser(Long id, Player player) {
        Optional<Player> resultPlayer = playerRepository.findById(id);
        if (resultPlayer.isPresent()) {
            resultPlayer.get().setFirstname(player.getFirstname());
            resultPlayer.get().setSurname(player.getSurname());
            resultPlayer.get().setCountry_id(player.getCountry_id());
            resultPlayer.get().setTeam_id(player.getTeam_id());
            resultPlayer.get().setPrice(player.getPrice());
            resultPlayer.get().setDogumtar(player.getDogumtar());
            resultPlayer.get().setGuc(player.getGuc());
            resultPlayer.get().setMevki(player.getMevki());
            resultPlayer.get().setUpdatedAt(new Date());
            resultPlayer.get().setUpdateBy("Admin");
            return playerRepository.save(resultPlayer.get());
        }
        return null;
    }

    @Override
    public Boolean deletePlayer(Long id) {
        Optional<Player> player = playerRepository.findById(id);

        if (player.isPresent()) {
            playerRepository.deleteById(id);
            return true;
        }
        return false;
    }


    @Override
    public List<Map<String, String>> getListLigAndCountry(Map<String, String> params) {
        Filter filter = new Filter(params);
        String lig = filter.getString("lig") == null ? "-1" : filter.getString("lig");
        String irk = filter.getString("irk") == null ? "-1" : filter.getString("irk");
        return playerRepository.getListLigAndCountry(lig, irk);
    }

    @Override
    public List<Map<String, String>> getAgeAndPlayers(Map<String,String> params) {
        Filter filter= new Filter(params);
        Long age = filter.getLong("age");
        String irk = filter.getString("irk") == null ? "-1" : filter.getString("irk");
        return playerRepository.getAgeAndPlayers(age,irk);
    }

    @Override
    public List<Map<String, String>> getCountryAndmevki(Map<String, String> params) {
        Filter filter = new Filter(params);
     //   JSONObject jsonObject = new JSONObject(params);  filter dosyamız olmasaydı bunu kullanırdık
        String irk =filter.getString("irk") == null ? "-1" : filter.getString("irk");
        String pozisyon=filter.getString("pozisyon") == null ? "-1" : filter.getString("pozisyon");
        return playerRepository.getCountryAndmevki(irk,pozisyon);
    }

    @Override
    public List<Map<String, String>> getMevkiAndAge(Map<String, String> params) {
        Filter filter = new Filter(params);
        String kita = filter.getString("kita") == null ? "-1" : filter.getString("kita");
        String pozisyon = filter.getString("pozisyon") == null ? "-1" : filter.getString("pozisyon");
        return playerRepository.getMevkiAndAge(kita,pozisyon);
    }

    @Override
    public List<Map<String,String>> getmevkiAndCountry(Map<String,String> params) {
        Filter filter = new Filter(params);
        String pozisyon = filter.getString("pozisyon") == null ? "-1" : filter.getString("pozisyon");
        String country = filter.getString("country") == null ? "-1" : filter.getString("country");
        return playerRepository.getmevkiAndCountry(pozisyon,country);
    }

    @Override
    public List<Map<String, String>> getCountryAndMevki(Map<String, String> params) {
        Filter filter = new Filter(params);
        String takimAdi = filter.getString("takimAdi") == null ? "-1" : filter.getString("takimAdi");
        return playerRepository.getCountryAndMevki(takimAdi);
    }

    @Override
    public List<Map<String, String>> getAgeAndMevkiAndCountry(Map<String, String> params) {
        Filter filter = new Filter(params);
        Long age = filter.getLong("age") == null ? -1L : filter.getLong("age");
        String pozisyon = filter.getString("pozisyon") == null ? "-1" : filter.getString("pozisyon");
        String country = filter.getString("country") == null ? "-1" : filter.getString("country");
        return playerRepository.getAgeAndMevkiAndCountry(age,pozisyon,country);
    }



    @Override
    public List<Map<String, String>> getAgeAndAgeAndMevki(Map<String, String> params) {
        Filter filter = new Filter(params);
        Long maxAge = filter.getLong("maxAge") == null ? -1L : filter.getLong("maxAge");
        Long minAge = filter.getLong("minAge") == null ? -1L : filter.getLong("minAge");
        String pozisyon = filter.getString("pozisyon") == null ? "-1" : filter.getString("pozisyon");
        return playerRepository.getAgeAndAgeAndMevki(maxAge,minAge,pozisyon);
    }
    @Override
    public List<Map<String, String>> getAgeAndAgeAndMevkiAndGuc(Map<String, String> params) {
        Filter filter = new Filter(params);
        Long maxAge = filter.getLong("maxAge") == null ? -1L : filter.getLong("maxAge");
        Long minAge = filter.getLong("minAge") == null ? -1L : filter.getLong("minAge");
        Long maxGuc = filter.getLong("maxGuc") == null ? -1L : filter.getLong("maxGuc");
        Long minGuc = filter.getLong("minGuc") == null ? -1L : filter.getLong("minGuc");
        String pozisyon = filter.getString("pozisyon") == null ? "-1" : filter.getString("pozisyon");
        return playerRepository.getAgeAndAgeAndMevkiAndGuc(maxAge,minAge,maxGuc,minGuc,pozisyon);
    }

    @Override
    public List<Map<String, String>> getAyakaAndPrice(Map<String, String> params) {
        Filter filter = new Filter(params);
        String ayak = filter.getString("ayak") == null ? "-1" : filter.getString("ayak");
        return playerRepository.getAyakaAndPrice(ayak);
    }


  //  public List<Map<String, String>> Age(Map<String, String> params) {
    //    Filter filter = new Filter(params);
     //   LocalDate simdiki_tarih = LocalDate.now();
     //   String futbolcu = filter.getString("futbolcu") == null ? "-1" : filter.getString("futbolcu");
    //   Long yas = filter.getLong("yas") == null ? -1L : filter.getLong("yas");
     //   Period.between(simdiki_tarih, LocalDate.ofEpochDay(yas)).getYears();
     //   return playerRepository.Age(yas,futbolcu);
  // }



}


