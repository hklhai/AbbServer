package com.hxqh.abb.model.dto.action;

import com.hxqh.abb.model.view.AbbLocation;

import java.util.List;

/**
 * Created by Ocean Lin on 2017/5/29.
 */
public class CityDto {


    private List<AbbLocation> childLocation;
    private AbbLocation abbLocation;

    public CityDto() {
    }

    public CityDto(List<AbbLocation> childLocation, AbbLocation abbLocation) {
        this.childLocation = childLocation;
        this.abbLocation = abbLocation;
    }

    public List<AbbLocation> getChildLocation() {
        return childLocation;
    }

    public void setChildLocation(List<AbbLocation> childLocation) {
        this.childLocation = childLocation;
    }

    public AbbLocation getAbbLocation() {
        return abbLocation;
    }

    public void setAbbLocation(AbbLocation abbLocation) {
        this.abbLocation = abbLocation;
    }
}
