package com.hxqh.abb.service;

import com.hxqh.abb.model.assist.UdtoolDto;
import com.hxqh.abb.service.base.BaseService;

import java.util.List;

/**
 * Created by lh on 2017/5/10.
 */
public interface ToolService extends BaseService {


    public abstract List<UdtoolDto> getListData() throws Exception;
}
