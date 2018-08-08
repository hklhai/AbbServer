package com.hxqh.abb.service;

import com.hxqh.abb.common.util.CglibUtil;
import com.hxqh.abb.common.util.GroupListUtil;
import com.hxqh.abb.dao.*;
import com.hxqh.abb.model.*;
import com.hxqh.abb.model.base.SessionInfo;
import com.hxqh.abb.model.dto.action.*;
import com.hxqh.abb.model.paperless.*;
import com.hxqh.abb.model.searchdto.Page;
import com.hxqh.abb.model.version2.Invuse;
import com.hxqh.abb.model.version2.Po;
import com.hxqh.abb.model.version2.Udinvcheck;
import com.hxqh.abb.model.view.*;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.*;

/**
 * Created by lh on 2017/4/14.
 */
@Transactional
@Service("commonService")
public class CommonServiceImpl implements CommonService {

    private static Map<String, TbApp> appListMap = new HashMap<>();
    private static Map<String, TbApp> appDetailMap = new HashMap<>();
    private static Map<String, List<TbApp>> fieldsMap = new LinkedHashMap<>();
    private static Map<String, List<TbApp>> detailMap = new LinkedHashMap<>();
    private static Map<String, List<TbApp>> childMap = new LinkedHashMap<>();
    private static Map<String, List<TbApp>> selectionMap = new LinkedHashMap<>();

    private static Map<String, List<Relation>> relativeMap = new LinkedHashMap<>();

    @Autowired
    private UserDao userDao;
    @Resource
    protected SessionFactory sessionFactory;
    @Autowired
    private TbAppDao appDao;
    @Autowired
    private FavoriteDao favoriteDao;
    @Autowired
    private RelationDao relationDao;

    @Autowired
    private UdtoolChkDao udtoolChkDao;
    @Autowired
    private VUdtoolchklineDao vUdtoolchklineDao;
    @Autowired
    private InvuseDao invuseDao;
    @Autowired
    private VUdwolineDao vUdwolineDao;
    @Autowired
    private WorkorderDao workorderDao;
    @Autowired
    private VUdwoqualificationDao vUdwoqualificationDao;
    @Autowired
    private UdinvcheckDao udinvcheckDao;
    @Autowired
    private PoDao poDao;
    @Autowired
    private VUdinvchecklineDao vUdinvchecklineDao;
    @Autowired
    private VPolineDao vPolineDao;
    @Autowired
    private WoactivityDao woactivityDao;
    @Autowired
    private VInvuselineallocateDao vInvuselineallocateDao;
    @Autowired
    private VInvuselinegrantDao vInvuselinegrantDao;
    @Autowired
    private VMatrectranDao vMatrectranDao;
    @Autowired
    private VInvuselinerefundDao vInvuselinerefundDao;
    @Autowired
    private UddelegateDao uddelegateDao;
    @Autowired
    private UdcustomerDao udcustomerDao;
    @Autowired
    private UdprojectDao udprojectDao;
    @Autowired
    private PaperlessProjectlineDao paperlessProjectlineDao;
    @Autowired
    private PaperlessEquipmentDao paperlessEquipmentDao;
    @Autowired
    private UdtrainrecordDao udtrainrecordDao;
    @Autowired
    private UdtrainrecordlineDao udtrainrecordlineDao;
    @Autowired
    private UdpmlineDao udpmlineDao;
    @Autowired
    private UdsafecheckDao udsafecheckDao;
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
    private UdworkreportDao udworkreportDao;
    @Autowired
    private UdworkcontentDao udworkcontentDao;
    @Autowired
    private UdnormalserviceDao udnormalserviceDao;


