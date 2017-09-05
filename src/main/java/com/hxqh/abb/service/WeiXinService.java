package com.hxqh.abb.service;

import com.hxqh.abb.model.version2.Wxuser;

/**
 * Created by Ocean lin on 2017/9/5.
 */
public interface WeiXinService {
    void addWxuser(Wxuser wxuser);

    void eidtWxuser(Wxuser wxuser);
}
