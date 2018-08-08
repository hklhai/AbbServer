package com.hxqh.abb.service;

import com.hxqh.abb.common.ObjectUtil;
import com.hxqh.abb.common.util.CglibUtil;
import com.hxqh.abb.common.util.GroupListUtil;
import com.hxqh.abb.dao.*;
import com.hxqh.abb.model.Person;
import com.hxqh.abb.model.TbApp;
import com.hxqh.abb.model.base.SessionInfo;
import com.hxqh.abb.model.dto.action.ListDto;
import com.hxqh.abb.model.paperless.*;
import com.hxqh.abb.model.searchdto.Page;
import com.hxqh.abb.model.version2.Autokey;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author fuyg
 * @date 2017-09-26.
 */
@Transactional
@Service("projectService")
public class ProjectServiceImpl implements ProjectService {

    private static Map<String, TbApp> appListMap = new HashMap<>();
    private static Map<String, List<TbApp>> selectionMap = new LinkedHashMap<>();

    @Resource
    protected SessionFactory sessionFactory;
    @Autowired
    private TbAppDao appDao;
    @Autowired
    private PersonDao personDao;
    @Autowired
    private UdprojectDao udprojectDao;
    @Autowired
    private UdprojectlineDao udprojectlineDao;
    @Autowired
    private UdequipmentDao udequipmentDao;
    @Autowired
    private UdcustomerDao udcustomerDao;
    @Autowired
    private UddelegateDao uddelegateDao;
    @Autowired
    private ProjectinfoDao projectinfoDao;
    @Autowired
    private UdsceneservicenotifyDao udsceneservicenotifyDao;
    @Autowired
    private UdpermissionDao udpermissionDao;
    @Autowired
    private UdoutboxcheckDao udoutboxcheckDao;
    @Autowired
    private Udsafechecktable2Dao udsafechecktable2Dao;
    @Autowired
    private UdtrainrecordDao udtrainrecordDao;
    @Autowired
    private UdtrainrecordlineDao udtrainrecordlineDao;
    @Autowired
    private UdentrustoutDao udentrustoutDao;
    @Autowired
    private UdnowcheckDao udnowcheckDao;
    @Autowired
    private UdproblemmodifyDao udproblemmodifyDao;
    @Autowired
    private UdpmlineDao udpmlineDao;
    @Autowired
    private AreaandserviceDao areaandserviceDao;
    @Autowired
    private UdsafecheckDao udsafecheckDao;
    @Autowired
    private UdworkreportDao udworkreportDao;
    @Autowired
    private UdqualificationDao udqualificationDao;
    @Autowired
    private UdchemicalsDao udchemicalsDao;
    @Autowired
    private UdprotectiveDao udprotectiveDao;
    @Autowired
    private UdworkpermitDao udworkpermitDao;
    @Autowired
    private UdtraincontentDao udtraincontentDao;
    @Autowired
    private UdsafemeetingDao udsafemeetingDao;
    @Autowired
    private UdemergencyDao udemergencyDao;
    @Autowired
    private UdsafelineDao udsafelineDao;
    @Autowired
    private UdassignmentriskDao udassignmentriskDao;
    @Autowired
    private UdworkcontentDao udworkcontentDao;
    @Autowired
    private UdnormalserviceDao udnormalserviceDao;
    @Autowired
    private UdsafedefineDao udsafedefineDao;
    @Autowired
    private AutokeyDao autokeyDao;

    @PostConstruct
    public void init() {
        Map<String, Object> params = new HashMap<>();
        params.put("appcontent", "SELECTION");
        String where = "appcontent=:appcontent";
        LinkedHashMap<String, String> orderby = new LinkedHashMap<>();
        orderby.put("ordernum", "asc");
        List<TbApp> appList = appDao.findAll(where, params, orderby);
        //对appList按照APPCONTENT分组
        Map<String, List<TbApp>> allMap = GroupListUtil.group(appList, new GroupListUtil.GroupBy<String>() {
            @Override
            public String groupby(Object obj) {
                TbApp d = (TbApp) obj;
                return d.getAppcontent();    // 分组依据为Appcontent
            }
        });
        //选项
        selectionMap = GroupListUtil.group(allMap.get("SELECTION"), new GroupListUtil.GroupBy<String>() {
            @Override
            public String groupby(Object obj) {
                TbApp d = (TbApp) obj;
                return d.getAppname();   // 分组依据为Appname
            }
        });
        for (TbApp e : appList) {
            if (e.getIspk() == 1 && e.getAppcontent().equals("SELECTION")) {
                appListMap.put(e.getAppname(), e);
            }
        }
    }

    @Override
    public ListDto selectionListData(Page page, String apptname, String searchs, SessionInfo sessionInfo, String whereStr) throws Exception {
        StringBuilder fs = new StringBuilder("");
        Map<String, Object> propertyMap = new LinkedHashMap();
        List<TbApp> dbList = new LinkedList<>();
        dbList = selectionMap.get(apptname);

        String apptable = appListMap.get(apptname).getApptable();
        String pkid = appListMap.get(apptname).getAppfield();
        initPropertyMap(fs, propertyMap, dbList);

        //动态生成类
        CglibUtil bean1 = new CglibUtil(propertyMap);
        Field[] declaredFields = bean1.getObject().getClass().getDeclaredFields();

        String fields = fs.substring(0, fs.length() - 1);
        //查询语句拼接
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append("SELECT * FROM (SELECT inner2_.*,rownumber () over (ORDER BY ORDER of inner2_) AS ROWNUMBER FROM (select ");
        stringBuilder.append(fields);

        StringBuilder noPageBuilder = new StringBuilder("");

        //处理select数据筛选
        if (apptname.equals("SELECTIONLOCATIONS")) {
            noPageBuilder.append(" from ").append(apptable).append(" where 1=1 and type='STOREROOM' ");
        } else {
            noPageBuilder.append(" from ").append(apptable).append(" where 1=1 ");
        }

        selectionWhere(apptname, noPageBuilder,whereStr);

        //查询条件判断是否是空字符串，如果是空字符串不做拼接操作
        String[] searchsStrings = searchs.split(",");
        String[] splitFileds = fields.split(",");
        //拼接
        String initString = fields + ",ROWNUMBER";
        String[] split = initString.split(",");
        if (searchsStrings.length > 0) {
            for (int i = 0; i < searchsStrings.length; i++) {
                if (!"".equals(searchsStrings[i])) {
                    noPageBuilder.append(" and ").append(splitFileds[i]).append("=:").append(splitFileds[i]);
                }
            }
        }

        // 增加库存管理列表筛选
        stringBuilder.append(noPageBuilder);
        stringBuilder.append(" order by ").append(pkid).append(" desc ");//排序
        stringBuilder.append("FETCH FIRST ").append(page.getlastResultNumber(page.getPageNumber(), page.getPageSize()));
        stringBuilder.append(" rows only ) AS inner2_ ) AS inner1_ WHERE ROWNUMBER >= ");
        stringBuilder.append(page.getfirstResultNumber(page.getPageNumber(), page.getPageSize()));
        stringBuilder.append(" ORDER BY ROWNUMBER");

        SQLQuery sqlQuery = sessionFactory.getCurrentSession().createSQLQuery(stringBuilder.toString());

        if (searchsStrings.length > 0) {
            for (int i = 0; i < searchsStrings.length; i++) {
                if (!"".equals(searchsStrings[i])) {
                    sqlQuery.setString(splitFileds[i], searchsStrings[i]);
                }
            }
        }

        List list = new LinkedList<>();
        List<Object[]> nameList = sqlQuery.list();
        for (Object[] o : nameList) {
            CglibUtil bean = new CglibUtil(propertyMap);
            String id = null;
            for (int j = 0; j < split.length; j++) {
                String field = split[j];
                field = field.substring(0, 1).toUpperCase() + field.substring(1);
                String setMethodName = "set" + field;
                Object object = bean.getObject();
                Class[] classes = {declaredFields[j].getType()};
                Method setMethod = object.getClass().getDeclaredMethod(setMethodName, classes);
                //保存当前主键
                if (field.equals(pkid)) {
                    BigInteger bigInteger = (BigInteger) o[j];
                    id = bigInteger.toString();
                }
                if (!setMethodName.contains("ROWNUMBER")) {
                    setMethod.invoke(object, o[j]);
                }
            }
            list.add(bean.getObject());
        }

        //获取总行数
        StringBuilder countSQL = new StringBuilder("");
        countSQL.append("select count(1) as c ").append(noPageBuilder);

        SQLQuery countQuery = sessionFactory.getCurrentSession().createSQLQuery(countSQL.toString());
        for (int i = 0; i < searchsStrings.length; i++) {
            if (!"".equals(searchsStrings[i])) {
                noPageBuilder.append(" and ").append(splitFileds[i]).append("=:").append(splitFileds[i]);
                countQuery.setString(splitFileds[i], searchsStrings[i]);
            }
        }
        Object score = countQuery.addScalar("c", StandardBasicTypes.INTEGER).uniqueResult();
        Integer size = Integer.parseInt(score.toString());
        page.setTotalPageNum(size);
        return new ListDto(list, page);
    }

