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

public class HelloEktorp2 {

	public static void main(String[] args) throws MalformedURLException {
		HttpClient httpClient = new StdHttpClient.Builder()
                .url("http://localhost:5984")
                .username("admin")
                .password("12345")
                .build();
		
		CouchDbInstance dbInstance = new StdCouchDbInstance(httpClient);
		// if the second parameter is true, the database will be created if it doesn't exists
		CouchDbConnector db = dbInstance.createConnector("my_first_database", true);
		
		Map<String, List<String>> majorCitiesByCountry = new HashMap<String, List<String>>();
		
		String[] a = new String[]{"12","2","3"};
		Arrays.asList(new String[]{"12","2","3"});
		
		List<String> countries = new ArrayList<String>();
	    Map<String, Object> referenceData = new HashMap<String, Object>();
	    referenceData.put("_id", "referenceData2");
	    referenceData.put("countries", countries);
	    referenceData.put("majorCitiesByCountry", majorCitiesByCountry);
	    
	    db.create(referenceData);

	    Map<String, Object> referenceData_2 = db.get(Map.class, "referenceData");
		
		System.out.println("finish");
	}

}
