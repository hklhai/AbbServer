package com.hxqh.abb.service;

import com.hxqh.abb.common.ObjectUtil;
import com.hxqh.abb.common.util.FileUtils;
import com.hxqh.abb.dao.AutokeyDao;
import com.hxqh.abb.dao.DocinfoDao;
import com.hxqh.abb.dao.DoclinkDao;
import com.hxqh.abb.dao.VDocDao;
import com.hxqh.abb.model.Asset;
import com.hxqh.abb.model.Docinfo;
import com.hxqh.abb.model.Doclink;
import com.hxqh.abb.model.Inventory;
import com.hxqh.abb.model.base.SessionInfo;
import com.hxqh.abb.model.dto.DocDto;
import com.hxqh.abb.model.version2.Autokey;
import com.hxqh.abb.model.view.VDoc;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ocean lin on 2017/9/12.
 */
@Transactional
@Service("fileService")
public class FileServiceImpl implements FileService {

    private final static Logger logger = Logger.getLogger(FileServiceImpl.class);

    @Value(value = "${com.hxqh.abb.upload}")
    private String uploadPath;

    @Resource
    protected SessionFactory sessionFactory;

    @Autowired
    private DocinfoDao docinfoDao;

    @Autowired
    private DoclinkDao doclinkDao;

    @Autowired
    private VDocDao vDocDao;

    @Autowired
    private AutokeyDao autokeyDao;

    //mo.addObject("size", file.getSize() / (1024.0 * 1024) + "M");

    @Override
    public void saveFile(MultipartFile file, SessionInfo sessionInfo, String apptable, Long pkid) throws Exception {
        String filename = new String();
        if (file.getOriginalFilename() != null && file.getSize() > 0) {
            File f = new File(uploadPath);

            if (!f.exists())
                f.mkdirs();
            filename = uploadPath
                    + "/"
                    + file.getOriginalFilename();
            FileOutputStream outputStream;
            try {
                outputStream = new FileOutputStream(new File(filename));
                outputStream.write(file.getBytes());
                outputStream.flush();
                outputStream.close();
            } catch (IOException e) {
                logger.error(e.getMessage());
            }
        }
        DocDto docDto = saveDocinfo(sessionInfo, file, filename);
        if (apptable != null && apptable.contains("PAPERLESS_")) {
            apptable = apptable.replace("PAPERLESS_", "");
        }
        saveDoclink(sessionInfo, apptable, pkid, docDto, file.getOriginalFilename());
    }

    private void saveDoclink(SessionInfo sessionInfo, String apptable, Long pkid, DocDto docDto, String originalFilename) throws Exception {
        //保存doclink
        Doclink doclink = new Doclink();
        ObjectUtil.setAddBasicData(doclink, sessionInfo);
        doclink.setOwnertable(apptable);
        doclink.setOwnerid(pkid);

        doclink.setDoctype("Attachments");
        doclink.setGetlatestversion(1);
        doclink.setPrintthrulink(1);
        doclink.setCopylinktowo(0);
        doclink.setDocinfoid(docDto.getDocinfoid());
        doclink.setDocument(docDto.getDocument());
        doclinkDao.save(doclink);
    }


    private DocDto saveDocinfo(SessionInfo sessionInfo, MultipartFile file, String filename) throws Exception {
        //保存docinfo
        Docinfo docinfo = new Docinfo();
        ObjectUtil.setAddBasicData(docinfo, sessionInfo);

        docinfo.setPrintthrulinkdflt(1);
        docinfo.setUsedefaultfilepath(0);
        // 2017-12-13 docinfo表中show 默认是1
        docinfo.setShow(1);
        docinfo.setDoctype("Attachments");
        docinfo.setUrltype("FILE");
        docinfo.setLangcode("ZH");

        String string = filename.replace("/", "\\");

        docinfo.setUrlname(string);
        docinfo.setDescription(file.getOriginalFilename());
        docinfoDao.save(docinfo);
        // 4. 2017-12-13  docinfoid与Contentuid一致
        String docinfoid = docinfo.getDocinfoid().toString();
        docinfo.setContentuid(docinfoid);

        Autokey autokey = autokeyDao.find(14l);
        docinfo.setDocument(String.valueOf(autokey.getSeed() + 1l));
        autokey.setSeed(autokey.getSeed() + 1l);
        autokeyDao.update(autokey);

        // 2017-12-13 状态null
        docinfo.setStatus(null);
        return new DocDto(String.valueOf(autokey.getSeed()), Long.valueOf(docinfoid));
    }


