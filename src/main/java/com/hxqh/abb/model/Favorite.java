package com.hxqh.abb.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TB_FAVORITES database table.
 */
@Entity
@Table(name = "TB_FAVORITES")
public class Favorite implements Serializable {
    private static final long serialVersionUID = 1L;

    private String appname;

    @Id
    @SequenceGenerator(name = "TB_FAVORITES_FAVORITESID_GENERATOR", allocationSize = 1, sequenceName = "TB_FAVORITESSEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB_FAVORITES_FAVORITESID_GENERATOR")
    private Long favoritesid;

    private String personid;

    private Long pkid;

    public Favorite() {
    }

    public Favorite(String appname, String personid, Long pkid) {
        this.appname = appname;
        this.personid = personid;
        this.pkid = pkid;
    }

    public String getAppname() {
        return appname;
    }

    public void setAppname(String appname) {
        this.appname = appname;
    }

    public Long getFavoritesid() {
        return favoritesid;
    }

    public void setFavoritesid(Long favoritesid) {
        this.favoritesid = favoritesid;
    }

    public String getPersonid() {
        return personid;
    }

    public void setPersonid(String personid) {
        this.personid = personid;
    }

    public Long getPkid() {
        return pkid;
    }

    public void setPkid(Long pkid) {
        this.pkid = pkid;
    }
}