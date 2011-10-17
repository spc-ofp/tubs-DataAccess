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

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.spc.ofp.tubs.domain.AuditEntry;

/**
 * @author Corey Cole <coreyc@spc.int>
 *
 */
@Entity
@Table(name = "[ref].[vessels]")
public class Vessel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4916191812943684821L;

	@Id
	@Column(name = "vessel_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "vessel_name", nullable = false, length = 50)
	private String name;

	@Column(name = "ircs", length = 16)
	private String ircs;

	@Column(name = "vty_code", nullable = false, length = 2)
	private String gearType;

	@NotNull
	@Column(name = "reg_country_code", nullable = false, length = 2)
	private String registeredCountryCode;

	// Optional values
	@Column(name = "ffa_id")
	private long ffaId;

	@Column(name = "reg_number", length = 20)
	private String registrationNumber;

	@Column(name = "incountry_code", length = 50)
	private String inCountryCode;

	@Column(name = "grt")
	private Double grossTonnage;

	@Column(name = "length")
	private Double length;

	@Column(name = "year_built")
	private Integer yearBuilt;

	@Column(name = "engine_power")
	private Double enginePower;

	@Column(name = "power_units", length = 2)
	private String powerUnits;

	@Column(name = "fuel_capacity")
	private Double fuelCapacity;

	@Column(name = "capacity_units", length = 2)
	private String capacityUnits;

	@Column(name = "hold_capacity")
	private Double holdCapacity;

	@Column(name = "speed", length = 50)
	private String speed;

	@Column(name = "vessel_notes", length = 250)
	private String notes;

	@Column(name = "vessel_curst_id")
	private long vesselCurstId;

	@Embedded
	private AuditEntry auditEntry;

	@Override
	public String toString() {
		return (null == name) ? "N/A" : name.trim();
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

	public String getIrcs() {
		return ircs;
	}

	public void setIrcs(String ircs) {
		this.ircs = ircs;
	}

	public String getGearType() {
		return gearType;
	}

	public void setGearType(String gearType) {
		this.gearType = gearType;
	}

	public String getRegisteredCountryCode() {
		return registeredCountryCode;
	}

	public void setRegisteredCountryCode(String registeredCountryCode) {
		this.registeredCountryCode = registeredCountryCode;
	}

	public long getFfaId() {
		return ffaId;
	}

	public void setFfaId(long ffaId) {
		this.ffaId = ffaId;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getInCountryCode() {
		return inCountryCode;
	}

	public void setInCountryCode(String inCountryCode) {
		this.inCountryCode = inCountryCode;
	}

	public Double getGrossTonnage() {
		return grossTonnage;
	}

	public void setGrossTonnage(Double grossTonnage) {
		this.grossTonnage = grossTonnage;
	}

	public Double getLength() {
		return length;
	}

	public void setLength(Double length) {
		this.length = length;
	}

	public Integer getYearBuilt() {
		return yearBuilt;
	}

	public void setYearBuilt(Integer yearBuilt) {
		this.yearBuilt = yearBuilt;
	}

	public Double getEnginePower() {
		return enginePower;
	}

	public void setEnginePower(Double enginePower) {
		this.enginePower = enginePower;
	}

	public String getPowerUnits() {
		return powerUnits;
	}

	public void setPowerUnits(String powerUnits) {
		this.powerUnits = powerUnits;
	}

	public Double getFuelCapacity() {
		return fuelCapacity;
	}

	public void setFuelCapacity(Double fuelCapacity) {
		this.fuelCapacity = fuelCapacity;
	}

	public String getCapacityUnits() {
		return capacityUnits;
	}

	public void setCapacityUnits(String capacityUnits) {
		this.capacityUnits = capacityUnits;
	}

	public Double getHoldCapacity() {
		return holdCapacity;
	}

	public void setHoldCapacity(Double holdCapacity) {
		this.holdCapacity = holdCapacity;
	}

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public long getVesselCurstId() {
		return vesselCurstId;
	}

	public void setVesselCurstId(long vesselCurstId) {
		this.vesselCurstId = vesselCurstId;
	}

	public AuditEntry getAuditEntry() {
		return auditEntry;
	}

	public void setAuditEntry(AuditEntry auditEntry) {
		this.auditEntry = auditEntry;
	}
}