    @Override
    public void deleteFile(Long docinfoid) {
        Docinfo docinfo = docinfoDao.find(docinfoid);
        String filePath = docinfo.getUrlname();
        FileUtils.deleteFile(filePath);
        //删除docinfo
        docinfoDao.delete(docinfoid);
        //删除doclink
        Map<String, Object> params = new HashMap<>();
        params.put("docinfoid", docinfoid);
        String where = "docinfoid=:docinfoid";
        List<Doclink> doclinkList = doclinkDao.findAll(where, params, null);
        if (doclinkList.size() > 0) {
            doclinkDao.delete(doclinkList.get(0).getDoclinksid());
        }
    }

    @Override
    public Docinfo getFilePath(Long docinfoid) {
        Map<String, Object> params = new HashMap<>();
        params.put("document", docinfoid.toString());
        String where = "document=:document";
        List<Docinfo> docinfoList = docinfoDao.findAll(where, params, null);

        return docinfoList.get(0);
    }


    @Override
    public List<VDoc> fileAssetList(Asset asset, SessionInfo sessionInfo) {

        String sql = "select * from V_DOC WHERE (ownertable = 'ASSET' and ownerid = :assetuid)\n" +
                "    or (ownertable = 'LOCATIONS' and\n" +
                "       ownerid = (select locationsid\n" +
                "                     from locations\n" +
                "                    where location = :location\n" +
                "                      and siteid = :siteid))\n" +
                "    or (ownertable = 'ITEM' and\n" +
                "       ownerid =\n" +
                "       (select itemid\n" +
                "           from item\n" +
                "          where itemnum = :itemnum\n" +
                "            and itemsetid = :itemsetid\n" +
                "            and itemtype in (select value\n" +
                "                               from synonymdomain\n" +
                "                              where maxvalue = 'ITEM'\n" +
                "                                and domainid = 'ITEMTYPE')))\n" +
                "    or (ownertable = 'TOOLITEM' and\n" +
                "       ownerid =\n" +
                "       (select itemid\n" +
                "           from item\n" +
                "          where itemnum = :itemnum\n" +
                "            and itemsetid = :itemsetid\n" +
                "            and itemtype in (select value\n" +
                "                               from synonymdomain\n" +
                "                              where maxvalue = 'TOOL'\n" +
                "                                and domainid = 'ITEMTYPE')))";

        List<VDoc> vDocs = sessionFactory.getCurrentSession().createSQLQuery(sql).addEntity(VDoc.class)
                .setLong("assetuid", asset.getAssetuid())
                .setString("location", sessionInfo.getLocation())
                .setString("siteid", sessionInfo.getSite())
                .setString("itemnum", asset.getItemnum())
                .setString("itemsetid", asset.getItemsetid())
                .list();

        return vDocs;
    }

    @Override
    public List<VDoc> fileUdtoolList(Long udtoolid, SessionInfo sessionInfo) {
        //ownertable = 'UDTOOL'  and ownerid = :UDTOOLID
        Map<String, Object> params = new HashMap<>();
        params.put("ownertable", "UDTOOL");
        params.put("ownerid", udtoolid);
        String where = "ownertable=:ownertable and ownerid=:ownerid";
        return vDocDao.findAll(where, params, null);
    }

