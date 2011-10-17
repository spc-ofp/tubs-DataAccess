/*
 * Copyright (C) 2011 Secretariat of the Pacific Community
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package org.spc.ofp.tubs.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * @author Corey Cole <coreyc@spc.int>
 *
 */
@Entity
@Table(name = "[obsv].[gen2multi]")
public class InteractionSupplementHeader implements java.io.Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7641559305660288088L;

	@Id
    @Column(name = "spmulti_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@Column(name = "landed_dtime")
	private Date landedDate;
	
	@Column(name = "measure", length = 50)
	private String measuringInstrument;
	
	@Column(name = "ps4_form_yn")
	private Boolean hasPS4;
	
	@Lob
    @Size(max = 10000)
    @Column(name = "comments")
	private String comments;
	
	@Embedded
	private AuditEntry auditEntry;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Trip.class)
    @JoinColumn(name = "obstrip_id")
	private Trip trip;
	
	@OneToMany(cascade = CascadeType.ALL, targetEntity = InteractionSupplementDetails.class, mappedBy = "header")
	private List<InteractionSupplementDetails> details;
	
	public boolean hasAssociatedPs4() {
		return null != hasPS4 && hasPS4.booleanValue();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getLandedDate() {
		return landedDate;
	}

	public void setLandedDate(Date landedDate) {
		this.landedDate = landedDate;
	}

	public String getMeasuringInstrument() {
		return measuringInstrument;
	}

	public void setMeasuringInstrument(String measuringInstrument) {
		this.measuringInstrument = measuringInstrument;
	}

	public Boolean getHasPS4() {
		return hasPS4;
	}

	public void setHasPS4(Boolean hasPS4) {
		this.hasPS4 = hasPS4;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public AuditEntry getAuditEntry() {
		return auditEntry;
	}

	public void setAuditEntry(AuditEntry auditEntry) {
		this.auditEntry = auditEntry;
	}

	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	public List<InteractionSupplementDetails> getDetails() {
		return details;
	}

	public void setDetails(List<InteractionSupplementDetails> details) {
		this.details = details;
	}
}
