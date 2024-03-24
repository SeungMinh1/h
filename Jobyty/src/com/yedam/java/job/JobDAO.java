package com.yedam.java.job;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JobDAO {
	
	//Oracle 연결정보
	String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
	String oracleUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	String connectedId = "hr";
	String connectedPwd = "hr";
	
	//전역필드
	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet  rs = null;
	
	//싱글톤
	private static JobDAO jobDAO = null;
	
	private JobDAO() {};
	
	public static JobDAO getInstance() {
		if(jobDAO == null) {
			jobDAO = new JobDAO();
		}
		return jobDAO;
	}
	
	
	//메소드 시작
	
	private void connect() {
		try {
			// JDBC연결
			Class.forName(jdbc_driver);
			
			conn = DriverManager.getConnection(oracleUrl, connectedId, connectedPwd);
			
			
		}catch(ClassNotFoundException e) {
			System.out.println("JDBC Driver Loading Fail");
		}catch(SQLException e) {
			System.out.println("DB Connect Fail");
			System.out.println(e.getMessage());
		}
		
	}
	
	private void disconnect() {
		
		try {
			//자원해제
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public List<Empjob> selectJobALL(){
		List<Empjob> list = new ArrayList<>();
		
		try {
			//DB연결
			connect();
			
			stmt = conn.createStatement();
			
			//실행할 sql문
			String select = "SELECT * "
					+ "FROM jobs "
					+ "ORDER BY job_id";
			
			
			rs = stmt.executeQuery(select);
			
			while(rs.next()) {
				
				Empjob job = new Empjob();
				
				job.setJobid(rs.getString("job_id"));
				job.setJobtitle(rs.getString("job_title"));
				job.setMinsalary(rs.getInt("min_salary"));
				job.setMaxsalary(rs.getInt("max_salary"));
				
				list.add(job);
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			
			//자원해제
			disconnect();
		}
		
		
		return list;
	}
	
	
	public Empjob selectJobInfo(int minsalary) {
		Empjob job = null;
		try {
			//연결
			connect();
			
			String select = "SELECT * "
					+ "FROM jobs "
					+ "WHERE min_salary =  ?  ";
			
			pstmt = conn.prepareStatement(select);
			pstmt.setInt(1, minsalary);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				job = new Empjob();
				job.setJobid(rs.getString("job_id"));
				job.setJobtitle(rs.getString("job_title"));
				job.setMinsalary(rs.getInt("min_salary"));
				job.setMaxsalary(rs.getInt("max_salary"));
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			//자원해제
			disconnect();
		}
		return job;
		
	}
	
	
	public Empjob selectJobInfoID(String id) {  //String 검색
		Empjob job = null;
		try {
			//연결
			connect();
			
			String select = "SELECT * "
					+ "FROM jobs "
					+ "WHERE job_id =  ? ";
			
			pstmt = conn.prepareStatement(select);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				job = new Empjob();
				job.setJobid(rs.getString("job_id"));
				job.setJobtitle(rs.getString("job_title"));
				job.setMinsalary(rs.getInt("min_salary"));
				job.setMaxsalary(rs.getInt("max_salary"));
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			//자원해제
			disconnect();
		}
		return job;
		
	}
	public List<Empjob> selectJobInfoIDALL(String id) {
		List<Empjob> list = new ArrayList<>();
		try {
			//연결
			connect();
			
			String select = "SELECT * "
					+ "FROM jobs "
					+ "WHERE job_id LIKE  ? ";
			
			pstmt = conn.prepareStatement(select);
			pstmt.setString(1, (id + '%'));
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Empjob job = new Empjob();
				
				job.setJobid(rs.getString("job_id"));
				job.setJobtitle(rs.getString("job_title"));
				job.setMinsalary(rs.getInt("min_salary"));
				job.setMaxsalary(rs.getInt("max_salary"));
				
				list.add(job);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			//자원해제
			disconnect();
		}
		return list;
		
	}
	
	
	public void insertJobinfo(Empjob job) {        ///등록
		
		try {
			//DB연결
			connect();
			
			String insert = "INSERT INTO jobs "
							+ "values(?, ?, ?, ?) ";
			
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, job.getJobid());
			pstmt.setString(2, job.getJobtitle());
			pstmt.setInt(3, job.getMinsalary());
			pstmt.setInt(4, job.getMaxsalary());
			
			int result = pstmt.executeUpdate();
			System.out.println("INSERT 결과 : " + result);
			
			//자원해제
			disconnect();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
