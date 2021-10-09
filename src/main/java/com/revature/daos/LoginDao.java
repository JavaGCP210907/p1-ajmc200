package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.LoginDTO;
import com.revature.models.Request;
import com.revature.utils.ConnectionUtil;
import com.revature.utils.JwtUtil;

public class LoginDao implements LoginInterface {

	@Override
	public boolean getCredentials(String username, String password){
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			boolean state;
			ResultSet rs = null;
			String sql = "select username, pass, title from credentials where username=? and pass=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			rs.next();
//****************************************************************************			
			LoginDTO pl = new LoginDTO(
					rs.getString("username"), 
					rs.getString("pass"),
					rs.getString("title"));
//****************************************************************************			
			if(pl.getUsername().equals(username)  && pl.getPassword().equals(password)) { //if login is successful...
			System.out.println("POG!");
			state = true;			
			} else { //login fails...
			System.out.println("FUUUU!");
			state = false;
			}
//******************************************************************************
			return state;
		} catch (SQLException e) {
			System.out.println("Something went wrong with your database!"); 
			e.printStackTrace();
		}
		return false;
	}
/////////////////////////////////////////////////////////////////////////////////	
	@Override
	public String getTitle(String username, String password){
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			ResultSet rs = null;
			String sql = "select username, pass, title from credentials where username=? and pass=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			rs.next();

			LoginDTO pl = new LoginDTO(
					rs.getString("username"), 
					rs.getString("pass"),
					rs.getString("title"));

			return pl.getTitle();
		} catch (SQLException e) {
			System.out.println("Something went wrong with your database!"); 
			e.printStackTrace();
		}		
		
		return null;
	}
}
