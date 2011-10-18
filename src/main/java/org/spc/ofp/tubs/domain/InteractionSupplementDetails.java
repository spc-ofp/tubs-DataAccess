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
package org.spc.ofp.tubs.domain;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.spc.ofp.tubs.domain.common.FishCondition;
import org.spc.ofp.tubs.domain.common.LengthMeasurement;
import org.spc.ofp.tubs.domain.common.Sex;

/**
 * Observers can fill out a supplement to a GEN-2 form
 * if there are multiple special species.  The supplement is
 * associated with an already existing GEN-2 form and holds
 * @author Corey Cole <coreyc@spc.int>
 *
 */
@Entity
@Table(name = "[obsv].[gen2multidetails]")
public class InteractionSupplementDetails implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4001023396820662516L;

	@Id
    @Column(name = "spmultdetails_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@Column(name = "sp_code", length = 3, nullable = false)
	private String speciesCode;
	
	@OneToOne
	@JoinColumn(name = "sex_code")
	private Sex sex;
	
	@Column(name = "len")
	private Double length;
	
	@OneToOne
	@JoinColumn(name = "len_code")
	private LengthMeasurement lengthMeasurement;
	
	@JoinColumn(name = "landed_cond_code")
	private FishCondition landedCondition;
    
    @Lob
    @Size(max = 10000)
    @Column(name = "landed_cond_desc")
    private String landedConditionDescription;
    
    @JoinColumn(name = "discard_cond_code")
    private FishCondition discardedCondition;
    
    @Lob
    @Size(max = 10000)
    @Column(name = "discard_cond_desc")
    private String discardedConditionDescription;
	
	@Embedded
	private AuditEntry auditEntry;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = InteractionSupplementHeader.class)
    @JoinColumn(name = "spmulti_id")
	private InteractionSupplementHeader header;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSpeciesCode() {
		return speciesCode;
	}

	public void setSpeciesCode(String speciesCode) {
		this.speciesCode = speciesCode;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public Double getLength() {
		return length;
	}

	public void setLength(Double length) {
		this.length = length;
	}

	public LengthMeasurement getLengthMeasurement() {
		return lengthMeasurement;
	}

	public void setLengthMeasurement(LengthMeasurement lengthMeasurement) {
		this.lengthMeasurement = lengthMeasurement;
	}

	public FishCondition getLandedCondition() {
		return landedCondition;
	}

	public void setLandedCondition(FishCondition landedCondition) {
		this.landedCondition = landedCondition;
	}

	public String getLandedConditionDescription() {
		return landedConditionDescription;
	}

	public void setLandedConditionDescription(String landedConditionDescription) {
		this.landedConditionDescription = landedConditionDescription;
	}

	public FishCondition getDiscardedCondition() {
		return discardedCondition;
	}

	public void setDiscardedCondition(FishCondition discardedCondition) {
		this.discardedCondition = discardedCondition;
	}

	public String getDiscardedConditionDescription() {
		return discardedConditionDescription;
	}

	public void setDiscardedConditionDescription(
			String discardedConditionDescription) {
		this.discardedConditionDescription = discardedConditionDescription;
	}

	public AuditEntry getAuditEntry() {
		return auditEntry;
	}

	public void setAuditEntry(AuditEntry auditEntry) {
		this.auditEntry = auditEntry;
	}

	public InteractionSupplementHeader getHeader() {
		return header;
	}

	public void setHeader(InteractionSupplementHeader header) {
		this.header = header;
	}
}
