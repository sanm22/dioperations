package com.pentaho.scripting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.http.client.ClientProtocolException;
import org.apache.log4j.Logger;

import com.pentaho.dao.SingletonProperties;

public class WebServiceCallForKitchenScript {
//	public static Properties prop = null;

	Logger logger = Logger.getLogger(WebServiceCallForKitchenScript.class);

	public boolean callWebService(String jobPath, String jobName) throws ClientProtocolException, IOException {

		try {
			URL url_one = new URL(ResourceBundle.getBundle("dioperations").getString("KITCHENURL") + jobPath + jobName);
			
			logger.info("URLL "+url_one.toString());
			
			HttpURLConnection connection = (HttpURLConnection) url_one.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);

			InputStream content = (InputStream) connection.getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(content));
			String line;
			while ((line = in.readLine()) != null) {
				logger.info(line);

			}
			return connection.getResponseCode() == 200;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
