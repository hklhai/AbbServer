package com.hxqh.abb.model.view;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the WOACTIVITY database table.
 * 
 */
@Entity
@Table(name="Woactivity")
public class Woactivity implements Serializable {
	private static final Long serialVersionUID = 1L;

	private Date actfinish;

	private BigDecimal actintlabcost;

	private double actintlabhrs;

	private BigDecimal actlabcost;

	private double actlabhrs;

	private BigDecimal actmatcost;

	private BigDecimal actoutlabcost;

	private double actoutlabhrs;

	private BigDecimal actservcost;

	private Date actstart;

	private BigDecimal acttoolcost;

	private String amcrew;

	private Integer ams;

	private Integer aos;

	private Integer apptrequired;

	private Integer assetlocpriority;

	private String assetnum;

	private String assignedownergroup;

	private Date availstatusdate;

	private String backoutplan;

	private String calccalendar;

	private String calcorgid;

	private Integer calcpriority;

	private String calcshift;

	private String calendar;

	private String changeby;

	private Date changedate;

	private Integer chargestore;

	private String cinum;

	private String classstructureid;

	private String commodity;

	private String commoditygroup;

	private String contract;

	private String crewid;

	private String crewworkgroup;

	private String description;

	private String dirissuemtlstatus;

	private Integer disabled;

	private Integer downtime;

	@Column(name="\"ENVIRONMENT\"")
	private String environment;

	private BigDecimal estatapprintlabcost;

	private double estatapprintlabhrs;

	private BigDecimal estatapprlabcost;

	private double estatapprlabhrs;

	private BigDecimal estatapprmatcost;

	private BigDecimal estatapproutlabcost;

	private double estatapproutlabhrs;

	private BigDecimal estatapprservcost;

	private BigDecimal estatapprtoolcost;

	private double estdur;

	private BigDecimal estintlabcost;

	private double estintlabhrs;

	private BigDecimal estlabcost;

	private double estlabhrs;

	private BigDecimal estmatcost;

	private BigDecimal estoutlabcost;

	private double estoutlabhrs;

	private BigDecimal estservcost;

	private BigDecimal esttoolcost;

	private String externalrefid;

	private Date faildate;

	private String failurecode;

	private String fincntrlid;

	private String firstapprstatus;

	private String flowaction;

	private Integer flowactionassist;

	private Integer flowcontrolled;

	private Date fnlconstraint;

	private String generatedforpo;

	private Long genforpolineid;

	private Integer genforporevision;

	private String glaccount;

	private Integer haschildren;

	private Integer hasfollowupwork;

	private Integer hasld;

	private Integer historyflag;

	private Integer ignorediavail;

	private Integer ignoresrmavail;

	private Integer inctasksinsched;

	private String inspector;

	private Integer interruptible;

	private Integer istask;

	private Long jobtaskid;

	private String jpnum;

	private String justifypriority;

	private String langcode;

	private Date lastcopylinkdate;

	private String launchentryname;

	private String lead;

	private Integer lms;

	@Column(name="\"LOCATION\"")
	private String location;

	private Integer los;

	private Date measuredate;

	private BigDecimal measurementvalue;

	private Integer nestedjpinprocess;

	private String newchildclass;

	private String observation;

	private String onbehalfof;

	private String orgid;

	private String origrecordclass;

	private String origrecordid;

	private BigDecimal outlabcost;

	private BigDecimal outmatcost;

	private BigDecimal outtoolcost;

	private String owner;

	private String ownergroup;

	private String ownersysid;

	@Column(name="\"PARENT\"")
	private String parent;

	private Integer parentchgsstatus;

	private String percoding;

	private String persongroup;

	private String phone;

	private Integer pluscfrequency;

	private String pluscfrequnit;

	private Integer pluscismobile;

	private Integer pluscjprevnum;

	private Integer pluscloop;

	private Date pluscnextdate;

	private Date pluscoverduedate;

	private String pluscphyloc;

	@Temporal(TemporalType.DATE)
	private Date pmduedate;

	@Temporal(TemporalType.DATE)
	private Date pmextdate;

	@Temporal(TemporalType.DATE)
	private Date pmnextduedate;

	private String pmnum;

	private String pointnum;

	private String problemcode;

	private String reasonforchange;

	private Double remdur;

	private String repairfacility;

	private String repfacsiteid;

	private Date reportdate;

	private String reportedby;

	private Integer reqasstdwntime;

	private Date respondby;

	private String risk;

	private String route;

	private Long routestopid;

	private Long rowstamp;

	private Date schedfinish;

	private Date schedstart;

	private String sctnum;

	private String sendersysid;

	private String siteid;

	private Date sneconstraint;

	private String sourcesysid;

	@Column(name="\"STATUS\"")
	private String status;

	private Date statusdate;

	private String storeroommtlstatus;

	private String supervisor;

	private Integer suspendflow;

	private Date targcompdate;

	private String targetdesc;

	private Date targstartdate;

	private Integer taskid;

	private String udcoding;

	private String uddlgnum;

	private Integer udlinenum;

	private String udpmsnum;

	private String udpronum;

