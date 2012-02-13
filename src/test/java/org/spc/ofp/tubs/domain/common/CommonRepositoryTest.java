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
package org.spc.ofp.tubs.domain.common;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
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
public class CommonRepositoryTest {

	@Autowired
	protected CommonRepository repo;
	
	private static final long VESSEL_ID = 2L;
	// This data comes from manual inspection of the database
	private static final String VESSEL_NAME = "MEREANA (1290)";
	private static final String VESSEL_REG_NO = "1290";
	
	private static final String OBSERVER_STAFF_CODE = "AU073";
	// This data comes from manual inspection of the database
	private static final String OBSERVER_FNAME = "BASIL";
	private static final String OBSERVER_LNAME = "ADAMS";
	
	private static final String PORT_NAME = "MAJURO";
	private static final String PORT_COUNTRY_CODE = "MH";
	private static final String PORT_LOCODE = "MHMAJ";
	
	private static final String PORT_NAME_2 = "CHUUK";
	private static final String PORT_ALSO_CALLED_2 = "TRUK";
	private static final String PORT_COUNTRY_CODE_2 = "FM";	
	private static final String PORT_LOCODE_2 = "FMTKK";
	
	
	/**
	 * Test method for {@link org.spc.ofp.tubs.domain.common.CommonRepository#findByStaffCode(java.lang.String)}.
	 */
	@Test
	public void testFindByStaffCode() {
		final Observer to = repo.findByStaffCode(OBSERVER_STAFF_CODE);
		assertNotNull(to);
		assertNotNull(to.getStaffCode());
		assertTrue(OBSERVER_STAFF_CODE.equalsIgnoreCase(to.getStaffCode().trim()));
		assertNotNull(to.getFirstName());
		assertTrue(OBSERVER_FNAME.equalsIgnoreCase(to.getFirstName().trim()));
		assertNotNull(to.getFamilyName());
		assertTrue(OBSERVER_LNAME.equalsIgnoreCase(to.getFamilyName().trim()));
	}

	/**
	 * Test method for {@link org.spc.ofp.tubs.domain.common.CommonRepository#findPortByNameAndCountry(java.lang.String,java.lang.String)}.
	 */
	@Test
	public void findPortByNameAndCountry() {
		final Port tp = repo.findPortByNameAndCountry(PORT_NAME, PORT_COUNTRY_CODE);
		assertNotNull(tp);
		assertNotNull(tp.getName());
		assertTrue(PORT_NAME.equalsIgnoreCase(tp.getName().trim()));
		assertNotNull(tp.getCountryCode());
		assertTrue(PORT_COUNTRY_CODE.equalsIgnoreCase(tp.getCountryCode().trim()));
		assertNotNull(tp.getLocationCode());
		assertTrue(PORT_LOCODE.equalsIgnoreCase(tp.getLocationCode().trim()));
	}
	
	@Test
	public void findPortByAlternateNameAndCountry() {
		final Port tp = repo.findPortByNameAndCountry(PORT_ALSO_CALLED_2, PORT_COUNTRY_CODE_2);
		assertNotNull(tp);
		assertNotNull(tp.getName());
		assertNotNull(tp.getCountryCode());
		assertNotNull(tp.getLocationCode());
		assertNotNull(tp.getAlsoCalled());
		
		assertTrue(PORT_NAME_2.equalsIgnoreCase(tp.getName().trim()));
		assertTrue(PORT_COUNTRY_CODE_2.equalsIgnoreCase(tp.getCountryCode().trim()));
		assertTrue(PORT_LOCODE_2.equalsIgnoreCase(tp.getLocationCode().trim()));
		assertTrue(PORT_ALSO_CALLED_2.equalsIgnoreCase(tp.getAlsoCalled().trim()));
		
	}

	/**
	 * Test method for {@link org.spc.ofp.tubs.domain.common.CommonRepository#findVesselById(long)}.
	 */
	@Test
	public void testFindVesselById() {
		final Vessel tv = repo.findVesselById(VESSEL_ID);
		assertNotNull(tv);
		assertEquals(VESSEL_ID, tv.getId());
		assertNotNull(tv.getName());
		assertTrue(VESSEL_NAME.equalsIgnoreCase(tv.getName().trim()));
		assertNotNull(tv.getRegistrationNumber());
		assertTrue(VESSEL_REG_NO.equalsIgnoreCase(tv.getRegistrationNumber().trim()));
	}
	
	@Test
	public void testFindSeaState() {
		final SeaState ss = repo.findSeaStateByCode("C");
		assertNotNull(ss);
	}
	

}
