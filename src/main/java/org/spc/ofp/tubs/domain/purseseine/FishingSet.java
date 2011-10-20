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

import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.spc.ofp.tubs.domain.AuditEntry;

/**
 *
 * @author Corey Cole <coreyc@spc.int>
 */
@Entity
@Table(name = "[obsv].[s_set]")
public class FishingSet implements java.io.Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -3343551585726104093L;

	// TODO Add validator that ensures that Dates for all events
    // are in sequence (startTime < skiffOff < winchOn < ringUp < startOfBrail < endOfBrail < stopTime)
	
	// TODO Call out source form field.  In fact, do this for all entities backed by a form
	// TODO It would be an interesting experiment to generate entities directly from a form description language...
    
    @Id
    @Column(name = "s_set_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "set_number")
    private Integer setNumber; // Should be unique within a trip
    
    @Column(name = "vessellog_dtime")
    private Date startTime;
    
    @Column(name = "skiffoff_dtime")
    private Date skiffOff;
    
    @Column(name = "winchon_dtime")
    private Date winchOn;
    
    @Column(name = "ringup_dtime")
    private Date ringUp;
    
    @Column(name = "sbrail_dtime")
    private Date startOfBrail;
    
    @Column(name = "ebrail_dtime")
    private Date endOfBrail;
    
    @Column(name = "stop_dtime")
    private Date stopTime;
    
    /**
     * Onboard total before this set (obs)
     */
    @Column(name = "ld_onboard")
    private Double weightOnBoard;
    
    /**
     * Onboard total before this set (ves)
     */
    @Column(name = "ld_ves_onboard")
    private Double weightOnBoardFromLog;
    
    /**
     * Total tonnage retained this set (obs)
     */
    @Column(name = "ld_tonnage")
    private Double observedSetRetainedTonnage;
    
    /**
     * Total tonnage retained this set (ves)
     */
    @Column(name = "ld_ves_tonnage")
    private Double setRetainedTonnageFromLog;
    
    /**
     * Is this vessel tonnage only from this set?
     */
    @Column(name = "ld_fromthisset_ans", length = 1)
    private String vesselTonnageOnlyFromThisSet;
    
    /**
     * New onboard total (obs)
     * Should be the sum of 'weightOnBoard' and 'observedSetRetainedTonnage'
     */
    @Column(name = "ld_newonboard")
    private Double observedNewOnboard; // From observer
    
    /**
     * New onboard total (ves)
     * Should be the sum of 'weightOnBoardFromLog' and 'setRetainedTonnageFromLog'
     */
    @Column(name = "ld_ves_newonboard")
    private Double newOnboardFromLog; // From vessel log
    
    /**
     * Total tuna this set
     * Total catch minus other species
     */
    @Column(name = "mttuna_obs")
    private Double tonsOfTunaObserved;
    
    /**
     * From the field labeled 'Brail 1' in the
     * box titled "SUM OF ALL BRAILS"
     */
    @Column(name = "ld_brails")
    private Double sumOfBrail1; // 
    
    /**
     * From the field labeled 'Brail 2' in the
     * box titled "SUM OF ALL BRAILS"
     */
    @Column(name = "ld_brails2")
    private Double sumOfBrail2; //
    
    /**
     * From the 'YES/NO' row of the 'SKJ' column of the area titled
     * "TOTAL SKJ-YFT-BET"
     */
    @Column(name = "totskj_ans")
    private Boolean containsSkipjack;
    
    /**
     * From the 'approx. %' row of the 'SKJ' column of the area titled
     * "TOTAL SKJ-YFT-BET"
     */
    @Column(name = "perc_skj")
    private Integer skipjackPercentage;
    
    /**
     * From the 'OBS (mT)' row of the 'SKJ' column of the area titled
     * "TOTAL SKJ-YFT-BET"
     */
    @Column(name = "mtskj_obs")
    private Double tonsOfSkipjackObserved;
    
    @Column(name = "totyft_ans")
    private Boolean containsYellowfin; 
    
    @Column(name = "perc_yft")
    private Integer yellowfinPercentage;
    
    @Column(name = "mtyft_obs")
    private Double tonsOfYellowfinObserved;
    
    @Column(name = "totbet_ans")
    private Boolean containsBigeye;
    
    @Column(name = "perc_bet")
    private Integer bigeyePercentage;
    
    @Column(name = "mtbet_obs")
    private Double tonsOfBigeyeObserved;
    
    // Not sure where on the form this comes from
    @Column(name = "totyftbet_ans")
    private Boolean containsLargeTuna;
    
    // Not sure where on the form this comes from
    @Column(name = "perc_yftbet")
    private Integer percentageOfLargeTuna;
    
    // Not sure where on the form this comes from
    @Column(name = "mtyftbet_obs")
    private Double tonsOfYellowfinAndBigEyeObserved;
    
    // Again, doesn't look like it comes from the paper form
    @Column(name = "tottun_ans")
    private Boolean totalTunaAnswer; // FIXME
    
    // Again, doesn't look like it comes from the paper form
    @Column(name = "perc_tun")
    private Integer percentageOfTuna; // FIXME
    
    // Again, doesn't look like it comes from the paper form
    @Column(name = "mttun_obs")
    private Double tonsOfTunaObserved2; // FIXME
    
    /**
     * From the field labeled 'SPECIES' in the box titled
     * "LARGE TUNA IN CATCH"
     */
    @Column(name = "large_sp")
    private String largeSpecies;
    
    /**
     * From the field labeled '% of wgt. of all tuna'
     * in the box titled "LARGE TUNA IN CATCH"
     */
    @Column(name = "large_perc")
    private Integer largeSpeciesPercentage;
    
    /**
     * From the field labeled 'No.'
     * in the box titled "LARGE TUNA IN CATCH"
     */
    @Column(name = "large_number")
    private Integer largeSpeciesCount;
    
    /**
     * From the field labeled 'TOTAL CATCH (all species, including discards)'
     */
    @Column(name = "total_catch")
    private Double totalCatch;
    
    /**
     * From the field labeled 'TAGS How many tags were recovered'
     */
    @Column(name = "b_nbtags")
    private Integer recoveredTagCount;
    
    // These columns appear in the database but don't appear to
    // be wired up in the user interface
    /*
	  ,[b_discards]
      ,[b_escape]
      ,[b_escpercent]
      ,[b_nbspecies]
      ,[b_school]
      ,[b_tagno]
      ,[b_sp_code]
      ,[b_len]
      ,[b_weight]
      ,[b_sex]
      ,[perc_large_yft]
      ,[perc_large_bet]
      ,[perc_large_yb]
      ,[nb_large_yft]
      ,[nb_large_bet]
      ,[nb_large_yb]
     */
       
    @Lob
    @Column(name = "comments")
    @Size(max = 10000)
    private String comments;
    
    @Embedded
    private AuditEntry auditEntry;
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Activity.class)
    @JoinColumn(name = "s_daylog_id")
    private Activity logEvent; // Pointer back to daily event log that contains this set
    
    // Child list of SetCatch objects
    @OneToMany(cascade = CascadeType.ALL, targetEntity = SetCatch.class, mappedBy = "fishingSet")
    private List<SetCatch> catchList;
    
    // Child list of LengthSamplingHeader objects
    @OneToMany(cascade = CascadeType.ALL, targetEntity = LengthSamplingHeader.class, mappedBy = "fishingSet")
    private List<LengthSamplingHeader> lengthSamples;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Integer getSetNumber() {
		return setNumber;
	}

	public void setSetNumber(final Integer setNumber) {
		this.setNumber = setNumber;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(final Date startTime) {
		this.startTime = startTime;
	}

	public Date getSkiffOff() {
		return skiffOff;
	}

	public void setSkiffOff(final Date skiffOff) {
		this.skiffOff = skiffOff;
	}

	public Date getWinchOn() {
		return winchOn;
	}

	public void setWinchOn(Date winchOn) {
		this.winchOn = winchOn;
	}

	public Date getRingUp() {
		return ringUp;
	}

	public void setRingUp(Date ringUp) {
		this.ringUp = ringUp;
	}

	public Date getStartOfBrail() {
		return startOfBrail;
	}

	public void setStartOfBrail(Date startOfBrail) {
		this.startOfBrail = startOfBrail;
	}

	public Date getEndOfBrail() {
		return endOfBrail;
	}

	public void setEndOfBrail(Date endOfBrail) {
		this.endOfBrail = endOfBrail;
	}

	public Date getStopTime() {
		return stopTime;
	}

	public void setStopTime(Date stopTime) {
		this.stopTime = stopTime;
	}

	public Double getWeightOnBoard() {
		return weightOnBoard;
	}

	public void setWeightOnBoard(Double weightOnBoard) {
		this.weightOnBoard = weightOnBoard;
	}

	public Double getWeightOnBoardFromLog() {
		return weightOnBoardFromLog;
	}

	public void setWeightOnBoardFromLog(Double weightOnBoardFromLog) {
		this.weightOnBoardFromLog = weightOnBoardFromLog;
	}

	public Double getObservedNewOnboard() {
		return observedNewOnboard;
	}

	public void setObservedNewOnboard(Double observedNewOnboard) {
		this.observedNewOnboard = observedNewOnboard;
	}

	public Double getNewOnboardFromLog() {
		return newOnboardFromLog;
	}

	public void setNewOnboardFromLog(Double newOnboardFromLog) {
		this.newOnboardFromLog = newOnboardFromLog;
	}

	public Double getTonsOfTunaObserved() {
		return tonsOfTunaObserved;
	}

	public void setTonsOfTunaObserved(Double tonsOfTunaObserved) {
		this.tonsOfTunaObserved = tonsOfTunaObserved;
	}

	public Boolean getContainsSkipjack() {
		return containsSkipjack;
	}

	public void setContainsSkipjack(Boolean containsSkipjack) {
		this.containsSkipjack = containsSkipjack;
	}

	public Integer getSkipjackPercentage() {
		return skipjackPercentage;
	}

	public void setSkipjackPercentage(Integer skipjackPercentage) {
		this.skipjackPercentage = skipjackPercentage;
	}

	public Double getTonsOfSkipjackObserved() {
		return tonsOfSkipjackObserved;
	}

	public void setTonsOfSkipjackObserved(Double tonsOfSkipjackObserved) {
		this.tonsOfSkipjackObserved = tonsOfSkipjackObserved;
	}

	public Boolean getContainsYellowfin() {
		return containsYellowfin;
	}

	public void setContainsYellowfin(Boolean containsYellowfin) {
		this.containsYellowfin = containsYellowfin;
	}

	public Integer getYellowfinPercentage() {
		return yellowfinPercentage;
	}

	public void setYellowfinPercentage(Integer yellowfinPercentage) {
		this.yellowfinPercentage = yellowfinPercentage;
	}

	public Double getTonsOfYellowfinObserved() {
		return tonsOfYellowfinObserved;
	}

	public void setTonsOfYellowfinObserved(Double tonsOfYellowfinObserved) {
		this.tonsOfYellowfinObserved = tonsOfYellowfinObserved;
	}

	public Boolean getContainsBigeye() {
		return containsBigeye;
	}

	public void setContainsBigeye(Boolean containsBigeye) {
		this.containsBigeye = containsBigeye;
	}

	public Integer getBigeyePercentage() {
		return bigeyePercentage;
	}

	public void setBigeyePercentage(Integer bigeyePercentage) {
		this.bigeyePercentage = bigeyePercentage;
	}

	public Double getTonsOfBigeyeObserved() {
		return tonsOfBigeyeObserved;
	}

	public void setTonsOfBigeyeObserved(Double tonsOfBigeyeObserved) {
		this.tonsOfBigeyeObserved = tonsOfBigeyeObserved;
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

	public Activity getLogEvent() {
		return logEvent;
	}

	public void setLogEvent(Activity logEvent) {
		this.logEvent = logEvent;
	}

	public List<SetCatch> getCatchList() {
		return catchList;
	}

	public void setCatchList(List<SetCatch> catchList) {
		if (null != catchList) {
			for (final SetCatch sc : catchList) {
				sc.setFishingSet(this);
			}
		}
		this.catchList = catchList;
	}

	public Double getObservedSetRetainedTonnage() {
		return observedSetRetainedTonnage;
	}

	public void setObservedSetRetainedTonnage(Double observedSetRetainedTonnage) {
		this.observedSetRetainedTonnage = observedSetRetainedTonnage;
	}

	public Double getSetRetainedTonnageFromLog() {
		return setRetainedTonnageFromLog;
	}

	public void setSetRetainedTonnageFromLog(Double setRetainedTonnageFromLog) {
		this.setRetainedTonnageFromLog = setRetainedTonnageFromLog;
	}

	public Boolean getVesselTonnageOnlyFromThisSet() {
		return "Y".equalsIgnoreCase(vesselTonnageOnlyFromThisSet);
	}

	public void setVesselTonnageOnlyFromThisSet(Boolean value) {
		this.vesselTonnageOnlyFromThisSet = 
		    null == value ? null :
		    value ? "Y" : "N";
	}

	public Double getSumOfBrail1() {
		return sumOfBrail1;
	}

	public void setSumOfBrail1(Double sumOfBrail1) {
		this.sumOfBrail1 = sumOfBrail1;
	}

	public Double getSumOfBrail2() {
		return sumOfBrail2;
	}

	public void setSumOfBrail2(Double sumOfBrail2) {
		this.sumOfBrail2 = sumOfBrail2;
	}

	public Boolean getContainsLargeTuna() {
		return containsLargeTuna;
	}

	public void setContainsLargeTuna(Boolean containsLargeTuna) {
		this.containsLargeTuna = containsLargeTuna;
	}

	public Integer getPercentageOfLargeTuna() {
		return percentageOfLargeTuna;
	}

	public void setPercentageOfLargeTuna(Integer percentageOfLargeTuna) {
		this.percentageOfLargeTuna = percentageOfLargeTuna;
	}

	public Double getTonsOfYellowfinAndBigEyeObserved() {
		return tonsOfYellowfinAndBigEyeObserved;
	}

	public void setTonsOfYellowfinAndBigEyeObserved(
			Double tonsOfYellowfinAndBigEyeObserved) {
		this.tonsOfYellowfinAndBigEyeObserved = tonsOfYellowfinAndBigEyeObserved;
	}

	public Boolean getTotalTunaAnswer() {
		return totalTunaAnswer;
	}

	public void setTotalTunaAnswer(Boolean totalTunaAnswer) {
		this.totalTunaAnswer = totalTunaAnswer;
	}

	public Integer getPercentageOfTuna() {
		return percentageOfTuna;
	}

	public void setPercentageOfTuna(Integer percentageOfTuna) {
		this.percentageOfTuna = percentageOfTuna;
	}

	public Double getTonsOfTunaObserved2() {
		return tonsOfTunaObserved2;
	}

	public void setTonsOfTunaObserved2(Double tonsOfTunaObserved2) {
		this.tonsOfTunaObserved2 = tonsOfTunaObserved2;
	}

	public String getLargeSpecies() {
		return largeSpecies;
	}

	public void setLargeSpecies(String largeSpecies) {
		this.largeSpecies = largeSpecies;
	}

	public Integer getLargeSpeciesPercentage() {
		return largeSpeciesPercentage;
	}

	public void setLargeSpeciesPercentage(Integer largeSpeciesPercentage) {
		this.largeSpeciesPercentage = largeSpeciesPercentage;
	}

	public Integer getLargeSpeciesCount() {
		return largeSpeciesCount;
	}

	public void setLargeSpeciesCount(Integer largeSpeciesCount) {
		this.largeSpeciesCount = largeSpeciesCount;
	}

	public Double getTotalCatch() {
		return totalCatch;
	}

	public void setTotalCatch(Double totalCatch) {
		this.totalCatch = totalCatch;
	}

	public Integer getRecoveredTagCount() {
		return recoveredTagCount;
	}

	public void setRecoveredTagCount(Integer recoveredTagCount) {
		this.recoveredTagCount = recoveredTagCount;
	}

	public List<LengthSamplingHeader> getLengthSamples() {
		return lengthSamples;
	}

	public void setLengthSamples(List<LengthSamplingHeader> lengthSamples) {
		if (null != lengthSamples) {
			for (final LengthSamplingHeader lsh : lengthSamples) {
				lsh.setFishingSet(this);
			}
		}
		this.lengthSamples = lengthSamples;
	}
}
