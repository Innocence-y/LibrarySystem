package com.nuc.library.user.action;

import com.nuc.library.user.entity.Admin;
import com.nuc.library.user.service.IUserImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.sql.SQLException;

public class AdminAction extends ActionSupport implements ModelDriven<Admin> {

    public static IUserImpl iUser = new IUserImpl();

    private Admin admin = new Admin();

    @Override
    public Admin getModel() {
        return admin;
    }

    //--管理员登录
    public String adminloginaction()throws SQLException{
        Boolean flag = false;
        flag = iUser.queryAdmin(admin.getUsername(),admin.getPassword());
        if(flag){
            ActionContext.getContext().getSession().put("admin",admin);
            return "adminloginOK";
        }
        this.addFieldError("adminloginerror","用户名密码不正确");
        return LOGIN;
    }

    //--管理员注册
    public String adminregisteraction() throws SQLException {
        boolean flag = iUser.addAdmin(admin);
        if (!flag) {
            this.addFieldError("registererror", "该账户已存在，请重新输入");
            return INPUT;
        }
        return "adminregisterOK";
    }
    //--退出系统
    public String adminlogoutaction(){
        ActionContext.getContext().getSession().put("admin",null);
        return "adminlogout";
    }

}
