package com.example.couchdb.connect;

import java.net.MalformedURLException;

import org.ektorp.CouchDbConnector;
import org.ektorp.CouchDbInstance;
import org.ektorp.http.HttpClient;
import org.ektorp.http.StdHttpClient;
import org.ektorp.impl.StdCouchDbInstance;

import com.example.couchdb.constant.ICouchDbConstants;

public class ConnectWithUserName {

	public static void main(String[] args) throws MalformedURLException {
		HttpClient httpClient = new StdHttpClient.Builder()
				.url(ICouchDbConstants.HOST_ADDRESS_OF_DB)
				.username(ICouchDbConstants.USERNAME_OF_DB)
				.password(ICouchDbConstants.PASSWORD_OF_DB)
				.build();

		CouchDbInstance dbInstance = new StdCouchDbInstance(httpClient);
		// if the second parameter is true, the database will be created if it
		// doesn't exists
		CouchDbConnector db = dbInstance.createConnector(ICouchDbConstants.DATABASE_NAME_CUST,
				true);

		System.out.println("Database connector initialized");
	}

}