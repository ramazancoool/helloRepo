package com.example.couchdb.map;

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

public class UpdateDbExample {

	public static void main(String[] args) throws MalformedURLException {
		HttpClient httpClient = new StdHttpClient.Builder()
				.url(ICouchDbConstants.HOST_ADDRESS_OF_DB)
				.username(ICouchDbConstants.USERNAME_OF_DB)
				.password(ICouchDbConstants.PASSWORD_OF_DB)
				.build();

		CouchDbInstance dbInstance = new StdCouchDbInstance(httpClient);
		// if the second parameter is true, the database will be created if it
		// doesn't exists
		CouchDbConnector dbConnector = dbInstance.createConnector(
				ICouchDbConstants.DATABASE_NAME_MY_FIRST_DB, true);

		Map resultMap = dbConnector.find(Map.class, ICouchDbConstants.ID_2);

		if (resultMap != null) {
			dbConnector.delete(resultMap);
		}

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("_id", "2");
		map.put("name", "Ektorp");
		map.put("version", 2.41);

		dbConnector.create(map);

		DisplayHelper.showDocument(map);

		Map<String, Object> map2 = dbConnector.find(Map.class,
				ICouchDbConstants.ID_2);

		map2.put("name", "Ektorp Updated");
		System.out.println("name = Ektorp Updated");

		dbConnector.update(map2);

		map2 = dbConnector.find(Map.class, "2");

		DisplayHelper.showDocument(map2);

	}

}
