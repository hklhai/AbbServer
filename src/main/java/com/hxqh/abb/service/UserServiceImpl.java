package com.hxqh.abb.service;

import com.hxqh.abb.common.util.CglibUtil;
import com.hxqh.abb.common.util.GroupListUtil;
import com.hxqh.abb.dao.TbAppDao;
import com.hxqh.abb.dao.UserDao;
import com.hxqh.abb.model.TbApp;
import com.hxqh.abb.model.User;
import com.hxqh.abb.model.dto.action.ListDto;
import com.hxqh.abb.model.searchdto.Page;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by lh on 2017/4/14.
 */
@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {

    static Map<String, TbApp> appMap = new HashMap<>();
    static Map<String, List<TbApp>> fieldsMap = new LinkedHashMap<>();

    @Autowired
    private UserDao userDao;

    @Resource
    protected SessionFactory sessionFactory;

    @Autowired
    private TbAppDao appDao;


    @PostConstruct
    public void init() {
        //主键
//        Map<String, Object> params = new HashMap<>();
//        params.put("ispk", 1);
//        String where = "ispk=:ispk ";
//
//        List<TbApp> tbApps = appDao.findAll(where, params, null);
//        for (TbApp e : tbApps) {
//            appMap.put(e.getAppname(), e);
//        }

        //属性
        Map<String, Object> fieldParams = new HashMap<>();
        fieldParams.put("APPCONTENT", "LIST");
        String fieldWhere = " APPCONTENT=:APPCONTENT ";
        List<TbApp> appList = appDao.findAll(fieldWhere, fieldParams, null);
        //对appList
        fieldsMap = GroupListUtil.group(appList, new GroupListUtil.GroupBy<String>() {
            @Override
            public String groupby(Object obj) {
                TbApp d = (TbApp) obj;
                return d.getAppname();    // 分组依据为getAppname
            }
        });

        for (TbApp e : appList) {
            if (e.getIspk() == 1) {
                appMap.put(e.getAppname(), e);
            }
        }

    }

    public List<User> getUserList() {
        return userDao.findAll();
    }

    @Override
    public ListDto vehicleListData(Page page, String apptname, String fieldsx, String searchs) throws Exception {
        StringBuilder fs = new StringBuilder("");
        Map<String, Object> propertyMap = new LinkedHashMap();

        //动态生成类
        List<TbApp> dbList = fieldsMap.get(apptname);

        String apptable = appMap.get(apptname).getApptable();
        String pkid = appMap.get(apptname).getAppfield();
        for (TbApp app : dbList) {
            //设置值
            propertyMap.put(app.getAppfield(), Class.forName(app.getFieldtype()));
            //获取字段集合
            if (!app.getAppfield().equals("ROWNUMBER")) {
                fs.append(app.getAppfield()).append(",");
            }
            if (app.getIspk() == 1) {
//                apptable = app.getApptable();
//                pkid = app.getAppfield();
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
        stringBuilder.append("SELECT * FROM (SELECT rownumber () over (ORDER BY ORDER of inner2_) AS rownumber,inner2_.*  FROM(");
        stringBuilder.append("select ").append(fields);

        StringBuilder noPageBuilder = new StringBuilder("");
        noPageBuilder.append(" from ").append(apptable);
        noPageBuilder.append(" where 1=1 ");


        stringBuilder.append(noPageBuilder);
        stringBuilder.append(" order by ").append(pkid).append(" desc ");//排序
        stringBuilder.append("FETCH FIRST ").append(page.getlastResultNumber(page.getPageNumber(), page.getPageSize())).append(" rows only");
        stringBuilder.append(") AS inner2_ ) AS inner1_ WHERE rownumber > ");
        stringBuilder.append(page.getfirstResultNumber(page.getPageNumber(), page.getPageSize()));
        stringBuilder.append(" ORDER BY rownumber");

        //查询条件判断是否是空字符串，如果是空字符串不做拼接操作
        String[] strings = searchs.split(",");
        String[] splitFileds = fields.split(",");
        //拼接
        String initString = "ROWNUMBER," + fields;
        String[] split = initString.split(",");

        SQLQuery sqlQuery = sessionFactory.getCurrentSession().createSQLQuery(stringBuilder.toString());

        if (strings.length > 0 && !strings[0].equals("")) {
            for (int i = 0; i < strings.length; i++) {
                if (!"".equals(strings[i])) {
                    noPageBuilder.append(" and ").append(splitFileds[i]).append("=:").append(splitFileds[i]);
                    sqlQuery.setString(splitFileds[i], strings[i]);
                }
            }
        }
        List list = new LinkedList<>();
        List<Object[]> nameList = sqlQuery.list();

        for (Object[] o : nameList) {
            CglibUtil bean = new CglibUtil(propertyMap);
            for (int j = 0; j < splitFileds.length; j++) {
//                String fieldName = declaredFields[j].getName().replace("$cglib_prop_", "");
//                String field = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                String field = split[j];
                String setMethodName = "set" + field;
                Object object = bean.getObject();
                Method setMethod = object.getClass().getDeclaredMethod(setMethodName, new Class[]{declaredFields[j].getType()});
                setMethod.invoke(object, o[j]);
            }
            list.add(bean.getObject());
        }

        //获取总行数
        StringBuilder countSQL = new StringBuilder("");
        countSQL.append("select count(1) as c ").append(noPageBuilder);

        SQLQuery countQuery = sessionFactory.getCurrentSession().createSQLQuery(countSQL.toString());
        for (int i = 0; i < strings.length; i++) {
            if (!"".equals(strings[i])) {
                noPageBuilder.append(" and ").append(splitFileds[i]).append("=:").append(splitFileds[i]);
                countQuery.setString(splitFileds[i], strings[i]);
            }
        }
        Object score = countQuery.addScalar("c", StandardBasicTypes.INTEGER).uniqueResult();
        Integer size = Integer.parseInt(score.toString());
        page.setTotalPageNum(size);

        return new ListDto(list, page);
    }

    @Override
    public List<TbApp> getAppInfo(String apptname) {
//        Map<String, Object> params = new HashMap<>();
//        params.put("APPNAME", apptname);
//        params.put("APPCONTENT", "LIST");
//        String where = "APPNAME=:APPNAME and APPCONTENT=:APPCONTENT";
//        List<TbApp> appList = appDao.findAll(where, params, null);
        return fieldsMap.get(apptname);
    }

}
