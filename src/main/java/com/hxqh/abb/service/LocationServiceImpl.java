package com.hxqh.abb.service;

import com.hxqh.abb.common.ObjectUtil;
import com.hxqh.abb.dao.*;
import com.hxqh.abb.model.base.SessionInfo;
import com.hxqh.abb.model.dto.action.CityDto;
import com.hxqh.abb.model.dto.action.InventoryDto;
import com.hxqh.abb.model.searchdto.InventorySearchDto;
import com.hxqh.abb.model.searchdto.Page;
import com.hxqh.abb.model.version2.*;
import com.hxqh.abb.model.view.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by lh on 2017/4/14.
 */
@Transactional
@Service("locationService")
public class LocationServiceImpl implements LocationService {

    @Autowired
    private AbbInventoryDao abbinventoryDao;
    @Autowired
    private AbbInventorySiteDao siteDao;
    @Autowired
    private AbbInventoryItemDao itemDao;
    @Autowired
    private AbbInventoryLocationDao abbInventoryLocationDao;
    @Autowired
    private AbbLocationDao abbLocationDao;
    @Autowired
    private InvuseDao invuseDao;
    @Autowired
    private InvuselineDao invuselineDao;
    @Autowired
    private UdinvcheckDao udinvcheckDao;
    @Autowired
    private UdinvchecklineDao udinvchecklineDao;
    @Autowired
    private PoDao poDao;
    @Autowired
    private PolineDao polineDao;
    @Autowired
    private MatrectranDao matrectranDao;
    @Autowired
    private AutokeyDao autokeyDao;

    @Override
    public List<AbbLocation> getRootList() {
        List<AbbLocation> abbLocations = abbLocationDao.findAll("parent is null", null, null);
        return abbLocations;
    }


    @Override
    public List<AbbLocation> getRootList(SessionInfo sessionInfo) {
        Map<String, Object> params = new HashMap<>();
        params.put("siteid", sessionInfo.getSite());
        String where = "siteid=:siteid and parent is null";
        List<AbbLocation> abbLocations = abbLocationDao.findAll(where, params, null);
        return abbLocations;
    }

    @Override
    public List<AbbLocation> getChildLocation(String location) {
        Map<String, Object> params = new HashMap<>();
        params.put("location", location);
        String where = "parent=:location";
        List<AbbLocation> childList = abbLocationDao.findAll(where, params, null);
        return childList;
    }


    @Override
    public InventoryDto getInventoryData(InventorySearchDto searchInventoryDto, Page page) {
        Map<String, Object> params = new HashMap<>();
        StringBuilder wherebuilder = new StringBuilder();
        wherebuilder.append("1=1 ");
        if (searchInventoryDto.getSiteid() != null && !"".equals(searchInventoryDto.getSiteid())) {
            wherebuilder.append(" and SITEID =").append(":SITEID");
            params.put("SITEID", searchInventoryDto.getSiteid());
        }
        if (searchInventoryDto.getDescription() != null && !"".equals(searchInventoryDto.getDescription())) {
            wherebuilder.append(" and (DESCRIPTION Like '%'||").append(":DESCRIPTION").append("||'%' )");
            params.put("DESCRIPTION", searchInventoryDto.getDescription());
        }
        if (searchInventoryDto.getLocation() != null && !"".equals(searchInventoryDto.getLocation())) {
            wherebuilder.append(" and LOCATION =").append(":LOCATION");
            params.put("LOCATION", searchInventoryDto.getLocation());
        }
        if (searchInventoryDto.getUdsapnum() != null && !"".equals(searchInventoryDto.getUdsapnum())) {
            wherebuilder.append(" and UDSAPNUM =").append(":UDSAPNUM");
            params.put("UDSAPNUM", searchInventoryDto.getUdsapnum());
        }
        if (searchInventoryDto.getCurbal() != null && !"".equals(searchInventoryDto.getCurbal())) {
            wherebuilder.append(" and CURBAL =").append(":CURBAL");
            params.put("CURBAL", searchInventoryDto.getCurbal());
        }
        List<AbbInventory> inventoryList = abbinventoryDao.findAll(page.getThisPageFirstElementNumber() - 1, page.getPageSize(), wherebuilder.toString(), params, " order by inventoryid desc");
        page.setTotalPageNum((int) abbinventoryDao.getCount(wherebuilder.toString(), params));
        InventoryDto inventoryDto = new InventoryDto(inventoryList, page);
        return inventoryDto;
    }