    private void selectionWhere(String apptname, StringBuilder noPageBuilder, String whereStr) {
        //selection拼接过滤条件  select * from ALNDOMAIN t where t.DOMAINID like 'UDTOOL%'
        if (apptname.equals("SELECTIONUDTOOLTYPE")) {//工具管理--工具种类
            noPageBuilder.append(" and DOMAINID='UDTOOLAPPLY' ");
        } else if (apptname.equals("SELECTIONUDLASTCHKRESULT")) {//工具管理--校准结果（上次校准结果）
            noPageBuilder.append(" and DOMAINID='UDLASTCHKRESULT' ");
        } else if (apptname.equals("SELECTIONINDUSTRYATTRIBUTES")) {//项目管理--行业属性
            noPageBuilder.append(" and DOMAINID='INDUSTRYATTRIBUTES' ");
        } else if (apptname.equals("SELECTIONSERVICEDEP")) {//项目管理--服务事业部
            noPageBuilder.append(" and DOMAINID='SERVICEDEP' ");
        } else if (apptname.equals("SELECTIONUDAREA")) {//项目管理--现场所在区域
            noPageBuilder.append(" and DOMAINID='UDAREA' ");
        } else if (apptname.equals("SELECTIONCUSTOMERNATURE")) {//项目管理--客户性质
            noPageBuilder.append(" and DOMAINID='CUSTOMERNATURE' ");
        } else if (apptname.equals("SELECTIONSERVICENATURE")) {//项目管理--服务性质
            noPageBuilder.append(" and DOMAINID='SERVICENATURE' ");
        }
        if(whereStr!=null&&!whereStr.equals("")){
            String[] strArr = whereStr.split(",");
            for (String whereKey : strArr) {
                //map.keySet()返回的是所有key的值
                if(whereKey!=null&&!whereKey.equals("")){
                    String[] att = whereKey.split(":");
                    if(att.length>1)
                    noPageBuilder.append(" and ").append(att[0]).append("='").append(att[1]).append("' ");
                }
            }
        }
    }

    private void initPropertyMap(StringBuilder fs, Map<String, Object> propertyMap, List<TbApp> dbList) throws ClassNotFoundException {
        for (TbApp app : dbList) {
            //设置值
            propertyMap.put(app.getAppfield(), Class.forName(app.getFieldtype()));
            //获取字段集合
            if (!app.getAppfield().equals("ROWNUMBER")) {
                fs.append(app.getAppfield()).append(",");
            }
            if (app.getIspk() == 1) {
                propertyMap.put("ROWNUMBER", Class.forName("java.lang.Object"));
            }
        }
    }

    @Override
    public Long addUdproject(Udproject udproject, SessionInfo sessionInfo) throws Exception {
        ObjectUtil.setAddBasicData(udproject, sessionInfo);
        udproject.setAppointperson(sessionInfo.getCreate());
        udprojectDao.save(udproject);
        if(udproject.getUdprojectlineList()!=null){
            for (Udprojectline udprojectline : udproject.getUdprojectlineList()) {
                udprojectline.setPronum(udproject.getPronum());
                udprojectline.setSiteid(udproject.getSiteid());
                udprojectlineDao.save(udprojectline);
                List<Udequipment> equipmentList = udprojectline.getUdequipmentList();
                if(equipmentList.size()>0){
                    for (Udequipment udequipment : equipmentList) {
                        udequipment.setPronum(udproject.getPronum());
                        udequipment.setSiteid(udproject.getSiteid());
                        udequipment.setLinenum(udprojectline.getLinenum());
                        ObjectUtil.setAddBasicData(udequipment, sessionInfo);
                        udequipmentDao.save(udequipment);
                    }
                }
                List<Udcustomer> customerList = udprojectline.getUdcustomerList();
                if(customerList.size()>0){
                    for (Udcustomer udcustomer : customerList) {
                        udcustomer.setPronum(udproject.getPronum());
                        udcustomer.setSiteid(udproject.getSiteid());
                        udcustomer.setLinenum(udprojectline.getLinenum());
                        ObjectUtil.setAddBasicData(udcustomer, sessionInfo);
                        udcustomerDao.save(udcustomer);
                    }
                }
            }
        }
        return udproject.getUdprojectid();
    }

    @Override
    public void editUdproject(Udproject udproject, SessionInfo sessionInfo) throws Exception {
        //持久化主表
        Udproject dbObject = udprojectDao.find(udproject.getUdprojectid());
        ObjectUtil.setEditBasicData(udproject, sessionInfo);
        BeanUtils.copyProperties(udproject, dbObject, ObjectUtil.getNullPropertyNames(udproject));
        udprojectDao.update(dbObject);

        //删除从表
        String deletes = udproject.getDeletes();
        if (deletes != null&&!deletes.equals("")) {
            String[] strings = deletes.split(",");
            for (int i = 0; i < strings.length; i++) {
                udprojectlineDao.delete(Long.valueOf(strings[i]));
            }
        }

        //更新或新增从表
        if(udproject.getUdprojectlineList()!=null) {
            for (Udprojectline udprojectline : udproject.getUdprojectlineList()) {
                if (udprojectline.getUdprojectlineid() == null) {
                    udprojectline.setPronum(udproject.getPronum());
                    udprojectline.setSiteid(udproject.getSiteid());
                    ObjectUtil.setAddBasicData(udprojectline, sessionInfo);
                    udprojectlineDao.save(udprojectline);
                    List<Udequipment> equipmentList = udprojectline.getUdequipmentList();
                    if (equipmentList.size() > 0) {
                        for (Udequipment udequipment : equipmentList) {
                            udequipment.setPronum(udproject.getPronum());
                            udequipment.setSiteid(udproject.getSiteid());
                            udequipment.setLinenum(udprojectline.getLinenum());
                            ObjectUtil.setAddBasicData(udequipment, sessionInfo);
                            udequipmentDao.save(udequipment);
                        }
                    }
                    List<Udcustomer> customerList = udprojectline.getUdcustomerList();
                    if (customerList.size() > 0) {
                        for (Udcustomer udcustomer : customerList) {
                            udcustomer.setPronum(udproject.getPronum());
                            udcustomer.setSiteid(udproject.getSiteid());
                            udcustomer.setLinenum(udprojectline.getLinenum());
                            ObjectUtil.setAddBasicData(udcustomer, sessionInfo);
                            udcustomerDao.save(udcustomer);
                        }
                    }
                } else {
                    Map<String, Object> lineparams = new HashMap<>();
                    lineparams.put("pronum", udproject.getPronum());
                    lineparams.put("siteid", udproject.getSiteid());
                    String linewhere = "pronum=:pronum and siteid=:siteid";
                    List<Udprojectline> udprojectlineList = udprojectlineDao.findAll(linewhere, lineparams, null);
                    Map<Long, Udprojectline> udprojectlineMap = udprojectlineList.stream().collect(
                            Collectors.toMap(Udprojectline::getUdprojectlineid, a -> a, (k1, k2) -> k1)
                    );
                    Udprojectline linedbobject = udprojectlineMap.get(udprojectline.getUdprojectlineid());
                    //已删除
                    if(linedbobject==null){
                        continue;
                    }
                    BeanUtils.copyProperties(udprojectline, linedbobject, ObjectUtil.getNullPropertyNames(udprojectline));
                    //ObjectUtil.setEditBasicData(udprojectline, sessionInfo);
                    udprojectlineDao.update(linedbobject);
                    //删除从表Udequipment
                    String udequipmentdeletes = udprojectline.getUdequipmentdeletes();
                    if (udequipmentdeletes != null&&!udequipmentdeletes.equals("")) {
                        String[] strings = udequipmentdeletes.split(",");
                        for (int i = 0; i < strings.length; i++) {
                            udequipmentDao.delete(Long.valueOf(strings[i]));
                        }
                    }
                    //删除从表Udcustomer
                    String udcustomerdeletes = udprojectline.getUdcustomerdeletes();
                    if (udcustomerdeletes != null&&!udcustomerdeletes.equals("")) {
                        String[] strings = udcustomerdeletes.split(",");
                        for (int i = 0; i < strings.length; i++) {
                            udcustomerDao.delete(Long.valueOf(strings[i]));
                        }
                    }
                    Map<String, Object> params = new HashMap<>();
                    params.put("pronum", udprojectline.getPronum());
                    params.put("linenum", udprojectline.getLinenum());
                    params.put("siteid", udprojectline.getSiteid());
                    String where = "pronum=:pronum and linenum=:linenum and siteid=:siteid";
                    //更新或新增从表Udequipment
                    List<Udequipment> equipmentList = udprojectline.getUdequipmentList();
                    if (equipmentList.size() > 0) {
                        for (Udequipment udequipment : equipmentList) {
                            if (udequipment.getUdequipmentid() == null) {
                                udequipment.setPronum(udproject.getPronum());
                                udequipment.setSiteid(udproject.getSiteid());
                                udequipment.setLinenum(udprojectline.getLinenum());
                                ObjectUtil.setAddBasicData(udequipment, sessionInfo);
                                udequipmentDao.save(udequipment);
                            } else {
                                List<Udequipment> udequipmentList = udequipmentDao.findAll(where, params, null);
                                Map<Long, Udequipment> udequipmentMap = udequipmentList.stream().collect(
                                        Collectors.toMap(Udequipment::getUdequipmentid, a -> a, (k1, k2) -> k1)
                                );
                                Udequipment dbobject = udequipmentMap.get(udequipment.getUdequipmentid());
                                //已删除
                                if(dbobject==null){
                                    continue;
                                }
                                BeanUtils.copyProperties(udequipment, dbobject, ObjectUtil.getNullPropertyNames(udequipment));
                                ObjectUtil.setEditBasicData(udequipment, sessionInfo);
                                udequipmentDao.update(dbobject);
                            }

                        }
                    }
                    //更新或新增从表Udcustomer
                    List<Udcustomer> customerList = udprojectline.getUdcustomerList();
                    if (customerList.size() > 0) {
                        for (Udcustomer udcustomer : customerList) {
                            if (udcustomer.getUdcustomerid() == null) {
                                udcustomer.setPronum(udproject.getPronum());
                                udcustomer.setSiteid(udproject.getSiteid());
                                udcustomer.setLinenum(udprojectline.getLinenum());
                                ObjectUtil.setAddBasicData(udcustomer, sessionInfo);
                                udcustomerDao.save(udcustomer);
                            } else {
                                List<Udcustomer> udcustomerList = udcustomerDao.findAll(where, params, null);
                                Map<Long, Udcustomer> udcustomerMap = udcustomerList.stream().collect(
                                        Collectors.toMap(Udcustomer::getUdcustomerid, a -> a, (k1, k2) -> k1)
                                );
                                Udcustomer dbobject = udcustomerMap.get(udcustomer.getUdcustomerid());
                                //已删除
                                if(dbobject==null){
                                    continue;
                                }
                                BeanUtils.copyProperties(udcustomer, dbobject, ObjectUtil.getNullPropertyNames(udcustomer));
                                ObjectUtil.setEditBasicData(udcustomer, sessionInfo);
                                udcustomerDao.update(dbobject);
                            }
                        }
                    }
                }
            }
        }
    }

