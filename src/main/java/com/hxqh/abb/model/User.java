package com.hxqh.abb.model;

import java.io.Serializable;

//@Entity
//@Table(name = "tb_user")
public class User  implements Serializable {

    private int id;
    private String name;
    private String password;
    private String sex;


    public User() {
    }

    public User(String name, String password, String sex) {
        super();
        this.name = name;
        this.password = password;
        this.sex = sex;
    }

    //@Id
    //@GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


}
