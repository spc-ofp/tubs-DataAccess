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
@Table(name = "[obsv].[ref_sp_len_wt]")
public class SpeciesWeight implements java.io.Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -3315871851437935720L;

	@Id
    @Column(name = "sp_code", length = 3)
    @Size(max=3)
    private String code;
    
    @Column(name = "samplesize")
    private Integer sampleSize;
    
    @Column(name = "avg_wt")
    private Double average;
    
    @Column(name = "obsv_wt_est")
    private Integer observerEstimate;
    
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

	public Integer getSampleSize() {
		return sampleSize;
	}

	public void setSampleSize(Integer sampleSize) {
		this.sampleSize = sampleSize;
	}

	public Double getAverage() {
		return average;
	}

	public void setAverage(Double average) {
		this.average = average;
	}

	public Integer getObserverEstimate() {
		return observerEstimate;
	}

	public void setObserverEstimate(Integer observerEstimate) {
		this.observerEstimate = observerEstimate;
	}

	public AuditEntry getAuditEntry() {
		return auditEntry;
	}

	public void setAuditEntry(AuditEntry auditEntry) {
		this.auditEntry = auditEntry;
	}
}
