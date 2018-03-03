package com.nuc.library.bookinfo.dao;

import com.nuc.library.bookinfo.entity.BookInfo;
import com.nuc.library.bookinfo.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class IBookInfoDaoImpl implements IBookInfoDao {

    static Connection conn;

    static {
        try {
            conn = DBUtil.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static String getTime(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(date);
        return time;
    }

    static String getSerialNumber(String BookID){
        Date date = new Date();
        Random random = new Random();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String time1 = sdf.format(date);
        String serialNumber = time1 + BookID + random.nextInt(9) + random.nextInt(9);
        return serialNumber;
    }

    //查询借书信息
    @Override
    public List<BookInfo> getBookInfo() throws SQLException {
        List<BookInfo> bookInfoList = new ArrayList<BookInfo>();
        String sql = "select * from lendinfo";
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            BookInfo bookInfo = new BookInfo();
            bookInfo.setSerialNumber(rs.getString(2));
            bookInfo.setUsername(rs.getString(3));
            bookInfo.setBookID(rs.getString(4));
            bookInfo.setLendTime(rs.getString(5));
            bookInfoList.add(bookInfo);
        }
        return bookInfoList;
    }

    //添加借书信息
    @Override
    public String addBookInfo(String BookID,String username) throws SQLException {
        //-- 获取当前时间
        String time = getTime();
        //-- 获取流水号
        String serialNumber = getSerialNumber(BookID);
        //-- 存入数据库
        String sql = "insert into lendinfo(SerialNumber,username,BookID,Time) values(?,?,?,?)";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1,serialNumber);
        pst.setString(2,username);
        pst.setString(3,BookID);
        pst.setString(4,time);
        pst.executeUpdate();
        return time;
    }

    //删除借书信息
    @Override
    public void deleteBookInfo(String SerialNumber) throws SQLException {
        String sql = "delete from lendinfo where SerialNumber = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1,SerialNumber);
        pst.executeUpdate();
        return ;
    }

    //添加还书信息
    @Override
    public void addReturnBookInfo(String BookID,String Grade,String username) throws SQLException {
        String time = getTime();
        String serialNumber = getSerialNumber(BookID);
        String sql = "insert into returninfo(SerialNumber,BookID,Time,Grade,username) value(?,?,?,?,?)";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1,serialNumber);
        pst.setString(2,BookID);
        pst.setString(3,time);
        pst.setString(4,Grade);
        pst.setString(5,username);
        pst.executeUpdate();
    }

    //--查询学生借阅信息
    @Override
    public List<BookInfo> getStudentBookInfo() throws SQLException {
        List<BookInfo> bookInfoList = new ArrayList<BookInfo>();
        String sql = "select * from lendinfo,user where lendinfo.username=user.username AND user.type=? ";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1,"学生");
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            BookInfo bookInfo = new BookInfo();
            bookInfo.setSerialNumber(rs.getString(2));
            bookInfo.setUsername(rs.getString(3));
            bookInfo.setBookID(rs.getString(4));
            bookInfo.setLendTime(rs.getString(5));
            bookInfoList.add(bookInfo);
        }
        return bookInfoList;
    }

    //--查询教师借阅信息
    @Override
    public List<BookInfo> getTeacherBookInfo() throws SQLException {
        List<BookInfo> bookInfoList = new ArrayList<BookInfo>();
        String sql = "select * from lendinfo,user where lendinfo.username=user.username AND user.type=? ";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1,"教师");
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            BookInfo bookInfo = new BookInfo();
            bookInfo.setSerialNumber(rs.getString(2));
            bookInfo.setUsername(rs.getString(3));
            bookInfo.setBookID(rs.getString(4));
            bookInfo.setLendTime(rs.getString(5));
            bookInfoList.add(bookInfo);
        }
        return bookInfoList;
    }

    //--查询个人借阅信息
    @Override
    public List<BookInfo> querypersonbookinfo(String username) throws SQLException {
        List<BookInfo> bookInfoList = new ArrayList<BookInfo>();
        String sql = "select * from lendinfo where username=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1,username);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            BookInfo bookInfo = new BookInfo();
            bookInfo.setSerialNumber(rs.getString(2));
            bookInfo.setUsername(rs.getString(3));
            bookInfo.setBookID(rs.getString(4));
            bookInfo.setLendTime(rs.getString(5));
            bookInfoList.add(bookInfo);
        }
        return bookInfoList;
    }

    public String calAVG(String BookID) throws SQLException {
        String sql = "select AVG(Grade) from returninfo where BookID=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1,BookID);
        ResultSet rs = pst.executeQuery();
        String grade = null;
        if(rs.next()) {
            grade = rs.getString(1).toString();
        }
        return grade;
    }
}