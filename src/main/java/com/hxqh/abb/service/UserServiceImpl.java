package com.hxqh.abb.service;

import com.hxqh.abb.common.util.CglibUtil;
import com.hxqh.abb.dao.TbAppDao;
import com.hxqh.abb.dao.UserDao;
import com.hxqh.abb.model.TbApp;
import com.hxqh.abb.model.User;
import com.hxqh.abb.model.dto.action.ListDto;
import com.hxqh.abb.model.searchdto.Page;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by lh on 2017/4/14.
 */
@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Resource
    protected SessionFactory sessionFactory;

    @Autowired
    private TbAppDao appDao;


    public List<User> getUserList() {
        return userDao.findAll();
    }


    @Override
    public ListDto vehicleListData(Page page, String apptname, String apptable, String pkid, String fieldsx, String searchs) throws Exception {
        StringBuilder fs = new StringBuilder("");

        //动态生成类
        List<TbApp> appList = getAppInfo(apptname);
        Map propertyMap = new HashMap();
        for (TbApp app : appList) {
            //设置值
            propertyMap.put(app.getAppfield(), Class.forName(app.getFieldtype()));
            //获取字段集合
            fs.append(app.getAppfield()).append(",");
            apptable = app.getApptable();
        }

        CglibUtil bean1 = new CglibUtil(propertyMap);
        Field[] declaredFields = bean1.getObject().getClass().getDeclaredFields();
        Class clazz = bean1.getObject().getClass();
        System.out.println(clazz.getSimpleName());
        Method[] methods = clazz.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.println(methods[i].getName());
        }

        String fields = fs.substring(0, fs.length() - 1);
        //查询语句拼接
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append("SELECT * FROM (SELECT inner2_.*, rownumber () over (ORDER BY ORDER of inner2_) AS rownumber_ FROM(");
        stringBuilder.append("select ").append(fields);

        StringBuilder noPageBuilder = new StringBuilder("");
        noPageBuilder.append(" from ").append(apptable);
        noPageBuilder.append(" where 1=1 ");


        stringBuilder.append(noPageBuilder);
        stringBuilder.append(" order by ").append(pkid).append(" desc ");//排序
        stringBuilder.append("FETCH FIRST ").append(page.getThisPageLastElementNumber()).append("rows only");
        stringBuilder.append(") AS inner2_ ) AS inner1_ WHERE rownumber_ > ");
        stringBuilder.append(page.getThisPageFirstElementNumber() - 1);
        stringBuilder.append("ORDER BY rownumber_");

        //查询条件判断是否是空字符串，如果是空字符串不做拼接操作
        String[] strings = searchs.split(",");
        String[] splitFileds = fields.split(",");
        SQLQuery sqlQuery = sessionFactory.getCurrentSession().createSQLQuery(stringBuilder.toString());

        for (int i = 0; i < strings.length; i++) {
            if (!"".equals(strings[i])) {
                noPageBuilder.append(" and ").append(splitFileds[i]).append("=:").append(splitFileds[i]);
                sqlQuery.setString(splitFileds[i], strings[i]);
            }
        }

        List list = new LinkedList<>();
        List<Object[]> nameList = sqlQuery.list();
        for (Object[] o : nameList) {
            CglibUtil bean = new CglibUtil(propertyMap);

            int len = o.length;
            for (int j = 0; j < len; j++) {
                String fieldName = declaredFields[j].getName().replace("$cglib_prop_", "");
                String setMethodName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                Method setMethod = bean.getObject().getClass().getDeclaredMethod(setMethodName, new Class[]{declaredFields[j].getType()});
                setMethod.invoke(bean.getObject(), o[j]);
            }
            list.add(bean.getObject());
        }

        //获取总行数
        StringBuilder countSQL = new StringBuilder("");
        countSQL.append("select count(1) ").append(noPageBuilder);

        SQLQuery countQuery = sessionFactory.getCurrentSession().createSQLQuery(countSQL.toString());
        for (int i = 0; i < strings.length; i++) {
            if (!"".equals(strings[i])) {
                noPageBuilder.append(" and ").append(splitFileds[i]).append("=:").append(splitFileds[i]);
                countQuery.setString(splitFileds[i], strings[i]);
            }
        }
        page.setTotalPageNum(((Long) countQuery.iterate().next()).intValue());

        //TODO test
        return new ListDto(list, page);
    }

    @Override
    public List<TbApp> getAppInfo(String apptname) {
        Map<String, Object> params = new HashMap<>();
        params.put("APPTNAME", apptname);
        params.put("APPCONTENT", "LIST");
        String where = "APPNAME=:APPNAME and  APPCONTENT=:APPCONTENT";

        //TODO 可以把主键初始化
        return appDao.findAll(where, params, null);
//        return null;
    }

}
