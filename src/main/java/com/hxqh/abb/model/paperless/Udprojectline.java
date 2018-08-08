package com.hxqh.abb.model.paperless;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by fuyg on 2017-09-30.
 */
@Entity
@Table(name="UDPROJECTLINE")
@DynamicUpdate
public class Udprojectline implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name="UDPROJECTLINE_UDPROJECTLINEID_GENERATOR", allocationSize = 1 , sequenceName="UDPROJECTLINEIDSEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UDPROJECTLINE_UDPROJECTLINEID_GENERATOR")
    private Long udprojectlineid;
    private String description;
    private String orgid;
    private String siteid;
    private Long hasld;
    private String edengineer;
    private String mdengineer;
    private String equipmentnum;
    private Date actualcompletedate;
    private Date actualcompletiondate;
    private Date actualdebugdate;
    private Date actualinstalldate;
    private Date actualsendpowerdate;
    private Date actualshipmentdate;
    private String childservicepro;
    private String mainservicepro;
    private String projectmanager;
    private Date palncompletiondate;
    private Date palndebugdate;
    private Date palnsendpowerdate;
    private Date palnshipmentdate;
    private Date plancompletedate;
    private Date planinstalldate;
    private Date qualitymaturitydate;
    private Double quantity;
    private String servicedep;
    private Double workinghours;
    private String industryattributes;
    private Long busbridge;
    private Long protectprogram;
    private String protecttype;
    private Double protectqty;
    private String provinces;
    private String city;
    private String address;
    private String salesengineer;
    private String pronum;
    private Long linenum;
    private String model;
    private Long rowstamp;
    private String ctrnum;
    private String areamanager;
    private String servicemanager;
    private Long kv;
    private String producer;
    private String area1;
    private Long udisjj = Long.valueOf(0);

    @Transient
    private String areamanagername;
    @Transient
    private String servicemanagername;
    @Transient
    private Long frontedid;
    @Transient
    private String udcustomerdeletes;
    @Transient
    private List<Udcustomer> udcustomerList;
    @Transient
    private String udequipmentdeletes;
    @Transient
    private List<Udequipment> udequipmentList;

    public Udprojectline() {
    }

    public Long getFrontedid() {
        return frontedid;
    }

    public void setFrontedid(Long frontedid) {
        this.frontedid = frontedid;
    }

    public Long getUdisjj() {
        return udisjj;
    }

    public void setUdisjj(Long udisjj) {
        if(udisjj==null){
            this.udisjj = Long.valueOf(0);
        }else {
            this.udisjj = udisjj;
        }
    }

    public String getAreamanagername() {
        return areamanagername;
    }

    public void setAreamanagername(String areamanagername) {
        this.areamanagername = areamanagername;
    }

    public String getServicemanagername() {
        return servicemanagername;
    }

    public void setServicemanagername(String servicemanagername) {
        this.servicemanagername = servicemanagername;
    }

    public String getUdcustomerdeletes() {
        return udcustomerdeletes;
    }

    public void setUdcustomerdeletes(String udcustomerdeletes) {
        this.udcustomerdeletes = udcustomerdeletes;
    }

    public List<Udcustomer> getUdcustomerList() {
        return udcustomerList;
    }

    public void setUdcustomerList(List<Udcustomer> udcustomerList) {
        this.udcustomerList = udcustomerList;
    }

    public String getUdequipmentdeletes() {
        return udequipmentdeletes;
    }

    public void setUdequipmentdeletes(String udequipmentdeletes) {
        this.udequipmentdeletes = udequipmentdeletes;
    }

    public List<Udequipment> getUdequipmentList() {
        return udequipmentList;
    }

    public void setUdequipmentList(List<Udequipment> udequipmentList) {
        this.udequipmentList = udequipmentList;
    }

    public Long getUdprojectlineid() {
        return udprojectlineid;
    }

    public void setUdprojectlineid(Long udprojectlineid) {
        this.udprojectlineid = udprojectlineid;
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

    public String getEdengineer() {
        return edengineer;
    }

    public void setEdengineer(String edengineer) {
        this.edengineer = edengineer;
    }

    public String getMdengineer() {
        return mdengineer;
    }

    public void setMdengineer(String mdengineer) {
        this.mdengineer = mdengineer;
    }

    public String getEquipmentnum() {
        return equipmentnum;
    }

    public void setEquipmentnum(String equipmentnum) {
        this.equipmentnum = equipmentnum;
    }

    public Date getActualcompletedate() {
        return actualcompletedate;
    }

    public void setActualcompletedate(Date actualcompletedate) {
        this.actualcompletedate = actualcompletedate;
    }

    public void setActualcompletedate(String actualcompletedate) {
        if(actualcompletedate!=null&&!actualcompletedate.equals("")){
            try {
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                this.actualcompletedate = sdf.parse(actualcompletedate);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Date getActualcompletiondate() {
        return actualcompletiondate;
    }

    public void setActualcompletiondate(Date actualcompletiondate) {
        this.actualcompletiondate = actualcompletiondate;
    }

    public void setActualcompletiondate(String actualcompletiondate) {
        if(actualcompletiondate!=null&&!actualcompletiondate.equals("")){
            try {
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                this.actualcompletiondate = sdf.parse(actualcompletiondate);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Date getActualdebugdate() {
        return actualdebugdate;
    }

    public void setActualdebugdate(Date actualdebugdate) {
        this.actualdebugdate = actualdebugdate;
    }

    public void setActualdebugdate(String actualdebugdate) {
        if(actualdebugdate!=null&&!actualdebugdate.equals("")){
            try {
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                this.actualdebugdate = sdf.parse(actualdebugdate);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Date getActualinstalldate() {
        return actualinstalldate;
    }

    public void setActualinstalldate(Date actualinstalldate) {
        this.actualinstalldate = actualinstalldate;
    }

    public void setActualinstalldate(String actualinstalldate) {
        if(actualinstalldate!=null&&!actualinstalldate.equals("")){
            try {
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                this.actualinstalldate = sdf.parse(actualinstalldate);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Date getActualsendpowerdate() {
        return actualsendpowerdate;
    }

    public void setActualsendpowerdate(Date actualsendpowerdate) {
        this.actualsendpowerdate = actualsendpowerdate;
    }

    public void setActualsendpowerdate(String actualsendpowerdate) {
        if(actualsendpowerdate!=null&&!actualsendpowerdate.equals("")){
            try {
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                this.actualsendpowerdate = sdf.parse(actualsendpowerdate);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Date getActualshipmentdate() {
        return actualshipmentdate;
    }

    public void setActualshipmentdate(Date actualshipmentdate) {
        this.actualshipmentdate = actualshipmentdate;
    }

    public void setActualshipmentdate(String actualshipmentdate) {
        if(actualshipmentdate!=null&&!actualshipmentdate.equals("")){
            try {
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                this.actualshipmentdate = sdf.parse(actualshipmentdate);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String getChildservicepro() {
        return childservicepro;
    }

    public void setChildservicepro(String childservicepro) {
        this.childservicepro = childservicepro;
    }

    public String getMainservicepro() {
        return mainservicepro;
    }

    public void setMainservicepro(String mainservicepro) {
        this.mainservicepro = mainservicepro;
    }

    public String getProjectmanager() {
        return projectmanager;
    }

    public void setProjectmanager(String projectmanager) {
        this.projectmanager = projectmanager;
    }

    public Date getPalncompletiondate() {
        return palncompletiondate;
    }

    public void setPalncompletiondate(Date palncompletiondate) {
        this.palncompletiondate = palncompletiondate;
    }

    public void setPalncompletiondate(String palncompletiondate) {
        if(palncompletiondate!=null&&!palncompletiondate.equals("")){
            try {
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                this.palncompletiondate = sdf.parse(palncompletiondate);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Date getPalndebugdate() {
        return palndebugdate;
    }

    public void setPalndebugdate(Date palndebugdate) {
        this.palndebugdate = palndebugdate;
    }

    public void setPalndebugdate(String palndebugdate) {
        if(palndebugdate!=null&&!palndebugdate.equals("")){
            try {
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                this.palndebugdate = sdf.parse(palndebugdate);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Date getPalnsendpowerdate() {
        return palnsendpowerdate;
    }

    public void setPalnsendpowerdate(Date palnsendpowerdate) {
        this.palnsendpowerdate = palnsendpowerdate;
    }

    public void setPalnsendpowerdate(String palnsendpowerdate) {
        if(palnsendpowerdate!=null&&!palnsendpowerdate.equals("")){
            try {
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                this.palnsendpowerdate = sdf.parse(palnsendpowerdate);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Date getPalnshipmentdate() {
        return palnshipmentdate;
    }

    public void setPalnshipmentdate(Date palnshipmentdate) {
        this.palnshipmentdate = palnshipmentdate;
    }

    public void setPalnshipmentdate(String palnshipmentdate) {
        if(palnshipmentdate!=null&&!palnshipmentdate.equals("")){
            try {
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                this.palnshipmentdate = sdf.parse(palnshipmentdate);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Date getPlancompletedate() {
        return plancompletedate;
    }

    public void setPlancompletedate(Date plancompletedate) {
        this.plancompletedate = plancompletedate;
    }

    public void setPlancompletedate(String plancompletedate) {
        if(plancompletedate!=null&&!plancompletedate.equals("")){
            try {
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                this.plancompletedate = sdf.parse(plancompletedate);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Date getPlaninstalldate() {
        return planinstalldate;
    }

    public void setPlaninstalldate(Date planinstalldate) {
        this.planinstalldate = planinstalldate;
    }

    public void setPlaninstalldate(String planinstalldate) {
        if(planinstalldate!=null&&!planinstalldate.equals("")){
            try {
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                this.planinstalldate = sdf.parse(planinstalldate);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Date getQualitymaturitydate() {
        return qualitymaturitydate;
    }

    public void setQualitymaturitydate(Date qualitymaturitydate) {
        this.qualitymaturitydate = qualitymaturitydate;
    }

    public void setQualitymaturitydate(String qualitymaturitydate) {
        if(qualitymaturitydate!=null&&!qualitymaturitydate.equals("")){
            try {
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                this.qualitymaturitydate = sdf.parse(qualitymaturitydate);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = (quantity==null?Double.valueOf(0):quantity);
    }

    public String getServicedep() {
        return servicedep;
    }

    public void setServicedep(String servicedep) {
        this.servicedep = servicedep;
    }

    public Double getWorkinghours() {
        return workinghours;
    }

    public void setWorkinghours(Double workinghours) {
        this.workinghours = workinghours;
    }

    public String getIndustryattributes() {
        return industryattributes;
    }

    public void setIndustryattributes(String industryattributes) {
        this.industryattributes = industryattributes;
    }

    public Long getBusbridge() {
        return busbridge;
    }

    public void setBusbridge(Long busbridge) {
        if(busbridge==null){
            this.busbridge = Long.valueOf(0);
        }else{
            this.busbridge = busbridge;
        }
    }

    public Long getProtectprogram() {
        return protectprogram;
    }

    public void setProtectprogram(Long protectprogram) {
        if(protectprogram==null){
            this.protectprogram = Long.valueOf(0);
        }else{
            this.protectprogram = protectprogram;
        }
    }

    public String getProtecttype() {
        return protecttype;
    }

    public void setProtecttype(String protecttype) {
        this.protecttype = protecttype;
    }

    public Double getProtectqty() {
        return protectqty;
    }

    public void setProtectqty(Double protectqty) {
        this.protectqty = (protectqty==null?Double.valueOf(0):protectqty);
    }

    public String getProvinces() {
        return provinces;
    }

    public void setProvinces(String provinces) {
        this.provinces = provinces;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSalesengineer() {
        return salesengineer;
    }

    public void setSalesengineer(String salesengineer) {
        this.salesengineer = salesengineer;
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

    public String getCtrnum() {
        return ctrnum;
    }

    public void setCtrnum(String ctrnum) {
        this.ctrnum = ctrnum;
    }

    public String getAreamanager() {
        return areamanager;
    }

    public void setAreamanager(String areamanager) {
        this.areamanager = areamanager;
    }

    public String getServicemanager() {
        return servicemanager;
    }

    public void setServicemanager(String servicemanager) {
        this.servicemanager = servicemanager;
    }

    public Long getKv() {
        return kv;
    }

    public void setKv(Long kv) {
        this.kv = kv;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getArea1() {
        return area1;
    }

    public void setArea1(String area1) {
        this.area1 = area1;
    }
}
