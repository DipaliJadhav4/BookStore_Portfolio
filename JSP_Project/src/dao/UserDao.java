package dao;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojo.User;
import utils.DBUtils;

public class UserDao implements Closeable {

	private Connection connection;
	private PreparedStatement registerStatement;
	private PreparedStatement validateStatement;

	public UserDao() throws Exception {

		this.connection = DBUtils.getConnection();
		this.validateStatement = this.connection.prepareStatement("SELECT * FROM users WHERE email=? AND password=? ");
		this.registerStatement = this.connection.prepareStatement(
				"INSERT INTO users(full_name,email,password,birth_date,creation_date) VALUES(?,?,?,?,?)");
	}

	public int registerUser(User user) throws Exception {
		this.registerStatement.setString(1, user.getFull_name());
		this.registerStatement.setString(2, user.getEmail());
		this.registerStatement.setString(3, user.getPassword());
		this.registerStatement.setDate(4, user.getBirth_date());
		this.registerStatement.setDate(5, user.getCreation_date());
		return this.registerStatement.executeUpdate();
	}

	public User validate(String email, String password) throws Exception {

		this.validateStatement.setString(1, email);
		this.validateStatement.setString(2, password);

		try (ResultSet rs = this.validateStatement.executeQuery()) {
			if (rs.next()) {
				User user = new User(rs.getInt("id"), rs.getString("full_name"), rs.getString("email"),
						rs.getString("password"), rs.getDate("birth_date"), rs.getDate("creation_date"));
				return user;

			}
		}

		return null;

	}

	@Override
	public void close() throws IOException {

		try {

			this.validateStatement.close();
			this.connection.close();
		} catch (SQLException e) {
			throw new IOException(e);
			// TODO Auto-generated catch block

		}

	}

}
