package com.nuc.library.bookinfo.entity;

public class BookInfo {

    private String SerialNumber;
    private String username;
    private String BookID;
    private String LendTime;

    public String getSerialNumber() {
        return SerialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        SerialNumber = serialNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBookID() {
        return BookID;
    }

    public void setBookID(String bookID) {
        BookID = bookID;
    }

    public String getLendTime() {
        return LendTime;
    }

    public void setLendTime(String lendTime) {
        LendTime = lendTime;
    }

    public BookInfo() {
    }

    public BookInfo(String serialNumber, String username, String bookID, String lendTime) {
        SerialNumber = serialNumber;
        this.username = username;
        BookID = bookID;
        LendTime = lendTime;
    }
}
