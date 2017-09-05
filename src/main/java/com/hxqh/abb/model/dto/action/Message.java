package com.hxqh.abb.model.dto.action;

/**
 * Created by Ocean Lin on 2017/5/7.
 */
public class Message {

    private int code;
    private String message;
    private boolean success;
    private Long aLong;

    public Message() {
    }

    public Message(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Message(int code, String message, boolean success) {
        this.code = code;
        this.message = message;
        this.success = success;
    }

    public Message(int code, String message, Long aLong) {
        this.code = code;
        this.message = message;
        this.aLong = aLong;
    }

    public Long getaLong() {
        return aLong;
    }

    public void setaLong(Long aLong) {
        this.aLong = aLong;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
