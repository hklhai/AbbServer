package com.hxqh.abb.service;

import com.hxqh.abb.model.version2.Udbed;
import com.hxqh.abb.model.version2.Udbedapply;
import com.hxqh.abb.model.version2.Udvehicle;
import com.hxqh.abb.model.version2.Udvehicleapply;

/**
 * Created by Ocean lin on 2017/9/5.
 */
public interface ServerStationService {

    Long addUdvehicle(Udvehicle udvehicle);

    void editUdvehicle(Udvehicle udvehicle);

    Long addUdvehicleapply(Udvehicleapply udvehicleapply);

    void editUdvehicleapply(Udvehicleapply udvehicleapply);

    Long addUdbed(Udbed udbed);

    void editUdbed(Udbed udbed);

    Long addUdbedapply(Udbedapply udbedapply);

    void editUdbedapply(Udbedapply udbedapply);
}
