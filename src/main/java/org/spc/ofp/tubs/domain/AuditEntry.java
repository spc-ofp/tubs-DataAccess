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

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Corey Cole <coreyc@spc.int>
 *
 */
@Embeddable
public class AuditEntry {

	@Column(name = "entered_dtime", updatable = false)
    private Date enteredDate;
    
    @Column(name = "entered_by", updatable = false)
    private String enteredBy;
    
    public AuditEntry() { }
    
    public AuditEntry(final String who, final Date when) {
    	this.enteredBy = who;
    	this.enteredDate = when;
    }

	public Date getEnteredDate() {
		return enteredDate;
	}

	public void setEnteredDate(Date enteredDate) {
		this.enteredDate = enteredDate;
	}

	public String getEnteredBy() {
		return enteredBy;
	}

	public void setEnteredBy(String enteredBy) {
		this.enteredBy = enteredBy;
	}
}
