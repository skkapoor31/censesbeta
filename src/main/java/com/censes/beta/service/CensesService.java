package com.censes.beta.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.censes.beta.DTO.AnswerDTO;
import com.censes.beta.DTO.UserDTO;
import com.censes.beta.DTO.ValuationResponseDTO;


public interface CensesService {
	
	UserDTO getValuation(Long uuid);
	
	void saveAnswer(List<AnswerDTO> ans, Long uuid);

	Long saveUser(UserDTO userDet);

}
