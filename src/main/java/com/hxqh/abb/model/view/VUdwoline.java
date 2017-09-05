package com.hxqh.abb.model.view;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the V_UDWOLINE database table.
 */
@Entity
@Table(name = "V_UDWOLINE")
public class VUdwoline implements Serializable {
    private static final long serialVersionUID = 1L;

    private String assetnum;

    private String assetdescription;

    private String assetudmodel;

    private String location;

    private String locationsdescription;

    @Id
    private Long udwolineid;

    public VUdwoline(){
    }


    public String getAssetnum() {
        return assetnum;
    }

    public void setAssetnum(String assetnum) {
        this.assetnum = assetnum;
    }

    public String getAssetdescription() {
        return assetdescription;
    }

    public void setAssetdescription(String assetdescription) {
        this.assetdescription = assetdescription;
    }

    public String getAssetudmodel() {
        return assetudmodel;
    }

    public void setAssetudmodel(String assetudmodel) {
        this.assetudmodel = assetudmodel;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocationsdescription() {
        return locationsdescription;
    }

    public void setLocationsdescription(String locationsdescription) {
        this.locationsdescription = locationsdescription;
    }

    public Long getUdwolineid() {
        return udwolineid;
    }

    public void setUdwolineid(Long udwolineid) {
        this.udwolineid = udwolineid;
    }
}

