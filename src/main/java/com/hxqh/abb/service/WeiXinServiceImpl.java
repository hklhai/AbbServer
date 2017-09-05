package com.hxqh.abb.service;

import com.hxqh.abb.dao.WxuserDao;
import com.hxqh.abb.model.version2.Wxuser;
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
    public void addWxuser(Wxuser wxuser) {
        wxuserDao.save(wxuser);
    }

    @Override
    public void eidtWxuser(Wxuser wxuser) {
        wxuserDao.update(wxuser);

    }
}
