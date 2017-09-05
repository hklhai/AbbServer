package com.hxqh.abb.service;

import com.hxqh.abb.common.util.CglibUtil;
import com.hxqh.abb.common.util.GroupListUtil;
import com.hxqh.abb.dao.*;
import com.hxqh.abb.model.*;
import com.hxqh.abb.model.dto.action.DetailDto;
import com.hxqh.abb.model.dto.action.ListDto;
import com.hxqh.abb.model.dto.action.WplaborDto;
import com.hxqh.abb.model.searchdto.Page;
import com.hxqh.abb.model.version2.*;
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
@Service("userService")
public class UserServiceImpl implements UserService {

    static Map<String, TbApp> appListMap = new HashMap<>();
    static Map<String, TbApp> appDetailMap = new HashMap<>();
    static Map<String, List<TbApp>> fieldsMap = new LinkedHashMap<>();
    static Map<String, List<TbApp>> detailMap = new LinkedHashMap<>();
    static Map<String, List<TbApp>> childMap = new LinkedHashMap<>();
    static Map<String, List<Relation>> relativeMap = new LinkedHashMap<>();

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

    @PostConstruct
    public void init() {

        List<TbApp> appList = appDao.findAll();
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

        for (TbApp e : appList) {
            if (e.getIspk() == 1 && e.getAppcontent().equals("LIST")) {
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
    public TbApp getAppName(String apptname) {
        return appListMap.get(apptname);
    }

    public List<User> getUserList() {
        return userDao.findAll();
    }

    @Override
    public ListDto vehicleListData(Page page, String apptname, String isFavorite, String searchs, String loginId) throws Exception {
        StringBuilder fs = new StringBuilder("");
        Map<String, Object> propertyMap = new LinkedHashMap();

        List<TbApp> dbList = fieldsMap.get(apptname);
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
        noPageBuilder.append(" from ").append(apptable).append(" where 1=1 ");


        //list遍历，每个对象通过反射调用get得到主键值，判断主键值是否存在，若存在，调用通过反射调用set favorites方法设置值
        //获取该appname下的收藏的ID
        Map<String, Object> params = new HashMap<>();
        params.put("personid", loginId.toUpperCase());
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

        stringBuilder.append(noPageBuilder);
        stringBuilder.append(" order by ").append(pkid).append(" desc ");//排序
        stringBuilder.append("FETCH FIRST ").append(page.getlastResultNumber(page.getPageNumber(), page.getPageSize()));
        stringBuilder.append(" rows only ) AS inner2_ ) AS inner1_ WHERE ROWNUMBER > ");
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
        String setMethodName = "set" + field;
        Object object = bean.getObject();
        Method setMethod = object.getClass().getDeclaredMethod(setMethodName, new Class[]{declaredField.getType()});
        setMethod.invoke(object, o);
    }


    @Override
    public DetailDto detailData(String apptname, String pkid) throws Exception {
        Map<String, Object> propertyMap = new LinkedHashMap<>();

        //获取表名与主键名称
        String tableName = appDetailMap.get(apptname).getApptable();
        String pkName = appDetailMap.get(apptname).getAppfield();
        //属性值
        List<TbApp> appList = fieldsMap.get(apptname);
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

    private Map<String, List> getChildMapInfo(String apptname, String pkid) {
        Map<String, List> map = new LinkedHashMap<>();

        Workorder workorder = workorderDao.find(Long.valueOf(pkid));


        if (apptname.equals("TOOLCHK")) { //工具校准行页面 信息
            UdtoolChk udtoolChk = udtoolChkDao.find(Long.valueOf(pkid));

            Map<String, Object> params = new HashMap<>();
            params.put("tcnum", udtoolChk.getTcnum());
            String where = "tcnum=:tcnum";

            LinkedHashMap<String, String> orderby = new LinkedHashMap<>();
            orderby.put("udtoolchklineid", "asc");
            List<VUdtoolchkline> udtoolchklineList = vUdtoolchklineDao.findAll(where, params, orderby);
            map.put("UDTOOLCHKLINE", udtoolchklineList);
        } else if (apptname.equals("INVUSE"))  //物资发放页面 信息
        {
            Invuse invuse = invuseDao.find(Long.valueOf(pkid));
            //TODO
//            Map<String, Object> params = new HashMap<>();
//            params.put("invusenum", invuse.getInvusenum());
//            params.put("siteid", invuse.getSiteid());
//            String where = "invusenum=:invusenum and siteid=:siteid";
//
//            LinkedHashMap<String, String> orderby = new LinkedHashMap<>();
//            orderby.put("invuseid", "asc");


        } else if (apptname.equals("INVENTORYCHK"))  //盘点清单信息
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
        } else if (apptname.equals("PURCHASEODER") || apptname.equals("PORECEIVE") || apptname.equals("WASTERECOVERY")) {          //采购清单信息、旧料回收清单、废料回收清单
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
        } else if (apptname.equals("PORECEIVE"))  // 接收清单
        {
            Po po = poDao.find(Long.valueOf(pkid));

            Map<String, Object> params = new HashMap<>();
            params.put("ponum", po.getPonum());
            params.put("positeid", po.getSiteid());
            String where = "ponum = :ponum and positeid=:positeid";

            LinkedHashMap<String, String> orderby = new LinkedHashMap<>();
            orderby.put("polineid", "asc");
            //TODO 缺少字段
            //.findAll(where, params, orderby);
        } else if (apptname.equals("WORKORDERMANAGEMENT"))//执行管理
        {
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

            //WOACTIVITY
            LinkedHashMap<String, String> orderbyWoactivity = new LinkedHashMap<>();
            orderbyUdwoqualification.put("workorderid", "asc");
            List<Woactivity> woactivityList = woactivityDao.findAll(where, params, orderbyWoactivity);
            map.put("WOACTIVITY", woactivityList);


            //WPLABOR
            String sqlWplabor = "SELECT WPLABORUID, LABORCODE, LABORHRS, TASKID, WONUM,SITEID\n" +
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

            //WPMATERIAL
            //TODO 建议增加WPMATERIAL主键
//            String sqlWpmaterial =  "select ITEMNUM,\n" +
//                    "       DESCRIPTION,\n" +
//                    "       ITEMQTY,\n" +
//                    "       UNITCOST,\n" +
//                    "       LINECOST,\n" +
//                    "       LOCATION,\n" +
//                    "       STORELOCSITE,\n" +
//                    "       ISSUETO,\n" +
//                    "       REQUESTBY\n" +
//                    "  from WPMATERIAL\n" +
//                    " where wonum IN\n" +
//                    "       (SELECT wonum\n" +
//                    "          FROM workorder\n" +
//                    "         WHERE (wonum = :wonum OR (parent = :wonum AND istask = 1))\n" +
//                    "           AND siteid = :siteid)";
//            sessionFactory.getCurrentSession().createSQLQuery(sqlWpmaterial)
//                    .addEntity(.class).setString("wonum", workorder.getWonum())
//                    .setString("siteid", workorder.getSiteid()).list();
        }


        return map;
    }

    private List getNextAuditList(String pkid, Relation audit) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        List<Object[]> nextAuditList = new LinkedList();
        List nAuditList = new LinkedList<>();

        //t2 where t1.WFASSIGNMENTID = t2.PERSONUID and ownertable = 'UDTOOLAPPLY' and t1.ownerid = 41 and assignstatus
        //in (select value from synonymdomain where domainid='WFASGNSTATUS' and maxvalue='ACTIVE')
        if (audit != null) {
            String str = "T1.ASSIGNCODE,T2.DISPLAYNAME,T1.DESCRIPTION,T1.PROCESSNAME,T1.OWNERTABLE,T1.OWNERID,T1.WFASSIGNMENTID";
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("SELECT ").append(str);
            stringBuilder.append(" from WFASSIGNMENT t1,PERSON t2 where t1.WFASSIGNMENTID = t2.PERSONUID and ");
            //ownertable = 'UDTOOLAPPLY' and t1.ownerid = 41
            stringBuilder.append("ownertable=:ownertable and ownerid=:ownerid ");
            nextAuditList = sessionFactory.getCurrentSession().createSQLQuery(stringBuilder.toString())
                    .setString("ownertable", audit.getApptable()).setString("ownerid", pkid).list();

            //构造类 反射设置值
            Map<String, Object> auditPropertyMap = new LinkedHashMap();

            List<String> pList = new LinkedList() {{
                add("ASSIGNCODE");
                add("DISPLAYNAME");
                add("DESCRIPTION");
                add("PROCESSNAME");
                add("OWNERTABLE");
                add("OWNERID");
                add("WFASSIGNMENTID");
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
                String setMethodName = "set" + field;
                Object object = auditBean.getObject();
                Class[] classes = {auditDeclaredFields[j].getType()};
                Method setMethod = object.getClass().getDeclaredMethod(setMethodName, classes);
                setMethod.invoke(object, o[j]);
            }
            nAuditList.add(auditBean.getObject());
        }
    }

    private List auditRecord(String pkid, Relation audit) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        List<Object[]> auditList = new LinkedList();
        List aList = new LinkedList<>();

        //增加审核与下一审批人关系
        if (audit != null) {
            String str = "T1.PERSONID,T2.DISPLAYNAME AS DISPLAYNAME,T1.TRANSDATE,T1.MEMO,T1.OWNERTABLE,T1.OWNERID,T1.TRANSID";
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
                add("PERSONID");
                add("DISPLAYNAME");
                add("TRANSDATE");
                add("MEMO");
                add("OWNERTABLE");
                add("OWNERID");
                add("TRANSID");
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
