<<<<<<< HEAD
package dev.cavazos.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	private static ConnectionUtil connUtil;
	private Properties props;
	
	private ConnectionUtil() {
		props = new Properties();
		
		InputStream propsFile = ConnectionUtil.class.getClassLoader()
				.getResourceAsStream("database.properties");
		
		try {
			props.load(propsFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static synchronized ConnectionUtil getConnectionUtil() {
		if(connUtil == null) {
			connUtil = new ConnectionUtil();
		}
		return connUtil;
	}
	
	public Connection getConnection() {
		Connection conn = null;
		
		String dbURL = props.getProperty("url");
		String dbUser = props.getProperty("usr");
		String dbPass = props.getProperty("psw");
		
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(
					dbURL,
					dbUser,
					dbPass);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
=======
package dev.cavazos.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	private static ConnectionUtil connUtil;
	private Properties props;
	
	private ConnectionUtil() {
		props = new Properties();
		
		InputStream propsFile = ConnectionUtil.class.getClassLoader()
				.getResourceAsStream("database.properties");
		
		try {
			props.load(propsFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static synchronized ConnectionUtil getConnectionUtil() {
		if(connUtil == null) {
			connUtil = new ConnectionUtil();
		}
		return connUtil;
	}
	
	public Connection getConnection() {
		Connection conn = null;
		
		String dbURL = props.getProperty("url");
		String dbUser = props.getProperty("usr");
		String dbPass = props.getProperty("psw");
		
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(
					dbURL,
					dbUser,
					dbPass);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
>>>>>>> 94179b20c88ec075cfeb65b45e1b379100717a22