    @Override
    public InventoryDto inventoryListData(Page page) {
        List<AbbInventory> inventoryList = abbinventoryDao.findAll(0, 15, null, null, " order by inventoryid desc");
        List<AbbInventoryLocation> locationList = abbInventoryLocationDao.findAll();
        List<AbbInventorySite> siteList = siteDao.findAll();
        List<AbbInventoryItem> itemList = itemDao.findAll();
        page.setTotalPageNum((int) abbinventoryDao.getCount());
        InventoryDto inventoryDto = new InventoryDto(inventoryList, siteList, locationList, itemList, page);
        return inventoryDto;
    }

    @Override
    public AbbLocation getParentLocation(String location) {
        Map<String, Object> params = new HashMap<>();
        params.put("location", location);
        String where = "location=:location";
        List<AbbLocation> childList = abbLocationDao.findAll(where, params, null);
        params.put("location", childList.get(0).getParent());
        List<AbbLocation> parent = abbLocationDao.findAll(where, params, null);
        return parent.get(0);
    }

    @Override
    public CityDto getCityList(String location) {
        Map<String, Object> params = new HashMap<>();
        params.put("location", location);
        String where = "location=:location";
        List<AbbLocation> abbLocations = abbLocationDao.findAll(where, params, null);

        String whereChild = "parent=:location";
        List<AbbLocation> childList = abbLocationDao.findAll(whereChild, params, null);
        CityDto cityDto = new CityDto(childList, abbLocations.get(0));
        return cityDto;
    }

    /*============================二期开始 ==========================*/


    @Override
    public Long addInvuse(Invuse invuse, SessionInfo sessionInfo) throws Exception {
        Autokey autokey = autokeyDao.find(221l);

        if (invuse.getMaintab().equals("main")) {
            ObjectUtil.setAddBasicData(invuse, sessionInfo);
            invuse.setInvusenum(String.valueOf(autokey.getSeed() + 1l));
            autokey.setSeed(autokey.getSeed() + 1l);
            autokeyDao.update(autokey);
            return saveInvuser(invuse);
        } else {
            Invuse dbObject = invuseDao.find(invuse.getInvuseid());
            ObjectUtil.setEditBasicData(dbObject, sessionInfo);
            BeanUtils.copyProperties(invuse, dbObject, ObjectUtil.getNullPropertyNames(invuse));

            invuseDao.merge(dbObject);
            if (invuse.getInvuselineList().size() > 0) {
                int count = 0;
                for (Invuseline invuseline : invuse.getInvuselineList()) {
                    //物资发放行是物资发放的子表，关系：INVUSELINE，子表INVUSELINE，关系SQL：invusenum=:invusenum and siteid=:siteid
                    invuseline.setInvusenum(invuse.getUdprojectnum());
                    //断点看一下 最后invuseline的Siteid到底是invuse.getSiteid() 还是session里的sessionInfo.getSite()
                    invuseline.setSiteid(invuse.getSiteid());
                    invuseline.setEnterby(sessionInfo.getLoginId());
                    ObjectUtil.setAddBasicData(invuseline, sessionInfo);
                    setInvuseline(invuse, invuseline);

                    count++;
                    invuseline.setInvuselinenum(count);
                    invuselineDao.save(invuseline);
                }
            }
            return dbObject.getInvuseid();
        }
    }


    private Long saveInvuser(Invuse invuse) {
        invuse.setInvowner(invuse.getPersonid());


        // 2017-12-22 06:58:10 新增“是否维保项目”字段（ISMAINT） 默认为0
        invuse.setIsmaint(0);

        invuse.setStatusiface(0);
        invuse.setAutocreated(0);
        invuse.setReceipts("NONE");
        invuse.setChangedate(new Date());
        invuse.setExchangerate(new BigDecimal(1));
        invuse.setExchangerate2(new BigDecimal(1));
        invuse.setLangcode("ZH");
        invuse.setIssite(0);

        // 不同app设置不同Udapptype
        if (invuse.getApptname().equals("UDISSUE")) {
            invuse.setUsetype("ISSUE");
            invuse.setUdapptype("ISSUE");
        } else if (invuse.getApptname().equals("UDTRANSFER")) {
            invuse.setUsetype("TRANSFER");
            invuse.setUdapptype("TRANSFER");
        } else if (invuse.getApptname().equals("UDRETURN")) {
            invuse.setUsetype("RETURN");
            invuse.setUdapptype("RETURN");
        }

        invuse.setWarranty(0);
        invuse.setStatus("ENTERED");

        invuseDao.save(invuse);
        Long invuseid = invuse.getInvuseid();
        invuse.setUdprojectnum(invuseid.toString());
        return invuseid;
    }


