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

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.spc.ofp.tubs.domain.common.FishCondition;
import org.spc.ofp.tubs.domain.common.Tag;

/**
 * @author Corey Cole <coreyc@spc.int>
 *
 */
@Entity
@Table(name = "[obsv].[gen2special]")
public class SpecialSpeciesInteraction implements java.io.Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1392261909605325973L;

	@Id
    @Column(name = "ssp_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@Embedded
	@AttributeOverride(name = "timestamp", column = @Column(name = "landed_dtime"))
	private SpaceTimeLocation location;
    
    @Column(name = "eez_code")
    private String eezCode;
    
    // FIXME We should treat this as a biological sample moment
    // and use an embedded object that holds species data
    @Column(name = "sp_code")
    private String speciesCode;
    
    @Column(name = "sp_desc")
    private String speciesDescription;
    
    @JoinColumn(name = "landed_cond_code")
    private FishCondition landedCondition;
    
    @Lob
    @Size(max = 10000)
    @Column(name = "landed_cond_desc")
    private String landedConditionDescription;
    
    @Lob
    @Size(max = 10000)
    @Column(name = "landed_handling")
    private String landedHandling;
    
    @Column(name = "landed_len")
    private Double landedLength;
    
    @JoinColumn(name = "discard_cond_code")
    private FishCondition discardedCondition;
    
    @Lob
    @Size(max = 10000)
    @Column(name = "discard_cond_desc")
    private String discardedConditionDescription;
    
    // http://en.wikibooks.org/wiki/Java_Persistence/Embeddables
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "number", column = @Column(name = "tag_ret_no")),
        @AttributeOverride(name = "type", column = @Column(name = "tag_ret_type")),
        @AttributeOverride(name = "organization", column = @Column(name = "tag_ret_org"))
    })
    private Tag retrievedTag;
    
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "number", column = @Column(name = "tag_place_no")),
        @AttributeOverride(name = "type", column = @Column(name = "tag_place_type")),
        @AttributeOverride(name = "organization", column = @Column(name = "tag_place_org"))
    })
    private Tag placedTag;
    
    // TODO Add additional columns 
    
    @OneToMany(cascade = CascadeType.ALL, targetEntity = SpecialSpeciesInteractionDetails.class, mappedBy = "header")
    private List<SpecialSpeciesInteractionDetails> details;
    
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

	public SpaceTimeLocation getLocation() {
		return location;
	}

	public void setLocation(SpaceTimeLocation location) {
		this.location = location;
	}

	public String getEezCode() {
		return eezCode;
	}

	public void setEezCode(String eezCode) {
		this.eezCode = eezCode;
	}

	public String getSpeciesCode() {
		return speciesCode;
	}

	public void setSpeciesCode(String speciesCode) {
		this.speciesCode = speciesCode;
	}

	public String getSpeciesDescription() {
		return speciesDescription;
	}

	public void setSpeciesDescription(String speciesDescription) {
		this.speciesDescription = speciesDescription;
	}

	public FishCondition getLandedCondition() {
		return landedCondition;
	}

	public void setLandedCondition(FishCondition landedCondition) {
		this.landedCondition = landedCondition;
	}

	public String getLandedConditionDescription() {
		return landedConditionDescription;
	}

	public void setLandedConditionDescription(String landedConditionDescription) {
		this.landedConditionDescription = landedConditionDescription;
	}

	public String getLandedHandling() {
		return landedHandling;
	}

	public void setLandedHandling(String landedHandling) {
		this.landedHandling = landedHandling;
	}

	public Double getLandedLength() {
		return landedLength;
	}

	public void setLandedLength(Double landedLength) {
		this.landedLength = landedLength;
	}

	public FishCondition getDiscardedCondition() {
		return discardedCondition;
	}

	public void setDiscardedCondition(FishCondition discardedCondition) {
		this.discardedCondition = discardedCondition;
	}

	public String getDiscardedConditionDescription() {
		return discardedConditionDescription;
	}

	public void setDiscardedConditionDescription(
			String discardedConditionDescription) {
		this.discardedConditionDescription = discardedConditionDescription;
	}

	public Tag getRetrievedTag() {
		return retrievedTag;
	}

	public void setRetrievedTag(Tag retrievedTag) {
		this.retrievedTag = retrievedTag;
	}

	public Tag getPlacedTag() {
		return placedTag;
	}

	public void setPlacedTag(Tag placedTag) {
		this.placedTag = placedTag;
	}

	public List<SpecialSpeciesInteractionDetails> getDetails() {
		return details;
	}

	public void setDetails(List<SpecialSpeciesInteractionDetails> details) {
		this.details = details;
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
