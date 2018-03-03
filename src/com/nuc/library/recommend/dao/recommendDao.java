package com.nuc.library.recommend.dao;

import com.nuc.library.book.vo.Book;
import com.nuc.library.bookinfo.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class recommendDao {

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

    public Book recommend(String username) throws SQLException {

        List<String> bookIDlist = new ArrayList<>();
        List<String> bookSortlist = new ArrayList<>();
        Map<String,Integer> bookSortmap = new HashMap<String,Integer>();

        //--查找该用户所借过的所有书籍
        String sql = "select BookID from returninfo where username=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1,username);
        ResultSet rs = pst.executeQuery();
        if(rs==null){
            return null;
        }
        while(rs.next()){
            String bookID = rs.getString(1);
            bookIDlist.add(bookID);
        }
        System.out.println(bookIDlist.size());

        //--通过BookID获取所借书籍的所有分类
        for(int i=0; i<bookIDlist.size(); i++) {
            sql = "select sort from book where BookID=?";
            pst = conn.prepareStatement(sql);
            pst.setString(1,bookIDlist.get(i));
            rs = pst.executeQuery();
            if(rs.next()){
                bookSortlist.add((String)rs.getString(1));
            }
        }
        System.out.println(bookSortlist);

        //--计算出现次数最多的分类
        String booksort = null;
        int flag = 0;
        for (String s:bookSortlist) {
            if(bookSortmap.get(s)!=null){
                int temp = bookSortmap.get(s)+1;
                bookSortmap.put(s,temp);
                if(flag < temp){
                    booksort = s;
                    flag = temp;
                }
            }else{
                bookSortmap.put(s,1);
                if(flag < 1){
                    booksort = s;
                    flag = 1;
                }
            }
        }

        //--在表查找该分类中评分最高的书，推荐给用户
        sql = "select * from book where sort=? order by grade desc";
        pst = conn.prepareStatement(sql);
        pst.setString(1,booksort);
        rs = pst.executeQuery();
        Book book = new Book();
        if(rs.next()){
            book.setId(rs.getInt(1));
            book.setBookID(rs.getString(2));
            book.setBookname(rs.getString(3));
            book.setAuthor(rs.getString(4));
            book.setSort(rs.getString(5));
            book.setGrade(rs.getString(6));
            book.setStatus(rs.getString(7));
        }
        return book;
    }

}
