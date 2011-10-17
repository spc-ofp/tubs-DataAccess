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

import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.spc.ofp.tubs.domain.common.SeaState;

/**
 * @author Corey Cole <coreyc@spc.int>
 *
 */
@Entity
@Table(name = "[obsv].[gen6poll]")
public class PollutionReportHeader implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1629220806946887281L;

	@Id
    @Column(name = "pollution_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@Column(name = "lat")
	private String latitude;
    
    @Column(name = "lon")
    private String longitude;
    
    @Column(name = "inc_dtime")
    private Date timestamp;
    
    @Column(name = "eez_code")
    private String eezCode;
    
    @Column(name = "vessel_id")
    private Integer vesselId; // For use when the sighted vessel already exists in DB
    
    @Column(name = "vessel_name", length = 50)
    private String vesselName;
    
    @Column(name = "ircs", length = 16)
    private String ircs;
    
    @Column(name = "form_id")
    private Integer formId;
    
    @Column(name = "wind_dir")
    @Min(0)
    @Max(360)
    private Integer windDirection;
    
    @Column(name = "wind_kts")
    private Integer windSpeed;
    
    @OneToOne
    @JoinColumn(name = "sea_code")
    private SeaState seaState;
	
	
	@Lob
    @Column(name = "comments")
    @Size(max = 10000)
	private String comments;
    
    @Embedded
    private AuditEntry auditEntry;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Trip.class)
    @JoinColumn(name = "obstrip_id")
    private Trip trip;
	
	// Might be better to use an ElementCollection?
	// http://en.wikibooks.org/wiki/Java_Persistence/ElementCollection
	@OneToMany(cascade = CascadeType.ALL, targetEntity = PollutionReportDetails.class, mappedBy = "header")
    private List<PollutionReportDetails> details;

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

	public Integer getFormId() {
		return formId;
	}

	public void setFormId(Integer formId) {
		this.formId = formId;
	}

	public Integer getWindDirection() {
		return windDirection;
	}

	public void setWindDirection(Integer windDirection) {
		this.windDirection = windDirection;
	}

	public Integer getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(Integer windSpeed) {
		this.windSpeed = windSpeed;
	}

	public SeaState getSeaState() {
		return seaState;
	}

	public void setSeaState(SeaState seaState) {
		this.seaState = seaState;
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

	public List<PollutionReportDetails> getDetails() {
		return details;
	}

	public void setDetails(List<PollutionReportDetails> details) {
		this.details = details;
	}
}
