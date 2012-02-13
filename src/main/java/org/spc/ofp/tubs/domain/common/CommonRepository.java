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

import javax.persistence.*;

import org.spc.ofp.tubs.domain.ImportStatus;
import org.springframework.stereotype.Repository;

/**
 * Rather than a repository per class, a generic repository is used.
 * This works because we're only performing minimal operations
 * (load/store).
 * 
 * @author Corey Cole <coreyc@spc.int>
 *
 */
@Repository
public class CommonRepository {

	@PersistenceContext
	protected EntityManager em; // Used for read-only stuff
	
	@PersistenceUnit
	protected EntityManagerFactory emf;
	
	public Port findPortByNameAndCountry(final String name, final String countryCode) {
		Port p = null;
		// Only catch NoResultException.  NonUniqueResultException means cleanup is necessary
		// and anything else is just like the rest of this code
		try {
			p = em.createQuery(
					"SELECT p FROM Port p WHERE p.name = ?1 AND p.countryCode = ?2", Port.class)
					    .setParameter(1, name)
					    .setParameter(2, countryCode)
					    .getSingleResult();
		} catch (NoResultException nre) {
			try {
				p = em.createQuery(
						"SELECT p FROM Port p WHERE p.alsoCalled = ?1 AND p.countryCode = ?2", Port.class)
						    .setParameter(1, name)
						    .setParameter(2, countryCode)
						    .getSingleResult();
			} catch (NoResultException ignoreMe) { } /* NOPMD */
		}
		return p;
	}
	
	public SeaState findSeaStateByCode(final String seaState) {
		return em.find(SeaState.class, seaState);
	}
	
	public FishCondition findConditionByCode(final String fc) {
		return em.find(FishCondition.class, fc);
	}
	
	public Fate findFateByCode(final String fc) {
		return em.find(Fate.class, fc);
	}
	
	public Observer findByStaffCode(final String staffCode) {
		return em.createQuery(
		    "SELECT o FROM Observer o WHERE o.staffCode = ?1", 
		    Observer.class).setParameter(
		        1, staffCode).getSingleResult();
	}
	
	public Vessel findVesselById(final long vesselId) {
		return em.find(Vessel.class, vesselId);
	}
	
	public ReferenceId findReferenceValueById(final long refId) {
		ReferenceId retval = null;
		try {
			retval = em.find(ReferenceId.class, refId);
		} catch (Exception ignoreMe) { } // TODO Change exception type to no entity found exception?
		return retval;
	}
	
	public ImportStatus findImportStatus(final String sourceId, final String sourceName) {
		return em.createQuery(
			    "SELECT i FROM ImportStatus i WHERE i.sourceId = ?1 AND i.sourceName = ?2", 
			    ImportStatus.class)
				    .setParameter(1, sourceId)
				    .setParameter(2, sourceName)
				    .getSingleResult();
	}
	
	public boolean saveImportStatus(final ImportStatus status) {
		boolean success = false;
		final EntityManager mgr = emf.createEntityManager();
		final EntityTransaction xa = mgr.getTransaction();
		xa.begin();
		try {			
			if (status.getId() > 0L) {
				mgr.merge(status);
			} else {
				mgr.persist(status);
			}
			xa.commit();
			success = true;
		} catch (Exception ignoreMe) { 
			rollbackQuietly(xa);
		} finally {
			mgr.close();
		}
		return success;
	}
		
	public boolean saveVessel(final Vessel vessel) {
		boolean success = false;
		final EntityManager mgr = emf.createEntityManager();
		final EntityTransaction xa = mgr.getTransaction();
		xa.begin();
		try {
			mgr.persist(vessel);
			xa.commit();
			success = true;
		} catch (Exception ignoreMe) {
			rollbackQuietly(xa);
		} finally {
			mgr.close();
		}
		return success;
	}
	
	/**
     * rollbackQuietly rolls back a pending EntityTransaction.
     * @param transaction Pending EntityTransaction, can be null.
     */
    private static void rollbackQuietly(final EntityTransaction transaction) {
        if (null == transaction) { return; }
        try {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        } catch (Exception ignoreMe) { } //NOPMD
    }
}
