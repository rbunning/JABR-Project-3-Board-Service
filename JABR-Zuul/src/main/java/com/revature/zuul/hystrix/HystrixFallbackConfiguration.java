package com.revature.zuul.hystrix;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;

@Configuration
public class HystrixFallbackConfiguration {
	
	@Bean
	public ZuulFallbackProvider zuulFallbackProvider() {
		return new ZuulFallbackProvider() {
			
			@Override
			public String getRoute( ) {
				//set so that if any service is unavailable, it will have 503 status
				return "*";
			}
			
			@Override
			public ClientHttpResponse fallbackResponse() {
				return new ClientHttpResponse() {
					@Override
					public HttpStatus getStatusCode() throws IOException {
						return HttpStatus.SERVICE_UNAVAILABLE;
					}
					
					@Override
					public int getRawStatusCode() throws IOException {
						return HttpStatus.SERVICE_UNAVAILABLE.value();
					}
					
					@Override 
					public String getStatusText() throws IOException {
						return HttpStatus.SERVICE_UNAVAILABLE.toString();
					}
					
					@Override
					public void close() {}
					
					@Override
					public InputStream getBody() throws IOException {
						return new ByteArrayInputStream("Apologies, but this service is temporarily unavailable.".getBytes());
					}
					
					@Override
					public HttpHeaders getHeaders() {
						HttpHeaders headers = new HttpHeaders();
						headers.setContentType(MediaType.APPLICATION_JSON);
						return headers;
					}
				};
			}
		};
	}
}
