package com.hxqh.abb.service;

/**
 * Created by Ocean lin on 2017/9/5.
 */

import com.hxqh.abb.dao.*;
import com.hxqh.abb.model.version2.Udbed;
import com.hxqh.abb.model.version2.Udbedapply;
import com.hxqh.abb.model.version2.Udvehicle;
import com.hxqh.abb.model.version2.Udvehicleapply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("serverStationService")
public class ServerStationServiceImpl implements ServerStationService {

    @Autowired
    private UdvehicleDao udvehicleDao;
    @Autowired
    private UdvehicleapplyDao udvehicleapplyDao;
    @Autowired
    private WftransactionDao wftransactionDao;
    @Autowired
    private WfassignmentDao wfassignmentDao;
    @Autowired
    private UdbedDao udbedDao;
    @Autowired
    private UdbedapplyDao udbedapplyDao;

    @Override
    public Long addUdvehicle(Udvehicle udvehicle) {
        udvehicleDao.save(udvehicle);
        return udvehicle.getUdvehicleid();
    }

    @Override
    public void editUdvehicle(Udvehicle udvehicle) {
        udvehicleDao.update(udvehicle);
    }

    @Override
    public Long addUdvehicleapply(Udvehicleapply udvehicleapply) {
        udvehicleapplyDao.save(udvehicleapply);
        return udvehicleapply.getUdvehicleid();
    }

    @Override
    public void editUdvehicleapply(Udvehicleapply udvehicleapply) {
        udvehicleapplyDao.update(udvehicleapply);
    }

    @Override
    public Long addUdbed(Udbed udbed) {
        udbedDao.save(udbed);
        return udbed.getUdbedid();
    }

    @Override
    public void editUdbed(Udbed udbed) {
        udbedDao.update(udbed);
    }

    @Override
    public Long addUdbedapply(Udbedapply udbedapply) {
        udbedapplyDao.save(udbedapply);
        return udbedapply.getUdbedapplyid();
    }

    @Override
    public void editUdbedapply(Udbedapply udbedapply) {
        udbedapplyDao.update(udbedapply);
    }


//    private void saveAuditAndNextAudit(List<Wftransaction> wftransactionList, Wfassignment wfassignment) {
//        if(wftransactionList.size()>0) {
//            for (Wftransaction wftransaction : wftransactionList) {
//                wftransactionDao.saveOrUpdate(wftransaction);
//            }
//        }
//        if(null!=wfassignment)
//        {
//            wfassignmentDao.save(wfassignment);
//        }
//    }
}
