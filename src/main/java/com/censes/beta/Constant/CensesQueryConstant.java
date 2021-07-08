package com.censes.beta.Constant;

public class CensesQueryConstant {

	public static String valuation = "select sum(a.answer_type_value*b.question_weight)  from answer_type a , question b, answer a1 where \r\n"
			+ "a1.answer_type_id = a.answer_type_id and b.question_id = a1.question_id and a1.uuid=? and b.question_type_id =1\r\n"
			+ "\r\n"
			+ "union\r\n"
			+ "\r\n"
			+ "select sum(a.answer_type_value*b.question_weight)  from answer_type a , question b, answer a1 where \r\n"
			+ "a1.answer_type_id = a.answer_type_id and b.question_id = a1.question_id and a1.uuid =?  and b.question_type_id =2";
	
	public static String insertAnswer="INSERT INTO public.answer\r\n"
			+ "(answer_type_id, question_id, uuid)\r\n"
			+ "VALUES(?, ?, ?);\r\n"
			+ "";
	
	public static String getMaxansid = "select coalesce(max(answer_id),0) from answer";
}
