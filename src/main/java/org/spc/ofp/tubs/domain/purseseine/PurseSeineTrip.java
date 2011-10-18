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

import java.util.List;

import javax.persistence.*;

import org.spc.ofp.tubs.domain.Trip;

/**
 * @author Corey Cole <coreyc@spc.int>
 *
 */
@Entity
@DiscriminatorValue("S")
public class PurseSeineTrip extends Trip {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2855914454441426109L;
	
	@OneToMany(cascade = CascadeType.ALL, targetEntity = Crew.class, mappedBy = "trip")
    private List<Crew> crew;
	
	@OneToMany(cascade = CascadeType.ALL, targetEntity = Day.class, mappedBy = "trip")
	private List<Day> days;

	public List<Crew> getCrew() {
		return crew;
	}

	public void setCrew(List<Crew> crew) {
		this.crew = crew;
	}

	public List<Day> getDays() {
		return days;
	}

	public void setDays(List<Day> days) {
		this.days = days;
	}
}
