package com.hxqh.abb.model.dto;

/**
 * Created by Ocean Lin on 2017/5/7.
 */
public class Message {

    private int code;
    private String message;

    public Message() {
    }

    public Message(int code, String message) {
        this.code = code;
        this.message = message;
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
}
