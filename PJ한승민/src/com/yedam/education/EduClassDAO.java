package com.yedam.education;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.java.common.DAO;

public class EduClassDAO extends DAO {
	
	//싱글톤
	private static EduClassDAO educlassDAO = null;
		
	public EduClassDAO() {}
	
	public static EduClassDAO getInstance() {
		if(educlassDAO == null) {
			educlassDAO = new EduClassDAO();
		}
		return educlassDAO;
	}
		
	// 1) 등록
	public void insertClass(EduClass eclass) {
		try {
			// 1. DB와 연결
			connect();
			
			// 2. 객체 생성
			// 3. SQL 실행
			// 4. 결과처리
			String insert = "insert into education_class (classNum, title, professor, max_num) "
					+ "VALUES(?,?,?,?) ";
	
			pstmt = conn.prepareStatement(insert);
			
			pstmt.setInt(1, eclass.getClassnum());
			pstmt.setString(2, eclass.getTitle());
			pstmt.setString(3, eclass.getProfessor());
			pstmt.setInt(4, eclass.getMaxNum());
			
			//  => 실제 쿼리문이 완성됨
			
			// 4. SQL 실행하기 - SELECT문
			
			int result = pstmt.executeUpdate();
			
			// 5. 결과값 처리하기
			
			System.out.println("Insert 결과 : " + result);
			// 5. 자원해제
			disconnect();
			
		}catch(SQLException e) {
			System.out.println("다른번호");//e.printStackTrace();
		}
	}

	// 2)  업데이트 변경   
	public void updateMemberprof(EduClass eclass) {  // 교수변경
		try {
			// 1. DB와 연결
			connect();
			
			// 2. 객체 생성
			// 3. SQL 실행
			// 4. 결과처리
			String update = "UPDATE education_class "
					+ "SET professor = ? "
					+ "WHERE classNum = ? ";
	
			pstmt = conn.prepareStatement(update);
			pstmt.setString(1, eclass.getProfessor());
			pstmt.setInt(2, eclass.getClassnum());
			
			// 4. SQL 실행하기 - SELECT문
			
			int result = pstmt.executeUpdate();
			
			// 5. 결과값 처리하기
			
			System.out.println("UPDATE결과 : " + result);
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			//5.자원해제
			disconnect();
		}
	}
	///////////////// max_num  업데이트 변경
	public void updateMembermaxNum(EduClass eclass) {  
		try {
			// 1. DB와 연결
			connect();
			
			// 2. 객체 생성
			// 3. SQL 실행
			// 4. 결과처리
			String update = "UPDATE education_class "
					+ "SET max_num = ? "
					+ "WHERE classNum = ? ";
	
			pstmt = conn.prepareStatement(update);
			pstmt.setInt(1, eclass.getMaxNum());
			pstmt.setInt(2, eclass.getClassnum());
			
			// 4. SQL 실행하기 - SELECT문
			
			int result = pstmt.executeUpdate();
			
			// 5. 결과값 처리하기
			
			System.out.println("UPDATE결과 : " + result);
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			//5.자원해제
			disconnect();
		}
	}
	///////////////// title 업데이트 변경
	public void updateMemberTitle(EduClass eclass) {  
		try {
			// 1. DB와 연결
			connect();
			
			// 2. 객체 생성
			// 3. SQL 실행
			// 4. 결과처리
			String update = "UPDATE education_class "
					+ "SET title = ? "
					+ "WHERE classNum = ? ";
	
			pstmt = conn.prepareStatement(update);
			pstmt.setString(1, eclass.getTitle());
			pstmt.setInt(2, eclass.getClassnum());
			
			// 4. SQL 실행하기 - SELECT문
			
			int result = pstmt.executeUpdate();
			
			// 5. 결과값 처리하기
			
			System.out.println("UPDATE결과 : " + result);
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			//5.자원해제
			disconnect();
		}
	}
	
	
	// 3) 삭제
	public void deleteEclass(int classNum) {
		
		try {
			// 1. DB와 연결
			connect();
			String delete = "DELETE FROM education_class "
					+ "WHERE classNum = " + classNum ;

			stmt = conn.createStatement();
			
			// 4. SQL 실행하기 - SELECT문
			int result = stmt.executeUpdate(delete);
			
			// 5. 결과값 처리하기
			System.out.println("Delete 결과 : " + result);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			//자원해제
			disconnect();
		}
	}
	
	// 4) 강좌 이름 검색
	public List<EduClass> selectClassTitle(String title) {
		List<EduClass> list = new ArrayList<>();
		try {
			// 1. DB와 연결
			connect();
		
			stmt = conn.createStatement();
			String select = "SELECT * "
							+ "FROM education_class "
							+ "WHERE title = '" + title +"'" 
							+ "ORDER BY classNum" ;
			

			
			// 4. SQL 실행하기 - SELECT문
			
			rs = stmt.executeQuery(select);
			
			// 5. 결과값 처리하기
			while(rs.next()) {
				EduClass eclass = new EduClass();
				eclass.setClassnum(rs.getInt("classNum"));
				eclass.setTitle(rs.getString("title"));
				eclass.setProfessor(rs.getString("professor"));
				eclass.setMaxNum(rs.getInt("max_num"));
				eclass.setCurrentNum(rs.getInt("current_num"));
				list.add(eclass);
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			//자원해제
			disconnect();
		}
		return list;
	}
	
	// 5) 전체 강좌 검색
	public List<EduClass> selectClassALL() {
		List<EduClass> list = new ArrayList<>();
		try {
			// 1. DB와 연결
			connect();
		
			stmt = conn.createStatement();
			String select = "SELECT * "
							+ "FROM education_class "
							+ "ORDER BY classNum" ;
			

			// 4. SQL 실행하기 - SELECT문
			
			rs = stmt.executeQuery(select);
			
			// 5. 결과값 처리하기
			while(rs.next()) {
				EduClass eclass = new EduClass();
				eclass.setClassnum(rs.getInt("classNum"));
				eclass.setTitle(rs.getString("title"));
				eclass.setProfessor(rs.getString("professor"));
				eclass.setMaxNum(rs.getInt("max_num"));
				eclass.setCurrentNum(rs.getInt("current_num"));
				list.add(eclass);
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			//자원해제
			disconnect();
		}
		return list;
	}
	
	
	// 4) 강좌 번호 검색
	public EduClass selectClassNum(int num) {
		EduClass eclass = new EduClass();
		try {
			// 1. DB와 연결
			connect();
		
			
			String select = "SELECT * "
							+ "FROM education_class "
							+ "WHERE classNum = ? " ;
			
			pstmt = conn.prepareStatement(select);
			pstmt.setInt(1, num);
			
			// 4. SQL 실행하기 - SELECT문
			
			rs = pstmt.executeQuery(select);
			
			// 5. 결과값 처리하기
			if(rs.next()) {
				eclass = new EduClass();
				eclass.setClassnum(rs.getInt("classNum"));
				eclass.setTitle(rs.getString("title"));
				eclass.setProfessor(rs.getString("professor"));
				eclass.setMaxNum(rs.getInt("max_num"));
				eclass.setCurrentNum(rs.getInt("current_num"));
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			//자원해제
			disconnect();
		}
		return eclass;
	}
	
	
		
		
	
	

}