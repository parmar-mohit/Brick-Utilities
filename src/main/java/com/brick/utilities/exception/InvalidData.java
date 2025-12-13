package com.brick.utilities.exception;

public class InvalidData extends Exception {
    public InvalidData(String data) {
        super( "Invalid Data : " + data );
    }
}
