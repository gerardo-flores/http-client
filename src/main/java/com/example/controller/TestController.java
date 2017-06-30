package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.client.RestClient;

@RestController
public class TestController {

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public Object testGet(@RequestParam(required = false) String uri) {
		RestClient client = new RestClient();
		String requestUri = (uri == null || uri.isEmpty()) ? "https://www.google.com" : uri;
		Object output = client.get(requestUri);
		System.out.println("CLIENT_STATUS_CODE:  " + client.getStatus());
		System.out.println("CLIENT_OUTPUT:  " + output);
		return output;
	}
}
