package com.yedam.board;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.yedam.java.app.LoginControl;

public class BoardMng {
	
	private Scanner sc = new Scanner(System.in);
	private BoardDAO boardDAO= BoardDAO.getInstance();
	
	public void run() {
		
		while(true) {
			menuPrint();
			
			int menuNo = menuSelect();
			
			if(menuNo == 1) {
				System.out.println("게시글 작성");
				insertBoard();
			}if(menuNo == 2) {
				System.out.println("게시글 삭제하기");
				updatePrint1();
			}if(menuNo == 3) {
				System.out.println("게시글 삭제하기");
				deleteBoard();
			}if(menuNo == 4) {
				System.out.println("게시글 조회하기");
				selectBoardlistALL();
				System.out.println(selectBoard1());
			}if(menuNo == 5) {
				selectBoardlistALL();
			}if(menuNo == 9) {
				break;
			}else {
				System.out.println("메뉴에서 선택하세요");
			}
		}
		end();
			
	}
	
	private void menuPrint() {
		String menu = "";
		menu += "1.게시글 등록하기 ";
		menu += "2.게시글 수정하기 ";
		menu += "3.게시글 삭제하기 ";
		menu += "4.게시글 조회하기 ";
		menu += "5.게시글 목록조회 ";
		menu += "9.종료 ";
		System.out.println("===========================================================");
		System.out.println(menu);
		System.out.println("===========================================================");
	}
	
	private int menuSelect() {
		int menuNo = 0;
		try {
			System.out.print("메뉴선택>> ");
			menuNo = sc.nextInt();
		}catch(NumberFormatException e) {
			System.out.println("숫자를 입력하세요.");
		}
		return menuNo;
	}
	
	
	private void end() {
		System.out.println("이전메뉴로 돌아갑니다.");
	}
	
	private void insertBoard() {
		Board board = inputAll();
		boardDAO.insertBoard(board);
	}
	
	private Board inputAll() {
		LocalDateTime now = LocalDateTime.now();
		Board board = new Board();
		System.out.print("게시글 제목>>");
		board.setBoardTitle(sc.next());
		board.setMemberId(LoginControl.getLoginInfo().getId());
		System.out.print("게시글 내용>> ");
		board.setContent(sc.next());
		board.setWriteDate(Date.valueOf(now.format(DateTimeFormatter.ofPattern("yyyy/MM/dd") )));

		
		return board;
	}
	
	private Board selectBoard1() {
		String title = titleSelect();
		Board board = boardDAO.slectBoard(title);
		//System.out.println(eclass);
		return board;
		
	}
	
	
	private void selectBoardlistALL(){
		List<Board> list = boardDAO.selectBoardAll();
		for(Board data : list) {
			System.out.println(data);
		}
	}
	
	private String titleSelect() {
		String boardTitle = null;
		try {
			System.out.print("게시글 제목>> ");
			boardTitle = sc.next();
		}catch(NumberFormatException e) {
			System.out.println("올바른 제목을 입력하세요.");
		}
		return boardTitle;
	}
	
	private String changeContent() {
		String boardTitle = null;
		try {
			System.out.print("변경할 내용>> ");
			boardTitle = sc.next();
		}catch(NumberFormatException e) {
			System.out.println("올바른 제목을 입력하세요.");
		}
		return boardTitle;
	}
	
	
	private void deleteBoard() {
		String title = titleSelect();
		boardDAO.deleteBoard(title);
	}
	
	
	private void updatePrint1() {  // 게시글 content 수정
		String title = titleSelect();
		Board board = boardDAO.slectBoard(title);    
		
		if(board == null) {
			System.out.println("없는 정보입니다.");
		}else {
			System.out.println(board); 
			String changeContent = changeContent();
			board.setContent(changeContent);
			boardDAO.updateCont(board);
			System.out.println("수정되었습니다.");
		}
	}
	
	

}
