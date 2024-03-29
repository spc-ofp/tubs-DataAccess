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

import java.io.Serializable;

import javax.persistence.*;

/**
 * @author Corey Cole <coreyc@spc.int>
 *
 */
@Entity
@Table(name = "ref.field_staff")
public class Observer implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6584845096950176233L;

	@Id
    @Column(name = "staff_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "staff_code")
    private String staffCode;
    
    @Column(name = "first_name")
    private String firstName;
    
    @Column(name = "family_name")
    private String familyName;
    
    @Column(name = "nationality_country_code", length = 2)
    private String nationalityCountryCode;
    
    @Override
    public String toString() {
        return String.format(
            "%s %s",
                null == firstName ? "" : firstName.trim(),
                null == familyName ? "" : familyName.trim());
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStaffCode() {
		return staffCode;
	}

	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getNationalityCountryCode() {
		return nationalityCountryCode;
	}

	public void setNationalityCountryCode(String nationalityCountryCode) {
		this.nationalityCountryCode = nationalityCountryCode;
	}
}
