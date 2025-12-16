package com.brick.utilities.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ConfigExceptionTest {
	@Test
	public void message_test() {
		String message = "ExceptionMessage";
		ConfigException configException = new ConfigException(message);
		assertEquals(message, configException.getMessage());
	}
}
