package com.nuc.library.bookinfo.dao;

import com.nuc.library.bookinfo.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CountDao {

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

    //--更新图书统计信息
    public void updateBookSortNumber(String BookID) throws SQLException {
        String sql = "select sort from book where BookID=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1,BookID);
        ResultSet rs = pst.executeQuery();
        if(rs.next()) {
            String sort = rs.getString(1);
            sql = "update sort set number=number+1 where sort=?";
            pst = conn.prepareStatement(sql);
            pst.setString(1,sort);
            pst.executeUpdate();
        }
        return ;
    }

    //--更新性别统计信息
    public void updateSexNumber(String username) throws SQLException {
        String sql = "select sex from user where username=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1,username);
        ResultSet rs = pst.executeQuery();
        if(rs.next()) {
            String sex = rs.getString(1);
            sql = "update sex set number=number+1 where sex=?";
            pst = conn.prepareStatement(sql);
            pst.setString(1,sex);
            pst.executeUpdate();
        }
        return ;
    }

    //--更新年级统计信息
    public void updateYearNumber(String username) throws SQLException {
        String sql = "select year from user where username=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1,username);
        ResultSet rs = pst.executeQuery();
        if(rs.next()) {
            String year = rs.getString(1);
            sql = "update year set number=number+1 where year=?";
            pst = conn.prepareStatement(sql);
            pst.setString(1,year);
            pst.executeUpdate();
        }
        return ;
    }

    //--更新学院统计信息
    public void updateCollegeNumber(String username) throws SQLException {
        String sql = "select college from user where username=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1,username);
        ResultSet rs = pst.executeQuery();
        if(rs.next()) {
            String college = rs.getString(1);
            sql = "update college set number=number+1 where college=?";
            pst = conn.prepareStatement(sql);
            pst.setString(1,college);
            pst.executeUpdate();
        }
        return ;
    }

    //--更新时间段统计信息
    public static void updateTimeNumber(String time) throws SQLException {
            String times[] = time.split(" ");
            String time2[] = times[1].split(":");
             String sql = null;
            if(Integer.parseInt(time2[0])<10) {
                sql = "update time set number=number+1 where time='6:00-10:00'";
            }else if(Integer.parseInt(time2[0])<14){
                sql = "update time set number=number+1 where time='10:00-14:00'";
            }else if(Integer.parseInt(time2[0])<18){
                sql = "update time set number=number+1 where time='14:00-18:00'";
            }else if(Integer.parseInt(time2[0])<22){
                sql = "update time set number=number+1 where time='18:00-22:00'";
            }
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.executeUpdate();
        return ;
    }

}