    @Override
    public List<VDoc> fileInventoryList(Inventory inventory, SessionInfo sessionInfo) {
        String sql = "select * from V_DOC WHERE \n" +
                "   (ownertable = 'INVENTORY' and ownerid = :inventoryid) or\n" +
                "       (ownertable = 'ITEM' and\n" +
                "       ownerid = (select itemid\n" +
                "                     from item\n" +
                "                    where itemnum = :itemnum\n" +
                "                      and itemsetid = :itemsetid))\n";
        List<VDoc> vDocs = sessionFactory.getCurrentSession().createSQLQuery(sql).addEntity(VDoc.class)
                .setLong("inventoryid", inventory.getInventoryid())
                .setString("itemnum", inventory.getItemnum())
                .setString("itemsetid", inventory.getItemsetid())
                .list();

        return vDocs;
    }

    @Override
    public List<VDoc> fileInvuseList(Long invuseid, SessionInfo sessionInfo) {
        //ownertable='INVUSE' and ownerid=:invuseid
        Map<String, Object> params = new HashMap<>();
        params.put("ownertable", "INVUSE");
        params.put("ownerid", invuseid);
        String where = "ownertable=:ownertable and ownerid=:ownerid";
        return vDocDao.findAll(where, params, null);
    }


    /**
     * "    or (ownertable = 'CONTRACT' and\n" +
     * "       ownerid = (select contractid\n" +
     * "                     from contract\n" +
     * "                    where contractnum = :contractrefnum\n" +
     * "                      and revisionnum = :contractrefrev\n" +
     * "                      and orgid = :orgid))\n" +
     *
     * @param sessionInfo
     * @return
     */
    @Override
    public List<VDoc> filePoList(Long poid, String vendor, String orgid, String ponum, String siteid, SessionInfo sessionInfo) {

        String sql = "select *\n" +
                "  from V_DOC\n" +
                " WHERE (ownertable = 'PO' and ownerid = :poid)\n" +
                "    or (ownertable = 'COMPANIES' and\n" +
                "       ownerid = (select companiesid\n" +
                "                     from companies\n" +
                "                    where company = :vendor\n" +
                "                      and orgid = :orgid))\n" +
                "    or (ownertable = 'MRLINE' and\n" +
                "       ownerid in (select mrlineid\n" +
                "                      from mrline\n" +
                "                     where mrnum in (select mrnum\n" +
                "                                       from poline\n" +
                "                                      where ponum = :ponum\n" +
                "                                        and siteid = :siteid)))\n" +
                "    or (ownertable = 'PR' and\n" +
                "       ownerid in (select prid\n" +
                "                      from pr\n" +
                "                     where prnum in (select prnum\n" +
                "                                       from prline\n" +
                "                                      where ponum = :ponum\n" +
                "                                        and positeid = :siteid)\n" +
                "                       and siteid = :siteid))\n" +
                "    or (ownertable = 'RFQ' and\n" +
                "       ownerid in (select rfqid\n" +
                "                      from rfq\n" +
                "                     where rfqnum in (select rfqnum\n" +
                "                                        from rfqline\n" +
                "                                       where ponum = :ponum\n" +
                "                                         and siteid = :siteid)))\n";

        List<VDoc> vDocs = sessionFactory.getCurrentSession().createSQLQuery(sql).addEntity(VDoc.class)
                .setLong("poid", poid)
                .setString("vendor", vendor)
                .setString("orgid", orgid)
                // TODO: 2017/10/13 null判断
//                .setString("contractrefnum", po.getContractrefnum())
//                .setInteger("contractrefrev", po.getContractrefrev())
                .setString("ponum", ponum)
                .setString("siteid", siteid)
                .list();

        return vDocs;
    }

