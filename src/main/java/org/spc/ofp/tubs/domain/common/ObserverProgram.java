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
package org.spc.ofp.tubs.domain.common;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.spc.ofp.tubs.domain.AuditEntry;


/**
 *
 * @author Corey Cole <coreyc@spc.int>
 */
@Entity
@Table(name = "[obsv].[ref_programs]")
public class ObserverProgram implements java.io.Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -5743772990900925688L;

	@Id
    @Column(name = "obsprg_code", length = 4)
    @Size(max = 4)
    private String code;
    
    @Column(name = "description")
    @NotNull
    @Size(max = 40)
    private String description;
    
    @Column(name = "comments")
    @Lob
    @Size(max = 10000)
    private String comments;
    
    @Embedded
    private AuditEntry auditEntry;
    
    @Override
    public String toString() {
        return String.format("%s (%s)", description, code);
    }

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
}
