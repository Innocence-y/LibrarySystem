package com.nuc.library.bookinfo.action;

import com.nuc.library.bookinfo.entity.BookInfo;
import com.nuc.library.bookinfo.service.IBookInfoImpl;
import com.nuc.library.user.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.sql.SQLException;
import java.sql.Time;
import java.util.List;

public class BookInfoAction extends ActionSupport{

    static IBookInfoImpl bookInfoImpl = new IBookInfoImpl();
    private String BookID;
    private String Grade;
    private String SerialNumber;
    private String Time;

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getSerialNumber() {
        return SerialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        SerialNumber = serialNumber;
    }

    public String getGrade() {
        return Grade;
    }

    public void setGrade(String grade) {
        Grade = grade;
    }

    public String getBookID() {
        return BookID;
    }

    public void setBookID(String bookID) {
        BookID = bookID;
    }

    //--借书
    public String lendbookinfo() throws SQLException {
//        System.out.println(user);
        User user= (User)ActionContext.getContext().getSession().get("user");
        String username = user.getUsername();
        bookInfoImpl.addBookInfo(BookID,username);

        return "lendOK";
    }

    //--还书transform
    public String returntransformbookinfo(){
        return "returntransform";
    }

    //--还书
    public String returnbookinfo() throws SQLException {
        User user= (User)ActionContext.getContext().getSession().get("user");
        String username = user.getUsername();
        bookInfoImpl.addReturnBookInfo(SerialNumber,BookID,Grade,username,Time);
        return "returnOK";
    }

    //--查询学生借书记录
    public String querystudentbookinfo() throws SQLException {
        List<BookInfo> bookinfolist = bookInfoImpl.getStudentBookInfolist();
        ActionContext.getContext().getSession().put("bookinfolist",bookinfolist);
        return "querystudentOK";
    }

    //--查询教师借书记录
    public String queryteacherbookinfo() throws SQLException {
        List<BookInfo> bookinfolist = bookInfoImpl.getTeacherBookInfolist();
        ActionContext.getContext().getSession().put("bookinfolist",bookinfolist);
        return "queryteacherOK";
    }

    //--查询所有借书记录
    public String querybookinfo() throws SQLException {
        List<BookInfo> bookinfolist = bookInfoImpl.getBookInfolist();
        ActionContext.getContext().getSession().put("bookinfolist",bookinfolist);
        return "queryOK";
    }

    //--删除学生借书记录
    public String deletestudentbookinfo() throws SQLException {
        bookInfoImpl.deletestudentBookInfo(SerialNumber);
        return "deletestudentOK";
    }

    //--删除教师借书记录
    public String deleteteacherbookinfo() throws SQLException {
        bookInfoImpl.deleteteacherBookInfo(SerialNumber);
        return "deleteteacherOK";
    }

    //--查询所有还书记录
    public String queryreturnbookinfo() throws SQLException {
        List<BookInfo> bookreturninfolist = bookInfoImpl.getReturnBookInfolist();
        ActionContext.getContext().getSession().put("bookreturninfolist",bookreturninfolist);
        return "queryreturnbookOK";
    }

    //--查询个人借阅信息
    public String personbookinfo() throws SQLException {
        User user= (User)ActionContext.getContext().getSession().get("user");
        String username = user.getUsername();
        List<BookInfo> bookinfolist = bookInfoImpl.querypersonbookinfo(username);
        ActionContext.getContext().getSession().put("bookinfolist",bookinfolist);
        return "querypersonbookinfo";
    }


}
