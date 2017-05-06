package com.hxqh.abb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the WORKORDER database table.
 * 
 */
@Entity
@Table(name="Workorder")
public class Workorder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="WORKORDER_WORKORDERID_GENERATOR", sequenceName="$TBALE_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="WORKORDER_WORKORDERID_GENERATOR")
	private long workorderid;

	private Timestamp actfinish;

	private BigDecimal actintlabcost;

	private double actintlabhrs;

	private BigDecimal actlabcost;

	private double actlabhrs;

	private BigDecimal actmatcost;

	private BigDecimal actoutlabcost;

	private double actoutlabhrs;

	private BigDecimal actservcost;

	private Timestamp actstart;

	private BigDecimal acttoolcost;

	private String amcrew;

	private int ams;

	private int aos;

	private int apptrequired;

	private int assetlocpriority;

	private String assetnum;

	private String assignedownergroup;

	private Timestamp availstatusdate;

	private String backoutplan;

	private String calccalendar;

	private String calcorgid;

	private int calcpriority;

	private String calcshift;

	private String calendar;

	private String changeby;

	private Timestamp changedate;

	private int chargestore;

	private String cinum;

	private String classstructureid;

	private String commodity;

	private String commoditygroup;

	private String contract;

	private String crewid;

	private String crewworkgroup;

	private String description;

	private String dirissuemtlstatus;

	private int disabled;

	private int downtime;

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

	private Timestamp faildate;

	private String failurecode;

	private String fincntrlid;

	private String firstapprstatus;

	private String flowaction;

	private int flowactionassist;

	private int flowcontrolled;

	private Timestamp fnlconstraint;

	private String generatedforpo;

	private long genforpolineid;

	private int genforporevision;

	private String glaccount;

	private int haschildren;

	private int hasfollowupwork;

	private int hasld;

	private int historyflag;

	private int ignorediavail;

	private int ignoresrmavail;

	private int inctasksinsched;

	private String inspector;

	private int interruptible;

	private int istask;

	private long jobtaskid;

	private String jpnum;

	private String justifypriority;

	private String langcode;

	private Timestamp lastcopylinkdate;

	private String launchentryname;

	private String lead;

	private int lms;

	@Column(name="\"LOCATION\"")
	private String location;

	private int los;

	private Timestamp measuredate;

	private BigDecimal measurementvalue;

	private int nestedjpinprocess;

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

	private int parentchgsstatus;

	private String percoding;

	private String persongroup;

	private String phone;

	private int pluscfrequency;

	private String pluscfrequnit;

	private int pluscismobile;

	private int pluscjprevnum;

	private int pluscloop;

	private Timestamp pluscnextdate;

	private Timestamp pluscoverduedate;

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

	private double remdur;

	private String repairfacility;

	private String repfacsiteid;

	private Timestamp reportdate;

	private String reportedby;

	private int reqasstdwntime;

	private Timestamp respondby;

	private String risk;

	private String route;

	private long routestopid;

	private long rowstamp;

	private Timestamp schedfinish;

	private Timestamp schedstart;

	private String sctnum;

	private String sendersysid;

	private String siteid;

	private Timestamp sneconstraint;

	private String sourcesysid;

	@Column(name="\"STATUS\"")
	private String status;

	private Timestamp statusdate;

	private String storeroommtlstatus;

	private String supervisor;

	private int suspendflow;

	private Timestamp targcompdate;

	private String targetdesc;

	private Timestamp targstartdate;

	private int taskid;

	private String udcoding;

	private String uddlgnum;

	private int udlinenum;

	private String udpmsnum;

	private String udpronum;

	private String udworktype;

	private String vendor;

	private String verification;

	private String whomischangefor;

	private int woacceptscharges;

	private String woclass;

	private String woeq1;

	private String woeq10;

	private String woeq11;

	private BigDecimal woeq12;

	private Timestamp woeq13;

	private BigDecimal woeq14;

	private String woeq2;

	private String woeq3;

	private String woeq4;

	private BigDecimal woeq5;

	private Timestamp woeq6;

	private BigDecimal woeq7;

	private String woeq8;

	private String woeq9;

	private String wogroup;

	private int woisswap;

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

	private Timestamp wojp5;

	private String wol1;

	private String wol2;

	private BigDecimal wol3;

	private Timestamp wol4;

	private String wolablnk;

	private String wolo1;

	private int wolo10;

	private String wolo2;

	private String wolo3;

	private String wolo4;

	private String wolo5;

	private BigDecimal wolo6;

	private Timestamp wolo7;

	private BigDecimal wolo8;

	private String wolo9;

	private String wonum;

	private int wopriority;

	private String worklocation;

	private String workpackmtlstatus;

	private String worktype;

	private String worts1;

	private String worts2;

	private String worts3;

	private Timestamp worts4;

	private BigDecimal worts5;

	private int wosequence;

	public Workorder() {
	}

	public long getWorkorderid() {
		return this.workorderid;
	}

	public void setWorkorderid(long workorderid) {
		this.workorderid = workorderid;
	}

	public Timestamp getActfinish() {
		return this.actfinish;
	}

	public void setActfinish(Timestamp actfinish) {
		this.actfinish = actfinish;
	}

	public BigDecimal getActintlabcost() {
		return this.actintlabcost;
	}

	public void setActintlabcost(BigDecimal actintlabcost) {
		this.actintlabcost = actintlabcost;
	}

	public double getActintlabhrs() {
		return this.actintlabhrs;
	}

	public void setActintlabhrs(double actintlabhrs) {
		this.actintlabhrs = actintlabhrs;
	}

	public BigDecimal getActlabcost() {
		return this.actlabcost;
	}

	public void setActlabcost(BigDecimal actlabcost) {
		this.actlabcost = actlabcost;
	}

	public double getActlabhrs() {
		return this.actlabhrs;
	}

	public void setActlabhrs(double actlabhrs) {
		this.actlabhrs = actlabhrs;
	}

	public BigDecimal getActmatcost() {
		return this.actmatcost;
	}

	public void setActmatcost(BigDecimal actmatcost) {
		this.actmatcost = actmatcost;
	}

	public BigDecimal getActoutlabcost() {
		return this.actoutlabcost;
	}

	public void setActoutlabcost(BigDecimal actoutlabcost) {
		this.actoutlabcost = actoutlabcost;
	}

	public double getActoutlabhrs() {
		return this.actoutlabhrs;
	}

	public void setActoutlabhrs(double actoutlabhrs) {
		this.actoutlabhrs = actoutlabhrs;
	}

	public BigDecimal getActservcost() {
		return this.actservcost;
	}

	public void setActservcost(BigDecimal actservcost) {
		this.actservcost = actservcost;
	}

	public Timestamp getActstart() {
		return this.actstart;
	}

	public void setActstart(Timestamp actstart) {
		this.actstart = actstart;
	}

	public BigDecimal getActtoolcost() {
		return this.acttoolcost;
	}

	public void setActtoolcost(BigDecimal acttoolcost) {
		this.acttoolcost = acttoolcost;
	}

	public String getAmcrew() {
		return this.amcrew;
	}

	public void setAmcrew(String amcrew) {
		this.amcrew = amcrew;
	}

	public int getAms() {
		return this.ams;
	}

	public void setAms(int ams) {
		this.ams = ams;
	}

	public int getAos() {
		return this.aos;
	}

	public void setAos(int aos) {
		this.aos = aos;
	}

	public int getApptrequired() {
		return this.apptrequired;
	}

	public void setApptrequired(int apptrequired) {
		this.apptrequired = apptrequired;
	}

	public int getAssetlocpriority() {
		return this.assetlocpriority;
	}

	public void setAssetlocpriority(int assetlocpriority) {
		this.assetlocpriority = assetlocpriority;
	}

	public String getAssetnum() {
		return this.assetnum;
	}

	public void setAssetnum(String assetnum) {
		this.assetnum = assetnum;
	}

	public String getAssignedownergroup() {
		return this.assignedownergroup;
	}

	public void setAssignedownergroup(String assignedownergroup) {
		this.assignedownergroup = assignedownergroup;
	}

	public Timestamp getAvailstatusdate() {
		return this.availstatusdate;
	}

	public void setAvailstatusdate(Timestamp availstatusdate) {
		this.availstatusdate = availstatusdate;
	}

	public String getBackoutplan() {
		return this.backoutplan;
	}

	public void setBackoutplan(String backoutplan) {
		this.backoutplan = backoutplan;
	}

	public String getCalccalendar() {
		return this.calccalendar;
	}

	public void setCalccalendar(String calccalendar) {
		this.calccalendar = calccalendar;
	}

	public String getCalcorgid() {
		return this.calcorgid;
	}

	public void setCalcorgid(String calcorgid) {
		this.calcorgid = calcorgid;
	}

	public int getCalcpriority() {
		return this.calcpriority;
	}

	public void setCalcpriority(int calcpriority) {
		this.calcpriority = calcpriority;
	}

	public String getCalcshift() {
		return this.calcshift;
	}

	public void setCalcshift(String calcshift) {
		this.calcshift = calcshift;
	}

	public String getCalendar() {
		return this.calendar;
	}

	public void setCalendar(String calendar) {
		this.calendar = calendar;
	}

	public String getChangeby() {
		return this.changeby;
	}

	public void setChangeby(String changeby) {
		this.changeby = changeby;
	}

	public Timestamp getChangedate() {
		return this.changedate;
	}

	public void setChangedate(Timestamp changedate) {
		this.changedate = changedate;
	}

	public int getChargestore() {
		return this.chargestore;
	}

	public void setChargestore(int chargestore) {
		this.chargestore = chargestore;
	}

	public String getCinum() {
		return this.cinum;
	}

	public void setCinum(String cinum) {
		this.cinum = cinum;
	}

	public String getClassstructureid() {
		return this.classstructureid;
	}

	public void setClassstructureid(String classstructureid) {
		this.classstructureid = classstructureid;
	}

	public String getCommodity() {
		return this.commodity;
	}

	public void setCommodity(String commodity) {
		this.commodity = commodity;
	}

	public String getCommoditygroup() {
		return this.commoditygroup;
	}

	public void setCommoditygroup(String commoditygroup) {
		this.commoditygroup = commoditygroup;
	}

	public String getContract() {
		return this.contract;
	}

	public void setContract(String contract) {
		this.contract = contract;
	}

	public String getCrewid() {
		return this.crewid;
	}

	public void setCrewid(String crewid) {
		this.crewid = crewid;
	}

	public String getCrewworkgroup() {
		return this.crewworkgroup;
	}

	public void setCrewworkgroup(String crewworkgroup) {
		this.crewworkgroup = crewworkgroup;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDirissuemtlstatus() {
		return this.dirissuemtlstatus;
	}

	public void setDirissuemtlstatus(String dirissuemtlstatus) {
		this.dirissuemtlstatus = dirissuemtlstatus;
	}

	public int getDisabled() {
		return this.disabled;
	}

	public void setDisabled(int disabled) {
		this.disabled = disabled;
	}

	public int getDowntime() {
		return this.downtime;
	}

	public void setDowntime(int downtime) {
		this.downtime = downtime;
	}

	public String getEnvironment() {
		return this.environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public BigDecimal getEstatapprintlabcost() {
		return this.estatapprintlabcost;
	}

	public void setEstatapprintlabcost(BigDecimal estatapprintlabcost) {
		this.estatapprintlabcost = estatapprintlabcost;
	}

	public double getEstatapprintlabhrs() {
		return this.estatapprintlabhrs;
	}

	public void setEstatapprintlabhrs(double estatapprintlabhrs) {
		this.estatapprintlabhrs = estatapprintlabhrs;
	}

	public BigDecimal getEstatapprlabcost() {
		return this.estatapprlabcost;
	}

	public void setEstatapprlabcost(BigDecimal estatapprlabcost) {
		this.estatapprlabcost = estatapprlabcost;
	}

	public double getEstatapprlabhrs() {
		return this.estatapprlabhrs;
	}

	public void setEstatapprlabhrs(double estatapprlabhrs) {
		this.estatapprlabhrs = estatapprlabhrs;
	}

	public BigDecimal getEstatapprmatcost() {
		return this.estatapprmatcost;
	}

	public void setEstatapprmatcost(BigDecimal estatapprmatcost) {
		this.estatapprmatcost = estatapprmatcost;
	}

	public BigDecimal getEstatapproutlabcost() {
		return this.estatapproutlabcost;
	}

	public void setEstatapproutlabcost(BigDecimal estatapproutlabcost) {
		this.estatapproutlabcost = estatapproutlabcost;
	}

	public double getEstatapproutlabhrs() {
		return this.estatapproutlabhrs;
	}

	public void setEstatapproutlabhrs(double estatapproutlabhrs) {
		this.estatapproutlabhrs = estatapproutlabhrs;
	}

	public BigDecimal getEstatapprservcost() {
		return this.estatapprservcost;
	}

	public void setEstatapprservcost(BigDecimal estatapprservcost) {
		this.estatapprservcost = estatapprservcost;
	}

	public BigDecimal getEstatapprtoolcost() {
		return this.estatapprtoolcost;
	}

	public void setEstatapprtoolcost(BigDecimal estatapprtoolcost) {
		this.estatapprtoolcost = estatapprtoolcost;
	}

	public double getEstdur() {
		return this.estdur;
	}

	public void setEstdur(double estdur) {
		this.estdur = estdur;
	}

	public BigDecimal getEstintlabcost() {
		return this.estintlabcost;
	}

	public void setEstintlabcost(BigDecimal estintlabcost) {
		this.estintlabcost = estintlabcost;
	}

	public double getEstintlabhrs() {
		return this.estintlabhrs;
	}

	public void setEstintlabhrs(double estintlabhrs) {
		this.estintlabhrs = estintlabhrs;
	}

	public BigDecimal getEstlabcost() {
		return this.estlabcost;
	}

	public void setEstlabcost(BigDecimal estlabcost) {
		this.estlabcost = estlabcost;
	}

	public double getEstlabhrs() {
		return this.estlabhrs;
	}

	public void setEstlabhrs(double estlabhrs) {
		this.estlabhrs = estlabhrs;
	}

	public BigDecimal getEstmatcost() {
		return this.estmatcost;
	}

	public void setEstmatcost(BigDecimal estmatcost) {
		this.estmatcost = estmatcost;
	}

	public BigDecimal getEstoutlabcost() {
		return this.estoutlabcost;
	}

	public void setEstoutlabcost(BigDecimal estoutlabcost) {
		this.estoutlabcost = estoutlabcost;
	}

	public double getEstoutlabhrs() {
		return this.estoutlabhrs;
	}

	public void setEstoutlabhrs(double estoutlabhrs) {
		this.estoutlabhrs = estoutlabhrs;
	}

	public BigDecimal getEstservcost() {
		return this.estservcost;
	}

	public void setEstservcost(BigDecimal estservcost) {
		this.estservcost = estservcost;
	}

	public BigDecimal getEsttoolcost() {
		return this.esttoolcost;
	}

	public void setEsttoolcost(BigDecimal esttoolcost) {
		this.esttoolcost = esttoolcost;
	}

	public String getExternalrefid() {
		return this.externalrefid;
	}

	public void setExternalrefid(String externalrefid) {
		this.externalrefid = externalrefid;
	}

	public Timestamp getFaildate() {
		return this.faildate;
	}

	public void setFaildate(Timestamp faildate) {
		this.faildate = faildate;
	}

	public String getFailurecode() {
		return this.failurecode;
	}

	public void setFailurecode(String failurecode) {
		this.failurecode = failurecode;
	}

	public String getFincntrlid() {
		return this.fincntrlid;
	}

	public void setFincntrlid(String fincntrlid) {
		this.fincntrlid = fincntrlid;
	}

	public String getFirstapprstatus() {
		return this.firstapprstatus;
	}

	public void setFirstapprstatus(String firstapprstatus) {
		this.firstapprstatus = firstapprstatus;
	}

	public String getFlowaction() {
		return this.flowaction;
	}

	public void setFlowaction(String flowaction) {
		this.flowaction = flowaction;
	}

	public int getFlowactionassist() {
		return this.flowactionassist;
	}

	public void setFlowactionassist(int flowactionassist) {
		this.flowactionassist = flowactionassist;
	}

	public int getFlowcontrolled() {
		return this.flowcontrolled;
	}

	public void setFlowcontrolled(int flowcontrolled) {
		this.flowcontrolled = flowcontrolled;
	}

	public Timestamp getFnlconstraint() {
		return this.fnlconstraint;
	}

	public void setFnlconstraint(Timestamp fnlconstraint) {
		this.fnlconstraint = fnlconstraint;
	}

	public String getGeneratedforpo() {
		return this.generatedforpo;
	}

	public void setGeneratedforpo(String generatedforpo) {
		this.generatedforpo = generatedforpo;
	}

	public long getGenforpolineid() {
		return this.genforpolineid;
	}

	public void setGenforpolineid(long genforpolineid) {
		this.genforpolineid = genforpolineid;
	}

	public int getGenforporevision() {
		return this.genforporevision;
	}

	public void setGenforporevision(int genforporevision) {
		this.genforporevision = genforporevision;
	}

	public String getGlaccount() {
		return this.glaccount;
	}

	public void setGlaccount(String glaccount) {
		this.glaccount = glaccount;
	}

	public int getHaschildren() {
		return this.haschildren;
	}

	public void setHaschildren(int haschildren) {
		this.haschildren = haschildren;
	}

	public int getHasfollowupwork() {
		return this.hasfollowupwork;
	}

	public void setHasfollowupwork(int hasfollowupwork) {
		this.hasfollowupwork = hasfollowupwork;
	}

	public int getHasld() {
		return this.hasld;
	}

	public void setHasld(int hasld) {
		this.hasld = hasld;
	}

	public int getHistoryflag() {
		return this.historyflag;
	}

	public void setHistoryflag(int historyflag) {
		this.historyflag = historyflag;
	}

	public int getIgnorediavail() {
		return this.ignorediavail;
	}

	public void setIgnorediavail(int ignorediavail) {
		this.ignorediavail = ignorediavail;
	}

	public int getIgnoresrmavail() {
		return this.ignoresrmavail;
	}

	public void setIgnoresrmavail(int ignoresrmavail) {
		this.ignoresrmavail = ignoresrmavail;
	}

	public int getInctasksinsched() {
		return this.inctasksinsched;
	}

	public void setInctasksinsched(int inctasksinsched) {
		this.inctasksinsched = inctasksinsched;
	}

	public String getInspector() {
		return this.inspector;
	}

	public void setInspector(String inspector) {
		this.inspector = inspector;
	}

	public int getInterruptible() {
		return this.interruptible;
	}

	public void setInterruptible(int interruptible) {
		this.interruptible = interruptible;
	}

	public int getIstask() {
		return this.istask;
	}

	public void setIstask(int istask) {
		this.istask = istask;
	}

	public long getJobtaskid() {
		return this.jobtaskid;
	}

	public void setJobtaskid(long jobtaskid) {
		this.jobtaskid = jobtaskid;
	}

	public String getJpnum() {
		return this.jpnum;
	}

	public void setJpnum(String jpnum) {
		this.jpnum = jpnum;
	}

	public String getJustifypriority() {
		return this.justifypriority;
	}

	public void setJustifypriority(String justifypriority) {
		this.justifypriority = justifypriority;
	}

	public String getLangcode() {
		return this.langcode;
	}

	public void setLangcode(String langcode) {
		this.langcode = langcode;
	}

	public Timestamp getLastcopylinkdate() {
		return this.lastcopylinkdate;
	}

	public void setLastcopylinkdate(Timestamp lastcopylinkdate) {
		this.lastcopylinkdate = lastcopylinkdate;
	}

	public String getLaunchentryname() {
		return this.launchentryname;
	}

	public void setLaunchentryname(String launchentryname) {
		this.launchentryname = launchentryname;
	}

	public String getLead() {
		return this.lead;
	}

	public void setLead(String lead) {
		this.lead = lead;
	}

	public int getLms() {
		return this.lms;
	}

	public void setLms(int lms) {
		this.lms = lms;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getLos() {
		return this.los;
	}

	public void setLos(int los) {
		this.los = los;
	}

	public Timestamp getMeasuredate() {
		return this.measuredate;
	}

	public void setMeasuredate(Timestamp measuredate) {
		this.measuredate = measuredate;
	}

	public BigDecimal getMeasurementvalue() {
		return this.measurementvalue;
	}

	public void setMeasurementvalue(BigDecimal measurementvalue) {
		this.measurementvalue = measurementvalue;
	}

	public int getNestedjpinprocess() {
		return this.nestedjpinprocess;
	}

	public void setNestedjpinprocess(int nestedjpinprocess) {
		this.nestedjpinprocess = nestedjpinprocess;
	}

	public String getNewchildclass() {
		return this.newchildclass;
	}

	public void setNewchildclass(String newchildclass) {
		this.newchildclass = newchildclass;
	}

	public String getObservation() {
		return this.observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public String getOnbehalfof() {
		return this.onbehalfof;
	}

	public void setOnbehalfof(String onbehalfof) {
		this.onbehalfof = onbehalfof;
	}

	public String getOrgid() {
		return this.orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	public String getOrigrecordclass() {
		return this.origrecordclass;
	}

	public void setOrigrecordclass(String origrecordclass) {
		this.origrecordclass = origrecordclass;
	}

	public String getOrigrecordid() {
		return this.origrecordid;
	}

	public void setOrigrecordid(String origrecordid) {
		this.origrecordid = origrecordid;
	}

	public BigDecimal getOutlabcost() {
		return this.outlabcost;
	}

	public void setOutlabcost(BigDecimal outlabcost) {
		this.outlabcost = outlabcost;
	}

	public BigDecimal getOutmatcost() {
		return this.outmatcost;
	}

	public void setOutmatcost(BigDecimal outmatcost) {
		this.outmatcost = outmatcost;
	}

	public BigDecimal getOuttoolcost() {
		return this.outtoolcost;
	}

	public void setOuttoolcost(BigDecimal outtoolcost) {
		this.outtoolcost = outtoolcost;
	}

	public String getOwner() {
		return this.owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getOwnergroup() {
		return this.ownergroup;
	}

	public void setOwnergroup(String ownergroup) {
		this.ownergroup = ownergroup;
	}

	public String getOwnersysid() {
		return this.ownersysid;
	}

	public void setOwnersysid(String ownersysid) {
		this.ownersysid = ownersysid;
	}

	public String getParent() {
		return this.parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public int getParentchgsstatus() {
		return this.parentchgsstatus;
	}

	public void setParentchgsstatus(int parentchgsstatus) {
		this.parentchgsstatus = parentchgsstatus;
	}

	public String getPercoding() {
		return this.percoding;
	}

	public void setPercoding(String percoding) {
		this.percoding = percoding;
	}

	public String getPersongroup() {
		return this.persongroup;
	}

	public void setPersongroup(String persongroup) {
		this.persongroup = persongroup;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getPluscfrequency() {
		return this.pluscfrequency;
	}

	public void setPluscfrequency(int pluscfrequency) {
		this.pluscfrequency = pluscfrequency;
	}

	public String getPluscfrequnit() {
		return this.pluscfrequnit;
	}

	public void setPluscfrequnit(String pluscfrequnit) {
		this.pluscfrequnit = pluscfrequnit;
	}

	public int getPluscismobile() {
		return this.pluscismobile;
	}

	public void setPluscismobile(int pluscismobile) {
		this.pluscismobile = pluscismobile;
	}

	public int getPluscjprevnum() {
		return this.pluscjprevnum;
	}

	public void setPluscjprevnum(int pluscjprevnum) {
		this.pluscjprevnum = pluscjprevnum;
	}

	public int getPluscloop() {
		return this.pluscloop;
	}

	public void setPluscloop(int pluscloop) {
		this.pluscloop = pluscloop;
	}

	public Timestamp getPluscnextdate() {
		return this.pluscnextdate;
	}

	public void setPluscnextdate(Timestamp pluscnextdate) {
		this.pluscnextdate = pluscnextdate;
	}

	public Timestamp getPluscoverduedate() {
		return this.pluscoverduedate;
	}

	public void setPluscoverduedate(Timestamp pluscoverduedate) {
		this.pluscoverduedate = pluscoverduedate;
	}

	public String getPluscphyloc() {
		return this.pluscphyloc;
	}

	public void setPluscphyloc(String pluscphyloc) {
		this.pluscphyloc = pluscphyloc;
	}

	public Date getPmduedate() {
		return this.pmduedate;
	}

	public void setPmduedate(Date pmduedate) {
		this.pmduedate = pmduedate;
	}

	public Date getPmextdate() {
		return this.pmextdate;
	}

	public void setPmextdate(Date pmextdate) {
		this.pmextdate = pmextdate;
	}

	public Date getPmnextduedate() {
		return this.pmnextduedate;
	}

	public void setPmnextduedate(Date pmnextduedate) {
		this.pmnextduedate = pmnextduedate;
	}

	public String getPmnum() {
		return this.pmnum;
	}

	public void setPmnum(String pmnum) {
		this.pmnum = pmnum;
	}

	public String getPointnum() {
		return this.pointnum;
	}

	public void setPointnum(String pointnum) {
		this.pointnum = pointnum;
	}

	public String getProblemcode() {
		return this.problemcode;
	}

	public void setProblemcode(String problemcode) {
		this.problemcode = problemcode;
	}

	public String getReasonforchange() {
		return this.reasonforchange;
	}

	public void setReasonforchange(String reasonforchange) {
		this.reasonforchange = reasonforchange;
	}

	public double getRemdur() {
		return this.remdur;
	}

	public void setRemdur(double remdur) {
		this.remdur = remdur;
	}

	public String getRepairfacility() {
		return this.repairfacility;
	}

	public void setRepairfacility(String repairfacility) {
		this.repairfacility = repairfacility;
	}

	public String getRepfacsiteid() {
		return this.repfacsiteid;
	}

	public void setRepfacsiteid(String repfacsiteid) {
		this.repfacsiteid = repfacsiteid;
	}

	public Timestamp getReportdate() {
		return this.reportdate;
	}

	public void setReportdate(Timestamp reportdate) {
		this.reportdate = reportdate;
	}

	public String getReportedby() {
		return this.reportedby;
	}

	public void setReportedby(String reportedby) {
		this.reportedby = reportedby;
	}

	public int getReqasstdwntime() {
		return this.reqasstdwntime;
	}

	public void setReqasstdwntime(int reqasstdwntime) {
		this.reqasstdwntime = reqasstdwntime;
	}

	public Timestamp getRespondby() {
		return this.respondby;
	}

	public void setRespondby(Timestamp respondby) {
		this.respondby = respondby;
	}

	public String getRisk() {
		return this.risk;
	}

	public void setRisk(String risk) {
		this.risk = risk;
	}

	public String getRoute() {
		return this.route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public long getRoutestopid() {
		return this.routestopid;
	}

	public void setRoutestopid(long routestopid) {
		this.routestopid = routestopid;
	}

	public long getRowstamp() {
		return this.rowstamp;
	}

	public void setRowstamp(long rowstamp) {
		this.rowstamp = rowstamp;
	}

	public Timestamp getSchedfinish() {
		return this.schedfinish;
	}

	public void setSchedfinish(Timestamp schedfinish) {
		this.schedfinish = schedfinish;
	}

	public Timestamp getSchedstart() {
		return this.schedstart;
	}

	public void setSchedstart(Timestamp schedstart) {
		this.schedstart = schedstart;
	}

	public String getSctnum() {
		return this.sctnum;
	}

	public void setSctnum(String sctnum) {
		this.sctnum = sctnum;
	}

	public String getSendersysid() {
		return this.sendersysid;
	}

	public void setSendersysid(String sendersysid) {
		this.sendersysid = sendersysid;
	}

	public String getSiteid() {
		return this.siteid;
	}

	public void setSiteid(String siteid) {
		this.siteid = siteid;
	}

	public Timestamp getSneconstraint() {
		return this.sneconstraint;
	}

	public void setSneconstraint(Timestamp sneconstraint) {
		this.sneconstraint = sneconstraint;
	}

	public String getSourcesysid() {
		return this.sourcesysid;
	}

	public void setSourcesysid(String sourcesysid) {
		this.sourcesysid = sourcesysid;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getStatusdate() {
		return this.statusdate;
	}

	public void setStatusdate(Timestamp statusdate) {
		this.statusdate = statusdate;
	}

	public String getStoreroommtlstatus() {
		return this.storeroommtlstatus;
	}

	public void setStoreroommtlstatus(String storeroommtlstatus) {
		this.storeroommtlstatus = storeroommtlstatus;
	}

	public String getSupervisor() {
		return this.supervisor;
	}

	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}

	public int getSuspendflow() {
		return this.suspendflow;
	}

	public void setSuspendflow(int suspendflow) {
		this.suspendflow = suspendflow;
	}

	public Timestamp getTargcompdate() {
		return this.targcompdate;
	}

	public void setTargcompdate(Timestamp targcompdate) {
		this.targcompdate = targcompdate;
	}

	public String getTargetdesc() {
		return this.targetdesc;
	}

	public void setTargetdesc(String targetdesc) {
		this.targetdesc = targetdesc;
	}

	public Timestamp getTargstartdate() {
		return this.targstartdate;
	}

	public void setTargstartdate(Timestamp targstartdate) {
		this.targstartdate = targstartdate;
	}

	public int getTaskid() {
		return this.taskid;
	}

	public void setTaskid(int taskid) {
		this.taskid = taskid;
	}

	public String getUdcoding() {
		return this.udcoding;
	}

	public void setUdcoding(String udcoding) {
		this.udcoding = udcoding;
	}

	public String getUddlgnum() {
		return this.uddlgnum;
	}

	public void setUddlgnum(String uddlgnum) {
		this.uddlgnum = uddlgnum;
	}

	public int getUdlinenum() {
		return this.udlinenum;
	}

	public void setUdlinenum(int udlinenum) {
		this.udlinenum = udlinenum;
	}

	public String getUdpmsnum() {
		return this.udpmsnum;
	}

	public void setUdpmsnum(String udpmsnum) {
		this.udpmsnum = udpmsnum;
	}

	public String getUdpronum() {
		return this.udpronum;
	}

	public void setUdpronum(String udpronum) {
		this.udpronum = udpronum;
	}

	public String getUdworktype() {
		return this.udworktype;
	}

	public void setUdworktype(String udworktype) {
		this.udworktype = udworktype;
	}

	public String getVendor() {
		return this.vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getVerification() {
		return this.verification;
	}

	public void setVerification(String verification) {
		this.verification = verification;
	}

	public String getWhomischangefor() {
		return this.whomischangefor;
	}

	public void setWhomischangefor(String whomischangefor) {
		this.whomischangefor = whomischangefor;
	}

	public int getWoacceptscharges() {
		return this.woacceptscharges;
	}

	public void setWoacceptscharges(int woacceptscharges) {
		this.woacceptscharges = woacceptscharges;
	}

	public String getWoclass() {
		return this.woclass;
	}

	public void setWoclass(String woclass) {
		this.woclass = woclass;
	}

	public String getWoeq1() {
		return this.woeq1;
	}

	public void setWoeq1(String woeq1) {
		this.woeq1 = woeq1;
	}

	public String getWoeq10() {
		return this.woeq10;
	}

	public void setWoeq10(String woeq10) {
		this.woeq10 = woeq10;
	}

	public String getWoeq11() {
		return this.woeq11;
	}

	public void setWoeq11(String woeq11) {
		this.woeq11 = woeq11;
	}

	public BigDecimal getWoeq12() {
		return this.woeq12;
	}

	public void setWoeq12(BigDecimal woeq12) {
		this.woeq12 = woeq12;
	}

	public Timestamp getWoeq13() {
		return this.woeq13;
	}

	public void setWoeq13(Timestamp woeq13) {
		this.woeq13 = woeq13;
	}

	public BigDecimal getWoeq14() {
		return this.woeq14;
	}

	public void setWoeq14(BigDecimal woeq14) {
		this.woeq14 = woeq14;
	}

	public String getWoeq2() {
		return this.woeq2;
	}

	public void setWoeq2(String woeq2) {
		this.woeq2 = woeq2;
	}

	public String getWoeq3() {
		return this.woeq3;
	}

	public void setWoeq3(String woeq3) {
		this.woeq3 = woeq3;
	}

	public String getWoeq4() {
		return this.woeq4;
	}

	public void setWoeq4(String woeq4) {
		this.woeq4 = woeq4;
	}

	public BigDecimal getWoeq5() {
		return this.woeq5;
	}

	public void setWoeq5(BigDecimal woeq5) {
		this.woeq5 = woeq5;
	}

	public Timestamp getWoeq6() {
		return this.woeq6;
	}

	public void setWoeq6(Timestamp woeq6) {
		this.woeq6 = woeq6;
	}

	public BigDecimal getWoeq7() {
		return this.woeq7;
	}

	public void setWoeq7(BigDecimal woeq7) {
		this.woeq7 = woeq7;
	}

	public String getWoeq8() {
		return this.woeq8;
	}

	public void setWoeq8(String woeq8) {
		this.woeq8 = woeq8;
	}

	public String getWoeq9() {
		return this.woeq9;
	}

	public void setWoeq9(String woeq9) {
		this.woeq9 = woeq9;
	}

	public String getWogroup() {
		return this.wogroup;
	}

	public void setWogroup(String wogroup) {
		this.wogroup = wogroup;
	}

	public int getWoisswap() {
		return this.woisswap;
	}

	public void setWoisswap(int woisswap) {
		this.woisswap = woisswap;
	}

	public String getWojo1() {
		return this.wojo1;
	}

	public void setWojo1(String wojo1) {
		this.wojo1 = wojo1;
	}

	public String getWojo2() {
		return this.wojo2;
	}

	public void setWojo2(String wojo2) {
		this.wojo2 = wojo2;
	}

	public String getWojo3() {
		return this.wojo3;
	}

	public void setWojo3(String wojo3) {
		this.wojo3 = wojo3;
	}

	public BigDecimal getWojo4() {
		return this.wojo4;
	}

	public void setWojo4(BigDecimal wojo4) {
		this.wojo4 = wojo4;
	}

	public String getWojo5() {
		return this.wojo5;
	}

	public void setWojo5(String wojo5) {
		this.wojo5 = wojo5;
	}

	public String getWojo6() {
		return this.wojo6;
	}

	public void setWojo6(String wojo6) {
		this.wojo6 = wojo6;
	}

	public String getWojo7() {
		return this.wojo7;
	}

	public void setWojo7(String wojo7) {
		this.wojo7 = wojo7;
	}

	public String getWojo8() {
		return this.wojo8;
	}

	public void setWojo8(String wojo8) {
		this.wojo8 = wojo8;
	}

	public String getWojp1() {
		return this.wojp1;
	}

	public void setWojp1(String wojp1) {
		this.wojp1 = wojp1;
	}

	public String getWojp2() {
		return this.wojp2;
	}

	public void setWojp2(String wojp2) {
		this.wojp2 = wojp2;
	}

	public String getWojp3() {
		return this.wojp3;
	}

	public void setWojp3(String wojp3) {
		this.wojp3 = wojp3;
	}

	public BigDecimal getWojp4() {
		return this.wojp4;
	}

	public void setWojp4(BigDecimal wojp4) {
		this.wojp4 = wojp4;
	}

	public Timestamp getWojp5() {
		return this.wojp5;
	}

	public void setWojp5(Timestamp wojp5) {
		this.wojp5 = wojp5;
	}

	public String getWol1() {
		return this.wol1;
	}

	public void setWol1(String wol1) {
		this.wol1 = wol1;
	}

	public String getWol2() {
		return this.wol2;
	}

	public void setWol2(String wol2) {
		this.wol2 = wol2;
	}

	public BigDecimal getWol3() {
		return this.wol3;
	}

	public void setWol3(BigDecimal wol3) {
		this.wol3 = wol3;
	}

	public Timestamp getWol4() {
		return this.wol4;
	}

	public void setWol4(Timestamp wol4) {
		this.wol4 = wol4;
	}

	public String getWolablnk() {
		return this.wolablnk;
	}

	public void setWolablnk(String wolablnk) {
		this.wolablnk = wolablnk;
	}

	public String getWolo1() {
		return this.wolo1;
	}

	public void setWolo1(String wolo1) {
		this.wolo1 = wolo1;
	}

	public int getWolo10() {
		return this.wolo10;
	}

	public void setWolo10(int wolo10) {
		this.wolo10 = wolo10;
	}

	public String getWolo2() {
		return this.wolo2;
	}

	public void setWolo2(String wolo2) {
		this.wolo2 = wolo2;
	}

	public String getWolo3() {
		return this.wolo3;
	}

	public void setWolo3(String wolo3) {
		this.wolo3 = wolo3;
	}

	public String getWolo4() {
		return this.wolo4;
	}

	public void setWolo4(String wolo4) {
		this.wolo4 = wolo4;
	}

	public String getWolo5() {
		return this.wolo5;
	}

	public void setWolo5(String wolo5) {
		this.wolo5 = wolo5;
	}

	public BigDecimal getWolo6() {
		return this.wolo6;
	}

	public void setWolo6(BigDecimal wolo6) {
		this.wolo6 = wolo6;
	}

	public Timestamp getWolo7() {
		return this.wolo7;
	}

	public void setWolo7(Timestamp wolo7) {
		this.wolo7 = wolo7;
	}

	public BigDecimal getWolo8() {
		return this.wolo8;
	}

	public void setWolo8(BigDecimal wolo8) {
		this.wolo8 = wolo8;
	}

	public String getWolo9() {
		return this.wolo9;
	}

	public void setWolo9(String wolo9) {
		this.wolo9 = wolo9;
	}

	public String getWonum() {
		return this.wonum;
	}

	public void setWonum(String wonum) {
		this.wonum = wonum;
	}

	public int getWopriority() {
		return this.wopriority;
	}

	public void setWopriority(int wopriority) {
		this.wopriority = wopriority;
	}

	public String getWorklocation() {
		return this.worklocation;
	}

	public void setWorklocation(String worklocation) {
		this.worklocation = worklocation;
	}

	public String getWorkpackmtlstatus() {
		return this.workpackmtlstatus;
	}

	public void setWorkpackmtlstatus(String workpackmtlstatus) {
		this.workpackmtlstatus = workpackmtlstatus;
	}

	public String getWorktype() {
		return this.worktype;
	}

	public void setWorktype(String worktype) {
		this.worktype = worktype;
	}

	public String getWorts1() {
		return this.worts1;
	}

	public void setWorts1(String worts1) {
		this.worts1 = worts1;
	}

	public String getWorts2() {
		return this.worts2;
	}

	public void setWorts2(String worts2) {
		this.worts2 = worts2;
	}

	public String getWorts3() {
		return this.worts3;
	}

	public void setWorts3(String worts3) {
		this.worts3 = worts3;
	}

	public Timestamp getWorts4() {
		return this.worts4;
	}

	public void setWorts4(Timestamp worts4) {
		this.worts4 = worts4;
	}

	public BigDecimal getWorts5() {
		return this.worts5;
	}

	public void setWorts5(BigDecimal worts5) {
		this.worts5 = worts5;
	}

	public int getWosequence() {
		return this.wosequence;
	}

	public void setWosequence(int wosequence) {
		this.wosequence = wosequence;
	}

}