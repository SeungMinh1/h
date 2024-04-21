package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BookService;
import com.yedam.service.BookServiceImpl;
import com.yedam.vo.BookVO;

public class BookAdd implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 도서등록후 retCode를 반환하도록 구현(json포맷) 성공일경우: Success, 실패일 경우 Fail.
		resp.setContentType("text/json;charset=utf-8");
		
		String code = req.getParameter("bookCode");
		String bookTitle = req.getParameter("bookTitle");
		String author = req.getParameter("author");
		String company = req.getParameter("company");
		String price= req.getParameter("price");
		int price2 = Integer.parseInt(price);
		
		BookVO bvo = new BookVO();
		bvo.setBookCode(code);
		bvo.setBookTitle(bookTitle);
		bvo.setAuthor(author);
		bvo.setCompany(company);
		bvo.setPrice(price2);
		
		BookService bsv = new BookServiceImpl();
		if(bsv.addBook(bvo)) {
			resp.getWriter().print("{\"retCode\" : \"Success\"}");
		}else {
			//{"retCode" : "Fail"}
			resp.getWriter().print("{\"retCode\" : \"Fail\"}");
		}


	}

}
