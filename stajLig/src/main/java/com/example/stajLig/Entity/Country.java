package com.example.stajLig.Entity;
import com.example.stajLig.Service.Auditable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "COUNTRY")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Country extends Auditable<Long> {
    @Id
    @GeneratedValue(generator = "SEQ_COUNTRY",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SEQ_COUNTRY",sequenceName = "SEQ_COUNTRY",allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CONTINENT")
    private String continent;

    @Column(name = "created_by")
    private Long createdBy;


    private Date createAt;
    private Date createDate;
    private String createdDatee;
    private Date updatedAt;
    private String updateBy;
    private String createBy;

}