    /*
    * 委派单
    * */
    @Override
    public Long addUddelegate(Uddelegate uddelegate, SessionInfo sessionInfo) throws Exception {
        //新建保存主表
        ObjectUtil.setAddBasicData(uddelegate, sessionInfo);

        Map<String, Object> params = new HashMap<>();
        String uddelegateNum = "101";
        String likeCoding = "WP-"+uddelegate.getPronum()+"-"+uddelegate.getLinenum()+"-"+uddelegate.getNumber()+"-";
        params.put("coding", likeCoding);
        String where = "coding like :coding||'%'";
        LinkedHashMap<String, String> orderby = new LinkedHashMap<>();
        orderby.put("coding", "desc");
        List<Uddelegate> uddelegateList = uddelegateDao.findAll(where, params, orderby);
        if(uddelegateList.size()>0){
            String maxnum = uddelegateList.get(0).getCoding();
            String[] maxnumStr = maxnum.split("-");
            if(maxnumStr.length>4){
                int max = Integer.valueOf(maxnumStr[4])+1;
                uddelegateNum = max+"";
            }
        }
        uddelegate.setCoding(likeCoding+uddelegateNum);

        uddelegateDao.save(uddelegate);
        return uddelegate.getUddelegateid();
    }

    @Override
    public void editUddelegate(Uddelegate uddelegate, SessionInfo sessionInfo) throws Exception {
        //编辑保存主表
        Uddelegate dbObject = uddelegateDao.find(uddelegate.getUddelegateid());
        ObjectUtil.setEditBasicData(dbObject, sessionInfo);
        BeanUtils.copyProperties(uddelegate, dbObject, ObjectUtil.getNullPropertyNames(uddelegate));
        uddelegateDao.update(dbObject);
    }

    /*
    * 现场服务联络函
    * */
    @Override
    public Long addProjectinfo(Projectinfo projectinfo, SessionInfo sessionInfo) throws Exception {
        //新建保存主表
        ObjectUtil.setAddBasicData(projectinfo, sessionInfo);

        Autokey autokey = autokeyDao.find(339l);
        projectinfo.setNumber(String.valueOf(autokey.getSeed() + 1l));
        autokey.setSeed(autokey.getSeed() + 1l);
        autokeyDao.update(autokey);

        projectinfoDao.save(projectinfo);
        return projectinfo.getProjectinfoid();
    }

    @Override
    public void editProjectinfo(Projectinfo projectinfo, SessionInfo sessionInfo) throws Exception {
        //编辑保存主表
        Projectinfo dbObject = projectinfoDao.find(projectinfo.getProjectinfoid());
        ObjectUtil.setEditBasicData(dbObject, sessionInfo);
        BeanUtils.copyProperties(projectinfo, dbObject, ObjectUtil.getNullPropertyNames(projectinfo));
        projectinfoDao.update(dbObject);
    }

    /*
    * 项目现场服务安全工作许可单
    * */
    @Override
    public Long addUdpermission(Udpermission udpermission, SessionInfo sessionInfo) throws Exception {
        //新建保存主表
        ObjectUtil.setAddBasicData(udpermission, sessionInfo);

        Map<String, Object> params = new HashMap<>();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
        String nowDate = sdf.format(new Date());
        String personReviation = "MAX";
        Map<String, Object> personParams = new HashMap<>();
        personParams.put("personid", sessionInfo.getCreate());
        Person person = personDao.findAll("personid=:personid", personParams, null).get(0);
        if(person!=null&&person.getSuoxie()!=null&&!person.getSuoxie().equals("")){
            personReviation = person.getSuoxie();
        }
        String uddelegateNum = "101";
        String likeCoding = "PTW-"+udpermission.getPronum()+"-"+udpermission.getLinenum()+"-"+nowDate+"-"+personReviation+"-";
        params.put("coding", likeCoding);
        String where = "coding like :coding||'%'";
        LinkedHashMap<String, String> orderby = new LinkedHashMap<>();
        orderby.put("coding", "desc");
        List<Uddelegate> uddelegateList = uddelegateDao.findAll(where, params, orderby);
        if(uddelegateList.size()>0){
            String maxnum = uddelegateList.get(0).getCoding();
            String[] maxnumStr = maxnum.split("-");
            if(maxnumStr.length>4){
                int max = Integer.valueOf(maxnumStr[4])+1;
                uddelegateNum = max+"";
            }
        }
        udpermission.setCoding(likeCoding+uddelegateNum);

        udpermissionDao.save(udpermission);
        return udpermission.getUdpermissionid();
    }

    @Override
    public void editUdpermission(Udpermission udpermission, SessionInfo sessionInfo) throws Exception {
        //编辑保存主表
        Udpermission dbObject = udpermissionDao.find(udpermission.getUdpermissionid());
        ObjectUtil.setEditBasicData(dbObject, sessionInfo);
        BeanUtils.copyProperties(udpermission, dbObject, ObjectUtil.getNullPropertyNames(udpermission));
        udpermissionDao.update(dbObject);
    }

    /*
     * 现场服务安全检查
     * */
    @Override
    public Long addUdsafechecktable2(Udsafechecktable2 udsafechecktable2, SessionInfo sessionInfo) throws Exception {
        //新建保存主表
        ObjectUtil.setAddBasicData(udsafechecktable2, sessionInfo);
        Long checkresult = udsafechecktable2.getCheckresult();
        if(checkresult!=null&&checkresult==1){
            udsafechecktable2.setCheckman(sessionInfo.getCreate());
            udsafechecktable2.setCheckdate(new Date());
        }
        Autokey autokey = autokeyDao.find(339l);
        udsafechecktable2.setNumber(String.valueOf(autokey.getSeed() + 1l));
        autokey.setSeed(autokey.getSeed() + 1l);
        autokeyDao.update(autokey);

        udsafechecktable2Dao.save(udsafechecktable2);
        return udsafechecktable2.getUdsafechecktable2id();
    }

