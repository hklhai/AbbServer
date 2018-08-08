package com.hxqh.abb.model.version2;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PHONE database table.
 */
@Entity
@Table(name = "Phone")
public class Phone implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "PHONE_PHONEID_GENERATOR", sequenceName = "PHONESEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PHONE_PHONEID_GENERATOR")
    private Long phoneid;

    private Integer isprimary;

    private String personid;

    private String phonenum;

    private long rowstamp;

    @Column(name = "\"TYPE\"")
    private String type;

    public Phone() {
    }

    public Long getPhoneid() {
        return phoneid;
    }

    public void setPhoneid(Long phoneid) {
        this.phoneid = phoneid;
    }

    public Integer getIsprimary() {
        return isprimary;
    }

    public void setIsprimary(Integer isprimary) {
        this.isprimary = isprimary;
    }

    public String getPersonid() {
        return personid;
    }

    public void setPersonid(String personid) {
        this.personid = personid;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public long getRowstamp() {
        return rowstamp;
    }

    public void setRowstamp(long rowstamp) {
        this.rowstamp = rowstamp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}