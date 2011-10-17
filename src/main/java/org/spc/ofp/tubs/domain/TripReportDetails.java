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

import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * @author Corey Cole <coreyc@spc.int>
 *
 */
@Entity
@Table(name = "[obsv].[gen3tripmondetails]")
public class TripReportDetails implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8123472914944366740L;

	@Id
    @Column(name = "gen3details_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@Column(name = "gen3_date")
	private java.util.Date incidentDate;
	
	@Lob
	@Column(name = "comments")
	@Size(max = 10000)
	private String comments;	
	
	@Embedded
	private AuditEntry auditEntry;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = TripReportHeader.class)
    @JoinColumn(name = "gen3_id")
    private TripReportHeader header;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public java.util.Date getIncidentDate() {
		return incidentDate;
	}

	public void setIncidentDate(java.util.Date incidentDate) {
		this.incidentDate = incidentDate;
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

	public TripReportHeader getHeader() {
		return header;
	}

	public void setHeader(TripReportHeader header) {
		this.header = header;
	}
}
