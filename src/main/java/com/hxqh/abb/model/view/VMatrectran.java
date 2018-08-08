package com.hxqh.abb.model.view;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the V_MATRECTRANS database table.
 * 
 */
@Entity
@Table(name="V_MATRECTRANS")
public class VMatrectran implements Serializable {
	private static final long serialVersionUID = 1L;

	private Date actualdate;

	private String assetnum;

	private BigDecimal conversion;

	private String enterby;

	private String issueunit;

	private String itemdescription;

	private String itemnum;

	private String itemudmodel;

	@Column(name="\"LOCATION\"")
	private String location;

	@Id
	private Long matrectransid;

	private Integer polinenum;

	private String receivedunit;

	private String remark;

	private String tobin;

	private String tostoreloc;

	private String ponum;

	public VMatrectran() {
	}

	public String getPonum() {
		return ponum;
	}

	public void setPonum(String ponum) {
		this.ponum = ponum;
	}

	public Date getActualdate() {
		return actualdate;
	}

	public void setActualdate(Date actualdate) {
		this.actualdate = actualdate;
	}

	public String getAssetnum() {
		return assetnum;
	}

	public void setAssetnum(String assetnum) {
		this.assetnum = assetnum;
	}

	public BigDecimal getConversion() {
		return conversion;
	}

	public void setConversion(BigDecimal conversion) {
		this.conversion = conversion;
	}

	public String getEnterby() {
		return enterby;
	}

	public void setEnterby(String enterby) {
		this.enterby = enterby;
	}

	public String getIssueunit() {
		return issueunit;
	}

	public void setIssueunit(String issueunit) {
		this.issueunit = issueunit;
	}

	public String getItemdescription() {
		return itemdescription;
	}

	public void setItemdescription(String itemdescription) {
		this.itemdescription = itemdescription;
	}

	public String getItemnum() {
		return itemnum;
	}

	public void setItemnum(String itemnum) {
		this.itemnum = itemnum;
	}

	public String getItemudmodel() {
		return itemudmodel;
	}

	public void setItemudmodel(String itemudmodel) {
		this.itemudmodel = itemudmodel;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Long getMatrectransid() {
		return matrectransid;
	}

	public void setMatrectransid(Long matrectransid) {
		this.matrectransid = matrectransid;
	}

	public Integer getPolinenum() {
		return polinenum;
	}

	public void setPolinenum(Integer polinenum) {
		this.polinenum = polinenum;
	}

	public String getReceivedunit() {
		return receivedunit;
	}

	public void setReceivedunit(String receivedunit) {
		this.receivedunit = receivedunit;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getTobin() {
		return tobin;
	}

	public void setTobin(String tobin) {
		this.tobin = tobin;
	}

	public String getTostoreloc() {
		return tostoreloc;
	}

	public void setTostoreloc(String tostoreloc) {
		this.tostoreloc = tostoreloc;
	}
}