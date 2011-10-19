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
package org.spc.ofp.tubs.constraints;

import java.util.Date;

/**
 * @author Corey Cole <coreyc@spc.int>
 *
 */
public class MinimumDateValue {

	// According to www.epochconverter.com, this is Wed, 31 Dec 1980 23:59:59 GMT
	// as epoch time.
	public static final Date VALUE = new Date(347155199L);
	
	public static boolean isAfterMinimum(final Date dt) {
		// The assumption here is that a null value is A-OK
		// If you want to validate not-null, use the appropriate JSR-303 annotation
		if (null == dt) { return true; }
		return dt.after(VALUE);
	}
}
