package com.nuc.library.book.action;

import com.nuc.library.book.service.BookService;
import com.nuc.library.book.vo.Book;
import com.opensymphony.xwork2.ActionSupport;


public class UpdateBookAction extends ActionSupport {
	private String BookID;

	public String getBookID() {
		return BookID;
	}

	public void setBookID(String bookID) {
		BookID = bookID;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private String bookname;
	private String author;
	private String sort;
	private String grade;
	private String status;
	String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String updateBookById() {
		Book book = new Book();
		book.setAuthor(author);
		book.setBookID(BookID);
		book.setBookname(bookname);
		book.setGrade(grade);
		book.setSort(sort);
		book.setStatus(status);
		BookService bookservice = new BookService();
		bookservice.updateBookById(Integer.parseInt(id), book);
		return "updateByIdOk";
	}
}
