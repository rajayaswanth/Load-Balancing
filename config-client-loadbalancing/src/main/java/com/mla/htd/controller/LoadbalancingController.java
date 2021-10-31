package com.mla.htd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class LoadbalancingController {

	@Qualifier("customRestTemplate")
	@Autowired
	private RestTemplate customRestTemplate;

	@RequestMapping(method = RequestMethod.GET, value = "/reservations/names")
	public ResponseEntity<String> names() {
		ResponseEntity<String> responseEntity = customRestTemplate.exchange("http://localhost:8080/message", HttpMethod.GET, null, String.class);
		return responseEntity;
	}

}
