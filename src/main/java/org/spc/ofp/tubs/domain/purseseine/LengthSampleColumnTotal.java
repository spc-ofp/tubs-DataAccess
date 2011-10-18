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

import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * LengthSampleColumnTotal captures the intermediate totals for a column of
 * samples recorded on a PS-4 form.
 * 
 * @author Corey Cole <coreyc@spc.int>
 *
 */
@Entity
@Table(name = "[obsv].[s_lf_columntot]")
public class LengthSampleColumnTotal implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7555329951158324841L;

	@Id
    @Column(name = "s_coltot_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "page_number")
	@Min(0)
	private Integer pageNumber;
	
	@Column(name = "col_code")
	private String columnCode; // FIXME Make this an enum 0-20, 21-40, 41-60, 61-80, 81-100, 101-120
	
	@Column(name = "col_order")
	private Integer columnOrder; // Looks like it's used to sort columns correctly (i.e. 0-10 comes before 21-40)
	
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
    
    // FIXME s_lf_pagetot and s_columntot don't have "enteredBy" column
    //@Embedded
    //private AuditEntry auditEntry;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = LengthSamplingHeader.class)
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

	public String getColumnCode() {
		return columnCode;
	}

	public void setColumnCode(String columnCode) {
		this.columnCode = columnCode;
	}

	public Integer getColumnOrder() {
		return columnOrder;
	}

	public void setColumnOrder(Integer columnOrder) {
		this.columnOrder = columnOrder;
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

	public LengthSamplingHeader getHeader() {
		return header;
	}

	public void setHeader(LengthSamplingHeader header) {
		this.header = header;
	}
}
