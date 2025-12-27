package org.swan.httpserver.config;

public class ConfigurationManager {
    private static ConfigurationManager myconfigurationManager;
    private static Configuration myCurrentConfiguration;
    
    private ConfigurationManager() {
    }
    public static ConfigurationManager getInstance() {
        if (myconfigurationManager == null)
            myconfigurationManager = new ConfigurationManager();
        return myconfigurationManager;
    }

    /*
    User to load a configuration file by the path provided
     */
    public void loadConfigurationFile(String filePath) {

    }

    /*
    Returns the current loaded configuration
     */
    public void getCurrentConfiguration() {

    }

}
