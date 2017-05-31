package com.hxqh.abb.model.view;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ABB_INDEX_ASSET database table.
 */
@Entity
@Table(name = "ABB_INDEX_ASSET")
public class AbbIndexAsset implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private long assetuid;

    private String description;

    @Column(name = "\"LOCATION\"")
    private String location;

    private String siteid;

    @Column(name = "\"STATE\"")
    private String state;

    private String locdesc;

    public AbbIndexAsset() {
    }

    public long getAssetuid() {
        return assetuid;
    }

    public void setAssetuid(long assetuid) {
        this.assetuid = assetuid;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSiteid() {
        return this.siteid;
    }

    public void setSiteid(String siteid) {
        this.siteid = siteid;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLocdesc() {
        return locdesc;
    }

    public void setLocdesc(String locdesc) {
        this.locdesc = locdesc;
    }
}