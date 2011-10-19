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

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.spc.ofp.tubs.domain.PollutionReportHeader;
import org.spc.ofp.tubs.domain.TripReportHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Corey Cole <coreyc@spc.int>
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(value = {"classpath:tubs-context.xml"})
public class TripRepositoryTest {

	@Autowired
	protected TripRepository repo;
	
	private static final long DOES_EXIST = 12517L;
	
	/**
	 * Test method for {@link org.spc.ofp.tubs.domain.purseseine.TripRepository#findById(long)}.
	 */
	@Test
	public void testLoad() {
		final PurseSeineTrip trip = repo.findById(DOES_EXIST);
		assertNotNull(trip);
		assertEquals(DOES_EXIST, trip.getId());
		assertNotNull(trip.getObserver());
		assertNotNull(trip.getDeparturePort());
		assertNotNull(trip.getReturnPort());
		assertNotNull(trip.getVessel());
		
		assertNotNull(trip.getAuditEntry());
		assertNotNull(trip.getVesselSightings());
		assertFalse(trip.getVesselSightings().isEmpty());
		assertNotNull(trip.getFishTransfers());
		assertFalse(trip.getFishTransfers().isEmpty());
		
		// Special Species interactions aren't present on every trip, but we should at least have an empty list
		assertNotNull(trip.getSpecialSpeciesInteractions());
		assertNotNull(trip.getInteractionSupplements());
		
		// This trip has a pollution report
		final List<PollutionReportHeader> pollutionReports = trip.getPollutionReports();
		assertNotNull(pollutionReports);
		assertFalse(pollutionReports.isEmpty());
		assertNotNull(pollutionReports.get(0).getDetails());
		
		// Every trip should have an associated GEN-3
		final TripReportHeader gen3 = trip.getTripReport();
		assertNotNull(gen3);
		assertNotNull(gen3.getDetails());
		
		// Data that's only applicable to a Purse Seine trip 
		assertNotNull(trip.getCrew());
		//Not a good test, as the S_CREW table can contain vacant positions, while the crew_number associated
		//with a trip doesn't		
		//assertEquals(trip.getCrewCount().intValue(), trip.getCrew().size());

		//The number of filled and vacant positions should be greater than or equal to the number of filled positions
		assertTrue(trip.getCrew().size() >= trip.getCrewCount().intValue());
		
		assertNotNull(trip.getDays());
		assertFalse(trip.getDays().isEmpty());
		
		// Purse-seine specific data
		// Force a full object traversal
		for (final Day day : trip.getDays()) {
			if (null != day) {
				for (final Activity activity : day.getActivities()) {
					if (null != activity) {
						final FishingSet fset = activity.getFishingSet();
						if (null != fset) {
							final List<SetCatch> catchList = fset.getCatchList();
							assertNotNull(catchList);
							final List<LengthSamplingHeader> sampleHeader = fset.getLengthSamples();
							assertNotNull(sampleHeader);
							for (final LengthSamplingHeader lsHeader : sampleHeader) {
								assertNotNull(lsHeader.getBrails());
								assertFalse(lsHeader.getBrails().isEmpty());
								assertNotNull(lsHeader.getColumnTotals());
								assertNotNull(lsHeader.getPageTotals());
							}
						}
					}
				}
			}
		}
	}

}
