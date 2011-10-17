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
package org.spc.ofp.tubs.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * @author Corey Cole <coreyc@spc.int>
 *
 */
@Entity
@Table(name = "[obsv].[gen3tripmon]")
public class TripReportHeader implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4759854036648639514L;

	@Id
    @Column(name = "gen3_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	// FIXME I really don't like this means of using columns instead of rows
	// However, we'll wait until the next iteration to come up with a better table implementation
	@Column(name = "q1_ans", length = 1)
	private String questionOneAnswer;	
	@Column(name = "q2_ans", length = 1)
	private String questionTwoAnswer;
	@Column(name = "q3_ans", length = 1)
	private String questionThreeAnswer;
	@Column(name = "q4_ans", length = 1)
	private String questionFourAnswer;
	@Column(name = "q5_ans", length = 1)
	private String questionFiveAnswer;
	@Column(name = "q6_ans", length = 1)
	private String questionSixAnswer;
	@Column(name = "q7_ans", length = 1)
	private String questionSevenAnswer;
	@Column(name = "q8_ans", length = 1)
	private String questionEightAnswer;
	@Column(name = "q9_ans", length = 1)
	private String questionNineAnswer;
	@Column(name = "q10_ans", length = 1)
	private String questionTenAnswer;
	@Column(name = "q11_ans", length = 1)
	private String questionElevenAnswer;
	@Column(name = "q12_ans", length = 1)
	private String questionTwelveAnswer;
	@Column(name = "q13_ans", length = 1)
	private String questionThirteenAnswer;
	@Column(name = "q14_ans", length = 1)
	private String questionFourteenAnswer;
	@Column(name = "q15_ans", length = 1)
	private String questionFifteenAnswer;
	@Column(name = "q16_ans", length = 1)
	private String questionSixteenAnswer;
	@Column(name = "q17_ans", length = 1)
	private String questionSeventeenAnswer;
	@Column(name = "q18_ans", length = 1)
	private String questionEighteenAnswer;
	@Column(name = "q19_ans", length = 1)
	private String questionNineteenAnswer;
	@Column(name = "q20_ans", length = 1)
	private String questionTwentyAnswer;
	
	@Column(name = "date1")
	private Date dateForFirstComment;
	
	@Lob
	@Column(name = "comments1")
	@Size(max = 10000)
	private String firstComment;
	
	@Column(name = "date2")
	private Date dateForSecondComment;
	
	@Lob
	@Column(name = "comments2")
	@Size(max = 10000)
	private String secondComment;
	
	@Column(name = "date3")
	private Date dateForThirdComment;
	
	@Lob
	@Column(name = "comments3")
	@Size(max = 10000)
	private String thirdComment;	
	
	@Embedded
	private AuditEntry auditEntry;
	
	@OneToOne(targetEntity = Trip.class)
    @JoinColumn(name = "obstrip_id")
    private Trip trip;
	
	@OneToMany(cascade = CascadeType.ALL, targetEntity = TripReportDetails.class, mappedBy = "header")
    private List<TripReportDetails> details;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getQuestionOneAnswer() {
		return questionOneAnswer;
	}

	public void setQuestionOneAnswer(String questionOneAnswer) {
		this.questionOneAnswer = questionOneAnswer;
	}

	public String getQuestionTwoAnswer() {
		return questionTwoAnswer;
	}

	public void setQuestionTwoAnswer(String questionTwoAnswer) {
		this.questionTwoAnswer = questionTwoAnswer;
	}

	public String getQuestionThreeAnswer() {
		return questionThreeAnswer;
	}

	public void setQuestionThreeAnswer(String questionThreeAnswer) {
		this.questionThreeAnswer = questionThreeAnswer;
	}

	public String getQuestionFourAnswer() {
		return questionFourAnswer;
	}

	public void setQuestionFourAnswer(String questionFourAnswer) {
		this.questionFourAnswer = questionFourAnswer;
	}

	public String getQuestionFiveAnswer() {
		return questionFiveAnswer;
	}

	public void setQuestionFiveAnswer(String questionFiveAnswer) {
		this.questionFiveAnswer = questionFiveAnswer;
	}

	public String getQuestionSixAnswer() {
		return questionSixAnswer;
	}

	public void setQuestionSixAnswer(String questionSixAnswer) {
		this.questionSixAnswer = questionSixAnswer;
	}

	public String getQuestionSevenAnswer() {
		return questionSevenAnswer;
	}

	public void setQuestionSevenAnswer(String questionSevenAnswer) {
		this.questionSevenAnswer = questionSevenAnswer;
	}

	public String getQuestionEightAnswer() {
		return questionEightAnswer;
	}

	public void setQuestionEightAnswer(String questionEightAnswer) {
		this.questionEightAnswer = questionEightAnswer;
	}

	public String getQuestionNineAnswer() {
		return questionNineAnswer;
	}

	public void setQuestionNineAnswer(String questionNineAnswer) {
		this.questionNineAnswer = questionNineAnswer;
	}

	public String getQuestionTenAnswer() {
		return questionTenAnswer;
	}

	public void setQuestionTenAnswer(String questionTenAnswer) {
		this.questionTenAnswer = questionTenAnswer;
	}

	public String getQuestionElevenAnswer() {
		return questionElevenAnswer;
	}

	public void setQuestionElevenAnswer(String questionElevenAnswer) {
		this.questionElevenAnswer = questionElevenAnswer;
	}

	public String getQuestionTwelveAnswer() {
		return questionTwelveAnswer;
	}

	public void setQuestionTwelveAnswer(String questionTwelveAnswer) {
		this.questionTwelveAnswer = questionTwelveAnswer;
	}

	public String getQuestionThirteenAnswer() {
		return questionThirteenAnswer;
	}

	public void setQuestionThirteenAnswer(String questionThirteenAnswer) {
		this.questionThirteenAnswer = questionThirteenAnswer;
	}

	public String getQuestionFourteenAnswer() {
		return questionFourteenAnswer;
	}

	public void setQuestionFourteenAnswer(String questionFourteenAnswer) {
		this.questionFourteenAnswer = questionFourteenAnswer;
	}

	public String getQuestionFifteenAnswer() {
		return questionFifteenAnswer;
	}

	public void setQuestionFifteenAnswer(String questionFifteenAnswer) {
		this.questionFifteenAnswer = questionFifteenAnswer;
	}

	public String getQuestionSixteenAnswer() {
		return questionSixteenAnswer;
	}

	public void setQuestionSixteenAnswer(String questionSixteenAnswer) {
		this.questionSixteenAnswer = questionSixteenAnswer;
	}

	public String getQuestionSeventeenAnswer() {
		return questionSeventeenAnswer;
	}

	public void setQuestionSeventeenAnswer(String questionSeventeenAnswer) {
		this.questionSeventeenAnswer = questionSeventeenAnswer;
	}

	public String getQuestionEighteenAnswer() {
		return questionEighteenAnswer;
	}

	public void setQuestionEighteenAnswer(String questionEighteenAnswer) {
		this.questionEighteenAnswer = questionEighteenAnswer;
	}

	public String getQuestionNineteenAnswer() {
		return questionNineteenAnswer;
	}

	public void setQuestionNineteenAnswer(String questionNineteenAnswer) {
		this.questionNineteenAnswer = questionNineteenAnswer;
	}

	public String getQuestionTwentyAnswer() {
		return questionTwentyAnswer;
	}

	public void setQuestionTwentyAnswer(String questionTwentyAnswer) {
		this.questionTwentyAnswer = questionTwentyAnswer;
	}

	public Date getDateForFirstComment() {
		return dateForFirstComment;
	}

	public void setDateForFirstComment(Date dateForFirstComment) {
		this.dateForFirstComment = dateForFirstComment;
	}

	public String getFirstComment() {
		return firstComment;
	}

	public void setFirstComment(String firstComment) {
		this.firstComment = firstComment;
	}

	public Date getDateForSecondComment() {
		return dateForSecondComment;
	}

	public void setDateForSecondComment(Date dateForSecondComment) {
		this.dateForSecondComment = dateForSecondComment;
	}

	public String getSecondComment() {
		return secondComment;
	}

	public void setSecondComment(String secondComment) {
		this.secondComment = secondComment;
	}

	public Date getDateForThirdComment() {
		return dateForThirdComment;
	}

	public void setDateForThirdComment(Date dateForThirdComment) {
		this.dateForThirdComment = dateForThirdComment;
	}

	public String getThirdComment() {
		return thirdComment;
	}

	public void setThirdComment(String thirdComment) {
		this.thirdComment = thirdComment;
	}

	public AuditEntry getAuditEntry() {
		return auditEntry;
	}

	public void setAuditEntry(AuditEntry auditEntry) {
		this.auditEntry = auditEntry;
	}

	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	public List<TripReportDetails> getDetails() {
		return details;
	}

	public void setDetails(List<TripReportDetails> details) {
		this.details = details;
	}
}
