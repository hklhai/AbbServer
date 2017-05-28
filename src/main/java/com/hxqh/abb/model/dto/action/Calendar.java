package com.hxqh.abb.model.dto.action;

import java.util.Date;
import java.util.List;

/**
 * Created by Ocean Lin on 2017/5/28.
 */
public class Calendar {

    private Date targstartdate;

    private List<String> wonum;

    public Calendar() {
    }

    public Calendar(Date targstartdate, List<String> wonum) {
        this.targstartdate = targstartdate;
        this.wonum = wonum;
    }

    public Date getTargstartdate() {
        return targstartdate;
    }

    public void setTargstartdate(Date targstartdate) {
        this.targstartdate = targstartdate;
    }

    public List<String> getWonum() {
        return wonum;
    }

    public void setWonum(List<String> wonum) {
        this.wonum = wonum;
    }
}
