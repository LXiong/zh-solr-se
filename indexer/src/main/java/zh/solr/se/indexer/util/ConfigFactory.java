package zh.solr.se.indexer.util;

import java.util.HashMap;

public class ConfigFactory {
	public static final String SOLR_CONFIG_PATH = "/solr.properties";
	public static final String DB_CONFIG_PATH = "/db.properties";
	public static final String INDEXER_CONFIG_PATH = "/indexer.properties";
	
	private static ConfigFactory instance = new ConfigFactory();
	private HashMap<String, ConfigProperties> configMap = new HashMap<String, ConfigProperties>();
	
	public static ConfigFactory getInstance() {
		return instance;
	}
	
	private ConfigFactory() {
		
	}
	
	/**
	 * This is the factory method for producing config properties object
	 * each path has a single instance of config properties
	 * @param filePath the class path to the config file
	 * @return
	 */
	synchronized public ConfigProperties getConfigProperties(String filePath) {
		ConfigProperties config = configMap.get(filePath);
		if (config == null) {
			config = new ConfigProperties(filePath);
			configMap.put(filePath, config);
		}
		
		return config;
	}
}