	private String udworktype;

	private String vendor;

	private String verification;

	private String whomischangefor;

	private Integer woacceptscharges;

	private String woclass;

	private String woeq1;

	private String woeq10;

	private String woeq11;

	private BigDecimal woeq12;

	private Date woeq13;

	private BigDecimal woeq14;

	private String woeq2;

	private String woeq3;

	private String woeq4;

	private BigDecimal woeq5;

	private Date woeq6;

	private BigDecimal woeq7;

	private String woeq8;

	private String woeq9;

	private String wogroup;

	private Integer woisswap;

	private String wojo1;

	private String wojo2;

	private String wojo3;

	private BigDecimal wojo4;

	private String wojo5;

	private String wojo6;

	private String wojo7;

	private String wojo8;

	private String wojp1;

	private String wojp2;

	private String wojp3;

	private BigDecimal wojp4;

	private Date wojp5;

	private String wol1;

	private String wol2;

	private BigDecimal wol3;

	private Date wol4;

	private String wolablnk;

	private String wolo1;

	private Integer wolo10;

	private String wolo2;

	private String wolo3;

	private String wolo4;

	private String wolo5;

	private BigDecimal wolo6;

	private Date wolo7;

	private BigDecimal wolo8;

	private String wolo9;

	private String wonum;

	private Integer wopriority;

	private String worklocation;

	@Id
	private Long workorderid;

	private String workpackmtlstatus;

	private String worktype;

	private String worts1;

	private String worts2;

	private String worts3;

	private Date worts4;

	private BigDecimal worts5;

	private Integer wosequence;

	public Woactivity() {
	}

	public Date getActfinish() {
		return actfinish;
	}

	public void setActfinish(Date actfinish) {
		this.actfinish = actfinish;
	}

	public BigDecimal getActintlabcost() {
		return actintlabcost;
	}

	public void setActintlabcost(BigDecimal actintlabcost) {
		this.actintlabcost = actintlabcost;
	}

	public double getActintlabhrs() {
		return actintlabhrs;
	}

	public void setActintlabhrs(double actintlabhrs) {
		this.actintlabhrs = actintlabhrs;
	}

	public BigDecimal getActlabcost() {
		return actlabcost;
	}

	public void setActlabcost(BigDecimal actlabcost) {
		this.actlabcost = actlabcost;
	}

	public double getActlabhrs() {
		return actlabhrs;
	}

	public void setActlabhrs(double actlabhrs) {
		this.actlabhrs = actlabhrs;
	}

	public BigDecimal getActmatcost() {
		return actmatcost;
	}

	public void setActmatcost(BigDecimal actmatcost) {
		this.actmatcost = actmatcost;
	}

	public BigDecimal getActoutlabcost() {
		return actoutlabcost;
	}

	public void setActoutlabcost(BigDecimal actoutlabcost) {
		this.actoutlabcost = actoutlabcost;
	}

	public double getActoutlabhrs() {
		return actoutlabhrs;
	}

	public void setActoutlabhrs(double actoutlabhrs) {
		this.actoutlabhrs = actoutlabhrs;
	}

	public BigDecimal getActservcost() {
		return actservcost;
	}

	public void setActservcost(BigDecimal actservcost) {
		this.actservcost = actservcost;
	}

	public Date getActstart() {
		return actstart;
	}

	public void setActstart(Date actstart) {
		this.actstart = actstart;
	}

	public BigDecimal getActtoolcost() {
		return acttoolcost;
	}

	public void setActtoolcost(BigDecimal acttoolcost) {
		this.acttoolcost = acttoolcost;
	}

	public String getAmcrew() {
		return amcrew;
	}

	public void setAmcrew(String amcrew) {
		this.amcrew = amcrew;
	}

	public Integer getAms() {
		return ams;
	}

	public void setAms(Integer ams) {
		this.ams = ams;
	}

	public Integer getAos() {
		return aos;
	}

	public void setAos(Integer aos) {
		this.aos = aos;
	}

	public Integer getApptrequired() {
		return apptrequired;
	}

	public void setApptrequired(Integer apptrequired) {
		this.apptrequired = apptrequired;
	}

	public Integer getAssetlocpriority() {
		return assetlocpriority;
	}

	public void setAssetlocpriority(Integer assetlocpriority) {
		this.assetlocpriority = assetlocpriority;
	}

	public String getAssetnum() {
		return assetnum;
	}

	public void setAssetnum(String assetnum) {
		this.assetnum = assetnum;
	}

	public String getAssignedownergroup() {
		return assignedownergroup;
	}

	public void setAssignedownergroup(String assignedownergroup) {
		this.assignedownergroup = assignedownergroup;
	}

	public Date getAvailstatusdate() {
		return availstatusdate;
	}

	public void setAvailstatusdate(Date availstatusdate) {
		this.availstatusdate = availstatusdate;
	}

	public String getBackoutplan() {
		return backoutplan;
	}

	public void setBackoutplan(String backoutplan) {
		this.backoutplan = backoutplan;
	}

	public String getCalccalendar() {
		return calccalendar;
	}

