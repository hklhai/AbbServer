package com.hxqh.abb.service;

import com.hxqh.abb.common.ObjectUtil;
import com.hxqh.abb.dao.*;
import com.hxqh.abb.model.Workorder;
import com.hxqh.abb.model.base.SessionInfo;
import com.hxqh.abb.model.version2.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Ocean lin on 2017/9/5.
 */

@Transactional
@Service("executiveService")
public class ExecutiveServiceImpl implements ExecutiveService {
    @Autowired
    private WorkorderDao workorderDao;
    @Autowired
    private UdwolineDao udwolineDao;
    @Autowired
    private UdwoqualificationDao udwoqualificationDao;
    @Autowired
    private WplaborDao wplaborDao;
    @Autowired
    private LabtranDao labtranDao;
    @Autowired
    private MatusetranDao matusetranDao;
    @Autowired
    private FailurereportDao failurereportDao;
    @Autowired
    private RelatedrecordDao relatedrecordDao;
    @Autowired
    private AutokeyDao autokeyDao;


    @Override
    public Long addWorkOrder(Workorder workorder, SessionInfo sessionInfo) throws Exception {

        if (workorder.getMaintab().equals("main")) {
            ObjectUtil.setAddBasicData(workorder, sessionInfo);


            Autokey autokey = autokeyDao.find(209l);
            workorder.setWonum(String.valueOf(autokey.getSeed() + 1l));
            autokey.setSeed(autokey.getSeed() + 1l);
            autokeyDao.update(autokey);

            workorderDao.save(workorder);
            return workorder.getWorkorderid();
        } else {
            Workorder dbObject = workorderDao.find(workorder.getWorkorderid());
            ObjectUtil.setEditBasicData(dbObject, sessionInfo);
            BeanUtils.copyProperties(workorder, dbObject, ObjectUtil.getNullPropertyNames(workorder));
            workorderDao.merge(dbObject);

            //设备信息
            if (workorder.getUdwolineList().size() > 0) {
                for (Udwoline udwoline : workorder.getUdwolineList()) {
                    ObjectUtil.setAddBasicData(udwoline, sessionInfo);

                    //wonum=:wonum and siteid=:siteid
                    udwoline.setWonum(workorder.getWonum());
                    udwoline.setSiteid(workorder.getSiteid());
                    udwolineDao.save(udwoline);
                }
            }
            //资质
            if (workorder.getUdwoqualificationList().size() > 0) {
                for (Udwoqualification udwoqualification : workorder.getUdwoqualificationList()) {
                    ObjectUtil.setAddBasicData(udwoqualification, sessionInfo);

                    //wonum=:wonum and siteid=:siteid
                    udwoqualification.setWonum(workorder.getWonum());
                    udwoqualification.setSiteid(workorder.getSiteid());
                    udwoqualificationDao.save(udwoqualification);
                }
            }

            /**************************************计划标签页信息******************************************/
            // TODO: 2017/11/2 视图是否要有关联
            //其中 WOACTIVITY  WPMATERIAL  为视图

            // WPLABOR
            if (workorder.getWplaborList().size() > 0) {
                for (Wplabor wplabor : workorder.getWplaborList()) {
                    ObjectUtil.setAddBasicData(wplabor, sessionInfo);
                    //wonum in (select wonum from workorder where (wonum=:wonum or (parent=:wonum and istask = :yes)) and siteid=:siteid )
                    wplabor.setWonum(workorder.getWonum());
                    wplabor.setSiteid(workorder.getSiteid());
                    wplabor.setRate(0.0);
                    wplabor.setApptrequired(0);
                    wplabor.setRatehaschanged(0);

                    Autokey autokey = autokeyDao.find(232l);
                    wplabor.setWplaborid(String.valueOf(autokey.getSeed() + 1l));
                    autokey.setSeed(autokey.getSeed() + 1l);
                    autokeyDao.update(autokey);

                    wplaborDao.save(wplabor);
                }
            }

            /**************************************计划标签页信息******************************************/

            /**************************************执行报告标签页******************************************/
            //其中 WOACTIVITY  为视图
            //执行报告标签页 LABTRANS
            if (workorder.getLabtranList().size() > 0) {
                for (Labtran labtran : workorder.getLabtranList()) {
                    //refwo in (select wonum from workorder where (wonum=:wonum or (parent=:wonum and istask = :yes)) and siteid=:siteid )
                    labtran.setRefwo(workorder.getWonum());
                    labtran.setSiteid(workorder.getSiteid());

                    labtran.setEnteredastask(0);
                    labtran.setGenapprservreceipt(0);
                    labtran.setRollup(0);
                    labtran.setLinecost(new BigDecimal(0.0));
                    labtran.setOutside(0);
                    labtran.setTranstype("WORK");
                    // TODO: 2017/11/27 业务逻辑存在问题
                    labtran.setStartdate(new Date());
                    labtran.setEnterdate(new Date());
                    labtran.setPayrate(new BigDecimal(0.0));
                    labtran.setCraft("TEST");
                    labtran.setTransdate(new Date());
                    labtran.setEnterby(sessionInfo.getLoginId());

                    labtranDao.save(labtran);
                }
            }

            //执行报告标签页 MATUSETRANS
            if (workorder.getMatusetranList().size() > 0) {
                for (Matusetran matusetran : workorder.getMatusetranList()) {
                    //refwo in (select wonum from workorder where (wonum=:wonum or (parent=:wonum and istask = :yes)) and siteid=:siteid )
                    matusetran.setRefwo(workorder.getWonum());
                    matusetran.setSiteid(workorder.getSiteid());
                    matusetranDao.save(matusetran);
                }
            }

            /**************************************执行报告标签页******************************************/

            //故障报告标签页
            if (workorder.getFailurereportList().size() > 0) {
                for (Failurereport failurereport : workorder.getFailurereportList()) {
                    //wonum = :wonum and siteid=:siteid
                    failurereport.setWonum(workorder.getWonum());
                    failurereport.setSiteid(workorder.getSiteid());
                    failurereportDao.save(failurereport);
                }
            }

            //关联工单标签页  RELATEDRECORD
            // siteid = :siteid and recordkey=:wonum and class =:woclass and relatedrecclass in
            // (select value from synonymdomain where domainid ='WOCLASS' and maxvalue in ('CHANGE', 'RELEASE','ACTIVITY', 'WORKORDER'))
            if (workorder.getRelatedrecordList().size() > 0) {
                for (Relatedrecord relatedrecord : workorder.getRelatedrecordList()) {
                    relatedrecord.setSiteid(workorder.getSiteid());
                    relatedrecord.setRecordkey(workorder.getWonum());
                    relatedrecordDao.save(relatedrecord);
                }
            }
            return workorder.getWorkorderid();
        }


    }

