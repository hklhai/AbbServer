package com.hxqh.abb.model.dto.action;

import com.hxqh.abb.model.searchdto.Page;

import java.util.List;

/**
 * Created by Ocean lin on 2017/8/17.
 */
public class ListDto {

    private List list;
    private Page page;
    private String apptname;

    public ListDto(List list, Page page) {
        this.list = list;
        this.page = page;
    }

    public ListDto() {
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public String getApptname() {
        return apptname;
    }

    public void setApptname(String apptname) {
        this.apptname = apptname;
    }
}
