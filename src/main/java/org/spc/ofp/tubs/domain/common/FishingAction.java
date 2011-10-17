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
package org.spc.ofp.tubs.domain.common;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.spc.ofp.tubs.domain.AuditEntry;

/**
 *
 * @author Corey Cole <coreyc@spc.int>
 */
@Entity
@Table(name = "[obsv].[ref_action]")
public class FishingAction implements java.io.Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 5069446156787516371L;

	@Id
    @Column(name = "action_code", length = 2)
    private String code;
    
    @Column(name = "desc")
    @NotNull
    @Size(max = 100)
    private String description;
    
    @Column(name = "inuse_yn")
    private Boolean inUse;
    
    @Column(name = "forms_used")
    private String usedOnForms;
    
    @Embedded
    private AuditEntry auditEntry;
    
    @Override
    public String toString() {
        return code;
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

	public Boolean getInUse() {
		return inUse;
	}

	public void setInUse(Boolean inUse) {
		this.inUse = inUse;
	}

	public String getUsedOnForms() {
		return usedOnForms;
	}

	public void setUsedOnForms(String usedOnForms) {
		this.usedOnForms = usedOnForms;
	}

	public AuditEntry getAuditEntry() {
		return auditEntry;
	}

	public void setAuditEntry(AuditEntry auditEntry) {
		this.auditEntry = auditEntry;
	}
}
