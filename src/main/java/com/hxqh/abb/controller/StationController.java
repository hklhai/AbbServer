package com.hxqh.abb.controller;

import com.hxqh.abb.common.util.IConstants;
import com.hxqh.abb.model.base.SessionInfo;
import com.hxqh.abb.model.dto.action.Message;
import com.hxqh.abb.model.version2.Udvehicleapply;
import com.hxqh.abb.service.ServerStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Ocean lin on 2017/9/14.
 * 本类建立原因：UDVEHICLE、UDVEHICLEAPPLY两张表主键均为UDVEHICLEID
 * 呵呵
 */
@Controller
@RequestMapping("/station")
@SessionAttributes(value = "sessionInfo")
public class StationController {
    @Autowired
    private ServerStationService serverStationService;


    /**
     * addUdvehicleapply 业务接口
     * 车辆申请
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addUdvehicleapply", method = RequestMethod.POST)
    public Message addUdvehicleapply(@RequestBody Udvehicleapply Udvehicleapply, @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        Message message = new Message(IConstants.OCCUPIED, IConstants.OCCUPIEDINFO);
        try {
            Long aLong = serverStationService.addUdvehicleapply(Udvehicleapply, sessionInfo);
            if (aLong == -3L)
                return message;
            message = new Message(IConstants.SUCCESS, IConstants.ADDSUCCESS, aLong);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.ADDFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }


    /**
     * editUdvehicleapply 业务接口
     * 车辆申请的详情保存
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/editUdvehicleapply", method = RequestMethod.POST)
    public Message editUdvehicleapply(@RequestBody Udvehicleapply udvehicleapply, @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        Message message = null;
        try {
            serverStationService.editUdvehicleapply(udvehicleapply, sessionInfo);
            message = new Message(IConstants.SUCCESS, IConstants.EDITSUCCESS);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.EDITFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }


}
