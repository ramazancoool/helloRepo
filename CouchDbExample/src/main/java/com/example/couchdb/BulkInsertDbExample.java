package com.example.couchdb;

import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ektorp.CouchDbConnector;
import org.ektorp.CouchDbInstance;
import org.ektorp.http.HttpClient;
import org.ektorp.http.StdHttpClient;
import org.ektorp.impl.StdCouchDbInstance;

import com.example.couchdb.constant.ICouchDbConstants;
import com.example.couchdb.utility.DisplayHelper;

public class BulkInsertDbExample {

	public static void main(String[] args) throws MalformedURLException {
		HttpClient httpClient = new StdHttpClient.Builder()
                .url(ICouchDbConstants.HOST_ADDRESS_OF_DB)
                .username(ICouchDbConstants.USERNAME_OF_DB)
                .password(ICouchDbConstants.PASSWORD_OF_DB)
                .build();
		
		CouchDbInstance dbInstance = new StdCouchDbInstance(httpClient);
		// if the second parameter is true, the database will be created if it doesn't exists
		CouchDbConnector dbConnector = dbInstance.createConnector(ICouchDbConstants.DATABASE_NAME_MY_FIRST_DB, true);
		
		//Delete already exist
		Map resultMap;
		resultMap = dbConnector.find(Map.class, ICouchDbConstants.ID_1);
		
		if(resultMap != null){
			dbConnector.delete(resultMap);
		}

		resultMap = dbConnector.find(Map.class, ICouchDbConstants.ID_2);
		
		if(resultMap != null){
			dbConnector.delete(resultMap);
		}
		//delete end
		
		//fill the map
		Map<String, Object> map1 = new HashMap<String, Object>();
		Map<String, Object> map2 = new HashMap<String, Object>();
		
		map1.put("_id", ICouchDbConstants.ID_1);
		map1.put("name", "ektorp");
		map1.put("version", 2.41);

		map2.put("_id", ICouchDbConstants.ID_2);
		map2.put("name", "ektorp2");
		map2.put("version", 2.41);
	    
		List<Map<String, Object>> list = Arrays.asList(map1, map2);
		
		//Insert bulk command
		//Bulk update is same.
		dbConnector.executeBulk(list);
		System.out.println("Bulk insert done");
		
		resultMap = dbConnector.find(Map.class, ICouchDbConstants.ID_1);
		DisplayHelper.showDocument(map2);

		resultMap = dbConnector.find(Map.class, ICouchDbConstants.ID_2);
		DisplayHelper.showDocument(map2);
		
	}
	

}
