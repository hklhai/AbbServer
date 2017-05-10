package com.hxqh.abb.service;

import com.hxqh.abb.common.util.BeanUtilEx;
import com.hxqh.abb.dao.UdtoolDao;
import com.hxqh.abb.model.Udtool;
import com.hxqh.abb.model.assist.UdtoolDto;
import com.hxqh.abb.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lh on 2017/5/10.
 */
@Transactional
@Service("toolService")
public class ToolServiceImpl extends BaseServiceImpl<Object> implements ToolService {
    @Autowired
    private UdtoolDao udtoolDao;


    @Override
    public List<UdtoolDto> getListData() throws Exception{
        List<Udtool> udtoolList = udtoolDao.findAll(0, 15, null, null, " order by udtoolid desc");
        List<UdtoolDto> udtoolDtoList = new ArrayList<>();
        copy2UdtoolDto(udtoolList,udtoolDtoList);
        return udtoolDtoList;
    }

    private void copy2UdtoolDto(List<Udtool> udtoolList, List<UdtoolDto> udtoolDtoList) throws Exception  {
        for (int i = 0; i < udtoolList.size(); i++) {
            UdtoolDto udtoolDto = new UdtoolDto();
            BeanUtilEx.copyProperties(udtoolDto, udtoolList.get(i));
            udtoolDtoList.add(udtoolDto);
        }
    }







}