    @Override
    public void editInvuse(Invuse invuse, SessionInfo sessionInfo) throws Exception {
        //持久化主表
        Invuse dbObject = invuseDao.find(invuse.getInvuseid());
        ObjectUtil.setEditBasicData(invuse, sessionInfo);
        BeanUtils.copyProperties(invuse, dbObject, ObjectUtil.getNullPropertyNames(invuse));
        invuseDao.merge(dbObject);


        //删除从表
        if (null != invuse.getDeletes() && !invuse.getDeletes().equals("")) {
            String[] strings = invuse.getDeletes().split(",");
            for (int i = 0; i < strings.length; i++) {
                invuselineDao.delete(Long.valueOf(strings[i]));
            }
        }
        //从表操作
        Map<String, Object> params = new HashMap<>();
        params.put("invusenum", invuse.getInvusenum());
        String where = "invusenum=:invusenum ";
        List<Invuseline> invuselineList = invuselineDao.findAll(where, params, null);
        Map<Long, Invuseline> invuselineMap = invuselineList.stream().collect(
                Collectors.toMap(Invuseline::getInvuselineid, a -> a, (k1, k2) -> k1)
        );
        if (null != invuse.getInvuselineList()) {
            int count = 0;
            for (Invuseline invuseline : invuse.getInvuselineList()) {
                if (null != invuseline.getInvuselineid()) {
                    Invuseline dbobject = invuselineMap.get(invuseline.getInvuselineid());
                    ObjectUtil.setEditBasicData(invuseline, sessionInfo);
                    BeanUtils.copyProperties(invuseline, dbobject, ObjectUtil.getNullPropertyNames(invuseline));
                    invuselineDao.merge(dbobject);
                    count++;
                } else {
                    invuseline.setEnterby(sessionInfo.getLoginId());
                    invuseline.setInvusenum(invuse.getUdprojectnum());
                    ObjectUtil.setAddBasicData(invuseline, sessionInfo);
                    setInvuseline(invuse, invuseline);

                    count++;
                    invuseline.setInvuselinenum(count);
                    invuselineDao.save(invuseline);
                }
            }
        }

    }

    private void setInvuseline(Invuse invuse, Invuseline invuseline) {
        //非空添加
        // 不同app设置不同Udapptype
        if (invuse.getApptname().equals("UDISSUE")) {
            invuseline.setUsetype("ISSUE");
        } else if (invuse.getApptname().equals("UDTRANSFER")) {
            invuseline.setUsetype("TRANSFER");
        } else if (invuse.getApptname().equals("UDRETURN")) {
            invuseline.setUsetype("RETURN");
        }

        invuseline.setValidated(0);
        invuseline.setEnteredastask(0);
        invuseline.setLinetype("ITEM");
        invuseline.setFromstoreloc(invuse.getFromstoreloc());
        invuseline.setActualdate(new Date());
        invuseline.setUnitcost(new BigDecimal(0));
        invuseline.setLinecost(new BigDecimal(0));
        invuseline.setPhyscnt(new BigDecimal(0));
        invuseline.setPhyscntdate(new Date());
        invuseline.setSplit(0);
        invuseline.setReturnagainstissue(0);
        invuseline.setReceiptscomplete(0);
        invuseline.setInspectionrequired(0);
        invuseline.setLangcode("ZH");
    }

