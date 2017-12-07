
package com.pentaho.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

/**
 *
 * @author Mateen SA
 */
public class CustomPropertiesReader extends Properties {

	private static final long serialVersionUID = 1L;
	private static CustomPropertiesReader reader = null;
	final static Logger logger = Logger.getLogger(CustomPropertiesReader.class);

	public CustomPropertiesReader() {
		super();
	}

	public static CustomPropertiesReader getInstance(boolean runOnServer) throws FileNotFoundException, IOException {

		if (reader == null) {
			if (runOnServer) {
				ResourceBundle bundle = ResourceBundle.getBundle("dioperations");
				return reader = new CustomPropertiesReader().init(new File(bundle.getString("CONNECTION_ENV_FILE")),
						new File(bundle.getString("CONFIGURATION_ENV_FILE")));
			} else {
				return reader = new CustomPropertiesReader().init(new File("D:\\connection.env"),
						new File("D:\\config.env"));
			}
		} else {
			return reader;
		}
	}

	private CustomPropertiesReader init(File file1, File file2) throws FileNotFoundException, IOException {

		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(file1));

			// One way of reading the file
			String contentLine = "";

			while (contentLine != null) {
				String[] str = br.readLine().replace("export ", "").replace("'", "").replace("\"", "").split("=");
				if (str.length > 1) {
					this.setProperty(str[0].trim(), str[1].trim());
				}
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (NullPointerException e) {
			System.out.println("");

		} finally {

			try {
				if (br != null)
					br.close();
			} catch (IOException ioe) {
				System.out.println("Error in closing the BufferedReader");
				logger.error("Error in closing the BufferedReader:" + ioe.getMessage());
			}

		}

		BufferedReader br1 = null;

		try {
			br1 = new BufferedReader(new FileReader(file2));

			// One way of reading the file
			String contentLine = "";

			while (contentLine != null) {
				String[] str = br1.readLine().replace("export ", "").replace("'", "").replace("\"", "").split("=");
				if (str.length > 1) {
					this.setProperty(str[0].trim(), str[1].trim());
				}
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (NullPointerException e) {
			System.out.println("");

		} finally {

			try {
				if (br1 != null)
					br1.close();
			} catch (IOException ioe) {
				System.out.println("Error in closing the BufferedReader");
				logger.error("Error in closing the BufferedReader:" + ioe.getMessage());
			}
		}
		return this;
	}

}
