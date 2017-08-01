package com.ektorp;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ektorp.CouchDbConnector;
import org.ektorp.CouchDbInstance;
import org.ektorp.http.HttpClient;
import org.ektorp.http.StdHttpClient;
import org.ektorp.impl.StdCouchDbInstance;

public class HelloEktorp3 {

	public static void main(String[] args) throws MalformedURLException {
		HttpClient httpClient = new StdHttpClient.Builder()
                .url("http://localhost:5984")
                .username("admin")
                .password("12345")
                .build();
		
		CouchDbInstance dbInstance = new StdCouchDbInstance(httpClient);
		// if the second parameter is true, the database will be created if it doesn't exists
		CouchDbConnector db = dbInstance.createConnector("my_first_database", true);
		
	    
	    Map<String, Object> map = db.find(Map.class, "referenceData");

	    System.out.println(map.get("name"));
		
		System.out.println("finish");
	}

}
