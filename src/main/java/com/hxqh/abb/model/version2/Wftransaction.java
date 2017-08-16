package com.hxqh.abb.model.version2;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Date;


/**
 * The persistent class for the WFTRANSACTION database table.
 * 
 */
@Entity
@Table(name="Wftransaction")
public class Wftransaction implements Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="WFTRANSACTION_TRANSID_GENERATOR", sequenceName="WFTRANSACTIONSEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="WFTRANSACTION_TRANSID_GENERATOR")
	private Long transid;

	private Integer actionid;

	private String actionperformed;

	private Long assignid;

	private String memo;

	private Integer nodeid;

	private String nodetype;

	private Long ownerid;

	private String ownertable;

	private String personid;

	private String processname;

	private Integer processrev;

	private Long rowstamp;

	private Date transdate;

	private String transtype;

	private Long wfid;

	private String wftasktype;

	public Wftransaction() {
	}

	public Long getTransid() {
		return this.transid;
	}

	public void setTransid(Long transid) {
		this.transid = transid;
	}

	public Integer getActionid() {
		return this.actionid;
	}

	public void setActionid(Integer actionid) {
		this.actionid = actionid;
	}

	public String getActionperformed() {
		return this.actionperformed;
	}

	public void setActionperformed(String actionperformed) {
		this.actionperformed = actionperformed;
	}

	public Long getAssignid() {
		return this.assignid;
	}

	public void setAssignid(Long assignid) {
		this.assignid = assignid;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Integer getNodeid() {
		return this.nodeid;
	}

	public void setNodeid(Integer nodeid) {
		this.nodeid = nodeid;
	}

	public String getNodetype() {
		return this.nodetype;
	}

	public void setNodetype(String nodetype) {
		this.nodetype = nodetype;
	}

	public Long getOwnerid() {
		return this.ownerid;
	}

	public void setOwnerid(Long ownerid) {
		this.ownerid = ownerid;
	}

	public String getOwnertable() {
		return this.ownertable;
	}

	public void setOwnertable(String ownertable) {
		this.ownertable = ownertable;
	}

	public String getPersonid() {
		return this.personid;
	}

	public void setPersonid(String personid) {
		this.personid = personid;
	}

	public String getProcessname() {
		return this.processname;
	}

	public void setProcessname(String processname) {
		this.processname = processname;
	}

	public Integer getProcessrev() {
		return this.processrev;
	}

	public void setProcessrev(Integer processrev) {
		this.processrev = processrev;
	}

	public Long getRowstamp() {
		return this.rowstamp;
	}

	public void setRowstamp(Long rowstamp) {
		this.rowstamp = rowstamp;
	}

	public Date getTransdate() {
		return this.transdate;
	}

	public void setTransdate(Date transdate) {
		this.transdate = transdate;
	}

	public String getTranstype() {
		return this.transtype;
	}

	public void setTranstype(String transtype) {
		this.transtype = transtype;
	}

	public Long getWfid() {
		return this.wfid;
	}

	public void setWfid(Long wfid) {
		this.wfid = wfid;
	}

	public String getWftasktype() {
		return this.wftasktype;
	}

	public void setWftasktype(String wftasktype) {
		this.wftasktype = wftasktype;
	}

}