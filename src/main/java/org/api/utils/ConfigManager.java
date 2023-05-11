package org.api.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {

    private static ConfigManager configManager;
    private static final Properties prop = new Properties();

    //Constructor
    private ConfigManager() throws IOException {

        InputStream inputStream = ConfigManager.class.getResourceAsStream("/config.properties");
        prop.load(inputStream);
    }
    public static ConfigManager getInstance(){
        if(configManager == null){

            synchronized (ConfigManager.class){
                try {
                    configManager = new ConfigManager();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return configManager;
    }

    public String getString(String key){

        return System.getProperty(key, prop.getProperty(key));
    }
}
