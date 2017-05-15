package com.hxqh.abb.service;

import com.hxqh.abb.model.searchdto.UdtoolDto;
import com.hxqh.abb.model.view.AbbUdtool;
import com.hxqh.abb.service.base.BaseService;

import java.util.List;

/**
 * Created by lh on 2017/5/10.
 */
public interface ToolService extends BaseService {


    public abstract List<AbbUdtool> getListData(UdtoolDto udtoolDto) throws Exception;
}
