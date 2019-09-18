package com.bv.loginform;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bv.connection.DBconnect;

public class loginDao {

	public static boolean validateUser(String username , String password)
	{
		String str = "select username , password from logindetails where username = ? and password = ?";
		boolean status = false;
		Connection con = DBconnect.getConnection();
		try {
			PreparedStatement prepared = con.prepareStatement(str);
			prepared.setString(1, username);
			prepared.setString(2, password);
			ResultSet rs = prepared.executeQuery();
			status = rs.next();
			
			if(status)
			{
				return status;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
}
