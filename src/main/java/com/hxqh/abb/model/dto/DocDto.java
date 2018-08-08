package com.hxqh.abb.model.dto;

/**
 * Created by Ocean lin on 2017/12/14.
 */
public class DocDto {

    private String document;
    private Long docinfoid;

    public DocDto(String document, Long docinfoid) {
        this.document = document;
        this.docinfoid = docinfoid;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Long getDocinfoid() {
        return docinfoid;
    }

    public void setDocinfoid(Long docinfoid) {
        this.docinfoid = docinfoid;
    }
}
