package com.login.register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAOImpl implements UserDAO {

	static Connection con;
	static PreparedStatement pstmt;

	@Override
	public int insertUser(User user) {
		int count = 0;

		try {
			con = MyConnection.getCon();
			pstmt = con.prepareStatement("insert into user values(?,?,?)");
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getName());
			count = pstmt.executeUpdate();
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return count;
	}

	@Override
	public User getUser(String userid, String password) {
		User user = new User();
		try {
			con = MyConnection.getCon();
			pstmt = con.prepareStatement("select * from user where name=? and password=?");
			pstmt.setString(1, userid);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				user.setUsername(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setName(rs.getString(3));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return user; 
	}

}
