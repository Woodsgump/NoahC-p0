package dev.cavazos.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Implements the JDCB to connect to the Amazon AWS Database.
 * 
 * @author Noah Cavazos
 *
 */
public class ConnectionUtil {
	private static ConnectionUtil connUtil;
	private Properties props;
	
	/**
	 * Reads from the properties file to get the Url, username, and password in order
	 * to connect to AWS Database.
	 */
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
	
	/**
	 * Instantiating a new instance of ConnectionUtil.
	 * 
	 * @return connUtil the instance of ConnectionUtil.
	 */
	public static synchronized ConnectionUtil getConnectionUtil() {
		if(connUtil == null) {
			connUtil = new ConnectionUtil();
		}
		return connUtil;
	}
	
	/**
	 * Retrieving the data from database.properties to input the path to the AWS database.
	 * 
	 * @return conn the instance of Connection
	 */
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
