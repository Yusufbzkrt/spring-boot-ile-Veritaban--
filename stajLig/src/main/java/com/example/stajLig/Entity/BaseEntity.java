package com.example.stajLig.Entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;




@Data
public class BaseEntity implements Serializable {

    private Date createAt;
    private Date createDate;
    private String createdDate;
    private Date updatedAt;
    private String updateBy;
    private String createBy;
}
