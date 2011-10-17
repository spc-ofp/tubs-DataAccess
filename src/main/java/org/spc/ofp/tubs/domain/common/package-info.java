/**
 * Entities in org.spc.ofp.tubs.domain.common are those which are either completely controlled
 * by the TUBS administrator or are infrequently added during trip entry.
 * 
 * An example of the former is the enumeration of values for gonad stage.
 * An example of the latter is a vessel.  While an observer may spot an unknown vessel,
 * such a sighting does not merit a full-blown vessel entity with all it's associated metadata.
 * 
 * @since 1.0
 */
package org.spc.ofp.tubs.domain.common;