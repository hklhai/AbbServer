package com.hxqh.abb.controller;

import com.hxqh.abb.common.util.IConstants;
import com.hxqh.abb.model.base.SessionInfo;
import com.hxqh.abb.model.dto.action.Message;
import com.hxqh.abb.model.version2.Udbed;
import com.hxqh.abb.model.version2.Udbedapply;
import com.hxqh.abb.model.version2.Udvehicle;
import com.hxqh.abb.service.ServerStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Ocean lin on 2017/9/5.
 */
@Controller
@RequestMapping("/serverstation")
@SessionAttributes(value = "sessionInfo")
public class ServerStationController {

    @Autowired
    private ServerStationService serverStationService;


    /**
     * addUdvehicle 业务接口
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addUdvehicle", method = RequestMethod.POST)
    public Message addUdvehicle(@RequestBody Udvehicle udvehicle, @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        Message message = null;
        try {
            Long aLong = serverStationService.addUdvehicle(udvehicle, sessionInfo);
            message = new Message(IConstants.SUCCESS, IConstants.ADDSUCCESS, aLong);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.ADDFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }

    /**
     * editUdvehicle 业务接口
     * 车辆台账
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/editUdvehicle", method = RequestMethod.POST)
    public Message editUdvehicle(@RequestBody Udvehicle udvehicle, @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        Message message = null;
        try {
            serverStationService.editUdvehicle(udvehicle, sessionInfo);
            message = new Message(IConstants.SUCCESS, IConstants.EDITSUCCESS);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.EDITFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }


    /**
     * addUdbed 业务接口
     * 住宿台账
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addUdbed", method = RequestMethod.POST)
    public Message addUdbed(@RequestBody Udbed Udbed, @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        Message message = null;
        try {
            Long aLong = serverStationService.addUdbed(Udbed, sessionInfo);
            message = new Message(IConstants.SUCCESS, IConstants.ADDSUCCESS, aLong);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.ADDFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }

    /**
     * editUdbed 业务接口
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/editUdbed", method = RequestMethod.POST)
    public Message editUdbed(@RequestBody Udbed Udbed, @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        Message message = null;
        try {
            serverStationService.editUdbed(Udbed, sessionInfo);
            message = new Message(IConstants.SUCCESS, IConstants.EDITSUCCESS);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.EDITFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }

    /**
     * addUdbedapply 业务接口
     * 住宿申请添加方法
     * <p>
     * 返回
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addUdbedapply", method = RequestMethod.POST)
    public Message addUdbedapply(@RequestBody Udbedapply Udbedapply, @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {

        Message message = new Message(IConstants.OCCUPIED, IConstants.OCCUPIEDINFO);
        try {
            Long aLong = serverStationService.addUdbedapply(Udbedapply, sessionInfo);
            if (aLong == -3L)
                return message;
            message = new Message(IConstants.SUCCESS, IConstants.ADDSUCCESS);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.ADDFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }

    /**
     * editUdbedapply 业务接口
     * 住宿申请详情保存
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/editUdbedapply", method = RequestMethod.POST)
    public Message editUdbedapply(@RequestBody Udbedapply Udbedapply, @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        Message message = null;
        try {
            serverStationService.editUdbedapply(Udbedapply, sessionInfo);
            message = new Message(IConstants.SUCCESS, IConstants.EDITSUCCESS);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.EDITFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }


}