    @Override
    public void editUdsafechecktable2(Udsafechecktable2 udsafechecktable2, SessionInfo sessionInfo) throws Exception {
        //编辑保存主表
        Udsafechecktable2 dbObject = udsafechecktable2Dao.find(udsafechecktable2.getUdsafechecktable2id());
        Long checkresult = udsafechecktable2.getCheckresult();
        if(checkresult!=null&&checkresult==1){
            udsafechecktable2.setCheckman(sessionInfo.getCreate());
            udsafechecktable2.setCheckdate(new Date());
        }else{

        }
        ObjectUtil.setEditBasicData(dbObject, sessionInfo);
        BeanUtils.copyProperties(udsafechecktable2, dbObject, ObjectUtil.getNullPropertyNames(udsafechecktable2));
        udsafechecktable2Dao.update(dbObject);
    }

    /*
     * 现场设备委托开箱
     * */
    @Override
    public Long addUdentrustout(Udentrustout udentrustout, SessionInfo sessionInfo) throws Exception {
        //新建保存主表
        ObjectUtil.setAddBasicData(udentrustout, sessionInfo);

        Autokey autokey = autokeyDao.find(339l);
        udentrustout.setNumber(String.valueOf(autokey.getSeed() + 1l));
        autokey.setSeed(autokey.getSeed() + 1l);
        autokeyDao.update(autokey);

        udentrustoutDao.save(udentrustout);
        return udentrustout.getUdentrustoutid();
    }

    @Override
    public void editUdentrustout(Udentrustout udentrustout, SessionInfo sessionInfo) throws Exception {
        //编辑保存主表
        Udentrustout dbObject = udentrustoutDao.find(udentrustout.getUdentrustoutid());
        ObjectUtil.setEditBasicData(dbObject, sessionInfo);
        BeanUtils.copyProperties(udentrustout, dbObject, ObjectUtil.getNullPropertyNames(udentrustout));
        udentrustoutDao.update(dbObject);
    }

    @Override
    public Long addUdsceneservicenotify(Udsceneservicenotify udsceneservicenotify, SessionInfo sessionInfo) throws Exception {
        String isMainTab = udsceneservicenotify.getMaintab();
        ObjectUtil.setAddBasicData(udsceneservicenotify, sessionInfo);

        Autokey autokey = autokeyDao.find(339l);
        udsceneservicenotify.setNumber(String.valueOf(autokey.getSeed() + 1l));
        autokey.setSeed(autokey.getSeed() + 1l);
        autokeyDao.update(autokey);

        udsceneservicenotifyDao.save(udsceneservicenotify);
        return udsceneservicenotify.getUdid();
    }

    @Override
    public void editUdsceneservicenotify(Udsceneservicenotify udsceneservicenotify, SessionInfo sessionInfo) throws Exception {
        //修改主表
        Udsceneservicenotify dbObject = udsceneservicenotifyDao.find(udsceneservicenotify.getUdid());
        ObjectUtil.setEditBasicData(dbObject, sessionInfo);
        String[] nullfeild = ObjectUtil.getNullPropertyNames(udsceneservicenotify);
        BeanUtils.copyProperties(udsceneservicenotify, dbObject, ObjectUtil.getNullPropertyNames(udsceneservicenotify));
        udsceneservicenotifyDao.update(dbObject);
    }

    @Override
    public Long addUdoutboxcheck(Udoutboxcheck udoutboxcheck, SessionInfo sessionInfo) throws Exception {
        ObjectUtil.setAddBasicData(udoutboxcheck, sessionInfo);

        Autokey autokey = autokeyDao.find(339l);
        udoutboxcheck.setNumber(String.valueOf(autokey.getSeed() + 1l));
        autokey.setSeed(autokey.getSeed() + 1l);
        autokeyDao.update(autokey);

        udoutboxcheckDao.save(udoutboxcheck);
        return udoutboxcheck.getUdoutboxcheckid();
    }

    @Override
    public void editUdoutboxcheck(Udoutboxcheck udoutboxcheck, SessionInfo sessionInfo) throws Exception {
        //修改主表
        Udoutboxcheck dbObject = udoutboxcheckDao.find(udoutboxcheck.getUdoutboxcheckid());
        ObjectUtil.setEditBasicData(dbObject, sessionInfo);
        String[] nullfeild = ObjectUtil.getNullPropertyNames(udoutboxcheck);
        BeanUtils.copyProperties(udoutboxcheck, dbObject, ObjectUtil.getNullPropertyNames(udoutboxcheck));
        udoutboxcheckDao.update(dbObject);
    }

    @Override
    public Long addUdtrainrecord(Udtrainrecord udtrainrecord, SessionInfo sessionInfo) throws Exception {
        ObjectUtil.setAddBasicData(udtrainrecord, sessionInfo);
        udtrainrecord.setCreator(sessionInfo.getDisplayname());
        //设置自增编号
        Autokey autokey = autokeyDao.find(339l);
        udtrainrecord.setNumber(String.valueOf(autokey.getSeed() + 1l));
        autokey.setSeed(autokey.getSeed() + 1l);
        autokeyDao.update(autokey);

        udtrainrecordDao.save(udtrainrecord);
        if (null != udtrainrecord.getUdtrainrecordlineList()) {
            for (Udtrainrecordline udtrainrecordline : udtrainrecord.getUdtrainrecordlineList()) {
                udtrainrecordline.setUdtrainrecordid(udtrainrecord.getUdtrainrecordid());
                ObjectUtil.setAddBasicData(udtrainrecordline, sessionInfo);
                udtrainrecordlineDao.save(udtrainrecordline);
            }
        }
        return udtrainrecord.getUdtrainrecordid();
    }

    @Override
    public void editUdtrainrecord(Udtrainrecord udtrainrecord, SessionInfo sessionInfo) throws Exception {
        //修改主表
        Udtrainrecord dbObject = udtrainrecordDao.find(udtrainrecord.getUdtrainrecordid());
        ObjectUtil.setEditBasicData(dbObject, sessionInfo);
        String[] nullfeild = ObjectUtil.getNullPropertyNames(udtrainrecord);
        BeanUtils.copyProperties(udtrainrecord, dbObject, ObjectUtil.getNullPropertyNames(udtrainrecord));
        udtrainrecordDao.update(dbObject);

        //删除
        if (null != udtrainrecord.getDeletes() && !udtrainrecord.getDeletes().equals("")) {
            String[] strings = udtrainrecord.getDeletes().split(",");
            for (int i = 0; i < strings.length; i++) {
                udtrainrecordlineDao.delete(Long.valueOf(strings[i]));
            }
        }

        Map<String, Object> params = new HashMap<>();
        params.put("udtrainrecordid", udtrainrecord.getUdtrainrecordid());
        String where = "udtrainrecordid=:udtrainrecordid";
        List<Udtrainrecordline> UdtrainrecordlineList = udtrainrecordlineDao.findAll(where, params, null);
        Map<Long, Udtrainrecordline> udtrainrecordlineMap = UdtrainrecordlineList.stream().collect(
                Collectors.toMap(Udtrainrecordline::getUdtrainrecordlineid, a -> a, (k1, k2) -> k1)
        );

        if (null != udtrainrecord.getUdtrainrecordlineList()) {
            for (Udtrainrecordline udtrainrecordline : udtrainrecord.getUdtrainrecordlineList()) {
                if (null != udtrainrecordline.getUdtrainrecordlineid()) {
                    Udtrainrecordline dbobject = udtrainrecordlineMap.get(udtrainrecordline.getUdtrainrecordlineid());
                    if(dbobject==null){
                        continue;
                    }
                    BeanUtils.copyProperties(udtrainrecordline, dbobject, ObjectUtil.getNullPropertyNames(udtrainrecordline));
                    ObjectUtil.setEditBasicData(udtrainrecordline, sessionInfo);
                    udtrainrecordlineDao.update(dbobject);
                } else {
                    udtrainrecordline.setUdtrainrecordid(udtrainrecord.getUdtrainrecordid());
                    ObjectUtil.setAddBasicData(udtrainrecordline, sessionInfo);
                    udtrainrecordlineDao.save(udtrainrecordline);
                }
            }
        }
    }

    @Override
    public Long addUdnowcheck(Udnowcheck udnowcheck, SessionInfo sessionInfo) throws Exception {
        ObjectUtil.setAddBasicData(udnowcheck, sessionInfo);
        //设置自增编号
        Autokey autokey = autokeyDao.find(339l);
        udnowcheck.setNumber(String.valueOf(autokey.getSeed() + 1l));
        autokey.setSeed(autokey.getSeed() + 1l);
        autokeyDao.update(autokey);

        udnowcheckDao.save(udnowcheck);
        return udnowcheck.getUdnowcheckid();
    }

    @Override
    public void editUdnowcheck(Udnowcheck udnowcheck, SessionInfo sessionInfo) throws Exception {
        //修改主表
        Udnowcheck dbObject = udnowcheckDao.find(udnowcheck.getUdnowcheckid());
        ObjectUtil.setEditBasicData(dbObject, sessionInfo);
        String[] nullfeild = ObjectUtil.getNullPropertyNames(udnowcheck);
        BeanUtils.copyProperties(udnowcheck, dbObject, ObjectUtil.getNullPropertyNames(udnowcheck));
        udnowcheckDao.update(dbObject);
    }

