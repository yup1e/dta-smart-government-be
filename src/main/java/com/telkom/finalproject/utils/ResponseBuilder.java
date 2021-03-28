package com.telkom.finalproject.utils;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.telkom.finalproject.responses.Response;

public class ResponseBuilder {

	public static void setResponse(HttpServletResponse response, int code, String message, String data) {
		try {
			Response<String> newResponse = new Response<>();
			newResponse.setCode(code);
			newResponse.setMessage(message);
			newResponse.setData(data);
			
			ObjectMapper objectMapper = new ObjectMapper();
			String finalResponse = objectMapper.writeValueAsString(newResponse);
			
			response.setStatus(code);
			response.setContentType("application/json");
			response.getWriter().write(finalResponse);
			response.getWriter().flush();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}