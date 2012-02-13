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
@Table(name = "[ref].[ports]")
public class Port implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8273434498577506665L;

	@Id
    @Column(name = "port_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "port_name")
    private String name;
    
    @Column(name = "country_code")
    private String countryCode;
    
    @Column(name = "location_code")
    private String locationCode;
    
    @Column(name = "alsocalled")
    private String alsoCalled;
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(32);
        sb.append(null == name ? "Unknown" : name).append(" (");
        sb.append(countryCode).append(")");
        return sb.toString();
        
    }

	public long getId() {
		return id;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(final String countryCode) {
		this.countryCode = countryCode;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(final String locationCode) {
		this.locationCode = locationCode;
	}

	public String getAlsoCalled() {
		return alsoCalled;
	}

	public void setAlsoCalled(final String alsoCalled) {
		this.alsoCalled = alsoCalled;
	}
}
