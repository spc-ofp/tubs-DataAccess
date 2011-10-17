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
 *
 * @author Corey Cole <coreyc@spc.int>
 */
@Entity
@Table(name = "[obsv].[s_vess_attrib]")
public class VesselAttribute implements java.io.Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -6614203045980713039L;

	// TODO s_vess_attrib needs a distinct key with a FK to obsv.trip
    // and a uniqueness constraint on same
    @Id
    @Column(name = "obstrip_id")
    private long id;
    
    @Column(name = "speedboats_n")
    private Integer speedboatCount;
    
    @Column(name = "tow_n")
    private Integer towboatCount;
    
    @Column(name = "auxboats_n")
    private Integer auxiliaryCount;
    
    @Column(name = "light_n")
    private Integer lightCount;
    
    @Column(name = "tenderboats_yn")
    private Boolean hasTender;
    
    @Column(name = "skiff_make", length = 20)
    @Size(max = 20)
    private String skiffMake;
    
    @Column(name = "skiff_hp")
    private Integer skiffHorsepower;
    
    @Column(name = "cruise_speed")
    private Double cruiseSpeed;
    
    @Column(name = "heli_make", length = 15)
    @Size(max = 15)
    private String helicopterMake;
    
    @Column(name = "heli_model", length = 15)
    @Size(max = 15)
    private String helicopterModel;
    
    @Column(name = "heli_reg_no", length = 15)
    @Size(max = 15)
    private String helicopterRegistrationNumber;
    
    @Column(name = "heli_range")
    private Integer helicopterRange;
    
    @Column(name = "heli_colour", length = 30)
    @Size(max = 30)
    private String helicopterColor;
    
    @Column(name = "heli_services_n")
    private Integer boatsServicedByHelicopter;
    
    @Embedded
    private AuditEntry auditEntry;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Integer getSpeedboatCount() {
		return speedboatCount;
	}

	public void setSpeedboatCount(Integer speedboatCount) {
		this.speedboatCount = speedboatCount;
	}

	public Integer getTowboatCount() {
		return towboatCount;
	}

	public void setTowboatCount(Integer towboatCount) {
		this.towboatCount = towboatCount;
	}

	public Integer getAuxiliaryCount() {
		return auxiliaryCount;
	}

	public void setAuxiliaryCount(Integer auxiliaryCount) {
		this.auxiliaryCount = auxiliaryCount;
	}

	public Integer getLightCount() {
		return lightCount;
	}

	public void setLightCount(Integer lightCount) {
		this.lightCount = lightCount;
	}

	public Boolean getHasTender() {
		return hasTender;
	}

	public void setHasTender(Boolean hasTender) {
		this.hasTender = hasTender;
	}

	public String getSkiffMake() {
		return skiffMake;
	}

	public void setSkiffMake(String skiffMake) {
		this.skiffMake = skiffMake;
	}

	public Integer getSkiffHorsepower() {
		return skiffHorsepower;
	}

	public void setSkiffHorsepower(Integer skiffHorsepower) {
		this.skiffHorsepower = skiffHorsepower;
	}

	public Double getCruiseSpeed() {
		return cruiseSpeed;
	}

	public void setCruiseSpeed(Double cruiseSpeed) {
		this.cruiseSpeed = cruiseSpeed;
	}

	public String getHelicopterMake() {
		return helicopterMake;
	}

	public void setHelicopterMake(String helicopterMake) {
		this.helicopterMake = helicopterMake;
	}

	public String getHelicopterModel() {
		return helicopterModel;
	}

	public void setHelicopterModel(String helicopterModel) {
		this.helicopterModel = helicopterModel;
	}

	public String getHelicopterRegistrationNumber() {
		return helicopterRegistrationNumber;
	}

	public void setHelicopterRegistrationNumber(String helicopterRegistrationNumber) {
		this.helicopterRegistrationNumber = helicopterRegistrationNumber;
	}

	public Integer getHelicopterRange() {
		return helicopterRange;
	}

	public void setHelicopterRange(Integer helicopterRange) {
		this.helicopterRange = helicopterRange;
	}

	public String getHelicopterColor() {
		return helicopterColor;
	}

	public void setHelicopterColor(String helicopterColor) {
		this.helicopterColor = helicopterColor;
	}

	public Integer getBoatsServicedByHelicopter() {
		return boatsServicedByHelicopter;
	}

	public void setBoatsServicedByHelicopter(Integer boatsServicedByHelicopter) {
		this.boatsServicedByHelicopter = boatsServicedByHelicopter;
	}

	public AuditEntry getAuditEntry() {
		return auditEntry;
	}

	public void setAuditEntry(AuditEntry auditEntry) {
		this.auditEntry = auditEntry;
	}
}
