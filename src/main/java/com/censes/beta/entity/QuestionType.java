package com.censes.beta.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "question_type")
@Data
public class QuestionType {

	@Id
	@Column(name = "question_type_id")
	private int questionTypeId;
	@Column(name = "question_type_desc")
	private String questionTypeDesc;

}
