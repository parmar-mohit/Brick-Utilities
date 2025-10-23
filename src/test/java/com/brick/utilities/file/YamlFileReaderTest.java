package com.brick.utilities.file;

import com.brick.utilities.BrickMap;
import com.brick.utilities.exception.InvalidData;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class YamlFileReaderTest {

    @Test
    public void test_invalidFileName(){
        String fileName= "invalid.yaml";
        FileReader fileReader = new YamlFileReader(fileName);
        assertThrows(FileNotFoundException.class,()->{
            fileReader.getMap();
        });
    }

    @Test
    public void test_invalidYaml(){
        String fileName = "yaml/invalid_data.yaml";
        FileReader fileReader = new YamlFileReader(fileName);
        assertThrows(InvalidData.class,()->{
            fileReader.getMap();
        });
    }


    @Test
    public void test_success() throws InvalidData, FileNotFoundException {
        String fileName = "yaml/success.yaml";
        FileReader fileReader = new YamlFileReader(fileName);

        Map<String,Object> expectedMap = new HashMap<>();
        Map<String,Object> subMap = new HashMap<>();
        subMap.put("xyz",123);
        expectedMap.put("abc",subMap);
        expectedMap.put("def","hello");
        BrickMap expectedBrickMap = new BrickMap(expectedMap);

        assertEquals(expectedBrickMap, fileReader.getMap());
    }
}
