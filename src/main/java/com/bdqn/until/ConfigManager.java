package com.bdqn.until;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {

    private static ConfigManager configManager=null;
    Properties properties=null;
    private ConfigManager(){
        String configFile="ConfigManager.properties";
        InputStream in =ConfigManager.class.getClassLoader().getResourceAsStream(configFile);

         properties=new Properties();
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static ConfigManager getConfigManager(){
       if(configManager==null){
           synchronized (ConfigManager.class){
           configManager=new ConfigManager();
           }
       }

        return configManager;
    }

    public String getpro(String key){
        return properties.getProperty(key);
    }

}
