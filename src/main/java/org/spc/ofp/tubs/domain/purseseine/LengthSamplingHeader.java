/*
 * Copyright (C) 2011 Secretariat of the Pacific Community
 *
 * This file is part of TUBS.
 *
 * TUBS is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * TUBS is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with TUBS.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.spc.ofp.tubs.domain.purseseine;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.spc.ofp.tubs.domain.AuditEntry;
import org.spc.ofp.tubs.domain.common.ReferenceId;

/**
 * @author Corey Cole <coreyc@spc.int>
 *
 */
@Entity
@Table(name = "[obsv].[s_lf]")
public class LengthSamplingHeader implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4857612544015179791L;

	@Id
    @Column(name = "s_lf_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "form_id")
	private Integer formId;
	
	@OneToOne
	@JoinColumn(name = "sampletype_id")
	private ReferenceId protocolType;
	
	@Column(name = "other_desc")
	@Size(max = 50)
	private String samplingProtocolComments;
	
	@Column(name = "sbrail_time")
	@Size(max = 4)
	// Does @Min(0), @Max(2359) provide a better validation?
	@Min(0)
	@Max(2359)
	@Pattern(regexp = "[0-2][0-9][0-5][0-9]") // TODO Confirm this is a reasonable regex.  Also, check for time of day pattern
	private String brailStartTime;
	
	@Column(name = "ebrail_time")
	@Size(max = 4)
	@Pattern(regexp = "[0-2][0-9][0-5][0-9]") // TODO Confirm this is a reasonable regex.  Also, check for time of day pattern
	private String brailEndTime;
	
	@Embedded
    private AuditEntry auditEntry;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = FishingSet.class)
	@JoinColumn(name = "s_set_id")
    private FishingSet fishingSet; 
	
	@OneToMany(cascade = CascadeType.ALL, targetEntity = LengthSample.class, mappedBy = "header")
	private List<LengthSample> samples;
	
	@OneToMany(cascade = CascadeType.ALL, targetEntity = LengthSampleColumnTotal.class, mappedBy = "header")
	private List<LengthSampleColumnTotal> columnTotals;
	
	@OneToMany(cascade = CascadeType.ALL, targetEntity = Brail.class, mappedBy = "header")
	private List<Brail> brails;
	
	@OneToOne(cascade = CascadeType.ALL, targetEntity = LengthSamplePageTotal.class, mappedBy = "header")
	private LengthSamplePageTotal pageTotals;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Integer getFormId() {
		return formId;
	}

	public void setFormId(Integer formId) {
		this.formId = formId;
	}

	public ReferenceId getProtocolType() {
		return protocolType;
	}

	public void setProtocolType(ReferenceId protocolType) {
		this.protocolType = protocolType;
	}

	public String getSamplingProtocolComments() {
		return samplingProtocolComments;
	}

	public void setSamplingProtocolComments(String samplingProtocolComments) {
		this.samplingProtocolComments = samplingProtocolComments;
	}

	public String getBrailStartTime() {
		return brailStartTime;
	}

	public void setBrailStartTime(String brailStartTime) {
		this.brailStartTime = brailStartTime;
	}

	public String getBrailEndTime() {
		return brailEndTime;
	}

	public void setBrailEndTime(String brailEndTime) {
		this.brailEndTime = brailEndTime;
	}

	public AuditEntry getAuditEntry() {
		return auditEntry;
	}

	public void setAuditEntry(AuditEntry auditEntry) {
		this.auditEntry = auditEntry;
	}

	public List<LengthSample> getSamples() {
		return samples;
	}

	public void setSamples(List<LengthSample> samples) {
		if (null != samples) {
			for (final LengthSample sample : samples) {
				sample.setHeader(this);
			}
		}
		this.samples = samples;
	}

	public List<LengthSampleColumnTotal> getColumnTotals() {
		return columnTotals;
	}

	public void setColumnTotals(List<LengthSampleColumnTotal> columnTotals) {
		if (null != columnTotals) {
			for (final LengthSampleColumnTotal columnTotal : columnTotals) {
				columnTotal.setHeader(this);
			}
		}
		this.columnTotals = columnTotals;
	}

	public LengthSamplePageTotal getPageTotals() {
		return pageTotals;
	}

	public void setPageTotals(LengthSamplePageTotal pageTotals) {
		if (null != pageTotals) { pageTotals.setHeader(this); }
		this.pageTotals = pageTotals;
	}

	public FishingSet getFishingSet() {
		return fishingSet;
	}

	public void setFishingSet(FishingSet fishingSet) {
		this.fishingSet = fishingSet;
	}

	public List<Brail> getBrails() {
		return brails;
	}

	public void setBrails(List<Brail> brails) {
		if (null != brails) {
			for (final Brail brail : brails) {
				brail.setHeader(this);
			}
		}
		this.brails = brails;
	}
}
