package com.censes.beta.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "Answer_type")
public class AnswerType {
	
	@Id
	@Column(name="answer_type_id")
	private int answerTypeId;
	@Column(name="answer_type_value")
	private float answerTypeValue;
	

}
