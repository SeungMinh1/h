package com.yedam.board;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.java.center.CenterMember;
import com.yedam.java.common.DAO;

public class BoardDAO extends DAO {
	
	//싱글톤
	private static BoardDAO boardDAO = null;
		
	private BoardDAO() {}
	
	public static BoardDAO getInstance() {
		if(boardDAO == null) {
			boardDAO = new BoardDAO();
		}
		return boardDAO;
	}
	
	//enrol.setMemberId(LoginControl.getLoginInfo().getId());
	
	// 1) 등록
	public void insertBoard(Board board) {
		try {
			// 1. DB와 연결
			connect();
			
			// 2. 객체 생성
			// 3. SQL 실행
			// 4. 결과처리
			String insert = "INSERT into boardVO (board_title, member_id, content, write_date)  "
					+ "VALUES(?,?,?,?) " ;
	
			pstmt = conn.prepareStatement(insert);
			
			pstmt.setString(1, board.getBoardTitle());
			pstmt.setString(2, board.getMemberId());
			pstmt.setString(3, board.getContent());
			pstmt.setDate(4, board.getWriteDate());
			
			int result = pstmt.executeUpdate();
			
			//  결과값 처리하기
			
			System.out.println("Insert 결과 : " + result);
			// 5. 자원해제
			disconnect();
			
		}catch(SQLException e) {
			System.out.println("이미 존재하는 아이디 입니다.");//e.printStackTrace();
		}
	}
	
	
	//  업데이트 변경    
	public void updateCont(Board board) {  // content 변경
		try {
			// 1. DB와 연결
			connect();
			
			String update = "UPDATE boardVO "
					+ "SET content = ? "
					+ "WHERE member_id = ? " 
					+ "AND board_title = ? ";
	
			pstmt = conn.prepareStatement(update);
			pstmt.setString(1, board.getContent());
			pstmt.setString(2, board.getMemberId());
			pstmt.setString(2, board.getBoardTitle());
			
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
	
	public void deleteBoard(String board_title) { //삭제
		
		try {
			// 1. DB와 연결
			connect();
			String delete = "DELETE FROM boardVO "
					+ "WHERE board_title = '" + board_title + "'";

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
	
	public Board slectBoard(String board_title) {  //조회
		Board board = null;
		
		try {
			// 1. DB와 연결
			connect();
			
			String select = "SELECT * "
					+ "FROM boardVO "
					+ "WHERE board_title = ? ";
			
			pstmt = conn.prepareStatement(select);
			pstmt.setString(1, board_title);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				board = new Board();
				board.setBoardTitle(rs.getString("board_title"));
				board.setMemberId(rs.getString("member_id"));
				board.setContent(rs.getString("content"));
				board.setWriteDate(rs.getDate("write_date"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			//자원해제
			disconnect();
		}
		return board;
	}
	
	// 5) 검색 전체검색
	public List<Board> selectBoardAll() {
		List<Board> list = new ArrayList<>();
		try {
			// 1. DB와 연결
			connect();
			
			stmt = conn.createStatement();
			
			String select = "SELECT board_title, member_id, write_date "
							+ "FROM boardVO "
							+ "ORDER BY write_date " ;
			
			// 4. SQL 실행하기 - SELECT문
			
			rs = stmt.executeQuery(select);
			
			// 5. 결과값 처리하기
			while(rs.next()) {
				Board board = new Board();
				board.setBoardTitle(rs.getString("board_title"));
				board.setMemberId(rs.getString("member_id"));
				//board.setContent(rs.getString("content"));
				board.setWriteDate(rs.getDate("write_date"));

				list.add(board);
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
