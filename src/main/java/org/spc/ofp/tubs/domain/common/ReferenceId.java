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
@Table(name = "[obsv].[ref_ids]")
public class ReferenceId implements java.io.Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -1904462366048086042L;

	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @NotNull
    @Column(name = "source")
    private String source;
    
    @Column(name = "code_name")
    private String codeName;
    
    @Size(max = 200)
    @Column(name = "code_notes", length = 200)
    private String codeNotes;
    
    @Column(name = "forms_used")
    private String formsWhereUsed;
    
    @Column(name = "inuse_yn")
    private Boolean isInUse;
    
    @Embedded
    private AuditEntry auditEntry;
    
    @Override
    public String toString() {
        return codeName;
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public String getCodeNotes() {
		return codeNotes;
	}

	public void setCodeNotes(String codeNotes) {
		this.codeNotes = codeNotes;
	}

	public String getFormsWhereUsed() {
		return formsWhereUsed;
	}

	public void setFormsWhereUsed(String formsWhereUsed) {
		this.formsWhereUsed = formsWhereUsed;
	}

	public Boolean getIsInUse() {
		return isInUse;
	}

	public void setIsInUse(Boolean isInUse) {
		this.isInUse = isInUse;
	}

	public AuditEntry getAuditEntry() {
		return auditEntry;
	}

	public void setAuditEntry(AuditEntry auditEntry) {
		this.auditEntry = auditEntry;
	}
}
