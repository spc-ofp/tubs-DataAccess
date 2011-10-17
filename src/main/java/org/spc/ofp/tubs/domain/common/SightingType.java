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

/**
 *
 * @author Corey Cole <coreyc@spc.int>
 */
@Entity
@Table(name = "[obsv].[ref_sightings_type]")
public class SightingType implements java.io.Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -7081845649258008992L;

	@Id
    @Column(name = "type_code")
    private long code;
    
    @Column(name = "type_name", length = 30)
    @Size(max = 30)
    private String name;
    
    @Override
    public String toString() {
        return name;
    }

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