    @Override
    public List<VDoc> fileWorkorderList(Long workorderid, String wonum, String assetnum, String location, String siteid, String jpnum, Integer pluscjprevnum, String pmnum, SessionInfo sessionInfo) {
        String sql = "select *\n" +
                "  from V_DOC\n" +
                " WHERE (ownertable = 'WORKORDER' and ownerid = :workorderid)\n" +
                "    or (ownertable = 'WORKORDER' and\n" +
                "       ownerid in (select workorderid\n" +
                "                      from workorder\n" +
                "                     where parent = :wonum\n" +
                "                       and istask = 1\n" +
                "                       and siteid = :siteid))\n" +
                "    or (ownertable = 'ASSET' and\n" +
                "       ownerid in (select assetuid\n" +
                "                      from asset\n" +
                "                     where assetnum = :assetnum\n" +
                "                       and siteid = :siteid))\n" +
                "    or (ownertable = 'LOCATIONS' and\n" +
                "       ownerid in (select locationsid\n" +
                "                      from locations\n" +
                "                     where location = :location\n" +
                "                       and siteid = :siteid))\n" +
                "    or (ownertable = 'JOBPLAN' and\n" +
                "       ownerid in (select jobplanid\n" +
                "                      from jobplan\n" +
                "                     where jpnum = :jpnum\n" +
                "                       and (siteid is null or siteid = :siteid)\n" +
                "                       and pluscrevnum = :pluscjprevnum))\n" +
                "    or (ownertable = 'PM' and\n" +
                "       ownerid in (select pmuid\n" +
                "                      from pm\n" +
                "                     where pmnum = :pmnum\n" +
                "                       and siteid = :siteid))\n" +
                "    or (ownertable = 'SAFETYPLAN' and\n" +
                "       ownerid in\n" +
                "       (select safetyplanuid\n" +
                "           from safetyplan, wosafetyplan\n" +
                "          where safetyplan.safetyplanid = wosafetyplan.safetyplanid\n" +
                "            and wosafetyplan.wonum = :wonum\n" +
                "            and wosafetyplan.siteid = :siteid))\n" +
                "    or (ownertable in ('SR', 'INCIDENT', 'PROBLEM') and\n" +
                "       ownerid in (select ticketuid\n" +
                "                      from ticket, relatedrecord\n" +
                "                     where ticketid = recordkey\n" +
                "                       and ticket.class = relatedrecord.class\n" +
                "                       and relatedrecclass = :woclass\n" +
                "                       and relatedreckey = :wonum\n" +
                "                       and relatedrecsiteid = :siteid))\n" +
                "    or (ownertable in ('WOCHANGE', 'WORELEASE', 'WOACTIVITY') and\n" +
                "       ownerid in (select workorderid\n" +
                "                      from workorder, relatedrecord\n" +
                "                     where wonum = recordkey\n" +
                "                       and workorder.woclass = relatedrecord.class\n" +
                "                       and relatedrecclass = :woclass\n" +
                "                       and relatedreckey = :wonum\n" +
                "                       and relatedrecsiteid = :siteid))\n" +
                "    or (ownertable = 'COMMLOG' and\n" +
                "       ownerid in\n" +
                "       (select commloguid\n" +
                "           from commlog\n" +
                "          where ownerid = :workorderid\n" +
                "            and ownertable in\n" +
                "                (select value from synonymdomain where domainid = 'WOCLASS')))\n" +
                "    or (ownertable = 'SLA' and\n" +
                "       ownerid in (select slaid\n" +
                "                      from sla, slarecords, workorder\n" +
                "                     where sla.slanum = slarecords.slanum\n" +
                "                       and slarecords.ownerid = workorder.workorderid\n" +
                "                       and sla.objectname = 'WORKORDER'\n" +
                "                       and slarecords.ownertable = 'WORKORDER'\n" +
                "                       and workorder.wonum = :wonum))\n";
        List<VDoc> vDocs = sessionFactory.getCurrentSession().createSQLQuery(sql).addEntity(VDoc.class)
                .setLong("workorderid", workorderid)
                .setString("wonum", wonum)
                .setString("siteid", siteid)
                .setString("assetnum", assetnum)
                .setString("location", location)
                .setString("jpnum", jpnum)
                .setInteger("pluscjprevnum", pluscjprevnum)
                .setString("pmnum", pmnum)
                .list();

        return vDocs;

    }

    @Override
    public List<VDoc> fileUdprojectList(Long udprojectid, SessionInfo sessionInfo) {
        //ownertable = 'UDTOOL'  and ownerid = :UDTOOLID
        Map<String, Object> params = new HashMap<>();
        params.put("ownertable", "UDPROJECT");
        params.put("ownerid", udprojectid);
        String where = "ownertable=:ownertable and ownerid=:ownerid";
        return vDocDao.findAll(where, params, null);
    }

