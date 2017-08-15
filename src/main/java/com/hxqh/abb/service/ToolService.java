package com.hxqh.abb.service;

import com.hxqh.abb.model.Udtool;
import com.hxqh.abb.model.UdtoolApply;
import com.hxqh.abb.model.UdtoolChk;
import com.hxqh.abb.model.UdtoolLend;
import com.hxqh.abb.model.dto.action.ToolDto;
import com.hxqh.abb.model.searchdto.Page;
import com.hxqh.abb.model.searchdto.UdtoolDto;
import com.hxqh.abb.model.view.AbbUdtool;

import java.util.List;

/**
 * Created by lh on 2017/5/10.
 */
public interface ToolService {


    public abstract ToolDto getListData(Page page) throws Exception;

    public abstract ToolDto getToolData(UdtoolDto udtoolDto, Page page) throws Exception;
    /***************************************/
    /**
     * 工具借还
     **/

    List<UdtoolLend> getUdtoolLendList();

    UdtoolLend getUdtoolLendId(Long udtoollendid);

    void addUdtoolLend(UdtoolLend udtoolLend);

    void updateUdtoolLend(UdtoolLend ul);

    void delUdtoolLend(long l);


    /**************************************/
    /**
     * 工具修丢废
     **/
    List<UdtoolApply> getUdtoolApplyList();

    UdtoolApply getUdtoolApplyId(Long udtoolapplyid);

    void addUdtoolApply(UdtoolApply udtoolApply);

    void updateUdtoolApply(UdtoolApply ua);

    void delUdtoolApply(long l);


    /**************************************/
    /**
     * 工具台账
     **/

    List<AbbUdtool> getUdtoolList();

    AbbUdtool getAbbUdtoolId(Long udtoolid);

    /**************************************/
    /**
     * 工具校准
     **/

    List<UdtoolChk> getUdtoolChkList();

    UdtoolChk getUdtoolChkId(Long udtoolchkid);
    /**************************************/


}
