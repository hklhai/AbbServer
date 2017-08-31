package com.hxqh.abb.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TB_RELATION database table.
 */
@Entity
@Table(name = "TB_RELATION")
public class Relation implements Serializable {
    private static final long serialVersionUID = 1L;

    private String appchname;

    private String appfield;

    private String appname;

    private String apptable;

    private Integer ischild;

    @Id
    @SequenceGenerator(name = "TB_RELATION_RELATIONID_GENERATOR", allocationSize = 1, sequenceName = "TB_RELATION")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB_RELATION_RELATIONID_GENERATOR")
    private Long relationid;

    private String relationtable;

    private String relationtablechname;

    private String relationtablepk;

    private String relationtableseq;

    public Relation() {
    }

    public String getAppchname() {
        return this.appchname;
    }

    public void setAppchname(String appchname) {
        this.appchname = appchname;
    }

    public String getAppfield() {
        return this.appfield;
    }

    public void setAppfield(String appfield) {
        this.appfield = appfield;
    }

    public String getAppname() {
        return this.appname;
    }

    public void setAppname(String appname) {
        this.appname = appname;
    }

    public String getApptable() {
        return this.apptable;
    }

    public void setApptable(String apptable) {
        this.apptable = apptable;
    }

    public Integer getIschild() {
        return this.ischild;
    }

    public void setIschild(Integer ischild) {
        this.ischild = ischild;
    }


    public Long getRelationid() {
        return relationid;
    }

    public void setRelationid(Long relationid) {
        this.relationid = relationid;
    }

    public String getRelationtable() {
        return this.relationtable;
    }

    public void setRelationtable(String relationtable) {
        this.relationtable = relationtable;
    }

    public String getRelationtablechname() {
        return this.relationtablechname;
    }

    public void setRelationtablechname(String relationtablechname) {
        this.relationtablechname = relationtablechname;
    }

    public String getRelationtablepk() {
        return this.relationtablepk;
    }

    public void setRelationtablepk(String relationtablepk) {
        this.relationtablepk = relationtablepk;
    }

    public String getRelationtableseq() {
        return this.relationtableseq;
    }

    public void setRelationtableseq(String relationtableseq) {
        this.relationtableseq = relationtableseq;
    }

}