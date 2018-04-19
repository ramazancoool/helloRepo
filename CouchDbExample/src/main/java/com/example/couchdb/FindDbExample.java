package com.example.couchdb;

import java.net.MalformedURLException;
import java.util.Map;

import org.ektorp.CouchDbConnector;
import org.ektorp.CouchDbInstance;
import org.ektorp.http.HttpClient;
import org.ektorp.http.StdHttpClient;
import org.ektorp.impl.StdCouchDbInstance;

import com.example.couchdb.constant.ICouchDbConstants;
import com.example.couchdb.utility.DisplayHelper;

public class FindDbExample {

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

		Map<String, Object> map = dbConnector.find(Map.class,
				ICouchDbConstants.ID_REFERENCE_DATA);

		DisplayHelper.showDocument(map);
	}

}