    @Override
    public Long addUdproblemmodify(Udproblemmodify udproblemmodify, SessionInfo sessionInfo) throws Exception {
        ObjectUtil.setAddBasicData(udproblemmodify, sessionInfo);
        udproblemmodify.setCreator(sessionInfo.getDisplayname());
        //设置自增编号
        Autokey autokey = autokeyDao.find(339l);
        udproblemmodify.setNumber(String.valueOf(autokey.getSeed() + 1l));
        autokey.setSeed(autokey.getSeed() + 1l);
        autokeyDao.update(autokey);

        udproblemmodifyDao.save(udproblemmodify);
        if (udproblemmodify.getUdpmlineList()!=null) {
            for (Udpmline udpmline : udproblemmodify.getUdpmlineList()) {
                udpmline.setUdproblemmodifyid(udproblemmodify.getUdproblemmodifyid());
                ObjectUtil.setAddBasicData(udpmline, sessionInfo);
                udpmlineDao.save(udpmline);
            }
        }
        return udproblemmodify.getUdproblemmodifyid();
    }

    @Override
    public void editUdproblemmodify(Udproblemmodify udproblemmodify, SessionInfo sessionInfo) throws Exception {
        //修改主表
        Udproblemmodify dbObject = udproblemmodifyDao.find(udproblemmodify.getUdproblemmodifyid());
        ObjectUtil.setEditBasicData(dbObject, sessionInfo);
        String[] nullfeild = ObjectUtil.getNullPropertyNames(udproblemmodify);
        BeanUtils.copyProperties(udproblemmodify, dbObject, ObjectUtil.getNullPropertyNames(udproblemmodify));
        udproblemmodifyDao.update(dbObject);

        //删除
        if (udproblemmodify.getDeletes()!=null&&!udproblemmodify.getDeletes().equals("")) {
            String[] strings = udproblemmodify.getDeletes().split(",");
            for (int i = 0; i < strings.length; i++) {
                udpmlineDao.delete(Long.valueOf(strings[i]));
            }
        }

        Map<String, Object> params = new HashMap<>();
        params.put("udproblemmodifyid", udproblemmodify.getUdproblemmodifyid());
        String where = "udproblemmodifyid=:udproblemmodifyid";
        List<Udpmline> udpmlineList = udpmlineDao.findAll(where, params, null);
        Map<Long, Udpmline> udpmlineMap = udpmlineList.stream().collect(
                Collectors.toMap(Udpmline::getUdpmlineid, a -> a, (k1, k2) -> k1)
        );

        if (null != udproblemmodify.getUdpmlineList()) {
            for (Udpmline udpmline : udproblemmodify.getUdpmlineList()) {
                if (udpmline.getUdpmlineid()!=null) {
                    Udpmline dbobject = udpmlineMap.get(udpmline.getUdpmlineid());
                    if(dbobject==null){
                        continue;
                    }
                    BeanUtils.copyProperties(udpmline, dbobject, ObjectUtil.getNullPropertyNames(udpmline));
                    ObjectUtil.setEditBasicData(udpmline, sessionInfo);
                    udpmlineDao.update(dbobject);
                } else {
                    udpmline.setUdproblemmodifyid(udproblemmodify.getUdproblemmodifyid());
                    ObjectUtil.setAddBasicData(udpmline, sessionInfo);
                    udpmlineDao.save(udpmline);
                }
            }
        }
    }

    @Override
    public Long addAreaandservice(Areaandservice areaandservice, SessionInfo sessionInfo) throws Exception {
        //String isMainTab = udoutboxcheck.getMaintab();
        ObjectUtil.setAddBasicData(areaandservice, sessionInfo);
        areaandserviceDao.save(areaandservice);
        return areaandservice.getAreaandserviceid();
    }

    @Override
    public void editAreaandservice(Areaandservice areaandservice, SessionInfo sessionInfo) throws Exception {
        //修改主表
        Areaandservice dbObject = areaandserviceDao.find(areaandservice.getAreaandserviceid());
        ObjectUtil.setEditBasicData(dbObject, sessionInfo);
        String[] nullfeild = ObjectUtil.getNullPropertyNames(areaandservice);
        BeanUtils.copyProperties(areaandservice, dbObject, ObjectUtil.getNullPropertyNames(areaandservice));
        areaandserviceDao.update(dbObject);
    }

    @Override
    public Long addUdworkreport(Udworkreport udworkreport, SessionInfo sessionInfo) throws Exception {
        ObjectUtil.setAddBasicData(udworkreport, sessionInfo);
        udworkreport.setCreator(sessionInfo.getDisplayname());

        Map<String, Object> params = new HashMap<>();
        String udworkreportNum = "101";
        String likeNumber = "WR-"+udworkreport.getPronum()+"-"+udworkreport.getLinenum()+"-";
        params.put("number", likeNumber);
        String where = "number like :number||'%'";
        LinkedHashMap<String, String> orderby = new LinkedHashMap<>();
        orderby.put("number", "desc");
        List<Udworkreport> udworkreportList = udworkreportDao.findAll(where, params, orderby);
        if(udworkreportList.size()>0){
            String maxnum = udworkreportList.get(0).getNumber();
            String[] maxnumStr = maxnum.split("-");
            if(maxnumStr.length>3){
                int max = Integer.valueOf(maxnumStr[3])+1;
                udworkreportNum = max+"";
            }
        }
        udworkreport.setNumber(likeNumber+udworkreportNum);

        udworkreportDao.save(udworkreport);
        if (null != udworkreport.getUdworkcontentList()) {
            for (Udworkcontent udworkcontent : udworkreport.getUdworkcontentList()) {
                udworkcontent.setUdworkreportnum(String.valueOf(udworkreport.getUdworkreportid()));
                ObjectUtil.setAddBasicData(udworkcontent, sessionInfo);
                udworkcontentDao.save(udworkcontent);
            }
        }
        if (null != udworkreport.getUdnormalserviceList()) {
            for (Udnormalservice udnormalservice : udworkreport.getUdnormalserviceList()) {
                udnormalservice.setUdworkreportid(String.valueOf(udworkreport.getUdworkreportid()));
                ObjectUtil.setAddBasicData(udnormalservice, sessionInfo);
                udnormalserviceDao.save(udnormalservice);
            }
        }
        return udworkreport.getUdworkreportid();
    }

