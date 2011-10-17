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
	
	private static final long PORT_ID = 67L;
	private static final String PORT_NAME = "MAJURO";
	private static final String PORT_COUNTRY_CODE = "MH";
	
	
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
	 * Test method for {@link org.spc.ofp.tubs.domain.common.CommonRepository#findPortById(long)}.
	 */
	@Test
	public void testFindPortById() {
		final Port tp = repo.findPortById(PORT_ID);
		assertNotNull(tp);
		assertEquals(PORT_ID, tp.getId());
		assertNotNull(tp.getName());
		assertTrue(PORT_NAME.equalsIgnoreCase(tp.getName().trim()));
		assertNotNull(tp.getCountryCode());
		assertTrue(PORT_COUNTRY_CODE.equalsIgnoreCase(tp.getCountryCode().trim()));
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
