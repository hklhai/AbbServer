package com.hxqh.abb.service;

import com.hxqh.abb.model.base.SessionInfo;
import com.hxqh.abb.model.version2.Wxuser;

/**
 * Created by Ocean lin on 2017/9/5.
 */
public interface WeiXinService {

    void editWxuser(Wxuser wxuser, SessionInfo sessionInfo) throws Exception;

    Long addWeixinUser(Wxuser wxuser, SessionInfo sessionInfo) throws Exception;
}