    @Override
    public void editUdworkreport(Udworkreport udworkreport, SessionInfo sessionInfo) throws Exception {
        //修改主表
        Udworkreport dbObject = udworkreportDao.find(udworkreport.getUdworkreportid());
        ObjectUtil.setEditBasicData(dbObject, sessionInfo);

//        Map<String, Object> udworkreportParams = new HashMap<>();
//        String udworkreportNum = "101";
//        String likeNumber = "WR-"+udworkreport.getPronum()+"-"+udworkreport.getLinenum()+"-";
//        udworkreportParams.put("number", likeNumber);
//        String where = "number like :number||'%'";
//        LinkedHashMap<String, String> orderby = new LinkedHashMap<>();
//        orderby.put("number", "desc");
//        List<Udworkreport> udworkreportList = udworkreportDao.findAll(where, udworkreportParams, orderby);
//        if(udworkreportList.size()>0){
//            String maxnum = udworkreportList.get(0).getNumber();
//            String[] maxnumStr = maxnum.split("-");
//            if(maxnumStr.length>3){
//                int max = Integer.valueOf(maxnumStr[3])+1;
//                udworkreportNum = max+"";
//            }
//        }
//        udworkreport.setNumber(likeNumber+udworkreportNum);

        BeanUtils.copyProperties(udworkreport, dbObject, ObjectUtil.getNullPropertyNames(udworkreport));
        udworkreportDao.update(dbObject);

        Map<String, Object> params = new HashMap<>();
        params.put("udworkreportid", String.valueOf(udworkreport.getUdworkreportid()));
        params.put("siteid", udworkreport.getSiteid());

        //删除
        String deletes = udworkreport.getDeletes();
        if (deletes!=null&&!deletes.equals("")) {
            String[] appDeletes = deletes.split(";");
            for (int i = 0; i < appDeletes.length; i++) {
                String tableName = appDeletes[i].split(":")[0];
                if (tableName.equals("UDWORKCONTENT")) { //工作报告UDWORKCONTENT
                    String[] split = appDeletes[i].split(":")[1].split(",");
                    for (int j = 0; j < split.length; j++) {
                        udworkcontentDao.delete(Long.valueOf(split[j]));
                    }
                } else if (tableName.equals("UDNORMALSERVICE")) { //正常服务UDNORMALSERVICE
                    String[] split = appDeletes[i].split(":")[1].split(",");
                    for (int j = 0; j < split.length; j++) {
                        udnormalserviceDao.delete(Long.valueOf(split[j]));
                    }
                }
            }
        }
        //保存
        String where_w = "udworkreportnum=:udworkreportid and siteid=:siteid";
        List<Udworkcontent> udworkcontentList = udworkcontentDao.findAll(where_w, params, null);
        Map<Long, Udworkcontent> udworkcontentMap = udworkcontentList.stream().collect(
                Collectors.toMap(Udworkcontent::getUdworkcontentid, a -> a, (k1, k2) -> k1)
        );
        if (null != udworkreport.getUdworkcontentList()) {
            for (Udworkcontent udworkcontent : udworkreport.getUdworkcontentList()) {
                if (null != udworkcontent.getUdworkcontentid()) {
                    Udworkcontent dbobject = udworkcontentMap.get(udworkcontent.getUdworkcontentid());
                    if(dbobject==null){
                        continue;
                    }
                    BeanUtils.copyProperties(udworkcontent, dbobject, ObjectUtil.getNullPropertyNames(udworkcontent));
                    ObjectUtil.setEditBasicData(udworkcontent, sessionInfo);
                    udworkcontentDao.update(dbobject);
                } else {
                    udworkcontent.setUdworkreportnum(String.valueOf(udworkreport.getUdworkreportid()));
                    ObjectUtil.setAddBasicData(udworkcontent, sessionInfo);
                    udworkcontentDao.save(udworkcontent);
                }
            }
        }

        //保存
        String where_n = "udworkreportid=:udworkreportid and siteid=:siteid";
        List<Udnormalservice> udnormalserviceList = udnormalserviceDao.findAll(where_n, params, null);
        Map<Long, Udnormalservice> udnormalserviceMap = udnormalserviceList.stream().collect(
                Collectors.toMap(Udnormalservice::getUdnormalid, a -> a, (k1, k2) -> k1)
        );
        if (null != udworkreport.getUdnormalserviceList()) {
            for (Udnormalservice udnormalservice : udworkreport.getUdnormalserviceList()) {
                if (null != udnormalservice.getUdnormalid()) {
                    Udnormalservice dbobject = udnormalserviceMap.get(udnormalservice.getUdnormalid());
                    if(dbobject==null){
                        continue;
                    }
                    BeanUtils.copyProperties(udnormalservice, dbobject, ObjectUtil.getNullPropertyNames(udnormalservice));
                    ObjectUtil.setEditBasicData(udnormalservice, sessionInfo);
                    udnormalserviceDao.update(dbobject);
                } else {
                    udnormalservice.setUdworkreportid(String.valueOf(udworkreport.getUdworkreportid()));
                    ObjectUtil.setAddBasicData(udnormalservice, sessionInfo);
                    udnormalserviceDao.save(udnormalservice);
                }
            }
        }
    }

    @Override
    public Long addUdsafecheck(Udsafecheck udsafecheck, SessionInfo sessionInfo) throws Exception {
        ObjectUtil.setAddBasicData(udsafecheck, sessionInfo);

        Autokey autokey = autokeyDao.find(277l);
        udsafecheck.setScnum(String.valueOf(autokey.getSeed() + 1l));
        autokey.setSeed(autokey.getSeed() + 1l);
        autokeyDao.update(autokey);

        udsafecheckDao.save(udsafecheck);
        //人员资质与能力
        if (null != udsafecheck.getUdqualificationList()) {
            for (Udqualification udqualification : udsafecheck.getUdqualificationList()) {
                udqualification.setScnum(udsafecheck.getScnum());
                ObjectUtil.setAddBasicData(udqualification, sessionInfo);
                udqualificationDao.save(udqualification);
            }
        }
        //化学品
        if (null != udsafecheck.getUdchemicalsList()) {
            for (Udchemicals udchemicals : udsafecheck.getUdchemicalsList()) {
                udchemicals.setScnum(udsafecheck.getScnum());
                ObjectUtil.setAddBasicData(udchemicals, sessionInfo);
                udchemicalsDao.save(udchemicals);
            }
        }
        //个人防护装备及安全用具
        if (null != udsafecheck.getUdprotectiveList()) {
            for (Udprotective udprotective : udsafecheck.getUdprotectiveList()) {
                udprotective.setScnum(udsafecheck.getScnum());
                ObjectUtil.setAddBasicData(udprotective, sessionInfo);
                udprotectiveDao.save(udprotective);
            }
        }
        //项目工作安全许可要求
        if (null != udsafecheck.getUdworkpermitList()) {
            for (Udworkpermit udworkpermit : udsafecheck.getUdworkpermitList()) {
                udworkpermit.setScnum(udsafecheck.getScnum());
                ObjectUtil.setAddBasicData(udworkpermit, sessionInfo);
                udworkpermitDao.save(udworkpermit);
            }
        }
        //现场安全培训
        if (null != udsafecheck.getUdtraincontentList()) {
            for (Udtraincontent udtraincontent : udsafecheck.getUdtraincontentList()) {
                udtraincontent.setScnum(udsafecheck.getScnum());
                ObjectUtil.setAddBasicData(udtraincontent, sessionInfo);
                udtraincontentDao.save(udtraincontent);
            }
        }
        //安全会议
        if (null != udsafecheck.getUdsafemeetingList()) {
            for (Udsafemeeting udsafemeeting : udsafecheck.getUdsafemeetingList()) {
                udsafemeeting.setScnum(udsafecheck.getScnum());
                ObjectUtil.setAddBasicData(udsafemeeting, sessionInfo);
                udsafemeetingDao.save(udsafemeeting);
            }
        }
        //急救物品
        if (null != udsafecheck.getUdemergencyList()) {
            for (Udemergency udemergency : udsafecheck.getUdemergencyList()) {
                udemergency.setScnum(udsafecheck.getScnum());
                ObjectUtil.setAddBasicData(udemergency, sessionInfo);
                udemergencyDao.save(udemergency);
            }
        }
        //作业风险及项目特殊风险
        if (null != udsafecheck.getUdassignmentriskList()) {
            for (Udassignmentrisk udassignmentrisk : udsafecheck.getUdassignmentriskList()) {
                udassignmentrisk.setScnum(udsafecheck.getScnum());
                ObjectUtil.setAddBasicData(udassignmentrisk, sessionInfo);
                udassignmentriskDao.save(udassignmentrisk);
            }
        }
        //开关柜检查及保养
        if (null != udsafecheck.getUdsafelinecList()) {
            for (Udsafeline udsafeline : udsafecheck.getUdsafelinecList()) {
                udsafeline.setScnum(udsafecheck.getScnum());
                udsafeline.setCheckcontent("开关柜检查及保养");
                ObjectUtil.setAddBasicData(udsafeline, sessionInfo);
                udsafelineDao.save(udsafeline);
            }
        }
        //开关柜试验
        if (null != udsafecheck.getUdsafelinetList()) {
            for (Udsafeline udsafeline : udsafecheck.getUdsafelinetList()) {
                udsafeline.setScnum(udsafecheck.getScnum());
                udsafeline.setCheckcontent("开关柜试验");
                ObjectUtil.setAddBasicData(udsafeline, sessionInfo);
                udsafelineDao.save(udsafeline);
            }
        }
        //VD4断路器维护保养
        if (null != udsafecheck.getUdsafelinevList()) {
            for (Udsafeline udsafeline : udsafecheck.getUdsafelinevList()) {
                udsafeline.setScnum(udsafecheck.getScnum());
                udsafeline.setCheckcontent("VD4断路器维护保养");
                ObjectUtil.setAddBasicData(udsafeline, sessionInfo);
                udsafelineDao.save(udsafeline);
            }
        }

        return udsafecheck.getUdsafecheckid();
    }