	public void setCalccalendar(String calccalendar) {
		this.calccalendar = calccalendar;
	}

	public String getCalcorgid() {
		return calcorgid;
	}

	public void setCalcorgid(String calcorgid) {
		this.calcorgid = calcorgid;
	}

	public Integer getCalcpriority() {
		return calcpriority;
	}

	public void setCalcpriority(Integer calcpriority) {
		this.calcpriority = calcpriority;
	}

	public String getCalcshift() {
		return calcshift;
	}

	public void setCalcshift(String calcshift) {
		this.calcshift = calcshift;
	}

	public String getCalendar() {
		return calendar;
	}

	public void setCalendar(String calendar) {
		this.calendar = calendar;
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

	public Integer getChargestore() {
		return chargestore;
	}

	public void setChargestore(Integer chargestore) {
		this.chargestore = chargestore;
	}

	public String getCinum() {
		return cinum;
	}

	public void setCinum(String cinum) {
		this.cinum = cinum;
	}

	public String getClassstructureid() {
		return classstructureid;
	}

	public void setClassstructureid(String classstructureid) {
		this.classstructureid = classstructureid;
	}

	public String getCommodity() {
		return commodity;
	}

	public void setCommodity(String commodity) {
		this.commodity = commodity;
	}

	public String getCommoditygroup() {
		return commoditygroup;
	}

	public void setCommoditygroup(String commoditygroup) {
		this.commoditygroup = commoditygroup;
	}

	public String getContract() {
		return contract;
	}

	public void setContract(String contract) {
		this.contract = contract;
	}

	public String getCrewid() {
		return crewid;
	}

	public void setCrewid(String crewid) {
		this.crewid = crewid;
	}

	public String getCrewworkgroup() {
		return crewworkgroup;
	}

	public void setCrewworkgroup(String crewworkgroup) {
		this.crewworkgroup = crewworkgroup;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDirissuemtlstatus() {
		return dirissuemtlstatus;
	}

	public void setDirissuemtlstatus(String dirissuemtlstatus) {
		this.dirissuemtlstatus = dirissuemtlstatus;
	}

	public Integer getDisabled() {
		return disabled;
	}

	public void setDisabled(Integer disabled) {
		this.disabled = disabled;
	}

	public Integer getDowntime() {
		return downtime;
	}

	public void setDowntime(Integer downtime) {
		this.downtime = downtime;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public BigDecimal getEstatapprintlabcost() {
		return estatapprintlabcost;
	}

	public void setEstatapprintlabcost(BigDecimal estatapprintlabcost) {
		this.estatapprintlabcost = estatapprintlabcost;
	}

	public double getEstatapprintlabhrs() {
		return estatapprintlabhrs;
	}

	public void setEstatapprintlabhrs(double estatapprintlabhrs) {
		this.estatapprintlabhrs = estatapprintlabhrs;
	}

	public BigDecimal getEstatapprlabcost() {
		return estatapprlabcost;
	}

	public void setEstatapprlabcost(BigDecimal estatapprlabcost) {
		this.estatapprlabcost = estatapprlabcost;
	}

	public double getEstatapprlabhrs() {
		return estatapprlabhrs;
	}

	public void setEstatapprlabhrs(double estatapprlabhrs) {
		this.estatapprlabhrs = estatapprlabhrs;
	}

	public BigDecimal getEstatapprmatcost() {
		return estatapprmatcost;
	}

	public void setEstatapprmatcost(BigDecimal estatapprmatcost) {
		this.estatapprmatcost = estatapprmatcost;
	}

	public BigDecimal getEstatapproutlabcost() {
		return estatapproutlabcost;
	}

	public void setEstatapproutlabcost(BigDecimal estatapproutlabcost) {
		this.estatapproutlabcost = estatapproutlabcost;
	}

	public double getEstatapproutlabhrs() {
		return estatapproutlabhrs;
	}

	public void setEstatapproutlabhrs(double estatapproutlabhrs) {
		this.estatapproutlabhrs = estatapproutlabhrs;
	}

	public BigDecimal getEstatapprservcost() {
		return estatapprservcost;
	}

	public void setEstatapprservcost(BigDecimal estatapprservcost) {
		this.estatapprservcost = estatapprservcost;
	}

	public BigDecimal getEstatapprtoolcost() {
		return estatapprtoolcost;
	}

	public void setEstatapprtoolcost(BigDecimal estatapprtoolcost) {
		this.estatapprtoolcost = estatapprtoolcost;
	}

	public double getEstdur() {
		return estdur;
	}

	public void setEstdur(double estdur) {
		this.estdur = estdur;
	}

	public BigDecimal getEstintlabcost() {
		return estintlabcost;
	}

	public void setEstintlabcost(BigDecimal estintlabcost) {
		this.estintlabcost = estintlabcost;
	}

	public double getEstintlabhrs() {
		return estintlabhrs;
	}

	public void setEstintlabhrs(double estintlabhrs) {
		this.estintlabhrs = estintlabhrs;
	}

	public BigDecimal getEstlabcost() {
		return estlabcost;
	}

	public void setEstlabcost(BigDecimal estlabcost) {
		this.estlabcost = estlabcost;
	}

	public double getEstlabhrs() {
		return estlabhrs;
	}

	public void setEstlabhrs(double estlabhrs) {
		this.estlabhrs = estlabhrs;
	}

	public BigDecimal getEstmatcost() {
		return estmatcost;
	}

	public void setEstmatcost(BigDecimal estmatcost) {
		this.estmatcost = estmatcost;
	}

	public BigDecimal getEstoutlabcost() {
		return estoutlabcost;
	}

	public void setEstoutlabcost(BigDecimal estoutlabcost) {
		this.estoutlabcost = estoutlabcost;
	}

	public double getEstoutlabhrs() {
		return estoutlabhrs;
	}

	public void setEstoutlabhrs(double estoutlabhrs) {
		this.estoutlabhrs = estoutlabhrs;
	}

	public BigDecimal getEstservcost() {
		return estservcost;
	}

	public void setEstservcost(BigDecimal estservcost) {
		this.estservcost = estservcost;
	}

	public BigDecimal getEsttoolcost() {
		return esttoolcost;
	}

	public void setEsttoolcost(BigDecimal esttoolcost) {
		this.esttoolcost = esttoolcost;
	}

	public String getExternalrefid() {
		return externalrefid;
	}

	public void setExternalrefid(String externalrefid) {
		this.externalrefid = externalrefid;
	}

	public Date getFaildate() {
		return faildate;
	}

	public void setFaildate(Date faildate) {
		this.faildate = faildate;
	}

	public String getFailurecode() {
		return failurecode;
	}

	public void setFailurecode(String failurecode) {
		this.failurecode = failurecode;
	}

	public String getFincntrlid() {
		return fincntrlid;
	}

	public void setFincntrlid(String fincntrlid) {
		this.fincntrlid = fincntrlid;
	}

	public String getFirstapprstatus() {
		return firstapprstatus;
	}

	public void setFirstapprstatus(String firstapprstatus) {
		this.firstapprstatus = firstapprstatus;
	}

	public String getFlowaction() {
		return flowaction;
	}

	public void setFlowaction(String flowaction) {
		this.flowaction = flowaction;
	}

	public Integer getFlowactionassist() {
		return flowactionassist;
	}

	public void setFlowactionassist(Integer flowactionassist) {
		this.flowactionassist = flowactionassist;
	}

	public Integer getFlowcontrolled() {
		return flowcontrolled;
	}

	public void setFlowcontrolled(Integer flowcontrolled) {
		this.flowcontrolled = flowcontrolled;
	}

	public Date getFnlconstraint() {
		return fnlconstraint;
	}

	public void setFnlconstraint(Date fnlconstraint) {
		this.fnlconstraint = fnlconstraint;
	}

	public String getGeneratedforpo() {
		return generatedforpo;
	}

	public void setGeneratedforpo(String generatedforpo) {
		this.generatedforpo = generatedforpo;
	}

	public Long getGenforpolineid() {
		return genforpolineid;
	}

	public void setGenforpolineid(Long genforpolineid) {
		this.genforpolineid = genforpolineid;
	}

	public Integer getGenforporevision() {
		return genforporevision;
	}

	public void setGenforporevision(Integer genforporevision) {
		this.genforporevision = genforporevision;
	}

	public String getGlaccount() {
		return glaccount;
	}

	public void setGlaccount(String glaccount) {
		this.glaccount = glaccount;
	}

	public Integer getHaschildren() {
		return haschildren;
	}

	public void setHaschildren(Integer haschildren) {
		this.haschildren = haschildren;
	}

	public Integer getHasfollowupwork() {
		return hasfollowupwork;
	}

	public void setHasfollowupwork(Integer hasfollowupwork) {
		this.hasfollowupwork = hasfollowupwork;
	}

	public Integer getHasld() {
		return hasld;
	}

	public void setHasld(Integer hasld) {
		this.hasld = hasld;
	}

	public Integer getHistoryflag() {
		return historyflag;
	}

	public void setHistoryflag(Integer historyflag) {
		this.historyflag = historyflag;
	}

	public Integer getIgnorediavail() {
		return ignorediavail;
	}

	public void setIgnorediavail(Integer ignorediavail) {
		this.ignorediavail = ignorediavail;
	}

	public Integer getIgnoresrmavail() {
		return ignoresrmavail;
	}

	public void setIgnoresrmavail(Integer ignoresrmavail) {
		this.ignoresrmavail = ignoresrmavail;
	}

	public Integer getInctasksinsched() {
		return inctasksinsched;
	}

	public void setInctasksinsched(Integer inctasksinsched) {
		this.inctasksinsched = inctasksinsched;
	}

	public String getInspector() {
		return inspector;
	}

	public void setInspector(String inspector) {
		this.inspector = inspector;
	}

	public Integer getInterruptible() {
		return interruptible;
	}

	public void setInterruptible(Integer interruptible) {
		this.interruptible = interruptible;
	}

	public Integer getIstask() {
		return istask;
	}

	public void setIstask(Integer istask) {
		this.istask = istask;
	}

	public Long getJobtaskid() {
		return jobtaskid;
	}

	public void setJobtaskid(Long jobtaskid) {
		this.jobtaskid = jobtaskid;
	}

	public String getJpnum() {
		return jpnum;
	}

	public void setJpnum(String jpnum) {
		this.jpnum = jpnum;
	}

	public String getJustifypriority() {
		return justifypriority;
	}

	public void setJustifypriority(String justifypriority) {
		this.justifypriority = justifypriority;
	}

	public String getLangcode() {
		return langcode;
	}

	public void setLangcode(String langcode) {
		this.langcode = langcode;
	}

	public Date getLastcopylinkdate() {
		return lastcopylinkdate;
	}

	public void setLastcopylinkdate(Date lastcopylinkdate) {
		this.lastcopylinkdate = lastcopylinkdate;
	}

	public String getLaunchentryname() {
		return launchentryname;
	}

	public void setLaunchentryname(String launchentryname) {
		this.launchentryname = launchentryname;
	}

	public String getLead() {
		return lead;
	}

	public void setLead(String lead) {
		this.lead = lead;
	}

	public Integer getLms() {
		return lms;
	}

	public void setLms(Integer lms) {
		this.lms = lms;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getLos() {
		return los;
	}

	public void setLos(Integer los) {
		this.los = los;
	}

	public Date getMeasuredate() {
		return measuredate;
	}

	public void setMeasuredate(Date measuredate) {
		this.measuredate = measuredate;
	}

	public BigDecimal getMeasurementvalue() {
		return measurementvalue;
	}

	public void setMeasurementvalue(BigDecimal measurementvalue) {
		this.measurementvalue = measurementvalue;
	}

	public Integer getNestedjpinprocess() {
		return nestedjpinprocess;
	}

	public void setNestedjpinprocess(Integer nestedjpinprocess) {
		this.nestedjpinprocess = nestedjpinprocess;
	}

	public String getNewchildclass() {
		return newchildclass;
	}

	public void setNewchildclass(String newchildclass) {
		this.newchildclass = newchildclass;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public String getOnbehalfof() {
		return onbehalfof;
	}

	public void setOnbehalfof(String onbehalfof) {
		this.onbehalfof = onbehalfof;
	}

	public String getOrgid() {
		return orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	public String getOrigrecordclass() {
		return origrecordclass;
	}

	public void setOrigrecordclass(String origrecordclass) {
		this.origrecordclass = origrecordclass;
	}

	public String getOrigrecordid() {
		return origrecordid;
	}

	public void setOrigrecordid(String origrecordid) {
		this.origrecordid = origrecordid;
	}

	public BigDecimal getOutlabcost() {
		return outlabcost;
	}

	public void setOutlabcost(BigDecimal outlabcost) {
		this.outlabcost = outlabcost;
	}

	public BigDecimal getOutmatcost() {
		return outmatcost;
	}

	public void setOutmatcost(BigDecimal outmatcost) {
		this.outmatcost = outmatcost;
	}

	public BigDecimal getOuttoolcost() {
		return outtoolcost;
	}

	public void setOuttoolcost(BigDecimal outtoolcost) {
		this.outtoolcost = outtoolcost;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getOwnergroup() {
		return ownergroup;
	}

	public void setOwnergroup(String ownergroup) {
		this.ownergroup = ownergroup;
	}

	public String getOwnersysid() {
		return ownersysid;
	}

	public void setOwnersysid(String ownersysid) {
		this.ownersysid = ownersysid;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public Integer getParentchgsstatus() {
		return parentchgsstatus;
	}

	public void setParentchgsstatus(Integer parentchgsstatus) {
		this.parentchgsstatus = parentchgsstatus;
	}

	public String getPercoding() {
		return percoding;
	}

	public void setPercoding(String percoding) {
		this.percoding = percoding;
	}

	public String getPersongroup() {
		return persongroup;
	}

	public void setPersongroup(String persongroup) {
		this.persongroup = persongroup;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getPluscfrequency() {
		return pluscfrequency;
	}

	public void setPluscfrequency(Integer pluscfrequency) {
		this.pluscfrequency = pluscfrequency;
	}

	public String getPluscfrequnit() {
		return pluscfrequnit;
	}

	public void setPluscfrequnit(String pluscfrequnit) {
		this.pluscfrequnit = pluscfrequnit;
	}

	public Integer getPluscismobile() {
		return pluscismobile;
	}

	public void setPluscismobile(Integer pluscismobile) {
		this.pluscismobile = pluscismobile;
	}

	public Integer getPluscjprevnum() {
		return pluscjprevnum;
	}

	public void setPluscjprevnum(Integer pluscjprevnum) {
		this.pluscjprevnum = pluscjprevnum;
	}

	public Integer getPluscloop() {
		return pluscloop;
	}

	public void setPluscloop(Integer pluscloop) {
		this.pluscloop = pluscloop;
	}

	public Date getPluscnextdate() {
		return pluscnextdate;
	}

	public void setPluscnextdate(Date pluscnextdate) {
		this.pluscnextdate = pluscnextdate;
	}

	public Date getPluscoverduedate() {
		return pluscoverduedate;
	}

	public void setPluscoverduedate(Date pluscoverduedate) {
		this.pluscoverduedate = pluscoverduedate;
	}

	public String getPluscphyloc() {
		return pluscphyloc;
	}

	public void setPluscphyloc(String pluscphyloc) {
		this.pluscphyloc = pluscphyloc;
	}

	public Date getPmduedate() {
		return pmduedate;
	}

	public void setPmduedate(Date pmduedate) {
		this.pmduedate = pmduedate;
	}

	public Date getPmextdate() {
		return pmextdate;
	}

	public void setPmextdate(Date pmextdate) {
		this.pmextdate = pmextdate;
	}

	public Date getPmnextduedate() {
		return pmnextduedate;
	}

	public void setPmnextduedate(Date pmnextduedate) {
		this.pmnextduedate = pmnextduedate;
	}

	public String getPmnum() {
		return pmnum;
	}

	public void setPmnum(String pmnum) {
		this.pmnum = pmnum;
	}

	public String getPointnum() {
		return pointnum;
	}

	public void setPointnum(String pointnum) {
		this.pointnum = pointnum;
	}

	public String getProblemcode() {
		return problemcode;
	}

	public void setProblemcode(String problemcode) {
		this.problemcode = problemcode;
	}

	public String getReasonforchange() {
		return reasonforchange;
	}

	public void setReasonforchange(String reasonforchange) {
		this.reasonforchange = reasonforchange;
	}

	public Double getRemdur() {
		return remdur;
	}

	public void setRemdur(Double remdur) {
		this.remdur = remdur;
	}

	public String getRepairfacility() {
		return repairfacility;
	}

	public void setRepairfacility(String repairfacility) {
		this.repairfacility = repairfacility;
	}

	public String getRepfacsiteid() {
		return repfacsiteid;
	}

	public void setRepfacsiteid(String repfacsiteid) {
		this.repfacsiteid = repfacsiteid;
	}

	public Date getReportdate() {
		return reportdate;
	}

	public void setReportdate(Date reportdate) {
		this.reportdate = reportdate;
	}

	public String getReportedby() {
		return reportedby;
	}

	public void setReportedby(String reportedby) {
		this.reportedby = reportedby;
	}

	public Integer getReqasstdwntime() {
		return reqasstdwntime;
	}

	public void setReqasstdwntime(Integer reqasstdwntime) {
		this.reqasstdwntime = reqasstdwntime;
	}

	public Date getRespondby() {
		return respondby;
	}

	public void setRespondby(Date respondby) {
		this.respondby = respondby;
	}

	public String getRisk() {
		return risk;
	}

	public void setRisk(String risk) {
		this.risk = risk;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public Long getRoutestopid() {
		return routestopid;
	}

	public void setRoutestopid(Long routestopid) {
		this.routestopid = routestopid;
	}

	public Long getRowstamp() {
		return rowstamp;
	}

	public void setRowstamp(Long rowstamp) {
		this.rowstamp = rowstamp;
	}

	public Date getSchedfinish() {
		return schedfinish;
	}

	public void setSchedfinish(Date schedfinish) {
		this.schedfinish = schedfinish;
	}

	public Date getSchedstart() {
		return schedstart;
	}

	public void setSchedstart(Date schedstart) {
		this.schedstart = schedstart;
	}

	public String getSctnum() {
		return sctnum;
	}

	public void setSctnum(String sctnum) {
		this.sctnum = sctnum;
	}

	public String getSendersysid() {
		return sendersysid;
	}

	public void setSendersysid(String sendersysid) {
		this.sendersysid = sendersysid;
	}

	public String getSiteid() {
		return siteid;
	}

	public void setSiteid(String siteid) {
		this.siteid = siteid;
	}

	public Date getSneconstraint() {
		return sneconstraint;
	}

	public void setSneconstraint(Date sneconstraint) {
		this.sneconstraint = sneconstraint;
	}

	public String getSourcesysid() {
		return sourcesysid;
	}

	public void setSourcesysid(String sourcesysid) {
		this.sourcesysid = sourcesysid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getStatusdate() {
		return statusdate;
	}

	public void setStatusdate(Date statusdate) {
		this.statusdate = statusdate;
	}

	public String getStoreroommtlstatus() {
		return storeroommtlstatus;
	}

	public void setStoreroommtlstatus(String storeroommtlstatus) {
		this.storeroommtlstatus = storeroommtlstatus;
	}

	public String getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}

	public Integer getSuspendflow() {
		return suspendflow;
	}

	public void setSuspendflow(Integer suspendflow) {
		this.suspendflow = suspendflow;
	}

	public Date getTargcompdate() {
		return targcompdate;
	}

	public void setTargcompdate(Date targcompdate) {
		this.targcompdate = targcompdate;
	}

	public String getTargetdesc() {
		return targetdesc;
	}

	public void setTargetdesc(String targetdesc) {
		this.targetdesc = targetdesc;
	}

	public Date getTargstartdate() {
		return targstartdate;
	}

	public void setTargstartdate(Date targstartdate) {
		this.targstartdate = targstartdate;
	}

	public Integer getTaskid() {
		return taskid;
	}

	public void setTaskid(Integer taskid) {
		this.taskid = taskid;
	}

	public String getUdcoding() {
		return udcoding;
	}

	public void setUdcoding(String udcoding) {
		this.udcoding = udcoding;
	}

	public String getUddlgnum() {
		return uddlgnum;
	}

	public void setUddlgnum(String uddlgnum) {
		this.uddlgnum = uddlgnum;
	}

	public Integer getUdlinenum() {
		return udlinenum;
	}

	public void setUdlinenum(Integer udlinenum) {
		this.udlinenum = udlinenum;
	}

	public String getUdpmsnum() {
		return udpmsnum;
	}

	public void setUdpmsnum(String udpmsnum) {
		this.udpmsnum = udpmsnum;
	}

	public String getUdpronum() {
		return udpronum;
	}

	public void setUdpronum(String udpronum) {
		this.udpronum = udpronum;
	}

	public String getUdworktype() {
		return udworktype;
	}

	public void setUdworktype(String udworktype) {
		this.udworktype = udworktype;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getVerification() {
		return verification;
	}

	public void setVerification(String verification) {
		this.verification = verification;
	}

	public String getWhomischangefor() {
		return whomischangefor;
	}

	public void setWhomischangefor(String whomischangefor) {
		this.whomischangefor = whomischangefor;
	}

	public Integer getWoacceptscharges() {
		return woacceptscharges;
	}

	public void setWoacceptscharges(Integer woacceptscharges) {
		this.woacceptscharges = woacceptscharges;
	}

	public String getWoclass() {
		return woclass;
	}

	public void setWoclass(String woclass) {
		this.woclass = woclass;
	}

	public String getWoeq1() {
		return woeq1;
	}

	public void setWoeq1(String woeq1) {
		this.woeq1 = woeq1;
	}

	public String getWoeq10() {
		return woeq10;
	}

	public void setWoeq10(String woeq10) {
		this.woeq10 = woeq10;
	}

	public String getWoeq11() {
		return woeq11;
	}

	public void setWoeq11(String woeq11) {
		this.woeq11 = woeq11;
	}

	public BigDecimal getWoeq12() {
		return woeq12;
	}

	public void setWoeq12(BigDecimal woeq12) {
		this.woeq12 = woeq12;
	}

	public Date getWoeq13() {
		return woeq13;
	}

	public void setWoeq13(Date woeq13) {
		this.woeq13 = woeq13;
	}

	public BigDecimal getWoeq14() {
		return woeq14;
	}

	public void setWoeq14(BigDecimal woeq14) {
		this.woeq14 = woeq14;
	}

	public String getWoeq2() {
		return woeq2;
	}

	public void setWoeq2(String woeq2) {
		this.woeq2 = woeq2;
	}

	public String getWoeq3() {
		return woeq3;
	}

	public void setWoeq3(String woeq3) {
		this.woeq3 = woeq3;
	}

	public String getWoeq4() {
		return woeq4;
	}

	public void setWoeq4(String woeq4) {
		this.woeq4 = woeq4;
	}

	public BigDecimal getWoeq5() {
		return woeq5;
	}

	public void setWoeq5(BigDecimal woeq5) {
		this.woeq5 = woeq5;
	}

	public Date getWoeq6() {
		return woeq6;
	}

	public void setWoeq6(Date woeq6) {
		this.woeq6 = woeq6;
	}

	public BigDecimal getWoeq7() {
		return woeq7;
	}

	public void setWoeq7(BigDecimal woeq7) {
		this.woeq7 = woeq7;
	}

	public String getWoeq8() {
		return woeq8;
	}

	public void setWoeq8(String woeq8) {
		this.woeq8 = woeq8;
	}

	public String getWoeq9() {
		return woeq9;
	}

	public void setWoeq9(String woeq9) {
		this.woeq9 = woeq9;
	}

	public String getWogroup() {
		return wogroup;
	}

	public void setWogroup(String wogroup) {
		this.wogroup = wogroup;
	}

	public Integer getWoisswap() {
		return woisswap;
	}

	public void setWoisswap(Integer woisswap) {
		this.woisswap = woisswap;
	}

	public String getWojo1() {
		return wojo1;
	}

	public void setWojo1(String wojo1) {
		this.wojo1 = wojo1;
	}

	public String getWojo2() {
		return wojo2;
	}

	public void setWojo2(String wojo2) {
		this.wojo2 = wojo2;
	}

	public String getWojo3() {
		return wojo3;
	}

	public void setWojo3(String wojo3) {
		this.wojo3 = wojo3;
	}

	public BigDecimal getWojo4() {
		return wojo4;
	}

	public void setWojo4(BigDecimal wojo4) {
		this.wojo4 = wojo4;
	}

	public String getWojo5() {
		return wojo5;
	}

	public void setWojo5(String wojo5) {
		this.wojo5 = wojo5;
	}

	public String getWojo6() {
		return wojo6;
	}

	public void setWojo6(String wojo6) {
		this.wojo6 = wojo6;
	}

	public String getWojo7() {
		return wojo7;
	}

	public void setWojo7(String wojo7) {
		this.wojo7 = wojo7;
	}

	public String getWojo8() {
		return wojo8;
	}

	public void setWojo8(String wojo8) {
		this.wojo8 = wojo8;
	}

	public String getWojp1() {
		return wojp1;
	}

	public void setWojp1(String wojp1) {
		this.wojp1 = wojp1;
	}

	public String getWojp2() {
		return wojp2;
	}

	public void setWojp2(String wojp2) {
		this.wojp2 = wojp2;
	}

	public String getWojp3() {
		return wojp3;
	}

	public void setWojp3(String wojp3) {
		this.wojp3 = wojp3;
	}

	public BigDecimal getWojp4() {
		return wojp4;
	}

	public void setWojp4(BigDecimal wojp4) {
		this.wojp4 = wojp4;
	}

	public Date getWojp5() {
		return wojp5;
	}

	public void setWojp5(Date wojp5) {
		this.wojp5 = wojp5;
	}

	public String getWol1() {
		return wol1;
	}

	public void setWol1(String wol1) {
		this.wol1 = wol1;
	}

	public String getWol2() {
		return wol2;
	}

	public void setWol2(String wol2) {
		this.wol2 = wol2;
	}

	public BigDecimal getWol3() {
		return wol3;
	}

	public void setWol3(BigDecimal wol3) {
		this.wol3 = wol3;
	}

	public Date getWol4() {
		return wol4;
	}

	public void setWol4(Date wol4) {
		this.wol4 = wol4;
	}

	public String getWolablnk() {
		return wolablnk;
	}

	public void setWolablnk(String wolablnk) {
		this.wolablnk = wolablnk;
	}

	public String getWolo1() {
		return wolo1;
	}

	public void setWolo1(String wolo1) {
		this.wolo1 = wolo1;
	}

	public Integer getWolo10() {
		return wolo10;
	}

	public void setWolo10(Integer wolo10) {
		this.wolo10 = wolo10;
	}

	public String getWolo2() {
		return wolo2;
	}

	public void setWolo2(String wolo2) {
		this.wolo2 = wolo2;
	}

	public String getWolo3() {
		return wolo3;
	}

	public void setWolo3(String wolo3) {
		this.wolo3 = wolo3;
	}

	public String getWolo4() {
		return wolo4;
	}

	public void setWolo4(String wolo4) {
		this.wolo4 = wolo4;
	}

	public String getWolo5() {
		return wolo5;
	}

	public void setWolo5(String wolo5) {
		this.wolo5 = wolo5;
	}

	public BigDecimal getWolo6() {
		return wolo6;
	}

	public void setWolo6(BigDecimal wolo6) {
		this.wolo6 = wolo6;
	}

	public Date getWolo7() {
		return wolo7;
	}

	public void setWolo7(Date wolo7) {
		this.wolo7 = wolo7;
	}

	public BigDecimal getWolo8() {
		return wolo8;
	}

	public void setWolo8(BigDecimal wolo8) {
		this.wolo8 = wolo8;
	}

	public String getWolo9() {
		return wolo9;
	}

	public void setWolo9(String wolo9) {
		this.wolo9 = wolo9;
	}

	public String getWonum() {
		return wonum;
	}

	public void setWonum(String wonum) {
		this.wonum = wonum;
	}

	public Integer getWopriority() {
		return wopriority;
	}

	public void setWopriority(Integer wopriority) {
		this.wopriority = wopriority;
	}

	public String getWorklocation() {
		return worklocation;
	}

	public void setWorklocation(String worklocation) {
		this.worklocation = worklocation;
	}

	public Long getWorkorderid() {
		return workorderid;
	}

	public void setWorkorderid(Long workorderid) {
		this.workorderid = workorderid;
	}

	public String getWorkpackmtlstatus() {
		return workpackmtlstatus;
	}

	public void setWorkpackmtlstatus(String workpackmtlstatus) {
		this.workpackmtlstatus = workpackmtlstatus;
	}

	public String getWorktype() {
		return worktype;
	}

	public void setWorktype(String worktype) {
		this.worktype = worktype;
	}

	public String getWorts1() {
		return worts1;
	}

	public void setWorts1(String worts1) {
		this.worts1 = worts1;
	}

	public String getWorts2() {
		return worts2;
	}

	public void setWorts2(String worts2) {
		this.worts2 = worts2;
	}

	public String getWorts3() {
		return worts3;
	}

	public void setWorts3(String worts3) {
		this.worts3 = worts3;
	}

	public Date getWorts4() {
		return worts4;
	}

	public void setWorts4(Date worts4) {
		this.worts4 = worts4;
	}

	public BigDecimal getWorts5() {
		return worts5;
	}

	public void setWorts5(BigDecimal worts5) {
		this.worts5 = worts5;
	}

	public Integer getWosequence() {
		return wosequence;
	}

	public void setWosequence(Integer wosequence) {
		this.wosequence = wosequence;
	}
}