    /**
     * 库存盘点添加
     *
     * @param udinvcheck
     * @param sessionInfo
     * @return
     * @throws Exception
     */
    @Override
    public Long addUdinvcheck(Udinvcheck udinvcheck, SessionInfo sessionInfo) throws Exception {
        if (udinvcheck.getMaintab().equals("main")) {
            ObjectUtil.setAddBasicData(udinvcheck, sessionInfo);
            udinvcheck.setEnterby(sessionInfo.getDisplayname());
            udinvcheck.setEnterdate(new Date());

            Autokey autokey = autokeyDao.find(237l);
            udinvcheck.setInvchecknum(String.valueOf(autokey.getSeed() + 1l));
            autokey.setSeed(autokey.getSeed() + 1l);
            autokeyDao.update(autokey);

            udinvcheckDao.save(udinvcheck);
            return udinvcheck.getUdinvcheckid();
        } else {
            Udinvcheck dbObject = udinvcheckDao.find(udinvcheck.getUdinvcheckid());
            ObjectUtil.setEditBasicData(udinvcheck, sessionInfo);
            BeanUtils.copyProperties(udinvcheck, dbObject, ObjectUtil.getNullPropertyNames(udinvcheck));
            udinvcheckDao.update(dbObject);

            if (udinvcheck.getUdinvchecklineList().size() > 0) {
                for (Udinvcheckline udinvcheckline : udinvcheck.getUdinvchecklineList()) {
                    //invchecknum=:invchecknum and siteid=:siteid and storeloc=:storeloc
                    udinvcheckline.setInvchecknum(udinvcheck.getInvchecknum());
                    udinvcheckline.setSiteid(udinvcheck.getSiteid());
                    udinvcheckline.setStoreloc(udinvcheck.getStoreloc());
                    ObjectUtil.setAddBasicData(udinvcheckline, sessionInfo);
                    udinvchecklineDao.save(udinvcheckline);
                }
            }
            return dbObject.getUdinvcheckid();
        }
    }

    /**
     * 库存盘点详情保存
     *
     * @param udinvcheck
     * @param sessionInfo
     * @throws Exception
     */
    @Override
    public void editUdinvcheck(Udinvcheck udinvcheck, SessionInfo sessionInfo) throws Exception {
        Udinvcheck dbObject = udinvcheckDao.find(udinvcheck.getUdinvcheckid());
        ObjectUtil.setEditBasicData(udinvcheck, sessionInfo);
        BeanUtils.copyProperties(udinvcheck, dbObject, ObjectUtil.getNullPropertyNames(udinvcheck));
        udinvcheckDao.update(dbObject);

        //删除
        if (null != udinvcheck.getDeletes() && !udinvcheck.getDeletes().equals("")) {
            String[] strings = udinvcheck.getDeletes().split(",");
            for (int i = 0; i < strings.length; i++) {
                udinvchecklineDao.delete(Long.valueOf(strings[i]));
            }
        }

        Map<String, Object> params = new HashMap<>();
        params.put("invchecknum", udinvcheck.getInvchecknum());
        String where = "invchecknum=:invchecknum";
        List<Udinvcheckline> udinvchecklineList = udinvchecklineDao.findAll(where, params, null);
        Map<Long, Udinvcheckline> udinvchecklineMap = udinvchecklineList.stream().collect(
                Collectors.toMap(Udinvcheckline::getUdinvchecklineid, a -> a, (k1, k2) -> k1)
        );

        if (null != udinvcheck.getUdinvchecklineList()) {
            for (Udinvcheckline udinvcheckline : udinvcheck.getUdinvchecklineList()) {
                if (null != udinvcheckline.getUdinvchecklineid()) {
                    Udinvcheckline dbobject = udinvchecklineMap.get(udinvcheckline.getUdinvchecklineid());
                    BeanUtils.copyProperties(udinvcheckline, dbobject, ObjectUtil.getNullPropertyNames(udinvcheckline));
                    ObjectUtil.setEditBasicData(udinvcheckline, sessionInfo);
                    udinvchecklineDao.update(dbobject);
                } else {
                    udinvcheckline.setInvchecknum(udinvcheck.getInvchecknum());
                    udinvcheckline.setStoreloc(udinvcheck.getStoreloc());
                    ObjectUtil.setAddBasicData(udinvcheckline, sessionInfo);
                    udinvchecklineDao.save(udinvcheckline);
                }
            }
        }
    }


    @Override
    public Long addPo(Po po, SessionInfo sessionInfo) throws Exception {
        if (po.getMaintab().equals("main")) {
            ObjectUtil.setAddBasicData(po, sessionInfo);

            return savePo(po, sessionInfo);
        } else {
            Po dbObject = poDao.find(po.getPoid());
            ObjectUtil.setEditBasicData(po, sessionInfo);
            BeanUtils.copyProperties(po, dbObject, ObjectUtil.getNullPropertyNames(po));
            poDao.update(dbObject);
            if (po.getPolineList().size() > 0) {
                for (Poline poline : po.getPolineList()) {
                    //ponum=:ponum and revisionnum=:revisionnum and siteid=:siteid
                    ObjectUtil.setAddBasicData(poline, sessionInfo);
                    poline.setPonum(po.getPonum());
                    poline.setRevisionnum(po.getRevisionnum());
                    poline.setSiteid(po.getSiteid());
                    polineDao.save(poline);
                }
            }
            return dbObject.getPoid();
        }
    }

