package com.hxqh.abb.model.version2;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the AUTOKEY database table.
 */
@Entity
@Table(name = "AUTOKEY")
public class Autokey implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "AUTOKEY_AUTOKEYID_GENERATOR", sequenceName = "AUTOKEYSEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AUTOKEY_AUTOKEYID_GENERATOR")
    private Long autokeyid;

    private String autokeyname;

    private String langcode;

    private String orgid;

    private String prefix;

    private Long rowstamp;

    private Long seed;

    private String setid;

    private String siteid;

    public Autokey() {
    }

    public Long getAutokeyid() {
        return autokeyid;
    }

    public void setAutokeyid(Long autokeyid) {
        this.autokeyid = autokeyid;
    }

    public String getAutokeyname() {
        return autokeyname;
    }

    public void setAutokeyname(String autokeyname) {
        this.autokeyname = autokeyname;
    }

    public String getLangcode() {
        return langcode;
    }

    public void setLangcode(String langcode) {
        this.langcode = langcode;
    }

    public String getOrgid() {
        return orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public Long getRowstamp() {
        return rowstamp;
    }

    public void setRowstamp(Long rowstamp) {
        this.rowstamp = rowstamp;
    }

    public Long getSeed() {
        return seed;
    }

    public void setSeed(Long seed) {
        this.seed = seed;
    }

    public String getSetid() {
        return setid;
    }

    public void setSetid(String setid) {
        this.setid = setid;
    }

    public String getSiteid() {
        return siteid;
    }

    public void setSiteid(String siteid) {
        this.siteid = siteid;
    }
}