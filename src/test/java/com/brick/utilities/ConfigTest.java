package com.brick.utilities;

import com.brick.utilities.exception.ConfigException;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ConfigTest {

    @Test
    public void test_success() throws ConfigException {
        String clearFlag = "logger" + Config.SEPERATOR + "clear";
        String allLog = "logger" + Config.SEPERATOR + "all" +Config.SEPERATOR + "file";
        String invalidKey = "invalid";
        List<String> outputList = new ArrayList<>();
        outputList.add("file1.log");
        outputList.add("file2.log");

        assertTrue(Config.getConfigBoolean(clearFlag));
        assertEquals(outputList,Config.getConfigObject(allLog));
        assertThrows(ConfigException.class, ()->{
        	Config.getConfigBoolean(invalidKey);
        });
        
        
        String intKey = "xyz.abc";
        assertEquals(123, Config.getConfigInteger(intKey));
        assertEquals(123, Config.getConfigIntegerOrDefault(intKey, 345));
        assertEquals(345, Config.getConfigIntegerOrDefault(invalidKey, 345));
    }

    @Test
    public void test_exception(){
        String allLog = "logger" + Config.SEPERATOR + "all" +Config.SEPERATOR + "file";
        assertThrows(ConfigException.class,()->{
            Config.getConfigBoolean(allLog);
        });
        
        assertThrows(ConfigException.class,()->{
        	Config.getConfigInteger(allLog);
        });
    }
}
