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

	private int calendarbased;

	@Column(name="\"CONDITION\"")
	private String condition;

	private String conditionclass;

	private String description;

	private Timestamp duedate;

	private int emailnotification;

	private String escrole;

	private int groupnum;

	private int hasld;

	private int keeporigassgn;

	private String langcode;

	private int nodeid;

	private String nonacceptmsg;

	private String origperson;

	private long ownerid;

	private String ownertable;

	@Column(name="\"PRIORITY\"")
	private int priority;

	private String processname;

	private int processrev;

	private String relationship;

	private String roleid;

	private long rowstamp;

	private int separategroups;

	private Timestamp startdate;

	private String templateid;

	private double timelimit;

	private long wfid;

	public Wfassignment() {
	}

	public long getWfassignmentid() {
		return this.wfassignmentid;
	}

	public void setWfassignmentid(long wfassignmentid) {
		this.wfassignmentid = wfassignmentid;
	}

	public String getAcceptexpr() {
		return this.acceptexpr;
	}

	public void setAcceptexpr(String acceptexpr) {
		this.acceptexpr = acceptexpr;
	}

	public String getApp() {
		return this.app;
	}

	public void setApp(String app) {
		this.app = app;
	}

	public String getAssign01() {
		return this.assign01;
	}

	public void setAssign01(String assign01) {
		this.assign01 = assign01;
	}

	public String getAssign02() {
		return this.assign02;
	}

	public void setAssign02(String assign02) {
		this.assign02 = assign02;
	}

	public String getAssign03() {
		return this.assign03;
	}

	public void setAssign03(String assign03) {
		this.assign03 = assign03;
	}

	public String getAssign04() {
		return this.assign04;
	}

	public void setAssign04(String assign04) {
		this.assign04 = assign04;
	}

	public String getAssign05() {
		return this.assign05;
	}

	public void setAssign05(String assign05) {
		this.assign05 = assign05;
	}

	public String getAssigncode() {
		return this.assigncode;
	}

	public void setAssigncode(String assigncode) {
		this.assigncode = assigncode;
	}

	public long getAssignid() {
		return this.assignid;
	}

	public void setAssignid(long assignid) {
		this.assignid = assignid;
	}

	public String getAssignstatus() {
		return this.assignstatus;
	}

	public void setAssignstatus(String assignstatus) {
		this.assignstatus = assignstatus;
	}

	public int getCalendarbased() {
		return this.calendarbased;
	}

	public void setCalendarbased(int calendarbased) {
		this.calendarbased = calendarbased;
	}

	public String getCondition() {
		return this.condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getConditionclass() {
		return this.conditionclass;
	}

	public void setConditionclass(String conditionclass) {
		this.conditionclass = conditionclass;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getDuedate() {
		return this.duedate;
	}

	public void setDuedate(Timestamp duedate) {
		this.duedate = duedate;
	}

	public int getEmailnotification() {
		return this.emailnotification;
	}

	public void setEmailnotification(int emailnotification) {
		this.emailnotification = emailnotification;
	}

	public String getEscrole() {
		return this.escrole;
	}

	public void setEscrole(String escrole) {
		this.escrole = escrole;
	}

	public int getGroupnum() {
		return this.groupnum;
	}

	public void setGroupnum(int groupnum) {
		this.groupnum = groupnum;
	}

	public int getHasld() {
		return this.hasld;
	}

	public void setHasld(int hasld) {
		this.hasld = hasld;
	}

	public int getKeeporigassgn() {
		return this.keeporigassgn;
	}

	public void setKeeporigassgn(int keeporigassgn) {
		this.keeporigassgn = keeporigassgn;
	}

	public String getLangcode() {
		return this.langcode;
	}

	public void setLangcode(String langcode) {
		this.langcode = langcode;
	}

	public int getNodeid() {
		return this.nodeid;
	}

	public void setNodeid(int nodeid) {
		this.nodeid = nodeid;
	}

	public String getNonacceptmsg() {
		return this.nonacceptmsg;
	}

	public void setNonacceptmsg(String nonacceptmsg) {
		this.nonacceptmsg = nonacceptmsg;
	}

	public String getOrigperson() {
		return this.origperson;
	}

	public void setOrigperson(String origperson) {
		this.origperson = origperson;
	}

	public long getOwnerid() {
		return this.ownerid;
	}

	public void setOwnerid(long ownerid) {
		this.ownerid = ownerid;
	}

	public String getOwnertable() {
		return this.ownertable;
	}

	public void setOwnertable(String ownertable) {
		this.ownertable = ownertable;
	}

	public int getPriority() {
		return this.priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getProcessname() {
		return this.processname;
	}

	public void setProcessname(String processname) {
		this.processname = processname;
	}

	public int getProcessrev() {
		return this.processrev;
	}

	public void setProcessrev(int processrev) {
		this.processrev = processrev;
	}

	public String getRelationship() {
		return this.relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getRoleid() {
		return this.roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	public long getRowstamp() {
		return this.rowstamp;
	}

	public void setRowstamp(long rowstamp) {
		this.rowstamp = rowstamp;
	}

	public int getSeparategroups() {
		return this.separategroups;
	}

	public void setSeparategroups(int separategroups) {
		this.separategroups = separategroups;
	}

	public Timestamp getStartdate() {
		return this.startdate;
	}

	public void setStartdate(Timestamp startdate) {
		this.startdate = startdate;
	}

	public String getTemplateid() {
		return this.templateid;
	}

	public void setTemplateid(String templateid) {
		this.templateid = templateid;
	}

	public double getTimelimit() {
		return this.timelimit;
	}

	public void setTimelimit(double timelimit) {
		this.timelimit = timelimit;
	}

	public long getWfid() {
		return this.wfid;
	}

	public void setWfid(long wfid) {
		this.wfid = wfid;
	}

}