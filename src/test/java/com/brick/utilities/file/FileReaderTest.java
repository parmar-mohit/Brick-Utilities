package com.brick.utilities.file;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FileReaderTest {
	@Test
	public void fileExtensionTest() {
		String fileName1 = "abc.xyz";
		String fileName2 = "abc.xyz.def";
		String fileName3 = "qwerty";
		
		assertEquals("xyz", FileReader.getFileExtension(fileName1));
		assertEquals("def",FileReader.getFileExtension(fileName2));
		assertEquals("qwerty", FileReader.getFileExtension(fileName3));
	}
}
