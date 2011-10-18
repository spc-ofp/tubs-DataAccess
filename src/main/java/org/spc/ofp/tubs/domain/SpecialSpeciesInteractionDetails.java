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

import org.spc.ofp.tubs.domain.common.FishCondition;

/**
 * @author Corey Cole <coreyc@spc.int>
 *
 */
@Entity
@Table(name = "[obsv].[gen2specialinteraction]")
public class SpecialSpeciesInteractionDetails implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6487312870011014486L;

	@Id
    @Column(name = "sspinteraction_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@Column(name = "start_end", length = 5, nullable = false)
	private String startAndEnd;
	
	@Column(name = "number")
	private Integer number;
	
	@JoinColumn(name = "cond_code")
	private FishCondition condition;
	
	@Column(name = "description", length = 50)
	private String description;
	
	@Embedded
	private AuditEntry auditEntry;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = SpecialSpeciesInteraction.class)
    @JoinColumn(name = "ssp_id")
	private SpecialSpeciesInteraction header;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStartAndEnd() {
		return startAndEnd;
	}

	public void setStartAndEnd(String startAndEnd) {
		this.startAndEnd = startAndEnd;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public FishCondition getCondition() {
		return condition;
	}

	public void setCondition(FishCondition condition) {
		this.condition = condition;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public AuditEntry getAuditEntry() {
		return auditEntry;
	}

	public void setAuditEntry(AuditEntry auditEntry) {
		this.auditEntry = auditEntry;
	}

	public SpecialSpeciesInteraction getHeader() {
		return header;
	}

	public void setHeader(SpecialSpeciesInteraction header) {
		this.header = header;
	}
}
