package com.hxqh.abb.service;

import com.hxqh.abb.common.ObjectUtil;
import com.hxqh.abb.dao.WxuserDao;
import com.hxqh.abb.model.base.SessionInfo;
import com.hxqh.abb.model.version2.Wxuser;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Ocean lin on 2017/9/5.
 */

@Transactional
@Service("weiXinService")
public class WeiXinServiceImpl implements WeiXinService {

    @Autowired
    private WxuserDao wxuserDao;

    @Override
    public void editWxuser(Wxuser wxuser, SessionInfo sessionInfo) throws Exception {
        Wxuser dbobject=wxuserDao.find(wxuser.getWxuserid());
        ObjectUtil.setEditBasicData(wxuser, sessionInfo);
        BeanUtils.copyProperties(wxuser,dbobject,ObjectUtil.getNullPropertyNames(wxuser));

        wxuserDao.update(dbobject);
    }

    @Override
    public Long addWeixinUser(Wxuser wxuser, SessionInfo sessionInfo) throws Exception {
        ObjectUtil.setAddBasicData(wxuser, sessionInfo);
        wxuserDao.save(wxuser);
        return wxuser.getWxuserid();
    }
}
