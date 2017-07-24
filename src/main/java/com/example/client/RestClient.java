package com.example.client;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.util.Properties;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class RestClient {
	private RestTemplate rest;
	private HttpHeaders headers;
	private HttpStatus status;

	public RestClient() {		
		this.rest = new RestTemplate();
		this.headers = new HttpHeaders();
		this.readProxySettings();
		headers.add("Content-Type", "application/json");
		headers.add("Accept", "*/*");
		
	}

	public String get(String uri) {
		HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);
		ResponseEntity<String> responseEntity = rest.exchange(uri, HttpMethod.GET, requestEntity, String.class);
		this.setStatus(responseEntity.getStatusCode());
		return responseEntity.getBody();
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	
	public void readProxySettings(){
		Properties props = System.getProperties();
		String proxyServer = props.getProperty("http.proxyHost");
		String proxyPort = props.getProperty("http.proxyPort");
		System.out.println("The proxy server is set to: " + proxyServer + " " + proxyPort);
	}
	
	public SimpleClientHttpRequestFactory requestFactory(){
		SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();

	    Proxy proxy= new Proxy(Type.HTTP, new InetSocketAddress("c1184651648.saasprotection.com", 8080));
	    requestFactory.setProxy(proxy);
	    
	    return requestFactory;
	}
}