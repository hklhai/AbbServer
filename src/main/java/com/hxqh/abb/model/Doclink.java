package com.hxqh.abb.model;

import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


/**
 * The persistent class for the DOCLINKS database table.
 */
@Entity
@Table(name = "DOCLINKS")
@DynamicUpdate
public class Doclink implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "DOCLINKS_DOCLINKSID_GENERATOR", sequenceName = "DOCLINKSSEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DOCLINKS_DOCLINKSID_GENERATOR")
    private Long doclinksid;

    private String changeby;

    private Date changedate;

    private Integer copylinktowo;

    private String createby;

    private Date createdate;

    private Long docinfoid;

    private String doctype;

    @Column(name = "\"DOCUMENT\"")
    private String document;

    private String docversion;

    private Integer getlatestversion;

    private Long ownerid;

    private String ownertable;

    private Integer printthrulink;

    @Column(name = "\"REFERENCE\"")
    private String reference;

    private Long rowstamp;

    private String udfiletype;

    public Doclink() {
    }

    public Long getDoclinksid() {
        return this.doclinksid;
    }

    public void setDoclinksid(Long doclinksid) {
        this.doclinksid = doclinksid;
    }

    public String getChangeby() {
        return this.changeby;
    }

    public void setChangeby(String changeby) {
        this.changeby = changeby;
    }

    public Date getChangedate() {
        return this.changedate;
    }

    public void setChangedate(Date changedate) {
        this.changedate = changedate;
    }

    public Integer getCopylinktowo() {
        return this.copylinktowo;
    }

    public void setCopylinktowo(Integer copylinktowo) {
        this.copylinktowo = copylinktowo;
    }

    public String getCreateby() {
        return this.createby;
    }

    public void setCreateby(String createby) {
        this.createby = createby;
    }

    public Date getCreatedate() {
        return this.createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Long getDocinfoid() {
        return this.docinfoid;
    }

    public void setDocinfoid(Long docinfoid) {
        this.docinfoid = docinfoid;
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

    public Integer getGetlatestversion() {
        return this.getlatestversion;
    }

    public void setGetlatestversion(Integer getlatestversion) {
        this.getlatestversion = getlatestversion;
    }

    public Long getOwnerid() {
        return this.ownerid;
    }

    public void setOwnerid(Long ownerid) {
        this.ownerid = ownerid;
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

    public String getReference() {
        return this.reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Long getRowstamp() {
        return this.rowstamp;
    }

    public void setRowstamp(Long rowstamp) {
        this.rowstamp = rowstamp;
    }

    public String getUdfiletype() {
        return this.udfiletype;
    }

    public void setUdfiletype(String udfiletype) {
        this.udfiletype = udfiletype;
    }

}