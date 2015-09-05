package com.iweb.dao;

import java.util.List;

import com.iweb.entity.Question;

public interface IQuestionDAO {
	/**
	 * get singlequestions
	 */
	public List<Question> single() throws Exception;
	
	/**
	 * get judgements
	 */
	public List<Question> judgement() throws Exception;
	
	/**
	 * add single questions
	 */
	public boolean addsingle(Question single) throws Exception;
	
	/**
	 * add judgement questions
	 */
	public boolean addjudgement(Question judgement) throws Exception;
	
	/**
	 * remove questions
	 */
	public boolean remove(int id) throws Exception;
}
