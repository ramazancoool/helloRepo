package com.example.couchdb;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import org.ektorp.CouchDbConnector;
import org.ektorp.CouchDbInstance;
import org.ektorp.http.HttpClient;
import org.ektorp.http.StdHttpClient;
import org.ektorp.impl.StdCouchDbInstance;

import com.example.couchdb.constant.ICouchDbConstants;
import com.example.couchdb.utility.DisplayHelper;

public class InsertDbExample {

	public static void main(String[] args) throws MalformedURLException {
		HttpClient httpClient = new StdHttpClient.Builder()
                .url("http://localhost:5984")
                .username("admin")
                .password("12345")
                .build();
		
		CouchDbInstance dbInstance = new StdCouchDbInstance(httpClient);
		// if the second parameter is true, the database will be created if it doesn't exists
		CouchDbConnector dbConnector = dbInstance.createConnector(ICouchDbConstants.DATABASE_NAME_MY_FIRST_DB, true);
		
		//Delete already exist
		Map resultMap = dbConnector.find(Map.class, ICouchDbConstants.ID_1);
		
		if(resultMap != null){
			dbConnector.delete(resultMap);
		}
		//delete end
		
		//fill the map
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("_id", ICouchDbConstants.ID_1);
		map.put("name", "ektorp");
		map.put("version", 2.41);
	    
		//Insert command
		dbConnector.create(map);

		
		Map<String, Object> map2 = dbConnector.find(Map.class, ICouchDbConstants.ID_1);
		
		DisplayHelper.showDocument(map2);
		
	}
	

}
