package com.hxqh.abb.service;

import com.hxqh.abb.model.Udtool;
import com.hxqh.abb.model.UdtoolApply;
import com.hxqh.abb.model.UdtoolChk;
import com.hxqh.abb.model.UdtoolLend;
import com.hxqh.abb.model.base.SessionInfo;
import com.hxqh.abb.model.dto.action.ToolDto;
import com.hxqh.abb.model.dto.action.UdtoolchklineDto;
import com.hxqh.abb.model.searchdto.Page;
import com.hxqh.abb.model.searchdto.UdtoolDto;
import com.hxqh.abb.model.version2.Udtoolchkline;

import java.util.List;

/**
 * Created by lh on 2017/5/10.
 */
public interface ToolService {

    /*****************************************一期*****************************************/

    ToolDto getListData(Page page) throws Exception;

    ToolDto getToolData(UdtoolDto udtoolDto, Page page) throws Exception;

    /*****************************************一期*****************************************/

    Long addToolAccount(Udtool udtool, SessionInfo sessionInfo) throws Exception;

    Long addToolLend(UdtoolLend udtoolLend, SessionInfo sessionInfo) throws Exception;

    Long addToolApply(UdtoolApply udtoolApply, SessionInfo sessionInfo) throws Exception;

    Long addToolCHK(UdtoolChk udtoolChk, SessionInfo sessionInfo) throws Exception;

    void editToolAccount(Udtool udtool, SessionInfo sessionInfo) throws Exception;

    void editToolLend(UdtoolLend udtoolLend, SessionInfo sessionInfo) throws Exception;

    void editToolApply(UdtoolApply udtoolApply, SessionInfo sessionInfo) throws Exception;

    void editToolCHK(UdtoolChk udtoolChk, SessionInfo sessionInfo) throws Exception;
}
