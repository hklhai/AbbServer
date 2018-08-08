package com.hxqh.abb.model.version2;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the EMAIL database table.
 */
@Entity
@Table(name = "Email")
public class Email implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "EMAIL_EMAILID_GENERATOR", sequenceName = "EMAILSEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMAIL_EMAILID_GENERATOR")
    private Long emailid;

    private String emailaddress;

    private Integer isprimary;

    private String personid;

    private Long rowstamp;

    @Column(name = "\"TYPE\"")
    private String type;

    public Email() {
    }

    public Long getEmailid() {
        return emailid;
    }

    public void setEmailid(Long emailid) {
        this.emailid = emailid;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
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

    public Long getRowstamp() {
        return rowstamp;
    }

    public void setRowstamp(Long rowstamp) {
        this.rowstamp = rowstamp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}