    //添加数据
    private Long savePo(Po po, SessionInfo sessionInfo) {
        po.setPotype("STD");
        po.setVendor("SKF");
        po.setContact("JIM JACKSON");
        po.setPaymentterms("2/10 NET 30");
        po.setShipvia("UPS-1");
        po.setCustomernum("39921");
        po.setFob("HARTFORD,CT");
        po.setShiptoattn(sessionInfo.getLoginId());
        po.setTotalcost(new BigDecimal(0));
        po.setPriority(0);
        po.setHistoryflag(0);
        po.setPo10(0);
        po.setCurrencycode("USD");
        po.setExchangerate(new BigDecimal(0));
        po.setExchangedate(new Date());
        po.setBuyahead(0);
        po.setTotaltax1(new BigDecimal(0));
        po.setTotaltax2(new BigDecimal(0));
        po.setTotaltax3(new BigDecimal(0));
        po.setInclusive1(1);
        po.setInclusive2(1);
        po.setInclusive3(1);
        po.setInternal(0);
        po.setTotaltax4(new BigDecimal(0));
        po.setTotaltax5(new BigDecimal(0));
        po.setInclusive4(1);
        po.setInclusive5(1);
        po.setPayonreceipt(0);
        po.setInspectionrequired(0);
        po.setLangcode("ZH");
        po.setRevisionnum(0);
        po.setInternalchange(0);
        po.setIgnorecntrev(0);

        // 不同app设置不同Udapptype
        if (po.getApptname().equals("UDPO") || po.getApptname().equals("RECEIPTS")) {
            po.setUdapptype("UDPO");
        } else if (po.getApptname().equals("RECEIPTS")) {
            po.setUdapptype("TRANSFER");
        } else if (po.getApptname().equals("UDWM")) {
            po.setUdapptype("UDWM");
        } else if (po.getApptname().equals("UDOM")) {
            po.setUdapptype("UDOM");
        }
        // 设置状态
        po.setStatus("WAPPR");
        poDao.save(po);
        Long poid = po.getPoid();
        po.setPonum(setponum(poid));


        return poid;
    }

    //获取流水号
    private String setponum(Long poid) {
        StringBuffer stringBuffer = new StringBuffer().append(new SimpleDateFormat("yyyyMMdd").format(new Date()));

        int i = poid.toString().length();
        String s = String.valueOf(poid);
        switch (i) {
            case 1:
                stringBuffer.append("00").append(s);
                break;
            case 2:
                stringBuffer.append("0").append(s);
                break;
            default:
                String str = s.substring(i - 3, i);
                stringBuffer.append(str);
                break;
        }

        return stringBuffer.toString();
    }

    @Override
    public void editPo(Po po, SessionInfo sessionInfo) throws Exception {
        Po dbObject = poDao.find(po.getPoid());
        ObjectUtil.setEditBasicData(po, sessionInfo);
        BeanUtils.copyProperties(po, dbObject, ObjectUtil.getNullPropertyNames(po));
        poDao.update(dbObject);

        //删除
        if (null != po.getDeletes() && !po.getDeletes().equals("")) {
            String[] strings = po.getDeletes().split(",");
            for (int i = 0; i < strings.length; i++) {
                polineDao.delete(Long.valueOf(strings[i]));
            }
        }

        Map<String, Object> params = new HashMap<>();
        params.put("ponum", po.getPonum());
        String where = "ponum=:ponum";
        List<Poline> polineList = polineDao.findAll(where, params, null);
        Map<Long, Poline> polineMap = polineList.stream().collect(
                Collectors.toMap(Poline::getPolineid, a -> a, (k1, k2) -> k1)
        );

        if (null != po.getPolineList()) {
            for (Poline poline : po.getPolineList()) {
                if (null != poline.getPolineid()) {
                    Poline dbobject = polineMap.get(poline.getPolineid());
                    BeanUtils.copyProperties(poline, dbobject, ObjectUtil.getNullPropertyNames(poline));
                    ObjectUtil.setEditBasicData(poline, sessionInfo);
                    polineDao.update(dbobject);
                } else {
                    poline.setPonum(po.getPonum());
                    ObjectUtil.setAddBasicData(poline, sessionInfo);
                    savepoline(poline, sessionInfo);

                }
            }
        }

    }

