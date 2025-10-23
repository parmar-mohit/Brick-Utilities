package com.brick.utilities;

import com.brick.utilities.exception.ConfigException;
import org.junit.jupiter.api.Test;

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
        assertNull(Config.getConfigObject(invalidKey));
    }

    @Test
    public void test_exception(){
        String allLog = "logger" + Config.SEPERATOR + "all" +Config.SEPERATOR + "file";
        assertThrows(ConfigException.class,()->{
            Config.getConfigBoolean(allLog);
        });
    }
}
