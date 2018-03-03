package com.nuc.library.book.action;

import com.opensymphony.xwork2.ActionSupport;

public class LendBookAction extends ActionSupport {

    String BookID;

    public String getBookID() {
        return BookID;
    }

    public void setBookID(String bookID) {
        BookID = bookID;
    }

    public String lendbook(){
        return "lendbook";
    }

}
