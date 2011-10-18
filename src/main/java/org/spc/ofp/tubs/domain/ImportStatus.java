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


/**
 * @author Corey Cole <coreyc@spc.int>
 *
 */
@Entity
@Table(name = "[obsv].[import_status]")
public class ImportStatus implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -1114329037773628090L;

	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@Size(max = 25)
	@Column(name = "source_id", nullable = false, length = 25)
	private String sourceId;
	
	@Size(max = 25)
	@Column(name = "source_name", nullable = false, length = 25)
	private String sourceName;
	
	@Column(name = "obstrip_id")
	private long tripId;
	
	@Size(max = 1)
	@Column(name = "status", length = 1)
	private String status;
	
	@Lob
	@Column(name = "comments")
	@Size(max = 10000)
	private String comments;
	
	@Embedded
	private AuditEntry auditEntry;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSourceId() {
		return sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public long getTripId() {
		return tripId;
	}

	public void setTripId(long tripId) {
		this.tripId = tripId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public AuditEntry getAuditEntry() {
		return auditEntry;
	}

	public void setAuditEntry(final AuditEntry auditEntry) {
		this.auditEntry = auditEntry;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(final String comments) {
		this.comments = comments;
	}
}
