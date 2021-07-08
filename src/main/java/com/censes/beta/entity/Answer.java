package com.censes.beta.entity;

import lombok.Data;

import java.util.Set;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Answer {

	@Column(name="answer_id")
	@Id
	@GeneratedValue( strategy= GenerationType.AUTO ) 
	private Long answerId;
	
	
	@ManyToOne
	@JoinColumn(name = "answer_type_id")
	private AnswerType answerType;
	
	@ManyToOne
	@JoinColumn(name="uuid")
	private User user;
	
	

	@JoinColumn(name="question_id")
	@ManyToOne
	private Question question;
}
