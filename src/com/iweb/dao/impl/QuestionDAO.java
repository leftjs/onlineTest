package com.iweb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;







import com.iweb.dao.IQuestionDAO;
import com.iweb.entity.Question;

public class QuestionDAO extends BaseDAO implements IQuestionDAO {

	@Override
	public List<Question> single() throws Exception {
		List<Question> questions = new ArrayList<Question>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		try{
			conn = getConn();
			pstmt = conn.prepareStatement("select * from  QUESTION_SINGLE order by rand()");
			rs = pstmt.executeQuery();
			while(rs.next()){
				questions.add(new Question(rs.getInt("id"),
						rs.getString("question"),
						new String[]{rs.getString("A"),rs.getString("B"),rs.getString("C"),rs.getString("D")},
						rs.getString("answer")
						) );
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rs,pstmt,conn);
		}
		return questions;
	}

	@Override
	public List<Question> judgement() throws Exception {
		List<Question> questions = new ArrayList<Question>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		try{
			conn = getConn();
			pstmt = conn.prepareStatement("select * from QUESTION_JUDGMENT order by rand()");
			rs = pstmt.executeQuery();
			while(rs.next()){
				questions.add(new Question(rs.getInt("id"),
						rs.getString("question"),
						rs.getString("answer")
						) );
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rs,pstmt,conn);
		}
		return questions;
	}
	
	@Override
	public boolean remove(int id) throws Exception { 
		if(true)return true;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = getConn();
			pstmt = conn.prepareStatement("delete from QUESTION_SINGLE where id=?");
			pstmt.setInt(1, id);
			return pstmt.executeUpdate() > 0 ? true :false;			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(null, pstmt, conn);
		}
		return false;

	}

	@Override
	public boolean addsingle(Question single) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = getConn();
			pstmt = conn.prepareStatement("insert into QUESTION_SINGLE(question,A,B,C,D,answer)values(?,?,?,?,?,?)");

			pstmt.setString(1, single.getQuestion());
			pstmt.setString(2, single.getCheck()[0]);
			pstmt.setString(3, single.getCheck()[1]);
			pstmt.setString(4, single.getCheck()[2]);
			pstmt.setString(5, single.getCheck()[3]);
			//pstmt.setString(6, single.getCheck()[4]);
			pstmt.setString(6, single.getAnswer());
			
			return pstmt.executeUpdate() > 0 ? true:false;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close( null,pstmt,conn);
		}
		return false;
	}

	@Override
	public boolean addjudgement(Question judgement) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = getConn();
			pstmt = conn.prepareStatement("insert into QUESTION_JUDGMENT(question,answer)values(?,?)");
			pstmt.setString(1, judgement.getQuestion());
			pstmt.setString(2, judgement.getAnswer());
			
			return pstmt.executeUpdate() > 0 ? true:false;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close( null,pstmt,conn);
		}
		return false;
	}
}
