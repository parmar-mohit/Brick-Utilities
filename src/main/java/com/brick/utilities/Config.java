package com.brick.utilities;

import com.brick.utilities.exception.ConfigException;
import com.brick.utilities.exception.KeyNotFound;
import com.brick.utilities.file.FileReader;
import com.brick.utilities.file.YamlFileReader;

/*
    Description: Helps Read and get Config Details from Config file
 */
public class Config {
    public static final String SEPERATOR = ".";
    private static final String SEPERATOR_REGEX = "\\.";
    private static final String CONFIG_FILE = "application.yaml";


    /*
        Singleton Pattern to Ensure Config File is read only once
     */
    static {
        instance = new Config();
    }
    private static final Config instance;

    private BrickMap configMap;
    private Config()  {
        FileReader fileReader = new YamlFileReader(CONFIG_FILE);
        try {
            configMap = fileReader.getMap();
        } catch (Exception e) {
            e.printStackTrace();
            configMap = null;
        }
    }

    /*
        Description: Returns Data from Config File based on key
     */
    public static Object getConfigObject(String key) throws ConfigException {
        if( instance == null ){
            return null;
        }

        String[] nestedKeys = key.split(SEPERATOR_REGEX);
        try {
            BrickMap currentMap = instance.configMap;
            for (int i = 0; i < nestedKeys.length; i++) {
                if( currentMap.contains(nestedKeys[i]) ){

                    if( i == nestedKeys.length - 1){
                        return currentMap.getObject(nestedKeys[i]);
                    }

                    currentMap = currentMap.getBrickMap(nestedKeys[i]);
                }else{
                    return null;
                }
            }
        }catch(KeyNotFound e){
            throw new ConfigException(e.getMessage());
        }

        return null; // Returns null if key is not found or some exception or unexpected event occurs
    }

    /*
        Description: Returns Boolean Data from Config File
     */
    public static Boolean getConfigBoolean(String key) throws ConfigException {
        try{
            return (Boolean)getConfigObject(key);
        }catch(ClassCastException e){
            throw new ConfigException(e.getMessage());
        }
    }
}

