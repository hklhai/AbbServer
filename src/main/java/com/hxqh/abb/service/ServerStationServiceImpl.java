package com.hxqh.abb.service;

/**
 * Created by Ocean lin on 2017/9/5.
 */

import com.hxqh.abb.common.ObjectUtil;
import com.hxqh.abb.dao.*;
import com.hxqh.abb.model.base.SessionInfo;
import com.hxqh.abb.model.version2.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Transactional
@Service("serverStationService")
public class ServerStationServiceImpl implements ServerStationService {

    @Autowired
    private UdvehicleDao udvehicleDao;
    @Autowired
    private UdvehicleapplyDao udvehicleapplyDao;
    @Autowired
    private UdbedDao udbedDao;
    @Autowired
    private UdbedapplyDao udbedapplyDao;
    @Autowired
    private AutokeyDao autokeyDao;

    @Override
    public Long addUdvehicle(Udvehicle udvehicle, SessionInfo sessionInfo) throws Exception {
        //利用反射设置siteid、orgid、createby、changeby、createddate、changedate
        ObjectUtil.setAddBasicData(udvehicle, sessionInfo);
        udvehicleDao.save(udvehicle);
        return udvehicle.getUdvehicleid();
    }


    @Override
    public void editUdvehicle(Udvehicle udvehicle, SessionInfo sessionInfo) throws Exception {
        Udvehicle dbObject = udvehicleDao.find(udvehicle.getUdvehicleid());
        ObjectUtil.setEditBasicData(dbObject, sessionInfo);
        BeanUtils.copyProperties(udvehicle, dbObject, ObjectUtil.getNullPropertyNames(udvehicle));

        udvehicleDao.update(dbObject);
    }


    @Override
    public Long addUdvehicleapply(Udvehicleapply udvehicleapply, SessionInfo sessionInfo) throws Exception {
        // 增加判断，如果历史记录中时间段被占用则提示建议更换时间段
        List<Udvehicleapply> udvehicleapplyList = udvehicleapplyDao.findAll();

        for (Udvehicleapply vehicleapply : udvehicleapplyList) {
            if (vehicleapply.getLicense().equals(udvehicleapply.getLicense())) {
                // 判断起止时间互相交叉
                // starttime在[start,end]中或者endtime在[start,end]
                if ((vehicleapply.getEndtime().compareTo(udvehicleapply.getStarttime()) == 1 &&
                        udvehicleapply.getStarttime().compareTo(vehicleapply.getStarttime()) == 1) ||
                        (vehicleapply.getEndtime().compareTo(udvehicleapply.getEndtime()) == 1 &&
                                udvehicleapply.getEndtime().compareTo(vehicleapply.getStarttime()) == 1
                        )) {
                    return -3L;
                }
            }
        }


        ObjectUtil.setAddBasicData(udvehicleapply, sessionInfo);

        Autokey autokey = autokeyDao.find(241l);
        udvehicleapply.setApplynum(String.valueOf(autokey.getSeed() + 1l));
        autokey.setSeed(autokey.getSeed() + 1l);
        autokeyDao.update(autokey);

        // 增加申请人与申请时间
        udvehicleapply.setApplicant(sessionInfo.getLoginId());
        udvehicleapply.setApplytime(new Date());
        udvehicleapply.setStatus("WAPPR");

        udvehicleapplyDao.save(udvehicleapply);
        return udvehicleapply.getUdvehicleid();
    }

    @Override
    public void editUdvehicleapply(Udvehicleapply udvehicleapply, SessionInfo sessionInfo) throws Exception {

        Udvehicleapply dbObject = udvehicleapplyDao.find(udvehicleapply.getUdvehicleid());
        ObjectUtil.setEditBasicData(dbObject, sessionInfo);
        BeanUtils.copyProperties(udvehicleapply, dbObject, ObjectUtil.getNullPropertyNames(udvehicleapply));
        udvehicleapplyDao.update(dbObject);
    }

    @Override
    public Long addUdbed(Udbed udbed, SessionInfo sessionInfo) throws Exception {
        ObjectUtil.setAddBasicData(udbed, sessionInfo);
        udbedDao.save(udbed);

        return udbed.getUdbedid();
    }

    @Override
    public void editUdbed(Udbed udbed, SessionInfo sessionInfo) throws Exception {
        Udbed dbObject = udbedDao.find(udbed.getUdbedid());
        ObjectUtil.setEditBasicData(dbObject, sessionInfo);
        BeanUtils.copyProperties(udbed, dbObject, ObjectUtil.getNullPropertyNames(udbed));
        udbedDao.update(dbObject);
    }

    @Override
    public Long addUdbedapply(Udbedapply udbedapply, SessionInfo sessionInfo) throws Exception {
        // 增加判断，如果历史记录中时间段被占用则提示建议更换时间段
        List<Udbedapply> udbedapplyList = udbedapplyDao.findAll();

        for (Udbedapply bedApply : udbedapplyList) {
            if (bedApply.getBednum().equals(udbedapply.getBednum())) {
                // 判断起止时间互相交叉
                // starttime在[start,end]中或者endtime在[start,end]
                if ((bedApply.getEndtime().compareTo(udbedapply.getStarttime()) == 1 &&
                        udbedapply.getStarttime().compareTo(bedApply.getStarttime()) == 1) ||
                        (bedApply.getEndtime().compareTo(udbedapply.getEndtime()) == 1 &&
                                udbedapply.getEndtime().compareTo(bedApply.getStarttime()) == 1)) {
                    return -3L;
                }
            }
        }

        ObjectUtil.setAddBasicData(udbedapply, sessionInfo);

        Autokey autokey = autokeyDao.find(241l);
        udbedapply.setApplynum(String.valueOf(autokey.getSeed() + 1l));
        autokey.setSeed(autokey.getSeed() + 1l);
        autokeyDao.update(autokey);

        udbedapply.setApplicant(sessionInfo.getLoginId());
        udbedapply.setApplytime(new Date());

        udbedapplyDao.save(udbedapply);
        return udbedapply.getUdbedapplyid();
    }

    @Override
    public void editUdbedapply(Udbedapply udbedapply, SessionInfo sessionInfo) throws Exception {
        Udbedapply dbObject = udbedapplyDao.find(udbedapply.getUdbedapplyid());
        ObjectUtil.setEditBasicData(dbObject, sessionInfo);
        BeanUtils.copyProperties(udbedapply, dbObject, ObjectUtil.getNullPropertyNames(udbedapply));

        udbedapplyDao.update(dbObject);
    }

}
