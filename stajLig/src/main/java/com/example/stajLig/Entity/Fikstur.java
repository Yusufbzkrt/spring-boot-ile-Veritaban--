
package com.example.stajLig.Entity;

import javax.persistence.*;

import com.example.stajLig.Service.Auditable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


import java.util.Date;

@Entity
@Table(name = "FIKSTUR")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Fikstur extends Auditable<Long> {

    @Id
    @GeneratedValue(generator = "SEQ_FIKSTUR",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SEQ_FIKSTUR",sequenceName = "SEQ_FIKSTUR",allocationSize = 1)
    @Column(name = "ID")
    private Long id;
    @Column(name = "ICSAHA")
    private String ic_saha;
    @Column(name = "IC1")
    private String iç;
    @Column(name = "DEPLASMAN")
    private String deplasman;
    @Column(name = "DIŞ1")
    private String dış;
    @Column(name = "HAFTA")
    private int hafta;

    private Date createAt;
    private Date createDate;
    private String createdDatee;
    private Date updatedAt;
    private String updateBy;
    private String createBy;
}

