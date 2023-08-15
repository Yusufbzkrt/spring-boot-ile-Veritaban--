
package com.example.stajLig.Entity;


import javax.persistence.*;

import com.example.stajLig.Service.Auditable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


import java.util.Date;

@Entity
@Table(name = "STADIUM")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Stadium extends Auditable<Long> {
    @Id
    @GeneratedValue(generator = "SEQ_STADIUM",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SEQ_STADIUM",sequenceName = "SEQ_STADIUM",allocationSize = 1)
    @Column(name = "ID")
    private Long id;
    @Column(name = "STADIUM")
    private String stadium;
    @Column(name = "HEIGHT")
    private int height;


    private Date createAt;
    private Date createDate;
    private String createdDatee;
    private Date updatedAt;
    private String updateBy;
    private String createBy;
}

