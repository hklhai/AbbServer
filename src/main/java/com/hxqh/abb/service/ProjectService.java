package com.hxqh.abb.service;

import com.hxqh.abb.model.dto.action.ListDto;
import com.hxqh.abb.model.paperless.*;
import com.hxqh.abb.model.searchdto.Page;
import com.hxqh.abb.model.base.SessionInfo;

import java.util.List;

/**
 * @author fuyg
 * @date 2017-09-26.
 */
public interface ProjectService {

    ListDto selectionListData(Page page, String apptname, String searchs, SessionInfo loginId, String whereStr) throws Exception;

    Long addUdproject(Udproject udproject, SessionInfo sessionInfo) throws Exception;

    void editUdproject(Udproject udproject, SessionInfo sessionInfo) throws Exception;

    Long addUddelegate(Uddelegate uddelegate, SessionInfo sessionInfo) throws Exception;

    void editUddelegate(Uddelegate uddelegate, SessionInfo sessionInfo) throws Exception;

    Long addProjectinfo(Projectinfo projectinfo, SessionInfo sessionInfo) throws Exception;

    void editProjectinfo(Projectinfo projectinfo, SessionInfo sessionInfo) throws Exception;

    Long addUdsceneservicenotify(Udsceneservicenotify udsceneservicenotify, SessionInfo sessionInfo) throws Exception;

    void editUdsceneservicenotify(Udsceneservicenotify udsceneservicenotify, SessionInfo sessionInfo) throws Exception;

    Long addUdpermission(Udpermission udpermission, SessionInfo sessionInfo) throws Exception;

    void editUdpermission(Udpermission udpermission, SessionInfo sessionInfo) throws Exception;

    Long addUdoutboxcheck(Udoutboxcheck udoutboxcheck, SessionInfo sessionInfo) throws Exception;

    void editUdoutboxcheck(Udoutboxcheck udoutboxcheck, SessionInfo sessionInfo) throws Exception;

    Long addUdsafechecktable2(Udsafechecktable2 udsafechecktable2, SessionInfo sessionInfo) throws Exception;

    void editUdsafechecktable2(Udsafechecktable2 udsafechecktable2, SessionInfo sessionInfo) throws Exception;

    Long addUdtrainrecord(Udtrainrecord udtrainrecord, SessionInfo sessionInfo) throws Exception;

    void editUdtrainrecord(Udtrainrecord udtrainrecord, SessionInfo sessionInfo) throws Exception;

    Long addUdentrustout(Udentrustout udentrustout, SessionInfo sessionInfo) throws Exception;

    void editUdentrustout(Udentrustout udentrustout, SessionInfo sessionInfo) throws Exception;

    Long addUdnowcheck(Udnowcheck udnowcheck, SessionInfo sessionInfo) throws Exception;

    void editUdnowcheck(Udnowcheck udnowcheck, SessionInfo sessionInfo) throws Exception;

    Long addUdproblemmodify(Udproblemmodify udproblemmodify, SessionInfo sessionInfo) throws Exception;

    void editUdproblemmodify(Udproblemmodify udproblemmodify, SessionInfo sessionInfo) throws Exception;

    Long addAreaandservice(Areaandservice areaandservice, SessionInfo sessionInfo) throws Exception;

    void editAreaandservice(Areaandservice areaandservice, SessionInfo sessionInfo) throws Exception;

    Long addUdsafecheck(Udsafecheck udsafecheck, SessionInfo sessionInfo) throws Exception;

    void editUdsafecheck(Udsafecheck udsafecheck, SessionInfo sessionInfo) throws Exception;

    Long addUdworkreport(Udworkreport udworkreport, SessionInfo sessionInfo) throws Exception;

    void editUdworkreport(Udworkreport udworkreport, SessionInfo sessionInfo) throws Exception;

    void getCheckItems(String udsafecheckid, String type, SessionInfo sessionInfo) throws Exception;

    List<Udequipment> getEquipments(String pronum, String linenum, String siteid, SessionInfo sessionInfo) throws Exception;
}
