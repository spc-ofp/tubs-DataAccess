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

import java.math.BigDecimal;

import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * LengthSamplePageTotal captures the intermediate totals for a page of
 * samples recorded on a PS-4 form.
 * 
 * @author Corey Cole <coreyc@spc.int>
 *
 */
@Entity
@Table(name = "[obsv].[s_lf_pagetot]")
public class LengthSamplePageTotal implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 608153294678004177L;

	@Id
    @Column(name = "s_pagetot_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "page_number")
	@Min(0)
	private Integer pageNumber;
	
	// FIXME We should treat this as a biological sample moment
    // and use an embedded object that holds species data
    @Column(name = "sp_code", length = 3)
    private String speciesCode;
    
    @Column(name = "sp_order")
    private Integer speciesOrder; // More UI sorting magic
    
    @Column(name = "num_measured")
    @Max(20) // Only twenty rows!
    private Integer speciesCount; // This is the count for this species code
    
    @Column(name = "sum_lengths")
    private Integer sumOfLengths;
    
    @Column(name = "avg_length")
    private BigDecimal averageLength;
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = LengthSamplingHeader.class)
    @JoinColumn(name = "s_lf_id")
    private LengthSamplingHeader header; // Pointer back to containing header

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public String getSpeciesCode() {
		return speciesCode;
	}

	public void setSpeciesCode(String speciesCode) {
		this.speciesCode = speciesCode;
	}

	public Integer getSpeciesOrder() {
		return speciesOrder;
	}

	public void setSpeciesOrder(Integer speciesOrder) {
		this.speciesOrder = speciesOrder;
	}

	public Integer getSpeciesCount() {
		return speciesCount;
	}

	public void setSpeciesCount(Integer speciesCount) {
		this.speciesCount = speciesCount;
	}

	public Integer getSumOfLengths() {
		return sumOfLengths;
	}

	public void setSumOfLengths(Integer sumOfLengths) {
		this.sumOfLengths = sumOfLengths;
	}

	public BigDecimal getAverageLength() {
		return averageLength;
	}

	public void setAverageLength(BigDecimal averageLength) {
		this.averageLength = averageLength;
	}

	public LengthSamplingHeader getHeader() {
		return header;
	}

	public void setHeader(LengthSamplingHeader header) {
		this.header = header;
	}
    
    // FIXME s_lf_pagetot and s_columntot don't have "enteredBy" column
    //@Embedded
    //private AuditEntry auditEntry;
}
