package vn.iostar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vn.iostar.model.User;
import vn.iostar.utils.DBConnection;

public class UserDaoImpl implements UserDao {
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	
	public User get(String Username)
	{
		String sql = "SELECT * FROM [User] WHERE username = ? ";
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, Username);
			System.out.println(">>> Executing query: " + sql + " with username = " + Username);
			rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setUserName(rs.getString("username"));
				user.setFullName(rs.getString("fullname"));
				user.setPassWord(rs.getString("password"));
				user.setAvatar(rs.getString("avatar"));
				user.setRoleid(Integer.parseInt(rs.getString("roleId")));
				user.setPhone(rs.getString("phone"));
				user.setCreatedDate(rs.getDate("createDate"));
				return user; 
			}
		} 
		catch (Exception e) {e.printStackTrace(); }
		return null;
	}
}
