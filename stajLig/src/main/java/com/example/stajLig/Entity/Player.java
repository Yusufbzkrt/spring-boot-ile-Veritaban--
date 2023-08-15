
package com.example.stajLig.Entity;

import javax.persistence.*;

import com.example.stajLig.Service.Auditable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.Date;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.Period;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;


@Entity
@Table(name = "PLAYER")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Player extends Auditable<Long> {
    @Id
    @GeneratedValue(generator = "SEQ_PLAYER",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SEQ_PLAYER",sequenceName = "SEQ_PLAYER",allocationSize = 1)

    private Long id;
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Column(name = "SURNAME")
    private String surname;
    @Column(name = "COUNTRYID")
    private int country_id;
    @Column(name = "TEAMID")
    private int team_id;
    @Column(name = "PRICE")
    private int price;
    @Column(name = "DOGUMTAR")
    private Date dogumtar;
    @Column(name = "MEVKI")
    private String mevki;
    @Column(name = "AYAK")
    private String ayak;
    @Column(name = "GUC")
    private int guc;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public int getTeam_id() {
        return team_id;
    }

    public void setTeam_id(int team_id) {
        this.team_id = team_id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getDogumtar() {
        return dogumtar;
    }

    public void setDogumtar(Date dogumtar) {
        this.dogumtar = dogumtar;
    }

    public String getMevki() {
        return mevki;
    }

    public void setMevki(String mevki) {
        this.mevki = mevki;
    }

    public String getAyak() {
        return ayak;
    }

    public void setAyak(String ayak) {
        this.ayak = ayak;
    }

    public int getGuc() {
        return guc;
    }

    public void setGuc(int guc) {
        this.guc = guc;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreatedDatee() {
        return createdDatee;
    }

    public void setCreatedDatee(String createdDatee) {
        this.createdDatee = createdDatee;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    private Date createAt;
    private Date createDate;
    private String createdDatee;
    private Date updatedAt;
    private String updateBy;
    private String createBy;
}