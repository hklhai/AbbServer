package com.hxqh.abb.controller;

import com.hxqh.abb.common.util.IConstants;
import com.hxqh.abb.model.dto.action.Message;
import com.hxqh.abb.model.version2.Udbed;
import com.hxqh.abb.model.version2.Udbedapply;
import com.hxqh.abb.model.version2.Udvehicle;
import com.hxqh.abb.model.version2.Udvehicleapply;
import com.hxqh.abb.service.ServerStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

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
    @RequestMapping(value = "/addUdvehicle", method = RequestMethod.GET)
    public Message addUdvehicle(Udvehicle udvehicle) {
        Message message = null;
        try {
            Long aLong = serverStationService.addUdvehicle(udvehicle);
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
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/editUdvehicle", method = RequestMethod.GET)
    public Message editUdvehicle(Udvehicle udvehicle) {
        Message message = null;
        try {
            serverStationService.editUdvehicle(udvehicle);
            message = new Message(IConstants.SUCCESS, IConstants.EDITSUCCESS);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.EDITFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }


    /**
     * addUdvehicleapply 业务接口
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addUdvehicleapply", method = RequestMethod.GET)
    public Message addUdvehicleapply(Udvehicleapply Udvehicleapply) {
        Message message = null;
        try {
            Long aLong = serverStationService.addUdvehicleapply(Udvehicleapply);
            message = new Message(IConstants.SUCCESS, IConstants.ADDSUCCESS,aLong);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.ADDFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }

    /**
     * editUdvehicleapply 业务接口
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/editUdvehicleapply", method = RequestMethod.GET)
    public Message editUdvehicleapply(Udvehicleapply Udvehicleapply) {
        Message message = null;
        try {
            serverStationService.editUdvehicleapply(Udvehicleapply);
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
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addUdbed", method = RequestMethod.GET)
    public Message addUdbed(Udbed Udbed) {
        Message message = null;
        try {
            Long aLong = serverStationService.addUdbed(Udbed);
            message = new Message(IConstants.SUCCESS, IConstants.ADDSUCCESS,aLong);
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
    @RequestMapping(value = "/editUdbed", method = RequestMethod.GET)
    public Message editUdbed(Udbed Udbed) {
        Message message = null;
        try {
            serverStationService.editUdbed(Udbed);
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
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addUdbedapply", method = RequestMethod.GET)
    public Message addUdbedapply(Udbedapply Udbedapply) {
        Message message = null;
        try {
            serverStationService.addUdbedapply(Udbedapply);
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
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/editUdbedapply", method = RequestMethod.GET)
    public Message editUdbedapply(Udbedapply Udbedapply) {
        Message message = null;
        try {
            serverStationService.editUdbedapply(Udbedapply);
            message = new Message(IConstants.SUCCESS, IConstants.EDITSUCCESS);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.EDITFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }



}
