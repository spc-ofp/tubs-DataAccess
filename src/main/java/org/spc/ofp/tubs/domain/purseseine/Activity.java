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

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.*;

//import org.hibernate.annotations.Type;
import org.spc.ofp.tubs.constraints.MinimumDateValue;
import org.spc.ofp.tubs.domain.AuditEntry;
import org.spc.ofp.tubs.domain.common.ReferenceId;
import org.spc.ofp.tubs.domain.common.SeaState;

import com.google.common.base.Strings;
//import com.vividsolutions.jts.geom.Point;

/**
 *
 * @author Corey Cole <coreyc@spc.int>
 */
@Entity
@Table(name = "obsv.s_daylog")
@NamedNativeQuery(
    name = Activity.FIND_BY_TRIP,
    query = 
        "SELECT " +
        " A.* " +
        "FROM " +
        " obsv.s_daylog A, " +
        " obsv.s_day D " +
        "WHERE " +
        " A.s_day_id = D.s_day_id " +
        " AND D.obstrip_id = ?",
    resultClass = Activity.class
)
public class Activity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -203501038597187196L;

	public static final String FIND_BY_TRIP = "Activity.FindByTrip";
    
    @Id
    @Column(name = "s_daylog_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "act_dtime")
    @Past
    private Date localTime;
    
    @Column(name = "utc_act_dtime")
    @Past
    private Date utcTime;
    
    @Column(name = "lat")
    @Pattern(regexp = "[0-9]{4}\\.[0-9]{3}[NS]")
    private String latitude;
    
    @Column(name = "lon")
    @Pattern(regexp = "[0-1][0-9]{4}\\.[0-9]{3}[EW]")
    private String longitude;
    
    /*
    // TODO Update schema to include GIS functionality
    @Column(name = "location")
    @Type(type = "org.hibernatespatial.GeometryUserType")
    private Point location;
    */
    
    @Column(name = "eez_code")
    private String eezCode;
    
    // FIXME This doesn't appear to be wired to current UI
    @Column(name = "fish_days")
    private BigDecimal fishingDays;
    
    @Column(name = "wind_dir")
    @Min(0)
    @Max(360)
    private Integer windDirection;
    
    @Column(name = "wind_kts")
    private Integer windSpeed;
    
    @OneToOne
    @JoinColumn(name = "sea_code")
    private SeaState seaState;
    
    @OneToOne
    @JoinColumn(name = "s_activ_id")
    private ReferenceId activityType;
    
    @OneToOne
    @JoinColumn(name = "schas_id")
    private ReferenceId associationType;
    
    @OneToOne
    @JoinColumn(name = "deton_id")
    private ReferenceId detectionMethod;
    
    @Column(name = "beacon")
    private String beacon;
    
    @Column(name = "payao")
    private String payao;
    
    @Lob
    @Column(name = "comments")
    @Size(max = 10000)
    private String comments;
    
    @Embedded
    private AuditEntry auditEntry;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Day.class)
    @JoinColumn(name = "s_day_id")
    private Day day; // Pointer back to containing day
    
    @OneToOne(cascade = CascadeType.ALL, targetEntity = FishingSet.class, mappedBy = "logEvent")
    private FishingSet fishingSet;
    
    @AssertTrue(message = "invalid local activity time (before January 1st, 1981)")
    public boolean isValidLocalDate() {
    	return MinimumDateValue.isAfterMinimum(this.localTime);
    }
    
    @AssertTrue(message = "invalid UTC activity time (before January 1st, 1981)")
    public boolean isValidUtcDate() {
    	return MinimumDateValue.isAfterMinimum(this.utcTime);
    }
    
    public boolean hasPosition() {
        return
           !Strings.isNullOrEmpty(latitude) &&
           !Strings.isNullOrEmpty(latitude.trim()) &&
           !Strings.isNullOrEmpty(longitude) &&
           !Strings.isNullOrEmpty(latitude.trim());
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getLocalTime() {
		return localTime;
	}

	public void setLocalTime(Date localTime) {
		this.localTime = localTime;
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

	public ReferenceId getActivityType() {
		return activityType;
	}

	public void setActivityType(ReferenceId activityType) {
		this.activityType = activityType;
	}

	public ReferenceId getAssociationType() {
		return associationType;
	}

	public void setAssociationType(ReferenceId associationType) {
		this.associationType = associationType;
	}

	public ReferenceId getDetectionMethod() {
		return detectionMethod;
	}

	public void setDetectionMethod(ReferenceId detectionMethod) {
		this.detectionMethod = detectionMethod;
	}

	public String getBeacon() {
		return beacon;
	}

	public void setBeacon(String beacon) {
		this.beacon = beacon;
	}

	public String getPayao() {
		return payao;
	}

	public void setPayao(String payao) {
		this.payao = payao;
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

	public Day getDay() {
		return day;
	}

	public void setDay(Day day) {
		this.day = day;
	}

	public BigDecimal getFishingDays() {
		return fishingDays;
	}

	public void setFishingDays(BigDecimal fishingDays) {
		this.fishingDays = fishingDays;
	}

	public FishingSet getFishingSet() {
		return fishingSet;
	}

	public void setFishingSet(FishingSet fishingSet) {
		this.fishingSet = fishingSet;
	}

	public Date getUtcTime() {
		return utcTime;
	}

	public void setUtcTime(Date utcTime) {
		this.utcTime = utcTime;
	}
}
