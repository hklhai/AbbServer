package com.hxqh.abb.controller;

import com.hxqh.abb.common.util.IConstants;
import com.hxqh.abb.common.util.TimeUtil;
import com.hxqh.abb.model.assist.Time;
import com.hxqh.abb.model.base.SessionInfo;
import com.hxqh.abb.model.dto.action.InventoryDto;
import com.hxqh.abb.model.dto.action.Message;
import com.hxqh.abb.model.searchdto.InventorySearchDto;
import com.hxqh.abb.model.searchdto.Page;
import com.hxqh.abb.model.version2.Invuse;
import com.hxqh.abb.model.version2.Po;
import com.hxqh.abb.model.version2.Udinvcheck;
import com.hxqh.abb.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * Created by lh on 2017/5/11.
 */
@Controller
@RequestMapping("/inventory")
@SessionAttributes(value = "sessionInfo")
public class InventoryController {

    @Autowired
    private LocationService locationService;

    /*****************************************一期*****************************************/

    /**
     * 库存管理页面跳转
     * 2017-5-11
     *
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list() {
        return "inventory/inventory";
    }

    /**
     * 地图页面数据接口  获取数据与分类列表信息
     * 2017-5-10
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/inventoryData", method = RequestMethod.POST)
    public InventoryDto inventoryListData(Page page, @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        InventoryDto inventoryData = null;

        try {
            inventoryData = locationService.inventoryListData(page);
        } catch (Exception e) {
            e.printStackTrace();
        }
        inventoryData.setSessionInfo(sessionInfo);
        inventoryData.setTime(new Time(TimeUtil.getTime()));
        return inventoryData;
    }


    /**
     * 库存页面数据接口  获取数据包含分页
     * 2017-5-15
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/data", method = RequestMethod.POST)
    public InventoryDto data(InventorySearchDto inventorySearchDto, Page page) {
        InventoryDto inventoryData = locationService.getInventoryData(inventorySearchDto, page);
        return inventoryData;
    }
    /*****************************************一期*****************************************/


    /**
     * addInvuse 业务接口
     * 物资发放、备件调拨、物资退库  新增功能公用
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addInvuse", method = RequestMethod.POST)
    public Message addInvuse(@RequestBody Invuse invuse, @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        Message message = null;
        try {
            Long aLong = locationService.addInvuse(invuse, sessionInfo);
            message = new Message(IConstants.SUCCESS, IConstants.ADDSUCCESS, aLong);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.ADDFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }

    /**
     * editInvuse 业务接口
     * 物资发放、备件调拨、物资退库 编辑功能公用
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/editInvuse", method = RequestMethod.POST)
    public Message editInvuse(@RequestBody Invuse invuse, @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        Message message = null;
        try {
            locationService.editInvuse(invuse, sessionInfo);
            message = new Message(IConstants.SUCCESS, IConstants.EDITSUCCESS);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.ADDFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }


    /**
     * addUdinvcheck 业务接口
     * 库存盘点
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addUdinvcheck", method = RequestMethod.POST)
    public Message addUdinvcheck(@RequestBody Udinvcheck udinvcheck, @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        Message message = null;
        try {
            Long aLong = locationService.addUdinvcheck(udinvcheck, sessionInfo);
            message = new Message(IConstants.SUCCESS, IConstants.ADDSUCCESS, aLong);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.ADDFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }

    /**
     * editUdinvcheck 业务接口
     * 库存盘点
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/editUdinvcheck", method = RequestMethod.POST)
    public Message editUdinvcheck(@RequestBody Udinvcheck udinvcheck, @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        Message message = null;
        try {
            locationService.editUdinvcheck(udinvcheck, sessionInfo);
            message = new Message(IConstants.SUCCESS, IConstants.ADDSUCCESS);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.ADDFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }


    /**
     * addPo  业务接口
     * 采购清单、旧料回收、废料回收   功能公用
     * Po 中UDAPPTYPEDNAME取值（旧料回收单，废料回收单，采购清单）
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addPo", method = RequestMethod.POST)
    public Message addPo(@RequestBody Po po, @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        Message message = null;
        try {
            Long aLong = locationService.addPo(po, sessionInfo);
            message = new Message(IConstants.SUCCESS, IConstants.ADDSUCCESS, aLong);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.ADDFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }

    /**
     * editPo  业务接口
     * 采购清单、旧料回收、废料回收   功能公用
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/editPo", method = RequestMethod.POST)
    public Message editPo(@RequestBody Po po, @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        Message message = null;
        try {
            locationService.editPo(po, sessionInfo);
            message = new Message(IConstants.SUCCESS, IConstants.ADDSUCCESS);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.ADDFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }


    /**
     * addPoreceive 业务接口
     * 接收
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addPoreceive", method = RequestMethod.POST)
    public Message addPoreceive(@RequestBody Po po, @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        Message message = null;
        try {
            Long aLong = locationService.addPoreceive(po, sessionInfo);
            message = new Message(IConstants.SUCCESS, IConstants.ADDSUCCESS, aLong);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.ADDFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }


    /**
     * editPoreceive 业务接口
     * 接收
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/editPoreceive", method = RequestMethod.POST)
    public Message editPoreceive(@RequestBody Po po, @ModelAttribute("sessionInfo") SessionInfo sessionInfo) {
        Message message = null;
        try {
            locationService.editPoreceive(po, sessionInfo);
            message = new Message(IConstants.SUCCESS, IConstants.ADDSUCCESS);
        } catch (Exception e) {
            message = new Message(IConstants.FAIL, IConstants.ADDFAIL);
            e.printStackTrace();
        } finally {
            return message;
        }
    }


}
