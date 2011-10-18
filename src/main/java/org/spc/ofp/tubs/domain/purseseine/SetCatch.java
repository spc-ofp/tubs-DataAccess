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
package org.spc.ofp.tubs.domain.purseseine;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.spc.ofp.tubs.domain.AuditEntry;
import org.spc.ofp.tubs.domain.common.Fate;
import org.spc.ofp.tubs.domain.common.FishCondition;

/**
 *
 * @author Corey Cole <coreyc@spc.int>
 */
@Entity
@Table(name = "[obsv].[s_setcatch]")
public class SetCatch implements java.io.Serializable, Comparable<SetCatch> {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 498482823515992802L;

	@Id
    @Column(name = "s_setcatch_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "sp_code")
    private String speciesCode;
    
    @Column(name = "large_fish")
    private Boolean containsLargeFish;
    
    @OneToOne
    @JoinColumn(name = "fate_code")
    private Fate fate;
    
    @OneToOne
    @JoinColumn(name = "cond_code")
    private FishCondition condition;
    
    // TODO What's a reasonable maximum value for weight?
    
    @Column(name = "obs_mt")
    private Double observerWeight; // Recorded by observer
    
    @Column(name = "obs_n")
    private Integer observerCount; // Recorded by observer
    
    @Column(name = "ves_mt")
    private Double vesselWeight; // From vessel log
        
    @Column(name = "ves_n")
    private Integer countFromLog;
    
    @Lob
    @Column(name = "comments")
    @Size(max = 10000)
    private String comments;
    
    public int compareTo(SetCatch other) {
        if (null == other) { return 1; }
        if (this == other) { return 0; }
        final Double ccw = 
            (null == this.observerWeight) ? 
                Double.valueOf(0.0d) :
                this.observerWeight;
        return ccw.compareTo(other.observerWeight);
    }
    
    // FIXME
    // These columns don't appear to be wired to the user interface
    /*
    @Column(name = "sp_c_spcomp")
    private Double sp_c_spcomp;
    
    @Column(name = "sp_w_low")
    private Double sp_w_low;
    
    @Column(name = "sp_w_high")
    private Double sp_w_high;
    
    @Column(name = "avg_len")
    private Integer avg_len;
    
    @Column(name = "sp_w_est")
    private Double sp_w_est;
    
    @Column(name = "sp_w_id")
    private Integer sp_w_id;
    
    @Column(name = "sp_c_est")
    private Double sp_c_est;
    
    @Column(name = "sp_c_id")
    private Integer sp_c_id;
    
    @Column(name = "sp_n_est")
    private Integer sp_n_est;
    */
    
    @Embedded
    private AuditEntry auditEntry;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = FishingSet.class)
    @JoinColumn(name = "s_set_id")
    private FishingSet fishingSet;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSpeciesCode() {
		return speciesCode;
	}

	public void setSpeciesCode(String speciesCode) {
		this.speciesCode = speciesCode;
	}

	public Boolean getContainsLargeFish() {
		return containsLargeFish;
	}

	public void setContainsLargeFish(Boolean containsLargeFish) {
		this.containsLargeFish = containsLargeFish;
	}

	public Fate getFate() {
		return fate;
	}

	public void setFate(Fate fate) {
		this.fate = fate;
	}

	public FishCondition getCondition() {
		return condition;
	}

	public void setCondition(FishCondition condition) {
		this.condition = condition;
	}

	public Double getObserverWeight() {
		return observerWeight;
	}

	public void setObserverWeight(Double observerWeight) {
		this.observerWeight = observerWeight;
	}

	public Double getVesselWeight() {
		return vesselWeight;
	}

	public void setVesselWeight(Double vesselWeight) {
		this.vesselWeight = vesselWeight;
	}

	public Integer getObserverCount() {
		return observerCount;
	}

	public void setObserverCount(Integer observerCount) {
		this.observerCount = observerCount;
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

	public Integer getCountFromLog() {
		return countFromLog;
	}

	public void setCountFromLog(Integer countFromLog) {
		this.countFromLog = countFromLog;
	}

	public FishingSet getFishingSet() {
		return fishingSet;
	}

	public void setFishingSet(FishingSet fishingSet) {
		this.fishingSet = fishingSet;
	} 
}
