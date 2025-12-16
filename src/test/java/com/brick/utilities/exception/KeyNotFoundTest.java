package com.brick.utilities.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class KeyNotFoundTest {
	@Test
	public void message_test() {
		String keyNotFound = "xyz";
		KeyNotFound keyNotFoundException = new KeyNotFound(keyNotFound);
		String expectedMessage = "Cannot Find Key : " + keyNotFound;
		assertEquals(expectedMessage, keyNotFoundException.getMessage());
		assertEquals(keyNotFound, keyNotFoundException.getKeyNotFound());
	}
}
