package com.brick.utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

public class BrickRequestBody {
	private JsonNode requestBody;
	private Map<String,String> pathVariables;
	private Map<String,String> headers;
	private List<Cookie> cookies;
	private Map<String,String[]> queryParams;
	
	public BrickRequestBody(JsonNode requestBody, Map<String, String> pathVariables, Map<String, String> headers,List<Cookie> cookies, Map<String, String[]> queryParams) {
		super();
		this.requestBody = requestBody;
		this.pathVariables = pathVariables;
		this.headers = headers;
		this.cookies = cookies;
		this.queryParams = queryParams;
	}
	
	/*
	 * Description: Returns RequestBody in Json Format
	 */
	public static JsonNode getRequestBody(HttpServletRequest req) throws IOException {
		StringBuilder body = new StringBuilder();
		String line;
		try (BufferedReader reader = req.getReader()) {
		    while ((line = reader.readLine()) != null) {
		        body.append(line);
		    }
		}
		String requestBody = body.toString();
		
		return new ObjectMapper().readTree(requestBody);
	}

	public JsonNode getRequestBody() {
		return requestBody;
	}

	public Map<String, String> getPathVariables() {
		return pathVariables;
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	public List<Cookie> getCookies() {
		return cookies;
	}

	public Map<String, String[]> getQueryParams() {
		return queryParams;
	}
}
