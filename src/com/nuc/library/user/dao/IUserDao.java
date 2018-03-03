package com.nuc.library.user.dao;

import com.nuc.library.user.entity.Admin;
import com.nuc.library.user.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDao {

    //--添加管理员
    public boolean addAdmin(Admin admin) throws SQLException;

    //--查找管理员
    public  boolean queryAdmin(String username,String password) throws SQLException;

    //--添加用户
    public boolean addUser(User user) throws SQLException;

    //--查找用户
    public  boolean queryUser(String username,String password) throws SQLException;

    //--查找所有用户
    public List<User> queryUserList() throws SQLException;

    //--删除用户
    public void deleteUser(String username) throws SQLException;

    //--更新用户
    public User updateUser(int id,User user) throws SQLException;

    //--查找学生
    public List<User> queryStudentList() throws SQLException;

    //--查找教师
    public List<User> queryTeacherList() throws SQLException;

    //--初始化用户
    public User initUser(String username) throws SQLException;
}
