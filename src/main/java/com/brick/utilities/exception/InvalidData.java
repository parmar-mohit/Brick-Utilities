package com.brick.utilities.exception;

public class InvalidData extends Exception {
    public static final String INVALID_YAML_FILE = "File does not contain Valid Data : ";

    public InvalidData(String fileName) {
        super( INVALID_YAML_FILE + fileName );
    }
}
