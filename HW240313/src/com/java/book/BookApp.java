package com.java.book;

import java.util.Scanner;

public class BookApp {

	public static void main(String[] args) {
		boolean run = true;
		Scanner sc = new Scanner(System.in);
		BookDAO bo = new BookDAO();
		
		while(run) {
			System.out.println("======================================");
			System.out.println(" 1.등록 | 2.목록 | 3.수정 | 4.삭제 | 5.종료");
			System.out.println("======================================");
			System.out.print("메뉴선택 > ");
			int menu = Integer.parseInt(sc.nextLine());
			
			if(menu ==1) {  //등록
				System.out.println("====게시글 등록 ====");
				System.out.print("도서번호 > ");
				String bookNum = sc.nextLine();
				System.out.print("도서제목 > ");
				String bookName = sc.nextLine();
				System.out.print("도서저자 > ");
				String bookAuthor = sc.nextLine();
				System.out.print("출판일자 > ");
				String bookDate = sc.nextLine();
				System.out.print("도서소개 > ");
				String bookIntro = sc.nextLine();
				
				Book book = new Book(bookNum, bookName, bookAuthor, bookDate, bookIntro);
				bo.addBook(book);
				
			}else if(menu ==2) { //목록
				System.out.println("====익명 게시판 ====");
				bo.printAllBook();
				
			}else if(menu ==3) { //수정
				
				System.out.println("====수정 정보 입력 ====");
				System.out.print("수정할 도서번호 > ");
				String bookNum = sc.nextLine();
				
				Book book = bo.getBook(bookNum);
				System.out.println(book.getBookInfomation());
				System.out.print("수정할 내용 > ");
				String bookIntro = sc.nextLine();
				bo.updateBook(bookNum, bookIntro);
				
			}else if(menu ==4) { //삭제
				System.out.println("====삭제 정보 입력 ====");
				System.out.print("삭제할 도서번호 > ");
				String bookNum = sc.nextLine();
				bo.delBook(bookNum);
				
			}else if(menu ==5) {
				run = false;
			}else {
				System.out.println("메뉴를 잘못 입력했습니다.");
			}
		
		System.out.println("프로그램을 종료합니다.");
			
		}

	}

}
