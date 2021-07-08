package com.censes.beta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.censes.beta.DTO.AnswerDTO;
import com.censes.beta.DTO.UserDTO;
import com.censes.beta.DTO.ValuationResponseDTO;
import com.censes.beta.service.CensesService;

@RestController
@RequestMapping("/censes/v1")
public class CensesController {
	
	@Autowired
	CensesService censesService;
	
	@GetMapping("/testing")
	public String healthCheck() {
		return "Working fine for now";
	}

	@PostMapping("/saveUserDet")
	public Integer saveUserDetails(@RequestBody UserDTO userDet) {
		Integer uuid =Integer.parseInt(censesService.saveUser(userDet).toString());
		return uuid;
	}
	
	@PostMapping("/valuation/{uuid}")
	public UserDTO getMemberValuation(@RequestBody
			List<AnswerDTO> answerDto,@PathVariable("uuid") String uuid) {
		
		censesService.saveAnswer(answerDto, Long.parseLong(uuid));
		
		return censesService.getValuation(Long.parseLong(uuid));
	}

	
}
