package com.pentaho.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Inet4Address;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 *
 * @author Mateen SA
 */
public class SingletonProperties {
	final static Logger logger = Logger.getLogger(SingletonProperties.class);

	public SingletonProperties() {

	}

	public static Properties getProperties() throws FileNotFoundException, IOException { 
		return  CustomPropertiesReader.getInstance(Inet4Address.getLocalHost().getHostName().contains("aws"));
	}
}
