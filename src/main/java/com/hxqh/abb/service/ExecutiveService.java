package com.hxqh.abb.service;

import com.hxqh.abb.model.Workorder;
import com.hxqh.abb.model.base.SessionInfo;

/**
 * Created by Ocean lin on 2017/9/5.
 */
public interface ExecutiveService {

    Long addWorkOrder(Workorder workorder, SessionInfo sessionInfo) throws Exception;

    Long editWorkOrder(Workorder workorder, SessionInfo sessionInfo) throws Exception;
}
