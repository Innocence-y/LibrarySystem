package com.nuc.library.bookinfo.service;

import com.nuc.library.book.dao.BookDao;
import com.nuc.library.bookinfo.dao.CountDao;
import com.nuc.library.bookinfo.dao.IBookInfoDaoImpl;
import com.nuc.library.bookinfo.entity.BookInfo;

import java.sql.SQLException;
import java.util.List;

public class IBookInfoImpl implements IBookInfo {

    static IBookInfoDaoImpl iBookInfoDao = new IBookInfoDaoImpl();
    static BookDao bookDao = new BookDao();
    static CountDao countDao = new CountDao();

    //--查询借阅信息
    @Override
    public List<BookInfo> getBookInfolist() throws SQLException {
        return iBookInfoDao.getBookInfo();
    }

    //--添加借阅信息
    @Override
    public void addBookInfo(String BookID,String username) throws SQLException {
        String time = iBookInfoDao.addBookInfo(BookID,username);
        bookDao.updateBookStatusToLend(BookID);
        countDao.updateTimeNumber(time);
    }

    //--删除学生借阅信息
    @Override
    public void deletestudentBookInfo(String SerialNumber) throws SQLException {
        iBookInfoDao.deleteBookInfo(SerialNumber);
    }

    //删除教师借阅信息
    @Override
    public void deleteteacherBookInfo(String SerialNumber) throws SQLException {
        iBookInfoDao.deleteBookInfo(SerialNumber);
    }

    @Override
    //--增加还书记录
    public void addReturnBookInfo(String SerialNumber,String BookID,String Grade,String username,String Time) throws SQLException {
        iBookInfoDao.addReturnBookInfo(BookID,Grade,username);
        bookDao.updateBookStatusToReturn(BookID);
        bookDao.updateBookGrade(BookID,iBookInfoDao.calAVG(BookID));
        iBookInfoDao.deleteBookInfo(SerialNumber);
        countDao.updateBookSortNumber(BookID);
        countDao.updateSexNumber(username);
        countDao.updateYearNumber(username);
        countDao.updateCollegeNumber(username);
    }

    //--查询所有还书记录
    @Override
    public List<BookInfo> getReturnBookInfolist() throws SQLException {
        return null;
    }

    //--查询学生借阅信息
    @Override
    public List<BookInfo> getStudentBookInfolist() throws SQLException {
        return iBookInfoDao.getStudentBookInfo();
    }

    //--查询教师借阅信息
    @Override
    public List<BookInfo> getTeacherBookInfolist() throws SQLException {
        return iBookInfoDao.getTeacherBookInfo();
    }

    //--查询个人借阅信息
    @Override
    public List<BookInfo> querypersonbookinfo(String username) throws SQLException {
        return iBookInfoDao.querypersonbookinfo(username);
    }

}
