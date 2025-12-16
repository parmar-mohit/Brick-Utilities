package com.brick.utilities.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class InvalidDataTest {
	@Test
	public void message_test() {
		String invalidData = "xyz";
		InvalidData invalidDataException = new InvalidData(invalidData);
		String expectedMessage = "Invalid Data : " + invalidData;
		assertEquals(expectedMessage, invalidDataException.getMessage());
	}
}
