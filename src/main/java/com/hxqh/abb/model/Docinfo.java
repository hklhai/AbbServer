package com.hxqh.abb.model;

import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


/**
 * The persistent class for the DOCINFO database table.
 */
@Entity
@Table(name = "DOCINFO")
@DynamicUpdate
public class Docinfo implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "DOCINFO_DOCINFOID_GENERATOR", allocationSize = 1, sequenceName = "DOCINFOSEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DOCINFO_DOCINFOID_GENERATOR")
    private Long docinfoid;

    @Column(name = "\"APPLICATION\"")
    private String application;

    private String changeby;

    private Date changedate;

    private String contentuid;

    private String createby;

    private Date createdate;

    private String description;

    private String dmsname;

    private String doclocation;

    private String doctype;

    @Column(name = "\"DOCUMENT\"")
    private String document;

    private Integer hasld;

    private String langcode;

    private Integer printthrulinkdflt;

    private Integer revision;

    private Long rowstamp;

    private Integer show;

    @Column(name = "\"STATUS\"")
    private String status;

    private Date statusdate;

    private String urlname;

    private String urlparam1;

    private String urlparam2;

    private String urlparam3;

    private String urlparam4;

    private String urlparam5;

    private String urltype;

    private Integer usedefaultfilepath;

    public Docinfo() {
    }

    public Long getDocinfoid() {
        return this.docinfoid;
    }

    public void setDocinfoid(Long docinfoid) {
        this.docinfoid = docinfoid;
    }

    public String getApplication() {
        return this.application;
    }

    public void setApplication(String application) {
        this.application = application;
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

    public String getContentuid() {
        return this.contentuid;
    }

    public void setContentuid(String contentuid) {
        this.contentuid = contentuid;
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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDmsname() {
        return this.dmsname;
    }

    public void setDmsname(String dmsname) {
        this.dmsname = dmsname;
    }

    public String getDoclocation() {
        return this.doclocation;
    }

    public void setDoclocation(String doclocation) {
        this.doclocation = doclocation;
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

    public Integer getHasld() {
        return this.hasld;
    }

    public void setHasld(Integer hasld) {
        this.hasld = hasld;
    }

    public String getLangcode() {
        return this.langcode;
    }

    public void setLangcode(String langcode) {
        this.langcode = langcode;
    }

    public Integer getPrintthrulinkdflt() {
        return printthrulinkdflt;
    }

    public void setPrintthrulinkdflt(Integer printthrulinkdflt) {
        this.printthrulinkdflt = printthrulinkdflt;
    }

    public Integer getRevision() {
        return this.revision;
    }

    public void setRevision(Integer revision) {
        this.revision = revision;
    }

    public Long getRowstamp() {
        return this.rowstamp;
    }

    public void setRowstamp(Long rowstamp) {
        this.rowstamp = rowstamp;
    }

    public Integer getShow() {
        return this.show;
    }

    public void setShow(Integer show) {
        this.show = show;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStatusdate() {
        return this.statusdate;
    }

    public void setStatusdate(Date statusdate) {
        this.statusdate = statusdate;
    }

    public String getUrlname() {
        return this.urlname;
    }

    public void setUrlname(String urlname) {
        this.urlname = urlname;
    }

    public String getUrlparam1() {
        return this.urlparam1;
    }

    public void setUrlparam1(String urlparam1) {
        this.urlparam1 = urlparam1;
    }

    public String getUrlparam2() {
        return this.urlparam2;
    }

    public void setUrlparam2(String urlparam2) {
        this.urlparam2 = urlparam2;
    }

    public String getUrlparam3() {
        return this.urlparam3;
    }

    public void setUrlparam3(String urlparam3) {
        this.urlparam3 = urlparam3;
    }

    public String getUrlparam4() {
        return this.urlparam4;
    }

    public void setUrlparam4(String urlparam4) {
        this.urlparam4 = urlparam4;
    }

    public String getUrlparam5() {
        return this.urlparam5;
    }

    public void setUrlparam5(String urlparam5) {
        this.urlparam5 = urlparam5;
    }

    public String getUrltype() {
        return this.urltype;
    }

    public void setUrltype(String urltype) {
        this.urltype = urltype;
    }

    public Integer getUsedefaultfilepath() {
        return this.usedefaultfilepath;
    }

    public void setUsedefaultfilepath(Integer usedefaultfilepath) {
        this.usedefaultfilepath = usedefaultfilepath;
    }

}