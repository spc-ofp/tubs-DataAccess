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
import org.spc.ofp.tubs.domain.Trip;

/**
 *
 * @author Corey Cole <coreyc@spc.int>
 */
@Entity
@Table(name = "obsv.s_day")
public class Day implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4785637190673643943L;

	@Id
    @Column(name = "s_day_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@Column(name = "form_id")
	private Integer formId; // This is null in the dataset
    
    @Column(name = "start_dtime")
    private Date startOfDay;
    
    @Column(name = "utc_start_dtime")
    private Date utcStartOfDay;
    
    @Column(name = "sch_fish_n")
    private Integer freeSchoolCount;
    
    @Column(name = "fad_fish_n")
    private Integer anchoredObjectsWithSchool;
    
    @Column(name = "fad_nofish_n")
    private Integer anchoredObjectsWithoutSchool;
    
    @Column(name = "log_fish_n")
    private Integer floatingObjectsWithSchool;
    
    @Column(name = "log_nofish_n")
    private Integer floatingObjectsWithoutSchool;
    
    @Column(name = "gen3today_ans", length = 1)
    private String gen3Flag;
    
    @Column(name = "diarypage", length = 50)
    @Size(max = 50)
    private String diaryPage;
    
    @Embedded
    private AuditEntry auditEntry;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Trip.class)
    @JoinColumn(name = "obstrip_id")
    private Trip trip;
    
    @OneToMany(cascade = CascadeType.ALL, targetEntity = Activity.class, mappedBy = "day")
    private List<Activity> activities;
    
    private static String schoolFormat(final Integer with, final Integer without) {
        return String.format(
            "%d with / %d without",
            null == with ? 0 : with.intValue(),
            null == without ? 0 : without.intValue());
    }
    
    public String anchoredObjects() {
        return schoolFormat(anchoredObjectsWithSchool, anchoredObjectsWithoutSchool);
    }
    
    public String floatingObjects() {
        return schoolFormat(floatingObjectsWithSchool, floatingObjectsWithoutSchool);
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getStartOfDay() {
		return startOfDay;
	}

	public void setStartOfDay(final Date timestamp) {
		this.startOfDay = timestamp;
	}
	
	public Date getUtcStartOfDay() {
		return utcStartOfDay;
	}
	
	public void setUtcStartOfDay(final Date value) {
		this.utcStartOfDay = value;
	}

	public Integer getFreeSchoolCount() {
		return freeSchoolCount;
	}

	public void setFreeSchoolCount(Integer freeSchoolCount) {
		this.freeSchoolCount = freeSchoolCount;
	}

	public Integer getAnchoredObjectsWithSchool() {
		return anchoredObjectsWithSchool;
	}

	public void setAnchoredObjectsWithSchool(Integer anchoredObjectsWithSchool) {
		this.anchoredObjectsWithSchool = anchoredObjectsWithSchool;
	}

	public Integer getAnchoredObjectsWithoutSchool() {
		return anchoredObjectsWithoutSchool;
	}

	public void setAnchoredObjectsWithoutSchool(Integer anchoredObjectsWithoutSchool) {
		this.anchoredObjectsWithoutSchool = anchoredObjectsWithoutSchool;
	}

	public Integer getFloatingObjectsWithSchool() {
		return floatingObjectsWithSchool;
	}

	public void setFloatingObjectsWithSchool(Integer floatingObjectsWithSchool) {
		this.floatingObjectsWithSchool = floatingObjectsWithSchool;
	}

	public Integer getFloatingObjectsWithoutSchool() {
		return floatingObjectsWithoutSchool;
	}

	public void setFloatingObjectsWithoutSchool(Integer floatingObjectsWithoutSchool) {
		this.floatingObjectsWithoutSchool = floatingObjectsWithoutSchool;
	}

	public String getGen3Flag() {
		return gen3Flag;
	}

	public void setGen3Flag(String gen3Flag) {
		this.gen3Flag = gen3Flag;
	}

	public String getDiaryPage() {
		return diaryPage;
	}

	public void setDiaryPage(String diaryPage) {
		this.diaryPage = diaryPage;
	}

	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	public AuditEntry getAuditEntry() {
		return auditEntry;
	}

	public void setAuditEntry(AuditEntry auditEntry) {
		this.auditEntry = auditEntry;
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

	public Integer getFormId() {
		return formId;
	}

	public void setFormId(Integer formId) {
		this.formId = formId;
	}
}
