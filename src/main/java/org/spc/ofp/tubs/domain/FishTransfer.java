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
package org.spc.ofp.tubs.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * @author Corey Cole <coreyc@spc.int>
 *
 */
@Entity
@Table(name = "[obsv].[gen1fishtransfer]")
public class FishTransfer implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4431314642729774387L;

	@Id
    @Column(name = "fish_tran_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "lat")
    private String latitude;
    
    @Column(name = "lon")
    private String longitude;
    
    @Column(name = "fish_tran_dtime")
    private Date timestamp;
    
    @Column(name = "eez_code")
    private String eezCode;
    
    @Column(name = "vessel_id")
    private Integer vesselId; // For use when the sighted vessel already exists in DB
    
    @Column(name = "vessel_name", length = 50)
    private String vesselName;
    
    @Column(name = "ircs", length = 16)
    private String ircs;
    
    @Column(name = "reg_country_code", length = 2)
    private String registeredCountryCode;
    
    // TODO Add VesselType
    
    @Column(name = "skj_c")
    private Double skipjackTransferred;
    
    @Column(name = "yft_c")
    private Double yellowfinTransferred;
    
    @Column(name = "bet_c")
    private Double bigeyeTransferred;
    
    @Column(name = "mix_c")
    private Double miscTransferred;
    
    // TODO Action Code
    
    @Lob
    @Size(max = 10000)
    @Column(name = "comments")
    private String comments;
    
    @Embedded
    private AuditEntry auditEntry;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Trip.class)
    @JoinColumn(name = "obstrip_id")
    private Trip trip;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getEezCode() {
		return eezCode;
	}

	public void setEezCode(String eezCode) {
		this.eezCode = eezCode;
	}

	public Integer getVesselId() {
		return vesselId;
	}

	public void setVesselId(Integer vesselId) {
		this.vesselId = vesselId;
	}

	public String getVesselName() {
		return vesselName;
	}

	public void setVesselName(String vesselName) {
		this.vesselName = vesselName;
	}

	public String getIrcs() {
		return ircs;
	}

	public void setIrcs(String ircs) {
		this.ircs = ircs;
	}

	public String getRegisteredCountryCode() {
		return registeredCountryCode;
	}

	public void setRegisteredCountryCode(String registeredCountryCode) {
		this.registeredCountryCode = registeredCountryCode;
	}

	public Double getSkipjackTransferred() {
		return skipjackTransferred;
	}

	public void setSkipjackTransferred(Double skipjackTransferred) {
		this.skipjackTransferred = skipjackTransferred;
	}

	public Double getYellowfinTransferred() {
		return yellowfinTransferred;
	}

	public void setYellowfinTransferred(Double yellowfinTransferred) {
		this.yellowfinTransferred = yellowfinTransferred;
	}

	public Double getBigeyeTransferred() {
		return bigeyeTransferred;
	}

	public void setBigeyeTransferred(Double bigeyeTransferred) {
		this.bigeyeTransferred = bigeyeTransferred;
	}

	public Double getMiscTransferred() {
		return miscTransferred;
	}

	public void setMiscTransferred(Double miscTransferred) {
		this.miscTransferred = miscTransferred;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public AuditEntry getAuditEntry() {
		return auditEntry;
	}

	public void setAuditEntry(AuditEntry auditEntry) {
		this.auditEntry = auditEntry;
	}

	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}   
}
