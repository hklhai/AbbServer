package com.hxqh.abb.model.view;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;


/**
 * The persistent class for the V_DOC database table.
 */
@Entity
@Table(name = "V_DOC")
public class VDoc implements Serializable {
    private static final Long serialVersionUID = 1L;

    private String createby;

    private Date createdate;

    private String description;

    @Id
    private Long doclinksid;

    private String doctype;

    @Column(name = "\"DOCUMENT\"")
    private String document;

    private String docversion;

    private String ownertable;

    private Integer printthrulink;

    private String urlname;

    private Long ownerid;

    public VDoc() {
    }

    public Long getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(Long ownerid) {
        this.ownerid = ownerid;
    }

    public String getCreateby() {
        return this.createby;
    }

    public void setCreateby(String createby) {
        this.createby = createby;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getDoclinksid() {
        return this.doclinksid;
    }

    public void setDoclinksid(Long doclinksid) {
        this.doclinksid = doclinksid;
    }

    public String getDoctype() {
        return this.doctype;
    }

    public void setDoctype(String doctype) {
        this.doctype = doctype;
    }

    public String getDocument() {
        return this.document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getDocversion() {
        return this.docversion;
    }

    public void setDocversion(String docversion) {
        this.docversion = docversion;
    }

    public String getOwnertable() {
        return this.ownertable;
    }

    public void setOwnertable(String ownertable) {
        this.ownertable = ownertable;
    }

    public Integer getPrintthrulink() {
        return printthrulink;
    }

    public void setPrintthrulink(Integer printthrulink) {
        this.printthrulink = printthrulink;
    }

    public String getUrlname() {
        return this.urlname;
    }

    public void setUrlname(String urlname) {
        this.urlname = urlname;
    }

}