package com.brick.utilities.exception;

public class KeyNotFound extends Exception {
	
	private String keyNotFound;
	
    public KeyNotFound(String key) {
        super("Cannot Find Key : "+key);
        this.keyNotFound = key;
    }

	public String getKeyNotFound() {
		return keyNotFound;
	}
    
    
}
