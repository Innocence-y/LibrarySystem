package com.nuc.library.book.service;

import com.nuc.library.book.vo.Book;

import java.util.List;

public interface BaseService {
	public void addBook(Book book);
	public void deleteBookById(String BookID);
	
	public void updateBookById(int id, Book book);

	public Book findById(int id);
	public List<Book> findByBookName(String bookname);

	public List<Book> findBySort(String sort);
	public List<Book> findAll() throws Exception;

	public List<Book> typeQuery(String query,String option) throws Exception;
}
