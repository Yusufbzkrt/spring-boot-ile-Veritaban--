
package com.example.stajLig.Repository;

import com.example.stajLig.Entity.Player;
import liquibase.pro.packaged.M;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;


@Repository
public interface PlayerRepository extends JpaRepository<Player,Long> {

//deneme1
        @Query(value ="select pt.firstname as futbolcuAdi ,\n" +
                "                pt.surname as futbolcuSoyadi,\n" +
                "                tt.lig as futbolcuLigi,\n" +
                "                ct.name as futbolcuMemleket\n" +
                "                from player pt\n" +
                "                inner join country ct on pt.countryid=ct.id \n" +
                "                inner join team tt on pt.teamid=tt.id \n" +
                "                where (tt.lig = :lig or :lig ='-1') and \n" +
                "                (ct.name = :irk or :irk ='-1')", nativeQuery = true)
        List<Map<String,String>> getListLigAndCountry(@RequestParam("lig") String lig, @RequestParam("irk") String irk) ;
//deneme2
    //date_part, bir tarih veya saat değerinden yıl, ay, gün, saat, dakika veya saniye ayıklamak için kullanabiliriz.
           @Query(value = "select p.firstname,p.surname,p.dogumtar,c.name\n" +
                   "from player p\n" +
                   "inner join country c on\n" +
                   "p.countryid = c.id\n" +
                   "where (date_part('year',current_date) - date_part('year', p.dogumtar ) < :age ) \n" +
                   "and (c.name = :irk or :irk = '-1')",nativeQuery = true)
           List<Map<String,String>> getAgeAndPlayers(@RequestParam("age") Long age, @RequestParam("irk") String irk);
// deneme3
           @Query(value = " select avg(date_part('year',current_date) - date_part('year', p.dogumtar )) as ortalamaYas , count(c.name)  as toplamOyuncu\n" +
                   "                    from player p \n" +
                   "                    inner join country c on p.countryid = c.id \n" +
                   "                    where (c.name = :irk or :irk ='-1') and \n" +
                   "                   (p.mevki = :pozisyon or :pozisyon='-1')",nativeQuery = true)
           List<Map<String,String>> getCountryAndmevki(@RequestParam("irk") String irk, @RequestParam("pozisyon") String pozisyon) ;
//deneme4

@Query(value = "select avg(date_part('year',current_date) - date_part('year', p.dogumtar )) as ortalamaYas, count(c.continent) as KıtaToplamOyuncu\n" +
        " from player p \n" +
        " inner join country c on p.countryid =c.id \n" +
        " where (c.continent= :kita or :kita ='-1') and (p.mevki = :pozisyon or :pozisyon='-1')",nativeQuery = true)
  List<Map<String,String>> getMevkiAndAge(@RequestParam("kita")String kita,@RequestParam("pozisyon")String pozisyon);

//deneme5
    @Query(value = "select c.\"name\", count(p.id) as OyuncuSayisi \n" +
            "  from country c \n" +
            "   inner join player p on c.id =p.countryid \n" +
            "  where (p.mevki = :pozisyon or :pozisyon = '-1') and \n" +
            "(c.name = :country or :country ='-1') \n" +
            "  group by c.\"name\" ",nativeQuery = true)
    List<Map<String,String>> getmevkiAndCountry(@RequestParam("pozisyon") String pozisyon,@RequestParam("country")String country);


    //TAKIMLARIN FUTBOLCULARIN ULKELERE GORE SAYISI
// deneme6
    @Query(value = "select c.name,count(p.id) as oyuncuSayisi\n" +
            "from country c \n" +
            "inner join player p on c.id=p.countryid \n" +
            "inner join team t on t.id=p.teamid \n" +
            "where (t.teamname = :takimAdi or :takimAdi = '-1')\n" +
            "group by c.\"name\" ",nativeQuery = true)
    List<Map<String,String>> getCountryAndMevki(@RequestParam("takimAdi") String takimAdi);



