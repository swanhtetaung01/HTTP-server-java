package org.swan.httpserver.config;

import com.fasterxml.jackson.databind.JsonNode;
import org.swan.httpserver.util.Json;

import java.io.FileReader;
import java.io.IOException;

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
    public void loadConfigurationFile(String filePath) throws IOException {
        FileReader fileReader = new FileReader(filePath);
        StringBuffer stringBuffer = new StringBuffer();
        int i;
        while ((i = fileReader.read()) != -1) {
            stringBuffer.append((char)i);
        }
        JsonNode conf = Json.parse(stringBuffer.toString());
        myCurrentConfiguration = Json.fromJson(conf, Configuration.class);
    }

    /*
    Returns the current loaded configuration
     */
    public void getCurrentConfiguration() {

    }

}
