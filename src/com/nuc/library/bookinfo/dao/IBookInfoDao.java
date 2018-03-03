package com.nuc.library.bookinfo.dao;

import com.nuc.library.bookinfo.entity.BookInfo;

import java.sql.SQLException;
import java.util.List;

public interface IBookInfoDao {

    public List<BookInfo> getBookInfo() throws SQLException;

    public String addBookInfo(String BookID,String username) throws SQLException;

    public void deleteBookInfo(String SerialNumber) throws SQLException;

    public void addReturnBookInfo(String BookID,String Grade,String username) throws SQLException;

    //--查询学生借阅信息
    public List<BookInfo> getStudentBookInfo() throws SQLException;

    //--查询教师借阅信息
    public List<BookInfo> getTeacherBookInfo() throws SQLException;

    //--查询个人借阅信息
    public List<BookInfo> querypersonbookinfo(String username) throws SQLException;

}