    @Override
    public void editUdsafecheck(Udsafecheck udsafecheck, SessionInfo sessionInfo) throws Exception {
        //修改主表
        Udsafecheck dbObject = udsafecheckDao.find(udsafecheck.getUdsafecheckid());
        ObjectUtil.setEditBasicData(dbObject, sessionInfo);
        BeanUtils.copyProperties(udsafecheck, dbObject, ObjectUtil.getNullPropertyNames(udsafecheck));
        udsafecheckDao.update(dbObject);

        //删除子表
        String deletes = udsafecheck.getDeletes();
        if (deletes!=null&&!deletes.equals("")) {
            String[] appDeletes = deletes.split(";");
            for (int i = 0; i < appDeletes.length; i++) {
                String tableName = appDeletes[i].split(":")[0];
                if (tableName.equals("UDQUALIFICATION")) {
                    String[] split = appDeletes[i].split(":")[1].split(",");
                    for (int j = 0; j < split.length; j++) {
                        udqualificationDao.delete(Long.valueOf(split[j]));
                    }
                }else if(tableName.equals("UDCHEMICALS")){
                    String[] split = appDeletes[i].split(":")[1].split(",");
                    for (int j = 0; j < split.length; j++) {
                        udchemicalsDao.delete(Long.valueOf(split[j]));
                    }
                }else if(tableName.equals("UDPROTECTIVE")){
                    String[] split = appDeletes[i].split(":")[1].split(",");
                    for (int j = 0; j < split.length; j++) {
                        udprotectiveDao.delete(Long.valueOf(split[j]));
                    }
                }else if(tableName.equals("UDWORKPERMIT")){
                    String[] split = appDeletes[i].split(":")[1].split(",");
                    for (int j = 0; j < split.length; j++) {
                        udworkpermitDao.delete(Long.valueOf(split[j]));
                    }
                }else if(tableName.equals("UDTRAINCONTENT")){
                    String[] split = appDeletes[i].split(":")[1].split(",");
                    for (int j = 0; j < split.length; j++) {
                        udtraincontentDao.delete(Long.valueOf(split[j]));
                    }
                }else if(tableName.equals("UDSAFEMEETING")){
                    String[] split = appDeletes[i].split(":")[1].split(",");
                    for (int j = 0; j < split.length; j++) {
                        udsafemeetingDao.delete(Long.valueOf(split[j]));
                    }
                }else if(tableName.equals("UDEMERGENCY")){
                    String[] split = appDeletes[i].split(":")[1].split(",");
                    for (int j = 0; j < split.length; j++) {
                        udemergencyDao.delete(Long.valueOf(split[j]));
                    }
                }else if(tableName.equals("UDASSIGNMENTRISK")){
                    String[] split = appDeletes[i].split(":")[1].split(",");
                    for (int j = 0; j < split.length; j++) {
                        udassignmentriskDao.delete(Long.valueOf(split[j]));
                    }
                }else if(tableName.equals("UDSAFELINE_C")||tableName.equals("UDSAFELINE_T")||tableName.equals("UDSAFELINE_V")){
                    String[] split = appDeletes[i].split(":")[1].split(",");
                    for (int j = 0; j < split.length; j++) {
                        udsafelineDao.delete(Long.valueOf(split[j]));
                    }
                }
            }
        }
        //子表保存
        Map<String, Object> params = new HashMap<>();
        params.put("scnum", udsafecheck.getScnum());
        params.put("siteid", udsafecheck.getSiteid());
        String where = "scnum=:scnum and siteid=:siteid";
        //人员资质与能力
        List<Udqualification> udqualificationList = udqualificationDao.findAll(where, params, null);
        Map<Long, Udqualification> udpmlineMap = udqualificationList.stream().collect(
                Collectors.toMap(Udqualification::getUdqualificationid, a -> a, (k1, k2) -> k1)
        );
        if (null != udsafecheck.getUdqualificationList()) {
            for (Udqualification udqualification : udsafecheck.getUdqualificationList()) {
                if (null != udqualification.getUdqualificationid()) {
                    Udqualification dbobject = udpmlineMap.get(udqualification.getUdqualificationid());
                    if(dbobject==null){
                        continue;
                    }
                    BeanUtils.copyProperties(udqualification, dbobject, ObjectUtil.getNullPropertyNames(udqualification));
                    ObjectUtil.setEditBasicData(udqualification, sessionInfo);
                    udqualificationDao.update(dbobject);
                } else {
                    udqualification.setScnum(udsafecheck.getScnum());
                    ObjectUtil.setAddBasicData(udqualification, sessionInfo);
                    udqualificationDao.save(udqualification);
                }
            }
        }
        // 化学品
        List<Udchemicals> udchemicalsList = udchemicalsDao.findAll(where, params, null);
        Map<Long, Udchemicals> udchemicalsMap = udchemicalsList.stream().collect(
                Collectors.toMap(Udchemicals::getUdchemicalsid, a -> a, (k1, k2) -> k1)
        );
        if (null != udsafecheck.getUdchemicalsList()) {
            for (Udchemicals udchemicals : udsafecheck.getUdchemicalsList()) {
                if (null != udchemicals.getUdchemicalsid()) {
                    Udchemicals dbobject = udchemicalsMap.get(udchemicals.getUdchemicalsid());
                    if(dbobject==null){
                        continue;
                    }
                    BeanUtils.copyProperties(udchemicals, dbobject, ObjectUtil.getNullPropertyNames(udchemicals));
                    ObjectUtil.setEditBasicData(udchemicals, sessionInfo);
                    udchemicalsDao.update(dbobject);
                } else {
                    udchemicals.setScnum(udsafecheck.getScnum());
                    ObjectUtil.setAddBasicData(udchemicals, sessionInfo);
                    udchemicalsDao.save(udchemicals);
                }
            }
        }
        //个人防护装备及安全用具
        List<Udprotective> udprotectiveList = udprotectiveDao.findAll(where, params, null);
        Map<Long, Udprotective> udprotectiveMap = udprotectiveList.stream().collect(
                Collectors.toMap(Udprotective::getUdprotectiveid, a -> a, (k1, k2) -> k1)
        );
        if (null != udsafecheck.getUdprotectiveList()) {
            for (Udprotective udprotective : udsafecheck.getUdprotectiveList()) {
                if (null != udprotective.getUdprotectiveid()) {
                    Udprotective dbobject = udprotectiveMap.get(udprotective.getUdprotectiveid());
                    if(dbobject==null){
                        continue;
                    }
                    BeanUtils.copyProperties(udprotective, dbobject, ObjectUtil.getNullPropertyNames(udprotective));
                    ObjectUtil.setEditBasicData(udprotective, sessionInfo);
                    udprotectiveDao.update(dbobject);
                } else {
                    udprotective.setScnum(udsafecheck.getScnum());
                    ObjectUtil.setAddBasicData(udprotective, sessionInfo);
                    udprotectiveDao.save(udprotective);
                }
            }
        }
        //项目工作安全许可要求
        List<Udworkpermit> udworkpermitList = udworkpermitDao.findAll(where, params, null);
        Map<Long, Udworkpermit> udworkpermitMap = udworkpermitList.stream().collect(
                Collectors.toMap(Udworkpermit::getUdworkpermitid, a -> a, (k1, k2) -> k1)
        );
        if (null != udsafecheck.getUdworkpermitList()) {
            for (Udworkpermit udworkpermit : udsafecheck.getUdworkpermitList()) {
                if (null != udworkpermit.getUdworkpermitid()) {
                    Udworkpermit dbobject = udworkpermitMap.get(udworkpermit.getUdworkpermitid());
                    if(dbobject==null){
                        continue;
                    }
                    BeanUtils.copyProperties(udworkpermit, dbobject, ObjectUtil.getNullPropertyNames(udworkpermit));
                    ObjectUtil.setEditBasicData(udworkpermit, sessionInfo);
                    udworkpermitDao.update(dbobject);
                } else {
                    udworkpermit.setScnum(udsafecheck.getScnum());
                    ObjectUtil.setAddBasicData(udworkpermit, sessionInfo);
                    udworkpermitDao.save(udworkpermit);
                }
            }
        }
        //现场安全培训
        List<Udtraincontent> udtraincontentList = udtraincontentDao.findAll(where, params, null);
        Map<Long, Udtraincontent> udtraincontentMap = udtraincontentList.stream().collect(
                Collectors.toMap(Udtraincontent::getUdtraincontentid, a -> a, (k1, k2) -> k1)
        );
        if (null != udsafecheck.getUdtraincontentList()) {
            for (Udtraincontent udtraincontent : udsafecheck.getUdtraincontentList()) {
                if (null != udtraincontent.getUdtraincontentid()) {
                    Udtraincontent dbobject = udtraincontentMap.get(udtraincontent.getUdtraincontentid());
                    if(dbobject==null){
                        continue;
                    }
                    BeanUtils.copyProperties(udtraincontent, dbobject, ObjectUtil.getNullPropertyNames(udtraincontent));
                    ObjectUtil.setEditBasicData(udtraincontent, sessionInfo);
                    udtraincontentDao.update(dbobject);
                } else {
                    udtraincontent.setScnum(udsafecheck.getScnum());
                    ObjectUtil.setAddBasicData(udtraincontent, sessionInfo);
                    udtraincontentDao.save(udtraincontent);
                }
            }
        }
        //安全会议
        List<Udsafemeeting> udsafemeetingList = udsafemeetingDao.findAll(where, params, null);
        Map<Long, Udsafemeeting> udsafemeetingMap = udsafemeetingList.stream().collect(
                Collectors.toMap(Udsafemeeting::getUdsafemeetingid, a -> a, (k1, k2) -> k1)
        );
        if (null != udsafecheck.getUdsafemeetingList()) {
            for (Udsafemeeting udsafemeeting : udsafecheck.getUdsafemeetingList()) {
                if (null != udsafemeeting.getUdsafemeetingid()) {
                    Udsafemeeting dbobject = udsafemeetingMap.get(udsafemeeting.getUdsafemeetingid());
                    if(dbobject==null){
                        continue;
                    }
                    BeanUtils.copyProperties(udsafemeeting, dbobject, ObjectUtil.getNullPropertyNames(udsafemeeting));
                    ObjectUtil.setEditBasicData(udsafemeeting, sessionInfo);
                    udsafemeetingDao.update(dbobject);
                } else {
                    udsafemeeting.setScnum(udsafecheck.getScnum());
                    ObjectUtil.setAddBasicData(udsafemeeting, sessionInfo);
                    udsafemeetingDao.save(udsafemeeting);
                }
            }
        }
        //急救物品
        List<Udemergency> udemergencyList = udemergencyDao.findAll(where, params, null);
        Map<Long, Udemergency> udemergencyMap = udemergencyList.stream().collect(
                Collectors.toMap(Udemergency::getUdemergencyid, a -> a, (k1, k2) -> k1)
        );
        if (null != udsafecheck.getUdemergencyList()) {
            for (Udemergency udemergency : udsafecheck.getUdemergencyList()) {
                if (null != udemergency.getUdemergencyid()) {
                    Udemergency dbobject = udemergencyMap.get(udemergency.getUdemergencyid());
                    if(dbobject==null){
                        continue;
                    }
                    BeanUtils.copyProperties(udemergency, dbobject, ObjectUtil.getNullPropertyNames(udemergency));
                    ObjectUtil.setEditBasicData(udemergency, sessionInfo);
                    udemergencyDao.update(dbobject);
                } else {
                    udemergency.setScnum(udsafecheck.getScnum());
                    ObjectUtil.setAddBasicData(udemergency, sessionInfo);
                    udemergencyDao.save(udemergency);
                }
            }
        }
        //作业风险及项目特殊风险
        List<Udassignmentrisk> udassignmentriskList = udassignmentriskDao.findAll(where, params, null);
        Map<Long, Udassignmentrisk> udassignmentriskMap = udassignmentriskList.stream().collect(
                Collectors.toMap(Udassignmentrisk::getUdassignmentriskid, a -> a, (k1, k2) -> k1)
        );
        if (null != udsafecheck.getUdassignmentriskList()) {
            for (Udassignmentrisk udassignmentrisk : udsafecheck.getUdassignmentriskList()) {
                if (null != udassignmentrisk.getUdassignmentriskid()) {
                    Udassignmentrisk dbobject = udassignmentriskMap.get(udassignmentrisk.getUdassignmentriskid());
                    if(dbobject==null){
                        continue;
                    }
                    BeanUtils.copyProperties(udassignmentrisk, dbobject, ObjectUtil.getNullPropertyNames(udassignmentrisk));
                    ObjectUtil.setEditBasicData(udassignmentrisk, sessionInfo);
                    udassignmentriskDao.update(dbobject);
                } else {
                    udassignmentrisk.setScnum(udsafecheck.getScnum());
                    ObjectUtil.setAddBasicData(udassignmentrisk, sessionInfo);
                    udassignmentriskDao.save(udassignmentrisk);
                }
            }
        }
        //开关柜检查及保养
        String where_c = "scnum=:scnum and siteid=:siteid and checkcontent='开关柜检查及保养'";
        List<Udsafeline> udsafelinecList = udsafelineDao.findAll(where_c, params, null);
        Map<Long, Udsafeline> udsafelinecMap = udsafelinecList.stream().collect(
                Collectors.toMap(Udsafeline::getUdsafelineid, a -> a, (k1, k2) -> k1)
        );
        if (null != udsafecheck.getUdsafelinecList()) {
            for (Udsafeline udsafeline : udsafecheck.getUdsafelinecList()) {
                if (null != udsafeline.getUdsafelineid()) {
                    Udsafeline dbobject = udsafelinecMap.get(udsafeline.getUdsafelineid());
                    if(dbobject==null){
                        continue;
                    }
                    BeanUtils.copyProperties(udsafeline, dbobject, ObjectUtil.getNullPropertyNames(udsafeline));
                    ObjectUtil.setEditBasicData(udsafeline, sessionInfo);
                    udsafelineDao.update(dbobject);
                } else {
                    udsafeline.setScnum(udsafecheck.getScnum());
                    udsafeline.setCheckcontent("开关柜检查及保养");
                    ObjectUtil.setAddBasicData(udsafeline, sessionInfo);
                    udsafelineDao.save(udsafeline);
                }
            }
        }
        //开关柜试验
        String where_t = "scnum=:scnum and siteid=:siteid and checkcontent='开关柜试验'";
        List<Udsafeline> udsafelinetList = udsafelineDao.findAll(where_t, params, null);
        Map<Long, Udsafeline> udsafelinetMap = udsafelinetList.stream().collect(
                Collectors.toMap(Udsafeline::getUdsafelineid, a -> a, (k1, k2) -> k1)
        );
        if (null != udsafecheck.getUdsafelinetList()) {
            for (Udsafeline udsafeline : udsafecheck.getUdsafelinetList()) {
                if (null != udsafeline.getUdsafelineid()) {
                    Udsafeline dbobject = udsafelinetMap.get(udsafeline.getUdsafelineid());
                    if(dbobject==null){
                        continue;
                    }
                    BeanUtils.copyProperties(udsafeline, dbobject, ObjectUtil.getNullPropertyNames(udsafeline));
                    ObjectUtil.setEditBasicData(udsafeline, sessionInfo);
                    udsafelineDao.update(dbobject);
                } else {
                    udsafeline.setScnum(udsafecheck.getScnum());
                    udsafeline.setCheckcontent("开关柜试验");
                    ObjectUtil.setAddBasicData(udsafeline, sessionInfo);
                    udsafelineDao.save(udsafeline);
                }
            }
        }
        //VD4断路器维护保养
        String where_v = "scnum=:scnum and siteid=:siteid and checkcontent='VD4断路器维护保养'";
        List<Udsafeline> udsafelinevList = udsafelineDao.findAll(where_v, params, null);
        Map<Long, Udsafeline> udsafelinevMap = udsafelinevList.stream().collect(
                Collectors.toMap(Udsafeline::getUdsafelineid, a -> a, (k1, k2) -> k1)
        );
        if (null != udsafecheck.getUdsafelinevList()) {
            for (Udsafeline udsafeline : udsafecheck.getUdsafelinevList()) {
                if (null != udsafeline.getUdsafelineid()) {
                    Udsafeline dbobject = udsafelinevMap.get(udsafeline.getUdsafelineid());
                    if(dbobject==null){
                        continue;
                    }
                    BeanUtils.copyProperties(udsafeline, dbobject, ObjectUtil.getNullPropertyNames(udsafeline));
                    ObjectUtil.setEditBasicData(udsafeline, sessionInfo);
                    udsafelineDao.update(dbobject);
                } else {
                    udsafeline.setScnum(udsafecheck.getScnum());
                    udsafeline.setCheckcontent("VD4断路器维护保养");
                    ObjectUtil.setAddBasicData(udsafeline, sessionInfo);
                    udsafelineDao.save(udsafeline);
                }
            }
        }
    }

