package com.hxqh.abb.model.view;


import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the V_UDWOQUALIFICATION database table.
 */
@Entity
@Table(name = "V_UDWOQUALIFICATION")
public class VUdwoqualification implements Serializable {
    private static final long serialVersionUID = 1L;

    private String qualification;

    private String udwoqualificationdescription;

    private String wonum;

    private String siteid;

    @Id
    private Long udwoqualificationid;

    public VUdwoqualification(){

    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getUdwoqualificationdescription() {
        return udwoqualificationdescription;
    }

    public void setUdwoqualificationdescription(String udwoqualificationdescription) {
        this.udwoqualificationdescription = udwoqualificationdescription;
    }

    public String getWonum() {
        return wonum;
    }

    public void setWonum(String wonum) {
        this.wonum = wonum;
    }

    public String getSiteid() {
        return siteid;
    }

    public void setSiteid(String siteid) {
        this.siteid = siteid;
    }

    public Long getUdwoqualificationid() {
        return udwoqualificationid;
    }

    public void setUdwoqualificationid(Long udwoqualificationid) {
        this.udwoqualificationid = udwoqualificationid;
    }
}


