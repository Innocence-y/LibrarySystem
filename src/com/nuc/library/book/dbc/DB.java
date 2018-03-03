package com.nuc.library.book.dbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
	private static final String DBDRIVER="com.mysql.jdbc.Driver";
	private static final String DBURL="jdbc:mysql://localhost:3306/librarysystem?useUnicode=true&characterEncoding=UTF-8";
	private static final String DBUSER="root";
	private static final String DBPASS="123456";
	private static Connection conn=null;
	public static  Connection  getConnection(){
	
		try {
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		} catch (Exception e) {
			// TODO: handle exception
		}
		if(conn!=null){
			System.out.println("���ӳɹ���");
		}
	    return conn;	
		
	}
	
	public static void main(String[] args){
		Connection conn = DB.getConnection();
		System.out.println(conn);
		if(conn!=null){
			System.out.println("�ɹ�����");
		}
	}

}