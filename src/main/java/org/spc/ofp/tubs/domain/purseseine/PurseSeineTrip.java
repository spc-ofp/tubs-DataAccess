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
