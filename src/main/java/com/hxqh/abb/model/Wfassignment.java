package com.hxqh.abb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the WFASSIGNMENT database table.
 * 
 */
@Entity
@Table(name="Wfassignment")
public class Wfassignment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="WFASSIGNMENT_WFASSIGNMENTID_GENERATOR", sequenceName="$TBALE_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="WFASSIGNMENT_WFASSIGNMENTID_GENERATOR")
	private long wfassignmentid;

	private String acceptexpr;

	private String app;

	@Column(name="ASSIGN_01")
	private String assign01;

	@Column(name="ASSIGN_02")
	private String assign02;

	@Column(name="ASSIGN_03")
	private String assign03;

	@Column(name="ASSIGN_04")
	private String assign04;

	@Column(name="ASSIGN_05")
	private String assign05;

	private String assigncode;

	private long assignid;

	private String assignstatus;

	private Integer calendarbased;

	@Column(name="\"CONDITION\"")
	private String condition;

	private String conditionclass;




	private Integer emailnotification;

	private String escrole;

	//private Integer groupnum;

	private Integer hasld;

	private Integer keeporigassgn;

	private String langcode;

	private Integer nodeid;

	private String nonacceptmsg;

	private String origperson;

	//private long ownerid;

	private String ownertable;



	private String processname;

	private Integer processrev;

	private String relationship;

	private String roleid;

	private long rowstamp;

	private Integer separategroups;



	private String templateid;

	private Double timelimit;

	private long wfid;


	private Timestamp duedate;
	private String description;
	private Timestamp startdate;
	@Column(name = "\"PRIORITY\"")
	private Integer priority;


	public Wfassignment() {
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public long getWfassignmentid() {
		return wfassignmentid;
	}

	public void setWfassignmentid(long wfassignmentid) {
		this.wfassignmentid = wfassignmentid;
	}

	public Timestamp getDuedate() {
		return duedate;
	}

	public void setDuedate(Timestamp duedate) {
		this.duedate = duedate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getStartdate() {
		return startdate;
	}

	public void setStartdate(Timestamp startdate) {
		this.startdate = startdate;
	}

	public String getAcceptexpr() {
		return acceptexpr;
	}

	public void setAcceptexpr(String acceptexpr) {
		this.acceptexpr = acceptexpr;
	}

	public String getApp() {
		return app;
	}

	public void setApp(String app) {
		this.app = app;
	}

	public String getAssign01() {
		return assign01;
	}

	public void setAssign01(String assign01) {
		this.assign01 = assign01;
	}

	public String getAssign02() {
		return assign02;
	}

	public void setAssign02(String assign02) {
		this.assign02 = assign02;
	}

	public String getAssign03() {
		return assign03;
	}

	public void setAssign03(String assign03) {
		this.assign03 = assign03;
	}

	public String getAssign04() {
		return assign04;
	}

	public void setAssign04(String assign04) {
		this.assign04 = assign04;
	}

	public String getAssign05() {
		return assign05;
	}

	public void setAssign05(String assign05) {
		this.assign05 = assign05;
	}

	public String getAssigncode() {
		return assigncode;
	}

	public void setAssigncode(String assigncode) {
		this.assigncode = assigncode;
	}

	public long getAssignid() {
		return assignid;
	}

	public void setAssignid(long assignid) {
		this.assignid = assignid;
	}

	public String getAssignstatus() {
		return assignstatus;
	}

	public void setAssignstatus(String assignstatus) {
		this.assignstatus = assignstatus;
	}

	public Integer getCalendarbased() {
		return calendarbased;
	}

	public void setCalendarbased(Integer calendarbased) {
		this.calendarbased = calendarbased;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getConditionclass() {
		return conditionclass;
	}

	public void setConditionclass(String conditionclass) {
		this.conditionclass = conditionclass;
	}

	public Integer getEmailnotification() {
		return emailnotification;
	}

	public void setEmailnotification(Integer emailnotification) {
		this.emailnotification = emailnotification;
	}

	public String getEscrole() {
		return escrole;
	}

	public void setEscrole(String escrole) {
		this.escrole = escrole;
	}

	public Integer getHasld() {
		return hasld;
	}

	public void setHasld(Integer hasld) {
		this.hasld = hasld;
	}

	public Integer getKeeporigassgn() {
		return keeporigassgn;
	}

	public void setKeeporigassgn(Integer keeporigassgn) {
		this.keeporigassgn = keeporigassgn;
	}

	public String getLangcode() {
		return langcode;
	}

	public void setLangcode(String langcode) {
		this.langcode = langcode;
	}

	public Integer getNodeid() {
		return nodeid;
	}

	public void setNodeid(Integer nodeid) {
		this.nodeid = nodeid;
	}

	public String getNonacceptmsg() {
		return nonacceptmsg;
	}

	public void setNonacceptmsg(String nonacceptmsg) {
		this.nonacceptmsg = nonacceptmsg;
	}

	public String getOrigperson() {
		return origperson;
	}

	public void setOrigperson(String origperson) {
		this.origperson = origperson;
	}

	public String getOwnertable() {
		return ownertable;
	}

	public void setOwnertable(String ownertable) {
		this.ownertable = ownertable;
	}

	public String getProcessname() {
		return processname;
	}

	public void setProcessname(String processname) {
		this.processname = processname;
	}

	public Integer getProcessrev() {
		return processrev;
	}

	public void setProcessrev(Integer processrev) {
		this.processrev = processrev;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	public long getRowstamp() {
		return rowstamp;
	}

	public void setRowstamp(long rowstamp) {
		this.rowstamp = rowstamp;
	}

	public Integer getSeparategroups() {
		return separategroups;
	}

	public void setSeparategroups(Integer separategroups) {
		this.separategroups = separategroups;
	}

	public String getTemplateid() {
		return templateid;
	}

	public void setTemplateid(String templateid) {
		this.templateid = templateid;
	}

	public Double getTimelimit() {
		return timelimit;
	}

	public void setTimelimit(Double timelimit) {
		this.timelimit = timelimit;
	}

	public long getWfid() {
		return wfid;
	}

	public void setWfid(long wfid) {
		this.wfid = wfid;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}
}