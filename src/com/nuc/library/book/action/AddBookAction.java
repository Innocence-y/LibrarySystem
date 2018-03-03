package com.nuc.library.book.action;
import com.nuc.library.book.service.BookService;
import com.nuc.library.book.vo.Book;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public  class AddBookAction extends ActionSupport implements ModelDriven<Book> {

  Book book = new Book();
  public Book getModel(){
	  return book;
  }

  public String addBook(){
	  BookService bookservice=new BookService();
	  bookservice.addBook(book);
	  return "addOk";
  }
}
