package com.nuc.library.recommend.action;

import com.nuc.library.book.vo.Book;
import com.nuc.library.recommend.dao.recommendDao;
import com.nuc.library.user.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.sql.SQLException;

public class recommendAction extends ActionSupport {

    public String recommendBook() throws SQLException {
        User user = (User) ActionContext.getContext().getSession().get("user");
        recommendDao recommendDao = new recommendDao();
        Book recommendBook = recommendDao.recommend(user.getUsername());
        ActionContext.getContext().getSession().put("recommendBook",recommendBook);
        return "recommendOK";
    }

}
