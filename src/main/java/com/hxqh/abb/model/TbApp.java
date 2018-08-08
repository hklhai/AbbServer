package com.hxqh.abb.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TB_APP database table.
 */
@Entity
@Table(name = "V_APP")
public class TbApp implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "TB_APP_APPID_GENERATOR", sequenceName = "TB_APPSEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB_APP_APPID_GENERATOR")
    private long appid;

    private String appchname;

    private String appcontent;

    private String appfield;

    private String appname;

    private String apptable;

    private String fieldtype;

    private Integer ordernum;

    private Integer ispk;

    private String childtablename;

    public TbApp(String appfield, String fieldtype) {
        this.appfield = appfield;
        this.fieldtype = fieldtype;
    }

    public TbApp() {
    }

    public Integer getIspk() {
        return ispk;
    }

    public void setIspk(Integer ispk) {
        this.ispk = ispk;
    }

    public long getAppid() {
        return this.appid;
    }

    public void setAppid(long appid) {
        this.appid = appid;
    }

    public String getAppchname() {
        return this.appchname;
    }

    public void setAppchname(String appchname) {
        this.appchname = appchname;
    }

    public String getAppcontent() {
        return this.appcontent;
    }

    public void setAppcontent(String appcontent) {
        this.appcontent = appcontent;
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

    public String getFieldtype() {
        return fieldtype;
    }

    public void setFieldtype(String fieldtype) {
        this.fieldtype = fieldtype;
    }

    public Integer getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(Integer ordernum) {
        this.ordernum = ordernum;
    }

    public String getChildtablename() {
        return childtablename;
    }

    public void setChildtablename(String childtablename) {
        this.childtablename = childtablename;
    }
}