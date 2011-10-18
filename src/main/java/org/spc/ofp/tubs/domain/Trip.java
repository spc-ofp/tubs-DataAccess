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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.spc.ofp.tubs.domain.common.Observer;
import org.spc.ofp.tubs.domain.common.Port;
import org.spc.ofp.tubs.domain.common.Vessel;

/**
 * @author Corey Cole <coreyc@spc.int>
 *
 */
@Entity
@Table(name = "[obsv].[trip]")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "gear_code", discriminatorType = DiscriminatorType.STRING)
public abstract class Trip implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8123656774227339589L;
	
	public static final String PURSE_SEINE_SHORT_CODE = "S";
    public static final String LONGLINE_SHORT_CODE = "L";
	
	@Id
	@Column(name = "obstrip_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "tripno")
	private String tripNumber;
    
    @Column(name = "staff_code")
    private String staffCode;
    
    @OneToOne
    @JoinColumn(name = "staff_id")
    private Observer observer;
    
    @Column(name = "obsprg_code", nullable = false)
    private String programCode;
    
    @OneToOne
    @JoinColumn(name = "dep_port_id")
    private Port departurePort;
    
    @OneToOne
    @JoinColumn(name = "ret_port_id")
    private Port returnPort;
    
    @Column(name = "gear_code", length = 1, insertable = false, updatable = false)
    public String gearCode; // TODO: Change to enum
    
    @Column(name = "dep_date")
    private Date departureDate;
    
    @Column(name = "ret_date")
    private Date returnDate;
    
    @Column(name = "vesowner")
    private String vesselOwner;
    
    @OneToOne
    @JoinColumn(name = "vessel_id")
    private Vessel vessel;
    
    @Lob
    @Size(max = 10000)
    @Column(name = "form1_comments")
    private String comments;
    
    @Column(name = "crew_number")
    private Integer crewCount;
    
    @Embedded
    private AuditEntry auditEntry;
    
    @OneToMany(cascade = CascadeType.ALL, targetEntity = VesselSighting.class, mappedBy = "trip")
    private List<VesselSighting> vesselSightings;
    
    @OneToMany(cascade = CascadeType.ALL, targetEntity = FishTransfer.class, mappedBy = "trip")
    private List<FishTransfer> fishTransfers;
    
    @OneToMany(cascade = CascadeType.ALL, targetEntity = SpecialSpeciesInteraction.class, mappedBy = "trip")
    private List<SpecialSpeciesInteraction> specialSpeciesInteractions;
    
    @OneToMany(cascade = CascadeType.ALL, targetEntity = InteractionSupplementHeader.class, mappedBy = "trip")
    private List<InteractionSupplementHeader> interactionSupplements;
    
    @OneToMany(cascade = CascadeType.ALL, targetEntity = PollutionReportHeader.class, mappedBy = "trip")
    private List<PollutionReportHeader> pollutionReports;
    
    @OneToOne(cascade = CascadeType.ALL, targetEntity = TripReportHeader.class, mappedBy = "trip")
    private TripReportHeader tripReport;
    
    public String tripName() {
        final StringBuilder sb = new StringBuilder();
        sb.append(null == observer ? "N/A" : observer.getStaffCode().trim()).append(" / ");
        sb.append(null == tripNumber ? "N/A" : tripNumber.trim());
        return sb.toString();
    }
        
    public boolean isPurseSeineTrip() {
    	return null != gearCode && PURSE_SEINE_SHORT_CODE.equalsIgnoreCase(gearCode.trim());
    }

    public boolean isLongLineTrip() {
    	return null != gearCode && LONGLINE_SHORT_CODE.equalsIgnoreCase(gearCode.trim());
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTripNumber() {
		return tripNumber;
	}

	public void setTripNumber(String tripNumber) {
		this.tripNumber = tripNumber;
	}

	public String getStaffCode() {
		return staffCode;
	}

	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode;
	}

	public String getProgramCode() {
		return programCode;
	}

	public void setProgramCode(String programCode) {
		this.programCode = programCode;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public String getVesselOwner() {
		return vesselOwner;
	}

	public void setVesselOwner(String vesselOwner) {
		this.vesselOwner = vesselOwner;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Integer getCrewCount() {
		return crewCount;
	}

	public void setCrewCount(Integer crewCount) {
		this.crewCount = crewCount;
	}

	public AuditEntry getAuditEntry() {
		return auditEntry;
	}

	public void setAuditEntry(AuditEntry auditEntry) {
		this.auditEntry = auditEntry;
	}

	public List<VesselSighting> getVesselSightings() {
		return vesselSightings;
	}

	public void setVesselSightings(final Collection<VesselSighting> value) {
		this.vesselSightings =
		    new ArrayList<VesselSighting>(null == value ? 0 : value.size());
		if (null == value) { return; }
		for (final VesselSighting vs : value) {
			if (null != vs) {
				if (null == vs.getTrip()) {
					vs.setTrip(this);
				}
				this.vesselSightings.add(vs);
			}
		}
		
	}

	public List<FishTransfer> getFishTransfers() {
		return fishTransfers;
	}

	public void setFishTransfers(final Collection<FishTransfer> value) {
		this.fishTransfers =
		    new ArrayList<FishTransfer>(null == value ? 0 : value.size());
		if (null == value) { return; }
		for (final FishTransfer ft : value) {
			if (null != ft) {
				if (null == ft.getTrip()) { ft.setTrip(this); }
				this.fishTransfers.add(ft);
			}
		}		
	}

	public Observer getObserver() {
		return observer;
	}

	public void setObserver(Observer observer) {
		this.observer = observer;
	}

	public Port getDeparturePort() {
		return departurePort;
	}

	public void setDeparturePort(Port departurePort) {
		this.departurePort = departurePort;
	}

	public Port getReturnPort() {
		return returnPort;
	}

	public void setReturnPort(Port returnPort) {
		this.returnPort = returnPort;
	}

	public List<SpecialSpeciesInteraction> getSpecialSpeciesInteractions() {
		return specialSpeciesInteractions;
	}

	public void setSpecialSpeciesInteractions(
			final Collection<SpecialSpeciesInteraction> value) {
		this.specialSpeciesInteractions =
		    new ArrayList<SpecialSpeciesInteraction>(null == value ? 0 : value.size());
		if (null == value) { return; }
		for (final SpecialSpeciesInteraction ssi : value) {
			if (null != ssi) {
				if (null == ssi.getTrip()) { ssi.setTrip(this); }
				this.specialSpeciesInteractions.add(ssi);
			}
		}
	}

	public List<InteractionSupplementHeader> getInteractionSupplements() {
		return interactionSupplements;
	}

	public void setInteractionSupplements(final Collection<InteractionSupplementHeader> value) {
		this.interactionSupplements =
		    new ArrayList<InteractionSupplementHeader>(null == value ? 0 : value.size());
		if (null == value) { return; }
		for (final InteractionSupplementHeader ish : value) {
			if (null != ish) {
				if (null == ish.getTrip()) { ish.setTrip(this); }
			}
		}
	}

	public List<PollutionReportHeader> getPollutionReports() {
		return pollutionReports;
	}

	public void setPollutionReports(final Collection<PollutionReportHeader> value) {
		this.pollutionReports =
		    new ArrayList<PollutionReportHeader>(null == value ? 0 : value.size());
		if (null == value) { return; }
		for (final PollutionReportHeader prh : value) {
			if (null != prh) {
				if (null == prh.getTrip()) { prh.setTrip(this); }
			}
		}
	}

	public TripReportHeader getTripReport() {
		return tripReport;
	}

	public void setTripReport(TripReportHeader tripReport) {
		this.tripReport = tripReport;
	}

	public Vessel getVessel() {
		return vessel;
	}

	public void setVessel(Vessel vessel) {
		this.vessel = vessel;
	}
}
