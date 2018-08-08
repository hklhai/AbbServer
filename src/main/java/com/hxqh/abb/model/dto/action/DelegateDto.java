package com.hxqh.abb.model.dto.action;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by fuyg on 2017-11-23.
 */
@Entity
public class DelegateDto {
    @Id
    private Long uddelegateid;
    private String dlgnum;
    private String pronum;
    private String linenum;
    private String appointperson;
    private String recipient;
    private String model;
    private BigDecimal quantity;
    private String servicedep;

    public DelegateDto() {
    }

    public Long getUddelegateid() {
        return uddelegateid;
    }

    public void setUddelegateid(Long uddelegateid) {
        this.uddelegateid = uddelegateid;
    }

    public String getDlgnum() {
        return dlgnum;
    }

    public void setDlgnum(String dlgnum) {
        this.dlgnum = dlgnum;
    }

    public String getPronum() {
        return pronum;
    }

    public void setPronum(String pronum) {
        this.pronum = pronum;
    }

    public String getLinenum() {
        return linenum;
    }

    public void setLinenum(String linenum) {
        this.linenum = linenum;
    }

    public String getAppointperson() {
        return appointperson;
    }

    public void setAppointperson(String appointperson) {
        this.appointperson = appointperson;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getServicedep() {
        return servicedep;
    }

    public void setServicedep(String servicedep) {
        this.servicedep = servicedep;
    }
}
