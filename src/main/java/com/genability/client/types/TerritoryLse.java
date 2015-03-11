package com.genability.client.types;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TerritoryLse {
	private Long lseId;
	private String lseName;

	private Boolean distribution;
	private Boolean supplierResidential;
	private Boolean supplierGeneral;
	private BigDecimal residentialCoverage;
	private BigDecimal generalCoverage;
	
	public Long getLseId() {
		return lseId;
	}

	public void setLseId(Long lseId) {
		this.lseId = lseId;
	}

	public String getLseName() {
		return lseName;
	}

	public void setLseName(String lseName) {
		this.lseName = lseName;
	}

	public Boolean getDistribution() {
		return distribution;
	}

	public void setDistribution(Boolean distribution) {
		this.distribution = distribution;
	}

	public Boolean getSupplierResidential() {
		return supplierResidential;
	}

	public void setSupplierResidential(Boolean supplierResidential) {
		this.supplierResidential = supplierResidential;
	}

	public Boolean getSupplierGeneral() {
		return supplierGeneral;
	}

	public void setSupplierGeneral(Boolean supplierGeneral) {
		this.supplierGeneral = supplierGeneral;
	}

	public BigDecimal getResidentialCoverage() {
		return residentialCoverage;
	}

	public void setResidentialCoverage(BigDecimal residentialCoverage) {
		this.residentialCoverage = residentialCoverage;
	}

	public BigDecimal getGeneralCoverage() {
		return generalCoverage;
	}

	public void setGeneralCoverage(BigDecimal generalCoverage) {
		this.generalCoverage = generalCoverage;
	}
}
