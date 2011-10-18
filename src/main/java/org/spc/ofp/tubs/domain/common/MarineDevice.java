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
@Table(name = "[obsv].[ref_marine_devices]")
public class MarineDevice implements java.io.Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -7591233501799132174L;

	@Id
    @Column(name = "device_id")
    private long id;
    
    @Column(name = "device_desc")
    @Size(max = 40)
    @NotNull
    private String description;
    
    @Column(name = "device_cat")
    @Size(max = 40)
    private String category;
    
    @Column(name = "gearlist")
    private String forGearTypes;
    
    @Column(name = "order_l")
    private Integer longLineOrder;
    
    @Column(name = "order_s")
    private Integer purseSeineOrder;
    
    @Column(name = "order_p")
    private Integer poleAndLineOrder;
    
    @Embedded
    private AuditEntry auditEntry;
    
    @Override
    public String toString() {
        return description;
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getForGearTypes() {
		return forGearTypes;
	}

	public void setForGearTypes(String forGearTypes) {
		this.forGearTypes = forGearTypes;
	}

	public Integer getLongLineOrder() {
		return longLineOrder;
	}

	public void setLongLineOrder(Integer longLineOrder) {
		this.longLineOrder = longLineOrder;
	}

	public Integer getPurseSeineOrder() {
		return purseSeineOrder;
	}

	public void setPurseSeineOrder(Integer purseSeineOrder) {
		this.purseSeineOrder = purseSeineOrder;
	}

	public Integer getPoleAndLineOrder() {
		return poleAndLineOrder;
	}

	public void setPoleAndLineOrder(Integer poleAndLineOrder) {
		this.poleAndLineOrder = poleAndLineOrder;
	}

	public AuditEntry getAuditEntry() {
		return auditEntry;
	}

	public void setAuditEntry(AuditEntry auditEntry) {
		this.auditEntry = auditEntry;
	}   
}