    //poline 非空添  加
    private void savepoline(Poline poline, SessionInfo sessionInfo) {

        poline.setReceivedtotalcost(new BigDecimal(0));
        poline.setRejectedqty(new BigDecimal(0));
        poline.setIssue(0);
        poline.setPolinenum(1);
        poline.setTaxed(0);
        poline.setChargestore(0);
        poline.setTax1(new BigDecimal(0));
        poline.setTax2(new BigDecimal(0));
        poline.setTax3(new BigDecimal(0));
        poline.setReceiptreqd(1);
        poline.setTax4(new BigDecimal(0));
        poline.setTax5(new BigDecimal(0));
        poline.setLoadedcost(new BigDecimal(0));
        poline.setProrateservice(0);
        poline.setReceiptscomplete(1);
        poline.setInspectionrequired(0);
        poline.setLinecost2(new BigDecimal(0));
        poline.setIsdistributed(0);
        poline.setEnteredastask(0);
        poline.setLinetype("ITEM");
        poline.setLangcode("ZH");
        poline.setConversion(new BigDecimal(1));
        poline.setMktplcitem(0);
        poline.setRevisionnum(0);
        poline.setTaxexempt(0);
        poline.setConsignment(0);
        poline.setLinecost(new BigDecimal(0));
        poline.setEnterby(sessionInfo.getLoginId());

        polineDao.save(poline);
    }

    @Override
    public Long addPoreceive(Po po, SessionInfo sessionInfo) throws Exception {
        if (po.getMaintab().equals("main")) {
            ObjectUtil.setAddBasicData(po, sessionInfo);
            po.setPonum(po.getPoid().toString());
            poDao.save(po);
            return po.getPoid();
        } else {
            Po dbObject = poDao.find(po.getPoid());
            ObjectUtil.setEditBasicData(dbObject, sessionInfo);
            BeanUtils.copyProperties(po, dbObject, ObjectUtil.getNullPropertyNames(po));
            poDao.update(dbObject);
            if (po.getMatrectranList().size() > 0) {
                for (Matrectran matrectran : po.getMatrectranList()) {
                    //ponum = :ponum and positeid=:siteid
                    ObjectUtil.setAddBasicData(matrectran, sessionInfo);
                    matrectran.setPonum(po.getPonum());
                    matrectran.setPositeid(po.getSiteid());
                    matrectranDao.save(matrectran);
                }
            }
            return dbObject.getPoid();
        }
    }

    @Override
    public void editPoreceive(Po po, SessionInfo sessionInfo) throws Exception {
        Po dbObject = poDao.find(po.getPoid());
        ObjectUtil.setEditBasicData(po, sessionInfo);
        BeanUtils.copyProperties(po, dbObject, ObjectUtil.getNullPropertyNames(po));
        poDao.update(dbObject);

        //删除
        if (null != po.getDeletes() && !po.getDeletes().equals("")) {
            String[] strings = po.getDeletes().split(",");
            for (int i = 0; i < strings.length; i++) {
                matrectranDao.delete(Long.valueOf(strings[i]));
            }
        }

        Map<String, Object> params = new HashMap<>();
        params.put("ponum", po.getPonum());
        String where = "ponum=:ponum";
        List<Matrectran> matrectranList = matrectranDao.findAll(where, params, null);
        Map<Long, Matrectran> matrectranMap = matrectranList.stream().collect(
                Collectors.toMap(Matrectran::getMatrectransid, a -> a, (k1, k2) -> k1)
        );
        if (null != po.getMatrectranList()) {
            for (Matrectran matrectran : po.getMatrectranList()) {
                if (null != matrectran.getMatrectransid()) {
                    Matrectran dbobject = matrectranMap.get(matrectran.getMatrectransid());
                    BeanUtils.copyProperties(matrectran, dbobject, ObjectUtil.getNullPropertyNames(matrectran));
                    ObjectUtil.setEditBasicData(matrectran, sessionInfo);
                    matrectranDao.update(dbobject);
                } else {
                    matrectran.setPonum(po.getMnetsent());
                    ObjectUtil.setAddBasicData(matrectran, sessionInfo);
                    matrectranDao.save(matrectran);
                }
            }
        }

    }


    /*============================二期开始 ==========================*/

}


