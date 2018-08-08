package com.hxqh.abb.model.version2;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the RELATEDRECORD database table.
 */
@Entity
@Table(name = "Relatedrecord")
@DynamicUpdate
public class Relatedrecord implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "RELATEDRECORD_RELATEDRECORDID_GENERATOR", allocationSize = 1, sequenceName = "RELATEDRECORDSEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RELATEDRECORD_RELATEDRECORDID_GENERATOR")
    private Long relatedrecordid;

    @Column(name = "\"CLASS\"")
    private String class_;

    private String orgid;

    private String recordkey;

    private String relatedrecclass;

    private String relatedreckey;

    private String relatedrecorgid;

    private String relatedrecsiteid;

    private String relatetype;

    private Long rowstamp;

    private String siteid;

    @Transient
    private Long frontedid;
    @Transient
    private String wonum;


    public Relatedrecord() {
    }

    public String getWonum() {
        return wonum;
    }

    public void setWonum(String wonum) {
        this.wonum = wonum;
    }

    public Long getFrontedid() {
        return frontedid;
    }

    public void setFrontedid(Long frontedid) {
        this.frontedid = frontedid;
    }

    public Long getRelatedrecordid() {
        return this.relatedrecordid;
    }

    public void setRelatedrecordid(Long relatedrecordid) {
        this.relatedrecordid = relatedrecordid;
    }

    public String getClass_() {
        return this.class_;
    }

    public void setClass_(String class_) {
        this.class_ = class_;
    }

    public String getOrgid() {
        return this.orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid;
    }

    public String getRecordkey() {
        return this.recordkey;
    }

    public void setRecordkey(String recordkey) {
        this.recordkey = recordkey;
    }

    public String getRelatedrecclass() {
        return this.relatedrecclass;
    }

    public void setRelatedrecclass(String relatedrecclass) {
        this.relatedrecclass = relatedrecclass;
    }

    public String getRelatedreckey() {
        return this.relatedreckey;
    }

    public void setRelatedreckey(String relatedreckey) {
        this.relatedreckey = relatedreckey;
    }

    public String getRelatedrecorgid() {
        return this.relatedrecorgid;
    }

    public void setRelatedrecorgid(String relatedrecorgid) {
        this.relatedrecorgid = relatedrecorgid;
    }

    public String getRelatedrecsiteid() {
        return this.relatedrecsiteid;
    }

    public void setRelatedrecsiteid(String relatedrecsiteid) {
        this.relatedrecsiteid = relatedrecsiteid;
    }

    public String getRelatetype() {
        return this.relatetype;
    }

    public void setRelatetype(String relatetype) {
        this.relatetype = relatetype;
    }

    public Long getRowstamp() {
        return this.rowstamp;
    }

    public void setRowstamp(Long rowstamp) {
        this.rowstamp = rowstamp;
    }

    public String getSiteid() {
        return this.siteid;
    }

    public void setSiteid(String siteid) {
        this.siteid = siteid;
    }

}