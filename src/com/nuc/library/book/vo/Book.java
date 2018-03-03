package com.nuc.library.book.vo;

public class Book {
	private int  id;
	private String BookID;
	private String bookname;
	private String author;
	private String sort;
	private String grade;
	private String  status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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

	@Override
	public String toString() {
		return "Book{" +
				"id=" + id +
				", BookID='" + BookID + '\'' +
				", bookname='" + bookname + '\'' +
				", author='" + author + '\'' +
				", sort='" + sort + '\'' +
				", grade='" + grade + '\'' +
				", status='" + status + '\'' +
				'}';
	}
}
