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
package org.spc.ofp.tubs.domain.purseseine;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.spc.ofp.tubs.domain.AuditEntry;


/**
 * @author Corey Cole <coreyc@spc.int>
 *
 */
@Entity
@Table(name = "[obsv].[s_crew]")
public class Crew implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5066292241898222095L;

	@Id
    @Column(name = "s_crew_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "name", length = 50)
    @Size(max = 50)
    private String name;
    
    @Column(name = "country_code", length = 2)
    @Size(max = 2)
    private String countryCode;
    
    @Column(name = "exp_yr")
    private Integer yearsExperience;
    
    @Column(name = "exp_mo")
    private Integer monthsExperience;
    
    @Lob
    @Column(name = "comments")
    @Size(max = 10000)
    private String comments;
    
    @Embedded
    private AuditEntry auditEntry;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = PurseSeineTrip.class)
    @JoinColumn(name = "obstrip_id")
    private PurseSeineTrip trip;
    
    public String experience() {
        if (null == yearsExperience && null == monthsExperience) {
            return "N/A";
        }
        return String.format(
            "%d years %d months",
            null == yearsExperience ? 0 : yearsExperience.intValue(),
            null == monthsExperience ? 0 : monthsExperience.intValue());
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public Integer getYearsExperience() {
		return yearsExperience;
	}

	public void setYearsExperience(Integer yearsExperience) {
		this.yearsExperience = yearsExperience;
	}

	public Integer getMonthsExperience() {
		return monthsExperience;
	}

	public void setMonthsExperience(Integer monthsExperience) {
		this.monthsExperience = monthsExperience;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public PurseSeineTrip getTrip() {
		return trip;
	}

	public void setTrip(PurseSeineTrip trip) {
		this.trip = trip;
	}

	public AuditEntry getAuditEntry() {
		return auditEntry;
	}

	public void setAuditEntry(AuditEntry auditEntry) {
		this.auditEntry = auditEntry;
	}
}
