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
package org.spc.ofp.tubs.domain;

import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * @author Corey Cole <coreyc@spc.int>
 *
 */
@Entity
@Table(name = "[obsv].[gen6polldetails]")
public class PollutionReportDetails implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2508075786909086303L;

	@Id
    @Column(name = "pollutiondetails_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@Column(name = "pollutiontype_id")
	private Integer pollutionType;
	
	@Column(name = "material_id")
	private Integer material;
	
	@Lob
	@Column(name = "poll_desc")
	@Size(max = 10000)
	private String description;
	
	@Lob
	@Column(name = "poll_qty")
	@Size(max = 10000)
	private String quantity;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = PollutionReportHeader.class)
    @JoinColumn(name = "pollution_Id")
	private PollutionReportHeader header;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Integer getPollutionType() {
		return pollutionType;
	}

	public void setPollutionType(Integer pollutionType) {
		this.pollutionType = pollutionType;
	}

	public Integer getMaterial() {
		return material;
	}

	public void setMaterial(Integer material) {
		this.material = material;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public PollutionReportHeader getHeader() {
		return header;
	}

	public void setHeader(PollutionReportHeader header) {
		this.header = header;
	}
}
