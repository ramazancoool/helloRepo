package com.example.couchdb.map;

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

import com.example.couchdb.constant.ICouchDbConstants;
import com.example.couchdb.utility.DisplayHelper;

public class InsertDbExample2 {

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

		Map resultMap = dbConnector.find(Map.class,
				ICouchDbConstants.ID_REFERENCE_DATA2);

		if (resultMap != null) {
			dbConnector.delete(resultMap);
		}

		Map<String, List<String>> majorCitiesByCountry = new HashMap<String, List<String>>();

		String[] a = new String[] { "12", "2", "3" };
		Arrays.asList(new String[] { "12", "2", "3" });

		List<String> countries = new ArrayList<String>();
		Map<String, Object> referenceData = new HashMap<String, Object>();
		referenceData.put("_id", ICouchDbConstants.ID_REFERENCE_DATA2);
		referenceData.put("countries", countries);
		referenceData.put("majorCitiesByCountry", majorCitiesByCountry);

		dbConnector.create(referenceData);

		Map<String, Object> map = dbConnector.get(Map.class,
				ICouchDbConstants.ID_REFERENCE_DATA2);

		DisplayHelper.showDocument(map);

	}

}