    //deneme7
    //YASI 30 USTU OLAN FORVET OLUPTA ULKESİ TURKİYEOLAN FUTBOLCU
    @Query(value = "select p.dogumtar,p.mevki,c.name,p.firstname,p.surname\n" +
            "from player p \n" +
            "inner join country c on c.id =p.countryid \n" +
            "where (date_part('year',current_date) - date_part('year', p.dogumtar ) > :age or :age ='-1') and" +
            " (p.mevki = :pozisyon or :pozisyon = '-1') and" +
            " (c.\"name\" = :country or :country = '-1')",nativeQuery = true)
    List<Map<String,String>> getAgeAndMevkiAndCountry(@RequestParam("age") Long age,@RequestParam("pozisyon")String pozisyon,@RequestParam("country")String country);


    //deneme8
    //YAŞI 24 İLE 26 ARASINDA OLAN VE KALECİSİ OLAN TAKIMLAR
    @Query(value = "select p.dogumtar,p.mevki,t.teamname,p.firstname,p.surname \n" +
            "\t\tfrom player p \n" +
            "\t\tinner join team t on p.teamid =t.id\n" +
            "\t\twhere (date_part('year',current_date) - date_part('year', p.dogumtar ) < :maxAge or :maxAge= '-1') and (date_part('year',current_date) - date_part('year', p.dogumtar ) > :minAge or :minAge= '-1')\n" +
            "\t\tand (p.mevki = :pozisyon or :pozisyon = '-1')",nativeQuery = true)
    List<Map<String,String>> getAgeAndAgeAndMevki(@RequestParam("maxAge") Long maxAge,@RequestParam("minAge") Long minAge,@RequestParam("pozisyon")String pozisyon);

    //deneme9
    //YAŞI 18 İLE 22 ARASINDA OLAN FORVETLERARASINDA GUCU 70 İLE 80 ARASINDAKI FUTBOLCULAR
    @Query(value = "select p.dogumtar,p.mevki,t.teamname,p.firstname,p.guc \n" +
            "\t\tfrom player p \n" +
            "\t\tinner join team t on p.teamid =t.id\n" +
            "\t\twhere (date_part('year',current_date) - date_part('year', p.dogumtar ) < :maxAge or :maxAge= '-1') and (date_part('year',current_date) - date_part('year', p.dogumtar ) > :minAge or :minAge= '-1')\n" +
            "\t\tand (p.mevki = :pozisyon or :pozisyon = '-1') and (p.guc < :maxGuc or :maxGuc = '-1')\n" +
            "\t\tand (p.guc > :minGuc or :minGuc = '-1')",nativeQuery = true)
    List<Map<String,String>> getAgeAndAgeAndMevkiAndGuc(@RequestParam("maxAge") Long maxAge,@RequestParam("minAge") Long minAge,@RequestParam("maxGuc") Long maxGuc,@RequestParam("minGuc") Long minGuc,@RequestParam("pozisyon")String pozisyon);


    //deneme10
    //SAĞ AYAKLI OLUP PİYASA DEĞERİ EN YUKSEK BES FUTBOL
    @Query(value = "select p.firstname,p.surname,p.price,p.ayak as kullandıgıAyak\n" +
            "\t\tfrom player p \n" +
            "\t\twhere ( p.ayak = :ayak or :ayak= '-1')\n" +
            "\t\torder by p.price desc limit 5",nativeQuery = true)
    List<Map<String,String>> getAyakaAndPrice(@RequestParam("ayak")String ayak);

  //  @Query(value = "select p.dogumtar ,p.mevki,c.name,p.firstname,p.surname\n" +
       //     "            from player p\n" +
       //     "            inner join country c on c.id =p.countryid \n" +
       //     "            where ( p.dogumtar > :age or :age = '-1')  and\n" +
       //     "             (p.mevki = :pozisyon or :pozisyon = '-1') and\n" +
      //      "             (c.name = :country or :country = '-1')",nativeQuery = true)
  //  List<Map<String, String>> Age(@RequestParam("yas")Long yas,@RequestParam("futbolcu")String futbolcu);
}







