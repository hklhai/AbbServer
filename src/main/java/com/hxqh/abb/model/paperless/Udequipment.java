package com.hxqh.abb.model.paperless;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Administrator on 2017-10-09.
 */
@Entity
@Table(name="UDEQUIPMENT")
@DynamicUpdate
public class Udequipment  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="UDEQUIPMENT_UDEQUIPMENTID_GENERATOR", sequenceName="UDEQUIPMENTIDSEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UDEQUIPMENT_UDEQUIPMENTID_GENERATOR")
    private Long udequipmentid;
    private String description;
    private String orgid;
    private String siteid;
    private Long hasld;
    private Double quantity;
    private String pronum;
    private Long linenum;
    private String model;
    private Long rowstamp;
    private String equnum;
    private Long col1 = Long.valueOf(0);
    private Long col2 = Long.valueOf(0);
    private Long col3 = Long.valueOf(0);
    private Long col4 = Long.valueOf(0);
    private Long col5 = Long.valueOf(0);
    private Long col6 = Long.valueOf(0);
    private Long col7 = Long.valueOf(0);
    private Long col8 = Long.valueOf(0);
    private Long col9 = Long.valueOf(0);
    private Long col10 = Long.valueOf(0);
    private Long col11 = Long.valueOf(0);
    private Long col12 = Long.valueOf(0);
    private Long col13 = Long.valueOf(0);
    private Long col14 = Long.valueOf(0);
    private Long col15 = Long.valueOf(0);
    private Long col16 = Long.valueOf(0);
    private Long col17 = Long.valueOf(0);
    private Long col18 = Long.valueOf(0);
    private Long col19 = Long.valueOf(0);


    @Transient
    private Long equipmentid;
    @Transient
    private String equnumdesc;
    @Transient
    private String udmodel;
    @Transient
    private String locationdesc;
    @Transient
    private String isdelete;

    public String getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(String isdelete) {
        this.isdelete = isdelete;
    }

    public Long getEquipmentid() {
        return equipmentid;
    }

    public void setEquipmentid(Long equipmentid) {
        this.equipmentid = equipmentid;
    }

    public String getEqunumdesc() {
        return equnumdesc;
    }

    public void setEqunumdesc(String equnumdesc) {
        this.equnumdesc = equnumdesc;
    }

    public String getUdmodel() {
        return udmodel;
    }

    public void setUdmodel(String udmodel) {
        this.udmodel = udmodel;
    }

    public String getLocationdesc() {
        return locationdesc;
    }

    public void setLocationdesc(String locationdesc) {
        this.locationdesc = locationdesc;
    }

    public Long getUdequipmentid() {
        return udequipmentid;
    }

    public void setUdequipmentid(Long udequipmentid) {
        this.udequipmentid = udequipmentid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrgid() {
        return orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid;
    }

    public String getSiteid() {
        return siteid;
    }

    public void setSiteid(String siteid) {
        this.siteid = siteid;
    }

    public Long getHasld() {
        return hasld;
    }

    public void setHasld(Long hasld) {
        this.hasld = hasld;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getPronum() {
        return pronum;
    }

    public void setPronum(String pronum) {
        this.pronum = pronum;
    }

    public Long getLinenum() {
        return linenum;
    }

    public void setLinenum(Long linenum) {
        this.linenum = linenum;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getRowstamp() {
        return rowstamp;
    }

    public void setRowstamp(Long rowstamp) {
        this.rowstamp = rowstamp;
    }

    public String getEqunum() {
        return equnum;
    }

    public void setEqunum(String equnum) {
        this.equnum = equnum;
    }

    public Long getCol1() {
        return col1;
    }

    public void setCol1(Long col1) {
        this.col1 = col1;
    }

    public Long getCol2() {
        return col2;
    }

    public void setCol2(Long col2) {
        this.col2 = col2;
    }

    public Long getCol3() {
        return col3;
    }

    public void setCol3(Long col3) {
        this.col3 = col3;
    }

    public Long getCol4() {
        return col4;
    }

    public void setCol4(Long col4) {
        this.col4 = col4;
    }

    public Long getCol5() {
        return col5;
    }

    public void setCol5(Long col5) {
        this.col5 = col5;
    }

    public Long getCol6() {
        return col6;
    }

    public void setCol6(Long col6) {
        this.col6 = col6;
    }

    public Long getCol7() {
        return col7;
    }

    public void setCol7(Long col7) {
        this.col7 = col7;
    }

    public Long getCol8() {
        return col8;
    }

    public void setCol8(Long col8) {
        this.col8 = col8;
    }

    public Long getCol9() {
        return col9;
    }

    public void setCol9(Long col9) {
        this.col9 = col9;
    }

    public Long getCol10() {
        return col10;
    }

    public void setCol10(Long col10) {
        this.col10 = col10;
    }

    public Long getCol11() {
        return col11;
    }

    public void setCol11(Long col11) {
        this.col11 = col11;
    }

    public Long getCol12() {
        return col12;
    }

    public void setCol12(Long col12) {
        this.col12 = col12;
    }

    public Long getCol13() {
        return col13;
    }

    public void setCol13(Long col13) {
        this.col13 = col13;
    }

    public Long getCol14() {
        return col14;
    }

    public void setCol14(Long col14) {
        this.col14 = col14;
    }

    public Long getCol15() {
        return col15;
    }

    public void setCol15(Long col15) {
        this.col15 = col15;
    }

    public Long getCol16() {
        return col16;
    }

    public void setCol16(Long col16) {
        this.col16 = col16;
    }

    public Long getCol17() {
        return col17;
    }

    public void setCol17(Long col17) {
        this.col17 = col17;
    }

    public Long getCol18() {
        return col18;
    }

    public void setCol18(Long col18) {
        this.col18 = col18;
    }

    public Long getCol19() {
        return col19;
    }

    public void setCol19(Long col19) {
        this.col19 = col19;
    }
}
