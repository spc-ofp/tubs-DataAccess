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
package org.spc.ofp.tubs.domain.longline;

import javax.persistence.*;

import org.spc.ofp.tubs.domain.Trip;

/**
 * @author Corey Cole <coreyc@spc.int>
 *
 */
@Entity
@DiscriminatorValue("L")
public class LongLineTrip extends Trip {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4487545294371318009L;

}
