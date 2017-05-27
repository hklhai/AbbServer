package com.hxqh.abb.model.dto.action;

import com.hxqh.abb.model.view.AbbAsset;
import com.hxqh.abb.model.view.AbbAssetLocation;

import java.util.List;

/**
 * Created by dell on 2017-05-18.
 */
public class AssetDto {
    private List<AbbAsset> abbAssetList;
    private AbbAssetLocation abbAssetLocationList;

    public AssetDto() {
    }

    public AssetDto(List<AbbAsset> abbAssetList, AbbAssetLocation abbAssetLocationList) {
        this.abbAssetList = abbAssetList;
        this.abbAssetLocationList = abbAssetLocationList;
    }

    public List<AbbAsset> getAbbAssetList() {
        return abbAssetList;
    }

    public void setAbbAssetList(List<AbbAsset> abbAssetList) {
        this.abbAssetList = abbAssetList;
    }

    public AbbAssetLocation getAbbAssetLocationList() {
        return abbAssetLocationList;
    }

    public void setAbbAssetLocationList(AbbAssetLocation abbAssetLocationList) {
        this.abbAssetLocationList = abbAssetLocationList;
    }
}
