package com.nuc.library.book.service;

import com.nuc.library.book.dao.BookDao;
import com.nuc.library.book.vo.Book;

import java.util.ArrayList;
import java.util.List;

public  class BookService implements BaseService{
	
	@Override
	public void addBook(Book book) {
		// TODO Auto-generated method stub
		BookDao dao=new BookDao();
		dao.addBook(book);
	}

	@Override
	public void deleteBookById(String BookID) {
		BookDao dao=new BookDao();
		dao.deleteBookById(BookID);
	}

	@Override
	public void updateBookById(int id,Book book) {
		// TODO Auto-generated method stub
		BookDao dao=new BookDao();
		dao.updateBookById(id,book);
		
	}

	@Override
	public Book findById(int id) {
		// TODO Auto-generated method stub
		BookDao dao=new BookDao();
		Book book=new Book();
		book=dao.findById(id);
		return book;
	}

	@Override
	public List<Book> findByBookName(String bookname) {
		// TODO Auto-generated method stub
		BookDao dao=new BookDao();
		List<Book> booklist = new ArrayList<Book>();
		booklist=dao.findByBookName(bookname);
		return booklist;
	
	}

	
	@Override
	public List<Book> findBySort(String sort) {
		// TODO Auto-generated method stub
		BookDao dao=new BookDao();
		List<Book> booklist = new ArrayList<Book>();
		booklist=dao.findBySort(sort);
		return booklist;	
		}

	@Override
	public List<Book> findAll() throws Exception {
		BookDao dao=new BookDao();
		List<Book> booklist = new ArrayList<Book>();
		booklist = dao.findAll();
		return booklist;
	}

	//--分类查询
	@Override
	public List<Book> typeQuery(String query,String option) throws Exception {
		BookDao dao=new BookDao();
		List<Book> booklist = new ArrayList<Book>();
		booklist=dao.typeQuery(query,option);
		return booklist;
	}

	public static void main(String[] args) throws Exception {
		List<Book> book=new ArrayList<>();
		BookService booklist=new BookService();
		book=booklist.typeQuery("sort","编程");
		System.out.println(book);
	}

}
