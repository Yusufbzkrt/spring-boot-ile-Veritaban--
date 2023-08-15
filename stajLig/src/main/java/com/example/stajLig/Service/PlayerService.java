
package com.example.stajLig.Service;

import com.example.stajLig.Entity.Player;
import org.apache.catalina.User;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;


public interface PlayerService {
Player createPlayer(Player player);
List<Player> getPlayers();

Player updateUser(Long id, Player player);
Boolean deletePlayer(Long id);

List<Map<String,String>> getListLigAndCountry(Map<String, String> params);
List<Map<String,String>>  getAgeAndPlayers(Map<String, String> params);
List<Map<String,String>> getCountryAndmevki(Map<String, String> params);
    List<Map<String,String>> getMevkiAndAge(Map<String, String> params);
    List<Map<String,String>> getmevkiAndCountry(Map<String, String> params);
    List<Map<String,String>> getCountryAndMevki(Map<String, String> params);
    List<Map<String,String>> getAgeAndMevkiAndCountry(Map<String, String> params);
    List<Map<String,String>> getAgeAndAgeAndMevki(Map<String, String> params);
    List<Map<String,String>> getAgeAndAgeAndMevkiAndGuc(Map<String, String> params);
    List<Map<String,String>> getAyakaAndPrice(Map<String, String> params);
}

