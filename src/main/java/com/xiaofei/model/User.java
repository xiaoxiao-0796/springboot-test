package com.xiaofei.model;

import lombok.Data;
import org.hibernate.annotations.Cache;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by xiaofei
 * Created at 2017/4/23.
 */
@Data
@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer id;


    @Column(name = "name")
    private String name;

    @Column(name = "passwd")
    private String passwd;

}