    public void getCheckItems(String udsafecheckid, String type, SessionInfo sessionInfo) throws Exception{
        List<Udsafeline> udsafelineList = new ArrayList<Udsafeline>();
        Udsafecheck udsafecheck = udsafecheckDao.find(Long.valueOf(udsafecheckid));
        Map<String, Object> params = new HashMap<>();
        params.put("checkcontent", type);
        String where = "checkcontent=:checkcontent and checkdetail is not null and checkdetail!=''";
        List<Udsafedefine> udsafedefineList = udsafedefineDao.findAll(where, params, null);
        if(udsafedefineList.size()>0){
            for(int i=0;i<udsafedefineList.size();i++){
                Udsafedefine udsafedefine = udsafedefineList.get(i);
                Udsafeline udsafeline = new Udsafeline();
                ObjectUtil.setAddBasicData(udsafeline, sessionInfo);
                udsafeline.setScnum(udsafecheck.getScnum());
                udsafeline.setChecktype(udsafedefine.getChecktype());
                udsafeline.setCheckdetail(udsafedefine.getCheckdetail());
                udsafeline.setCheckcontent(udsafedefine.getCheckcontent());
                udsafeline.setContent(udsafedefine.getContent());
                udsafelineDao.save(udsafeline);
            }
        }
    }

    public List<Udequipment> getEquipments(String pronum, String linenum, String siteid, SessionInfo sessionInfo) throws Exception{
        Map<String, Object> params = new HashMap<>();
        params.put("pronum", pronum);
        params.put("linenum", Long.valueOf(linenum));
        //params.put("siteid", siteid==null?sessionInfo.getSite():siteid);
//        String where = "pronum=:pronum and linenum=:linenum and siteid=:siteid";
        String where = "pronum=:pronum and linenum=:linenum";
        List<Udequipment> udequipmentList = udequipmentDao.findAll(where,params,null);
        return udequipmentList;
    }
}




