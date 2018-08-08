package com.hxqh.abb.model.assist;

/**
 * Created by Ocean lin on 2017/11/1.
 */
public class MaximoMessage {

    private String massage;
    // {"massage":"您不是当前流程任务分配人，无权限操作"}

    private String errorMsg;
    // 无数据发送提示错误

    private String msg;
    // {"INVUSEID":"2080","msg":"工作流启动成功"}


    private String UDVEHICLEID;
    // {"UDVEHICLEID":"316","status":"UDVFWZZ"}

    private String status;

    public MaximoMessage() {
    }

    public String getUDVEHICLEID() {
        return UDVEHICLEID;
    }

    public void setUDVEHICLEID(String UDVEHICLEID) {
        this.UDVEHICLEID = UDVEHICLEID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
