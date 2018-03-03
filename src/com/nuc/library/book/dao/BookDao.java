package com.nuc.library.book.dao;

import com.nuc.library.book.dbc.DB;
import com.nuc.library.book.vo.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDao implements BaseDao {
    private static Connection conn = DB.getConnection();
    private static PreparedStatement ps = null;

    @Override
    public void addBook(Book book) {
        String sql = "insert into book(BookID,bookname,author,sort,grade,status) values(?,?,?,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, book.getBookID());
            ps.setString(2, book.getBookname());
            ps.setString(3, book.getAuthor());
            ps.setString(4, book.getSort());
            ps.setString(5, book.getGrade());
            ps.setString(6, book.getStatus());
            ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void deleteBookById(String BookID) {
        String sql = "delete from book where BookID=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, BookID);
            ps.executeUpdate();
            System.out.println("delete");
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    @Override
    public void updateBookById(int id, Book book) {
        String sql = "update book set BookID=?,bookname=?,author=?,sort=?,grade=?,status=? where id=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, book.getBookID());
            ps.setString(2, book.getBookname());
            ps.setString(3, book.getAuthor());
            ps.setString(4, book.getSort());
            ps.setString(5, book.getGrade());
            ps.setString(6, book.getStatus());
            ps.setInt(7, id);
            ps.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    //--将图书的状态改为已借出
    public void updateBookStatusToLend(String BookID) {
        String sql = "update book set status=? where BookID=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, "已借出");
            ps.setString(2, BookID);
            ps.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    //--将图书的状态改为馆存
    public void updateBookStatusToReturn(String BookID) {
        String sql = "update book set status=? where BookID=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, "馆存");
            ps.setString(2, BookID);
            ps.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @Override
    public Book findById(int id) {
        Book book = new Book();
        ResultSet rs = null;
        String sql = "select * from book where id=?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                book.setBookID(rs.getString(2));
                book.setBookname(rs.getString(3));
                book.setAuthor(rs.getString(4));
                book.setSort(rs.getString(5));
                book.setGrade(rs.getString(6));
                book.setStatus(rs.getString(7));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return book;
    }

    @Override
    public List<Book> findByBookName(String bookname) {
        List<Book> books = new ArrayList<Book>();
        Book book = new Book();
        ResultSet rs = null;
        String sql = "select * from book where bookname=?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, bookname);
            rs = ps.executeQuery();
            while (rs.next()) {
                book.setBookID(rs.getString(2));
                book.setBookname(rs.getString(3));
                book.setAuthor(rs.getString(4));
                book.setSort(rs.getString(5));
                book.setGrade(rs.getString(6));
                book.setStatus(rs.getString(7));
                books.add(book);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public List<Book> findBySort(String sort) {
        List<Book> books = new ArrayList<Book>();
        ResultSet rs = null;
        String sql = "select * from book where sort=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, sort);
            rs = ps.executeQuery();

            while (rs.next()) {
                Book book = new Book();
                book.setBookID(rs.getString(2));
                book.setBookname(rs.getString(3));
                book.setAuthor(rs.getString(4));
                book.setSort(rs.getString(5));
                book.setGrade(rs.getString(6));
                book.setStatus(rs.getString(7));
                books.add(book);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public List<Book> findAll() throws Exception {
        List<Book> books = new ArrayList<Book>();
        ResultSet rs = null;
        String sql = "select * from book";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt(1));
                book.setBookID(rs.getString(2));
                book.setBookname(rs.getString(3));
                book.setAuthor(rs.getString(4));
                book.setSort(rs.getString(5));
                book.setGrade(rs.getString(6));
                book.setStatus(rs.getString(7));
                books.add(book);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return books;
    }

    //--分类查询
    @Override
    public List<Book> typeQuery(String query, String option) throws Exception {
        List<Book> books = new ArrayList<Book>();
        ResultSet rs = null;
        String sql = "select * from book where "+query+"=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, option);
            rs = ps.executeQuery();

            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt(1));
                book.setBookID(rs.getString(2));
                book.setBookname(rs.getString(3));
                book.setAuthor(rs.getString(4));
                book.setSort(rs.getString(5));
                book.setGrade(rs.getString(6));
                book.setStatus(rs.getString(7));
                books.add(book);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return books;
    }

    //-更新图书评分
    public void updateBookGrade(String BookID,String grade) {
        String sql = "update book set grade=? where BookID=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, grade);
            ps.setString(2, BookID);
            ps.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }


}
