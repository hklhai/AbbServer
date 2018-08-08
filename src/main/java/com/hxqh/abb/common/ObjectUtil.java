package com.hxqh.abb.common;

import com.hxqh.abb.model.assist.UserInfoAdd;
import com.hxqh.abb.model.assist.UserInfoEdit;
import com.hxqh.abb.model.base.SessionInfo;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ocean lin on 2017/9/13.
 */
public class ObjectUtil {

    private static final String STATUS = "空闲";

    public static void setAddBasicData(Object object, SessionInfo sessionInfo) throws Exception {
        //获取属性Object中的siteid、orgid、createby、changeby  createddate、changedate
        UserInfoAdd userInfoAdd = new UserInfoAdd();
        userInfoAdd.setChangedate(new Date());
        userInfoAdd.setCreatedate(new Date());
        userInfoAdd.setStatus(STATUS);
        userInfoAdd.setStatusdate(new Date());
        userInfoAdd.setHasld(0);
        userInfoAdd.setRowstamp(new Long(10000));
        userInfoAdd.setOrgid(sessionInfo.getOrg());
        userInfoAdd.setSiteid(sessionInfo.getSite());
        userInfoAdd.setChangeby(sessionInfo.getCreate());
        userInfoAdd.setCreateby(sessionInfo.getCreate());


        // 无奈的添加
        userInfoAdd.setCreatedby(sessionInfo.getCreate());
        userInfoAdd.setCreateddate(new Date());
        // 再次无奈的添加
        userInfoAdd.setChengdate(new Date());

        BeanUtils.copyProperties(object, userInfoAdd);
    }


    public static void setEditBasicData(Object object, SessionInfo sessionInfo) throws Exception {
        //仅设置changeby、changedate
        UserInfoEdit userInfoEdit = new UserInfoEdit();
        userInfoEdit.setChangeby(sessionInfo.getCreate());
        userInfoEdit.setChangedate(new Date());
        BeanUtils.copyProperties(object, userInfoEdit);
    }


    /**
     * @param source 要拷贝的对象
     * @return
     * @Description <p>获取到对象中属性为null的属性名  </P>
     */
    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null)
                emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}
