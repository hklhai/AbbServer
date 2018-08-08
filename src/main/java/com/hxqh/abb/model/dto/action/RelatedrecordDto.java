package com.hxqh.abb.model.dto.action;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Ocean lin on 2017/9/11.
 */
@Entity
public class RelatedrecordDto {

    @Id
    private Long relatedrecordid;
    private String relatedrecwonum;
    private String workorderdescription;
    private String assetnum;
    private String assetdescription;
    private String location;
    private String status;
    private String locationsdescription;

    public RelatedrecordDto() {
    }

    public Long getRelatedrecordid() {
        return relatedrecordid;
    }

    public void setRelatedrecordid(Long relatedrecordid) {
        this.relatedrecordid = relatedrecordid;
    }

    public String getRelatedrecwonum() {
        return relatedrecwonum;
    }

    public void setRelatedrecwonum(String relatedrecwonum) {
        this.relatedrecwonum = relatedrecwonum;
    }

    public String getWorkorderdescription() {
        return workorderdescription;
    }

    public void setWorkorderdescription(String workorderdescription) {
        this.workorderdescription = workorderdescription;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocationsdescription() {
        return locationsdescription;
    }

    public void setLocationsdescription(String locationsdescription) {
        this.locationsdescription = locationsdescription;
    }
}
