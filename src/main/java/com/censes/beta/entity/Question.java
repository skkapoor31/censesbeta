package com.censes.beta.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import lombok.Data;

@Data
@Entity
public class Question {

	@Id
	@Column(name = "question_id")
	private int questionId;
	@Column(name="question_desc")
	private String questionDesc;
	@Column(name = "question_weight")
	private float questionWeight;
	
	@JoinColumn(name = "question_type_id")
	@ManyToOne
	private QuestionType qtype;
	
}

