package com.nuc.library.bookinfo.service;

import com.nuc.library.bookinfo.entity.BookInfo;

import java.sql.SQLException;
import java.util.List;

public interface IBookInfo {

    //--查询借阅信息
    public List<BookInfo> getBookInfolist() throws SQLException;

    //--借书
    public void addBookInfo(String BookID,String username) throws SQLException;

    //删除学生借阅信息
    public void deletestudentBookInfo(String SerialNumber) throws SQLException;

    //删除教师借阅信息
    public void deleteteacherBookInfo(String SerialNumber) throws SQLException;

    //--还书
    public void addReturnBookInfo(String SerialNumber,String BookID,String Grade,String username,String Time) throws SQLException;

    //--查询还书信息
    public List<BookInfo> getReturnBookInfolist() throws SQLException;

    //--查询学生借阅信息
    public List<BookInfo> getStudentBookInfolist() throws SQLException;

    //--查询教师借阅信息
    public List<BookInfo> getTeacherBookInfolist() throws SQLException;

    //--查询个人借阅信息
    public List<BookInfo> querypersonbookinfo(String username) throws SQLException;

}
