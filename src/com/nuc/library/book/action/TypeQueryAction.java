package com.nuc.library.book.action;

import com.nuc.library.book.service.BookService;
import com.nuc.library.book.vo.Book;

import java.util.ArrayList;
import java.util.List;

public class TypeQueryAction {

    List<Book> booklist = new ArrayList<>();

    public List<Book> getBooklist() {
        return booklist;
    }

    public void setBooklist(List<Book> booklist) {
        this.booklist = booklist;
    }

    private String Query;
    private String Option;

    public String getQuery() {
        return Query;
    }

    public void setQuery(String query) {
        Query = query;
    }

    public String getOption() {
        return Option;
    }

    public void setOption(String option) {
        Option = option;
    }

    public String typeQueryaction() throws Exception {
        if(Query.toString().equals("ALL") && Option.toString().equals("ALL")){
            return "findall";
        }
        BookService bookservice = new BookService();
        booklist = bookservice.typeQuery(Query,Option);
        return "typeQuery";
    }
}
