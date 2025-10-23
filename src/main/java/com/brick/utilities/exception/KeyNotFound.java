package com.brick.utilities.exception;

public class KeyNotFound extends Exception {
    public KeyNotFound(String key) {
        super("Cannot Find Key : "+key);
    }
}
