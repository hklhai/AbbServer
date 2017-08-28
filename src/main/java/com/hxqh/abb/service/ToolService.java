package com.hxqh.abb.service;

import com.hxqh.abb.model.dto.action.ToolDto;
import com.hxqh.abb.model.searchdto.Page;
import com.hxqh.abb.model.searchdto.UdtoolDto;

/**
 * Created by lh on 2017/5/10.
 */
public interface ToolService {


    ToolDto getListData(Page page) throws Exception;

    ToolDto getToolData(UdtoolDto udtoolDto, Page page) throws Exception;



}
