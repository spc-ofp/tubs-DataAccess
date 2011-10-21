/*
 * Copyright (C) 2011 Secretariat of the Pacific Community
 *
 * This file is part of QuickTest.
 *
 * TUBS is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * QuickTest is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with QuickTest.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.spc.ofp.tubs.domain.purseseine;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.spc.ofp.tubs.domain.AuditEntry;

/**
 * @author Corey Cole <coreyc@spc.int>
 *
 */
@Entity
@Table(name = "[obsv].[s_lfbrails]")
public class Brail implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5632305749577891944L;

	@Id
    @Column(name = "s_lfbrail_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@Column(name = "whichbrail")
	private Integer brailNumber; // Either Brail1 or Brail2
	
	@Column(name = "pagenumber")
	private Integer pageNumber;
	
	@Column(name = "pagemax")
	private Integer pageCount;
	
	@Column(name = "fish_per_brail")
	private Integer fishPerBrail;
	
	@Column(name = "measure", length = 20)
	private String measuringInstrument;
	
	@Column(name = "len_code", length = 2)
	private String lengthCode;
	
	@Column(name = "brail_full_n")
	private Integer fullBrailCount;
	
	@Column(name = "brail_78_n")
	private Integer sevenEighthsBrailCount;
	
	@Column(name = "brail_34_n")
	private Integer threeQuartersBrailCount;
	
	@Column(name = "brail_23_n")
	private Integer twoThirdsBrailCount;
	
	@Column(name = "brail_12_n")
	private Integer oneHalfBrailCount;
	
	@Column(name = "brail_13_n")
	private Integer oneThirdBrailCount;
	
	@Column(name = "brail_14_n")
	private Integer oneQuarterBrailCount;
	
	@Column(name = "brail_18_n")
	private Integer oneEighthBrailCount;
	
	@Column(name = "brail_n")
	private Integer totalBrailCount;
	
	@Column(name = "sum_brails")
	private Double sumOfAllBrails;
	
	// brail'N'_fullness and brail'N'_samples
	// _ARE_ wired up in the application but _AREN'T_
	// present in the legacy system.
	// Therefore, these values will be null for imported data
	@Column(name = "brail1_fullness")
	private Integer brail1FullnessCode;
	
	@Column(name = "brail1_samples")
	private Integer samplesFromBrail1;
	
	@Column(name = "brail2_fullness")
    private Integer brail2FullnessCode;

    @Column(name = "brail2_samples")
    private Integer samplesFromBrail2;


    @Column(name = "brail3_fullness")
    private Integer brail3FullnessCode;

    @Column(name = "brail3_samples")
    private Integer samplesFromBrail3;


    @Column(name = "brail4_fullness")
    private Integer brail4FullnessCode;

    @Column(name = "brail4_samples")
    private Integer samplesFromBrail4;


    @Column(name = "brail5_fullness")
    private Integer brail5FullnessCode;

    @Column(name = "brail5_samples")
    private Integer samplesFromBrail5;


    @Column(name = "brail6_fullness")
    private Integer brail6FullnessCode;

    @Column(name = "brail6_samples")
    private Integer samplesFromBrail6;


    @Column(name = "brail7_fullness")
    private Integer brail7FullnessCode;

    @Column(name = "brail7_samples")
    private Integer samplesFromBrail7;


    @Column(name = "brail8_fullness")
    private Integer brail8FullnessCode;

    @Column(name = "brail8_samples")
    private Integer samplesFromBrail8;


    @Column(name = "brail9_fullness")
    private Integer brail9FullnessCode;

    @Column(name = "brail9_samples")
    private Integer samplesFromBrail9;


    @Column(name = "brail10_fullness")
    private Integer brail10FullnessCode;

    @Column(name = "brail10_samples")
    private Integer samplesFromBrail10;


    @Column(name = "brail11_fullness")
    private Integer brail11FullnessCode;

    @Column(name = "brail11_samples")
    private Integer samplesFromBrail11;


    @Column(name = "brail12_fullness")
    private Integer brail12FullnessCode;

    @Column(name = "brail12_samples")
    private Integer samplesFromBrail12;


    @Column(name = "brail13_fullness")
    private Integer brail13FullnessCode;

    @Column(name = "brail13_samples")
    private Integer samplesFromBrail13;


    @Column(name = "brail14_fullness")
    private Integer brail14FullnessCode;

    @Column(name = "brail14_samples")
    private Integer samplesFromBrail14;


    @Column(name = "brail15_fullness")
    private Integer brail15FullnessCode;

    @Column(name = "brail15_samples")
    private Integer samplesFromBrail15;


    @Column(name = "brail16_fullness")
    private Integer brail16FullnessCode;

    @Column(name = "brail16_samples")
    private Integer samplesFromBrail16;


    @Column(name = "brail17_fullness")
    private Integer brail17FullnessCode;

    @Column(name = "brail17_samples")
    private Integer samplesFromBrail17;


    @Column(name = "brail18_fullness")
    private Integer brail18FullnessCode;

    @Column(name = "brail18_samples")
    private Integer samplesFromBrail18;


    @Column(name = "brail19_fullness")
    private Integer brail19FullnessCode;

    @Column(name = "brail19_samples")
    private Integer samplesFromBrail19;


    @Column(name = "brail20_fullness")
    private Integer brail20FullnessCode;

    @Column(name = "brail20_samples")
    private Integer samplesFromBrail20;


    @Column(name = "brail21_fullness")
    private Integer brail21FullnessCode;

    @Column(name = "brail21_samples")
    private Integer samplesFromBrail21;


    @Column(name = "brail22_fullness")
    private Integer brail22FullnessCode;

    @Column(name = "brail22_samples")
    private Integer samplesFromBrail22;


    @Column(name = "brail23_fullness")
    private Integer brail23FullnessCode;

    @Column(name = "brail23_samples")
    private Integer samplesFromBrail23;


    @Column(name = "brail24_fullness")
    private Integer brail24FullnessCode;

    @Column(name = "brail24_samples")
    private Integer samplesFromBrail24;


    @Column(name = "brail25_fullness")
    private Integer brail25FullnessCode;

    @Column(name = "brail25_samples")
    private Integer samplesFromBrail25;


    @Column(name = "brail26_fullness")
    private Integer brail26FullnessCode;

    @Column(name = "brail26_samples")
    private Integer samplesFromBrail26;


    @Column(name = "brail27_fullness")
    private Integer brail27FullnessCode;

    @Column(name = "brail27_samples")
    private Integer samplesFromBrail27;


    @Column(name = "brail28_fullness")
    private Integer brail28FullnessCode;

    @Column(name = "brail28_samples")
    private Integer samplesFromBrail28;


    @Column(name = "brail29_fullness")
    private Integer brail29FullnessCode;

    @Column(name = "brail29_samples")
    private Integer samplesFromBrail29;
    
    @Column(name = "brail30_fullness")
    private Integer brail30FullnessCode;

    @Column(name = "brail30_samples")
    private Integer samplesFromBrail30;
	
	@Lob
    @Column(name = "comments")
    @Size(max = 10000)
    private String comments;
	
	@Embedded
    private AuditEntry auditEntry;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = LengthSamplingHeader.class)
    @JoinColumn(name = "s_lf_id")
    private LengthSamplingHeader header; // Pointer back to containing header

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Integer getBrailNumber() {
		return brailNumber;
	}

	public void setBrailNumber(Integer brailNumber) {
		this.brailNumber = brailNumber;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public Integer getFishPerBrail() {
		return fishPerBrail;
	}

	public void setFishPerBrail(Integer fishPerBrail) {
		this.fishPerBrail = fishPerBrail;
	}

	public String getMeasuringInstrument() {
		return measuringInstrument;
	}

	public void setMeasuringInstrument(String measuringInstrument) {
		this.measuringInstrument = measuringInstrument;
	}

	public String getLengthCode() {
		return lengthCode;
	}

	public void setLengthCode(String lengthCode) {
		this.lengthCode = lengthCode;
	}

	public Integer getFullBrailCount() {
		return fullBrailCount;
	}

	public void setFullBrailCount(Integer fullBrailCount) {
		this.fullBrailCount = fullBrailCount;
	}

	public Integer getSevenEighthsBrailCount() {
		return sevenEighthsBrailCount;
	}

	public void setSevenEighthsBrailCount(Integer sevenEighthsBrailCount) {
		this.sevenEighthsBrailCount = sevenEighthsBrailCount;
	}

	public Integer getThreeQuartersBrailCount() {
		return threeQuartersBrailCount;
	}

	public void setThreeQuartersBrailCount(Integer threeQuartersBrailCount) {
		this.threeQuartersBrailCount = threeQuartersBrailCount;
	}

	public Integer getTwoThirdsBrailCount() {
		return twoThirdsBrailCount;
	}

	public void setTwoThirdsBrailCount(Integer twoThirdsBrailCount) {
		this.twoThirdsBrailCount = twoThirdsBrailCount;
	}

	public Integer getOneHalfBrailCount() {
		return oneHalfBrailCount;
	}

	public void setOneHalfBrailCount(Integer oneHalfBrailCount) {
		this.oneHalfBrailCount = oneHalfBrailCount;
	}

	public Integer getOneThirdBrailCount() {
		return oneThirdBrailCount;
	}

	public void setOneThirdBrailCount(Integer oneThirdBrailCount) {
		this.oneThirdBrailCount = oneThirdBrailCount;
	}

	public Integer getOneQuarterBrailCount() {
		return oneQuarterBrailCount;
	}

	public void setOneQuarterBrailCount(Integer oneQuarterBrailCount) {
		this.oneQuarterBrailCount = oneQuarterBrailCount;
	}

	public Integer getOneEighthBrailCount() {
		return oneEighthBrailCount;
	}

	public void setOneEighthBrailCount(Integer oneEighthBrailCount) {
		this.oneEighthBrailCount = oneEighthBrailCount;
	}

	public Integer getTotalBrailCount() {
		return totalBrailCount;
	}

	public void setTotalBrailCount(Integer totalBrailCount) {
		this.totalBrailCount = totalBrailCount;
	}

	public Double getSumOfAllBrails() {
		return sumOfAllBrails;
	}

	public void setSumOfAllBrails(Double sumOfAllBrails) {
		this.sumOfAllBrails = sumOfAllBrails;
	}

	public Integer getBrail1FullnessCode() {
		return brail1FullnessCode;
	}

	public void setBrail1FullnessCode(Integer brail1FullnessCode) {
		this.brail1FullnessCode = brail1FullnessCode;
	}

	public Integer getSamplesFromBrail1() {
		return samplesFromBrail1;
	}

	public void setSamplesFromBrail1(Integer samplesFromBrail1) {
		this.samplesFromBrail1 = samplesFromBrail1;
	}

	public Integer getBrail2FullnessCode() {
		return brail2FullnessCode;
	}

	public void setBrail2FullnessCode(Integer brail2FullnessCode) {
		this.brail2FullnessCode = brail2FullnessCode;
	}

	public Integer getSamplesFromBrail2() {
		return samplesFromBrail2;
	}

	public void setSamplesFromBrail2(Integer samplesFromBrail2) {
		this.samplesFromBrail2 = samplesFromBrail2;
	}

	public Integer getBrail3FullnessCode() {
		return brail3FullnessCode;
	}

	public void setBrail3FullnessCode(Integer brail3FullnessCode) {
		this.brail3FullnessCode = brail3FullnessCode;
	}

	public Integer getSamplesFromBrail3() {
		return samplesFromBrail3;
	}

	public void setSamplesFromBrail3(Integer samplesFromBrail3) {
		this.samplesFromBrail3 = samplesFromBrail3;
	}

	public Integer getBrail4FullnessCode() {
		return brail4FullnessCode;
	}

	public void setBrail4FullnessCode(Integer brail4FullnessCode) {
		this.brail4FullnessCode = brail4FullnessCode;
	}

	public Integer getSamplesFromBrail4() {
		return samplesFromBrail4;
	}

	public void setSamplesFromBrail4(Integer samplesFromBrail4) {
		this.samplesFromBrail4 = samplesFromBrail4;
	}

	public Integer getBrail5FullnessCode() {
		return brail5FullnessCode;
	}

	public void setBrail5FullnessCode(Integer brail5FullnessCode) {
		this.brail5FullnessCode = brail5FullnessCode;
	}

	public Integer getSamplesFromBrail5() {
		return samplesFromBrail5;
	}

	public void setSamplesFromBrail5(Integer samplesFromBrail5) {
		this.samplesFromBrail5 = samplesFromBrail5;
	}

	public Integer getBrail6FullnessCode() {
		return brail6FullnessCode;
	}

	public void setBrail6FullnessCode(Integer brail6FullnessCode) {
		this.brail6FullnessCode = brail6FullnessCode;
	}

	public Integer getSamplesFromBrail6() {
		return samplesFromBrail6;
	}

	public void setSamplesFromBrail6(Integer samplesFromBrail6) {
		this.samplesFromBrail6 = samplesFromBrail6;
	}

	public Integer getBrail7FullnessCode() {
		return brail7FullnessCode;
	}

	public void setBrail7FullnessCode(Integer brail7FullnessCode) {
		this.brail7FullnessCode = brail7FullnessCode;
	}

	public Integer getSamplesFromBrail7() {
		return samplesFromBrail7;
	}

	public void setSamplesFromBrail7(Integer samplesFromBrail7) {
		this.samplesFromBrail7 = samplesFromBrail7;
	}

	public Integer getBrail8FullnessCode() {
		return brail8FullnessCode;
	}

	public void setBrail8FullnessCode(Integer brail8FullnessCode) {
		this.brail8FullnessCode = brail8FullnessCode;
	}

	public Integer getSamplesFromBrail8() {
		return samplesFromBrail8;
	}

	public void setSamplesFromBrail8(Integer samplesFromBrail8) {
		this.samplesFromBrail8 = samplesFromBrail8;
	}

	public Integer getBrail9FullnessCode() {
		return brail9FullnessCode;
	}

	public void setBrail9FullnessCode(Integer brail9FullnessCode) {
		this.brail9FullnessCode = brail9FullnessCode;
	}

	public Integer getSamplesFromBrail9() {
		return samplesFromBrail9;
	}

	public void setSamplesFromBrail9(Integer samplesFromBrail9) {
		this.samplesFromBrail9 = samplesFromBrail9;
	}

	public Integer getBrail10FullnessCode() {
		return brail10FullnessCode;
	}

	public void setBrail10FullnessCode(Integer brail10FullnessCode) {
		this.brail10FullnessCode = brail10FullnessCode;
	}

	public Integer getSamplesFromBrail10() {
		return samplesFromBrail10;
	}

	public void setSamplesFromBrail10(Integer samplesFromBrail10) {
		this.samplesFromBrail10 = samplesFromBrail10;
	}

	public Integer getBrail11FullnessCode() {
		return brail11FullnessCode;
	}

	public void setBrail11FullnessCode(Integer brail11FullnessCode) {
		this.brail11FullnessCode = brail11FullnessCode;
	}

	public Integer getSamplesFromBrail11() {
		return samplesFromBrail11;
	}

	public void setSamplesFromBrail11(Integer samplesFromBrail11) {
		this.samplesFromBrail11 = samplesFromBrail11;
	}

	public Integer getBrail12FullnessCode() {
		return brail12FullnessCode;
	}

	public void setBrail12FullnessCode(Integer brail12FullnessCode) {
		this.brail12FullnessCode = brail12FullnessCode;
	}

	public Integer getSamplesFromBrail12() {
		return samplesFromBrail12;
	}

	public void setSamplesFromBrail12(Integer samplesFromBrail12) {
		this.samplesFromBrail12 = samplesFromBrail12;
	}

	public Integer getBrail13FullnessCode() {
		return brail13FullnessCode;
	}

	public void setBrail13FullnessCode(Integer brail13FullnessCode) {
		this.brail13FullnessCode = brail13FullnessCode;
	}

	public Integer getSamplesFromBrail13() {
		return samplesFromBrail13;
	}

	public void setSamplesFromBrail13(Integer samplesFromBrail13) {
		this.samplesFromBrail13 = samplesFromBrail13;
	}

	public Integer getBrail14FullnessCode() {
		return brail14FullnessCode;
	}

	public void setBrail14FullnessCode(Integer brail14FullnessCode) {
		this.brail14FullnessCode = brail14FullnessCode;
	}

	public Integer getSamplesFromBrail14() {
		return samplesFromBrail14;
	}

	public void setSamplesFromBrail14(Integer samplesFromBrail14) {
		this.samplesFromBrail14 = samplesFromBrail14;
	}

	public Integer getBrail15FullnessCode() {
		return brail15FullnessCode;
	}

	public void setBrail15FullnessCode(Integer brail15FullnessCode) {
		this.brail15FullnessCode = brail15FullnessCode;
	}

	public Integer getSamplesFromBrail15() {
		return samplesFromBrail15;
	}

	public void setSamplesFromBrail15(Integer samplesFromBrail15) {
		this.samplesFromBrail15 = samplesFromBrail15;
	}

	public Integer getBrail16FullnessCode() {
		return brail16FullnessCode;
	}

	public void setBrail16FullnessCode(Integer brail16FullnessCode) {
		this.brail16FullnessCode = brail16FullnessCode;
	}

	public Integer getSamplesFromBrail16() {
		return samplesFromBrail16;
	}

	public void setSamplesFromBrail16(Integer samplesFromBrail16) {
		this.samplesFromBrail16 = samplesFromBrail16;
	}

	public Integer getBrail17FullnessCode() {
		return brail17FullnessCode;
	}

	public void setBrail17FullnessCode(Integer brail17FullnessCode) {
		this.brail17FullnessCode = brail17FullnessCode;
	}

	public Integer getSamplesFromBrail17() {
		return samplesFromBrail17;
	}

	public void setSamplesFromBrail17(Integer samplesFromBrail17) {
		this.samplesFromBrail17 = samplesFromBrail17;
	}

	public Integer getBrail18FullnessCode() {
		return brail18FullnessCode;
	}

	public void setBrail18FullnessCode(Integer brail18FullnessCode) {
		this.brail18FullnessCode = brail18FullnessCode;
	}

	public Integer getSamplesFromBrail18() {
		return samplesFromBrail18;
	}

	public void setSamplesFromBrail18(Integer samplesFromBrail18) {
		this.samplesFromBrail18 = samplesFromBrail18;
	}

	public Integer getBrail19FullnessCode() {
		return brail19FullnessCode;
	}

	public void setBrail19FullnessCode(Integer brail19FullnessCode) {
		this.brail19FullnessCode = brail19FullnessCode;
	}

	public Integer getSamplesFromBrail19() {
		return samplesFromBrail19;
	}

	public void setSamplesFromBrail19(Integer samplesFromBrail19) {
		this.samplesFromBrail19 = samplesFromBrail19;
	}

	public Integer getBrail20FullnessCode() {
		return brail20FullnessCode;
	}

	public void setBrail20FullnessCode(Integer brail20FullnessCode) {
		this.brail20FullnessCode = brail20FullnessCode;
	}

	public Integer getSamplesFromBrail20() {
		return samplesFromBrail20;
	}

	public void setSamplesFromBrail20(Integer samplesFromBrail20) {
		this.samplesFromBrail20 = samplesFromBrail20;
	}

	public Integer getBrail21FullnessCode() {
		return brail21FullnessCode;
	}

	public void setBrail21FullnessCode(Integer brail21FullnessCode) {
		this.brail21FullnessCode = brail21FullnessCode;
	}

	public Integer getSamplesFromBrail21() {
		return samplesFromBrail21;
	}

	public void setSamplesFromBrail21(Integer samplesFromBrail21) {
		this.samplesFromBrail21 = samplesFromBrail21;
	}

	public Integer getBrail22FullnessCode() {
		return brail22FullnessCode;
	}

	public void setBrail22FullnessCode(Integer brail22FullnessCode) {
		this.brail22FullnessCode = brail22FullnessCode;
	}

	public Integer getSamplesFromBrail22() {
		return samplesFromBrail22;
	}

	public void setSamplesFromBrail22(Integer samplesFromBrail22) {
		this.samplesFromBrail22 = samplesFromBrail22;
	}

	public Integer getBrail23FullnessCode() {
		return brail23FullnessCode;
	}

	public void setBrail23FullnessCode(Integer brail23FullnessCode) {
		this.brail23FullnessCode = brail23FullnessCode;
	}

	public Integer getSamplesFromBrail23() {
		return samplesFromBrail23;
	}

	public void setSamplesFromBrail23(Integer samplesFromBrail23) {
		this.samplesFromBrail23 = samplesFromBrail23;
	}

	public Integer getBrail24FullnessCode() {
		return brail24FullnessCode;
	}

	public void setBrail24FullnessCode(Integer brail24FullnessCode) {
		this.brail24FullnessCode = brail24FullnessCode;
	}

	public Integer getSamplesFromBrail24() {
		return samplesFromBrail24;
	}

	public void setSamplesFromBrail24(Integer samplesFromBrail24) {
		this.samplesFromBrail24 = samplesFromBrail24;
	}

	public Integer getBrail25FullnessCode() {
		return brail25FullnessCode;
	}

	public void setBrail25FullnessCode(Integer brail25FullnessCode) {
		this.brail25FullnessCode = brail25FullnessCode;
	}

	public Integer getSamplesFromBrail25() {
		return samplesFromBrail25;
	}

	public void setSamplesFromBrail25(Integer samplesFromBrail25) {
		this.samplesFromBrail25 = samplesFromBrail25;
	}

	public Integer getBrail26FullnessCode() {
		return brail26FullnessCode;
	}

	public void setBrail26FullnessCode(Integer brail26FullnessCode) {
		this.brail26FullnessCode = brail26FullnessCode;
	}

	public Integer getSamplesFromBrail26() {
		return samplesFromBrail26;
	}

	public void setSamplesFromBrail26(Integer samplesFromBrail26) {
		this.samplesFromBrail26 = samplesFromBrail26;
	}

	public Integer getBrail27FullnessCode() {
		return brail27FullnessCode;
	}

	public void setBrail27FullnessCode(Integer brail27FullnessCode) {
		this.brail27FullnessCode = brail27FullnessCode;
	}

	public Integer getSamplesFromBrail27() {
		return samplesFromBrail27;
	}

	public void setSamplesFromBrail27(Integer samplesFromBrail27) {
		this.samplesFromBrail27 = samplesFromBrail27;
	}

	public Integer getBrail28FullnessCode() {
		return brail28FullnessCode;
	}

	public void setBrail28FullnessCode(Integer brail28FullnessCode) {
		this.brail28FullnessCode = brail28FullnessCode;
	}

	public Integer getSamplesFromBrail28() {
		return samplesFromBrail28;
	}

	public void setSamplesFromBrail28(Integer samplesFromBrail28) {
		this.samplesFromBrail28 = samplesFromBrail28;
	}

	public Integer getBrail29FullnessCode() {
		return brail29FullnessCode;
	}

	public void setBrail29FullnessCode(Integer brail29FullnessCode) {
		this.brail29FullnessCode = brail29FullnessCode;
	}

	public Integer getSamplesFromBrail29() {
		return samplesFromBrail29;
	}

	public void setSamplesFromBrail29(Integer samplesFromBrail29) {
		this.samplesFromBrail29 = samplesFromBrail29;
	}

	public Integer getBrail30FullnessCode() {
		return brail30FullnessCode;
	}

	public void setBrail30FullnessCode(Integer brail30FullnessCode) {
		this.brail30FullnessCode = brail30FullnessCode;
	}

	public Integer getSamplesFromBrail30() {
		return samplesFromBrail30;
	}

	public void setSamplesFromBrail30(Integer samplesFromBrail30) {
		this.samplesFromBrail30 = samplesFromBrail30;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public AuditEntry getAuditEntry() {
		return auditEntry;
	}

	public void setAuditEntry(AuditEntry auditEntry) {
		this.auditEntry = auditEntry;
	}

	public LengthSamplingHeader getHeader() {
		return header;
	}

	public void setHeader(LengthSamplingHeader header) {
		this.header = header;
	}
}
