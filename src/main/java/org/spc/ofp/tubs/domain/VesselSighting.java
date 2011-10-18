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

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * @author Corey Cole <coreyc@spc.int>
 *
 */
@Entity
@Table(name = "[obsv].[gen1sightings]")
public class VesselSighting implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4898970618249175112L;

	@Id
	@Column(name = "sighting_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "form_id")
	private Integer formId;

	@Column(name = "sighting_dtime")
	private Date sightingDate;

	@Column(name = "lat")
	private String latitude;
	    
	@Column(name = "lon")
	private String longitude;

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

	@Column(name = "bearing_dir")
	@Min(0)
	@Max(360)
	private Integer bearing;

	@Column(name = "distance")
	private Double distance;

	@Column(name = "dist_unit", length = 2)
	private String distanceUnit;

	// TODO Add Action

	@Column(name = "photo_number", length = 10)
	private String photoNumber;

	@Lob
	@Column(name = "comments")
	@Size(max = 10000)
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

	public Integer getFormId() {
		return formId;
	}

	public void setFormId(Integer formId) {
		this.formId = formId;
	}

	public Date getSightingDate() {
		return sightingDate;
	}

	public void setSightingDate(Date sightingDate) {
		this.sightingDate = sightingDate;
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

	public Integer getBearing() {
		return bearing;
	}

	public void setBearing(Integer bearing) {
		this.bearing = bearing;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public String getDistanceUnit() {
		return distanceUnit;
	}

	public void setDistanceUnit(String distanceUnit) {
		this.distanceUnit = distanceUnit;
	}

	public String getPhotoNumber() {
		return photoNumber;
	}

	public void setPhotoNumber(String photoNumber) {
		this.photoNumber = photoNumber;
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
