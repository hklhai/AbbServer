package com.hxqh.abb.service;

import com.hxqh.abb.common.ObjectUtil;
import com.hxqh.abb.dao.*;
import com.hxqh.abb.model.Udtool;
import com.hxqh.abb.model.UdtoolApply;
import com.hxqh.abb.model.UdtoolChk;
import com.hxqh.abb.model.UdtoolLend;
import com.hxqh.abb.model.base.SessionInfo;
import com.hxqh.abb.model.dto.action.ToolDto;
import com.hxqh.abb.model.searchdto.Page;
import com.hxqh.abb.model.searchdto.UdtoolDto;
import com.hxqh.abb.model.version2.Autokey;
import com.hxqh.abb.model.version2.Udtoolchkline;
import com.hxqh.abb.model.view.AbbInventorySite;
import com.hxqh.abb.model.view.AbbUdtool;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by lh on 2017/5/10.
 */
@Transactional
@Service("toolService")
public class ToolServiceImpl implements ToolService {
    @Autowired
    private AbbUdtoolDao abbUdtoolDao;
    @Autowired
    private AbbInventorySiteDao siteDao;
    @Autowired
    private UdtoolDao udtoolDao;
    @Autowired
    private UdtoolLendDao udtoolLendDao;
    @Autowired
    private UdtoolApplyDao udtoolApplyDao;
    @Autowired
    private UdtoolChkDao udtoolChkDao;
    @Autowired
    private UdtoolchklineDao udtoolchklineDao;
    @Autowired
    private AutokeyDao autokeyDao;

    /*****************************************一期*****************************************/
    @Deprecated
    @Override
    public ToolDto getListData(Page page) throws Exception {
        List<AbbUdtool> udtoolList = abbUdtoolDao.findAll(0, 15, null, null, " order by udtoolid desc");
        List<AbbInventorySite> siteList = siteDao.findAll();
        List<String> statusList = Arrays.asList("完好", "维修");
        page.setTotalPageNum((int) abbUdtoolDao.getCount());
        ToolDto toolDto = new ToolDto(udtoolList, siteList, statusList, page);
        return toolDto;
    }

