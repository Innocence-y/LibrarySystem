package com.nuc.library.book.action;

import com.nuc.library.book.service.BookService;
import com.nuc.library.book.vo.Book;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;


public class FindBookAction extends ActionSupport {
	
	private List<Book> booklist=null;
	
	public List<Book> getBooklist() {
		return booklist;
	}

	public void setBooklist(List<Book> booklist) {
		this.booklist = booklist;
	}

	public String findAll() throws Exception{
		BookService bookService = new BookService();
		booklist = bookService.findAll();
		return "findOk";
	}

}
