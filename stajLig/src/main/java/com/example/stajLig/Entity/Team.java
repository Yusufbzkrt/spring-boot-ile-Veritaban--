
package com.example.stajLig.Entity;

import javax.persistence.*;

import com.example.stajLig.Service.Auditable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


import java.util.Date;

@Entity
@Table(name = "TEAM")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Team extends Auditable<Long> {
    @Id
  @GeneratedValue(generator = "SEQ_TEAM",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SEQ_TEAM",sequenceName = "SEQ_TEAM",allocationSize = 1)
    @Column(name = "ID")
    private Long id;
    @Column(name = "TEAMNAME")
    private String team;
    @Column(name = "LIG")
    private String lig;
    @Column(name = "STADIUMID")
    private Long stadium_id;
    @Column(name = "TEAMCODE")
    private String code;

  private Date createAt;
  private Date createDate;
  private String createdDatee;
  private Date updatedAt;
  private String updateBy;
  private String createBy;
}

