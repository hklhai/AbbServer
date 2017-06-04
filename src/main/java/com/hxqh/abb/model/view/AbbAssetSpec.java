package com.hxqh.abb.model.view;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the ABB_ASSET database table.
 */
@Entity
@Table(name = "ABB_ASSET_SPEC")
public class AbbAssetSpec implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private long assetspecid;
    private String assetattrid;
    private String description;
    private String measureunitid;
    private String alnvalue;
    private String classstructureid;

    public AbbAssetSpec() {
    }

    public String getClassstructureid() {
        return classstructureid;
    }

    public void setClassstructureid(String classstructureid) {
        this.classstructureid = classstructureid;
    }

    public long getAssetspecid() {
        return assetspecid;
    }

    public void setAssetspecid(long assetspecid) {
        this.assetspecid = assetspecid;
    }

    public String getAssetattrid() {
        return assetattrid;
    }

    public void setAssetattrid(String assetattrid) {
        this.assetattrid = assetattrid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMeasureunitid() {
        return measureunitid;
    }

    public void setMeasureunitid(String measureunitid) {
        this.measureunitid = measureunitid;
    }

    public String getAlnvalue() {
        return alnvalue;
    }

    public void setAlnvalue(String alnvalue) {
        this.alnvalue = alnvalue;
    }
}