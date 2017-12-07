package com.pentaho.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.apache.log4j.Logger;

public class CreateConnection {

	public static Connection instance = null;
	private static Connection connect = null;
	public static Properties prop = null;

	final static Logger logger = Logger.getLogger(CreateConnection.class);

	public static Connection getConnection() {

		try {
			prop = SingletonProperties.getProperties();
			Class.forName("com.mysql.jdbc.Driver");
			StringBuffer sb = new StringBuffer();
			sb.append("jdbc:mysql://");
			sb.append(prop.getProperty("HOSTNAME"));
			sb.append(":3306/");
			sb.append(prop.getProperty("DATABASE"));
			sb.append("?autoReconnect=true");
			sb.append("&user=");
			sb.append(prop.getProperty("DB_USER_NAME"));
			sb.append("&password=");
			sb.append(prop.getProperty("PASSWORD"));

			logger.info(sb.toString());

			connect = DriverManager.getConnection(sb.toString());
			logger.info("Connected to database");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return connect;

	}

	public static Connection createConnection() throws FileNotFoundException, IOException {

		if (instance == null) {
			instance = getConnection();
		}
		return instance;
	}
}