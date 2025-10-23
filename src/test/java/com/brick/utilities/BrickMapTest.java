package com.brick.utilities;

import com.brick.utilities.exception.KeyNotFound;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class BrickMapTest {

    @Test
    public void brickMapTest() throws KeyNotFound {
        String invalidKey = "";

        Map<String,Object> map = new HashMap<>();

        Map<String,Object> subMap = new HashMap<>();
        subMap.put("abc","abc");
        subMap.put("def","def");

        map.put("subMap",subMap);
        map.put("string","string");
        map.put("integer",2);
        map.put("double",3.0);

        List<Map<String,Object>> listOfMap = new ArrayList<>();
        listOfMap.add(new HashMap<>());
        listOfMap.add(new HashMap<>());

        map.put("listOfMap",listOfMap);

        List<String> listOfString = new ArrayList<>();
        listOfString.add("a");
        listOfString.add("b");

        map.put("listOfString",listOfString);

        List<Integer> listOfInteger = new ArrayList<>();
        listOfInteger.add(1);
        listOfInteger.add(2);

        map.put("listOfInteger", listOfInteger);

        List<Double> listOfDouble = new ArrayList<>();
        listOfDouble.add(1.0);
        listOfDouble.add(2.0);

        map.put("listOfDouble",listOfDouble);

        map.put("boolean", true);

        BrickMap brickMap = new BrickMap(map);

        assertEquals(new BrickMap(subMap), brickMap.getBrickMap("subMap"));
        assertThrows(KeyNotFound.class,()->{
            brickMap.getBrickMap(invalidKey);
        });

        assertEquals(new BrickMap(subMap), brickMap.getOptionalBrickMap("subMap").get());
        assertFalse(brickMap.getOptionalBrickMap(invalidKey).isPresent());

        assertEquals("string",brickMap.getString("string"));
        assertThrows(KeyNotFound.class,()->{
            brickMap.getString(invalidKey);
        });

        assertEquals("string",brickMap.getOptionalString("string").get());
        assertFalse(brickMap.getOptionalString(invalidKey).isPresent());

        assertEquals(2,brickMap.getOptionalInteger("integer").get());
        assertFalse(brickMap.getOptionalInteger(invalidKey).isPresent());

        assertEquals(3.0,brickMap.getOptionalDouble("double").get());
        assertFalse(brickMap.getOptionalDouble(invalidKey).isPresent());

        assertEquals(listOfMap, brickMap.getListOfMap("listOfMap"));
        assertThrows(KeyNotFound.class,()->{
            brickMap.getListOfMap(invalidKey);
        });

        assertEquals(listOfMap,brickMap.getOptionalListOfMap("listOfMap").get());
        assertFalse(brickMap.getOptionalListOfMap(invalidKey).isPresent());

        assertEquals(listOfString,brickMap.getOptionalListOfString("listOfString").get());
        assertFalse(brickMap.getOptionalListOfString(invalidKey).isPresent());

        assertEquals(listOfInteger,brickMap.getOptionalListOfInteger("listOfInteger").get());
        assertFalse(brickMap.getOptionalListOfInteger(invalidKey).isPresent());

        assertEquals(listOfDouble,brickMap.getOptionalListOfDouble("listOfDouble").get());
        assertFalse(brickMap.getOptionalListOfDouble(invalidKey).isPresent());

        assertTrue(brickMap.getBoolean("boolean"));
        assertThrows(KeyNotFound.class,()->{
            brickMap.getBoolean(invalidKey);
        });

        assertTrue(brickMap.getOptionalBoolean("boolean").get());
        assertFalse(brickMap.getOptionalBoolean(invalidKey).isPresent());

        assertEquals(subMap,brickMap.getObject("subMap"));
        assertThrows(KeyNotFound.class,()->{
            brickMap.getObject(invalidKey);
        });

        assertFalse(brickMap.isEmpty());
    }
}
