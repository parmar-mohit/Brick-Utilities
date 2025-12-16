package com.brick.utilities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.node.ObjectNode;

public class BrickRequestDataTest {
	
	@Test
	public void getRequestBody_staticMethod() throws IOException {
		HttpServletRequest request = mock(HttpServletRequest.class);
		BufferedReader requestReader = mock(BufferedReader.class);
		when( request.getReader() ).thenReturn(requestReader );
		String requestBody = "{\"value\" : \"123\"}";
		when( requestReader.readLine() ).thenReturn(requestBody).thenReturn(null);
		
		ObjectNode expectedNode = new ObjectMapper().createObjectNode();
		expectedNode.put("value","123");
		
		assertEquals(expectedNode, BrickRequestData.getRequestBody(request));
	}
	
	@Test
	public void getterTestCases() {
		JsonNode requestBody = new ObjectMapper().createObjectNode();
		Map<String,String> pathVariables = new HashMap<String,String>();
		Map<String,String> headers = new HashMap<String,String>();
		List<Cookie> cookieList = new ArrayList<Cookie>();
		Map<String,String[]> queryParams = new HashMap<String, String[]>();
		
		BrickRequestData brickRequestData = new BrickRequestData(requestBody, pathVariables, headers, cookieList, queryParams);
		
		assertEquals(requestBody, brickRequestData.getRequestBody());
		assertEquals(headers, brickRequestData.getHeaders());
		assertEquals(pathVariables, brickRequestData.getPathVariables());
		assertEquals(cookieList, brickRequestData.getCookies());
		assertEquals(queryParams, brickRequestData.getQueryParams());
	}

}