    @Override
    public Long editWorkOrder(Workorder workorder, SessionInfo sessionInfo) throws Exception {
        Workorder dbObject = workorderDao.find(workorder.getWorkorderid());
//        if (!dbObject.getCreateby().equals(sessionInfo.getCreate())) {
//            return -2L;
//        }

        BeanUtils.copyProperties(workorder, dbObject, ObjectUtil.getNullPropertyNames(workorder));
        ObjectUtil.setEditBasicData(dbObject, sessionInfo);

        workorderDao.merge(dbObject);

        //删除   UDWOLINE:1,2,3,4 FAILUREREPORT:23,44
        //UDWOLINE、UDWOQUALIFICATION、WPLABOR、LABTRANS
        //MATUSETRANS、FAILUREREPORT、RELATEDRECORD
        if (null != workorder.getDeletes() && !workorder.getDeletes().equals("")) {
            String[] appDeletes = workorder.getDeletes().split(" ");
            for (int i = 0; i < appDeletes.length; i++) {
                if (appDeletes[i].split(":")[0].equals("UDWOLINE")) {
                    String[] split = appDeletes[i].split(":")[1].split(",");
                    for (int j = 0; j < split.length; j++) {
                        udwolineDao.delete(Long.valueOf(split[j]));
                    }
                } else if (appDeletes[i].split(":")[0].equals("UDWOQUALIFICATION")) {
                    String[] split = appDeletes[i].split(":")[1].split(",");
                    for (int j = 0; j < split.length; j++) {
                        udwoqualificationDao.delete(Long.valueOf(split[j]));
                    }
                } else if (appDeletes[i].split(":")[0].equals("WPLABOR")) {
                    String[] split = appDeletes[i].split(":")[1].split(",");
                    for (int j = 0; j < split.length; j++) {
                        wplaborDao.delete(Long.valueOf(split[j]));
                    }
                } else if (appDeletes[i].split(":")[0].equals("LABTRANS")) {
                    String[] split = appDeletes[i].split(":")[1].split(",");
                    for (int j = 0; j < split.length; j++) {
                        labtranDao.delete(Long.valueOf(split[j]));
                    }
                } else if (appDeletes[i].split(":")[0].equals("MATUSETRANS")) {
                    String[] split = appDeletes[i].split(":")[1].split(",");
                    for (int j = 0; j < split.length; j++) {
                        matusetranDao.delete(Long.valueOf(split[j]));
                    }
                } else if (appDeletes[i].split(":")[0].equals("FAILUREREPORT")) {
                    String[] split = appDeletes[i].split(":")[1].split(",");
                    for (int j = 0; j < split.length; j++) {
                        failurereportDao.delete(Long.valueOf(split[j]));
                    }
                } else if (appDeletes[i].split(":")[0].equals("RELATEDRECORD")) {
                    String[] split = appDeletes[i].split(":")[1].split(",");
                    for (int j = 0; j < split.length; j++) {
                        relatedrecordDao.delete(Long.valueOf(split[j]));
                    }
                }
            }
        }

        /**************************************子表保存操作开始******************************************/
        // 设备信息 UDWOLINE
        // wonum=:wonum and siteid=:siteid
        Map<String, Object> params = new HashMap<>();
        params.put("wonum", workorder.getWonum());
        params.put("siteid", workorder.getSiteid());
        String where = "wonum=:wonum and siteid=:siteid";
        List<Udwoline> udwolineList = udwolineDao.findAll(where, params, null);
        Map<Long, Udwoline> udwolineMap = new HashMap<>();
        if (udwolineList.size() > 0) {
            udwolineMap = udwolineList.stream().collect(
                    Collectors.toMap(Udwoline::getUdwolineid, a -> a, (k1, k2) -> k1));
        }
        if (null != workorder.getUdwolineList()) {
            //新增或修改
            for (Udwoline udwoline : workorder.getUdwolineList()) {
                if (null != udwoline.getUdwolineid()) {
                    Udwoline udwolineDBObj = udwolineMap.get(udwoline.getUdwolineid());
                    BeanUtils.copyProperties(udwoline, udwolineDBObj, ObjectUtil.getNullPropertyNames(udwoline));
                    ObjectUtil.setEditBasicData(udwolineDBObj, sessionInfo);
                    udwolineDao.update(udwolineDBObj);
                } else {
                    udwoline.setWonum(workorder.getWonum());
                    udwoline.setSiteid(workorder.getSiteid());
                    ObjectUtil.setAddBasicData(udwoline, sessionInfo);
                    udwolineDao.save(udwoline);
                }
            }
        }


        // 资质 UDWOQUALIFICATION
        // wonum=:wonum and siteid=:siteid
        List<Udwoqualification> udwoqualificationList = udwoqualificationDao.findAll(where, params, null);
        Map<Long, Udwoqualification> udwoqualificationMap = new HashMap<>();
        if (udwoqualificationList.size() > 0) {
            udwoqualificationMap = udwoqualificationList.stream().
                    collect(Collectors.toMap(Udwoqualification::getUdwoqualificationid, x -> x, (k1, k2) -> k1));
        }
        if (null != workorder.getUdwoqualificationList()) {
            for (Udwoqualification udwoqualification : workorder.getUdwoqualificationList()) {
                if (null != udwoqualification.getUdwoqualificationid()) {
                    Udwoqualification udwoqualificationDBObj = udwoqualificationMap.get(udwoqualification.getUdwoqualificationid());
                    BeanUtils.copyProperties(udwoqualification, udwoqualificationDBObj, ObjectUtil.getNullPropertyNames(udwoqualification));
                    ObjectUtil.setEditBasicData(udwoqualificationDBObj, sessionInfo);
                    udwoqualificationDao.update(udwoqualificationDBObj);
                } else {
                    udwoqualification.setWonum(workorder.getWonum());
                    udwoqualification.setSiteid(workorder.getSiteid());
                    ObjectUtil.setAddBasicData(udwoqualification, sessionInfo);
                    udwoqualificationDao.save(udwoqualification);
                }
            }
        }


        // 计划、执行报告公用：工单管理持久化
        String workorderWhere = "parent=:wonum and siteid=:siteid";
        List<Workorder> workorderList = workorderDao.findAll(workorderWhere, params, null);
        Map<Long, Workorder> woMap = new HashMap<>();
        if (workorderList.size() > 0) {
            woMap = workorderList.stream().collect(Collectors.toMap(Workorder::getWorkorderid, x -> x, (x1, x2) -> x1));
        }
        if (null != workorder.getWorkorderList()) {
            for (Workorder wo : workorder.getWorkorderList()) {
                if (null != wo.getWorkorderid()) {
                    Workorder workorderDBObj = woMap.get(wo.getWorkorderid());
                    BeanUtils.copyProperties(wo, workorderDBObj, ObjectUtil.getNullPropertyNames(wo));
                    ObjectUtil.setEditBasicData(workorderDBObj, sessionInfo);
                    workorderDao.update(workorderDBObj);
                } else {
                    ObjectUtil.setAddBasicData(workorder, sessionInfo);

                    Autokey autokey = autokeyDao.find(209l);
                    workorder.setWonum(String.valueOf(autokey.getSeed() + 1l));
                    autokey.setSeed(autokey.getSeed() + 1l);
                    autokeyDao.update(autokey);

                    workorderDao.save(workorder);
                }
            }
        }


        // 计划标签页信息 WPLABOR
        // wonum in (select wonum from workorder where (wonum=:wonum or (parent=:wonum and istask = :yes)) and siteid=:siteid )
        List<Wplabor> wplaborList = wplaborDao.findAll(where, params, null);
        Map<Long, Wplabor> wplaborMap = new HashMap<>();
        if (wplaborList.size() > 0) {
            wplaborMap = wplaborList.stream().collect(Collectors.toMap(Wplabor::getWplaboruid, x -> x, (x1, x2) -> x1));
        }
        if (null != workorder.getWplaborList()) {
            for (Wplabor wplabor : workorder.getWplaborList()) {
                if (null != wplabor.getWplaboruid()) {
                    Wplabor wplaborDBObj = wplaborMap.get(wplabor.getWplaboruid());
                    BeanUtils.copyProperties(wplabor, wplaborDBObj, ObjectUtil.getNullPropertyNames(wplabor));
                    ObjectUtil.setEditBasicData(wplaborDBObj, sessionInfo);
                    wplaborDao.update(wplaborDBObj);
                } else {
                    wplabor.setWonum(workorder.getWonum());
                    wplabor.setSiteid(workorder.getSiteid());
                    wplabor.setRate(0.0);
                    wplabor.setApptrequired(0);
                    wplabor.setRatehaschanged(0);

                    Autokey autokey = autokeyDao.find(232l);
                    wplabor.setWplaborid(String.valueOf(autokey.getSeed() + 1l));
                    autokey.setSeed(autokey.getSeed() + 1l);
                    autokeyDao.update(autokey);

                    ObjectUtil.setAddBasicData(wplabor, sessionInfo);
                    wplaborDao.save(wplabor);
                }
            }
        }


        // 执行报告标签页 LABTRANS
        // refwo in (select wonum from workorder where (wonum=:wonum or (parent=:wonum and istask = :yes)) and siteid=:siteid )
        String whereLabtransMatusetrans = "refwo=:wonum and siteid=:siteid";
        List<Labtran> labtranList = labtranDao.findAll(whereLabtransMatusetrans, params, null);
        Map<Long, Labtran> labtranMap = new HashMap<>();
        if (labtranList.size() > 0) {
            labtranMap = labtranList.stream().collect(Collectors.toMap(Labtran::getLabtransid, x -> x, (x1, x2) -> x1));
        }
        if (null != workorder.getLabtranList()) {
            for (Labtran labtran : workorder.getLabtranList()) {
                if (null != labtran.getLabtransid()) {
                    Labtran labtranDBObj = labtranMap.get(labtran.getLabtransid());
                    BeanUtils.copyProperties(labtran, labtranDBObj, ObjectUtil.getNullPropertyNames(labtran));
                    ObjectUtil.setEditBasicData(labtranDBObj, sessionInfo);
                    labtranDao.update(labtranDBObj);
                } else {
                    labtran.setRefwo(workorder.getWonum());
                    labtran.setSiteid(workorder.getSiteid());


                    labtran.setEnteredastask(0);
                    labtran.setGenapprservreceipt(0);
                    labtran.setRollup(0);
                    labtran.setLinecost(new BigDecimal(0.0));
                    labtran.setOutside(0);
                    labtran.setTranstype("WORK");
                    // TODO: 2017/11/27 业务逻辑存在问题
                    labtran.setStartdate(new Date());
                    labtran.setEnterdate(new Date());
                    labtran.setPayrate(new BigDecimal(0.0));
                    labtran.setCraft("TEST");
                    labtran.setTransdate(new Date());
                    labtran.setEnterby(sessionInfo.getLoginId());


                    ObjectUtil.setAddBasicData(labtran, sessionInfo);
                    labtranDao.save(labtran);
                }
            }
        }


        // 执行报告标签页 MATUSETRANS
        // refwo in (select wonum from workorder where (wonum=:wonum or (parent=:wonum and istask = :yes)) and siteid=:siteid )
        List<Matusetran> matusetranList = matusetranDao.findAll(whereLabtransMatusetrans, params, null);
        Map<Long, Matusetran> matusetranMap = new HashMap<>();
        if (matusetranList.size() > 0) {
            matusetranMap = matusetranList.stream().collect(Collectors.toMap(Matusetran::getMatusetransid, x -> x, (x1, x2) -> x1));
        }
        if (null != workorder.getMatusetranList()) {
            for (Matusetran matusetran : workorder.getMatusetranList()) {
                if (null != matusetran.getMatusetransid()) {
                    Matusetran matusetranDBObj = matusetranMap.get(matusetran.getMatusetransid());
                    BeanUtils.copyProperties(matusetran, matusetranDBObj, ObjectUtil.getNullPropertyNames(matusetran));
                    ObjectUtil.setEditBasicData(matusetranDBObj, sessionInfo);
                    matusetranDao.update(matusetranDBObj);
                } else {
                    matusetran.setRefwo(workorder.getWonum());
                    matusetran.setSiteid(workorder.getSiteid());
                    ObjectUtil.setAddBasicData(matusetran, sessionInfo);
                    matusetranDao.save(matusetran);
                }
            }
        }

        // 故障报告标签页 FAILUREREPORT
        // wonum = :wonum and siteid=:siteid
        List<Failurereport> failurereportList = failurereportDao.findAll(where, params, null);
        Map<Long, Failurereport> failurereportMap = new HashMap<>();
        if (failurereportList.size() > 0) {
            failurereportMap = failurereportList.stream().collect(Collectors.toMap(Failurereport::getFailurereportid, x -> x, (x1, x2) -> x1));
        }
        if (null != workorder.getFailurereportList()) {
            for (Failurereport failurereport : workorder.getFailurereportList()) {
                if (null != failurereport.getFailurereportid()) {
                    Failurereport failurereportDBObj = failurereportMap.get(failurereport.getFailurereportid());
                    BeanUtils.copyProperties(failurereport, failurereportDBObj, ObjectUtil.getNullPropertyNames(failurereport));
                    ObjectUtil.setEditBasicData(failurereportDBObj, sessionInfo);
                    failurereportDao.update(failurereportDBObj);
                } else {
                    failurereport.setWonum(workorder.getWonum());
                    failurereport.setSiteid(workorder.getSiteid());
                    ObjectUtil.setAddBasicData(failurereport, sessionInfo);
                    failurereportDao.save(failurereport);
                }
            }
        }

        // 关联工单标签页 RELATEDRECORD
        // siteid = :siteid and recordkey=:wonum and class =:woclass and relatedrecclass in
        // (select value from synonymdomain where domainid ='WOCLASS' and maxvalue in ('CHANGE', 'RELEASE','ACTIVITY', 'WORKORDER'))
        String whereRelatedrecord = "recordkey=:wonum and siteid=:siteid";

        Map<Long, Relatedrecord> relatedrecordMap = new HashMap<>();
        List<Relatedrecord> relatedrecordList = relatedrecordDao.findAll(whereRelatedrecord, params, null);
        if (relatedrecordList.size() > 0) {
            relatedrecordMap = relatedrecordList.stream().collect(Collectors.toMap(Relatedrecord::getRelatedrecordid, x -> x, (x1, x2) -> x1));
        }
        if (null != workorder.getRelatedrecordList()) {
            for (Relatedrecord relatedrecord : workorder.getRelatedrecordList()) {
                if (null != relatedrecord.getRelatedrecordid()) {
                    Relatedrecord relatedrecordDBObj = relatedrecordMap.get(relatedrecord.getRelatedrecordid());
                    BeanUtils.copyProperties(relatedrecord, relatedrecordDBObj, ObjectUtil.getNullPropertyNames(relatedrecord));
                    ObjectUtil.setEditBasicData(relatedrecordDBObj, sessionInfo);
                    relatedrecordDao.update(relatedrecordDBObj);
                } else {
                    relatedrecord.setRecordkey(workorder.getWonum());
                    relatedrecord.setClass_(workorder.getWoclass());
                    relatedrecord.setSiteid(workorder.getSiteid());
                    ObjectUtil.setAddBasicData(relatedrecord, sessionInfo);
                    relatedrecordDao.save(relatedrecord);
                }
            }
        }

        /**************************************子表保存操作结束******************************************/

        return workorder.getWorkorderid();
    }
}
