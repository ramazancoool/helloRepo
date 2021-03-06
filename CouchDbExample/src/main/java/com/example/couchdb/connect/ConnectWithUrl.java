package com.example.couchdb.connect;

import java.net.MalformedURLException;

import org.ektorp.CouchDbConnector;
import org.ektorp.CouchDbInstance;
import org.ektorp.http.HttpClient;
import org.ektorp.http.StdHttpClient;
import org.ektorp.impl.StdCouchDbConnector;
import org.ektorp.impl.StdCouchDbInstance;
import org.ektorp.support.DesignDocument;

import com.example.couchdb.constant.ICouchDbConstants;

/**
 * Hello world!
 *
 */
public class ConnectWithUrl {
	public static void main(String[] args) throws MalformedURLException {
		
		HttpClient httpClient = new StdHttpClient.Builder().url(ICouchDbConstants.HOST_ADDRESS_OF_DB).build();
		CouchDbInstance dbInstance = new StdCouchDbInstance(httpClient);
		// --------------- Creating database----------------------------//
		CouchDbConnector db = new StdCouchDbConnector(ICouchDbConstants.DATABASE_NAME_CUST, dbInstance);
		db.createDatabaseIfNotExists();
		// --------------- Creating Document----------------------------//
		DesignDocument dd = new DesignDocument("light");
		db.create(dd);
	}
}