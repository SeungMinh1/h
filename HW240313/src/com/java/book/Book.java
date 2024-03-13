package com.java.book;

public class Book {
	//필드
	private String bookNum;  //도서번호
	private String bookName;  //도서제목
	private String bookAuthor;  //도서저자
	private String bookDate;  //출판일자
	private String bookIntro;  //도서소개
	
	
	//생성자
	public Book() {}
	
	public Book(String bookNum, String bookName, String bookAuthor, String bookDate, String bookIntro) {
		this.bookNum = bookNum;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookDate = bookDate;
		this.bookIntro = bookIntro;
	}
	//  getter/setter
	public String getBookNum() {
		return bookNum;
	}
	public void setBookNum(String bookNum) {
		this.bookNum = bookNum;
	}
	
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	
	public String getBookDate() {
		return bookDate;
	}
	public void setBookDate(String bookDate) {
		this.bookDate = bookDate;
	}
	
	public String getBookIntro() {
		return bookIntro;
	}
	public void setBookIntro(String bookIntro) {
		this.bookIntro = bookIntro;
	}
	
	public String getBookInfomation() {
		return bookNum +" "+  bookName + " " +  bookAuthor+" "+ bookDate+" "+ bookIntro;
	}

}
