package com.asa.CRP.commons;

import java.io.IOException;
import java.util.Properties;

/**
 * loader class for the properties files.
 * 
 * @author Shivani
 *
 */

public final class PropertiesFileLoader {

	/**
	 * 
	 */
	private static Properties webServiceProperties = new Properties();
	
	/**
	 * 
	 */
	private static Properties miscProperties = new Properties();


	/**
	 * 
	 */
	private static PropertiesFileLoader loader;

    /**
     * Private constructor 
     *
     */
	private PropertiesFileLoader() {
		try {
			webServiceProperties
					.load(PropertiesFileLoader.class.getClassLoader().getResourceAsStream("database.properties"));
			miscProperties.load(PropertiesFileLoader.class.getClassLoader().getResourceAsStream("Misc.properties"));
		} catch (IOException e) {
			//logger.error("Error loading webservices service properties file");
		}
	}

    /**
     * Method to get singlton instance of PropertiesFileLoader Class 
     *
     * @return PropertiesFileLoader
     */
	public static PropertiesFileLoader getInstance() {
		if (loader == null) {
			return new PropertiesFileLoader();
		}
		return loader;
	}

    /**
     * Method to get the instance of the properties file 
     *
     * @return Properties
     */
	
	public Properties getDatabaseProperties() {
		return webServiceProperties;
	}
	
	public Properties getMiscProperties() {
		return miscProperties;
	}

}
