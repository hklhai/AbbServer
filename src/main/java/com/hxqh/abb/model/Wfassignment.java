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

//	private String acceptexpr;
//
//	private String app;
//
//	@Column(name="ASSIGN_01")
//	private String assign01;
//
//	@Column(name="ASSIGN_02")
//	private String assign02;
//
//	@Column(name="ASSIGN_03")
//	private String assign03;
//
//	@Column(name="ASSIGN_04")
//	private String assign04;
//
//	@Column(name="ASSIGN_05")
//	private String assign05;
//
//	private String assigncode;
//
//	private long assignid;
//
//	private String assignstatus;
//
//	private int calendarbased;
//
//	@Column(name="\"CONDITION\"")
//	private String condition;
//
//	private String conditionclass;
//
//
//
//
//	private int emailnotification;
//
//	private String escrole;
//
//	//private int groupnum;
//
//	private int hasld;
//
//	private int keeporigassgn;
//
//	private String langcode;
//
//	private int nodeid;
//
//	private String nonacceptmsg;
//
//	private String origperson;
//
//	//private long ownerid;
//
//	private String ownertable;
//
//
//
//	private String processname;
//
//	private int processrev;
//
//	private String relationship;
//
//	private String roleid;
//
//	private long rowstamp;
//
//	private int separategroups;
//
//
//
//	private String templateid;
//
//	private double timelimit;
//
//	private long wfid;


	private Timestamp duedate;
	private String description;
	private Timestamp startdate;
//	@Column(name="\"PRIORITY\"")
//	private int priority;


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

//	public int getPriority() {
//		return priority;
//	}
//
//	public void setPriority(int priority) {
//		this.priority = priority;
//	}
}