    @PostConstruct
    public void init() {
        LinkedHashMap<String, String> orderby = new LinkedHashMap<>();
        orderby.put("ordernum", "asc");
        List<TbApp> appList = appDao.findAll(null, null, orderby);
        //对appList按照APPCONTENT分组
        Map<String, List<TbApp>> allMap = GroupListUtil.group(appList, new GroupListUtil.GroupBy<String>() {
            @Override
            public String groupby(Object obj) {
                TbApp d = (TbApp) obj;
                return d.getAppcontent();    // 分组依据为Appcontent
            }
        });

        //属性
        fieldsMap = GroupListUtil.group(allMap.get("LIST"), new GroupListUtil.GroupBy<String>() {
            @Override
            public String groupby(Object obj) {
                TbApp d = (TbApp) obj;
                return d.getAppname();    // 分组依据为Appname
            }
        });

        //详情
        detailMap = GroupListUtil.group(allMap.get("DETAIL"), new GroupListUtil.GroupBy<String>() {
            @Override
            public String groupby(Object obj) {
                TbApp d = (TbApp) obj;
                return d.getAppname();    // 分组依据为Appname
            }
        });

        //子表
        childMap = GroupListUtil.group(allMap.get("CHILD"), new GroupListUtil.GroupBy<String>() {
            @Override
            public String groupby(Object obj) {
                TbApp d = (TbApp) obj;
                return d.getChildtablename();    // 分组依据为Childtablename
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
            if (e.getIspk() == 1 && e.getAppcontent().equals("LIST") || e.getIspk() == 1 && e.getAppcontent().equals("SELECTION")) {
                appListMap.put(e.getAppname(), e);
            } else if (e.getIspk() == 1 && e.getAppcontent().equals("DETAIL")) {
                appDetailMap.put(e.getAppname(), e);
            }
        }
        /**************************初始化Detail详情关系****************************/
        List<Relation> relationList = relationDao.findAll();
        //对relationList按照APPCONTENT分组
        relativeMap = GroupListUtil.group(relationList, new GroupListUtil.GroupBy<String>() {
            @Override
            public String groupby(Object obj) {
                Relation d = (Relation) obj;
                return d.getAppname();    // 分组依据为Appname
            }
        });
    }

    @Override
    public List<TbApp> getAppInfo(String apptname) {
        return fieldsMap.get(apptname);
    }


    @Override
    public List<Relation> getRelativeMap(String apptname) {
        return relativeMap.get(apptname);
    }


    @Override
    public List<TbApp> getSelectionInfo(String apptname) {
        return selectionMap.get(apptname);
    }

    @Override
    public TbApp getAppName(String apptname) {
        return appListMap.get(apptname);
    }

    public List<User> getUserList() {
        return userDao.findAll();
    }

    @Override
    public ListDto listData(Page page, String apptname, String isFavorite, String searchs, SessionInfo sessionInfo, String udapptype) throws Exception {
        StringBuilder fs = new StringBuilder("");
        Map<String, Object> propertyMap = new LinkedHashMap();
        List<TbApp> dbList = new LinkedList<>();
        if (apptname.startsWith("SELECTION"))
            dbList = selectionMap.get(apptname);
        else
            dbList = fieldsMap.get(apptname);

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
        if (apptname.startsWith("SELECTION")) {
            if (apptname.equals("SELECTIONFAILURECODE")) {
                noPageBuilder.append(" from ").append(apptable).append(" where 1=1 and parent is null");
            } else if (apptname.equals("SELECTIONWORKORDER")) {
                noPageBuilder.append(" from ").append(apptable).append(" where 1=1 and taskid is not null");
            } else {
                noPageBuilder.append(" from ").append(apptable).append(" where 1=1 ");
            }
        } else {
            if (apptname.equals("UDTOOL") || apptname.equals("WXUSER")
                    || apptname.equals("UDPROJECT")|| apptname.equals("UDDELEGATE")|| apptname.equals("UDSAFE2")
                    || apptname.equals("UDPROINFO")|| apptname.equals("UDSCENESER")|| apptname.equals("UDPSM2")
                    || apptname.equals("UDBOXCHECK")|| apptname.equals("UDSC")|| apptname.equals("UDENTRUST")|| apptname.equals("UDAS")
                    || apptname.equals("UDTRAIN")|| apptname.equals("UDNC")|| apptname.equals("UDPM")|| apptname.equals("UDWP")) {
                noPageBuilder.append(" from ").append(apptable).append(" where 1=1 ");
            } else {
                noPageBuilder.append(" from ").append(apptable).append(" where 1=1 and siteid='" + sessionInfo.getSite() + "'");
            }
            // 接收过滤掉WAPPR
            if (apptname.equals("RECEIPTS")) {
                noPageBuilder.append(" AND STATUS = 'APPR' ");
            }
        }


        selectionWhere(apptname, noPageBuilder);

        //list遍历，每个对象通过反射调用get得到主键值，判断主键值是否存在，若存在，调用通过反射调用set favorites方法设置值
        //获取该appname下的收藏的ID
        Map<String, Object> params = new HashMap<>();
        params.put("personid", sessionInfo.getLoginId().toUpperCase());
        params.put("appname", apptname);
        String where = "personid=:personid and appname=:appname";
        List<Favorite> favoriteList = favoriteDao.findAll(where, params, null);
        List<String> listFavorite = new ArrayList<>();
        String ids = new String();

        for (Favorite favorite : favoriteList) {
            listFavorite.add(favorite.getPkid().toString());
        }
        if (favoriteList.size() == 0) {
            ids = "0";
        } else {
            for (Favorite favorite : favoriteList) {
                ids = ids + favorite.getPkid().toString() + ",";
            }
            ids = ids.substring(0, ids.length() - 1);
        }

        //判断是否收藏查询
        if (isFavorite.equals("favorite")) {
            noPageBuilder.append(" and ").append(pkid).append(" in (").append(ids).append(")");
        }

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
        // TODO: 2017/11/1  PO 待测试
        if (null != udapptype)
            noPageBuilder.append(udapptypeBuild(udapptype));

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
                if (setMethodName.contains("ROWNUMBER")) {
                    //判断是否存在主键，存在设置为1；否则设置为0
                    if (favoriteList.size() == 0) {
                        setMethod.invoke(object, 0);
                    } else {
                        if (listFavorite.contains(id))
                            setMethod.invoke(object, 1);
                        else
                            setMethod.invoke(object, 0);
                    }
                } else {
                    // 处理null为空字符串
                    if (null == o[j]) {
                        o[j] = "";
                    }
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


    private String udapptypeBuild(String udapptype) {
        StringBuilder builder = new StringBuilder();
        builder.append(" and ").append("UDAPPTYPE").append("='").append(udapptype).append("'");
        return builder.toString();
    }

    private void selectionWhere(String apptname, StringBuilder noPageBuilder) {
        //selection拼接过滤条件  select * from ALNDOMAIN t where t.DOMAINID like 'UDTOOL%'
        if (apptname.equals("SELECTIONUDTOOLTYPE")) {//工具管理--工具种类
            noPageBuilder.append(" and DOMAINID='UDTOOLTYPE' ");
        } else if (apptname.equals("SELECTIONUDLASTCHKRESULT")) {//工具管理--校准结果（上次校准结果）
            noPageBuilder.append(" and DOMAINID='UDLASTCHKRESULT' ");
        } else if (apptname.equals("SELECTIONINDUSTRYATTRIBUTES")) {//项目管理--行业属性
            noPageBuilder.append(" and DOMAINID='INDUSTRYATTRIBUTES' ");
        } else if (apptname.equals("SELECTIONSERVICEDEP")) {//项目管理--服务事业部
            noPageBuilder.append(" and DOMAINID='SERVICEDEP' ");
        } else if (apptname.equals("SELECTIONPROVINCES")) {//项目管理--现场所在省份
            noPageBuilder.append(" and DOMAINID='PROVINCES' ");
        } else if (apptname.equals("SELECTIONUDAREA")) {//项目管理--现场所在区域
            noPageBuilder.append(" and DOMAINID='UDAREA' ");
        } else if (apptname.equals("SELECTIONCUSTOMERNATURE")) {//项目管理--客户性质
            noPageBuilder.append(" and DOMAINID='CUSTOMERNATURE' ");
        } else if (apptname.equals("SELECTIONSERVICENATURE")) {//项目管理--服务性质
            noPageBuilder.append(" and DOMAINID='SERVICENATURE' ");
        } else if (apptname.equals("SELECTIONSUPPLIER")) {//设备开箱检验--供方
            noPageBuilder.append(" and DOMAINID='GONGF' ");
        }
//        //SYNONYMDOMAIN
//        if (apptname.equals("SELECTIONUDTOOLTYPE")) {
//            noPageBuilder.append(" and DOMAINID='UDLASTCHKRESULT' ");
//        }

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

    private void objectConstructor(Field declaredField, String field1, Object o, CglibUtil bean) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        String field = field1;
        field = field.substring(0, 1).toUpperCase() + field.substring(1);

        String setMethodName = "set" + field;
        Object object = bean.getObject();
        Method setMethod = object.getClass().getDeclaredMethod(setMethodName, new Class[]{declaredField.getType()});
        // null转换
        if (null == o) {
            o = "";
        }
        setMethod.invoke(object, o);
    }


    @Override
    public DetailDto detailData(String apptname, String pkid) throws Exception {
        Map<String, Object> propertyMap = new LinkedHashMap<>();

        //获取表名与主键名称
        String tableName = appDetailMap.get(apptname).getApptable();
        String pkName = appDetailMap.get(apptname).getAppfield();
        //属性值
        List<TbApp> appList = detailMap.get(apptname);
        StringBuilder fieldBuilder = new StringBuilder("");
        for (TbApp e : appList) {
            fieldBuilder.append(e.getAppfield()).append(",");
            propertyMap.put(e.getAppfield(), Class.forName(e.getFieldtype()));
        }
        String fields = fieldBuilder.substring(0, fieldBuilder.length() - 1);

        StringBuilder sql = new StringBuilder("");
        sql.append("select ").append(fields).append(" from ").append(tableName).append(" where ").append(pkName).append("=").append(":PKNAME");
        List list = sessionFactory.getCurrentSession().createSQLQuery(sql.toString()).setString("PKNAME", pkid).list();
        //动态生成类
        CglibUtil bean = new CglibUtil(propertyMap);
        Field[] declaredFields = bean.getObject().getClass().getDeclaredFields();
        String[] split = fields.split(",");

        List<Object[]> nameList = list;

        constructorObject(bean, declaredFields, split, nameList);
        List<Relation> relationList = relativeMap.get(apptname);
        List<Relation> childList = new ArrayList<>();

        Relation audit = nextAuditor(relationList, childList);
        /*****************************************子表************************************************/
        Map<String, List> map = getChildMapInfo(apptname, pkid);


        /*****************************************子表*************************************************/


        //审批记录
        List aList = auditRecord(pkid, audit);
        //下一审批人
        List nAuditList = getNextAuditList(pkid, audit);


        DetailDto detailDto = new DetailDto(bean.getObject(), aList, nAuditList, map);
        return detailDto;
    }

    public Relation nextAuditor(List<Relation> relationList, List<Relation> childList) {
        Relation audit = new Relation();
        //判断是否有子表
        if (relationList != null) {
            for (Relation e : relationList) {
                if (e.getIschild() == 1)
                    childList.add(e);
                if (e.getIschild() == 2)
                    audit = e;
            }
        }
        return audit;
    }

    private Map<String, List> getChildMapInfo(String apptname, String pkid) {
        Map<String, List> map = new LinkedHashMap<>();

        Workorder workorder = workorderDao.find(Long.valueOf(pkid));

        /*******************************************工具管理****************************************/
        if (apptname.equals("UDTOOLCHK")) { //工具校准行页面 信息
            UdtoolChk udtoolChk = udtoolChkDao.find(Long.valueOf(pkid));

            Map<String, Object> params = new HashMap<>();
            params.put("tcnum", udtoolChk.getTcnum());
            String where = "tcnum=:tcnum";

            LinkedHashMap<String, String> orderby = new LinkedHashMap<>();
            orderby.put("udtoolchklineid", "asc");
            List<VUdtoolchkline> udtoolchklineList = vUdtoolchklineDao.findAll(where, params, orderby);
            map.put("UDTOOLCHKLINE", udtoolchklineList);
        }
        /*******************************************工具管理****************************************/


        /*******************************************库存管理****************************************/
        else if (apptname.equals("UDISSUE"))   //物资发放页面 信息
        {
            Invuse invuse = invuseDao.find(Long.valueOf(pkid));

            Map<String, Object> params = new HashMap<>();
            params.put("invusenum", invuse.getInvusenum());
            params.put("siteid", invuse.getSiteid());
            params.put("location", invuse.getFromstoreloc());

            String where = "invusenum=:invusenum and siteid=:siteid and location=:location ";
            LinkedHashMap<String, String> orderby = new LinkedHashMap<>();
            orderby.put("invuselineid", "asc");
            List<VInvuselinegrant> invuselinegrantList = vInvuselinegrantDao.findAll(where, params, orderby);
            map.put("UDISSUE", invuselinegrantList);

        } else if (apptname.equals("UDTRANSFER"))  //备件调拨 信息
        {
            Invuse invuse = invuseDao.find(Long.valueOf(pkid));
            Map<String, Object> params = new HashMap<>();
            params.put("invusenum", invuse.getInvusenum());
            params.put("siteid", invuse.getSiteid());
            String where = "invusenum=:invusenum and siteid=:siteid";
            LinkedHashMap<String, String> orderby = new LinkedHashMap<>();
            orderby.put("invuselineid", "asc");
            List<VInvuselineallocate> invuselineallocateList = vInvuselineallocateDao.findAll(where, params, orderby);
            map.put("UDTRANSFER", invuselineallocateList);
        } else if (apptname.equals("UDINVCHECK"))  //盘点清单 信息
        {
            Udinvcheck udinvcheck = udinvcheckDao.find(Long.valueOf(pkid));
            Map<String, Object> params = new HashMap<>();
            params.put("invchecknum", udinvcheck.getInvchecknum());
            params.put("siteid", udinvcheck.getSiteid());
            params.put("storeloc", udinvcheck.getStoreloc());
            String where = "invchecknum=:invchecknum and siteid=:siteid and storeloc=:storeloc";

            LinkedHashMap<String, String> orderby = new LinkedHashMap<>();
            orderby.put("udinvchecklineid", "asc");

            List<VUdinvcheckline> udinvchecklineList = vUdinvchecklineDao.findAll(where, params, orderby);
            map.put("UDINVCHECKLINE", udinvchecklineList);
        } else if (apptname.equals("UDPO") || apptname.equals("UDOM") || apptname.equals("UDWM")) {
            //采购清单信息、旧料回收清单、废料回收清单
            Po po = poDao.find(Long.valueOf(pkid));
            Map<String, Object> params = new HashMap<>();
            params.put("ponum", po.getPonum());
            params.put("revisionnum", po.getRevisionnum());
            params.put("siteid", po.getSiteid());
            String where = "ponum=:ponum and revisionnum=:revisionnum and siteid=:siteid";

            LinkedHashMap<String, String> orderby = new LinkedHashMap<>();
            orderby.put("polineid", "asc");

            List<VPoline> polineList = vPolineDao.findAll(where, params, orderby);
            //旧料回收清单 多余字段UNITCOST、LINECOST
            map.put("POLINE", polineList);
        } else if (apptname.equals("RECEIPTS"))  // 接收清单
        {
            Po po = poDao.find(Long.valueOf(pkid));

            Map<String, Object> params = new HashMap<>();
            params.put("ponum", po.getPonum());
            params.put("positeid", po.getSiteid());
            String where = "ponum=:ponum and positeid=:positeid";

            LinkedHashMap<String, String> orderby = new LinkedHashMap<>();
            orderby.put("ponum", "asc");
            //TODO 缺少字段 RECEIPTQUANTITY
            List<VMatrectran> matrectranList = vMatrectranDao.findAll(where, params, orderby);
            map.put("RECEIPTS", matrectranList);
        } else if (apptname.equals("RECEIPTS"))  // 物资退库
        {
            Invuse invuse = invuseDao.find(Long.valueOf(pkid));

            Map<String, Object> params = new HashMap<>();
            params.put("invusenum", invuse.getInvusenum());
            params.put("siteid", invuse.getSiteid());
            String where = "invusenum=:invusenum and siteid=:siteid";
            LinkedHashMap<String, String> orderby = new LinkedHashMap<>();
            orderby.put("invuselineid", "asc");

            List<VInvuselinerefund> invuselinerefundList = vInvuselinerefundDao.findAll(where, params, orderby);
            //TODO CURBALTOTAL、DISPLAYUNITCOST、DISPLAYLINECOST
            map.put("RECEIPTS", invuselinerefundList);
        }
        /*******************************************库存管理****************************************/

        /*******************************************执行管理****************************************/
        else if (apptname.equals("WOTRACK")) {
            //V_UDWOLINE表  设备信息
            Map<String, Object> params = new HashMap<>();
            params.put("wonum", workorder.getWonum());
            params.put("siteid", workorder.getSiteid());
            String where = "wonum=:wonum and siteid=:siteid";

            LinkedHashMap<String, String> orderby = new LinkedHashMap<>();
            orderby.put("udwolineid", "asc");
            List<VUdwoline> udwolineList = vUdwolineDao.findAll(where, params, orderby);
            map.put("UDWOLINE", udwolineList);

            // V_UDWOQUALIFICATION表  资质
            LinkedHashMap<String, String> orderbyUdwoqualification = new LinkedHashMap<>();
            orderbyUdwoqualification.put("udwoqualificationid", "asc");
            List<VUdwoqualification> udwoqualificationList = vUdwoqualificationDao.findAll(where, params, orderbyUdwoqualification);
            map.put("UDWOQUALIFICATION", udwoqualificationList);

            //WOACTIVITY 计划标签页信息
            String whereWoactivity = "parent=:wonum and siteid=:siteid";
            LinkedHashMap<String, String> orderbyWoactivity = new LinkedHashMap<>();
            orderbyUdwoqualification.put("workorderid", "asc");
            List<Woactivity> woactivityList = woactivityDao.findAll(whereWoactivity, params, orderbyWoactivity);
            map.put("WOACTIVITY", woactivityList);


            //WPLABOR 
            // TODO: 2017/10/12 TASKID不存在
            String sqlWplabor = "SELECT copytaskid,wplaboruid, laborcode, laborhrs, wonum,siteid,copytaskid\n" +
                    "  FROM WPLABOR\n" +
                    " WHERE wonum IN\n" +
                    "       (SELECT wonum\n" +
                    "          FROM workorder\n" +
                    "         WHERE (wonum = :wonum OR (parent = :wonum AND istask = 1))\n" +
                    "           AND siteid = :siteid)\n";
            List<WplaborDto> wplaborlist = sessionFactory.getCurrentSession().createSQLQuery(sqlWplabor)
                    .addEntity(WplaborDto.class).setString("wonum", workorder.getWonum())
                    .setString("siteid", workorder.getSiteid()).list();
            map.put("WPLABOR", wplaborlist);

            //WPMATERIAL  计划标签页信息
            String sqlWpmaterial = "select itemnum,\n" +
                    "       description,\n" +
                    "       itemqty,\n" +
                    "       unitcost,\n" +
                    "       linecost,\n" +
                    "       location,\n" +
                    "       storelocsite,\n" +
                    "       issueto,\n" +
                    "       copytaskid,\n" +
                    "       requestby,\n" +
                    "       wpitemid\n" +
                    "  from WPMATERIAL\n" +
                    " where wonum IN\n" +
                    "       (SELECT wonum\n" +
                    "          FROM workorder\n" +
                    "         WHERE (wonum = :wonum OR (parent = :wonum AND istask = 1))\n" +
                    "           AND siteid = :siteid)";
            List<WpmaterialDto> wpmaterialDtoList = sessionFactory.getCurrentSession().createSQLQuery(sqlWpmaterial)
                    .addEntity(WpmaterialDto.class).setString("wonum", workorder.getWonum())
                    .setString("siteid", workorder.getSiteid()).list();
            map.put("WPMATERIAL", wpmaterialDtoList);

            //执行报告标签页  LABTRANS
            String labtransSql = "SELECT t.copytaskid, t.laborcode, p.displayname, t.regularhrs, t.labtransid\n" +
                    "  FROM LABTRANS t\n" +
                    "  left join person p\n" +
                    "    on p.personid = t.LABORCODE\n" +
                    " WHERE t.refwo IN (SELECT wonum\n" +
                    "                     FROM workorder\n" +
                    "                    WHERE (wonum = :wonum OR (parent = :wonum AND istask = 1))\n" +
                    "                      AND siteid = :siteid )\n";
            List<LabtransDto> labtransDtoList = sessionFactory.getCurrentSession().createSQLQuery(labtransSql)
                    .addEntity(LabtransDto.class).setString("wonum", workorder.getWonum())
                    .setString("siteid", workorder.getSiteid()).list();
            map.put("LABTRANS", labtransDtoList);


            //MATUSETRANS  执行报告标签页
            String matusetransSql = "select t.matusetransid,\n" +
                    "       t.itemnum,\n" +
                    "       t.description,\n" +
                    "       t.storeloc,\n" +
                    "       t.siteid,\n" +
                    "      -- t.positivequantity,\n" +
                    "       t.unitcost,\n" +
                    "       t.linecost,\n" +
                    "       t.copytaskid,\n" +
                    "       t.binnum,\n" +
                    "       t.issueto,\n" +
                    "       t.location,\n" +
                    "       t1.description     as locationsdescription,\n" +
                    "       t.assetnum,\n" +
                    "       t2.description      as assetdescription\n" +
                    "  from MATUSETRANS t\n" +
                    "  left join LOCATIONS t1\n" +
                    "    on t.location = t1.location\n" +
                    "   and t.siteid = t1.siteid\n" +
                    "  left join ASSET t2\n" +
                    "    on t2.assetnum = t.assetnum\n" +
                    "   and t2.siteid = t.siteid\n" +
                    "    where t.refwo in (select wonum\n" +
                    "                     from workorder\n" +
                    "                    where (wonum = :wonum or (parent = :wonum and istask = 1))\n" +
                    "                      and siteid = :siteid)\n";

            List<MatusetransDto> matusetransDtoList = sessionFactory.getCurrentSession().createSQLQuery(matusetransSql)
                    .addEntity(LabtransDto.class).setString("wonum", workorder.getWonum())
                    .setString("siteid", workorder.getSiteid()).list();
            map.put("MATUSETRANS", matusetransDtoList);


            //故障报告标签页--FAILUREREPORT
            String failurereportSQL = "SELECT t2.failurereportid,\n" +
                    "       t2.type,\n" +
                    "       t2.failurecode,\n" +
                    "       t3.description as failurecodedescription,\n" +
                    "       t2.orgid\n" +
                    "  FROM  FAILUREREPORT t2\n" +
                    "  LEFT JOIN FAILURECODE t3\n" +
                    "    ON t3.failurecode = t2.failurecode\n" +
                    "   AND t3.orgid = t2.ORGID\n" +
                    "where  t2.wonum = :wonum\n" +
                    "   AND t2.siteid = :siteid";

            List<FailurereportDto> failurereportDtoList = sessionFactory.getCurrentSession().createSQLQuery(failurereportSQL)
                    .addEntity(FailurereportDto.class)
                    .setString("wonum", workorder.getWonum())
                    .setString("siteid", workorder.getSiteid()).list();
            map.put("FAILUREREPORT", failurereportDtoList);

            //关联工单标签页  RELATEDRECORD
            String relatedrecordSQL = "SELECT t2.relatedrecordid,\n" +
                    "       t2.relatedreckey   as relatedrecwonum,\n" +
                    "       t3.description     as workorderdescription,\n" +
                    "       t3.assetnum,\n" +
                    "       t4.description     as assetdescription,\n" +
                    "       t5.location,\n" +
                    "       t5.                status,\n" +
                    "       t6.description     as locationsdescription\n" +
                    "  from RELATEDRECORD t2\n" +
                    "  LEFT JOIN WORKORDER t3\n" +
                    "    ON t3.wonum = t2.relatedreckey\n" +
                    "   AND t3.woclass = t2.relatedrecclass\n" +
                    "   AND t3.siteid = t2.relatedrecsiteid\n" +
                    "  LEFT JOIN ASSET t4\n" +
                    "    on t3.assetnum = t4.assetnum\n" +
                    "   AND t2.siteid = t4.siteid\n" +
                    "  LEFT JOIN WORKORDER t5\n" +
                    "    ON t5.wonum = t2.relatedreckey\n" +
                    "   AND t5.woclass = t2.relatedrecclass\n" +
                    "   AND t5.siteid = t2.relatedrecsiteid\n" +
                    "  LEFT JOIN LOCATIONS t6\n" +
                    "    on t6.location = t3.location\n" +
                    "   and t6.siteid = t3.siteid\n" +
                    " where t2.siteid = :siteid\n" +
                    "   AND t2.recordkey = :wonum\n" +
                    "   AND t2.class = :woclass\n" +
                    "   AND t2.relatedrecclass IN\n" +
                    "       (SELECT VALUE\n" +
                    "          FROM synonymdomain\n" +
                    "         WHERE domainid = 'WOCLASS'\n" +
                    "           AND MAXVALUE IN ('CHANGE', 'RELEASE', 'ACTIVITY', 'WORKORDER'))\n";

            List<RelatedrecordDto> relatedrecordDtoList = sessionFactory.getCurrentSession().createSQLQuery(relatedrecordSQL)
                    .addEntity(RelatedrecordDto.class)
                    .setString("wonum", workorder.getWonum())
                    .setString("woclass", workorder.getWoclass())
                    .setString("siteid", workorder.getSiteid()).list();
            map.put("RELATEDRECORD", relatedrecordDtoList);
        }

        /*******************************************无纸化项目开始****************************************/

        /*******************************************项目管理****************************************/
        else if (apptname.equals("UDPROJECT")) {
            Udproject udproject = udprojectDao.find(Long.valueOf(pkid));
            Map<String, Object> params = new HashMap<>();
            params.put("pronum", udproject.getPronum());
            params.put("siteid", udproject.getSiteid());
            String where = "pronum=:pronum and siteid=:siteid";
            LinkedHashMap<String, String> orderby = new LinkedHashMap<>();
            orderby.put("linenum", "asc");
            List<PaperlessProjectline> projectlinegrantList = paperlessProjectlineDao.findAll(where, params, orderby);
            if (projectlinegrantList.size() > 0) {
                Map<String, Object> lineParams = new HashMap<>();
                String lineWhere = "linenum=:linenum and pronum=:pronum and siteid=:siteid";
                lineParams.put("pronum", udproject.getPronum());
                lineParams.put("siteid", udproject.getSiteid());
                LinkedHashMap<String, String> equipmentOrderby = new LinkedHashMap<>();
                equipmentOrderby.put("udequipmentid", "asc");
                LinkedHashMap<String, String> customerOrderby = new LinkedHashMap<>();
                customerOrderby.put("udcustomerid", "asc");
                for (int i = 0; i < projectlinegrantList.size(); i++) {
                    PaperlessProjectline paperlessProjectline = projectlinegrantList.get(i);
                    if (paperlessProjectline != null) {
                        Long linenum = paperlessProjectline.getLinenum();
                        if (linenum != null) {
                            lineParams.put("linenum", linenum);
                            List<PaperlessEquipment> paperlessEquipmentList = paperlessEquipmentDao.findAll(lineWhere, lineParams, equipmentOrderby);
                            List<Udcustomer> udcustomerList = udcustomerDao.findAll(lineWhere, lineParams, customerOrderby);
                            paperlessProjectline.setUdequipmentList(paperlessEquipmentList);
                            paperlessProjectline.setUdcustomerList(udcustomerList);
                        }
                    }
                }
            }
            map.put("UDPROJECTLINE", projectlinegrantList);

            //关联委派单标签页  UDDELEGATE
            String uddelegateSQL = "select ug.dlgnum,ug.pronum,ug.linenum,ug.appointperson,ug.recipient,upl.model,upl.quantity,upl.servicedep,ug.uddelegateid \n" +
                    "from UDDELEGATE ug left join UDPROJECTLINE upl on ug.PRONUM = upl.PRONUM and ug.LINENUM = upl.LINENUM and ug.SITEID = upl.SITEID \n" +
                    "where ug.PRONUM=:pronum and ug.SITEID=:siteid";
            List<DelegateDto> delegateDtoList = sessionFactory.getCurrentSession().createSQLQuery(uddelegateSQL)
                    .addEntity(DelegateDto.class)
                    .setString("pronum", udproject.getPronum())
                    .setString("siteid", udproject.getSiteid()).list();
            map.put("UDDELEGATE", delegateDtoList);

            //关联检查表单标签页
            //现场服务联络函
            String projectinfoSQL = "select pc.number,pc.pronum,pc.linenum,ps.displayname as projectmanagername,pc.creator,pc.createdate,pc.projectinfoid \n" +
                    "from PROJECTINFO pc left join UDPROJECT up on pc.PRONUM = up.PRONUM and pc.SITEID = up.SITEID left join PERSON ps on up.PROJECTMANAGER = ps.PERSONID \n" +
                    "where pc.PRONUM=:pronum and pc.SITEID=:siteid";
            List<ProjectinfoDto> projectinfoList = sessionFactory.getCurrentSession().createSQLQuery(projectinfoSQL)
                    .addEntity(ProjectinfoDto.class)
                    .setString("pronum", udproject.getPronum())
                    .setString("siteid", udproject.getSiteid()).list();
            map.put("PROJECTINFO", projectinfoList);

            //现场服务通知
            String scnotifySQL = "select usn.number,usn.pronum,usn.linenum,ps.displayname as projectmanagername,usn.creator,usn.createdate,usn.udid \n" +
                    "from UDSCENESERVICENOTIFY usn left join UDPROJECT up on usn.PRONUM = up.PRONUM and usn.SITEID = up.SITEID left join PERSON ps on up.PROJECTMANAGER = ps.PERSONID \n" +
                    "where usn.PRONUM=:pronum and usn.SITEID=:siteid";
            List<ScnotifyDto> scnotifyList = sessionFactory.getCurrentSession().createSQLQuery(scnotifySQL)
                    .addEntity(ScnotifyDto.class)
                    .setString("pronum", udproject.getPronum())
                    .setString("siteid", udproject.getSiteid()).list();
            map.put("UDSCENESERVICENOTIFY", scnotifyList);

            //现场安全计划
            String safecheckSQL = "select us.scnum,us.pronum,us.linenum,ps.displayname as projectmanagername,us.createdby,us.createddate,us.udsafecheckid \n" +
                    "from UDSAFECHECK us left join UDPROJECT up on us.PRONUM = up.PRONUM and us.SITEID = up.SITEID left join PERSON ps on up.PROJECTMANAGER = ps.PERSONID \n" +
                    "where us.PRONUM=:pronum and us.SITEID=:siteid";
            List<SafecheckDto> safecheckList = sessionFactory.getCurrentSession().createSQLQuery(safecheckSQL)
                    .addEntity(SafecheckDto.class)
                    .setString("pronum", udproject.getPronum())
                    .setString("siteid", udproject.getSiteid()).list();
            map.put("UDSAFECHECK", safecheckList);

            //现场服务安全检查
            String safecheckt2SQL = "select usc.number,usc.pronum,usc.linenum,ps.displayname as projectmanagername,usc.creator,usc.createdate,usc.udsafechecktable2id \n" +
                    "from UDSAFECHECKTABLE2 usc left join UDPROJECT up on usc.PRONUM = up.PRONUM and usc.SITEID = up.SITEID left join PERSON ps on up.PROJECTMANAGER = ps.PERSONID \n" +
                    "where usc.PRONUM=:pronum and usc.SITEID=:siteid";
            List<Safechecktable2Dto> safecheckt2List = sessionFactory.getCurrentSession().createSQLQuery(safecheckt2SQL)
                    .addEntity(Safechecktable2Dto.class)
                    .setString("pronum", udproject.getPronum())
                    .setString("siteid", udproject.getSiteid()).list();
            map.put("UDSAFECHECKTABLE2", safecheckt2List);

            //现场服务安全工作许可
            String permissionSQL = "select um.coding,um.pronum,um.linenum,um.sctnumber,um.status,ps.displayname as projectmanagername,um.createdby,um.createddate,um.udpermissionid \n" +
                    "from UDPERMISSION um left join UDPROJECT up on um.PRONUM = up.PRONUM and um.SITEID = up.SITEID left join PERSON ps on up.PROJECTMANAGER = ps.PERSONID \n" +
                    "where um.PRONUM=:pronum and um.SITEID=:siteid";
            List<PermissionDto> permissionList = sessionFactory.getCurrentSession().createSQLQuery(permissionSQL)
                    .addEntity(PermissionDto.class)
                    .setString("pronum", udproject.getPronum())
                    .setString("siteid", udproject.getSiteid()).list();
            map.put("UDPERMISSION", permissionList);

            //现场设备委托开箱
            String entrustoutSQL = "select um.number,um.pronum,um.linenum,ps.displayname as projectmanagername,um.creator,um.createdate,um.udentrustoutid \n" +
                    "from UDENTRUSTOUT um left join UDPROJECT up on um.PRONUM = up.PRONUM and um.SITEID = up.SITEID left join PERSON ps on up.PROJECTMANAGER = ps.PERSONID \n" +
                    "where um.PRONUM=:pronum and um.SITEID=:siteid";
            List<EntrustoutDto> entrustoutList = sessionFactory.getCurrentSession().createSQLQuery(entrustoutSQL)
                    .addEntity(EntrustoutDto.class)
                    .setString("pronum", udproject.getPronum())
                    .setString("siteid", udproject.getSiteid()).list();
            map.put("UDENTRUSTOUT", entrustoutList);

            //现场培训记录
            String trainrecordSQL = "select um.number,um.pronum,um.linenum,ps.displayname as projectmanagername,um.creator,um.createdate,um.udtrainrecordid \n" +
                    "from UDTRAINRECORD um left join UDPROJECT up on um.PRONUM = up.PRONUM and um.SITEID = up.SITEID left join PERSON ps on up.PROJECTMANAGER = ps.PERSONID \n" +
                    "where um.PRONUM=:pronum and um.SITEID=:siteid";
            List<TrainrecordDto> trainrecordList = sessionFactory.getCurrentSession().createSQLQuery(trainrecordSQL)
                    .addEntity(TrainrecordDto.class)
                    .setString("pronum", udproject.getPronum())
                    .setString("siteid", udproject.getSiteid()).list();
            map.put("UDTRAINRECORD", trainrecordList);

            //设备安装/调试/送电现场检查
            String nowcheckSQL = "select um.number,um.pronum,um.linenum,ps.displayname as projectmanagername,um.creator,um.createdate,um.engineer,um.checkdate,um.udnowcheckid\n" +
                    "from UDNOWCHECK um left join UDPROJECT up on um.PRONUM = up.PRONUM and um.SITEID = up.SITEID left join PERSON ps on up.PROJECTMANAGER = ps.PERSONID \n" +
                    "where um.PRONUM=:pronum and um.SITEID=:siteid";
            List<NowcheckDto> nowcheckList = sessionFactory.getCurrentSession().createSQLQuery(nowcheckSQL)
                    .addEntity(NowcheckDto.class)
                    .setString("pronum", udproject.getPronum())
                    .setString("siteid", udproject.getSiteid()).list();
            map.put("UDNOWCHECK", nowcheckList);

            //现场问题整改通知书
            String problemmodifySQL = "select um.number,um.pronum,um.linenum,ps.displayname as projectmanagername,um.creator,um.createdate,upm.description as udpmlinedesc,upm.solutiondate,um.udproblemmodifyid \n" +
                    "from UDPROBLEMMODIFY um left join UDPROJECT up on um.PRONUM = up.PRONUM and um.SITEID = up.SITEID left join PERSON ps on up.PROJECTMANAGER = ps.PERSONID \n" +
                    "left join UDPMLINE upm on um.UDPROBLEMMODIFYID=upm.UDPROBLEMMODIFYID and upm.UDPMLINEID=(select min(UDPMLINEID) from UDPMLINE m join UDPROBLEMMODIFY p on m.UDPROBLEMMODIFYID = p.UDPROBLEMMODIFYID where p.PRONUM=:pronum and p.SITEID=:siteid) \n" +
                    "where um.PRONUM=:pronum and um.SITEID=:siteid";
            List<ProblemmodifyDto> problemmodifyList = sessionFactory.getCurrentSession().createSQLQuery(problemmodifySQL)
                    .addEntity(ProblemmodifyDto.class)
                    .setString("pronum", udproject.getPronum())
                    .setString("siteid", udproject.getSiteid()).list();
            map.put("UDPROBLEMMODIFY", problemmodifyList);

            //关联检查表单标签页
            /*String workreportSQL = "";
            List<WorkreportDto> workreportList = sessionFactory.getCurrentSession().createSQLQuery(workreportSQL)
                    .addEntity(WorkreportDto.class)
                    .setString("pronum", udproject.getPronum())
                    .setString("siteid", udproject.getSiteid()).list();
            map.put("UDWORKREPORT", workreportList);*/


        }
        /*******************************************委派单****************************************/
        else if (apptname.equals("UDDELEGATE"))  // 委派单
        {
            Uddelegate uddelegate = uddelegateDao.find(Long.valueOf(pkid));
            Map<String, Object> params = new HashMap<>();
            params.put("pronum", uddelegate.getPronum());
            params.put("siteid", uddelegate.getSiteid());
            String where = "pronum=:pronum and siteid=:siteid";
            LinkedHashMap<String, String> orderby = new LinkedHashMap<>();
            orderby.put("udcustomerid", "asc");
            List<Udcustomer> UdcustomerList = udcustomerDao.findAll(where, params, orderby);
            map.put("UDCUSTOMER", UdcustomerList);
        }
        /*******************************************现场培训记录****************************************/
        else if (apptname.equals("UDTRAIN"))  // 现场培训记录
        {
            Udtrainrecord udtrainrecord = udtrainrecordDao.find(Long.valueOf(pkid));
            Map<String, Object> params = new HashMap<>();
            params.put("udtrainrecordid", udtrainrecord.getUdtrainrecordid());
            params.put("siteid", udtrainrecord.getSiteid());
            String where = "udtrainrecordid=:udtrainrecordid and siteid=:siteid";
            LinkedHashMap<String, String> orderby = new LinkedHashMap<>();
            orderby.put("number", "asc");
            List<Udtrainrecordline> udtrainrecordlineList = udtrainrecordlineDao.findAll(where, params, orderby);
            map.put("UDTRAINRECORDLINE", udtrainrecordlineList);
        }
        /*******************************************现场问题整改通知书****************************************/
        else if (apptname.equals("UDPM")) {
            Map<String, Object> params = new HashMap<>();
            params.put("udproblemmodifyid", Long.valueOf(pkid));
            String where = "udproblemmodifyid=:udproblemmodifyid";
            LinkedHashMap<String, String> orderby = new LinkedHashMap<>();
            orderby.put("number", "asc");
            List<Udpmline> pmlineList = udpmlineDao.findAll(where, params, orderby);
            map.put("PMLINE", pmlineList);
        }
        /****************************************项目安全计划(维保改造)*************************************/
        else if (apptname.equals("UDSAFE2")) {
            Udsafecheck udsafecheck = udsafecheckDao.find(Long.valueOf(pkid));
            Map<String, Object> params = new HashMap<>();
            params.put("scnum", udsafecheck.getScnum());
            params.put("siteid", udsafecheck.getSiteid());
            String where = "scnum=:scnum and siteid=:siteid";
            //人员资质与能力
            LinkedHashMap<String, String> udqualification_orderby = new LinkedHashMap<>();
            udqualification_orderby.put("udqualificationid", "asc");
            List<Udqualification> udqualification = udqualificationDao.findAll(where, params, udqualification_orderby);
            map.put("UDQUALIFICATION", udqualification);
            //化学品
            LinkedHashMap<String, String> udchemicals_orderby = new LinkedHashMap<>();
            udchemicals_orderby.put("udchemicalsid", "asc");
            List<Udchemicals> udchemicals = udchemicalsDao.findAll(where, params, udchemicals_orderby);
            map.put("UDCHEMICALS", udchemicals);
            //个人防护装备及安全用具
            LinkedHashMap<String, String> udprotective_orderby = new LinkedHashMap<>();
            udprotective_orderby.put("udprotectiveid", "asc");
            List<Udprotective> udprotective = udprotectiveDao.findAll(where, params, udprotective_orderby);
            map.put("UDPROTECTIVE", udprotective);
            //项目工作安全许可要求
            LinkedHashMap<String, String> udworkpermit_orderby = new LinkedHashMap<>();
            udworkpermit_orderby.put("udworkpermitid", "asc");
            List<Udworkpermit> udworkpermit = udworkpermitDao.findAll(where, params, udworkpermit_orderby);
            map.put("UDWORKPERMIT", udworkpermit);
            //现场安全培训
            LinkedHashMap<String, String> udtraincontent_orderby = new LinkedHashMap<>();
            udtraincontent_orderby.put("udtraincontentid", "asc");
            List<Udtraincontent> udtraincontent = udtraincontentDao.findAll(where, params, udtraincontent_orderby);
            map.put("UDTRAINCONTENT", udtraincontent);
            //安全会议
            LinkedHashMap<String, String> udsafemeeting_orderby = new LinkedHashMap<>();
            udsafemeeting_orderby.put("udsafemeetingid", "asc");
            List<Udsafemeeting> udsafemeeting = udsafemeetingDao.findAll(where, params, udsafemeeting_orderby);
            map.put("UDSAFEMEETING", udsafemeeting);
            //急救物品
            LinkedHashMap<String, String> udemergency_orderby = new LinkedHashMap<>();
            udemergency_orderby.put("udemergencyid", "asc");
            List<Udemergency> udemergency = udemergencyDao.findAll(where, params, udemergency_orderby);
            map.put("UDEMERGENCY", udemergency);
            //作业风险及项目特殊风险
            LinkedHashMap<String, String> udassignmentrisk_orderby = new LinkedHashMap<>();
            udassignmentrisk_orderby.put("udassignmentriskid", "asc");
            List<Udassignmentrisk> udassignmentrisk = udassignmentriskDao.findAll(where, params, udassignmentrisk_orderby);
            map.put("UDASSIGNMENTRISK", udassignmentrisk);
            //UDSAFELINE
            LinkedHashMap<String, String> udsafeline_orderby = new LinkedHashMap<>();
            udsafeline_orderby.put("udsafelineid", "asc");
            //开关柜检查及保养
            String where_c = "scnum=:scnum and siteid=:siteid and checkcontent='开关柜检查及保养'";
            List<Udsafeline> udsafeline_c = udsafelineDao.findAll(where_c, params, udsafeline_orderby);
            map.put("UDSAFELINE_C", udsafeline_c);
            //开关柜试验
            String where_t = "scnum=:scnum and siteid=:siteid and checkcontent='开关柜试验'";
            List<Udsafeline> udsafeline_t = udsafelineDao.findAll(where_t, params, udsafeline_orderby);
            map.put("UDSAFELINE_T", udsafeline_t);
            //VD4断路器维护保养
            String where_v = "scnum=:scnum and siteid=:siteid and checkcontent='VD4断路器维护保养'";
            List<Udsafeline> udsafeline_v = udsafelineDao.findAll(where_v, params, udsafeline_orderby);
            map.put("UDSAFELINE_V", udsafeline_v);
        }
        /**********************************************工作报告*******************************************/
        else if (apptname.equals("UDWP")) {
            Udworkreport udworkreport = udworkreportDao.find(Long.valueOf(pkid));
            Map<String, Object> params = new HashMap<>();
            params.put("udworkreportid", pkid);
            params.put("siteid", udworkreport.getSiteid());
            //工作报告
            String where_w = "udworkreportnum=:udworkreportid and siteid=:siteid";
            LinkedHashMap<String, String> orderby_w = new LinkedHashMap<>();
            orderby_w.put("udworkcontentid", "asc");
            List<Udworkcontent> udworkcontentList = udworkcontentDao.findAll(where_w, params, orderby_w);
            map.put("UDWORKCONTENT", udworkcontentList);
            //正常服务
            String where_n = "udworkreportid=:udworkreportid and siteid=:siteid";
            LinkedHashMap<String, String> orderby_n = new LinkedHashMap<>();
            orderby_n.put("udnormalid", "asc");
            List<Udnormalservice> udnormalserviceList = udnormalserviceDao.findAll(where_n, params, orderby_n);
            map.put("UDNORMALSERVICE", udnormalserviceList);
        }
        /*******************************************无纸化项目结束****************************************/

        return map;
    }

    private List getNextAuditList(String pkid, Relation audit) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        List<Object[]> nextAuditList = new LinkedList();
        List nAuditList = new LinkedList<>();

        //t2 where t1.WFASSIGNMENTID = t2.PERSONUID and ownertable = 'UDTOOLAPPLY' and t1.ownerid = 41 and assignstatus
        //in (select value from synonymdomain where domainid='WFASGNSTATUS' and maxvalue='ACTIVE')
        if (audit != null) {
            String str = "t1.assigncode,t2.displayname,t1.description,t1.processname,t1.ownertable,t1.ownerid,t1.wfassignmentid";
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("SELECT ").append(str);
            stringBuilder.append(" from WFASSIGNMENT t1 left join  PERSON t2\n" +
                    "on  t1.ASSIGNCODE = t2.PERSONID where  ");
            //ownertable = 'UDTOOLAPPLY' and t1.ownerid = 41
            stringBuilder.append("ownertable=:ownertable and ownerid=:ownerid and assignstatus in (select value\n" +
                    "                          from synonymdomain\n" +
                    "                         where domainid = 'WFASGNSTATUS'\n" +
                    "                           and maxvalue = 'ACTIVE')");
            nextAuditList = sessionFactory.getCurrentSession().createSQLQuery(stringBuilder.toString())
                    .setString("ownertable", audit.getApptable()).setString("ownerid", pkid).list();

            //构造类 反射设置值
            Map<String, Object> auditPropertyMap = new LinkedHashMap();

            List<String> pList = new LinkedList() {{
                add("assigncode");
                add("displayname");
                add("description");
                add("processname");
                add("ownertable");
                add("ownerid");
                add("wfassignmentid");
            }};
            StringBuilder nextAuditBuilder = new StringBuilder("");
            for (String e : pList) {
                nextAuditBuilder.append(e).append(",");
                auditPropertyMap.put(e, Class.forName("java.lang.Object"));
            }
            String auditFields = nextAuditBuilder.substring(0, nextAuditBuilder.length() - 1);
            String[] auditSplit = auditFields.split(",");

            dealList(nextAuditList, nAuditList, auditPropertyMap, auditSplit);
        }
        return nAuditList;
    }

    private void dealList(List<Object[]> nextAuditList, List nAuditList, Map<String, Object> auditPropertyMap, String[] auditSplit) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        for (Object[] o : nextAuditList) {
            CglibUtil auditBean = new CglibUtil(auditPropertyMap);
            Field[] auditDeclaredFields = auditBean.getObject().getClass().getDeclaredFields();

            for (int j = 0; j < auditSplit.length; j++) {
                String field = auditSplit[j];
                field = field.substring(0, 1).toUpperCase() + field.substring(1);
                String setMethodName = "set" + field;
                Object object = auditBean.getObject();
                Class[] classes = {auditDeclaredFields[j].getType()};
                Method setMethod = object.getClass().getDeclaredMethod(setMethodName, classes);
                // 处理null为空字符串
                if (null == o[j]) {
                    o[j] = "";
                }
                setMethod.invoke(object, o[j]);
            }
            nAuditList.add(auditBean.getObject());
        }
    }

    public List auditRecord(String pkid, Relation audit) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        List<Object[]> auditList = new LinkedList();
        List aList = new LinkedList<>();

        //增加审核与下一审批人关系
        if (audit != null) {
            String str = "t1.personid,t2.displayname as displayname,t1.transdate,t1.memo,t1.ownertable,t1.ownerid,t1.transid";
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("SELECT ").append(str);
            stringBuilder.append(" FROM WFTRANSACTION t1 LEFT JOIN PERSON t2 ON t1.PERSONID = t2.PERSONID where ");
            //ownertable = 'UDTOOLAPPLY' and ownerid = :udtoolapplyid
            stringBuilder.append("ownertable=:ownertable and ownerid=:ownerid ");
            auditList = sessionFactory.getCurrentSession().createSQLQuery(stringBuilder.toString())
                    .setString("ownertable", audit.getApptable()).setString("ownerid", pkid).list();

            //构造类 反射设置值
            Map<String, Object> auditPropertyMap = new LinkedHashMap();

            List<String> pList = new LinkedList() {{
                add("personid");
                add("displayname");
                add("transdate");
                add("memo");
                add("ownertable");
                add("ownerid");
                add("transid");
            }};
            StringBuilder auditBuilder = new StringBuilder("");
            for (String e : pList) {
                auditBuilder.append(e).append(",");
                auditPropertyMap.put(e, Class.forName("java.lang.Object"));
            }
            String auditFields = auditBuilder.substring(0, auditBuilder.length() - 1);
            String[] auditSplit = auditFields.split(",");

            dealList(auditList, aList, auditPropertyMap, auditSplit);
        }
        return aList;
    }

    @Override
    public void favorites(String apptname, String favorites, String loginId) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("personid", loginId.toUpperCase());
        params.put("appname", apptname);
        String where = "personid=:personid and appname=:appname";

        List<Favorite> favoriteList = favoriteDao.findAll(where, params, null);
        if (favoriteList.size() == 0) {
            Favorite favorite = new Favorite(apptname, loginId.toUpperCase(), Long.valueOf(favorites));
            favoriteDao.save(favorite);
        } else {
            int flag = 0;
            for (Favorite favorite : favoriteList) {
                if (favorite.getPkid().toString().equals(favorites)) {
                    favoriteDao.delete(favoriteList.get(0).getFavoritesid());
                    flag = 1;
                }
            }
            if (flag == 0) {
                Favorite favorite = new Favorite(apptname, loginId.toUpperCase(), Long.valueOf(favorites));
                favoriteDao.save(favorite);
            }
        }
    }

    private void constructorObject(CglibUtil bean, Field[] declaredFields, String[] split, List<Object[]> nameList) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        for (Object[] o : nameList) {
            for (int j = 0; j < split.length; j++) {
                objectConstructor(declaredFields[j], split[j], o[j], bean);
            }
        }
    }

}
