package com.hxqh.abb.service;

import com.hxqh.abb.dao.*;
import com.hxqh.abb.model.Udtool;
import com.hxqh.abb.model.UdtoolApply;
import com.hxqh.abb.model.UdtoolChk;
import com.hxqh.abb.model.UdtoolLend;
import com.hxqh.abb.model.dto.action.ToolDto;
import com.hxqh.abb.model.searchdto.Page;
import com.hxqh.abb.model.searchdto.UdtoolDto;
import com.hxqh.abb.model.view.AbbInventorySite;
import com.hxqh.abb.model.view.AbbUdtool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lh on 2017/5/10.
 */
@Transactional
@Service("toolService")
public class ToolServiceImpl implements ToolService {
    @Autowired
    private AbbUdtoolDao udtoolDao;
    @Autowired
    private AbbInventorySiteDao siteDao;
    @Autowired
    private UdtoolApplyDao udtoolApplyDao;
    @Autowired
    private UdtoolLendDao udtoolLendDao;
    @Autowired
    private UdtoolChkDao udtoolChkDao;


    /**************************************/
    /**update by wkl
     * 2017-8-16
     * 工具台账
     **/

    @Override
    public List<AbbUdtool> getUdtoolList() {
        return udtoolDao.findAll();
    }

    @Override
    public AbbUdtool getAbbUdtoolId(Long udtoolid) {
        return udtoolDao.find(udtoolid);
    }
    /**************************************/
    /**
     * 工具校准
     **/
    @Override
    public List<UdtoolChk> getUdtoolChkList() {
        return udtoolChkDao.findAll();
    }

    @Override
    public UdtoolChk getUdtoolChkId(Long udtoolchkid) {
        return udtoolChkDao.find(udtoolchkid);
    }
    /***************************************/
    /**
     * 工具借还
     **/
    @Override
    public UdtoolLend getUdtoolLendId(Long udtoollendid) { return udtoolLendDao.find(udtoollendid); }

    @Override
    public List<UdtoolLend> getUdtoolLendList() {
        return udtoolLendDao.findAll();
    }

    @Override
    public void addUdtoolLend(UdtoolLend udtoolLend) {
        udtoolLendDao.save(udtoolLend);
    }

    @Override
    public void updateUdtoolLend(UdtoolLend ul) { udtoolLendDao.update(ul); }

    @Override
    public void delUdtoolLend(long l) { udtoolLendDao.delete(l); }


    /**************************************/
    /**
     * 工具修丢废
     **/

    @Override
    public List<UdtoolApply> getUdtoolApplyList() {
        return udtoolApplyDao.findAll();
    }

    @Override
    public UdtoolApply getUdtoolApplyId(Long udtoolapplyid) { return udtoolApplyDao.find(udtoolapplyid); }

    @Override
    public void addUdtoolApply(UdtoolApply udtoolApply) {
        udtoolApplyDao.save(udtoolApply);
    }

    @Override
    public void updateUdtoolApply(UdtoolApply ua) { udtoolApplyDao.update(ua); }

    @Override
    public void delUdtoolApply(long l) {
        udtoolApplyDao.delete(l);
    }


    /*******************************************************/
    @Override
    public ToolDto getListData(Page page) throws Exception {
        List<AbbUdtool> udtoolList = udtoolDao.findAll(0, 15, null, null, " order by udtoolid desc");
        List<AbbInventorySite> siteList = siteDao.findAll();
        List<String> statusList = Arrays.asList("完好", "维修");
        page.setTotalPageNum((int) udtoolDao.getCount());
        ToolDto toolDto = new ToolDto(udtoolList, siteList, statusList, page);
        return toolDto;
    }

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
        List<AbbUdtool> udtoolList = udtoolDao.findAll(page.getThisPageFirstElementNumber() - 1, page.getPageSize(), wherebuilder.toString(), params, " order by udtoolid desc");
        page.setTotalPageNum((int) udtoolDao.getCount(wherebuilder.toString(), params));
        ToolDto toolDto = new ToolDto(udtoolList, page);
        return toolDto;
    }


}
