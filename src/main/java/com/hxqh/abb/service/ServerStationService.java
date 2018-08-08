package com.hxqh.abb.service;

import com.hxqh.abb.model.base.SessionInfo;
import com.hxqh.abb.model.version2.Udbed;
import com.hxqh.abb.model.version2.Udbedapply;
import com.hxqh.abb.model.version2.Udvehicle;
import com.hxqh.abb.model.version2.Udvehicleapply;

/**
 * Created by Ocean lin on 2017/9/5.
 */
public interface ServerStationService {

    Long addUdvehicle(Udvehicle udvehicle, SessionInfo sessionInfo) throws Exception;

    void editUdvehicle(Udvehicle udvehicle, SessionInfo sessionInfo) throws Exception;

    Long addUdvehicleapply(Udvehicleapply udvehicleapply, SessionInfo sessionInfo) throws Exception;

    void editUdvehicleapply(Udvehicleapply udvehicleapply, SessionInfo sessionInfo) throws Exception;

    Long addUdbed(Udbed udbed, SessionInfo sessionInfo) throws Exception;

    void editUdbed(Udbed udbed, SessionInfo sessionInfo) throws Exception;

    Long addUdbedapply(Udbedapply udbedapply, SessionInfo sessionInfo) throws Exception;

    void editUdbedapply(Udbedapply udbedapply, SessionInfo sessionInfo) throws Exception;
}
