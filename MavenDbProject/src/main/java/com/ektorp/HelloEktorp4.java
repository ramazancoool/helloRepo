package com.ektorp;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import org.ektorp.CouchDbConnector;
import org.ektorp.CouchDbInstance;
import org.ektorp.http.HttpClient;
import org.ektorp.http.StdHttpClient;
import org.ektorp.impl.StdCouchDbInstance;

public class HelloEktorp4 {

	public static void main(String[] args) throws MalformedURLException {
		HttpClient httpClient = new StdHttpClient.Builder()
                .url("http://localhost:5984")
                .username("admin")
                .password("12345")
                .build();
		
		CouchDbInstance dbInstance = new StdCouchDbInstance(httpClient);
		// if the second parameter is true, the database will be created if it doesn't exists
		CouchDbConnector db = dbInstance.createConnector("my_first_database", true);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("_id", "1");
		map.put("name", "MIHU");
		map.put("version", 2.41);
	    
		db.create(map);

		
		Map<String, Object> map2 = db.find(Map.class, "1");
		
		System.out.println("db name: " + map2.get("name"));
		
		
		System.out.println("finish");
	}

}
