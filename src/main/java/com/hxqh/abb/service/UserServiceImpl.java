package com.hxqh.abb.service;

import com.hxqh.abb.common.util.CglibUtil;
import com.hxqh.abb.common.util.GroupListUtil;
import com.hxqh.abb.dao.PersonDao;
import com.hxqh.abb.dao.TbAppDao;
import com.hxqh.abb.dao.UserDao;
import com.hxqh.abb.model.Person;
import com.hxqh.abb.model.TbApp;
import com.hxqh.abb.model.User;
import com.hxqh.abb.model.base.SessionInfo;
import com.hxqh.abb.model.dto.action.DetailDto;
import com.hxqh.abb.model.dto.action.ListDto;
import com.hxqh.abb.model.searchdto.Page;
import org.apache.xpath.functions.FuncStartsWith;
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

    @Autowired
    private UserDao userDao;

    @Resource
    protected SessionFactory sessionFactory;

    @Autowired
    private TbAppDao appDao;

    @Autowired
    private PersonDao personDao;

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

        for (TbApp e : appList) {
            if (e.getIspk() == 1 && e.getAppcontent().equals("LIST")) {
                appListMap.put(e.getAppname(), e);
            } else if (e.getIspk() == 1 && e.getAppcontent().equals("DETAIL")) {
                appDetailMap.put(e.getAppname(), e);
            }
        }
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
    public ListDto vehicleListData(Page page, String apptname, String fieldsx, String searchs, String loginId) throws Exception {
        StringBuilder fs = new StringBuilder("");
        Map<String, Object> propertyMap = new LinkedHashMap();

        //动态生成类
        List<TbApp> dbList = fieldsMap.get(apptname);

        String apptable = appListMap.get(apptname).getApptable();
        String pkid = appListMap.get(apptname).getAppfield();
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

        CglibUtil bean1 = new CglibUtil(propertyMap);
        Field[] declaredFields = bean1.getObject().getClass().getDeclaredFields();
        //Class clazz = bean1.getObject().getClass();
        //System.out.println(clazz.getSimpleName());
        //Method[] methods = clazz.getDeclaredMethods();
        //for (int i = 0; i < methods.length; i++) {
        //System.out.println(methods[i].getName());
        //}

        String fields = fs.substring(0, fs.length() - 1);
        //查询语句拼接
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append("SELECT * FROM (SELECT inner2_.*,rownumber () over (ORDER BY ORDER of inner2_) AS ROWNUMBER FROM(");
        stringBuilder.append("select ").append(fields);

        StringBuilder noPageBuilder = new StringBuilder("");
        noPageBuilder.append(" from ").append(apptable);
        noPageBuilder.append(" where 1=1 ");


        stringBuilder.append(noPageBuilder);
        stringBuilder.append(" order by ").append(pkid).append(" desc ");//排序
        stringBuilder.append("FETCH FIRST ").append(page.getlastResultNumber(page.getPageNumber(), page.getPageSize())).append(" rows only");
        stringBuilder.append(") AS inner2_ ) AS inner1_ WHERE ROWNUMBER > ");
        stringBuilder.append(page.getfirstResultNumber(page.getPageNumber(), page.getPageSize()));
        stringBuilder.append(" ORDER BY ROWNUMBER");

        //查询条件判断是否是空字符串，如果是空字符串不做拼接操作
        String[] searchsStrings = searchs.split(",");
        String[] splitFileds = fields.split(",");
        //拼接
        String initString = fields + ",ROWNUMBER";
        String[] split = initString.split(",");

        SQLQuery sqlQuery = sessionFactory.getCurrentSession().createSQLQuery(stringBuilder.toString());

        if (searchsStrings.length > 0 && !searchsStrings[0].equals("")) {
            for (int i = 0; i < searchsStrings.length; i++) {
                if (!"".equals(searchsStrings[i])) {
                    noPageBuilder.append(" and ").append(splitFileds[i]).append("=:").append(splitFileds[i]);
                    sqlQuery.setString(splitFileds[i], searchsStrings[i]);
                }
            }
        }

        //list遍历，每个对象通过反射调用get得到主键值，判断主键值是否存在，若存在，调用通过反射调用set favorites方法设置值
        //获取该appname下的收藏的ID

        Map<String, Object> params = new HashMap<>();
        params.put("personid", loginId.toUpperCase());
        String where = "personid=:personid ";
        List<Person> personList = personDao.findAll(where, params, null);
        Person person = personList.get(0);
        String favor = person.getFavorites();
        String[] strings = favor.split(";");
        String[] ids = new String[30];
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].contains(apptname)) {
                ids = strings[i].split(":")[1].split(",");
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
                    for (int u = 0; u < ids.length; u++) {
                        if (id.equals(ids[u]))
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

    private void objectConstructor(Field declaredField, String field1, Object o, CglibUtil bean) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        String field = field1;
        String setMethodName = "set" + field;
        Object object = bean.getObject();
        Method setMethod = object.getClass().getDeclaredMethod(setMethodName, new Class[]{declaredField.getType()});
        setMethod.invoke(object, o);
    }


    @Override
    public DetailDto detailData(String apptname, String pkid) throws Exception {
        Map<String, Object> propertyMap = new LinkedHashMap();

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
//        Object obj = list.get(0);
        //动态生成类
        CglibUtil bean = new CglibUtil(propertyMap);
        Field[] declaredFields = bean.getObject().getClass().getDeclaredFields();
        String[] split = fields.split(",");

        List<Object[]> nameList = list;

        constructorObject(bean, declaredFields, split, nameList);
        DetailDto detailDto = new DetailDto(bean.getObject());
        return detailDto;
    }

    @Override
    public void favorites(String apptname, String favorites, SessionInfo sessionInfo) throws Exception {
        //查询Person表
        List<Person> personList = personDao.findAll("personid=" + sessionInfo.getLoginId(), null, null);
        Person person = personList.get(0);
        //判断Favorites字段是否为空
        if (person.getFavorites() == null) {
            person.setFavorites(apptname + ":" + favorites);
            personDao.update(person);
        } else {
            String f = person.getFavorites();
            String[] strings = f.split(";");
            List<String> list = new ArrayList<>();
            Collections.addAll(list, strings);
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).contains(apptname)) {
                    List<String> funcs = new ArrayList<>();
                    String[] s = list.get(i).split(":")[1].split(",");
                    Collections.addAll(funcs, s);

                    if (list.get(i).split(":")[1].contains(favorites)) {
                        funcs.remove(favorites);
                    } else {
                        funcs.add(favorites);
                    }
                    list.remove(list.get(i));
                    list.add(apptname+":"+funcs.toString());
                }
            }
            person.setFavorites(list.toString());
            personDao.update(person);
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
