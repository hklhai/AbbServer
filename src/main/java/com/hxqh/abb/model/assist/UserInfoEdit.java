package com.hxqh.abb.model.assist;

import java.util.Date;

/**
 * Created by Ocean lin on 2017/9/13.
 */
public class UserInfoEdit {

    private String changeby;

    private Date changedate;

    public UserInfoEdit() {
    }

    public String getChangeby() {
        return changeby;
    }

    public void setChangeby(String changeby) {
        this.changeby = changeby;
    }

    public Date getChangedate() {
        return changedate;
    }

    public void setChangedate(Date changedate) {
        this.changedate = changedate;
    }
}
