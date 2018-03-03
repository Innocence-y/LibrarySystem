package com.nuc.library.user.action;
import com.nuc.library.user.entity.User;
import com.nuc.library.user.service.IUserImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserAction extends ActionSupport implements ModelDriven<User> {

    public static IUserImpl iUser = new IUserImpl();

    private List<User> userlist = new ArrayList<User>();

    public List<User> getUserlist() {
        return userlist;
    }

    public void setUserlist(List<User> userlist) {
        this.userlist = userlist;
    }

    private User user = new User();

    public User getModel(){
        return user;
    }

    //--登录
    public String loginaction() throws SQLException {
        Boolean flag = false;
        flag = iUser.queryUser(user.getUsername(),user.getPassword());
        if(flag){
            user = iUser.initUser(user.getUsername());
            ActionContext.getContext().getSession().put("user",user);
            return "loginOK";
        }
        this.addFieldError("loginerror","用户名密码不正确");
        return "input";
    }

    //--注册
    public String registeraction() throws SQLException {
        boolean flag = iUser.addUser(user);
        if(!flag){
            this.addFieldError("registererror","该账户已存在，请重新输入");
            return LOGIN;
        }
        return "registerOK";
    }

    //--删除用户
    public String deleteaction() throws SQLException {
        iUser.deleteUser(user.getUsername());
        return "deleteOK";
    }

    //--更新用户
    public String updateaction() throws SQLException {
        user = iUser.updateUser(user.getId(),user);
        return "updateOK";
    }

    //--查找所有用户
    public String queryaction() throws SQLException {
        userlist = iUser.queryUserList();
        return "queryOK";
    }

    //--转换
    public String transformaction(){
        return "update";
    }

    //--退出系统
    public String logoutaction(){
        ActionContext.getContext().getSession().put("user",null);
        return "logout";
    }

    //--查询学生
    public String Students_queryaction() throws SQLException {
        userlist = iUser.queryStudentList();
        return "student_query_success";
    }

    //--查询教师
    public String teacher_queryaction() throws SQLException {
        userlist = iUser.queryTeacherList();
        return "teacher_query_success";
    }

    //--更新教师
    public String teacherupdateaction() throws SQLException {
        iUser.updateUser(user.getId(),user);
        return "teacherupdateOK";
    }

}