    @Override
    public List<VDoc> fileSingledelegateList(Long uddelegateid, SessionInfo sessionInfo) {
        //ownertable = 'UDTOOL'  and ownerid = :UDTOOLID
        Map<String, Object> params = new HashMap<>();
        params.put("ownertable", "UDDELEGATE");
        params.put("ownerid", uddelegateid);
        String where = "ownertable=:ownertable and ownerid=:ownerid";
        return vDocDao.findAll(where, params, null);
    }

    @Override
    public List<VDoc> fileSafecheckList(Long udsafecheckid, SessionInfo sessionInfo) {
        //ownertable = 'UDTOOL'  and ownerid = :UDTOOLID
        Map<String, Object> params = new HashMap<>();
        params.put("ownertable", "UDSAFECHECK");
        params.put("ownerid", udsafecheckid);
        String where = "ownertable=:ownertable and ownerid=:ownerid";
        return vDocDao.findAll(where, params, null);
    }

    @Override
    public List<VDoc> fileSingleprojectinfoList(Long projectinfoid, SessionInfo sessionInfo) {
        //ownertable = 'UDTOOL'  and ownerid = :UDTOOLID
        Map<String, Object> params = new HashMap<>();
        params.put("ownertable", "PROJECTINFO");
        params.put("ownerid", projectinfoid);
        String where = "ownertable=:ownertable and ownerid=:ownerid";
        return vDocDao.findAll(where, params, null);
    }

    @Override
    public List<VDoc> fileOutboxcheckList(Long udoutboxcheckid, SessionInfo sessionInfo) {
        //ownertable = 'UDTOOL'  and ownerid = :UDTOOLID
        Map<String, Object> params = new HashMap<>();
        params.put("ownertable", "UDOUTBOXCHECK");
        params.put("ownerid", udoutboxcheckid);
        String where = "ownertable=:ownertable and ownerid=:ownerid";
        return vDocDao.findAll(where, params, null);
    }

    @Override
    public List<VDoc> fileSingleudsafechecktable2List(Long udsafechecktable2id, SessionInfo sessionInfo) {
        //ownertable = 'UDTOOL'  and ownerid = :UDTOOLID
        Map<String, Object> params = new HashMap<>();
        params.put("ownertable", "UDSAFECHECKTABLE2");
        params.put("ownerid", udsafechecktable2id);
        String where = "ownertable=:ownertable and ownerid=:ownerid";
        return vDocDao.findAll(where, params, null);
    }

    @Override
    public List<VDoc> fileTrainrecordList(Long udtrainrecordid, SessionInfo sessionInfo) {
        //ownertable = 'UDTOOL'  and ownerid = :UDTOOLID
        Map<String, Object> params = new HashMap<>();
        params.put("ownertable", "UDTRAINRECORD");
        params.put("ownerid", udtrainrecordid);
        String where = "ownertable=:ownertable and ownerid=:ownerid";
        return vDocDao.findAll(where, params, null);
    }

    @Override
    public List<VDoc> fileNowcheckList(Long udnowcheckid, SessionInfo sessionInfo) {
        //ownertable = 'UDTOOL'  and ownerid = :UDTOOLID
        Map<String, Object> params = new HashMap<>();
        params.put("ownertable", "UDNOWCHECK");
        params.put("ownerid", udnowcheckid);
        String where = "ownertable=:ownertable and ownerid=:ownerid";
        return vDocDao.findAll(where, params, null);
    }

    @Override
    public List<VDoc> fileProblemmodifyList(Long udproblemmodifyid, SessionInfo sessionInfo) {
        //ownertable = 'UDTOOL'  and ownerid = :UDTOOLID
        Map<String, Object> params = new HashMap<>();
        params.put("ownertable", "UDPROBLEMMODIFY");
        params.put("ownerid", udproblemmodifyid);
        String where = "ownertable=:ownertable and ownerid=:ownerid";
        return vDocDao.findAll(where, params, null);
    }

}
