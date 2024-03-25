package com.yedam.java.center;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.java.common.DAO;



public class CmemberDAO extends DAO {
	
	//싱글톤
	private static CmemberDAO cmemberDAO = null;
		
	private CmemberDAO() {}
	
	public static CmemberDAO getInstance() {
		if(cmemberDAO == null) {
			cmemberDAO = new CmemberDAO();
		}
		return cmemberDAO;
	}
	
	// 1) 등록
		public void insertCenterMember(CenterMember member) {
			try {
				// 1. DB와 연결
				connect();
				
				// 2. 객체 생성
				// 3. SQL 실행
				// 4. 결과처리
				String insert = "INSERT INTO center_member "
						+ "VALUES(?,?,?,?,?,?)";
		
				pstmt = conn.prepareStatement(insert);
				
				pstmt.setString(1, member.getId());
				pstmt.setString(2, member.getPwd());
				pstmt.setString(3, member.getName());
				pstmt.setString(4, member.getGender());
				pstmt.setDate(5, member.getBirthdate());
				pstmt.setString(6, member.getAddress());
				
				//  => 실제 쿼리문이 완성됨
				
				// 4. SQL 실행하기 - SELECT문
				
				int result = pstmt.executeUpdate();
				
				// 5. 결과값 처리하기
				
				System.out.println("Insert 결과 : " + result);
				// 5. 자원해제
				disconnect();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		// 2) 비밀번호 업데이트 변경     ---------- 아이디로 검색해서 비번/아이디/이름/주소 업데이트하기? 로추가
		public void updateMemberpwd(CenterMember member) {  // 비밀번호 변경
			try {
				// 1. DB와 연결
				connect();
				
				// 2. 객체 생성
				// 3. SQL 실행
				// 4. 결과처리
				String update = "UPDATE center_member "
						+ "SET pwd = ? "
						+ "WHERE id = ? ";
		
				pstmt = conn.prepareStatement(update);
				pstmt.setString(1, member.getPwd());
				pstmt.setString(2, member.getId());
				
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
		public void updateMemberid(CenterMember member) {  // 비밀번호 변경
			try {
				// 1. DB와 연결
				connect();
				
				// 2. 객체 생성
				// 3. SQL 실행
				// 4. 결과처리
				String update = "UPDATE center_member "
						+ "SET id = ? "
						+ "WHERE id = ? ";
		
				pstmt = conn.prepareStatement(update);
				pstmt.setString(1, member.getId());
				pstmt.setString(2, member.getId());
				
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
		public void updateMemberaddress(CenterMember member) {  // 비밀번호 변경
			try {
				// 1. DB와 연결
				connect();
				
				// 2. 객체 생성
				// 3. SQL 실행
				// 4. 결과처리
				String update = "UPDATE center_member "
						+ "SET address = ? "
						+ "WHERE id = ? ";
		
				pstmt = conn.prepareStatement(update);
				pstmt.setString(1, member.getAddress());
				pstmt.setString(2, member.getId());
				
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
		
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////
		// 3) 삭제
		public void deleteMember(String id) {
			
			try {
				// 1. DB와 연결
				connect();
				String delete = "DELETE FROM center_member "
						+ "WHERE id = '" + id + "'";

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
		// 4) 검색 -- 아이디를 통한 검색
		public CenterMember slectMember(String id) {
			CenterMember member = null;
			
			try {
				// 1. DB와 연결
				connect();
				
				String select = "SELECT * "
						+ "FROM center_member "
						+ "WHERE id = ? ";
				
				pstmt = conn.prepareStatement(select);
				pstmt.setString(1, id);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					member = new CenterMember();
					member.setId(rs.getString("id"));
					member.setPwd(rs.getString("pwd"));
					member.setName(rs.getString("name"));
					member.setGender(rs.getString("gender"));
					member.setBirthdate(rs.getDate("birthdate"));
					member.setAddress(rs.getString("address"));
				}
				
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				//자원해제
				disconnect();
			}
			return member;
		}
	
		// 5) 검색 전체검색
		public List<CenterMember> selectMemberALL() {
			List<CenterMember> list = new ArrayList<>();
			try {
				// 1. DB와 연결
				connect();
				
				stmt = conn.createStatement();
				
				String select = "SELECT * "
								+ "FROM center_member "
								+ "ORDER BY id" ;
				
				// 4. SQL 실행하기 - SELECT문
				
				rs = stmt.executeQuery(select);
				
				// 5. 결과값 처리하기
				while(rs.next()) {
					CenterMember member = new CenterMember();
					member.setId(rs.getString("id"));
					member.setPwd(rs.getString("pwd"));
					member.setName(rs.getString("name"));
					member.setGender(rs.getString("gender"));
					member.setBirthdate(rs.getDate("birthdate"));
					member.setAddress(rs.getString("address"));
					list.add(member);
				}
				
				
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				//자원해제
				disconnect();
			}
			return list;
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
