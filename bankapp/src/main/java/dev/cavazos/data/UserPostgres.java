package dev.cavazos.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dev.cavazos.ds.List;
import dev.cavazos.models.User;
import dev.cavazos.utils.ConnectionUtil;

public class UserPostgres implements UserDAO {
	private ConnectionUtil connUtil = ConnectionUtil.getConnectionUtil();
	
	@Override
	public User create(User user) {
		try (Connection conn = connUtil.getConnection()){
			//set autocommit to false
			conn.setAutoCommit(false);
			
			String sql = "insert into customer "
					+ "(id, username, passwd)"
					+ "values (default, ?, ?)";
			// when inserting, retrieve the ID that was generated
			// keep to specify which column(s) are autogenerated
			String[] keys = {"id"};
			
			PreparedStatement stmt = conn.prepareStatement(sql, keys);
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getPassword());
			
			int rowsAffected = stmt.executeUpdate();
			ResultSet resultSet = stmt.getGeneratedKeys();
			if (resultSet.next() && rowsAffected == 1) {
				user.setID(resultSet.getInt("id"));
				conn.commit();
			} else {
				conn.rollback();
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public User findByID(int id) {
		User user = null;

		try(Connection conn = connUtil.getConnection()){
			String sql = "select customer.id, "
					+ "customer.username, "
					+ "passwd"
					+ "from customer "
					+ "where customer.id=?";
			
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, id);
		
		ResultSet resultSet = stmt.executeQuery();
		
		if(resultSet.next()) {
			String name = resultSet.getString("username");
			String passwd = resultSet.getString("passwd");
			
		user = new User(name, passwd);
		user.setID(id);
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return user;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(User user) {
		try (Connection conn = connUtil.getConnection()){
			conn.setAutoCommit(false);
			
			String sql = "update customer "
					+ "set username = ?, "
					+ "passwd= ?"
					+ "where id=?";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getPassword());
			stmt.setInt(3, user.getID());
			
			int rowsAffected = stmt.executeUpdate();
			if(rowsAffected<=1) {
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(User user) {
		try (Connection conn = connUtil.getConnection()){
			conn.setAutoCommit(false);
			
			String sql = "delte from customer where id=?";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, user.getID());
			
			int rowsAffected = stmt.executeUpdate();
			if (rowsAffected<= 1) {
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public User findByUsername(String username) {
		User user = null;
		
		try (Connection conn = connUtil.getConnection()){
			String sql = "select customer.username "
					+ "from customer "
					+ "where username=?";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			
			ResultSet resultSet = stmt.executeQuery();
			
			if(resultSet.next()) {
				String name = resultSet.getString("username");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}

}
