package com.hxqh.abb.controller;

import com.hxqh.abb.common.util.IConstants;
import com.hxqh.abb.model.base.SessionInfo;
import com.hxqh.abb.model.dto.action.ListDto;
import com.hxqh.abb.model.dto.action.Message;
import com.hxqh.abb.model.paperless.*;
import com.hxqh.abb.model.searchdto.Page;
import com.hxqh.abb.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author fuyg
 * @date 2017-09-26.
 */
@Controller
@RequestMapping("/project")
@SessionAttributes(value = "sessionInfo")
public class ProjectController {

    @Autowired
    private ProjectService projectService;


    /**
     * List公用数据接口
     * 点击进入列表
     *
     * @param apptname
     * @param searchs
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectionListData", method = RequestMethod.POST)
    public ListDto data(Page page,
                        @RequestParam("apptname") String apptname,
                        @RequestParam("searchs") String searchs,
                        @ModelAttribute("sessionInfo") SessionInfo sessionInfo,
                        @RequestParam(name = "whereStr") String whereStr) {
        ListDto listData = null;
        try {
            listData = projectService.selectionListData(page, apptname, searchs, sessionInfo, whereStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        listData.setApptname(apptname);
        return listData;
    }

    /**
     * addUdproject 业务接口
     * 项目管理：新增项目
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addUdproject", method = RequestMethod.POST)
    public Message addUdproject(@RequestBody Udproject udproject, @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        Message message = null;
        try {
            Long aLong = projectService.addUdproject(udproject,sessionInfo);
            message = new Message(IConstants.SUCCESS, IConstants.ADDSUCCESS, aLong);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.ADDFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }

    /**
     * editUdproject 业务接口
     * 项目管理：编辑项目
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/editUdproject", method = RequestMethod.POST)
    public Message editUdproject(@RequestBody Udproject udproject, @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        Message message = null;
        try {
            projectService.editUdproject(udproject, sessionInfo);
            message = new Message(IConstants.SUCCESS, IConstants.EDITSUCCESS);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.ADDFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }

    /**
     * addSingledelegate 业务接口
     * 委派单：新增项目
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addUddelegate", method = RequestMethod.POST)
    public Message addUddelegate(@RequestBody Uddelegate uddelegate, @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        Message message = null;
        try {
            Long aLong = projectService.addUddelegate(uddelegate,sessionInfo);
            message = new Message(IConstants.SUCCESS, IConstants.ADDSUCCESS, aLong);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.ADDFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }

    /**
     * editSingledelegate 业务接口
     * 接收
     * 委派单编辑保存
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/editUddelegate", method = RequestMethod.POST)
    public Message editUddelegate(@RequestBody Uddelegate uddelegate, @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        Message message = null;
        try {
            projectService.editUddelegate(uddelegate, sessionInfo);
            message = new Message(IConstants.SUCCESS, IConstants.ADDSUCCESS);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.ADDFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }

    /**
     * addSceneservicenotify 业务接口
     * 项目管理：新增现场服务通知
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addUdsceneservicenotify", method = RequestMethod.POST)
    public Message addSceneservicenotify(@RequestBody Udsceneservicenotify udsceneservicenotify, @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        Message message = null;
        try {
            Long aLong = projectService.addUdsceneservicenotify(udsceneservicenotify,sessionInfo);
            message = new Message(IConstants.SUCCESS, IConstants.ADDSUCCESS, aLong);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.ADDFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }

    /**
     * editUdproject 业务接口
     * 项目管理：编辑现场服务通知
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/editUdsceneservicenotify", method = RequestMethod.POST)
    public Message editSceneservicenotify(@RequestBody Udsceneservicenotify udsceneservicenotify, @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        Message message = null;
        try {
            projectService.editUdsceneservicenotify(udsceneservicenotify, sessionInfo);
            message = new Message(IConstants.SUCCESS, IConstants.EDITSUCCESS);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.ADDFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }

    /**
     * addSingleprojectinfo 业务接口
     * 现场服务联络函：新增项目
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addProjectinfo", method = RequestMethod.POST)
    public Message addSingleprojectinfo(@RequestBody Projectinfo projectinfo, @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        Message message = null;
        try {
            Long aLong = projectService.addProjectinfo(projectinfo,sessionInfo);
            message = new Message(IConstants.SUCCESS, IConstants.ADDSUCCESS, aLong);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.ADDFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }

    /**
     * editSingleprojectinfo 业务接口
     * 接收
     * 现场服务联络函编辑保存
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/editProjectinfo", method = RequestMethod.POST)
    public Message editSingleprojectinfo(@RequestBody Projectinfo projectinfo, @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        Message message = null;
        try {
            projectService.editProjectinfo(projectinfo, sessionInfo);
            message = new Message(IConstants.SUCCESS, IConstants.ADDSUCCESS);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.ADDFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }

    /**
     * addSingleudpermission 业务接口
     * 项目现场服务安全工作许可单：新增项目
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addUdpermission", method = RequestMethod.POST)
    public Message addUdpermission(@RequestBody Udpermission udpermission, @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        Message message = null;
        try {
            Long aLong = projectService.addUdpermission(udpermission,sessionInfo);
            message = new Message(IConstants.SUCCESS, IConstants.ADDSUCCESS, aLong);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.ADDFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }

    /**
     * editSingleudpermission 业务接口
     * 接收
     * 项目现场服务安全工作许可单
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/editUdpermission", method = RequestMethod.POST)
    public Message editUdpermission(@RequestBody Udpermission udpermission, @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        Message message = null;
        try {
            projectService.editUdpermission(udpermission, sessionInfo);
            message = new Message(IConstants.SUCCESS, IConstants.ADDSUCCESS);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.ADDFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }

    /**
     * addOutboxcheck 业务接口
     * 设备开箱检验
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addUdoutboxcheck", method = RequestMethod.POST)
    public Message addUdoutboxcheck(@RequestBody Udoutboxcheck udoutboxcheck, @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        Message message = null;
        try {
            Long aLong = projectService.addUdoutboxcheck(udoutboxcheck,sessionInfo);
            message = new Message(IConstants.SUCCESS, IConstants.ADDSUCCESS, aLong);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.ADDFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }

    /**
     * editOutboxcheck 业务接口
     *
     * 设备开箱检验
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/editUdoutboxcheck", method = RequestMethod.POST)
    public Message editUdoutboxcheck(@RequestBody Udoutboxcheck udoutboxcheck, @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        Message message = null;
        try {
            projectService.editUdoutboxcheck(udoutboxcheck, sessionInfo);
            message = new Message(IConstants.SUCCESS, IConstants.ADDSUCCESS);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.ADDFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }

    /**
     * addSingleudsafechecktable2 业务接口
     * 现场服务安全检查：新增项目
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addUdsafechecktable2", method = RequestMethod.POST)
    public Message addUdsafechecktable2(@RequestBody Udsafechecktable2 udsafechecktable2, @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        Message message = null;
        try {
            Long aLong = projectService.addUdsafechecktable2(udsafechecktable2,sessionInfo);
            message = new Message(IConstants.SUCCESS, IConstants.ADDSUCCESS, aLong);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.ADDFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }

    /**
     * editSingleudsafechecktable2 业务接口
     * 现场服务安全检查：编辑项目
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/editUdsafechecktable2", method = RequestMethod.POST)
    public Message editUdsafechecktable2(@RequestBody Udsafechecktable2 udsafechecktable2, @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        Message message = null;
        try {
            projectService.editUdsafechecktable2(udsafechecktable2, sessionInfo);
            message = new Message(IConstants.SUCCESS, IConstants.ADDSUCCESS);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.ADDFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }

    /**
     * addTrainrecord 业务接口
     * 现场培训记录
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addUdtrainrecord", method = RequestMethod.POST)
    public Message addUdtrainrecord(@RequestBody Udtrainrecord udtrainrecord, @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        Message message = null;
        try {
            Long aLong = projectService.addUdtrainrecord(udtrainrecord,sessionInfo);
            message = new Message(IConstants.SUCCESS, IConstants.ADDSUCCESS, aLong);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.ADDFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }

    /**
     * editTrainrecord 业务接口
     *
     * 现场培训记录
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/editUdtrainrecord", method = RequestMethod.POST)
    public Message editUdtrainrecord(@RequestBody Udtrainrecord udtrainrecord, @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        Message message = null;
        try {
            projectService.editUdtrainrecord(udtrainrecord, sessionInfo);
            message = new Message(IConstants.SUCCESS, IConstants.ADDSUCCESS);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.ADDFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }

    /**
     * addSingleudentrustout 业务接口
     * 现场设备委托开箱：新增项目
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addUdentrustout", method = RequestMethod.POST)
    public Message addUdentrustout(@RequestBody Udentrustout udentrustout, @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        Message message = null;
        try {
            Long aLong = projectService.addUdentrustout(udentrustout,sessionInfo);
            message = new Message(IConstants.SUCCESS, IConstants.ADDSUCCESS, aLong);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.ADDFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }

    /**
     * editSingleudentrustout 业务接口
     * 现场设备委托开箱：编辑项目
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/editUdentrustout", method = RequestMethod.POST)
    public Message editUdentrustout(@RequestBody Udentrustout udentrustout, @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        Message message = null;
        try {
            projectService.editUdentrustout(udentrustout, sessionInfo);
            message = new Message(IConstants.SUCCESS, IConstants.ADDSUCCESS);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.ADDFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }

    /**
     * addNowcheck 业务接口
     * 设备安装/调试/送电现场检查
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addUdnowcheck", method = RequestMethod.POST)
    public Message addUdnowcheck(@RequestBody Udnowcheck udnowcheck, @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        Message message = null;
        try {
            Long aLong = projectService.addUdnowcheck(udnowcheck,sessionInfo);
            message = new Message(IConstants.SUCCESS, IConstants.ADDSUCCESS, aLong);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.ADDFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }

    /**
     * editNowcheck 业务接口
     *
     * 设备安装/调试/送电现场检查
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/editUdnowcheck", method = RequestMethod.POST)
    public Message editUdnowcheck(@RequestBody Udnowcheck udnowcheck, @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        Message message = null;
        try {
            projectService.editUdnowcheck(udnowcheck, sessionInfo);
            message = new Message(IConstants.SUCCESS, IConstants.ADDSUCCESS);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.ADDFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }

    /**
     * addProblemmodify 业务接口
     * 现场问题整改通知书
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addUdproblemmodify", method = RequestMethod.POST)
    public Message addUdproblemModify(@RequestBody Udproblemmodify udproblemmodify, @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        Message message = null;
        try {
            Long aLong = projectService.addUdproblemmodify(udproblemmodify,sessionInfo);
            message = new Message(IConstants.SUCCESS, IConstants.ADDSUCCESS, aLong);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.ADDFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }

    /**
     * editProblemmodify 业务接口
     *
     * 现场问题整改通知书
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/editUdproblemmodify", method = RequestMethod.POST)
    public Message editUdproblemModify(@RequestBody Udproblemmodify udproblemmodify, @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        Message message = null;
        try {
            projectService.editUdproblemmodify(udproblemmodify, sessionInfo);
            message = new Message(IConstants.SUCCESS, IConstants.ADDSUCCESS);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.ADDFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }

    /**
     * addAreaandservice 业务接口
     * 区域和服务中心经理管理
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addAreaandservice", method = RequestMethod.POST)
    public Message addAreaandservice(@RequestBody Areaandservice areaandservice, @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        Message message = null;
        try {
            Long aLong = projectService.addAreaandservice(areaandservice,sessionInfo);
            message = new Message(IConstants.SUCCESS, IConstants.ADDSUCCESS, aLong);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.ADDFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }

    /**
     * editAreaandservice 业务接口
     *
     * 区域和服务中心经理管理
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/editAreaandservice", method = RequestMethod.POST)
    public Message editAreaandservice(@RequestBody Areaandservice areaandservice, @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        Message message = null;
        try {
            projectService.editAreaandservice(areaandservice, sessionInfo);
            message = new Message(IConstants.SUCCESS, IConstants.ADDSUCCESS);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.ADDFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }

    /**
     * addSafecheck 业务接口
     * 项目安全计划(维保改造)
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addUdsafecheck", method = RequestMethod.POST)
    public Message addUdsafecheck(@RequestBody Udsafecheck udsafecheck, @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        Message message = null;
        try {
            Long aLong = projectService.addUdsafecheck(udsafecheck,sessionInfo);
            message = new Message(IConstants.SUCCESS, IConstants.ADDSUCCESS, aLong);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.ADDFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }

    /**
     * editSafecheck 业务接口
     *
     * 项目安全计划(维保改造)
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/editUdsafecheck", method = RequestMethod.POST)
    public Message editUdsafecheck(@RequestBody Udsafecheck udsafecheck, @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        Message message = null;
        try {
            projectService.editUdsafecheck(udsafecheck, sessionInfo);
            message = new Message(IConstants.SUCCESS, IConstants.ADDSUCCESS);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.ADDFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }

    /**
     * addWorkreport 业务接口
     * 工作报告
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addUdworkreport", method = RequestMethod.POST)
    public Message addUdworkreport(@RequestBody Udworkreport udworkreport, @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        Message message = null;
        try {
            Long aLong = projectService.addUdworkreport(udworkreport,sessionInfo);
            message = new Message(IConstants.SUCCESS, IConstants.ADDSUCCESS, aLong);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.ADDFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }

    /**
     * editWorkreport 业务接口
     *
     * 工作报告
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/editUdworkreport", method = RequestMethod.POST)
    public Message editUdworkreport(@RequestBody Udworkreport udworkreport, @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        Message message = null;
        try {
            projectService.editUdworkreport(udworkreport, sessionInfo);
            message = new Message(IConstants.SUCCESS, IConstants.ADDSUCCESS);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.ADDFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }

    /**
     * getCheckItems 业务接口
     *
     * 项目安全计划 - 获取检查项
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getCheckItems", method = RequestMethod.POST)
    public Message getCheckItems(@RequestParam("udsafecheckid") String udsafecheckid,
                                         @RequestParam("type") String type,
                                         @ModelAttribute("sessionInfo") SessionInfo sessionInfo){
        Message message = null;
        try {
            projectService.getCheckItems(udsafecheckid, type, sessionInfo);
            message = new Message(IConstants.SUCCESS, "Get the check item Success!");
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, "Get the check item Fail!");
            e.printStackTrace();
        } finally {
            return message;
        }
    }

    /**
     * getEquipments 业务接口
     *
     * 工作报告 - 根据项目号和行号及siteid获取柜号（设备号）
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getEquipments", method = RequestMethod.POST)
    public List<Udequipment> getEquipments(@RequestParam("pronum") String pronum,
                                 @RequestParam("linenum") String linenum,
                                 @RequestParam("siteid") String siteid,
                                 @ModelAttribute("sessionInfo") SessionInfo sessionInfo){
        List<Udequipment> equipmentList = null;
        try {
            equipmentList = projectService.getEquipments(pronum,linenum,siteid,sessionInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return equipmentList;
        }
        return equipmentList;
    }
}
