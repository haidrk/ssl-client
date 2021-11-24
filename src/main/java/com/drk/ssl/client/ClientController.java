package com.drk.ssl.client;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/client")
public class ClientController {
	
	@Autowired
	RestTemplate restTemplate;
	
    @RequestMapping(value = "/ssl", method = RequestMethod.GET)
    public String ssl() {
    	try {
    		//System.setProperty("watt.security.ssl.client.ignoreEmptyAuthoritiesList", "true");
    		HttpsURLConnection.setDefaultHostnameVerifier((hostname, session) -> true);
    		//RestTemplate restTemplate = new RestTemplate();
            System.out.println("Entering client ssl test method");
            //return "client hello";
            return restTemplate.getForObject("https://localhost:9001/server/ssl", String.class);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return "failed";
    }
}