    @Deprecated
    @Override
    public ToolDto getToolData(UdtoolDto udtoolDto, Page page) throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        StringBuilder wherebuilder = new StringBuilder();
        wherebuilder.append("1=1 ");
        if (udtoolDto.getToolnum() != null && !"".equals(udtoolDto.getToolnum())) {
            wherebuilder.append(" and TOOLNUM =").append(":TOOLNUM");
            params.put("TOOLNUM", udtoolDto.getToolnum());
        }
        if (udtoolDto.getDescription() != null && !"".equals(udtoolDto.getDescription())) {
            wherebuilder.append(" and (DESCRIPTION like '%'||").append(":DESCRIPTION").append("||'%' )");
            params.put("DESCRIPTION", udtoolDto.getDescription());
        }
        if (udtoolDto.getStatus() != null && !"".equals(udtoolDto.getStatus())) {
            wherebuilder.append(" and STATUS =").append(":STATUS");
            params.put("STATUS", udtoolDto.getStatus());
        }
        if (udtoolDto.getDisplayname() != null && !"".equals(udtoolDto.getDisplayname())) {
            wherebuilder.append(" and DISPLAYNAME =").append(":DISPLAYNAME");
            params.put("DISPLAYNAME", udtoolDto.getDisplayname());
        }
        if (udtoolDto.getLocationsite() != null && !"".equals(udtoolDto.getLocationsite())) {
            wherebuilder.append(" and LOCATIONSITE =").append(":LOCATIONSITE");
            params.put("LOCATIONSITE", udtoolDto.getLocationsite());
        }
        List<AbbUdtool> udtoolList = abbUdtoolDao.findAll(page.getThisPageFirstElementNumber() - 1, page.getPageSize(), wherebuilder.toString(), params, " order by udtoolid desc");
        page.setTotalPageNum((int) abbUdtoolDao.getCount(wherebuilder.toString(), params));
        ToolDto toolDto = new ToolDto(udtoolList, page);
        return toolDto;
    }

    /*****************************************一期*****************************************/

    @Override
    public Long addToolAccount(Udtool udtool, SessionInfo sessionInfo) throws Exception {
        ObjectUtil.setAddBasicData(udtool, sessionInfo);
        udtoolDao.save(udtool);
        return udtool.getUdtoolid();
    }

    @Override
    public Long addToolLend(UdtoolLend udtoolLend, SessionInfo sessionInfo) throws Exception {
        ObjectUtil.setAddBasicData(udtoolLend, sessionInfo);

        Autokey autokey = autokeyDao.find(313l);
        udtoolLend.setLendnum(String.valueOf(autokey.getSeed() + 1l));
        autokey.setSeed(autokey.getSeed() + 1l);
        autokeyDao.update(autokey);

        udtoolLendDao.save(udtoolLend);
        return udtoolLend.getUdtoollendid();
    }

    @Override
    public Long addToolApply(UdtoolApply udtoolApply, SessionInfo sessionInfo) throws Exception {
        ObjectUtil.setAddBasicData(udtoolApply, sessionInfo);

        Autokey autokey = autokeyDao.find(321l);
        udtoolApply.setApplynum(String.valueOf(autokey.getSeed() + 1l));
        autokey.setSeed(autokey.getSeed() + 1l);
        autokeyDao.update(autokey);

        udtoolApplyDao.save(udtoolApply);
        return udtoolApply.getUdtoolapplyid();
    }


    @Override
    public void editToolAccount(Udtool udtool, SessionInfo sessionInfo) throws Exception {
        ObjectUtil.setEditBasicData(udtool, sessionInfo);
        udtoolDao.update(udtool);
    }

    @Override
    public void editToolLend(UdtoolLend udtoolLend, SessionInfo sessionInfo) throws Exception {
        UdtoolLend dbobject = udtoolLendDao.find(udtoolLend.getUdtoollendid());
        ObjectUtil.setEditBasicData(udtoolLend, sessionInfo);
        BeanUtils.copyProperties(udtoolLend, dbobject, ObjectUtil.getNullPropertyNames(udtoolLend));

        udtoolLendDao.update(dbobject);
    }

    @Override
    public void editToolApply(UdtoolApply udtoolApply, SessionInfo sessionInfo) throws Exception {
        UdtoolApply dbobject = udtoolApplyDao.find(udtoolApply.getUdtoolapplyid());
        ObjectUtil.setEditBasicData(udtoolApply, sessionInfo);
        BeanUtils.copyProperties(udtoolApply, dbobject, ObjectUtil.getNullPropertyNames(udtoolApply));
        udtoolApplyDao.update(dbobject);
    }


    @Override
    public Long addToolCHK(UdtoolChk udtoolChk, SessionInfo sessionInfo) throws Exception {
        if (udtoolChk.getMaintab().equals("main")) {
            ObjectUtil.setAddBasicData(udtoolChk, sessionInfo);

            Autokey autokey = autokeyDao.find(309l);
            udtoolChk.setTcnum(String.valueOf(autokey.getSeed() + 1l));
            autokey.setSeed(autokey.getSeed() + 1l);
            autokeyDao.update(autokey);

            udtoolChkDao.save(udtoolChk);
            return udtoolChk.getUdtoolchkid();
        } else {
            UdtoolChk dbObject = udtoolChkDao.find(udtoolChk.getUdtoolchkid());
            ObjectUtil.setEditBasicData(dbObject, sessionInfo);
            BeanUtils.copyProperties(udtoolChk, dbObject, ObjectUtil.getNullPropertyNames(udtoolChk));
            udtoolChkDao.merge(dbObject);
            if (udtoolChk.getUdtoolchklineList().size() > 0) {
                for (Udtoolchkline udtoolchkline : udtoolChk.getUdtoolchklineList()) {
                    ObjectUtil.setAddBasicData(udtoolchkline, sessionInfo);
                    udtoolchkline.setTcnum(udtoolChk.getTcnum());
                    udtoolchklineDao.save(udtoolchkline);
                }
            }
            return dbObject.getUdtoolchkid();
        }
    }


    @Override
    public void editToolCHK(UdtoolChk udtoolChk, SessionInfo sessionInfo) throws Exception {
        UdtoolChk chk = udtoolChkDao.find(udtoolChk.getUdtoolchkid());
        BeanUtils.copyProperties(udtoolChk, chk, ObjectUtil.getNullPropertyNames(udtoolChk));
        ObjectUtil.setEditBasicData(chk, sessionInfo);
        udtoolChkDao.update(chk);

        //删除
        if (null != udtoolChk.getDeletes() && !udtoolChk.getDeletes().equals("")) {
            String[] strings = udtoolChk.getDeletes().split(",");
            for (int i = 0; i < strings.length; i++) {
                udtoolchklineDao.delete(Long.valueOf(strings[i]));
            }
        }

        Map<String, Object> params = new HashMap<>();
        params.put("tcnum", udtoolChk.getTcnum());
        String where = "tcnum=:tcnum ";
        List<Udtoolchkline> udtoolchklineList = udtoolchklineDao.findAll(where, params, null);
        Map<Long, Udtoolchkline> udtoolchklineMap = udtoolchklineList.stream().collect(
                Collectors.toMap(Udtoolchkline::getUdtoolchklineid, a -> a, (k1, k2) -> k1));

        if (null != udtoolChk.getUdtoolchklineList()) {
            //新增或修改
            for (Udtoolchkline udtoolchkline : udtoolChk.getUdtoolchklineList()) {
                if (null != udtoolchkline.getUdtoolchklineid()) {
                    Udtoolchkline dbObject = udtoolchklineMap.get(udtoolchkline.getUdtoolchklineid());
                    BeanUtils.copyProperties(udtoolchkline, dbObject, ObjectUtil.getNullPropertyNames(udtoolchkline));
                    ObjectUtil.setEditBasicData(dbObject, sessionInfo);
                    udtoolchklineDao.update(dbObject);
                } else {
                    udtoolchkline.setTcnum(udtoolChk.getTcnum());
                    ObjectUtil.setAddBasicData(udtoolchkline, sessionInfo);
                    udtoolchklineDao.save(udtoolchkline);
                }
            }
        }
    }


}
