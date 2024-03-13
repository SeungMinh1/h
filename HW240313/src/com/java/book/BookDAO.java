package com.java.book;

import java.util.ArrayList;
import java.util.List;

public class BookDAO {
	
	private List<Book> bookList;
		
		//생성자
		public BookDAO() {
			this.bookList = new ArrayList<>();
		}
		
		//메소드
		
		//등록
		
		public void addBook(String bookNum, String bookName, String bookAuthor, String bookDate, String bookIntro) {
			Book book = new Book(bookNum, bookName, bookAuthor, bookDate, bookIntro);
			bookList.add(book);	
		}
		
		public void addBook(Book book) {
			bookList.add(book);
		}
		
		//수정 (수정대상 - 도서소개)
		public void updateBook(String bookNum, String bookIntro) {
			for(int i=0; i<bookList.size(); i++) {
				Book selectBook = bookList.get(i);
				if(bookNum.equals(selectBook.getBookNum())) {
					selectBook.setBookIntro(bookIntro);
				}
			}
		}
		
		//삭제
		public void delBook(String bookNum) {
			for(int i=0; i<bookList.size(); i++) {
				Book selectBook = bookList.get(i);
				if(bookNum.equals(selectBook.getBookNum())) {
					bookList.remove(i);
				}
			}
		}
		
		//단건조회
		public Book getBook(String bookNum) {
			Book selected = null;
			for(Book book : bookList) {
				if(bookNum.equals(book.getBookNum())) {
					selected = book;
				}
			}
			return selected;
		}
		
		//전체조회
		public void printAllBook() {
			for(Book book : bookList) {
				System.out.println(book.getBookInfomation());
			}
		}
		

}
