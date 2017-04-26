package com.xiaofei.model;

import lombok.Data;
import org.hibernate.annotations.Cache;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by xiaofei
 * Created at 2017/4/23.
 */
@Data
@Entity
public class User implements Serializable{

    @Id
    @GeneratedValue
    private Integer id;


    @Column(name = "name" ,length = 12)
    private String name;

    @Column(name = "passwd")
    private String passwd;

    public User(){}
    public User(String name ,String passwd){
        this.name = name;
        this.passwd = passwd;
    }

}
