package com.censes.beta.dao;

import java.util.List;

import com.censes.beta.DTO.AnswerDTO;

public interface CensesDao {

	String getValuation(Long uuid);
	void saveAnswer(List<AnswerDTO> ans, Long uuid);

}
