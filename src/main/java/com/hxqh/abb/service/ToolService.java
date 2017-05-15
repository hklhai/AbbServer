package com.hxqh.abb.service;

import com.hxqh.abb.common.Page;
import com.hxqh.abb.model.dto.ToolDto;
import com.hxqh.abb.model.searchdto.UdtoolDto;
import com.hxqh.abb.model.view.AbbUdtool;
import com.hxqh.abb.service.base.BaseService;

import java.util.List;

/**
 * Created by lh on 2017/5/10.
 */
public interface ToolService extends BaseService {


    public abstract ToolDto getListData() throws Exception;

    public abstract List<AbbUdtool> getToolData(UdtoolDto udtoolDto,Page page) throws Exception;
}
