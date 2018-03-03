package com.nuc.library.user.service;

import com.nuc.library.user.dao.IUserDaoImpl;
import com.nuc.library.user.entity.Admin;
import com.nuc.library.user.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IUserImpl implements IUser {

    static IUserDaoImpl iUserDao = new IUserDaoImpl();

    @Override
    public boolean addAdmin(Admin admin) throws SQLException {
        Boolean flag = false;
        flag = iUserDao.addAdmin(admin);
        return flag;
    }

    @Override
    public boolean queryAdmin(String username, String password) throws SQLException {
        Boolean flag = iUserDao.queryAdmin(username,password);
        return flag;
    }

    @Override
    public boolean addUser(User user) throws SQLException {
        Boolean flag = false;
        flag = iUserDao.addUser(user);
        return flag;
    }

    //--查找用户
    @Override
    public boolean queryUser(String username, String password) throws SQLException {
        Boolean flag = iUserDao.queryUser(username,password);
        return flag;
    }

    @Override
    public List<User> queryUserList() throws SQLException {
        List<User> list = new ArrayList<User>();
        list = iUserDao.queryUserList();
        return list;
    }

    @Override
    public void deleteUser(String username) throws SQLException {
        iUserDao.deleteUser(username);
        return ;
    }

    @Override
    public User updateUser(int id,User user) throws SQLException {
        User u = iUserDao.updateUser(id,user);
        return u;
    }

    @Override
    public List<User> queryStudentList() throws SQLException {
        List<User> list = new ArrayList<User>();
        list = iUserDao.queryStudentList();
        return list;
    }

    @Override
    public List<User> queryTeacherList() throws SQLException {
        List<User> list = new ArrayList<User>();
        list = iUserDao.queryTeacherList();
        return list;
    }

    //--初始化用户
    @Override
    public User initUser(String username) throws SQLException {
        User user = iUserDao.initUser(username);
        return user;
    }
}
