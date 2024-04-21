package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BookService;
import com.yedam.service.BookServiceImpl;

public class BookRemove implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 도서삭제후 retCode를 반환하도록 구현(json포맷) 성공일경우: Success, 실패일 경우 Fail.
		resp.setContentType("text/json;charset=utf-8");
		
		String bookCode = req.getParameter("bookCode");
		
		BookService bsv = new BookServiceImpl();
		if(bsv.removeBook(bookCode)) {
			resp.getWriter().print("{\"retCode\" : \"Success\"}");
		}else {
			resp.getWriter().print("{\"retCode\" : \"Fail\"}");
		}
		
	}

}
