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
@Table(name = "[obsv].[ref_line_material]")
public class LineMaterial implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -263573322564768386L;

	@Id
    @Column(name = "Material_code", length = 2)
    @Size(max = 2)
    private String code;
    
    @Column(name = "Gear_code", length = 1)
    @Size(max = 1)
    private String gearCode;
    
    @Column(name = "Material_desc")
    @Size(max = 30)
    private String description;
    
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

	public String getGearCode() {
		return gearCode;
	}

	public void setGearCode(String gearCode) {
		this.gearCode = gearCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
