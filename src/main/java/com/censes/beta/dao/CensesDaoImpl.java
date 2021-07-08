package com.censes.beta.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.censes.beta.Constant.CensesQueryConstant;
import com.censes.beta.DTO.AnswerDTO;


@Repository
public class CensesDaoImpl implements CensesDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@SuppressWarnings("deprecation")
	public String getValuation(Long uuid) {
		
		List<Object> res = jdbcTemplate.queryForList(CensesQueryConstant.valuation, new Object[]{uuid,uuid}, Object.class);
		
		return res.toString();
	}

	@Override
	public void saveAnswer(List<AnswerDTO> ans, Long uuid) {
		// TODO Auto-generated method stub
		batchInsert(ans, uuid);
	}
	
	
	 public int[] batchInsert(List<AnswerDTO> ans, Long uuid) {
		 
		// int answerId = jdbcTemplate.queryForObject(CensesQueryConstant.getMaxansid, Integer.class);

	        return this.jdbcTemplate.batchUpdate(
	            CensesQueryConstant.insertAnswer,
	            new BatchPreparedStatementSetter() {

	                public void setValues(PreparedStatement ps, int i) throws SQLException {
	                	//ps.setInt(1, answerId+i+1);
	                    ps.setInt(1, ans.get(i).getAnswerTypeId());
	                    ps.setInt(2, ans.get(i).getQuestionId());
	                    ps.setLong(3, uuid);
	                    
	                }

	                public int getBatchSize() {
	                    return ans.size();
	                }

	            });
	    }

	
}
