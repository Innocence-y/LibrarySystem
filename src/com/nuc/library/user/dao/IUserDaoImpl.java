package com.nuc.library.user.dao;

import com.nuc.library.user.entity.Admin;
import com.nuc.library.user.entity.User;
import com.nuc.library.user.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IUserDaoImpl implements IUserDao{

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

    //--添加管理员
    @Override
    public boolean addAdmin(Admin admin) throws SQLException {
        boolean flag = false;
        String sql = "select * from admin where username=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1,admin.getUsername());
        ResultSet rs = pst.executeQuery();
        if(rs.next()){
            if(rs.getString(2).toString().equals(admin.getUsername())) {
                flag = false;
            }
        }else {
            sql = "insert into admin(username,password) values(?,?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1, admin.getUsername());
            pst.setString(2, admin.getPassword());
            pst.executeUpdate();
            flag = true;
        }
        return flag;
    }

    //--查询管理员
    @Override
    public boolean queryAdmin(String username, String password) throws SQLException {
        String sql = "select password from admin where username=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1,username);
        ResultSet rs = pst.executeQuery();
        if(rs.next()){
            if(rs.getString(1).toString().equals(password)){
                return true;
            }
        }
        return false;
    }

    //--添加用户
    @Override
    public boolean addUser(User user) throws SQLException {
        boolean flag = false;
        String sql = "select * from user where username=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1,user.getUsername());
        ResultSet rs = pst.executeQuery();
        if(rs.next()){
            if(rs.getString(6).toString().equals(user.getUsername())) {
                flag = false;
            }
        }else {
            sql = "insert into user(college,year,major,type,username,password,sex) values(?,?,?,?,?,?,?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1, user.getCollege());
            pst.setString(2, user.getYear());
            pst.setString(3, user.getMajor());
            pst.setString(4, user.getType());
            pst.setString(5, user.getUsername());
            pst.setString(6, user.getPassword());
            pst.setString(7, user.getSex());
            pst.executeUpdate();
            flag = true;
        }
        return flag;
    }

    //--查询用户
    @Override
    public boolean queryUser(String username, String password) throws SQLException {
        String sql = "select password from user where username=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1,username);
        ResultSet rs = pst.executeQuery();
        if(rs.next()){
            if(rs.getString(1).toString().equals(password)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws SQLException {
        IUserDaoImpl iUserDao = new IUserDaoImpl();
        boolean flag = iUserDao.queryUser("123","123");
        System.out.println(flag);
    }

    //--查询所有用户
    @Override
    public List<User> queryUserList() throws SQLException {
        List<User> userlist = new ArrayList<>();
        String sql = "select * from user";
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            User user = new User();
            user.setId(rs.getInt(1));
            user.setCollege(rs.getString(2));
            user.setYear(rs.getString(3));
            user.setMajor(rs.getString(4));
            user.setType(rs.getString(5));
            user.setUsername(rs.getString(6));
            user.setPassword(rs.getString(7));
            user.setSex(rs.getString(8));
            userlist.add(user);
        }
        return userlist;
    }

    //--删除用户
    @Override
    public void deleteUser(String username) throws SQLException {
        String sql = "delete from user where username=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1,username);
        pst.executeUpdate();
        return;
    }

    //--修改用户信息
    @Override
    public User updateUser(int id,User user) throws SQLException {
        String sql = "update user set college=?,year=?,major=?,type=?,password=?,sex=? where id=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1,user.getCollege());
        pst.setString(2,user.getYear());
        pst.setString(3,user.getMajor());
        pst.setString(4,user.getType());
        pst.setString(5,user.getPassword());
        pst.setString(6,user.getSex());
        pst.setInt(7,id);
        pst.executeUpdate();
        user.setId(id);
        return user;
    }

    //--查找学生集合
    @Override
    public List<User> queryStudentList() throws SQLException {
        List<User> userlist = new ArrayList<>();
        String sql = "select * from user where type=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1,"学生");
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            User user = new User();
            user.setId(rs.getInt(1));
            user.setCollege(rs.getString(2));
            user.setYear(rs.getString(3));
            user.setMajor(rs.getString(4));
            user.setType(rs.getString(5));
            user.setUsername(rs.getString(6));
            user.setPassword(rs.getString(7));
            user.setSex(rs.getString(8));
            userlist.add(user);
        }
        return userlist;
    }

    //--查找教师集合
    @Override
    public List<User> queryTeacherList() throws SQLException {
        List<User> userlist = new ArrayList<>();
        String sql = "select * from user where type=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1,"教师");
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            User user = new User();
            user.setId(rs.getInt(1));
            user.setCollege(rs.getString(2));
            user.setYear(rs.getString(3));
            user.setMajor(rs.getString(4));
            user.setType(rs.getString(5));
            user.setUsername(rs.getString(6));
            user.setPassword(rs.getString(7));
            user.setSex(rs.getString(8));
            userlist.add(user);
        }
        return userlist;
    }

    //--初始化用户
    @Override
    public User initUser(String username) throws SQLException {
        String sql = "select * from user where username=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1,username);
        ResultSet rs = pst.executeQuery();
        User user = new User();
        while(rs.next()){
            user.setId(rs.getInt(1));
            user.setCollege(rs.getString(2));
            user.setYear(rs.getString(3));
            user.setMajor(rs.getString(4));
            user.setType(rs.getString(5));
            user.setUsername(rs.getString(6));
            user.setPassword(rs.getString(7));
            user.setSex(rs.getString(8));
        }
        return user;
    }

}
